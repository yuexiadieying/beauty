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

//企业法人财务状况
@Controller
@RequestMapping(value = "sjtystjfxjc")
public class QyfrcwzkController {

    //todo 城市客运法人企业财务状况
    //todo yearDate 2019
    @RequestMapping(value = "cskyfrqycwzk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> cskyfrqycwzk(@RequestParam String yearDate){
        List<HashMap<String,Object>>cskyfrqycwzkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 cskyfrqycwzkList

        responseDTO.setResponseData(cskyfrqycwzkList);
        return  responseDTO;
    }

    //todo 港口法人企业财务状况
    //todo yearDate 2019
    @RequestMapping(value = "gkfrqycwzk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gkfrqycwzk(@RequestParam String yearDate){
        List<HashMap<String,Object>> gkfrqycwzkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gkfrqycwzkList

        responseDTO.setResponseData(gkfrqycwzkList);
        return  responseDTO;
    }

    //todo 公路运输法人企业财务状况
    //todo yearDate 2019
    @RequestMapping(value = "glysfrqycwzk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glysfrqycwzk(@RequestParam String yearDate){
        List<HashMap<String,Object>> glysfrqycwzkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glysfrqycwzkList

        responseDTO.setResponseData(glysfrqycwzkList);
        return  responseDTO;
    }

    //todo 水路运输法人企业财务状况
    //todo yearDate 2019
    @RequestMapping(value = "slysfrqycwzk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> slysfrqycwzk(@RequestParam String yearDate){
        List<HashMap<String,Object>> slysfrqycwzkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 slysfrqycwzkList

        responseDTO.setResponseData(slysfrqycwzkList);
        return  responseDTO;
    }

}
