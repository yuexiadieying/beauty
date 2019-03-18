package com.meixiang.beauty.modules.weixin.impl;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.transaction.InstanceReturnMoneySignalDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import com.meixiang.beauty.common.utils.RedisLock;
import com.meixiang.beauty.modules.account.PayRecordService;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.modules.wechat.api.WeixinPayService;
import com.meixiang.beauty.modules.weixin.function.WeixinPayFunction;
import com.meixiang.beauty.sys.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangbaowei
 * @date 2015-11-04
 */

@Service
public class WeixinPayServiceImpl implements WeixinPayService {

    @Autowired
    private PayRecordService payRecordService;

    @Autowired
    private WeixinPayFunction weixinPayFunction;

    @Autowired
    private MongoTemplate mongoTemplate;

    private static ExecutorService threadExecutorSingle = Executors.newSingleThreadExecutor();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void handleOfflineProductPayNotifyInfo(String accountPay, PayRecordDTO payRecordDTO) {

        List<PayRecordDTO> payRecordDTOList = payRecordService.getUserPayRecordList(payRecordDTO);

        RedisLock redisLock = new RedisLock("userPay"+payRecordDTOList.get(0).getSysUserId());
        redisLock.lock();
        try {
            weixinPayFunction.processPayStatus(payRecordDTOList,"offline");

            //实时提现不跟交易放在一起，在此设置一个信号灯
            payRecordDTO = payRecordDTOList.get(0);
            InstanceReturnMoneySignalDTO instanceReturnMoneySignalDTO = new InstanceReturnMoneySignalDTO();
            instanceReturnMoneySignalDTO.setSysUserId(payRecordDTO.getSysUserId());
            instanceReturnMoneySignalDTO.setOutTradeNo(payRecordDTO.getOutTradeNo());
            instanceReturnMoneySignalDTO.setTransactionId(payRecordDTO.getTransactionId());
            instanceReturnMoneySignalDTO.setStatus("0");
            mongoTemplate.insert(instanceReturnMoneySignalDTO,"instanceReturnMoneySignal");

            //开启一个线程，进行即时返现和提升处理
            Runnable processInstancePayThread = new ProcessInstancePayThread(instanceReturnMoneySignalDTO);
            threadExecutorSingle.execute(processInstancePayThread);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            redisLock.unlock();
        }
    }

    //进入即时返现和提升处理线程
    private class ProcessInstancePayThread extends Thread {
        private InstanceReturnMoneySignalDTO instanceReturnMoneySignalDTO;

        public ProcessInstancePayThread(InstanceReturnMoneySignalDTO instanceReturnMoneySignalDTO) {
            this.instanceReturnMoneySignalDTO = instanceReturnMoneySignalDTO;
        }

        @Override
        public void run() {
            try
            {
                //todo 开启A、B店的规则，给不同的用户给与不同的金额入账，此处涉及到修改用户的account表和income表
                UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromUserId(instanceReturnMoneySignalDTO.getSysUserId());

                //todo 此处的逻辑主要是用来实现即时返现功能，此时即时返现的资金是冻结的，需要用户收货之后，获得返现的用户才能拿到钱
                if(!ObjectUtils.isNullOrEmpty(userInfoDTO.getParentUserId()))
                {
                    if(userInfoDTO.getUserType().equals(ConfigConstant.businessB1))
                    {
                        //走B店用户消费返现逻辑
                        //1、查询父一级用户是否是A店用户
                        UserInfoDTO parentUserInfoDTO =  UserUtils.getUserInfoFromUserId(userInfoDTO.getParentUserId());
                        if(parentUserInfoDTO.getUserType()!=null)
                        {
                            if(parentUserInfoDTO.getUserType().equals(ConfigConstant.businessA1))
                            {
                                weixinPayFunction.updateReturnMoneyDataBase(parentUserInfoDTO.getId(),ConfigConstant.businessB1,ConfigConstant.businessA1, instanceReturnMoneySignalDTO);
                            }
                        }
                    }
                    if(userInfoDTO.getUserType().equals(ConfigConstant.businessC1))
                    {
                        //走普通用户消费逻辑
                        //1、查询父一级的用户信息
                        UserInfoDTO parentUserInfoDTO = UserUtils.getUserInfoFromUserId(userInfoDTO.getParentUserId());
                        if(parentUserInfoDTO.getUserType()!=null)
                        {
                            if(parentUserInfoDTO.getUserType().equals(ConfigConstant.businessA1))  //2、如果父一级用户为A店用户
                            {
                                weixinPayFunction.updateReturnMoneyDataBase(parentUserInfoDTO.getId(),ConfigConstant.businessC1,ConfigConstant.businessA1, instanceReturnMoneySignalDTO);
                            }
                            else if(parentUserInfoDTO.getUserType().equals(ConfigConstant.businessB1)) //3、如果父一级用户为B店用户
                            {
                                //先更新用户上一级B店用户的返现金额
                                weixinPayFunction.updateReturnMoneyDataBase(parentUserInfoDTO.getId(),ConfigConstant.businessC1,ConfigConstant.businessB1, instanceReturnMoneySignalDTO);

                                if(parentUserInfoDTO.getParentUserId()!=null)
                                {
                                    UserInfoDTO grandpaUserInfoDTO = UserUtils.getUserInfoFromUserId(parentUserInfoDTO.getParentUserId());

                                    //在更新爷爷一级用户的类型为A店店主的返现金额
                                    if(grandpaUserInfoDTO.getUserType()!=null)
                                    {
                                        if(grandpaUserInfoDTO.getUserType().equals(ConfigConstant.businessA1))
                                        {
                                            weixinPayFunction.updateReturnMoneyDataBase(grandpaUserInfoDTO.getId(),ConfigConstant.businessC1,"A1B1", instanceReturnMoneySignalDTO);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                //判断此笔交易可否提升用户等级
                PayRecordDTO payRecordDTO = new PayRecordDTO();
                payRecordDTO.setStatus("1");
                payRecordDTO.setTransactionId(instanceReturnMoneySignalDTO.getTransactionId());
                List<PayRecordDTO> payRecordDTOList = payRecordService.getUserPayRecordList(payRecordDTO);

                float expenseMoney = 0;
                for(PayRecordDTO payRecord : payRecordDTOList)
                {
                    expenseMoney = expenseMoney + payRecord.getAmount();
                }

                //判断，消费额度是否可以提升用户的等级
                if(ConfigConstant.businessC1.equals(userInfoDTO.getUserType()))
                {
                    //如果是C用户
                    if(expenseMoney>=ConfigConstant.PROMOTE_B_LEVEL_MIN_EXPENSE&&expenseMoney<=ConfigConstant.PROMOTE_B_LEVEL_MAX_EXPENSE)
                    {
                        //消费金额在B的区间段，升级为B
                        weixinPayFunction.promoteUserBusinessTypeForExpenseSecond(userInfoDTO,ConfigConstant.businessB1);
                    }
                    else if(expenseMoney>=ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)
                    {
                        //消费金额在A的区间段，升级为A
                        weixinPayFunction.promoteUserBusinessTypeForExpenseSecond(userInfoDTO,ConfigConstant.businessA1);
                    }
                }
                else if(ConfigConstant.businessB1.equals(userInfoDTO.getUserType()))
                {
                    if(expenseMoney>=ConfigConstant.PROMOTE_A_LEVEL_MIN_EXPENSE)
                    {
                        //消费金额在A的区间段，升级为A
                        weixinPayFunction.promoteUserBusinessTypeForExpenseSecond(userInfoDTO,ConfigConstant.businessA1);
                    }
                }

                //正常完成分账和升级处理后，关闭信号灯
                Query query = new Query().addCriteria(Criteria.where("status").is("0")).addCriteria(Criteria.where("transactionId").is(instanceReturnMoneySignalDTO.getTransactionId()));
                Update update = new Update();
                update.set("status","1");
                mongoTemplate.updateFirst(query,update,"instanceReturnMoneySignal");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                throw e;
            }
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void handleTrainingProductPayNotifyInfo(String accountNeedPay, PayRecordDTO payRecordDTO)
    {
        List<PayRecordDTO> payRecordDTOList = payRecordService.getUserPayRecordList(payRecordDTO);
        RedisLock redisLock = new RedisLock("userPay"+payRecordDTOList.get(0).getSysUserId());
        redisLock.lock();
        try {
            weixinPayFunction.processPayStatus(payRecordDTOList,"training");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            redisLock.unlock();
        }
    }

}
