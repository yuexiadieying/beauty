package com.meixiang.beauty.webapp.traffic.controller.sjtystjfxjc;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.DlkhzczjqkDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.GsglfwqjckmxDataDTO;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//公路养护
@Controller
@RequestMapping(value = "sjtystjfxjc")
public class GlyhController {

    //todo 高速公路服务区及出口明细
    @RequestMapping(value = "gsglfwqjckmx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<GsglfwqjckmxDataDTO>>> gsglfwqjckmx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<GsglfwqjckmxDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<GsglfwqjckmxDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 公路管理机构及职工统计
    //todo choiceType为"guanlijigou"表示统计管理机构，为"zhigong"表示统计职工
    @RequestMapping(value = "glgljgjzgtj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glgljgjzgtj(@RequestParam String choiceType){
        List<HashMap<String,Object>> glgljgjzgtjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glgljgjzgtjList

        responseDTO.setResponseData(glgljgjzgtjList);
        return  responseDTO;
    }

    //todo 公司技术状况评定
    @RequestMapping(value = "gsjsqkpd", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,List<HashMap<String,Object>>>>> gsjsqkpd(@RequestParam String luxian,
                                                                 @RequestParam String startDate,
                                                                 @RequestParam String endDate){
        List<HashMap<String,List<HashMap<String,Object>>>> gsjsqkpdList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,List<HashMap<String,Object>>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gsjsqkpdList

        responseDTO.setResponseData(gsjsqkpdList);
        return  responseDTO;
    }

    //todo 公司路线基本情况
    @RequestMapping(value = "gslxjbqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gslxjbqk(@RequestParam String luxian){

        List<HashMap<String,Object>> gslxjbqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gslxjbqkList

        responseDTO.setResponseData(gslxjbqkList);
        return  responseDTO;
    }

    //todo 公路类别桥梁统计汇总
    @RequestMapping(value = "gllbqltjhz", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,List<HashMap<String,Object>>>>> gllbqltjhz(){

        List<HashMap<String,List<HashMap<String,Object>>>> gllbqltjhzList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,List<HashMap<String,Object>>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gllbqltjhzList

        responseDTO.setResponseData(gllbqltjhzList);
        return  responseDTO;
    }

    //todo 公路桥梁明细
    @RequestMapping(value = "glqlmx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glqlmx(@RequestParam String qiaoliang){

        List<HashMap<String,Object>> glqlmxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glqlmxList

        responseDTO.setResponseData(glqlmxList);
        return  responseDTO;
    }

    //todo 公路隧道明细
    @RequestMapping(value = "glsdmx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glsdmx(@RequestParam String suidao){

        List<HashMap<String,Object>> glsdmxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glsdmxList

        responseDTO.setResponseData(glsdmxList);
        return  responseDTO;
    }

    //todo 公路绿化情况
    @RequestMapping(value = "gllhqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gllhqk(@RequestParam String luxian){

        List<HashMap<String,Object>> gllhqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gllhqkList

        responseDTO.setResponseData(gllhqkList);
        return  responseDTO;
    }

    //todo 公路养护工程统计
    //todo monthDate 2019-12
    @RequestMapping(value = "glyhgctj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glyhgctj(@RequestParam String monthDate){
        List<HashMap<String,Object>> glyhgctjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glyhgctjList

        responseDTO.setResponseData(glyhgctjList);
        return  responseDTO;
    }

    //todo 公路应急储备物资统计
    @RequestMapping(value = "glyjcbwztj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glyjcbwztj(){

        List<HashMap<String,Object>> glyjcbwztjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glyjcbwztjList

        responseDTO.setResponseData(glyjcbwztjList);
        return  responseDTO;
    }

    //todo 公路损毁
    @RequestMapping(value = "glsh", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glsh(@RequestParam String luxian){

        List<HashMap<String,Object>> glshList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glshList

        responseDTO.setResponseData(glshList);
        return  responseDTO;
    }

    //todo 抢通统计
    //todo yearDate 2019
    @RequestMapping(value = "qttj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> qttj(@RequestParam String yearDate){

        List<HashMap<String,Object>> qttjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 qttjList

        responseDTO.setResponseData(qttjList);
        return  responseDTO;
    }

    //todo 公路机具统计
    @RequestMapping(value = "gljjtj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gljjtj(){

        List<HashMap<String,Object>> gljjtjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gljjtjList

        responseDTO.setResponseData(gljjtjList);
        return  responseDTO;
    }

}
