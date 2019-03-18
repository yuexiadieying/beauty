package com.meixiang.beauty.modules.weixin.function;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.dto.account.IncomeRecordDTO;
import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import com.meixiang.beauty.common.dto.transaction.InstanceReturnMoneySignalDTO;
import com.meixiang.beauty.common.dto.transaction.MonthTransactionRecordDTO;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.modules.account.AccountService;
import com.meixiang.beauty.modules.account.IncomeRecordService;
import com.meixiang.beauty.modules.account.PayRecordService;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.modules.system.util.WeixinTemplateMessageUtil;
import com.meixiang.beauty.modules.transaction.api.TransactionService;
import com.meixiang.beauty.modules.transaction.dao.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * Created by chenjiake on 2017/9/11.
 */
@Service
public class WeixinPayFunction {

    @Autowired
    private PayRecordService payRecordService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private IncomeRecordService incomeRecordService;

    @Autowired
    private TransactionDao transactionDao;

    @Transactional(rollbackFor = Exception.class)
    public void processPayStatus(List<PayRecordDTO> payRecordDTOList,String productType) {
        try
        {
            float totalMoney = 0;
            String productName = "";
            String token = WeixinUtil.getToken();
            String url = ConfigConstant.BUSINESS_WEB_URL + "orderManagement/1";
            String userId = "";
            for(PayRecordDTO payRecordDTO:payRecordDTOList)
            {
                //修改payRecord的订单状态，表示已支付
                payRecordDTO.setStatus("1");
                payRecordDTO.setUpdateDate(new Date());
                payRecordService.updatePayRecordStatus(payRecordDTO);

                totalMoney = totalMoney + payRecordDTO.getAmount();

                //修改business_order的状态，表示已支付
                BusinessOrderDTO businessOrderDTO = transactionService.getBusinessOrderDetailInfoByOrderId(payRecordDTO.getOrderId());
                if(productType.equals("offline"))
                {
                    businessOrderDTO.setStatus("1");
                }
                else if(productType.equals("training"))
                {
                    businessOrderDTO.setStatus("2");
                }
                businessOrderDTO.setUpdateDate(new Date());
                transactionService.updateBusinessOrderStatus(businessOrderDTO);

                productName = productName + businessOrderDTO.getBusinessProductName() +
                        "(" + businessOrderDTO.getProductSpec() + ")" + (int)businessOrderDTO.getBusinessProductNum() +"套"+";";
                userId = businessOrderDTO.getSysUserId();
            }

            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setId(userId);
            userInfoDTO.setDelFlag("0");
            List<UserInfoDTO> userInfoDTOList = userService.getUserInfo(userInfoDTO);
            if(userInfoDTOList.size()>0)
            {
                userInfoDTO = userInfoDTOList.get(0);
            }
            WeixinTemplateMessageUtil.sendOrderPaySuccessTemplateWXMessage((int)totalMoney+"元",productName,token,url,userInfoDTO.getUserOpenid());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void promoteUserBusinessTypeForExpenseSecond(UserInfoDTO userInfoDTO, String businessType) {

        //sys_user表也需要更新
        userInfoDTO.setUserType(businessType);
        userService.updateUserInfo(userInfoDTO);

        //更新user_business_type表的数据
        //1、把老级别变为失效
        UserBusinessTypeDTO userBusinessTypeDTO = new UserBusinessTypeDTO();
        userBusinessTypeDTO.setSysUserId(userInfoDTO.getId());
        userBusinessTypeDTO.setStatus("1");
        List<UserBusinessTypeDTO> userBusinessTypeDTOS = userService.getUserBusinessType(userBusinessTypeDTO);
        if(userBusinessTypeDTOS.size()==0)
        {
            return;
        }
        userBusinessTypeDTO = userBusinessTypeDTOS.get(0);
        userBusinessTypeDTO.setStatus("0");
        userService.updateUserBusinessType(userBusinessTypeDTO);

        //2、级别更新创建新的记录
        userBusinessTypeDTO = new UserBusinessTypeDTO();
        userBusinessTypeDTO.setId(UUID.randomUUID().toString());
        userBusinessTypeDTO.setParentUserId(userInfoDTO.getParentUserId());
        userBusinessTypeDTO.setSysUserId(userInfoDTO.getId());
        userBusinessTypeDTO.setUserType(businessType);
        userBusinessTypeDTO.setCreateDate(new Date());
        userBusinessTypeDTO.setStatus("1");
        userService.insertUserBusinessType(userBusinessTypeDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateReturnMoneyDataBase(String parentUserId, String userRuleType, String parentRuleType, InstanceReturnMoneySignalDTO instanceReturnMoneySignalDTO) {
        String token = WeixinUtil.getToken();
        try{
            //计算提成给上一级用户ruleType对应店的钱
            PayRecordDTO payRecordDTO = new PayRecordDTO();
            payRecordDTO.setTransactionId(instanceReturnMoneySignalDTO.getTransactionId());
            payRecordDTO.setOutTradeNo(instanceReturnMoneySignalDTO.getOutTradeNo());
            payRecordDTO.setSysUserId(instanceReturnMoneySignalDTO.getSysUserId());
            payRecordDTO.setStatus("1");
            List<PayRecordDTO> payRecordDTOList = payRecordService.getUserPayRecordList(payRecordDTO);

            float expenseAmount = 0;
            for(PayRecordDTO payRecord : payRecordDTOList)
            {
                expenseAmount = expenseAmount + payRecord.getAmount();
            }

            float returnMoney = 0;
            //逻辑先写死
            if(userRuleType.equals(ConfigConstant.businessC1))
            {
                if(parentRuleType.equals(ConfigConstant.businessA1)){

                    if(expenseAmount>=ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE&&expenseAmount<=ConfigConstant.PROMOTE_B_LEVEL_MAX_EXPENSE)
                    {
                        returnMoney = ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE*10/100 + (expenseAmount-ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE)*2/100;

                        //记录月度交易流水
                        float amount = expenseAmount-ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE;
                        recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
                    }
                    else if(expenseAmount>=ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)
                    {
                        returnMoney = ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE*5/100 + (expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)*2/100;

                        //记录月度交易流水
                        float amount = expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE;
                        recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
                    }
                    else
                    {
                        returnMoney = expenseAmount * 2/100;

                        //记录月度交易流水
                        float amount = expenseAmount;
                        recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
                    }

                }
                else if(parentRuleType.equals(ConfigConstant.businessB1))
                {
                    if(expenseAmount>=ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE&&expenseAmount<=ConfigConstant.PROMOTE_B_LEVEL_MAX_EXPENSE)
                    {
                        returnMoney = ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE*10/100 + (expenseAmount-ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE)*10/100;

                        //记录月度交易流水
                        float amount = expenseAmount-ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE;
                        recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
                    }
                    else if(expenseAmount>=ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)
                    {
                        returnMoney = ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE*5/100 + (expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)*10/100;

                        //记录月度交易流水
                        float amount = expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE;
                        recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
                    }
                    else
                    {
                        returnMoney = expenseAmount * 10/100;

                        //记录月度交易流水
                        float amount = expenseAmount;
                        recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
                    }
                }
                else if(parentRuleType.equals("A1B1"))
                {
                    if(expenseAmount>=ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE&&expenseAmount<=ConfigConstant.PROMOTE_B_LEVEL_MAX_EXPENSE)
                    {
                        returnMoney = (expenseAmount-ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE)*2/100;

                        //记录月度交易流水
                        float amount = expenseAmount-ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE;
                        recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
                    }
                    else if(expenseAmount>=ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)
                    {
                        returnMoney = (expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)*2/100;

                        //记录月度交易流水
                        float amount = expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE;
                        recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
                    }
                    else
                    {
                        returnMoney = expenseAmount * 2/100;

                        //记录月度交易流水
                        float amount = expenseAmount;
                        recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
                    }
                }
            }
            else if(userRuleType.equals(ConfigConstant.businessB1))
            {
                if(parentRuleType.equals(ConfigConstant.businessA1)){
                    if(expenseAmount>=ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)
                    {
                        returnMoney = ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE*5/100 + (expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)*2/100;

                        //记录月度交易流水
                        float amount = expenseAmount-ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE;
                        recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
                    }
                    else
                    {
                        returnMoney = expenseAmount * 2/100;

                        //记录月度交易流水
                        float amount = expenseAmount;
                        recordMonthTransaction(parentUserId,instanceReturnMoneySignalDTO,amount);
                    }
                }
            }


            if(returnMoney>0)
            {
                //将returnMoney去更新要返现的用户ID的account和income两个表的数据
                AccountDTO accountDTO = accountService.getUserAccountInfo(parentUserId);
                if(accountDTO==null)
                {
                    //为用户创建一个账户
                    accountDTO = new AccountDTO();
                    accountDTO.setId(UUID.randomUUID().toString());
                    accountDTO.setSysUserId(parentUserId);

                    UserInfoDTO userInfoDTO = new UserInfoDTO();
                    userInfoDTO.setId(parentUserId);
                    List<UserInfoDTO> userInfoDTOList = userService.getUserInfo(userInfoDTO);
                    accountDTO.setUserOpenId(userInfoDTOList.get(0).getUserOpenid());

                    accountDTO.setBalance((float)0.00);
                    accountDTO.setScore((float)0.00);
                    accountDTO.setStatus("normal");
                    accountDTO.setUpdateDate(new Date());
                    accountDTO.setBalanceDeny((float)0.00);
                    accountService.createUserAccount(accountDTO);
                }
                float balance = accountDTO.getBalance() + returnMoney;
                float balanceDeny = accountDTO.getBalanceDeny() + returnMoney;
                accountDTO.setBalance(balance);
                accountDTO.setBalanceDeny(balanceDeny);
                accountDTO.setUpdateDate(new Date());
                accountService.updateUserAccountInfo(accountDTO);

                IncomeRecordDTO incomeRecordDTO = new IncomeRecordDTO();
                incomeRecordDTO.setId(UUID.randomUUID().toString());
                incomeRecordDTO.setSysUserId(parentUserId);
                incomeRecordDTO.setAmount(returnMoney);
                incomeRecordDTO.setCreateDate(new Date());
                incomeRecordDTO.setIncomeType("instance");
                incomeRecordDTO.setUpdateDate(new Date());
                incomeRecordDTO.setTransactionId(instanceReturnMoneySignalDTO.getTransactionId());
                incomeRecordDTO.setStatus("0");
                incomeRecordService.insertUserIncomeInfo(incomeRecordDTO);
                WeixinTemplateMessageUtil.sendLowLevelBusinessExpenseTemplateWXMessage(accountDTO.getNickName(),expenseAmount+"", DateUtils.DateToStr(new Date()),token,"",accountDTO.getUserOpenId());
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void recordMonthTransaction(String userId, InstanceReturnMoneySignalDTO instanceReturnMoneySignalDTO, float amount) {
        MonthTransactionRecordDTO monthTransactionRecordDTO = new MonthTransactionRecordDTO();
        monthTransactionRecordDTO.setId(UUID.randomUUID().toString());
        monthTransactionRecordDTO.setTransactionId(instanceReturnMoneySignalDTO.getTransactionId());
        monthTransactionRecordDTO.setAmount(amount);
        monthTransactionRecordDTO.setUserId(userId);
        monthTransactionRecordDTO.setCreateDate(new Date());
        monthTransactionRecordDTO.setUpdateDate(new Date());
        transactionDao.recordMonthTransaction(monthTransactionRecordDTO);
    }
}
