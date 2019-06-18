package com.meixiang.beauty.webapp.traffic.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

//智慧公交
@Controller
@RequestMapping(value = "user")
public class UserController {

    //todo 用户登录
    @RequestMapping(value = "login", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> jcxx(@RequestBody HashMap<String,Object> loginMap){

        ResponseDTO<String> responseDTO = new ResponseDTO<>();

        System.out.println(loginMap.get("username"));
        System.out.println(loginMap.get("password"));

        String logintoken = UUID.randomUUID().toString();
        responseDTO.setResponseData(logintoken);

        responseDTO.setResult(StatusConstant.SUCCESS);
        return  responseDTO;
    }


}
