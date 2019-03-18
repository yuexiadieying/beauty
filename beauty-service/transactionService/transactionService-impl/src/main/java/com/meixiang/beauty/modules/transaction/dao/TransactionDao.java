package com.meixiang.beauty.modules.transaction.dao;


import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.system.UserOrderAddressDTO;
import com.meixiang.beauty.common.dto.transaction.*;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by sunxiao on 2017/8/8.
 */
@MyBatisDao
@Repository
public interface TransactionDao {

    void createBusinessOrder(BusinessOrderDTO businessOrderDTO);

    void createOrderProductRelation(OrderProductRelationDTO orderProductRelationDTO);

    OrderProductRelationDTO getOrderProductUnPaidInBuyCart(@Param("productId") String productId,
                                                          @Param("productSpec") String productSpec,
                                                          @Param("userId") String userId);

    void updateOrderProductRelation(OrderProductRelationDTO orderProductRelationDTO);

    List<OrderProductRelationDTO> getUserAllOrderProductFromBuyCart(@Param("userId") String userId);

    List<BusinessOrderDTO> getUserUnPayOrderInBuyCart(@Param("userId") String userId);

    BusinessOrderDTO getBusinessOrderByOrderId(@Param("orderId") String orderId);

    void updateBusinessOrder(BusinessOrderDTO businessOrderDTO);

    List<BusinessOrderDTO> getBusinessOrderListByUserIdAndStatus(@Param("userId") String userId, @Param("status") String status);

    List<BusinessOrderDTO> getTrainingBusinessOrder(BusinessOrderDTO businessOrderDTO);

    List<BusinessOrderDTO> getBusinessOrderList(BusinessOrderDTO businessOrderDTO);

    int queryBusinessOrderCountByParameters(PageParamVoDTO pageParamVoDTO);

    List<BusinessOrderDTO> queryBusinessOrderByParameters(PageParamVoDTO pageParamVoDTO);

    List<BusinessOrderDTO> queryAllBusinessOrders(@Param("pageStartNo") int pageStartNo,
                                                  @Param("pageSize") int pageSize,
                                                  @Param("isExportExcel") String isExportExcel);
    //查询所有订单Count
    int queryAllBusinessOrderCount(PageParamVoDTO<BusinessOrderDTO> pageParamVoDTO);

    BusinessOrderDTO getBusinessOrderDetailInfoByOrderId(@Param("orderId") String orderId);

    void recordMonthTransaction(MonthTransactionRecordDTO monthTransactionRecordDTO);

    List<MonthTransactionRecordDTO> getMonthTransactionRecordByUserId(@Param("userId") String userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    //查询订单详情
    BusinessOrderDTO queryOrderDetailsById(@Param("orderId") String orderId);

    //修改订单地址
    void updateOrderAddress(UserOrderAddressDTO userOrderAddressDTO);

    List<BusinessOrderDTO> getBusinessOrderByUserIdAndProductId(@Param("userId") String userId, @Param("productId") String productId);
}
