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

//营运车辆信息
@Controller
@RequestMapping(value = "sdlyssjxtgl")
public class YyclxxController {

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

    //todo 营运车辆基本信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "yycljbxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yycljbxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());

        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfbsvecgoodsService
                .getTsjxttfbsvecgoodsByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(), param));
        paramDTO.setTotalCount(tsjxttfbsvecgoodsService.getTsjxttfbsvecgoodsCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路运输证信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlyszxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> dlyszxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());

        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfbsvectrancertService
                .getTsjxttfbsvectrancertByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbsvectrancertService.getTsjxttfbsvectrancertCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 运营车辆年度审验信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "yyclndsyxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yyclndsyxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());

        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfbsvecgoodsvecexaService
                .getTsjxttfbsvecgoodsvecexaByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbsvecgoodsvecexaService
                .getTsjxttfbsvecgoodsvecexaCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路运输证换证信息 删除
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlyszhzxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> dlyszhzxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 营运车辆技术等级评定信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "yycljsdjpdxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yycljsdjpdxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());

        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfbsvecgoodstecgrdService
                .getTsjxttfbsvecgoodstecgrdByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbsvecgoodstecgrdService.getTsjxttfbsvecgoodstecgrdCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 运营车辆二级维护信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "yyclejwhxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yyclejwhxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());

        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfbsvecgoodsvindService
                .getTsjxttfbsvecgoodsvindByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbsvecgoodsvindService.getTsjxttfbsvecgoodsvindCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 营运车辆承运人责任险缴纳信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "yyclcyrzrxjnxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yyclcyrzrxjnxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());

        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfbsvehicleinsuranceService
                .getTsjxttfbsvehicleinsuranceByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbsvehicleinsuranceService.getTsjxttfbsvehicleinsuranceCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 运营车辆专籍信息 删除
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "yyclzjxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yyclzjxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 营运车辆过户信息 删除
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "yyclghxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yyclghxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }


}
