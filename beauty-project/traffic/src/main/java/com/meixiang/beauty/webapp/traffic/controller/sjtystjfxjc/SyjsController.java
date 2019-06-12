package com.meixiang.beauty.webapp.traffic.controller.sjtystjfxjc;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//水运建设
@Controller
@RequestMapping(value = "sjtystjfxjc")
public class SyjsController {

    //todo 港口工程设计情况
    @RequestMapping(value = "gkgcsjqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<GkgcsjqkDataDTO>>> gkgcsjqk(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<GkgcsjqkDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<GkgcsjqkDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 航道（航标）工程设计情况
    @RequestMapping(value = "hdgcsjqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HdgcsjqkDataDTO>>> hdgcsjqk(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HdgcsjqkDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HdgcsjqkDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 建设项目基本情况
    @RequestMapping(value = "jsxmjbqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<JsxmjbqkDataDTO>>> jsxmjbqk(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<JsxmjbqkDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<JsxmjbqkDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 交通运输支持系统设计情况
    @RequestMapping(value = "jtyszcxtsjqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<JtyszcxtsjqkDataDTO>>> jtyszcxtsjqk(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<JtyszcxtsjqkDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<JtyszcxtsjqkDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 枢纽工程设计情况
    @RequestMapping(value = "sngcsjqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<SngcsjqkDataDTO>>> sngcsjqk(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<SngcsjqkDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<SngcsjqkDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 相关单位基本情况
    @RequestMapping(value = "xgdwjbqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<XgdwjbqkDataDTO>>> xgdwjbqk(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<XgdwjbqkDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<XgdwjbqkDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 项目工程形象进度情况
    //todo monthDate 2019-08
    @RequestMapping(value = "xmgcxxjdqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> xmgcxxjdqk(@RequestParam String monthDate){
        List<HashMap<String,Object>> xmgcxxjdqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 xmgcxxjdqkList

        responseDTO.setResponseData(xmgcxxjdqkList);
        return  responseDTO;
    }

    //todo 项目资金控制情况数据
    //todo monthDate 2019-08
    @RequestMapping(value = "xmzjkzqksj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> xmzjkzqksj(@RequestParam String monthDate){
        List<HashMap<String,Object>> xmzjkzqksjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 xmzjkzqksjList

        responseDTO.setResponseData(xmzjkzqksjList);
        return  responseDTO;
    }

}
