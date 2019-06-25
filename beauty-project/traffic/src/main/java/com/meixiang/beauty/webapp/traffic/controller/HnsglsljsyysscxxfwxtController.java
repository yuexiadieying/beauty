package com.meixiang.beauty.webapp.traffic.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.annotation.TrafficLoginRequired;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsAccidentService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsAdvancedDeedService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsAppealReportService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsBusCreditRecordService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsBusReformRecordService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsComplaintService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsCreditReportService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsDriverCreditService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsEntStabilityService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsEquipmentService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsEsignCntRptService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsFacilityService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsGovTransTaskService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsIllegalService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerHonorService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerReformService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerRfrmCntService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerRuleService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsQualityEventService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfBsRestudyrecordService;
import com.meixiang.beauty.webapp.traffic.service.hnsglsljsyysscxxfwxt.TScxyTfPtPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Objects;

//湖南省公路水路建设与运输市场信息服务系统
@Controller
@RequestMapping(value = "hnsglsljsyysscxxfwxt")
public class HnsglsljsyysscxxfwxtController {

    @Autowired
    private TScxyTfBsAccidentService tScxyTfBsAccidentService;

    @Autowired
    private TScxyTfBsAdvancedDeedService tScxyTfBsAdvancedDeedService;

    @Autowired
    private TScxyTfBsAppealReportService tScxyTfBsAppealReportService;

    @Autowired
    private TScxyTfBsBusCreditRecordService tScxyTfBsBusCreditRecordService;

    @Autowired
    private TScxyTfBsBusReformRecordService tScxyTfBsBusReformRecordService;

    @Autowired
    private TScxyTfBsComplaintService tScxyTfBsComplaintService;

    @Autowired
    private TScxyTfBsCreditReportService tScxyTfBsCreditReportService;

    @Autowired
    private TScxyTfBsDriverCreditService tScxyTfBsDriverCreditService;

    @Autowired
    private TScxyTfBsEntStabilityService tScxyTfBsEntStabilityService;

    @Autowired
    private TScxyTfBsEquipmentService tScxyTfBsEquipmentService;

    @Autowired
    private TScxyTfBsEsignCntRptService tScxyTfBsEsignCntRptService;

    @Autowired
    private TScxyTfBsFacilityService tScxyTfBsFacilityService;

    @Autowired
    private TScxyTfBsGovTransTaskService tScxyTfBsGovTransTaskService;

    @Autowired
    private TScxyTfBsIllegalService tScxyTfBsIllegalService;

    @Autowired
    private TScxyTfBsOwnerHonorService tScxyTfBsOwnerHonorService;

    @Autowired
    private TScxyTfBsOwnerReformService tScxyTfBsOwnerReformService;

    @Autowired
    private TScxyTfBsOwnerRfrmCntService tScxyTfBsOwnerRfrmCntService;

    @Autowired
    private TScxyTfBsOwnerRuleService tScxyTfBsOwnerRuleService;

    @Autowired
    private TScxyTfBsQualityEventService tScxyTfBsQualityEventService;

    @Autowired
    private TScxyTfPtPersonService tScxyTfPtPersonService;

    @Autowired
    private TScxyTfBsRestudyrecordService tScxyTfBsRestudyrecordService;

    //todo 交通责任事故表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jtzrsgb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> jtzrsgb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsAccidentService
                .getTScxyTfBsAccidentByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));

        paramDTO.setTotalCount(tScxyTfBsAccidentService.getTScxyTfBsAccidentCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 车辆信用考核表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "clxykhb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> clxykhb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsBusCreditRecordService
                .getTScxyTfBsBusCreditRecordByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsBusCreditRecordService.getTScxyTfBsBusCreditRecordCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 车辆责令整改表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "clzlzgb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> clzlzgb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsBusReformRecordService
                .getTScxyTfBsBusReformRecordByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize()));
        paramDTO.setTotalCount(tScxyTfBsBusReformRecordService.getTScxyTfBsBusReformRecordCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 社会投诉表
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "shtsb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> shtsb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsComplaintService
                .getTScxyTfBsComplaintByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsComplaintService.getTScxyTfBsComplaintCount(param));
        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 业户考核申报表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "yhkhsbb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yhkhsbb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsCreditReportService
                .getTScxyTfBsCreditReportByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsCreditReportService.getTScxyTfBsCreditReportCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 从业人员考核签注表
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "cyrykhqzb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> cyrykhqzb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsDriverCreditService
                .getTScxyTfBsDriverCreditByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsDriverCreditService.getTScxyTfBsDriverCreditCount(param));
        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 违规上访表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "wgsfb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> wgsfb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsEntStabilityService
                .getTScxyTfBsEntStabilityByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsEntStabilityService.getTScxyTfBsEntStabilityCount(param));
        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 设备档案表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "sbdab", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> sbdab(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsEquipmentService
                .getTScxyTfBsEquipmentByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsEquipmentService.getTScxyTfBsEquipmentCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 电子签章申报内容表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dzqzsbnrb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> dzqzsbnrb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsEsignCntRptService
                .getTScxyTfBsEsignCntRptByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsEsignCntRptService.getTScxyTfBsEsignCntRptCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 设施档案表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "ssdab", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> ssdab(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsFacilityService
                .getTScxyTfBsFacilityByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsEquipmentService.getTScxyTfBsEquipmentCount(param));
        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 政府运输任务表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "zfysrwb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> zfysrwb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsGovTransTaskService
                .getTScxyTfBsGovTransTaskByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsGovTransTaskService.getTScxyTfBsGovTransTaskCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 经营违章表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jywzb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> jywzb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsIllegalService
                .getTScxyTfBsIllegalByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsIllegalService.getTScxyTfBsIllegalCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 企业荣誉表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "qyryb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> qyryb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsOwnerHonorService
                .getTScxyTfBsOwnerHonorByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsOwnerHonorService.getTScxyTfBsOwnerHonorCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 业户责令整改表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "yhzlzgb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yhzlzgb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsOwnerReformService
                .getTScxyTfBsOwnerReformByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsOwnerReformService.getTScxyTfBsOwnerReformCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 整改内容表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "zgnrb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> zgnrb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsOwnerRfrmCntService
                .getTScxyTfBsOwnerRfrmCntByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsOwnerRfrmCntService.getTScxyTfBsOwnerRfrmCntCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 规章制度表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "gzzdb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> gzzdb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsOwnerRuleService
                .getTScxyTfBsOwnerRuleByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsOwnerRuleService.getTScxyTfBsOwnerRuleCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 恶性服务事件表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "exfwsjb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> exfwsjb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsQualityEventService
                .getTScxyTfBsQualityEventByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsQualityEventService.getTScxyTfBsQualityEventCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 继续教育记录 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jxjyjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> jxjyjl(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setResponseData(tScxyTfBsRestudyrecordService.getTScxyTfBsRestudyrecordByPageable(
                pageParamDTO.getPageStartNo(),
                pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));

        paramDTO.setTotalCount(tScxyTfBsRestudyrecordService.getTScxyTfBsRestudyrecordCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 员工信息表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "ygxxb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> ygxxb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfPtPersonService
                .getTScxyTfPtPersonByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfPtPersonService.getTScxyTfPtPersonCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 先进事迹表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "xjsjb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> xjsjb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsAdvancedDeedService
                .getTScxyTfBsAdvancedDeedByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsAdvancedDeedService.getTScxyTfBsAdvancedDeedCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 申诉主表 待联调
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "sszb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> sszb(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();

        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" : String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tScxyTfBsAppealReportService
                .getTScxyTfBsAppealReportByPageable(
                        pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(),param));
        paramDTO.setTotalCount(tScxyTfBsAppealReportService.getTScxyTfBsAppealReportCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }


}
