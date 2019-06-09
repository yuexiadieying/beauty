package com.meixiang.beauty.webapp.traffic.controller;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.*;
import com.meixiang.beauty.webapp.traffic.dto.zhsy.OverallStatisticDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//湖南省港口企业与码头单位吞吐量表
@Controller
@RequestMapping(value = "hlsgkqyymtdwttlbb")
public class HnsgkqyymtdwttlbbController {

    //todo 湖南省港口企业与码头单位吞吐量报表首页
    @RequestMapping(value = "ttlbb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<TtlbbDTO>> getTtlbbDTO(){
        List<TtlbbDTO> ttlbbDTOList = new ArrayList<>();
        ResponseDTO<List<TtlbbDTO>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 ttlbbDTOList

        responseDTO.setResponseData(ttlbbDTOList);
        return  responseDTO;
    }


    //todo 全市泊位表中统计数据，包括了累计港口泊位数、增加的报告期、报废的报告期
    @RequestMapping(value = "qsbwbtjsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<QsbwbtjsjDTO> getQsbwbtjsjDTO(){
        QsbwbtjsjDTO qsbwbtjsjDTO = new QsbwbtjsjDTO();
        ResponseDTO<QsbwbtjsjDTO> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 qsbwbtjsjDTO

        responseDTO.setResponseData(qsbwbtjsjDTO);
        return  responseDTO;
    }

    //todo 全市泊位状况
    //todo 港口企业 gkqy
    //todo 码头单位 mtdw
    //todo startDate 开始日期 2019-04-23
    //todo endDate 结束日期 2019-05-23
    @RequestMapping(value = "qsbwzk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<QsbwzkDTO>> getQsbwzkDTO(@RequestParam String gkqy,
                                              @RequestParam String mtdw,
                                              @RequestParam String startDate,
                                              @RequestParam String endDate){
        List<QsbwzkDTO> qsbwzkDTOList = new ArrayList<>();
        ResponseDTO<List<QsbwzkDTO>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 qsbwzkDTOList

        responseDTO.setResponseData(qsbwzkDTOList);
        return  responseDTO;
    }

    //todo 港口企业和码头单位名录
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "gkqyml", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<GkqymlDTO>>> getGkqymlDTO(@RequestBody PageParamDTO pageParamDTO){
        List<GkqymlDTO> gkqymlDTOList = new ArrayList<>();
        PageParamDTO<List<GkqymlDTO>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<GkqymlDTO>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<List<GkqymlDTO>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(gkqymlDTOList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 企业操作人员
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "qyczry", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<QyczryDTO>>> getQyczryDTO(@RequestBody PageParamDTO pageParamDTO){
        List<QyczryDTO> qyczryDTOS = new ArrayList<>();
        PageParamDTO<List<QyczryDTO>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<QyczryDTO>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<List<QyczryDTO>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(qyczryDTOS);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 全省港区代表码
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "qsgqdbm", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<QsgqdbmDTO>>> getQsgqdbmDTO(@RequestBody PageParamDTO pageParamDTO){
        List<QsgqdbmDTO> qsgqdbmDTOS = new ArrayList<>();
        PageParamDTO<List<QsgqdbmDTO>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<QsgqdbmDTO>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<List<QsgqdbmDTO>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(qsgqdbmDTOS);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 全省港口表
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "qsgkb", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<QsgkbDTO>>> getQsgkbDTO(@RequestBody PageParamDTO pageParamDTO){
        List<QsgkbDTO> qsgqdbmDTOS = new ArrayList<>();
        PageParamDTO<List<QsgkbDTO>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<QsgkbDTO>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<List<QsgkbDTO>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(qsgqdbmDTOS);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 港口快报吞吐量
    //todo 港口企业 gkqy
    //todo 码头单位 mtdw
    //todo startDate 开始日期 2019-04-23
    //todo endDate 结束日期 2019-05-23
    @RequestMapping(value = "gkkbttl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<GkkbttlDTO>> getGkkbttlDTO(@RequestParam String gkqy,
                                              @RequestParam String mtdw,
                                              @RequestParam String startDate,
                                              @RequestParam String endDate){
        List<GkkbttlDTO> gkkbttlDTOList = new ArrayList<>();
        ResponseDTO<List<GkkbttlDTO>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gkkbttlDTOList

        responseDTO.setResponseData(gkkbttlDTOList);
        return  responseDTO;
    }


    //todo 港口快报吞吐量
    //todo 泊位编号 bwbh
    //todo 码头单位 mtdw
    //todo startDate 开始日期 2019-04-23
    //todo endDate 结束日期 2019-05-23
    @RequestMapping(value = "gkttl", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<GkttlDTO>> getGkttlDTO(@RequestParam String bwbh,
                                                @RequestParam String mtdw,
                                                @RequestParam String startDate,
                                                @RequestParam String endDate){
        List<GkttlDTO> gkttlDTOList = new ArrayList<>();
        ResponseDTO<List<GkttlDTO>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gkkbttlDTOList

        responseDTO.setResponseData(gkttlDTOList);
        return  responseDTO;
    }

    //todo 行政管理机构
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "xzgljg", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<XzgljgDTO>>> getXzgljgDTO(@RequestBody PageParamDTO pageParamDTO){
        List<XzgljgDTO> xzgljgDTOList = new ArrayList<>();
        PageParamDTO<List<XzgljgDTO>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<XzgljgDTO>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<List<XzgljgDTO>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(xzgljgDTOList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 行政管理人员
    //todo pageParamDTO内含分页参数
    @RequestMapping(value = "xzglry", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<XzglryDTO>>> getXzglryDTO(@RequestBody PageParamDTO pageParamDTO){
        List<XzglryDTO> xzglryDTOList = new ArrayList<>();
        PageParamDTO<List<XzglryDTO>> paramDTO = new PageParamDTO<>();
        ResponseDTO<PageParamDTO<List<XzglryDTO>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 PageParamDTO<List<XzglryDTO>>


        paramDTO.setTotalCount(10);//todo 总条数需要在业务层接口统计后返回
        paramDTO.setResponseData(xzglryDTOList);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }


}

