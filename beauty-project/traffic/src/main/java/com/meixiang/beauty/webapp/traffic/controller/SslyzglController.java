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
        xzqhDTOList = tSlyzXzqhsService.getTSlyzXzqhsByPageable(pageParamDTO.getPageStartNo(), pageParamDTO.getPageNo());

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
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> gljg(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> gljgList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(gljgList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 许可申请记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "xksqjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> xksqjl(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> xksqjlList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(xksqjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 水路运输业户台账
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "slysyhzt", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> slysyhzt(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> slysyhztList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(slysyhztList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 水路运输企业人员
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "slysqyry", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> slysqyry(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> slysqyryList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(slysqyryList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 运输辅助企业台账
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "ysfzqytz", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> ysfzqytz(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> ysfzqytzList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(ysfzqytzList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 运输辅助企业人员
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "ysfzqyry", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> ysfzqyry(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> ysfzqyryList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(ysfzqyryList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 年度审验业户记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "ndsyyhjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> ndsyyhjl(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> ndsyyhjlList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(ndsyyhjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 注销退出业户记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "zxtcyhjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> zxtcyhjl(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> zxtcyhjlList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(zxtcyhjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 企业违章记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "qywzjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> qywzjl(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> qywzjlList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(qywzjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 运营船舶信息
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "yycbxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> yycbxx(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> yycbxxList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(yycbxxList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 船舶类型代码
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "cblxdm", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cblxdm(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> cblxdmList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(cblxdmList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 年度审验船舶记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "ndsycbjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> ndsycbjl(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> ndsycbjlList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(ndsycbjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 年度审验船舶记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "bgcbjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> bgcbjl(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> bgcbjlList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(bgcbjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 船舶违章记录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "cbwzjl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> cbwzjl(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> cbwzjlList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(cbwzjlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 业户与船舶年审报数据
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "yhycbnsbsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> yhycbnsbsj(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> yhycbnsbsjList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


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
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> yscbml(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> yscbmlList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(yscbmlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 运输船舶名录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "yzglryml", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> yzglryml(@RequestBody PageParamDTO pageParamDTO){
        List<HashMap<String,Object>> yzglrymlList = new ArrayList<>();
        PageParamDTO<List<HashMap<String,Object>>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<HashMap<String,Object>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<HashMap<String,Object>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(yzglrymlList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

}
