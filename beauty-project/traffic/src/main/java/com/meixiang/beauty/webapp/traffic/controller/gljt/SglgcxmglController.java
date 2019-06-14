package com.meixiang.beauty.webapp.traffic.controller.gljt;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.DlkhzczjqkDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

//市公路工程项目管理
@Controller
@RequestMapping(value = "gljt")
public class SglgcxmglController {

    //todo 项目信息表
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "xmxxb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> xmxxb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 项目列表
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "xmlb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> xmlb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 项目周期
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "xmzq", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> xmzq(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 标段周期
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "bdzq", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> bdzq(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 标段列表
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "bdlb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> bdlb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 人员登记
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "rydj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> rydj(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 单位管理
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dwgl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> dwgl(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 质量台账
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "zltz", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> zltz(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 施工图审批
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "sgtsp", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> sgtsp(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 交工信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jiaotongxinxi", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> jiaotongxinxi(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 竣工信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jungongxinxi", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> jungongxinxi(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 台账修正（工程部分）
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "gzxzgcbf", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> gzxzgcbf(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 台账修正（台账信息）
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "tzxztzxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> tzxztzxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 台账修正
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "tzxz", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> tzxz(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 工程台账（工程部分）
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "gctzgcbf", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> gctzgcbf(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 工程台账（台账信息）
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "gctztzxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> gctztzxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 变更方案
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "bgfa", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> bgfa(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 变更申请
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "bgsq", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> bgsq(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }


}
