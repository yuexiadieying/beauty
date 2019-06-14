package com.meixiang.beauty.webapp.traffic.controller;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.QsbwbtjsjDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TtlbbDTO;
import com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//水运AIS系统
@Controller
@RequestMapping(value = "syaisxt")
public class SyaisxtController {

    //todo 综合统计
    //todo 包括了船舶动态表，动态历史表和船舶静态表的数据
    @RequestMapping(value = "zhtj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> zhtj(){
        List<HashMap<String,Object>> zhtjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 zhtjList

        responseDTO.setResponseData(zhtjList);
        return  responseDTO;
    }

    //todo 船舶动态表
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cbdtb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cbdtb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 船舶动态历史表
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cbdtlsb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cbdtlsb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 船舶静态表
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cbjtb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cbjtb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

}

