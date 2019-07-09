package com.meixiang.beauty.webapp.traffic.controller;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinTokenDTO;
import com.meixiang.beauty.common.utils.MD5Util;
import com.meixiang.beauty.webapp.traffic.annotation.TrafficLoginRequired;
import com.meixiang.beauty.webapp.traffic.constant.UserLevelEnum;
import com.meixiang.beauty.webapp.traffic.dto.system.UserInfoDTO;
import com.meixiang.beauty.webapp.traffic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    @Autowired
    private MongoTemplate mongoTemplate;

    //todo 用户登录
    @RequestMapping(value = "login", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> login(@RequestBody UserInfoDTO userInfoDTO, HttpSession session){

        ResponseDTO<String> responseDTO = new ResponseDTO<>();

//        Query query = new Query(Criteria.where("loginName").is(userInfoDTO.getLoginName()));
//        UserInfoDTO userInfo = mongoTemplate.findOne(query,UserInfoDTO.class,"userInfo");

        String account = userInfoDTO.getLoginName();
        if (Objects.isNull(account)) {
            account = "";
        }
        String passwd = userInfoDTO.getPassword();
        if (Objects.isNull(passwd)) {
            passwd = "";
        }

        UserInfoDTO res = userService.getUserinfoByParam(account, MD5Util.get32bitMD5(passwd));
        String logintoken = UUID.randomUUID().toString();
        String userInfoStr = (new Gson()).toJson(res);
        session.setAttribute(logintoken, userInfoStr);

        responseDTO.setResponseData(logintoken);
        responseDTO.setResult(StatusConstant.SUCCESS);

//        UserInfoDTO userInfoDTO = new UserInfoDTO();

//        System.out.println(loginMap.get("username"));
//        System.out.println(loginMap.get("password"));
//
//        if(loginMap.get("username").equals("CDJTJ"))
//        {
//            if(loginMap.get("password").equals("123456"))
//            {
//                userInfoDTO.setLoginName(loginMap.get("username").toString());
//                userInfoDTO.setNickname("常德交通局");
//                List<String> userLevelList = new ArrayList<>();
//                userLevelList.add(UserLevelEnum.SJTYSTJFXJC.getValue());
//                userLevelList.add(UserLevelEnum.SDLYSSJXTGL.getValue());
//                userLevelList.add(UserLevelEnum.GLJT.getValue());
//                userLevelList.add(UserLevelEnum.SSLYZGL.getValue());
//                userLevelList.add(UserLevelEnum.ZHGJ.getValue());
//                userLevelList.add(UserLevelEnum.HNSGLSLJSYYSSCXXFWXT.getValue());
//                userLevelList.add(UserLevelEnum.HNSGKQYYMTDWTTLBB.getValue());
//                userLevelList.add(UserLevelEnum.SYAISXT.getValue());
//                userLevelList.add(UserLevelEnum.SKYLWSPXT.getValue());
//                userInfoDTO.setUserLevel(userLevelList);
//
//                String logintoken = UUID.randomUUID().toString();
//                String userInfoStr = (new Gson()).toJson(userInfoDTO);
//                session.setAttribute(logintoken, userInfoStr);
//
//                responseDTO.setResponseData(logintoken);
//                responseDTO.setResult(StatusConstant.SUCCESS);
//            }
//        }
//        else if(loginMap.get("username").equals("CDJTJXXZX"))
//        {
//            if(loginMap.get("password").equals("123456"))
//            {
//                userInfoDTO.setLoginName(loginMap.get("username").toString());
//                userInfoDTO.setNickname("常德交通局基建养护科");
//                List<String> userLevelList = new ArrayList<>();
//                userLevelList.add(UserLevelEnum.SJTYSTJFXJC.getValue());
//                userLevelList.add(UserLevelEnum.SDLYSSJXTGL.getValue());
//                userLevelList.add(UserLevelEnum.GLJT.getValue());
//                userLevelList.add(UserLevelEnum.SSLYZGL.getValue());
//                userLevelList.add(UserLevelEnum.ZHGJ.getValue());
//                userLevelList.add(UserLevelEnum.HNSGLSLJSYYSSCXXFWXT.getValue());
//                userLevelList.add(UserLevelEnum.HNSGKQYYMTDWTTLBB.getValue());
//                userLevelList.add(UserLevelEnum.SYAISXT.getValue());
//                userLevelList.add(UserLevelEnum.SKYLWSPXT.getValue());
//                userInfoDTO.setUserLevel(userLevelList);
//
//                String logintoken = UUID.randomUUID().toString();
//                String userInfoStr = (new Gson()).toJson(userInfoDTO);
//                session.setAttribute(logintoken, userInfoStr);
//
//                responseDTO.setResponseData(logintoken);
//                responseDTO.setResult(StatusConstant.SUCCESS);
//            }
//        }
//        else if(loginMap.get("username").equals("CDJTJJJYH"))
//        {
//            if(loginMap.get("password").equals("123456"))
//            {
//                userInfoDTO.setLoginName(loginMap.get("username").toString());
//                userInfoDTO.setNickname("常德交通局");
//                List<String> userLevelList = new ArrayList<>();
//                userLevelList.add(UserLevelEnum.GLJT.getValue());
//                userLevelList.add(UserLevelEnum.SSLYZGL.getValue());
//                userLevelList.add(UserLevelEnum.HNSGLSLJSYYSSCXXFWXT.getValue());
//                userInfoDTO.setUserLevel(userLevelList);
//
//                String logintoken = UUID.randomUUID().toString();
//                String userInfoStr = (new Gson()).toJson(userInfoDTO);
//                session.setAttribute(logintoken, userInfoStr);
//
//                responseDTO.setResponseData(logintoken);
//                responseDTO.setResult(StatusConstant.SUCCESS);
//            }
//        }
//        else if(loginMap.get("username").equals("CDJTJYSK"))
//        {
//            if(loginMap.get("password").equals("123456"))
//            {
//                userInfoDTO.setLoginName(loginMap.get("username").toString());
//                userInfoDTO.setNickname("常德交通局运输科");
//                List<String> userLevelList = new ArrayList<>();
//                userLevelList.add(UserLevelEnum.SDLYSSJXTGL.getValue());
//                userInfoDTO.setUserLevel(userLevelList);
//
//                String logintoken = UUID.randomUUID().toString();
//                String userInfoStr = (new Gson()).toJson(userInfoDTO);
//                session.setAttribute(logintoken, userInfoStr);
//
//                responseDTO.setResponseData(logintoken);
//                responseDTO.setResult(StatusConstant.SUCCESS);
//            }
//        }
//        else
//        {
//            responseDTO.setResult(StatusConstant.FAILURE);
//        }

        return  responseDTO;
    }

    //todo 用户退出登录
    @RequestMapping(value = "loginOut", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO loginOut(HttpSession session){
        ResponseDTO<UserInfoDTO> responseDTO = new ResponseDTO<>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> headerValue = getHeadersInfo(request);
        String token = headerValue.get("logintoken");
        session.removeAttribute(token);
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
        userService.updateUserInfo(userInfoDTO);


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
