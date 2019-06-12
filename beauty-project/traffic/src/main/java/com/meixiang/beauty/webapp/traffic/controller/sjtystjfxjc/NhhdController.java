package com.meixiang.beauty.webapp.traffic.controller.sjtystjfxjc;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.CskyjtglDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.SnjcsjDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//内河航道
@Controller
@RequestMapping(value = "sjtystjfxjc")
public class NhhdController {

    //todo 分叉辅助段基础数据
    //todo monthDate 2019-08
    @RequestMapping(value = "fcfzdjcsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> fcfzdjcsj(@RequestParam String monthDate){
        List<HashMap<String,Object>> ldpjrjtltjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 ldpjrjtltjList

        responseDTO.setResponseData(ldpjrjtltjList);
        return  responseDTO;
    }

    //todo 过河建筑物基础数据
    @RequestMapping(value = "ghjzwjcsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> ghjzwjcsj(){
        List<HashMap<String,Object>> ghjzwjcsjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 ghjzwjcsjList

        responseDTO.setResponseData(ghjzwjcsjList);
        return  responseDTO;
    }

    //todo 航段基础数据
    //todo monthDate 2019-08
    @RequestMapping(value = "hdjcsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> hdjcsj(@RequestParam String monthDate){
        List<HashMap<String,Object>> hdjcsjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 hdjcsjList

        responseDTO.setResponseData(hdjcsjList);
        return  responseDTO;
    }

    //todo 临河设施基础数据
    @RequestMapping(value = "lhssjcsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> lhssjcsj(){
        List<HashMap<String,Object>> lhssjcsjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 lhssjcsjList

        responseDTO.setResponseData(lhssjcsjList);
        return  responseDTO;
    }

    //todo 瓶颈区段基础数据
    @RequestMapping(value = "pjqdjcsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> pjqdjcsj(@RequestParam String luduan,
                                                         @RequestParam String startDate,
                                                         @RequestParam String endDate){
        List<HashMap<String,Object>> pjqdjcsjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 pjqdjcsjList

        responseDTO.setResponseData(pjqdjcsjList);
        return  responseDTO;
    }

    //todo 枢纽基础数据
    @RequestMapping(value = "snjcsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<SnjcsjDataDTO>>> snjcsj(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<SnjcsjDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<SnjcsjDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

}
