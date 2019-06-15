package com.meixiang.beauty.webapp.traffic.controller;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.GkqymlDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TtlbbDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzUnitsHnDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.XzqhDTO;
import com.meixiang.beauty.webapp.traffic.service.sslyzgl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//省水路运政管理
@Controller
@RequestMapping(value = "sslyzgl")
public class SslyzglController {

    @Autowired
    private HomePageService homePageService;

    @Autowired
    private TSlyzXzqhsService tSlyzXzqhsService;

    @Autowired
    private TSlyzUnitsHnService tSlyzUnitsHnService;

    @Autowired
    private TSlyzApproveapplyrecordsService tSlyzApproveapplyrecordsService;

    @Autowired
    private TSlyzChangeshiprecordsService tSlyzChangeshiprecordsService;

    @Autowired
    private TSlyzEnterpriseillegalrunrdService tSlyzEnterpriseillegalrunrdService;

    @Autowired
    private TSlyzExitenterpriserecordsService tSlyzExitenterpriserecordsService;

    @Autowired
    private TSlyzPortsHnService tSlyzPortsHnService;

    @Autowired
    private TSlyzServiceenterprisesService tSlyzServiceenterprisesService;

    @Autowired
    private TSlyzServicepersonsService tSlyzServicepersonsService;

    @Autowired
    private TSlyzShipenterprisesService tSlyzShipenterprisesService;

    @Autowired
    private TSlyzShippersonsService tSlyzShippersonsService;

    @Autowired
    private TSlyzYearcheckenterprisesService tSlyzYearcheckenterprisesService;

    @Autowired
    private TSlyzYearcheckshipsService tSlyzYearcheckshipsService;

    @Autowired
    private TSlyzShipkindsService tSlyzShipkindsService;

    @Autowired
    private TSlyzShipillegalrunrecordsService tSlyzShipillegalrunrecordsService;

    @Autowired
    private TSlyzShipsService tSlyzShipsService;

    @Autowired
    private TSlyzShipnamesService tSlyzShipnamesService;

    @Autowired
    private TSlyzUnitpersonsService tSlyzUnitpersonsService;

    //todo 省水路运政管理首页 带测试
    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<SslyzglDTO>> getSslyzglDTO(){
        List<SslyzglDTO> sslyzglDTOList = new ArrayList<>();
        ResponseDTO<List<SslyzglDTO>> responseDTO = new ResponseDTO<>();

        sslyzglDTOList = homePageService.getHomePageInfo();

        responseDTO.setResponseData(sslyzglDTOList);
        return  responseDTO;
    }

    //todo 行政区划
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "xzqh", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String, Object>>>> getXzqhDTO(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String, Object>> xzqhDTOList = new ArrayList<>();
        PageParamDTO<List<Map<String, Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String, Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<List<XzqhDTO>>
        xzqhDTOList = tSlyzXzqhsService
                .getTSlyzXzqhsByPageable(pageParamDTO.getPageStartNo(), pageParamDTO.getPageNo());

        paramDTO.setTotalCount(tSlyzXzqhsService.getTSlyzXzqhsCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(xzqhDTOList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 管理机构
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "gljg", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> gljg(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> gljgList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>
        gljgList = tSlyzUnitsHnService
                .getTSlyzUnitsHnByPageable(pageParamDTO.getPageStartNo(),pageParamDTO.getPageNo());

        paramDTO.setTotalCount(tSlyzUnitsHnService.getTSlyzUnitsHnCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(gljgList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 许可申请记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "xksqjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> xksqjl(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> xksqjlList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        xksqjlList = tSlyzApproveapplyrecordsService
                .getTSlyzApproveapplyrecordsByPageable(pageParamDTO.getPageStartNo(), pageParamDTO.getPageNo());

        paramDTO.setTotalCount(tSlyzApproveapplyrecordsService.getTSlyzApproveapplyrecordsCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(xksqjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 水路运输业户台账
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "slysyhzt", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> slysyhzt(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> slysyhztList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        slysyhztList = tSlyzShipenterprisesService
                .getTSlyzShipenterprisesByPageable(pageParamDTO.getPageStartNo(), pageParamDTO.getPageNo());

        paramDTO.setTotalCount(tSlyzShipenterprisesService.getTSlyzShipenterprisesCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(slysyhztList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 水路运输企业人员
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "slysqyry", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> slysqyry(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> slysqyryList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        slysqyryList = tSlyzShippersonsService
                .getTSlyzShippersonsByPageable(pageParamDTO.getPageStartNo(),pageParamDTO.getPageNo());

        paramDTO.setTotalCount(tSlyzShippersonsService.getTSlyzShippersonsCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(slysqyryList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 运输辅助企业台账
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "ysfzqytz", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> ysfzqytz(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> ysfzqytzList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        ysfzqytzList = tSlyzServiceenterprisesService
                .getTSlyzServiceenterprisesByPageable(pageParamDTO.getPageStartNo(),pageParamDTO.getPageNo());

        paramDTO.setTotalCount(tSlyzServiceenterprisesService.getTSlyzServiceenterprisesCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(ysfzqytzList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 运输辅助企业人员
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "ysfzqyry", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> ysfzqyry(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> ysfzqyryList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        ysfzqyryList = tSlyzServicepersonsService
                .getTSlyzServicepersonsByPageable(pageParamDTO.getPageStartNo(),pageParamDTO.getPageNo());

        paramDTO.setTotalCount(tSlyzServicepersonsService.getTSlyzServicepersonsCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(ysfzqyryList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 年度审验业户记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "ndsyyhjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> ndsyyhjl(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> ndsyyhjlList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        ndsyyhjlList = tSlyzYearcheckenterprisesService
                .getTSlyzYearcheckenterprisesByPageable(pageParamDTO.getPageStartNo(), pageParamDTO.getPageNo());

        paramDTO.setTotalCount(tSlyzYearcheckenterprisesService.getTSlyzYearcheckenterprisesCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(ndsyyhjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 注销退出业户记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "zxtcyhjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> zxtcyhjl(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> zxtcyhjlList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        zxtcyhjlList = tSlyzExitenterpriserecordsService
                .getTSlyzExitenterpriserecordsByPageable(pageParamDTO.getPageStartNo(), pageParamDTO.getPageNo());


        paramDTO.setTotalCount(tSlyzExitenterpriserecordsService.getTSlyzExitenterpriserecordsCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(zxtcyhjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 企业违章记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "qywzjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> qywzjl(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> qywzjlList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        qywzjlList = tSlyzEnterpriseillegalrunrdService
                .getTSlyzEnterpriseillegalrunrdByPageable(pageParamDTO.getPageStartNo(), pageParamDTO.getPageNo() );

        paramDTO.setTotalCount(tSlyzEnterpriseillegalrunrdService.getTSlyzEnterpriseillegalrunrdCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(qywzjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 运营船舶信息
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "yycbxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yycbxx(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> yycbxxList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        yycbxxList = tSlyzShipsService
                .getTSlyzShipsByPageable(pageParamDTO.getPageStartNo(), pageParamDTO.getPageNo());

        paramDTO.setTotalCount(tSlyzShipsService.getTSlyzShipsCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(yycbxxList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 船舶类型代码
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "cblxdm", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> cblxdm(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> cblxdmList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        cblxdmList = tSlyzShipkindsService
                .getTSlyzShipkindsByPageable(pageParamDTO.getPageStartNo(), pageParamDTO.getPageNo());


        paramDTO.setTotalCount(tSlyzShipkindsService.getTSlyzShipkindsCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(cblxdmList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 年度审验船舶记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "ndsycbjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> ndsycbjl(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> ndsycbjlList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        ndsycbjlList = tSlyzYearcheckshipsService
                .getTSlyzYearcheckshipsByPageable(pageParamDTO.getPageStartNo(), pageParamDTO.getPageNo());

        paramDTO.setTotalCount(tSlyzYearcheckshipsService.getTSlyzYearcheckshipsCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(ndsycbjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 变更船舶记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "bgcbjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> bgcbjl(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> bgcbjlList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        bgcbjlList = tSlyzChangeshiprecordsService
                .getTSlyzChangeshiprecordsByPageable(pageParamDTO.getPageStartNo(), pageParamDTO.getPageNo());

        paramDTO.setTotalCount(tSlyzChangeshiprecordsService.getTSlyzChangeshiprecordsCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(bgcbjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 船舶违章记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "cbwzjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> cbwzjl(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> cbwzjlList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        cbwzjlList = tSlyzShipillegalrunrecordsService
                .getTSlyzShipillegalrunrecordsByPageable(pageParamDTO.getPageStartNo(),pageParamDTO.getPageNo() );

        paramDTO.setTotalCount(tSlyzShipillegalrunrecordsService.getTSlyzShipillegalrunrecordsCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(cbwzjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 业户与船舶年审报数据
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "yhycbnsbsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yhycbnsbsj(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> yhycbnsbsjList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(yhycbnsbsjList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 运输船舶名录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "yscbml", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yscbml(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> yscbmlList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        yscbmlList = tSlyzShipnamesService
                .getTSlyzShipnamesByPageable(pageParamDTO.getPageStartNo(), pageParamDTO.getPageNo());

        paramDTO.setTotalCount(tSlyzShipnamesService.getTSlyzShipnamesCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(yscbmlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 运输管理人员名录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "yzglryml", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> yzglryml(@RequestBody PageParamDTO pageParamDTO){
        List<Map<String,Object>> yzglrymlList = new ArrayList<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<Map<String,Object>>
        yzglrymlList = tSlyzUnitpersonsService
                .getTSlyzUnitpersonsByPageable(pageParamDTO.getPageStartNo(), pageParamDTO.getPageNo());

        paramDTO.setTotalCount(tSlyzUnitpersonsService.getTSlyzUnitpersonsCount());//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(yzglrymlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

}
