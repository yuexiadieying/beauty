package com.meixiang.beauty.webapp.traffic.controller.gljt;

import com.meixiang.beauty.common.dto.system.ResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//高速公路流量观测
@Controller
@RequestMapping(value = "gljt")
public class GsglllgcController {

    //todo 高速公路流量观测综合统计
    //todo choiceType为"luxian"表示统计路线，为"gljg"表示统计管理机构，为"dcz"表示统计调查中，为"sb"表示为设备，为"gcbfb"表示为跟车百分比，为"sjzyl"表示为时间占有率,
    // todo 为"llxx"表示统计流量信息,特别注意，当choiceType为"llxx"的时候，需要带入startDate和endDate两个参数
    @RequestMapping(value = "gsglllgczhtj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gsglllgczhtj(@RequestParam String choiceType,
                                                           @RequestParam(required = false) String startDate,
                                                           @RequestParam(required = false) String endDate){
        List<HashMap<String,Object>> gsglllgczhtjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gsglllgczhtjList

        responseDTO.setResponseData(gsglllgczhtjList);
        return  responseDTO;
    }

    //todo 路线信息
    @RequestMapping(value = "lxxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> lxxx(){
        List<HashMap<String,Object>> lxxxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 lxxxList

        responseDTO.setResponseData(lxxxList);
        return  responseDTO;
    }

    //todo 管理机构信息
    @RequestMapping(value = "gljgxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gljgxx(){
        List<HashMap<String,Object>> gljgxxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gljgxxList

        responseDTO.setResponseData(gljgxxList);
        return  responseDTO;
    }

    //todo 调查站信息
    @RequestMapping(value = "dczxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> dczxx(){
        List<HashMap<String,Object>> dczxxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 dczxxList

        responseDTO.setResponseData(dczxxList);
        return  responseDTO;
    }

    //todo 设备信息
    @RequestMapping(value = "sbxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> sbxx(){
        List<HashMap<String,Object>> sbxxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 sbxxList

        responseDTO.setResponseData(sbxxList);
        return  responseDTO;
    }

    //todo 流量信息
    @RequestMapping(value = "llxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,List<HashMap<String,Object>>>>> llxx(){
        List<HashMap<String,List<HashMap<String,Object>>>> llxxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,List<HashMap<String,Object>>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 llxxList

        responseDTO.setResponseData(llxxList);
        return  responseDTO;
    }

}
