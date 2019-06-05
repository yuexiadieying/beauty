package com.meixiang.beauty.webapp.traffic.controller;

import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.DeviceParamDTO;
import com.meixiang.beauty.webapp.traffic.service.RobotSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "")
public class RobotController {

    @Autowired
    private RobotSocketService robotSocketService;

    //todo 代码注释
    @RequestMapping(value = "gameBegin", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<DeviceParamDTO>> gameBegin(@RequestParam String gamePlaceId){
        List<DeviceParamDTO> deviceParamDTOS = new ArrayList<>();
        ResponseDTO responseDTO = new ResponseDTO<>();
        deviceParamDTOS =  robotSocketService.getRobotSocketService();
        responseDTO.setResponseData(deviceParamDTOS);
        return  responseDTO;
    }


}
