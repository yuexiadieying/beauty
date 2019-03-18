/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.web.system.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.SuggestionDto;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.system.UserOrderAddressDTO;
import com.meixiang.beauty.common.utils.OSSObjectTool;
import com.meixiang.beauty.common.utils.ObjectUtils;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.common.web.BaseController;
import com.meixiang.beauty.modules.system.api.SystemService;
import com.meixiang.beauty.modules.system.api.UserOrderAddressService;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.modules.transaction.api.TransactionRunTimeService;
import com.meixiang.beauty.modules.transaction.api.TransactionService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 工具 Controller
 *
 * @author ThinkGem
 * @version 2013-10-17
 */
@Controller
@RequestMapping(value = "system")
public class SystemController extends BaseController {

    @Autowired
    private SystemService systemService;

    @Autowired
    private UserOrderAddressService userOrderAddressService;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRunTimeService transactionRunTimeService;

    /**
     * 上传文件
     * @param file
     * @param
     * @return {"status","success"}
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value="/uploadMediaFile",method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public ResponseDTO UploadFile(@RequestParam("file") MultipartFile file, String fileName) throws UnsupportedEncodingException {
        ResponseDTO response = new ResponseDTO();
        String path=fileName;
        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        try {
            file.transferTo(newFile);
            OSSObjectTool.uploadFileInputStream(path,newFile.length(),new FileInputStream(newFile),OSSObjectTool.BUCKET_MX_PIC);
            response.setErrorInfo("上传成功");
            response.setResult(StatusConstant.SUCCESS);
            response.setResult(path);
        } catch (IOException e) {
            e.printStackTrace();
            response.setErrorInfo("上传失败");
            response.setResult(StatusConstant.FAILURE);
        }
        return response;
    }

    /**
     * 提交建议
     */
    @RequestMapping(value = "suggestionDetail", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO suggestion(@RequestParam String suggestion) {
        ResponseDTO<SuggestionDto> result = new ResponseDTO<>();
        UserInfoDTO userInfoDTO=UserUtils.getUserInfoFromRedis();
        String userId=userInfoDTO.getId();
        result.setResponseData(systemService.addSuggestion(userId,suggestion));
        result.setResult(StatusConstant.SUCCESS);
        return result;
    }

    /**
     * 获取用户默认收货地址信息
     */
    @RequestMapping(value = "userAddressUsedInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserOrderAddressDTO> userAddressUsedInfo() {
        ResponseDTO<UserOrderAddressDTO> result = new ResponseDTO<>();
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        UserOrderAddressDTO userOrderAddress = new UserOrderAddressDTO();
        List<UserOrderAddressDTO> userOrderAddressDTOList = userOrderAddressService.getUserAddressList(userInfoDTO.getId());
        if(userOrderAddressDTOList.size()==0)
        {
            result.setResult(StatusConstant.NO_USER_ADDRESS);
            return result;
        }
        for(UserOrderAddressDTO userOrderAddressDTO:userOrderAddressDTOList)
        {
            if(userOrderAddressDTO.getStatus().equals("1"))
            {
                userOrderAddress = userOrderAddressDTO;
                break;
            }
        }
        result.setResponseData(userOrderAddress);
        result.setResult(StatusConstant.SUCCESS);
        return result;
    }

    /**
     * 获取用户默认收货地址信息
     */
    @RequestMapping(value = "getUserAddressUsedInfoByAddressId", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserOrderAddressDTO> getUserAddressUsedInfoByAddressId(@RequestParam String addressId) {
        ResponseDTO<UserOrderAddressDTO> result = new ResponseDTO<>();
        UserOrderAddressDTO userOrderAddressDTO = userOrderAddressService.getUserAddressUsedInfoByAddressId(addressId);
        result.setResponseData(userOrderAddressDTO);
        result.setResult(StatusConstant.SUCCESS);
        return result;
    }

    /**
     * 获取用户头像和手机号
     */
    @RequestMapping(value = "getUserInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> getUserInfo() {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<UserInfoDTO> responseDTO = new ResponseDTO<>();
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        responseDTO.setResponseData(userInfoDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    /**
     * 根据用户的OpenId获取用户的信息
     */
    @RequestMapping(value = "getUserInfoByOpenId", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> getUserInfoByOpenId(HttpSession session, HttpServletRequest request) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<UserInfoDTO> responseDTO = new ResponseDTO<>();
        String openId = WeixinUtil.getOpenId(session,request);
        List<UserInfoDTO> userInfoDTOList = new ArrayList<>();
        if(openId!=null)
        {
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setUserOpenid(openId);
            userInfoDTOList = userService.getUserInfo(userInfoDTO);
        }

        if(userInfoDTOList.size()>0)
        {
            responseDTO.setResponseData(userInfoDTOList.get(0));
            responseDTO.setResult(StatusConstant.SUCCESS);
        }
        else
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return responseDTO;
    }

    /**
     * 根据用户的OpenId获取用户的信息
     */
    @RequestMapping(value = "getUserOpenIdFromSession", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> getUserOpenIdFromSession(HttpSession session, HttpServletRequest request) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO<String> responseDTO = new ResponseDTO<>();
        String openId = WeixinUtil.getOpenId(session,request);
        if(openId!=null)
        {
            responseDTO.setResponseData(openId);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }
        else
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return responseDTO;
    }


    @RequestMapping(value = "autoMonthlyIncomeCalc", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    void autoMonthlyIncomeCalc(HttpSession session, HttpServletRequest request) {
        transactionRunTimeService.autoMonthlyIncomeCalc();
    }

}
