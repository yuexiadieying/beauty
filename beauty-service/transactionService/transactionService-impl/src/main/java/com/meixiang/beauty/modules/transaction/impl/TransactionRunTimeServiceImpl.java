package com.meixiang.beauty.modules.transaction.impl;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.dto.account.IncomeRecordDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.transaction.*;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.common.utils.RedisLock;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.modules.account.IncomeRecordService;
import com.meixiang.beauty.modules.account.PayRecordService;
import com.meixiang.beauty.modules.account.dao.PayRecordDao;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.modules.system.util.WeixinTemplateMessageUtil;
import com.meixiang.beauty.modules.transaction.api.TransactionRunTimeService;
import com.meixiang.beauty.modules.transaction.dao.TransactionDao;
import com.meixiang.beauty.modules.transaction.function.TransactionRunTimeFunction;
import com.meixiang.beauty.sys.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by zbm84 on 2017/5/10.
 */

@Service
public class TransactionRunTimeServiceImpl implements TransactionRunTimeService {

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private IncomeRecordService incomeRecordService;

    @Autowired
    private PayRecordDao payRecordDao;

    @Autowired
    private PayRecordService payRecordService;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRunTimeFunction transactionRunTimeFunction;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void autoConfirmReceiveProduct() {

        //先获取所有用户已经完成支付，但是没有确认收货的订单
        BusinessOrderDTO businessOrderDTO = new BusinessOrderDTO();
        businessOrderDTO.setStatus("1");
        businessOrderDTO.setType("offline");
        List<BusinessOrderDTO> businessOrderDTOList = transactionDao.getBusinessOrderList(businessOrderDTO);

        //已经发货，但是用户没有确认收货的订单
        businessOrderDTO.setStatus("4");
        List<BusinessOrderDTO> businessOrderDTOList1 = transactionDao.getBusinessOrderList(businessOrderDTO);

        businessOrderDTOList.addAll(businessOrderDTOList1);

        //遍历所有用户的订单支付时间，todo 考虑加一个锁，避免用户凌晨3点下单的时候，造成business_order表死锁
        for(BusinessOrderDTO businessOrder:businessOrderDTOList)
        {
            Date dt1 = businessOrder.getUpdateDate();
            //获取15天前的日期
            Date dt2 = new Date((new Date()).getTime() - (long) ConfigConstant.AUTO_CONFIRM_RECEIVE_PRODUCT_DAY * 24 * 60 * 60 * 1000);

            //用户在15天前已经支付
            if (dt2.getTime() > dt1.getTime())
            {
                RedisLock redisLock = new RedisLock("businessOrder"+businessOrder.getBusinessOrderId());
                redisLock.lock();
                try{
                    String sendProductDate = DateUtils.DateToStr(businessOrder.getUpdateDate());
                    businessOrder.setStatus("2");
                    businessOrder.setUpdateDate(new Date());
                    transactionDao.updateBusinessOrder(businessOrder);
                    String autoReceiveProductDate = DateUtils.DateToStr(businessOrder.getUpdateDate());

                    String token = WeixinUtil.getToken();
                    String url = ConfigConstant.BUSINESS_WEB_URL + "orderManagement/1";

                    UserInfoDTO userInfoDTO = new UserInfoDTO();
                    userInfoDTO.setId(businessOrder.getSysUserId());
                    List<UserInfoDTO> userInfoDTOList =  userService.getUserInfo(userInfoDTO);
                    if(userInfoDTOList.size()>0)
                    {
                        WeixinTemplateMessageUtil.sendOrderConfirmReceiveTemplateWXMessage(businessOrder.getBusinessOrderId(), businessOrder.getBusinessProductName(),
                                sendProductDate,autoReceiveProductDate,token,url,userInfoDTOList.get(0).getUserOpenid());
                    }
                }
                catch (Exception e) {
                    throw e;
                } finally {
                    redisLock.unlock();
                }
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void autoProcessUserAccount() {

        //查询用户消费的不可提现金额
        IncomeRecordDTO incomeRecordDTO = new IncomeRecordDTO();
        incomeRecordDTO.setStatus("0");
        incomeRecordDTO.setIncomeType("instance");
        List<IncomeRecordDTO> incomeRecordDTOList = incomeRecordService.getUserIncomeRecordInfo(incomeRecordDTO);
        List<String> transactionIds = new ArrayList<>();

        //用户返现解冻
        transactionRunTimeFunction.deFrozenUserReturnMoney(incomeRecordDTOList,transactionIds);

        //同级推荐提升逻辑
        transactionRunTimeFunction.promoteUserBusinessTypeForRecommend();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void autoMonthlyIncomeCalc() {

        //加入开关量，证明本月已经完成过月度提成了，不用再次计算
        Query query = new Query(Criteria.where("year").is(DateUtils.getYear())).addCriteria(Criteria.where("month").is(DateUtils.getMonth()));
        MonthlyIncomeSignalDTO monthlyIncomeSignalDTO = mongoTemplate.findOne(query,MonthlyIncomeSignalDTO.class,"monthlyIncomeSignal");
        if(monthlyIncomeSignalDTO==null)
        {
            monthlyIncomeSignalDTO = new MonthlyIncomeSignalDTO();
            monthlyIncomeSignalDTO.setYear(DateUtils.getYear());
            monthlyIncomeSignalDTO.setMonth(DateUtils.getMonth());
            monthlyIncomeSignalDTO.setOnTimeFinish("false");
            mongoTemplate.insert(monthlyIncomeSignalDTO,"monthlyIncomeSignal");

            transactionRunTimeFunction.monthlyIncomeCalc(ConfigConstant.businessA1);

            transactionRunTimeFunction.monthlyIncomeCalc(ConfigConstant.businessB1);

            //操作完毕后，关闭信号量
            Update update = new Update();
            update.set("onTimeFinish","true");
            mongoTemplate.updateFirst(query,update,"monthlyIncomeSignal");
        }
        else if(monthlyIncomeSignalDTO.getOnTimeFinish().equals("false"))
        {
            transactionRunTimeFunction.monthlyIncomeCalc(ConfigConstant.businessA1);

            transactionRunTimeFunction.monthlyIncomeCalc(ConfigConstant.businessB1);

            //操作完毕后，关闭信号量
            Update update = new Update();
            update.set("onTimeFinish","true");
            mongoTemplate.updateFirst(query,update,"monthlyIncomeSignal");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void autoCalculateUserType() throws UnsupportedEncodingException {
        transactionRunTimeFunction.frozenUserType(ConfigConstant.businessA1);
        transactionRunTimeFunction.frozenUserType(ConfigConstant.businessB1);
    }

    @Override
    public void autoProcessNoPayRecordData() {

        Date dt1 = new Date((new Date()).getTime() - (long) ConfigConstant.AUTO_NOTIFY_PRODUCT_PAY * 24 * 60 * 60 * 1000);
        Date dt2 = new Date((new Date()).getTime() - (long) ConfigConstant.AUTO_DELETE_BUSINESS_ORDER * 24 * 60 * 60 * 1000);

        String token = WeixinUtil.getToken();

        //查询系统中所有未支付的订单
        BusinessOrderDTO businessOrderDTO = new BusinessOrderDTO();
        businessOrderDTO.setStatus("0");
        List<BusinessOrderDTO> businessOrderDTOList = transactionDao.getBusinessOrderList(businessOrderDTO);
        if(businessOrderDTOList.size()>0)
        {
            for(BusinessOrderDTO businessOrder : businessOrderDTOList)
            {
                if((businessOrder.getCreateDate().getTime()-dt1.getTime())<0)
                {

                    UserInfoDTO userInfoDTO = new UserInfoDTO();
                    userInfoDTO.setId(businessOrder.getSysUserId());
                    userInfoDTO.setDelFlag("0");
                    List<UserInfoDTO> userInfoDTOList = userService.getUserInfo(userInfoDTO);
                    String url = ConfigConstant.BUSINESS_WEB_URL + "orderManagement/0";
                    WeixinTemplateMessageUtil.sendOrderNotPayTemplateWXMessage(DateUtils.DateToStr(businessOrder.getCreateDate()),
                                                                                businessOrder.getBusinessOrderId(),token,url,userInfoDTOList.get(0).getUserOpenid());
                }
                else if((businessOrder.getCreateDate().getTime()-dt2.getTime())<0)
                {
                    businessOrder.setStatus("del");
                    transactionDao.updateBusinessOrder(businessOrder);
                    PayRecordDTO payRecordDTO = new PayRecordDTO();
                    payRecordDTO.setSysUserId(businessOrder.getSysUserId());
                    payRecordDTO.setOrderId(businessOrder.getBusinessOrderId());
                    List<PayRecordDTO> payRecordDTOList = payRecordDao.getPayRecordInfo(payRecordDTO);
                    if(payRecordDTOList.size()>0)
                    {
                        payRecordDTO = payRecordDTOList.get(0);
                        payRecordDTO.setStatus("2");
                        payRecordService.updatePayRecordStatus(payRecordDTO);
                    }
                }
            }
        }
    }
}
