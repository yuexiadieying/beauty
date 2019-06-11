package com.meixiang.beauty.webapp.traffic.controller.sjtystjfxjc;

import com.meixiang.beauty.common.dto.system.ResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//公路交调
@Controller
@RequestMapping(value = "sjtystjfxjc")
public class GljdController {

    //todo 路段平均日交通量统计
    @RequestMapping(value = "ldpjrjtltj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> ldpjrjtltj(@RequestParam String luduan,
                                                         @RequestParam String startDate,
                                                         @RequestParam String endDate){
        List<HashMap<String,Object>> ldpjrjtltjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 ldpjrjtltjList

        responseDTO.setResponseData(ldpjrjtltjList);
        return  responseDTO;
    }

    //todo 小时交通记录量
    @RequestMapping(value = "xsjtjll", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> xsjtjll(){
        List<HashMap<String,Object>> xsjtjllList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 xsjtjllList

        responseDTO.setResponseData(xsjtjllList);
        return  responseDTO;
    }

    //todo 日交通量统计
    @RequestMapping(value = "rjtltj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> rjtltj(){
        List<HashMap<String,Object>> rjtltjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 rjtltjList

        responseDTO.setResponseData(rjtltjList);
        return  responseDTO;
    }



}
