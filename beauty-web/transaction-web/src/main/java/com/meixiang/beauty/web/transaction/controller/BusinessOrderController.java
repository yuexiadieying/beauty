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
public class BusinessOrderController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    @Autowired
    private BuyCartService buyCartService;


    /**
     * 购买某个商品，创建订单
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "createBusinessOrder", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<String> createBusinessOrder(@RequestBody BusinessOrderDTO businessOrderDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<String> responseDTO = new ResponseDTO<>();

        String businessOrderId = transactionService.createBusinessOrder(businessOrderDTO);

        if(businessOrderId.equals(StatusConstant.FAILURE))
        {
            responseDTO.setResult(StatusConstant.FAILURE);
            responseDTO.setErrorInfo("订单创建失败");
        }
        else if(businessOrderId.equals(StatusConstant.NO_USER_ADDRESS))
        {
            responseDTO.setResult(StatusConstant.NO_USER_ADDRESS);
        }
        else
        {
            responseDTO.setResponseData(businessOrderId);
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setErrorInfo("订单创建成功");
        }

        return responseDTO;
    }

    /**
     * 获取某个订单的情况
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "getTrainingBusinessOrder", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<BusinessOrderDTO> getTrainingBusinessOrder(@RequestParam String productId, HttpSession session, HttpServletRequest request) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<BusinessOrderDTO> responseDTO = new ResponseDTO<>();

        //先获取用户的openid
        String openId = WeixinUtil.getOpenId(session,request);
        BusinessOrderDTO businessOrderDTO = new BusinessOrderDTO();
        if(openId==null)
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        else
        {
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setUserOpenid(openId);
            List<UserInfoDTO> userInfoDTOS = userService.getUserInfo(userInfoDTO);
            businessOrderDTO.setBusinessProductId(productId);
            businessOrderDTO.setSysUserId(userInfoDTOS.get(0).getId());
            businessOrderDTO = transactionService.getTrainingBusinessOrder(businessOrderDTO);
            if(businessOrderDTO==null)
            {
                responseDTO.setResult(StatusConstant.FAILURE);
            }
            else
            {
                if(businessOrderDTO.getStatus().equals("0"))
                {
                    responseDTO.setResult(StatusConstant.FAILURE);
                }
                else if(businessOrderDTO.getStatus().equals("1"))
                {
                    responseDTO.setResult(StatusConstant.SUCCESS);
                }
            }
        }
        return responseDTO;
    }


    /**
     * 更改某个订单的状态，可以修改为未支付、待支付等状态
     * 0表示未支付，1表示待支付，2表示已支付，3表示订单失效
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "updateBusinessOrderStatus", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<String> updateBusinessOrderStatus(@RequestBody BusinessOrderDTO businessOrderDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<String> responseDTO = new ResponseDTO<>();
        try
        {
            transactionService.updateBusinessOrderStatus(businessOrderDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }
        catch (Exception e)
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return responseDTO;
    }

    @RequestMapping(value = "updateBusinessOrderAddress", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<String> updateBusinessOrderAddress(@RequestParam String orderId,@RequestParam String orderAddressId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<String> responseDTO = new ResponseDTO<>();
        try
        {
            BusinessOrderDTO businessOrderDTO = transactionService.getBusinessOrderByOrderId(orderId);
            businessOrderDTO.setUserOrderAddressId(orderAddressId);
            transactionService.updateBusinessOrder(businessOrderDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }
        catch (Exception e)
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return responseDTO;
    }

    /**
     * 根据订单状态获取订单列表
     * 0表示未支付，1表示待支付，
     * 2表示已支付且未收货，3表示已支付且已收货，
     * 4表示订单失效
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "businessOrderList", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<List<BusinessOrderDTO>> businessOrderList(@RequestParam String status) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<List<BusinessOrderDTO>> responseDTO = new ResponseDTO<>();
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        //若businessOrderId为""，则用户订单列表是获取所有根据status状态订单，如果不为空，则为指定ID的订单
        List<BusinessOrderDTO> businessOrderDTOList =  transactionService.getBusinessOrderListByUserIdAndStatus(userInfoDTO.getId(),status);
        responseDTO.setResponseData(businessOrderDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 删除用户订单
     *
     * input PageParamDto
     *
     * output ResponseDTO
     *
     */
    @RequestMapping(value = "deleteOrderFromBuyCart", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO deleteOrderFromBuyCart(@RequestParam String orderId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try{
            buyCartService.deleteOrderFromBuyCart(orderId);
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setErrorInfo("删除订单成功");
        }catch (Exception e){
            responseDTO.setErrorInfo("删除订单失败");
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return responseDTO;
    }

}
