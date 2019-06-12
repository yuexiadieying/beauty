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

//从业人员信息
@Controller
@RequestMapping(value = "sdlyssjxtgl")
public class CyryxxController {

    //todo 从业人员基本信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryjbxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cyryjbxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员资格证信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryzgzxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cyryzgzxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员服务单位备案信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryfwdwbaxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cyryfwdwbaxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员继续教育信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryjxjyxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cyryjxjyxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员考试信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryksxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cyryksxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员违章记分信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyrywzjfxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cyrywzjfxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员记分教育信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryjfjyxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cyryjfjyxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 营运驾驶员准驾车型信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "yyjsyzjcxxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> yyjsyzjcxxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 教练员准教车型信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jlyzjcxxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> jlyzjcxxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员诚信考核信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyrycxkhxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cyrycxkhxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员黑名单信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryhmdxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cyryhmdxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员证件办理信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryzjblxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cyryzjblxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 职业技能鉴定信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "zyjnjdxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> zyjnjdxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }


}
