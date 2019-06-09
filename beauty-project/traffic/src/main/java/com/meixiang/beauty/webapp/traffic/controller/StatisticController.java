package com.meixiang.beauty.webapp.traffic.controller;

import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.zhsy.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "statistic")
public class StatisticController {


    //todo 综合统计首页的首栏统计数据
    @RequestMapping(value = "overallStatisticData", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<OverallStatisticDataDTO> getOverallStatisticDataDTO(){
        OverallStatisticDataDTO overallStatisticDataDTO = new OverallStatisticDataDTO();
        ResponseDTO<OverallStatisticDataDTO> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 overallStatisticDataDTO

        responseDTO.setResponseData(overallStatisticDataDTO);
        return  responseDTO;
    }

    //todo 高速公路流量观测
    //todo date参数为2017-08，表示某年某月份的数据
    @RequestMapping(value = "gsglllgcData", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<GsglllgcDataDTO> getGsglllgcDataDTO(@RequestParam String date){
        GsglllgcDataDTO gsglllgcDataDTO = new GsglllgcDataDTO();
        ResponseDTO<GsglllgcDataDTO> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gsglllgcDataDTO


        responseDTO.setResponseData(gsglllgcDataDTO);
        return  responseDTO;
    }

    //todo 调查站信息
    @RequestMapping(value = "dczxxData", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<DczxxDataDTO>> getDczxxData(){
        List<DczxxDataDTO> dczxxDataDTOS = new ArrayList<>();
        ResponseDTO<List<DczxxDataDTO>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 dczxxDataDTOS

        responseDTO.setResponseData(dczxxDataDTOS);
        return  responseDTO;
    }

    //todo 全市泊位
    @RequestMapping(value = "qsbwData", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<QsbwDataDTO> getQsbwData(){
        QsbwDataDTO qsbwDataDTO = new QsbwDataDTO();
        ResponseDTO<QsbwDataDTO> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 dczxxDataDTOS

        responseDTO.setResponseData(qsbwDataDTO);
        return  responseDTO;
    }

    //todo 港口快报吞吐量
    @RequestMapping(value = "gkkbttlData", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<GkkbttlDataDTO>> getGkkbttlData(@RequestParam(required = false) String gkqyName,
                                                     @RequestParam(required = false) String mtdwName){
        List<GkkbttlDataDTO> gkkbttlDataDTOS = new ArrayList<>();
        ResponseDTO<List<GkkbttlDataDTO>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gkkbttlDataDTOS

        responseDTO.setResponseData(gkkbttlDataDTOS);
        return  responseDTO;
    }

    //todo 城市客运
    //todo beginMonth 2019-03
    //todo endMonth 2019-08
    @RequestMapping(value = "cskyData", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<CskyDataDTO>> getCskyData(@RequestParam(required = false) String beginMonth,
                                               @RequestParam(required = false) String endMonth){
        List<CskyDataDTO> cskyDataDTOS = new ArrayList<>();
        ResponseDTO<List<CskyDataDTO>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 cskyDataDTOS

        responseDTO.setResponseData(cskyDataDTOS);
        return  responseDTO;
    }

    //todo 城市水运管理信息
    //todo beginMonth 2019-03
    //todo endMonth 2019-08
    @RequestMapping(value = "cssyglxxData", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<CssyglxxDataDTO>> getCssyglxxData(@RequestParam(required = false) String beginMonth,
                                                       @RequestParam(required = false) String endMonth){
        List<CssyglxxDataDTO> cssyglxxDataDTOS = new ArrayList<>();
        ResponseDTO<List<CssyglxxDataDTO>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 cssyglxxDataDTOS

        responseDTO.setResponseData(cssyglxxDataDTOS);
        return  responseDTO;
    }

}
