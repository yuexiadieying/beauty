package com.meixiang.beauty.web.transaction.controller;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.system.UserOrderAddressDTO;
import com.meixiang.beauty.common.utils.JedisUtils;
import com.meixiang.beauty.modules.system.api.UserOrderAddressService;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import com.meixiang.beauty.sys.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 微信页面参数获取相关的控制类
 * Created by baoweiw on 2015/7/27.
 */

@Controller
@RequestMapping(value = "transaction")
public class AttentionTeacherController {


    /**
     * 根据用户的所有收货地址
     *
     * input PageParamDto
     *
     * output ResponseDTO<List<ProductDTO>>
     *
     */
    @RequestMapping(value = "getAttentionTeacherStatus", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> getAttentionTeacherStatus() {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        ResponseDTO responseDTO = new ResponseDTO();
        if(!ObjectUtils.isNullOrEmpty(userInfoDTO))
        {
            responseDTO.setResponseData(JedisUtils.get(userInfoDTO.getMobile()+"attentionTeacher"));
        }

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
    @RequestMapping(value = "attentionTeacher", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO attentionTeacher() {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);
        ResponseDTO responseDTO = new ResponseDTO();
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        if(!ObjectUtils.isNullOrEmpty(userInfoDTO))
        {
            JedisUtils.set(userInfoDTO.getMobile()+"attentionTeacher","true", ConfigConstant.logintokenPeriod);
        }
        return responseDTO;
    }
}
