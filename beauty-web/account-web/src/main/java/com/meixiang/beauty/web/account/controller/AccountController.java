package com.meixiang.beauty.web.account.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.dto.product.InvoiceDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserBankCardInfoDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.account.IncomeRecordDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.modules.account.AccountService;
import com.meixiang.beauty.modules.account.IncomeRecordService;
import com.meixiang.beauty.modules.account.WithdrawService;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.modules.transaction.api.TransactionService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 微信页面参数获取相关的控制类
 * Created by baoweiw on 2015/7/27.
 */

@Controller
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    private IncomeRecordService incomeRecordService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private WithdrawService withdrawService;

    @Autowired
    private UserService userService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private TransactionService transactionService;

    /**
     * 获取用户的账户信息
     */
    @RequestMapping(value = "userAccountInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<AccountDTO> userAccountInfo() {
        //订单的4个状态,待付款,待发货,待收货,已完成
        String[] array = {"0","1","4","2"};
        List<Integer> stautsCountList = new ArrayList<>();//各个状态下的订单Count
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        ResponseDTO<AccountDTO> result = new ResponseDTO<>();
        AccountDTO accountDTO = accountService.getUserAccountInfo(userInfoDTO.getId());

        //如果用户没有账户，则为用户创建一个账户
        if(accountDTO==null)
        {
            accountDTO = new AccountDTO();

            //为用户新建一个账户
            accountDTO.setId(UUID.randomUUID().toString());
            accountDTO.setSysUserId(userInfoDTO.getId());
            accountDTO.setUserOpenId(userInfoDTO.getUserOpenid());
            accountDTO.setBalance((float)0.00);
            accountDTO.setScore((float)0.00);
            accountDTO.setStatus("nomral");
            accountDTO.setUpdateDate(new Date());
            accountDTO.setBalanceDeny((float)0.00);
            accountService.createUserAccount(accountDTO);
        }

        List<IncomeRecordDTO> incomeRecordDTOS = incomeRecordService.getUserIncomeInfoByDate(userInfoDTO.getId(),new Date());
        float todayIncome = 0;
        for(IncomeRecordDTO incomeRecordDTO:incomeRecordDTOS)
        {
            todayIncome = todayIncome + incomeRecordDTO.getAmount();
        }
        accountDTO.setTodayIncome(todayIncome);
        accountDTO.setIdentifyNumber(userInfoDTO.getIdentifyNumber());

        Query query = new Query(Criteria.where("sysUserId").is(userInfoDTO.getId()));
        List<UserBankCardInfoDTO> userBankCardInfoDTOS = mongoTemplate.find(query,UserBankCardInfoDTO.class,"userBankCardInfo");
        if(userBankCardInfoDTOS.size()>0)
        {
            accountDTO.setBankCardInfo(userBankCardInfoDTOS.get(0));
        }

        for (String status :array) {//按状态查询订单
            List<BusinessOrderDTO> businessOrderDTOList =  transactionService.getBusinessOrderListByUserIdAndStatus(userInfoDTO.getId(),status);
            stautsCountList.add(businessOrderDTOList.size());
        }
        accountDTO.setStautsCountList(stautsCountList);
        result.setResponseData(accountDTO);
        result.setResult(StatusConstant.SUCCESS);
        return result;
    }

    /**
     * 用户进行提现操作
     */
    @RequestMapping(value = "withDrawMoneyFromAccount", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO withDrawMoneyFromAccount(@RequestParam float moneyAmount,
                                         @RequestParam String identifyNumber,
                                         @RequestParam String bankCardNumber,
                                         @RequestParam String userName,
                                         HttpServletRequest request,
                                         HttpSession session) {
        ResponseDTO<AccountDTO> result = new ResponseDTO<>();

        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();

        if(!(identifyNumber==null||identifyNumber.equals("")))
        {
            userInfoDTO.setIdentifyNumber(identifyNumber);
            userService.updateUserInfo(userInfoDTO);
        }
        else
        {
            result.setResult(StatusConstant.FAILURE);
            result.setErrorInfo("noIdentify");
            return  result;
        }

        try{
            String openid = WeixinUtil.getOpenId(session,request);
            UserBankCardInfoDTO userBankCardInfoDTO = new UserBankCardInfoDTO();
            userBankCardInfoDTO.setSysUserId(userInfoDTO.getId());
            userBankCardInfoDTO.setUserName(userName);
            userBankCardInfoDTO.setBankCardNumber(bankCardNumber);
            withdrawService.withDrawMoneyFromAccount(moneyAmount,request,openid,userBankCardInfoDTO);
            result.setResult(StatusConstant.SUCCESS);
        }catch (Exception e)
        {
            e.printStackTrace();
            result.setResult(StatusConstant.FAILURE);
        }
        return result;
    }

}
