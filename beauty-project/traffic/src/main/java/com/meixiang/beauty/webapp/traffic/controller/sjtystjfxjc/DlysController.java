package com.meixiang.beauty.webapp.traffic.controller.sjtystjfxjc;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.CskyjtglDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.DlcyrysjDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.DlkhzczjqkDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.DlysjlrsjDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//道路运输
@Controller
@RequestMapping(value = "sjtystjfxjc")
public class DlysController {

    //todo 道路运输统计（半年，年）涵盖道路客运站信息
    @RequestMapping(value = "dkystjhgdlkyzxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,List<String>>>> dkystjhgdlkyzxx(@RequestParam String startDate,
                                                                    @RequestParam String endDate){
        List<HashMap<String,List<String>>> dkystjhgdlkyzxxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,List<String>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 dkystjhgdlkyzxxList

        responseDTO.setResponseData(dkystjhgdlkyzxxList);
        return  responseDTO;
    }

    //todo 道路客货站场增减情况
    @RequestMapping(value = "dlkhzczjqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<DlkhzczjqkDataDTO>>> dlkhzczjqk(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<DlkhzczjqkDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<DlkhzczjqkDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路危险货物运输数据
    @RequestMapping(value = "dlwxhwyssj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> dlwxhwyssj(){
        List<HashMap<String,Object>> dlwxhwyssjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 dlwxhwyssjList

        responseDTO.setResponseData(dlwxhwyssjList);
        return  responseDTO;
    }

    //todo 道路从业人员数据
    @RequestMapping(value = "dlcyrysj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<DlcyrysjDataDTO>>> dlcyrysj(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<DlcyrysjDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<DlcyrysjDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路货运场站数据
    @RequestMapping(value = "dlhyczsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> dlhyczsj(@RequestParam String startDate,
                                                       @RequestParam String endDate){
        List<HashMap<String,Object>> dlhyczsjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 dlhyczsjList

        responseDTO.setResponseData(dlhyczsjList);
        return  responseDTO;
    }

    //todo 道路运输经理人数据
    @RequestMapping(value = "dlysjlrsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<DlysjlrsjDataDTO>>> dlysjlrsj(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<DlysjlrsjDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<DlysjlrsjDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 港澳台及外商投资道路运输情况数据
    //todo yearDate 2019
    @RequestMapping(value = "gatjwztzdlysqksj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gatjwztzdlysqksj(@RequestParam String yearDate){
        List<HashMap<String,Object>> gatjwztzdlysqksjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gatjwztzdlysqksjList

        responseDTO.setResponseData(gatjwztzdlysqksjList);
        return  responseDTO;
    }

    //todo 道路经营业户数据
    @RequestMapping(value = "dljyyhsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> dljyyhsj(){
        List<HashMap<String,Object>> dljyyhsjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 dljyyhsjList

        responseDTO.setResponseData(dljyyhsjList);
        return  responseDTO;
    }

    //todo 道路运输统计（企业）涵盖公路货运企业运输量调查数据
    @RequestMapping(value = "dlystjhgglhyqyysldcsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> dlystjhgglhyqyysldcsj(@RequestParam String startDate,
                                                                    @RequestParam String endDate){
        List<HashMap<String,Object>> dlystjhgglhyqyysldcsjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 dlystjhgglhyqyysldcsjList

        responseDTO.setResponseData(dlystjhgglhyqyysldcsjList);
        return  responseDTO;
    }

    //todo 公路客运企业运输调查
    @RequestMapping(value = "glkyqyysldc", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glkyqyysldc(){
        List<HashMap<String,Object>> glkyqyysldcList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glkyqyysldcList

        responseDTO.setResponseData(glkyqyysldcList);
        return  responseDTO;
    }

    //todo 重点联系公路运输企业经营财务状况调查数据
    @RequestMapping(value = "zdlxglysqyjycwzkdcsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> zdlxglysqyjycwzkdcsj(@RequestParam String startDate,
                                                                    @RequestParam String endDate){
        List<HashMap<String,Object>> zdlxglysqyjycwzkdcsjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 zdlxglysqyjycwzkdcsjList

        responseDTO.setResponseData(zdlxglysqyjycwzkdcsjList);
        return  responseDTO;
    }

    //todo 湖南省交通公路装卸搬运企业统计
    @RequestMapping(value = "hnsjtglzxbyqytj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> hnsjtglzxbyqytj(){
        List<HashMap<String,Object>> hnsjtglzxbyqytjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 hnsjtglzxbyqytjList

        responseDTO.setResponseData(hnsjtglzxbyqytjList);
        return  responseDTO;
    }

}
