package com.meixiang.beauty.webapp.traffic.controller;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import com.meixiang.beauty.webapp.traffic.annotation.TrafficLoginRequired;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.QsbwbtjsjDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TtlbbDTO;
import com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb.HlsgkqyymtdwttlbbHomePageService;
import com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb.TGkmtBerthsService;
import com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb.TGkmtEnterprisesService;
import com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb.TGkmtEnterpriseusersService;
import com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb.TGkmtPortregionsService;
import com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb.TGkmtPortsService;
import com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb.TGkmtQuickreportdataService;
import com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb.TGkmtReportdataService;
import com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb.TGkmtUnitsService;
import com.meixiang.beauty.webapp.traffic.service.hlsgkqyymtdwttlbb.TGkmtUnitusersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//湖南省港口企业与码头单位吞吐量表
@Controller
@RequestMapping(value = "hlsgkqyymtdwttlbb")
public class HnsgkqyymtdwttlbbController {

    @Autowired
    private TGkmtBerthsService tGkmtBerthsService;

    @Autowired
    private TGkmtEnterprisesService tGkmtEnterprisesService;

    @Autowired
    private TGkmtEnterpriseusersService tGkmtEnterpriseusersService;

    @Autowired
    private TGkmtPortregionsService tGkmtPortregionsService;

    @Autowired
    private TGkmtPortsService tGkmtPortsService;

    @Autowired
    private TGkmtQuickreportdataService tGkmtQuickreportdataService;

    @Autowired
    private TGkmtReportdataService tGkmtReportdataService;

    @Autowired
    private TGkmtUnitsService tGkmtUnitsService;

    @Autowired
    private TGkmtUnitusersService tGkmtUnitusersService;

    @Autowired
    private HlsgkqyymtdwttlbbHomePageService homePageService;

    //todo 湖南省港口企业与码头单位吞吐量报表首页
    @RequestMapping(value = "ttlbb", method = {RequestMethod.POST, RequestMethod.GET})
    @TrafficLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<TtlbbDTO>> getTtlbbDTO(){
        List<TtlbbDTO> ttlbbDTOList = new ArrayList<>();
        ResponseDTO<List<TtlbbDTO>> responseDTO = new ResponseDTO<>();

        ttlbbDTOList = homePageService.getHomePageInfo();

        responseDTO.setResponseData(ttlbbDTOList);
        return  responseDTO;
    }


    //todo 全市泊位表中统计数据，包括了累计港口泊位数、增加的报告期、报废的报告期
    @RequestMapping(value = "qsbwbtjsj", method = {RequestMethod.POST, RequestMethod.GET})
    @TrafficLoginRequired
    public
    @ResponseBody
    ResponseDTO<QsbwbtjsjDTO> getQsbwbtjsjDTO(){
        QsbwbtjsjDTO qsbwbtjsjDTO = new QsbwbtjsjDTO();
        ResponseDTO<QsbwbtjsjDTO> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 qsbwbtjsjDTO

        responseDTO.setResponseData(qsbwbtjsjDTO);
        return  responseDTO;
    }

    //todo 全市泊位状况 待测试
    //todo 港口企业 gkqy
    //todo 码头单位 mtdw
    //todo startDate 开始日期 2019-04-23
    //todo endDate 结束日期 2019-05-23
    @RequestMapping(value = "qsbwzk", method = {RequestMethod.POST, RequestMethod.GET})
    @TrafficLoginRequired
    public
    @ResponseBody
    ResponseDTO<List<Map<String, Object>>> getQsbwzkDTO(@RequestParam String gkqy,
                                              @RequestParam String mtdw,
                                              @RequestParam String startDate,
                                              @RequestParam String endDate){
        List<Map<String, Object>> qsbwzkDTOList = new ArrayList<>();
        ResponseDTO<List<Map<String, Object>>> responseDTO = new ResponseDTO<>();

        qsbwzkDTOList = tGkmtBerthsService.getTGkmtBerthsByPageable(0, 10000, gkqy, mtdw, startDate, endDate);

        responseDTO.setResponseData(qsbwzkDTOList);
        return  responseDTO;
    }

    //todo 港口企业和码头单位名录 待测试
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "gkqyml", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String, Object>>>> getGkqymlDTO(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String, Object>> gkqymlDTOList = new ArrayList<>();
        PageParamDTO<List<Map<String, Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String, Object>>>> responseDTO = new ResponseDTO<>();

        gkqymlDTOList = tGkmtEnterprisesService.getTGkmtEnterprisesByPageable(
                (pageParamDTO.getPageStartNo()-1)*pageParamDTO.getPageSize(),
                pageParamDTO.getPageStartNo()*pageParamDTO.getPageSize());

        paramDTO.setTotalCount(tGkmtEnterprisesService.getTGkmtEnterprisesCount());
        paramDTO.setResponseData(gkqymlDTOList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 企业操作人员 待测试
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "qyczry", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String, Object>>>> getQyczryDTO(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String, Object>> qyczryDTOS = new ArrayList<>();
        PageParamDTO<List<Map<String, Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String, Object>>>> responseDTO = new ResponseDTO<>();

        qyczryDTOS = tGkmtEnterpriseusersService.getTGkmtEnterpriseusersByPageable(
                (pageParamDTO.getPageStartNo()-1)*pageParamDTO.getPageSize(),
                pageParamDTO.getPageStartNo()*pageParamDTO.getPageSize());

        paramDTO.setTotalCount(tGkmtEnterpriseusersService.getTGkmtEnterpriseusersCount());
        paramDTO.setResponseData(qyczryDTOS);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 全省港区代表码 待测试
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "qsgqdbm", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String, Object>>>> getQsgqdbmDTO(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String, Object>> qsgqdbmDTOS = new ArrayList<>();
        PageParamDTO<List<Map<String, Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String, Object>>>> responseDTO = new ResponseDTO<>();

        qsgqdbmDTOS = tGkmtPortregionsService.getTGkmtPortregionsByPageable(
                (pageParamDTO.getPageStartNo()-1)*pageParamDTO.getPageSize(),
                pageParamDTO.getPageStartNo()*pageParamDTO.getPageSize());
        paramDTO.setTotalCount(tGkmtPortregionsService.getTGkmtPortregionsCount());
        paramDTO.setResponseData(qsgqdbmDTOS);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 全省港口表 待测试
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "qsgkb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String, Object>>>> getQsgkbDTO(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String, Object>> qsgqdbmDTOS = new ArrayList<>();
        PageParamDTO<List<Map<String, Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String, Object>>>> responseDTO = new ResponseDTO<>();

        qsgqdbmDTOS = tGkmtPortsService.getTGkmtPortsByPageable(
                (pageParamDTO.getPageStartNo()-1)*pageParamDTO.getPageSize(),
                pageParamDTO.getPageStartNo()*pageParamDTO.getPageSize());
        paramDTO.setTotalCount(tGkmtPortsService.getTGkmtPortsCount());
        paramDTO.setResponseData(qsgqdbmDTOS);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 港口快报吞吐量 待测试
    //todo 港口企业 gkqy
    //todo 码头单位 mtdw
    //todo startDate 开始日期 2019-04-23
    //todo endDate 结束日期 2019-05-23
    @RequestMapping(value = "gkkbttl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String, Object>>> getGkkbttlDTO(@RequestParam String gkqy,
                                              @RequestParam String mtdw,
                                              @RequestParam String startDate,
                                              @RequestParam String endDate){
        List<Map<String, Object>> gkkbttlDTOList = new ArrayList<>();
        ResponseDTO<List<Map<String, Object>>> responseDTO = new ResponseDTO<>();

        gkkbttlDTOList = tGkmtQuickreportdataService.getTGkmtQuickreportdataByPageable(0, 10000, gkqy, mtdw, startDate, endDate);

        responseDTO.setResponseData(gkkbttlDTOList);
        return  responseDTO;
    }


    //todo 港口吞吐量 待测试
    //todo 泊位编号 bwbh
    //todo 码头单位 mtdw
    //todo startDate 开始日期 2019-04-23
    //todo endDate 结束日期 2019-05-23
    @RequestMapping(value = "gkttl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String, Object>>> getGkttlDTO(@RequestParam String bwbh,
                                                @RequestParam String mtdw,
                                                @RequestParam String startDate,
                                                @RequestParam String endDate){
        List<Map<String, Object>> gkttlDTOList = new ArrayList<>();
        ResponseDTO<List<Map<String, Object>>> responseDTO = new ResponseDTO<>();

        gkttlDTOList = tGkmtReportdataService.getTGkmtReportdataByPageable(0, 10000, bwbh, mtdw, startDate, endDate);
        responseDTO.setResponseData(gkttlDTOList);
        return  responseDTO;
    }

    //todo 行政管理机构 待测试
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "xzgljg", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String, Object>>>> getXzgljgDTO(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String, Object>> xzgljgDTOList = new ArrayList<>();
        PageParamDTO<List<Map<String, Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String, Object>>>> responseDTO = new ResponseDTO<>();

        xzgljgDTOList = tGkmtUnitsService.getTGkmtUnitsByPageable(
                (pageParamDTO.getPageStartNo()-1)*pageParamDTO.getPageSize(),
                pageParamDTO.getPageStartNo()*pageParamDTO.getPageSize());

        paramDTO.setTotalCount(tGkmtUnitsService.getTGkmtUnitsCount());
        paramDTO.setResponseData(xzgljgDTOList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 行政管理人员 待测试
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "xzglry", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String, Object>>>> getXzglryDTO(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String, Object>> xzglryDTOList = new ArrayList<>();
        PageParamDTO<List<Map<String, Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String, Object>>>> responseDTO = new ResponseDTO<>();

        xzglryDTOList = tGkmtUnitusersService.getTGkmtUnitusersByPageable(
                (pageParamDTO.getPageStartNo()-1)*pageParamDTO.getPageSize(),
                pageParamDTO.getPageStartNo()*pageParamDTO.getPageSize());

        paramDTO.setResponseData(xzglryDTOList);

        paramDTO.setTotalCount(tGkmtUnitusersService.getTGkmtUnitusersCount());
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }


}

