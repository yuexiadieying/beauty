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

//道路运政执法信息
@Controller
@RequestMapping(value = "sdlyssjxtgl")
public class DlyzzfxxController {
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

    @Autowired
    private TsjxttfbscasedealwithService tsjxttfbscasedealwithService;

    //todo 道路运政案件处罚立案信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlyzajcflaxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> dlyzajcflaxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO

        paramDTO.setRequestData(tsjxttfbscasedealwithService
                .getTsjxttfbscasedealwithByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tsjxttfbscasedealwithService.getTsjxttfbscasedealwithCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路运政案件处罚决定信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlyzajcfjdxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> dlyzajcfjdxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setRequestData(tsjxttfbscasedealwithService
                .getTsjxttfbscasedealwithByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbscasedealwithService.getTsjxttfbscasedealwithCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路运政案件结案信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlyzajjaxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> dlyzajjaxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setRequestData(tsjxttfbscasedealwithService
                .getTsjxttfbscasedealwithByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbscasedealwithService.getTsjxttfbscasedealwithCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }


}
