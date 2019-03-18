package com.meixiang.beauty.web.transaction.controller;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.transaction.*;
import com.meixiang.beauty.common.utils.JedisUtils;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.modules.transaction.api.BuyCartService;
import com.meixiang.beauty.modules.transaction.api.TransactionService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 微信页面参数获取相关的控制类
 * Created by baoweiw on 2015/7/27.
 */

@Controller
@RequestMapping(value = "transaction")
public class BuyCartController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private BuyCartService buyCartService;

    /**
     * 将货品加入用户的购物车
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "addProduct2BuyCart", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO addProduct2BuyCart(@RequestParam String productId,@RequestParam String productSpec) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        String result = buyCartService.addOfflineProduct2BuyCart(productId,productSpec);
        responseDTO.setResult(result);
        return responseDTO;
    }

    @RequestMapping(value = "minusProduct2BuyCart", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO minusProduct2BuyCart(@RequestParam String productId,@RequestParam String productSpec) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try
        {
            buyCartService.minusProduct2BuyCart(productId,productSpec);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }
        catch (Exception e)
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return responseDTO;
    }

    /**
     * 获取用户购物车中的商品总数
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "getProductNumFromBuyCart", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<String> getProductNumFromBuyCart() {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<String> responseDTO = new ResponseDTO<>();
        try
        {
            responseDTO.setResponseData(buyCartService.getProductNumFromBuyCart());
            responseDTO.setResult(StatusConstant.SUCCESS);
        }
        catch (Exception e)
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return responseDTO;
    }


    /**
     * 获取用户购物车中的信息
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "buyCart", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<List<BusinessOrderDTO>> buyCart() {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<List<BusinessOrderDTO>> responseDTO = new ResponseDTO<>();
        List<BusinessOrderDTO> businessOrderDTOList = buyCartService.getUserUnPayOrderInBuyCart();
        responseDTO.setResponseData(businessOrderDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

}
