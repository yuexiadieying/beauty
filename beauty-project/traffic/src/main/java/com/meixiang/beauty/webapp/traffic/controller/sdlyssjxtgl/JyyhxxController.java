package com.meixiang.beauty.webapp.traffic.controller.sdlyssjxtgl;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.CskyjtglDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//经营业户信息
@Controller
@RequestMapping(value = "sdlyssjxtgl")
public class JyyhxxController {

    //todo 经营业户基本信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jyyhjbxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> jyyhjbxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路运输经营许可证信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlysjyxkzxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> dlysjyxkzxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路运输经营许可证换证信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlyxjyxkzhzxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> dlyxjyxkzhzxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 经营业户质量信誉考核信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jyyhzlxykhxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> jyyhzlxykhxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 经营业户工商注册信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jyyhgszcxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> jyyhgszcxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 经营业户税务登记信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jyyhswdjxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> jyyhswdjxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路客运站专项信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlkyzzxxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> dlkyzzxxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路货运站专项信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlhyzzxxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> dlhyzzxxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 机动车维修经营业户专项信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jdcwxjyyhzxxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> jdcwxjyyhzxxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 机动车驾驶员培训业户专项信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jdcjsypxyhzxxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> jdcjsypxyhzxxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 经营业户安全生产事故信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jyyhaqscsgxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> jyyhaqscsgxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }


}
