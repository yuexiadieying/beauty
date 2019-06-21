package com.meixiang.beauty.webapp.traffic.controller;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.webapp.traffic.annotation.TrafficLoginRequired;
import com.meixiang.beauty.webapp.traffic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

//智慧公交
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    //todo 用户登录
    @RequestMapping(value = "login", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> login(@RequestBody HashMap<String,Object> loginMap, HttpSession session){

        ResponseDTO<String> responseDTO = new ResponseDTO<>();

        UserInfoDTO userInfoDTO = new UserInfoDTO();

        System.out.println(loginMap.get("username"));
        System.out.println(loginMap.get("password"));

        userInfoDTO.setLoginName(loginMap.get("username").toString());
        userInfoDTO.setPassword(loginMap.get("password").toString());

        String logintoken = UUID.randomUUID().toString();

        String userInfoStr = (new Gson()).toJson(userInfoDTO);
        session.setAttribute(logintoken, userInfoStr);

        responseDTO.setResponseData(logintoken);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return  responseDTO;
    }

    //todo 获取用户信息的接口
    @RequestMapping(value = "getUserInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO<UserInfoDTO> getUserInfo(HttpSession session){

        ResponseDTO<UserInfoDTO> responseDTO = new ResponseDTO<>();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        Map<String, String> headerValue = getHeadersInfo(request);

        String token = headerValue.get("logintoken");

        String userInfoStr = userService.getUserInfoFromToken(token,session);

        UserInfoDTO userInfoDTO = (new Gson()).fromJson(userInfoStr,UserInfoDTO.class);

        responseDTO.setResponseData(userInfoDTO);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return  responseDTO;
    }

    //todo 储存用户的信息
    @RequestMapping(value = "saveUserInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO saveUserInfo(@RequestBody UserInfoDTO userInfoDTO){

        ResponseDTO responseDTO = new ResponseDTO<>();

        //todo 存储用户的信息



        responseDTO.setResult(StatusConstant.SUCCESS);
        return  responseDTO;
    }

    private static Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

}
