package com.meixiang.beauty.webapp.traffic.controller.sjtystjfxjc;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.CskyjtglDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//城市客运
@Controller
@RequestMapping(value = "sjtystjfxjc")
public class TestController {

    //todo 城市（县城）客运交通管理
    @RequestMapping(value = "cskyjtgl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<CskyjtglDataDTO>>> cskyjtgl(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<CskyjtglDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<CskyjtglDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 城市客运主要统计指标快速年报信息
    @RequestMapping(value = "cskyzytjzbksnbxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> cskyzytjzbksnbxx(){
        List<HashMap<String,Object>> cskyzytjzbksnbxxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 cskyzytjzbksnbxxList

        responseDTO.setResponseData(cskyzytjzbksnbxxList);
        return  responseDTO;
    }

    //todo 出租汽车运营情况
    @RequestMapping(value = "czqcyyqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> czqcyyqk(@RequestParam String startDate,
                                                       @RequestParam String endDate){
        List<HashMap<String,Object>> czqcyyqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 czqcyyqkList

        responseDTO.setResponseData(czqcyyqkList);
        return  responseDTO;
    }



}
