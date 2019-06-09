package com.meixiang.beauty.webapp.traffic.controller;

import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.DeviceParamDTO;
import com.meixiang.beauty.webapp.traffic.dto.zhsy.OverallStatisticDataDTO;
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


    //todo 综合统计首页数据
    @RequestMapping(value = "overallStatisticData", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<OverallStatisticDataDTO> getOverallStatisticDataDTO(){
        OverallStatisticDataDTO overallStatisticDataDTO = new OverallStatisticDataDTO();
        ResponseDTO responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 overallStatisticDataDTO

        responseDTO.setResponseData(overallStatisticDataDTO);
        return  responseDTO;
    }





}
