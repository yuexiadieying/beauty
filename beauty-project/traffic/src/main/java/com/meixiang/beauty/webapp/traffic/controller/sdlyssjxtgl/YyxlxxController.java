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

//运营线路信息
@Controller
@RequestMapping(value = "sdlyssjxtgl")
public class YyxlxxController {
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

    //todo 物理线路信息 删除
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "wlxlxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> wlxlxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 客运经营线路信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "kyjyxlxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> kyjyxlxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setRequestData(tsjxttfbslinperregService
                .getTsjxttfbslinperregByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbslinperregService.getTsjxttfbslinperregCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 线路标志牌信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "xlbzpxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> xlbzpxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setRequestData(tsjxttfbspermitlincardService
                .getTsjxttfbspermitlincardByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tsjxttfbspermitlincardService.getTsjxttfbspermitlincardCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }


}
