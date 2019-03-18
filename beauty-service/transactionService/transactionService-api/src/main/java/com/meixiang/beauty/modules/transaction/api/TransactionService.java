package com.meixiang.beauty.modules.transaction.api;

import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.UserOrderAddressDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;

import java.util.List;

/**
 * Created by zbm84 on 2017/5/10.
 */
public interface TransactionService {

    void updateBusinessOrderStatus(BusinessOrderDTO businessOrderDTO);

    void updateBusinessOrder(BusinessOrderDTO businessOrderDTO);

    List<BusinessOrderDTO> getBusinessOrderListByUserIdAndStatus(String userId, String status);

    String createBusinessOrder(BusinessOrderDTO businessOrderDTO);

    BusinessOrderDTO getBusinessOrderByOrderId(String orderId);

    PageParamDTO<List<PayRecordDTO>> queryPayRecordsByParameters(String transactionIdOrOrderId, String applyStartTime, String applyEndTime, String updateStartTime, String updateEndTime, Integer pageNo, Integer pageSize);

    BusinessOrderDTO getTrainingBusinessOrder(BusinessOrderDTO businessOrderDTO);

    PageParamVoDTO<List<BusinessOrderDTO>> queryBusinessOrderByParameters(PageParamVoDTO pageParamVoDTO);

    //查询所有订单
    PageParamDTO<List<BusinessOrderDTO>> queryAllBusinessOrders(PageParamVoDTO<BusinessOrderDTO> pageParamVoDTO);

    BusinessOrderDTO getBusinessOrderDetailInfoByOrderId(String orderId);

    //订单详情
    BusinessOrderDTO queryOrderDetailsById(String orderId);

    //修改订单地址
    void updateOrderAddress(UserOrderAddressDTO userOrderAddressDTO);

    List<BusinessOrderDTO> getBusinessOrderByUserIdAndProductId(String userId, String productId);
}
