package com.meixiang.beauty.modules.transaction.impl;

import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.system.UserOrderAddressDTO;
import com.meixiang.beauty.common.dto.transaction.*;
import com.meixiang.beauty.modules.account.dao.PayRecordDao;
import com.meixiang.beauty.modules.system.api.UserOrderAddressService;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.modules.transaction.api.TransactionService;
import com.meixiang.beauty.modules.transaction.dao.TransactionDao;
import com.meixiang.beauty.sys.utils.CodeGenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.meixiang.beauty.common.utils.DateUtils.formatDate;

/**
 * Created by zbm84 on 2017/5/10.
 */

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserOrderAddressService userOrderAddressService;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private PayRecordDao payRecordDao;

    @Override
    public void updateBusinessOrderStatus(BusinessOrderDTO businessOrderDTO){
        BusinessOrderDTO businessOrderDTONew = transactionDao.getBusinessOrderByOrderId(businessOrderDTO.getBusinessOrderId());
        businessOrderDTONew.setStatus(businessOrderDTO.getStatus());
        transactionDao.updateBusinessOrder(businessOrderDTONew);
    }


    @Override
    public void updateBusinessOrder(BusinessOrderDTO businessOrderDTO){
        transactionDao.updateBusinessOrder(businessOrderDTO);
    }

    @Override
    public List<BusinessOrderDTO> getBusinessOrderListByUserIdAndStatus(String userId, String status) {
        if(status.equals("all"))
        {
            status="";
        }
        List<BusinessOrderDTO> businessOrderDTOList=transactionDao.getBusinessOrderListByUserIdAndStatus(userId,status);
        return businessOrderDTOList;
    }

    //返回订单的ID号
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createBusinessOrder(BusinessOrderDTO businessOrderDTO){
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();

        if(businessOrderDTO.getProductSpec().equals("training"))
        {
            //查找用户是否下过单，并处于待支付状态，若处于待支付状态，直接返回当前订单号，若没有下过单，则进入后续流程则创建新的订单并返回
            businessOrderDTO.setType("training");
            businessOrderDTO.setSysUserId(userInfoDTO.getId());
            List<BusinessOrderDTO> businessOrderDTOList = transactionDao.getTrainingBusinessOrder(businessOrderDTO);
            if(businessOrderDTOList.size()>0)
            {
                return businessOrderDTOList.get(0).getBusinessOrderId();
            }
        }

        businessOrderDTO.setId(UUID.randomUUID().toString());
        businessOrderDTO.setSysUserId(userInfoDTO.getId());
        businessOrderDTO.setBusinessOrderId(CodeGenUtil.getOrderCodeNumber());
        businessOrderDTO.setStatus("0");
        businessOrderDTO.setCreateDate(new Date());
        businessOrderDTO.setUpdateDate(new Date());

        //查询用户默认收货地址的ID
        List<UserOrderAddressDTO> userOrderAddressDTOList = userOrderAddressService.getUserOrderAddress(userInfoDTO.getId(), "1");

        if(userOrderAddressDTOList.size()!=0)
        {
            businessOrderDTO.setUserOrderAddressId(userOrderAddressDTOList.get(0).getId());
        }
        transactionDao.createBusinessOrder(businessOrderDTO);

        OrderProductRelationDTO orderProductRelationDTO = new OrderProductRelationDTO();
        orderProductRelationDTO.setId(UUID.randomUUID().toString());
        orderProductRelationDTO.setBusinessOrderId(businessOrderDTO.getBusinessOrderId());
        orderProductRelationDTO.setBusinessProductId(businessOrderDTO.getBusinessProductId());
        orderProductRelationDTO.setProductNum(1);
        orderProductRelationDTO.setProductSpec(businessOrderDTO.getProductSpec());
        transactionDao.createOrderProductRelation(orderProductRelationDTO);

        return businessOrderDTO.getBusinessOrderId();
    }

    @Override
    public BusinessOrderDTO getBusinessOrderByOrderId(String orderId) {
        return transactionDao.getBusinessOrderByOrderId(orderId);
    }

    /**
     * 根据条件查询提成信息
     * @param transactionIdOrOrderId
     * @param applyStartTime
     * @param applyEndTime
     * @param updateStartTime
     * @param updateEndTime
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageParamDTO<List<PayRecordDTO>> queryPayRecordsByParameters(String transactionIdOrOrderId,
                                                                        String applyStartTime,
                                                                        String applyEndTime,
                                                                        String updateStartTime,
                                                                        String updateEndTime,
                                                                        Integer pageNo,
                                                                        Integer pageSize) {
        PageParamDTO<List<PayRecordDTO>> page = new  PageParamDTO<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int pageStartNo = (pageNo-1)*pageSize;
        int count = payRecordDao.queryPayRecordCountByParameters(
                transactionIdOrOrderId,applyStartTime,applyEndTime,updateStartTime,updateEndTime);
        page.setTotalCount(count);
        List<PayRecordDTO> PayRecordDTOList = payRecordDao.queryPayRecordsByParameters(
                transactionIdOrOrderId,applyStartTime,applyEndTime,updateStartTime,updateEndTime,pageStartNo,pageSize);

        for(PayRecordDTO payRecordDTO : PayRecordDTOList){
            if(payRecordDTO.getNickName() != null && payRecordDTO.getNickName() !=""){
                try {
                    payRecordDTO.setNickName(URLDecoder.decode(payRecordDTO.getNickName(),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        page.setResponseData(PayRecordDTOList);

        return page;

    }

    @Override
    public BusinessOrderDTO getTrainingBusinessOrder(BusinessOrderDTO businessOrderDTO) {
        businessOrderDTO.setType("training");
        List<BusinessOrderDTO> businessOrderDTOList = transactionDao.getTrainingBusinessOrder(businessOrderDTO);
        if(businessOrderDTOList.size()==0)
        {
            return  null;
        }
        else
        {
            return businessOrderDTOList.get(0);
        }
    }

    /**
     * 条件查询订单
     * @return
     */
    @Override
    public PageParamVoDTO<List<BusinessOrderDTO>> queryBusinessOrderByParameters(PageParamVoDTO pageParamVoDTO) {
        PageParamVoDTO<List<BusinessOrderDTO>> page = new  PageParamVoDTO<>();
        int count = transactionDao.queryBusinessOrderCountByParameters(pageParamVoDTO);
        List<BusinessOrderDTO> businessOrderDTODTOList = transactionDao.queryBusinessOrderByParameters(pageParamVoDTO);
        for(BusinessOrderDTO businessOrderDTO : businessOrderDTODTOList){
            if(businessOrderDTO.getNickName()!="" && businessOrderDTO.getNickName() != null){
                try {
                    businessOrderDTO.setNickName(URLDecoder.decode(businessOrderDTO.getNickName(),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        page.setTotalCount(count);
        page.setResponseData(businessOrderDTODTOList);
        return page;
    }

    //查询所有订单
    @Override
    public PageParamDTO<List<BusinessOrderDTO>> queryAllBusinessOrders(PageParamVoDTO<BusinessOrderDTO> pageParamVoDTO) {
        PageParamDTO<List<BusinessOrderDTO>> page = new  PageParamDTO<>();
        page.setPageNo(pageParamVoDTO.getPageNo());
        page.setPageSize(pageParamVoDTO.getPageSize());
//        int pageStartNo = (page.getPageNo()-1)*page.getPageSize();
        int count = transactionDao.queryAllBusinessOrderCount(pageParamVoDTO);

        List<BusinessOrderDTO> businessOrderDTOList = transactionDao.queryAllBusinessOrders(
                pageParamVoDTO.getPageStartNo(),page.getPageSize(),pageParamVoDTO.getIsExportExcel());
        //int count = businessOrderDTOList.size();
        for(BusinessOrderDTO businessOrderDTO : businessOrderDTOList){
            if(businessOrderDTO.getNickName() != null && businessOrderDTO.getNickName() != ""){
                try {
                    businessOrderDTO.setNickName(URLDecoder.decode(businessOrderDTO.getNickName(),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        page.setTotalCount(count);
        page.setResponseData(businessOrderDTOList);
        return page;
    }

    @Override
    public BusinessOrderDTO getBusinessOrderDetailInfoByOrderId(String orderId) {
        return transactionDao.getBusinessOrderDetailInfoByOrderId(orderId);
    }

    @Override
    public BusinessOrderDTO queryOrderDetailsById(String orderId) {
        return transactionDao.queryOrderDetailsById(orderId);
    }

    @Override
    public void updateOrderAddress(UserOrderAddressDTO userOrderAddressDTO) {
        transactionDao.updateOrderAddress(userOrderAddressDTO);
    }

    @Override
    public List<BusinessOrderDTO> getBusinessOrderByUserIdAndProductId(String userId, String productId) {
        return transactionDao.getBusinessOrderByUserIdAndProductId(userId, productId);
    }

}
