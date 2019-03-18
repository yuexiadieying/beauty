package com.meixiang.beauty.modules.transaction.function;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.account.IncomeRecordDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import com.meixiang.beauty.common.dto.transaction.MonthTransactionRecordDTO;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.common.utils.RedisLock;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.modules.account.AccountService;
import com.meixiang.beauty.modules.account.IncomeRecordService;
import com.meixiang.beauty.modules.account.PayRecordService;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.modules.system.util.WeixinTemplateMessageUtil;
import com.meixiang.beauty.modules.transaction.dao.TransactionDao;
import com.meixiang.beauty.sys.utils.CodeGenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * Created by zbm84 on 2017/5/10.
 */

@Service
public class TransactionRunTimeFunction {

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private IncomeRecordService incomeRecordService;

    @Autowired
    private PayRecordService payRecordService;

    @Autowired
    private UserService userService;

    public void frozenUserType(String userType) throws UnsupportedEncodingException {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserType(userType);
        userInfoDTO.setDelFlag("0");
        List<UserInfoDTO> userInfoDTOList = userService.getUserInfo(userInfoDTO);
        for(UserInfoDTO userInfo : userInfoDTOList)
        {
            UserBusinessTypeDTO userBusinessTypeDTO = new UserBusinessTypeDTO();
            userBusinessTypeDTO.setSysUserId(userInfo.getId());
            userBusinessTypeDTO.setStatus("1");
            List<UserBusinessTypeDTO> userBusinessTypeDTOS = userService.getUserBusinessType(userBusinessTypeDTO);

            if(userBusinessTypeDTOS.size()==0)
            {
                //为用户创建一个记录
                userBusinessTypeDTO = new UserBusinessTypeDTO();
                userBusinessTypeDTO.setId(UUID.randomUUID().toString());
                userBusinessTypeDTO.setSysUserId(userInfo.getId());
                userBusinessTypeDTO.setStatus("1");
                userBusinessTypeDTO.setParentUserId(userInfo.getParentUserId());
                userBusinessTypeDTO.setUserType(userInfo.getUserType());
                userBusinessTypeDTO.setCreateDate(new Date());
                userService.insertUserBusinessType(userBusinessTypeDTO);
            }
            else
            {
                userBusinessTypeDTO = userBusinessTypeDTOS.get(0);
            }

            Date dt1 = userBusinessTypeDTO.getCreateDate();
            Date dt2 = new Date((new Date()).getTime() - (long) ConfigConstant.USER_TYPE_PERIOD * 24 * 60 * 60 * 1000);
            Date dt3 = new Date((new Date()).getTime() - (long) (ConfigConstant.USER_TYPE_PERIOD-3) * 24 * 60 * 60 * 1000);

            //用户在365天前已经是目前的等级了
            if (dt2.getTime() > dt1.getTime())
            {
                userBusinessTypeDTO.setStatus("2");//2表示为冻结状态
                userService.updateUserBusinessType(userBusinessTypeDTO);
            }

            if(dt3.getTime()> dt1.getTime())
            {
                String name = URLDecoder.decode(userInfo.getNickname(),"utf-8");
                String expDate = DateUtils.DateToStr(dt2);
                String token = WeixinUtil.getToken();
                String openid = userInfo.getUserOpenid();
                String url = ConfigConstant.BUSINESS_WEB_URL + "myselfCenter";
                WeixinTemplateMessageUtil.sendBusinessMemberDeadlineTemplateWXMessage(name,expDate,token,url,openid);
            }
        }

    }

    public void monthlyIncomeCalc(String businessType) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserType(businessType);
        userInfoDTO.setDelFlag("0");
        List<UserInfoDTO> userInfoDTOList = userService.getUserInfo(userInfoDTO);
        //String token = WeixinUtil.getToken();
        for(UserInfoDTO userInfo:userInfoDTOList)
        {
            float returnMonthlyMoney = 0;

//            Date startDate = null;
//            Date endDate = DateUtils.formatDateString(DateUtils.getYear()+"-"+DateUtils.getMonth()+"-"+"26");
//            int t = Integer.parseInt("02");
//            if(DateUtils.getMonth().equals("01"))
//            {
//                int month = 12;
//                int year = Integer.parseInt(DateUtils.getYear()) - 1;
//                startDate = DateUtils.formatDateString(year + "-" + month + "-26");
//            }
//            else{
//                int month = Integer.parseInt(DateUtils.getMonth()) - 1;
//                startDate = DateUtils.formatDateString(DateUtils.getYear() + "-" + month + "-26");
//            }

            Date startDate = DateUtils.formatDateString("2018-02-26");
            Date endDate = DateUtils.formatDateString("2018-03-26");

            if(userInfo.getId().equals("fad6255e-3bd6-4eab-9672-525bbe3e60b0"))
            {
                int t11 = 0;
            }

            List<MonthTransactionRecordDTO> monthTransactionRecordDTOList =  transactionDao.getMonthTransactionRecordByUserId(userInfo.getId(),startDate,endDate);

            for(MonthTransactionRecordDTO monthTransactionRecordDTO:monthTransactionRecordDTOList)
            {
                returnMonthlyMoney = returnMonthlyMoney + monthTransactionRecordDTO.getAmount();
            }

            //计算当前用户本月的消费金额
            List<PayRecordDTO> payRecordDTOList = payRecordService.getUserPayRecordListByDate(userInfo.getId(),startDate,endDate);
            float userExpenseAmount = 0;
            for(PayRecordDTO payRecordDTO:payRecordDTOList)
            {
                if(payRecordDTO.getStatus().equals("1"))
                {
                    userExpenseAmount = userExpenseAmount + payRecordDTO.getAmount();
                }
            }

            if((businessType.equals(ConfigConstant.businessA1)&&userExpenseAmount>=ConfigConstant.MONTH_A_INCOME_MAX_EXPENSE)
                    ||(businessType.equals(ConfigConstant.businessB1)&&userExpenseAmount>=ConfigConstant.MONTH_B_INCOME_MAX_EXPENSE))
            {
                returnMonthlyMoney = returnMonthlyMoney + userExpenseAmount;
                if(returnMonthlyMoney>0)
                {
                    if(businessType.equals(ConfigConstant.businessA1))
                    {
                        returnMonthlyMoney = returnMonthlyMoney * ConfigConstant.MONTH_A_INCOME_PERCENTAGE/100;
                    }
                    else if(businessType.equals(ConfigConstant.businessB1))
                    {
                        returnMonthlyMoney = returnMonthlyMoney * ConfigConstant.MONTH_B_INCOME_PERCENTAGE/100;
                    }
                    IncomeRecordDTO incomeRecordDTO = new IncomeRecordDTO();
                    incomeRecordDTO.setId(UUID.randomUUID().toString());
                    incomeRecordDTO.setTransactionId(CodeGenUtil.getTransactionCodeNumber());
                    incomeRecordDTO.setSysUserId(userInfo.getId());
                    incomeRecordDTO.setIncomeType("month");
                    incomeRecordDTO.setAmount(returnMonthlyMoney);
                    incomeRecordDTO.setStatus("0");
                    incomeRecordDTO.setCreateDate(new Date());
                    incomeRecordDTO.setUpdateDate(new Date());
                    incomeRecordService.insertUserIncomeInfo(incomeRecordDTO);

                    AccountDTO accountDTO = accountService.getUserAccountInfo(userInfo.getId());
                    float balance = accountDTO.getBalance() + returnMonthlyMoney;
                    float balanceDeny = accountDTO.getBalanceDeny() + returnMonthlyMoney;
                    accountDTO.setBalance(balance);
                    accountDTO.setBalanceDeny(balanceDeny);
                    accountDTO.setUpdateDate(new Date());
                    accountService.updateUserAccountInfo(accountDTO);
                }
            }

//            String url = ConfigConstant.BUSINESS_WEB_URL + "orderManagement/1";
            //WeixinTemplateMessageUtil.sendMonthIncomeTemplateWXMessage(userInfo.getId(),returnMonthlyMoney+"",DateUtils.DateToStr(new Date()),token,"",userInfo.getUserOpenid());
        }
    }

    public void promoteUserBusinessTypeForRecommend() {
        //根据B用户推荐20个B的逻辑，来实现用户等级提升
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setDelFlag("0");
        userInfoDTO.setUserType(ConfigConstant.businessB1);
        List<UserInfoDTO> userInfoDTOS = userService.getUserInfo(userInfoDTO);
        String token = WeixinUtil.getToken();
        for(UserInfoDTO userInfo : userInfoDTOS)
        {
            //查询所有下一级的情况
            UserInfoDTO nextUserInfoDTO = new UserInfoDTO();
            nextUserInfoDTO.setParentUserId(userInfo.getId());
            List<UserInfoDTO> userInfoDTOList = userService.getUserInfo(nextUserInfoDTO);

            int recommendBNum = 0;
            int recommendANum = 0;
            boolean promoteAFlag = false;
            for(UserInfoDTO user:userInfoDTOList)
            {
                //先确保下线用户的状态没有被冻结，2的话被冻结了
                UserBusinessTypeDTO userBusinessTypeDTO = new UserBusinessTypeDTO();
                userBusinessTypeDTO.setStatus("1");
                userBusinessTypeDTO.setSysUserId(user.getId());
                List<UserBusinessTypeDTO> userBusinessTypeDTOS = userService.getUserBusinessType(userBusinessTypeDTO);

                if(userBusinessTypeDTOS.size()>0)
                {
                    if(user.getUserType().equals(ConfigConstant.businessA1))
                    {
                        recommendANum = recommendANum + 1;
                    }else if(user.getUserType().equals(ConfigConstant.businessB1))
                    {
                        recommendBNum = recommendBNum + 1;
                    }
                }
            }
            if((recommendBNum+recommendANum)>=20)
            {
                promoteAFlag = true;
            }
            if(promoteAFlag)
            {
                //更新user_business_type表的数据
                //1、把老级别变为失效
                UserBusinessTypeDTO userBusinessTypeDTO = new UserBusinessTypeDTO();
                userBusinessTypeDTO.setSysUserId(userInfo.getId());
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
                userBusinessTypeDTO.setParentUserId(userInfo.getParentUserId());
                userBusinessTypeDTO.setSysUserId(userInfo.getId());
                userBusinessTypeDTO.setUserType(ConfigConstant.businessA1);
                userBusinessTypeDTO.setStatus("1");
                userBusinessTypeDTO.setCreateDate(new Date());
                userService.insertUserBusinessType(userBusinessTypeDTO);

                //sys_user表也需要更新
                userInfo.setUserType(ConfigConstant.businessA1);
                userService.updateUserInfo(userInfo);
                Calendar calendar = Calendar.getInstance();
                Date date = new Date();
                calendar.setTime(date);
                calendar.add(Calendar.YEAR, 1);
                date = calendar.getTime();
                WeixinTemplateMessageUtil.sendBusinessPromoteForRecommendTemplateWXMessage(userInfo.getNickname(),DateUtils.DateToStr(date),token, "", userInfo.getUserOpenid());
            }
        }
    }

    public void deFrozenUserReturnMoney(List<IncomeRecordDTO> incomeRecordDTOList,List<String> transactionIds) {
       for(IncomeRecordDTO incomeRecord : incomeRecordDTOList)
        {
            if(!transactionIds.contains(incomeRecord.getTransactionId()))
            {
                transactionIds.add(incomeRecord.getTransactionId());
            }

            boolean operationFlag = true;

            //判断incomeRecord记录中的这个用户的门店是不是处于冻结状态
            UserBusinessTypeDTO userBusinessTypeDTO = new UserBusinessTypeDTO();
            userBusinessTypeDTO.setSysUserId(incomeRecord.getSysUserId());
            userBusinessTypeDTO.setStatus("2");
            List<UserBusinessTypeDTO> userBusinessTypeDTOS = userService.getUserBusinessType(userBusinessTypeDTO);
            if(userBusinessTypeDTOS.size()>0)
            {
                break;
            }

            //根据transactionId查询orderId，根据orderId查询business_order
            PayRecordDTO payRecordDTO = new PayRecordDTO();
            payRecordDTO.setTransactionId(incomeRecord.getTransactionId());
            List<PayRecordDTO> payRecordDTOList =  payRecordService.getUserPayRecordList(payRecordDTO);

            if(payRecordDTOList.size()==0)
            {
                break;
            }

            //判断某笔交易下订单是否都已经收货
            for(PayRecordDTO payRecord : payRecordDTOList)
            {
                BusinessOrderDTO businessOrderDTO = transactionDao.getBusinessOrderByOrderId(payRecord.getOrderId());
                if(!businessOrderDTO.getStatus().equals("2")&&!businessOrderDTO.getStatus().equals("5"))//5代表已退货
                {
                    operationFlag = false;
                    break;
                }
            }

            if(operationFlag)
            {
                //用户资金解冻和级别提升返现，和推荐奖励，的所有操作，加一把锁
                RedisLock redisLock = new RedisLock("userReturnMoneyDeLock"+incomeRecord.getSysUserId());
                redisLock.lock();

                try
                {
                    //解冻用户的提成，先找出要解冻返现的用户账户，做资金解冻
                    float balanceDeny = incomeRecord.getAmount();
                    AccountDTO accountDTO = accountService.getUserAccountInfo(incomeRecord.getSysUserId());
                    balanceDeny = accountDTO.getBalanceDeny() - balanceDeny;
                    if(balanceDeny==0)
                    {
                        balanceDeny = balanceDeny + (float)0.0001;
                    }
                    accountDTO.setBalanceDeny(balanceDeny);
                    accountDTO.setUpdateDate(new Date());
                    accountService.updateUserAccountInfo(accountDTO);

                    incomeRecord.setStatus("1");
                    incomeRecord.setUpdateDate(new Date());
                    incomeRecordService.updateIncomeInfo(incomeRecord);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    throw e;
                }
                finally {
                    redisLock.unlock();
                }
            }
        }
    }

}
