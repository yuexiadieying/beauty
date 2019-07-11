package com.meixiang.beauty.webapp.traffic.controller.sdlyssjxtgl;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.List;
import java.util.Objects;

//从业人员信息
@Controller
@RequestMapping(value = "sdlyssjxtgl")
public class CyryxxController {
    @Autowired
    private TsjxttfptownerService tsjxttfptownerService;

    @Autowired
    private TsjxttfbsjurctcService tsjxttfbsjurctcService;

    @Autowired
    private TsjxttfbscreditcheckService tsjxttfbscreditcheckService;

    @Autowired
    private TsjxttfbsindustryinfoService tsjxttfbsindustryinfoService;

    @Autowired
    private TsjxttfbsappstationService tsjxttfbsappstationService;

    @Autowired
    private TsjxttfbsownertrainextService tsjxttfbsownertrainextService;

    @Autowired
    private TsjxttfbsvectrancertService tsjxttfbsvectrancertService;

    @Autowired
    private TsjxttfbsvecgoodsvecexaService tsjxttfbsvecgoodsvecexaService;

    @Autowired
    private TsjxttfbsvecgoodsService tsjxttfbsvecgoodsService;

    @Autowired
    private TsjxttfbsvecgoodstecgrdService tsjxttfbsvecgoodstecgrdService;

    @Autowired
    private TsjxttfbsvecgoodsvindService tsjxttfbsvecgoodsvindService;

    @Autowired
    private TsjxttfbsvehicleinsuranceService tsjxttfbsvehicleinsuranceService;

    @Autowired
    private TsjxttfptcmpsnService tsjxttfptcmpsnService;

    @Autowired
    private TsjxttfbscmpsnrecordService tsjxttfbscmpsnrecordService;

    @Autowired
    private TsjxttfbsrestudyrecordService tsjxttfbsrestudyrecordService;

    @Autowired
    private TsjxttfbscaseinfoService tsjxttfbscaseinfoService;

    @Autowired
    private TsjxttfbsenbeworrecordService tsjxttfbsenbeworrecordService;

    @Autowired
    private TsjxttfbsdrivercreditService tsjxttfbsdrivercreditService;

    @Autowired
    private TsjxttfbslinperregService tsjxttfbslinperregService;

    @Autowired
    private TsjxttfbspermitlincardService tsjxttfbspermitlincardService;
    //todo 从业人员基本信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryjbxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> cyryjbxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO

        paramDTO.setRequestData(tsjxttfptcmpsnService
                .getTsjxttfptcmpsnByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(), param));
        paramDTO.setTotalCount(tsjxttfptcmpsnService.getTsjxttfptcmpsnCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员资格证信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryzgzxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> cyryzgzxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setRequestData(tsjxttfbsenbeworrecordService
                .getTsjxttfbsenbeworrecordByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbsenbeworrecordService.getTsjxttfbsenbeworrecordCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员服务单位备案信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryfwdwbaxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> cyryfwdwbaxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfbscmpsnrecordService
                .getTsjxttfbscmpsnrecordByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbscmpsnrecordService.getTsjxttfbscmpsnrecordCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员继续教育信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryjxjyxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> cyryjxjyxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setRequestData(tsjxttfbsrestudyrecordService
                .getTsjxttfbsrestudyrecordByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbsrestudyrecordService.getTsjxttfbsrestudyrecordCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员考试信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryksxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> cyryksxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

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
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> cyrywzjfxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setRequestData(tsjxttfbscaseinfoService
                .getTsjxttfbscaseinfoByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbscaseinfoService.getTsjxttfbscaseinfoCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员记分教育信息 删除
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryjfjyxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> cyryjfjyxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

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
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yyjsyzjcxxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setRequestData(tsjxttfbsenbeworrecordService
                .getTsjxttfbsenbeworrecordByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbsenbeworrecordService.getTsjxttfbsenbeworrecordCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 教练员准教车型信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jlyzjcxxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> jlyzjcxxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfbsenbeworrecordService
                .getTsjxttfbsenbeworrecordByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbsenbeworrecordService.getTsjxttfbsenbeworrecordCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员诚信考核信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyrycxkhxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> cyrycxkhxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setRequestData(tsjxttfbsdrivercreditService
                .getTsjxttfbsdrivercreditByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbsdrivercreditService.getTsjxttfbsdrivercreditCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员黑名单信息 删除
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyryhmdxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> cyryhmdxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

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
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> cyryzjblxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setRequestData(tsjxttfbsenbeworrecordService
                .getTsjxttfbsenbeworrecordByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbsenbeworrecordService.getTsjxttfbsenbeworrecordCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 职业技能鉴定信息 删除
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "zyjnjdxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> zyjnjdxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }


}
