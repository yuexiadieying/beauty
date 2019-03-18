package com.meixiang.beauty.modules.transaction.api;

import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;

import java.util.List;

/**
 * Created by zbm84 on 2017/5/10.
 */
public interface BuyCartService {

    List<BusinessOrderDTO> getUserUnPayOrderInBuyCart();

    String addOfflineProduct2BuyCart(String productId, String productSpec);

    String getProductNumFromBuyCart();

    void minusProduct2BuyCart(String productId, String productSpec);

    void deleteOrderFromBuyCart(String orderId);

}
