package com.meixiang.beauty.modules.transaction.impl;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.product.OfflineProductDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.system.UserOrderAddressDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.transaction.OrderProductRelationDTO;
import com.meixiang.beauty.common.utils.RedisLock;
import com.meixiang.beauty.modules.system.api.UserOrderAddressService;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.modules.transaction.api.BuyCartService;
import com.meixiang.beauty.modules.transaction.dao.TransactionDao;
import com.meixiang.beauty.sys.utils.CodeGenUtil;
import com.meixiang.beauty.sys.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zbm84 on 2017/5/10.
 */

@Service
public class BuyCartServiceImpl implements BuyCartService {

    @Autowired
    private UserOrderAddressService userOrderAddressService;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<BusinessOrderDTO> getUserUnPayOrderInBuyCart() {
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        List<BusinessOrderDTO> businessOrderDTOS = transactionDao.getUserUnPayOrderInBuyCart(userInfoDTO.getId());
        for(BusinessOrderDTO businessOrderDTO:businessOrderDTOS)
        {
            Query query = new Query().addCriteria(Criteria.where("productId").is(businessOrderDTO.getBusinessProductId()));
            OfflineProductDTO offlineProductDTO = mongoTemplate.findOne(query, OfflineProductDTO.class,"offlineProduct");
            businessOrderDTO.setSenderAddress(offlineProductDTO.getSenderAddress());
        }
        return businessOrderDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addOfflineProduct2BuyCart(String productId, String productSpec) {
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();

        //判断用户是否已经将此商品加入过购物车，如果已经加入过，则直接增加订单中，产品的数量
        OrderProductRelationDTO orderProductRelationUnPaid = transactionDao.getOrderProductUnPaidInBuyCart(productId,productSpec,userInfoDTO.getId());

        if(ObjectUtils.isNullOrEmpty(orderProductRelationUnPaid))
        {
            try {
                //如果没有加入过，则直接增加订单中，并设置产品的数量为1
                String businessOrderId = CodeGenUtil.getOrderCodeNumber();
                BusinessOrderDTO businessOrderDTO = new BusinessOrderDTO();
                businessOrderDTO.setId(UUID.randomUUID().toString());
                businessOrderDTO.setSysUserId(userInfoDTO.getId());
                businessOrderDTO.setBusinessOrderId(businessOrderId);
                businessOrderDTO.setType("offline");
                businessOrderDTO.setStatus("3");
                businessOrderDTO.setCreateDate(new Date());
                businessOrderDTO.setUpdateDate(new Date());
                //查询用户默认收货地址的ID
                List<UserOrderAddressDTO> userOrderAddressDTOList = userOrderAddressService.getUserOrderAddress(userInfoDTO.getId(), "1");
                if (userOrderAddressDTOList.size() != 0) {
                    businessOrderDTO.setUserOrderAddressId(userOrderAddressDTOList.get(0).getId());
                }
                transactionDao.createBusinessOrder(businessOrderDTO);

                OrderProductRelationDTO orderProductRelationDTO = new OrderProductRelationDTO();
                orderProductRelationDTO.setId(UUID.randomUUID().toString());
                orderProductRelationDTO.setBusinessOrderId(businessOrderId);
                orderProductRelationDTO.setBusinessProductId(productId);
                orderProductRelationDTO.setProductNum(1);
                orderProductRelationDTO.setProductSpec(productSpec);
                transactionDao.createOrderProductRelation(orderProductRelationDTO);

                return StatusConstant.SUCCESS;
            }
            catch (Exception e)
            {
                return  StatusConstant.FAILURE;
            }
        }
        else
        {
            RedisLock redisLock = new RedisLock("OrderProductRelation");
            try
            {
                Integer productNum = orderProductRelationUnPaid.getProductNum() + 1;
                orderProductRelationUnPaid.setProductNum(productNum);
                transactionDao.updateOrderProductRelation(orderProductRelationUnPaid);
                return StatusConstant.SUCCESS;
            }
            catch (Exception e) {
                e.printStackTrace();
                return StatusConstant.FAILURE;
            } finally {
                redisLock.unlock();
            }
        }
    }

    @Override
    public String getProductNumFromBuyCart() {
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        if(userInfoDTO==null){
            return "0";
        }
        else
        {
            Integer num = 0;
            List<OrderProductRelationDTO> orderProductRelationDTOS = transactionDao.getUserAllOrderProductFromBuyCart(userInfoDTO.getId());
            for(OrderProductRelationDTO orderProductRelationDTO:orderProductRelationDTOS)
            {
                num = num + orderProductRelationDTO.getProductNum();
            }
            return num.toString();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void minusProduct2BuyCart(String productId, String productSpec) {
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();

        OrderProductRelationDTO orderProductRelationUnPaid = transactionDao.getOrderProductUnPaidInBuyCart(productId,productSpec,userInfoDTO.getId());
        RedisLock redisLock = new RedisLock("OrderProductRelation");
        try
        {
            Integer productNum = orderProductRelationUnPaid.getProductNum()-1;
            orderProductRelationUnPaid.setProductNum(productNum);
            transactionDao.updateOrderProductRelation(orderProductRelationUnPaid);
        }
        catch (Exception e) {
            throw e;
        } finally {
            redisLock.unlock();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOrderFromBuyCart(String orderId) {

        RedisLock redisLock = new RedisLock("businessOrder"+orderId);
        try
        {
            BusinessOrderDTO businessOrderDTO = transactionDao.getBusinessOrderByOrderId(orderId);
            businessOrderDTO.setUpdateDate(new Date());
            businessOrderDTO.setStatus("del");
            transactionDao.updateBusinessOrder(businessOrderDTO);
        }
        catch (Exception e) {
            throw e;
        } finally {
            redisLock.unlock();
        }

    }

}
