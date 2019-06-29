package com.meixiang.beauty.webapp.traffic.controller;

import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.service.zhgj.TBusLineService;
import com.meixiang.beauty.webapp.traffic.service.zhgj.TBusLineStationRefService;
import com.meixiang.beauty.webapp.traffic.service.zhgj.TBusStationService;
import com.meixiang.beauty.webapp.traffic.service.zhgj.TBusTopicGisHdService;
import com.meixiang.beauty.webapp.traffic.service.zhgj.TBusTopicGisService;
import com.meixiang.beauty.webapp.traffic.service.zhgj.TBusVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

//智慧公交
@Controller
@RequestMapping(value = "zhgj")
public class ZhgjController {

    @Autowired
    private TBusLineService tBusLineService;

    @Autowired
    private TBusLineStationRefService tBusLineStationRefService;

    @Autowired
    private TBusStationService tBusStationService;

    @Autowired
    private TBusTopicGisHdService tBusTopicGisHdService;

    @Autowired
    private TBusTopicGisService tBusTopicGisService;

    @Autowired
    private TBusVehicleService tBusVehicleService;

    //todo 基础信息
    @RequestMapping(value = "jcxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String,Object>>> jcxx(@RequestParam String searchParam){
        List<Map<String,Object>> jcxxList = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 fhxjcglkrsqkList
        jcxxList = tBusLineService.getTBusLineBasiceInfo(searchParam);

        responseDTO.setResponseData(jcxxList);
        return  responseDTO;
    }

    //todo 运营状态信息
    @RequestMapping(value = "yyztxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String,Object>>> yyztxx(@RequestParam String searchParam){
        List<Map<String,Object>> yyztxxList = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 fhxjcglkrsqkList
        yyztxxList = tBusLineStationRefService.getTBusLineStationBasicInfo(searchParam);

        responseDTO.setResponseData(yyztxxList);
        return  responseDTO;
    }

    //todo 公交车线路信息
    @RequestMapping(value = "gjcxluxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String,Object>>> gjcxluxx(@RequestParam String searchParam,
                                                   @RequestParam Boolean isLineName
    ){
        List<Map<String,Object>> gjcxluxx = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 fhxjcglkrsqkList
        if (isLineName) {
            gjcxluxx = tBusLineStationRefService
                    .getTBusLineStationPositionInfoByLineName(searchParam);
        } else {
            gjcxluxx = tBusLineStationRefService
                    .getTBusLineStationPositionInfoByLicensePlate(searchParam);
        }

        responseDTO.setResponseData(gjcxluxx);
        return  responseDTO;
    }

    //todo 车辆位置信息
    @RequestMapping(value = "gjcxwzxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String,Object>>> gjcxwzxx(@RequestParam String searchParam){
        List<Map<String,Object>> gjcxwzxx = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 fhxjcglkrsqkList
        gjcxwzxx = tBusTopicGisService.getTBusTopicGisInfo(searchParam);

        responseDTO.setResponseData(gjcxwzxx);
        return  responseDTO;
    }

    //todo 运营信息
    @RequestMapping(value = "yyxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String,Object>>> yyxx(@RequestParam String searchParam){
        List<Map<String,Object>> yyxxList = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 yyxxList

        responseDTO.setResponseData(yyxxList);
        return  responseDTO;
    }

    //todo 安全管理信息
    @RequestMapping(value = "aqglxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String,Object>>> aqglxx(@RequestParam String searchParam){
        List<Map<String,Object>> aqglxxList = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 aqglxxList

        responseDTO.setResponseData(aqglxxList);
        return  responseDTO;
    }

}
