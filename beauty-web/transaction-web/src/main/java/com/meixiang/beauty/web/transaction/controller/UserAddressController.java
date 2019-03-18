package com.meixiang.beauty.web.transaction.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.system.UserOrderAddressDTO;
import com.meixiang.beauty.modules.system.api.UserOrderAddressService;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 微信页面参数获取相关的控制类
 * Created by baoweiw on 2015/7/27.
 */

@Controller
@RequestMapping(value = "transaction")
public class UserAddressController {

    @Autowired
    private UserOrderAddressService userOrderAddressService;

    /**
     * 根据用户的所有收货地址
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "userAddressList", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<List<UserOrderAddressDTO>> userAddressList() {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        ResponseDTO<List<UserOrderAddressDTO>> responseDTO = new ResponseDTO<>();
        List<UserOrderAddressDTO> userOrderAddressDTOList =  userOrderAddressService.getUserAddressList(userInfoDTO.getId());
        responseDTO.setResponseData(userOrderAddressDTOList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 根据用户id查询收货地址
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "findUserAddressById", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserOrderAddressDTO> findUserAddressById(@RequestParam String addressId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<UserOrderAddressDTO> responseDTO = new ResponseDTO<>();
        UserOrderAddressDTO userOrderAddressDTO =  userOrderAddressService.findUserAddressById(addressId);
        responseDTO.setResponseData(userOrderAddressDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 根据用户的所有收货地址
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "addUserAddress", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO addUserAddress(@RequestBody UserOrderAddressDTO userOrderAddressDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try{
            userOrderAddressDTO.setId(UUID.randomUUID().toString());
            userOrderAddressService.addUserAddress(userOrderAddressDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setErrorInfo("添加用户地址成功");
        }catch (Exception e)
        {
            responseDTO.setResult(StatusConstant.FAILURE);
            responseDTO.setErrorInfo("添加用户地址失败");
        }
        return responseDTO;
    }

    /**
     * 根据用户的所有收货地址
     *
     * input PageParamDto
     *
     * output ResponseDTO
     *
     */
    @RequestMapping(value = "updateUserAddress", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO updateUserAddress(@RequestBody UserOrderAddressDTO userOrderAddressDTO) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try{
            userOrderAddressService.updateUserAddress(userOrderAddressDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setErrorInfo("更新用户收货地址成功");
        }catch (Exception e){
            responseDTO.setErrorInfo("更新用户收货地址失败");
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return responseDTO;
    }


    /**
     * 根据用户Id删除
     *
     * input PageParamDto
     *
     * output ResponseDTO
     *
     */
    @RequestMapping(value = "deleteUserAddress", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO deleteUserAddress(@RequestParam String addressId) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO<>();
        try{
            userOrderAddressService.deleteUserAddress(addressId);
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setErrorInfo("删除收货地址成功");
        }catch (Exception e){
            responseDTO.setErrorInfo("删除收货地址失败");
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return responseDTO;
    }

}
