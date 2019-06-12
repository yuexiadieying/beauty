package com.meixiang.beauty.webapp.traffic.controller.sdlyssjxtgl;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

//道路运政执法信息
@Controller
@RequestMapping(value = "sdlyssjxtgl")
public class DlyzzfxxController {

    //todo 道路运政案件处罚立案信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlyzajcflaxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> dlyzajcflaxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路运政案件处罚决定信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlyzajcfjdxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> dlyzajcfjdxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路运政案件结案信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlyzajjaxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> dlyzajjaxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }


}
