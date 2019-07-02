package com.meixiang.beauty.webapp.traffic.controller.sjtystjfxjc;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.CskyjtglDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.DlcyrysjDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.DlkhzczjqkDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.DlysjlrsjDataDTO;
import com.meixiang.beauty.webapp.traffic.service.sjtystjfxjc.*;
import com.meixiang.beauty.webapp.traffic.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

//道路运输
@Controller
@RequestMapping(value = "sjtystjfxjc")
public class DlysController {

    @Autowired
    private Ttjjhdlsy003ngdService ttjjhdlsy003ngdService;

    @Autowired
    private Ttjjhdlsy005ngdService ttjjhdlsy005ngdService;

    @Autowired
    private Ttjjhdlsy011ngdService ttjjhdlsy011ngdService;

    @Autowired
    private Ttjjhdlsy013ngdService ttjjhdlsy013ngdService;

    @Autowired
    private Ttjjhdlys001ngdService ttjjhdlys001ngdService;

    @Autowired
    private Ttjjhfpjb01Service ttjjhfpjb01Service;

    @Autowired
    private Ttjjhfpjb02Service ttjjhfpjb02Service;

    @Autowired
    private Ttjjhfpjb03Service ttjjhfpjb03Service;

    @Autowired
    private Ttjjhfpjb04Service ttjjhfpjb04Service;

    @Autowired
    private Ttjjhgsgljc01Service ttjjhgsgljc01Service;

    @Autowired
    private Ttjjhjht20Service ttjjhjht20Service;

    @Autowired
    private Ttjjhjht21Service ttjjhjht21Service;

    @Autowired
    private Ttjjhjht10yService ttjjhjht10yService;

    @Autowired
    private Ttjjhjht2Service ttjjhjht2Service;

    @Autowired
    private Ttjjhjht3Service ttjjhjht3Service;

    @Autowired
    private Ttjjhjht5Service ttjjhjht5Service;

    @Autowired
    private Ttjjhjht7Service ttjjhjht7Service;

    @Autowired
    private Ttjjhjht8Service ttjjhjht8Service;

    @Autowired
    private Ttjjhjtg92Service ttjjhjtg92Service;

    @Autowired
    private Ttjjhjtgz01f1Service ttjjhjtgz01f1Service;

    @Autowired
    private Ttjjhjtgz0304Service ttjjhjtgz0304Service;

    @Autowired
    private Ttjjhjtgz030405Service ttjjhjtgz030405Service;

    @Autowired
    private Ttjjhjtt3Service ttjjhjtt3Service;

    @Autowired
    private Ttjjhjtt31Service ttjjhjtt31Service;

    @Autowired
    private Ttjjhjtt311f3Service ttjjhjtt311f3Service;

    @Autowired
    private Ttjjhjtt4Service ttjjhjtt4Service;

    @Autowired
    private Ttjjhkcgx01Service ttjjhkcgx01Service;

    //todo 道路运输统计（半年，年）涵盖道路客运站信息
    @RequestMapping(value = "dkystjhgdlkyzxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String,List<String>>>> dkystjhgdlkyzxx(@RequestParam String startDate,
                                                                    @RequestParam String endDate){
        List<Map<String,List<String>>> dkystjhgdlkyzxxList = new ArrayList<>();
        ResponseDTO<List<Map<String,List<String>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 dkystjhgdlkyzxxList
        dkystjhgdlkyzxxList = ttjjhdlsy005ngdService
                .getRoadTransportStatisticInfo(DateUtil.getDayFrom(startDate), DateUtil.getDayFrom(endDate));

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
    ResponseDTO<List<Map<String,Object>>> dlwxhwyssj(){
        List<Map<String,Object>> dlwxhwyssjList = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

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
    ResponseDTO<List<Map<String,Object>>> dlhyczsj(@RequestParam String startDate,
                                                       @RequestParam String endDate){
        List<Map<String,Object>> dlhyczsjList = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

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
    ResponseDTO<List<Map<String,Object>>> gatjwztzdlysqksj(@RequestParam String yearDate){
        List<Map<String,Object>> gatjwztzdlysqksjList = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gatjwztzdlysqksjList

        responseDTO.setResponseData(gatjwztzdlysqksjList);
        return  responseDTO;
    }

    //todo 道路经营业户数据
    @RequestMapping(value = "dljyyhsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String,Object>>> dljyyhsj(){
        List<Map<String,Object>> dljyyhsjList = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 dljyyhsjList

        responseDTO.setResponseData(dljyyhsjList);
        return  responseDTO;
    }

    //todo 道路运输统计（企业）涵盖公路货运企业运输量调查数据
    @RequestMapping(value = "dlystjhgglhyqyysldcsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String,Object>>> dlystjhgglhyqyysldcsj(@RequestParam String startDate,
                                                                    @RequestParam String endDate){
        List<Map<String,Object>> dlystjhgglhyqyysldcsjList = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 dlystjhgglhyqyysldcsjList

        responseDTO.setResponseData(dlystjhgglhyqyysldcsjList);
        return  responseDTO;
    }

    //todo 公路客运企业运输调查
    @RequestMapping(value = "glkyqyysldc", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String,Object>>> glkyqyysldc(){
        List<Map<String,Object>> glkyqyysldcList = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glkyqyysldcList

        responseDTO.setResponseData(glkyqyysldcList);
        return  responseDTO;
    }

    //todo 重点联系公路运输企业经营财务状况调查数据
    @RequestMapping(value = "zdlxglysqyjycwzkdcsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String,Object>>> zdlxglysqyjycwzkdcsj(@RequestParam String startDate,
                                                                    @RequestParam String endDate){
        List<Map<String,Object>> zdlxglysqyjycwzkdcsjList = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 zdlxglysqyjycwzkdcsjList

        responseDTO.setResponseData(zdlxglysqyjycwzkdcsjList);
        return  responseDTO;
    }

    //todo 湖南省交通公路装卸搬运企业统计
    @RequestMapping(value = "hnsjtglzxbyqytj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<Map<String,Object>>> hnsjtglzxbyqytj(){
        List<Map<String,Object>> hnsjtglzxbyqytjList = new ArrayList<>();
        ResponseDTO<List<Map<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 hnsjtglzxbyqytjList

        responseDTO.setResponseData(hnsjtglzxbyqytjList);
        return  responseDTO;
    }

}
