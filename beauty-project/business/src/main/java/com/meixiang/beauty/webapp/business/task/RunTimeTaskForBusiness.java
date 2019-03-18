package com.meixiang.beauty.webapp.business.task;

import com.meixiang.beauty.modules.account.AccountService;
import com.meixiang.beauty.modules.transaction.api.TransactionRunTimeService;
import com.meixiang.beauty.modules.transaction.api.TransactionService;
import com.meixiang.beauty.modules.wechat.api.WeixinCoreService;
import com.meixiang.beauty.sys.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

/**
 * Created by sunxiao on 2017/9/14.
 */
public class RunTimeTaskForBusiness {

    @Autowired
    WeixinCoreService weixinCoreService;

    @Autowired
    TransactionRunTimeService transactionRunTimeService;

    @Autowired
    AccountService accountService;

    //每隔60分钟，更新一次公众号的Token
    public void updateWeixinToken(){
        weixinCoreService.updateWeixinToken();
    }

    //每隔30分钟，将payRecord表中，状态为0的订单，进行状态调整处理
    public void processNoPayRecordData(){
//        transactionRunTimeService.autoProcessNoPayRecordData();
    }

    public void autoTaskEveryDayInMorning() throws UnsupportedEncodingException {
        //用户15天后，自动转为收到货物
        transactionRunTimeService.autoConfirmReceiveProduct();

        //完成用户的状态冻结的自动化操作
        transactionRunTimeService.autoCalculateUserType();

        //用户即时返现解冻和用户等级提升的批量处理
        transactionRunTimeService.autoProcessUserAccount();

        //判断是不是本月的25号，若是25号，则进行月度提成计算
        Calendar now = Calendar.getInstance();
        String day = now.get(Calendar.DAY_OF_MONTH) + "";
        if(day.equals("26"))
        {
            transactionRunTimeService.autoMonthlyIncomeCalc();
        }
    }

}
