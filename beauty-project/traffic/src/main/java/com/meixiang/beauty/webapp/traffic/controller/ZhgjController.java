package com.meixiang.beauty.webapp.traffic.controller;

import com.meixiang.beauty.common.dto.system.ResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//智慧公交
@Controller
@RequestMapping(value = "zhgj")
public class ZhgjController {

    //todo 基础信息
    @RequestMapping(value = "jcxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> jcxx(@RequestParam String searchParam){
        List<HashMap<String,Object>> jcxxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 fhxjcglkrsqkList

        responseDTO.setResponseData(jcxxList);
        return  responseDTO;
    }

    //todo 运营状态信息
    @RequestMapping(value = "yyztxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> yyztxx(@RequestParam String searchParam){
        List<HashMap<String,Object>> yyztxxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 fhxjcglkrsqkList

        responseDTO.setResponseData(yyztxxList);
        return  responseDTO;
    }

    //todo 运营信息
    @RequestMapping(value = "yyxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> yyxx(@RequestParam String searchParam){
        List<HashMap<String,Object>> yyxxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 yyxxList

        responseDTO.setResponseData(yyxxList);
        return  responseDTO;
    }

    //todo 安全管理信息
    @RequestMapping(value = "aqglxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> aqglxx(@RequestParam String searchParam){
        List<HashMap<String,Object>> aqglxxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 aqglxxList

        responseDTO.setResponseData(aqglxxList);
        return  responseDTO;
    }

}
