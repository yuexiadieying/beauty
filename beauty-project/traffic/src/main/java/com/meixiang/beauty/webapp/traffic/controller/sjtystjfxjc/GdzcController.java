package com.meixiang.beauty.webapp.traffic.controller.sjtystjfxjc;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.DlkhzczjqkDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.JtgdzctzeDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//固定资产
@Controller
@RequestMapping(value = "sjtystjfxjc")
public class GdzcController {

    //todo 交通固定资产投资额
    @RequestMapping(value = "jtgdzctze", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<JtgdzctzeDataDTO>>> jtgdzctze(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<JtgdzctzeDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<JtgdzctzeDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 新增生产力情况
    @RequestMapping(value = "xzsclqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> xzsclqk(){
        List<HashMap<String,Object>> xzsclqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 xzsclqkList

        responseDTO.setResponseData(xzsclqkList);
        return  responseDTO;
    }

    //todo 港澳台及外商投资道路运输情况数据
    //todo yearDate 2019
    @RequestMapping(value = "glgdzctz", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glgdzctz(@RequestParam String yearDate){
        List<HashMap<String,Object>> glgdzctzjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glgdzctzjList

        responseDTO.setResponseData(glgdzctzjList);
        return  responseDTO;
    }

    //todo 资金来源情况
    @RequestMapping(value = "zjlyqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> zjlyqk(){
        List<HashMap<String,Object>> zjlyqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 zjlyqkList

        responseDTO.setResponseData(zjlyqkList);
        return  responseDTO;
    }

    //todo 中央及地方安排农村公路建设情况
    @RequestMapping(value = "zyjdfapncgljsqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,List<HashMap<String,Object>>>>> zyjdfapncgljsqk(@RequestParam String yearDate){
        List<HashMap<String,List<HashMap<String,Object>>>> zyjdfapncgljsqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,List<HashMap<String,Object>>>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 zyjdfapncgljsqkList

        responseDTO.setResponseData(zyjdfapncgljsqkList);
        return  responseDTO;
    }

    //todo 固定资产统计栏
    //todo choice为"zyapncgljss"表示为中央安排农村公路建设数，"dfapncgljss"为地方安排农村公路建设
    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<HashMap<String,Object>> gdzczhtj(@RequestParam String choiceType){
        HashMap<String,Object> gdzczhtj = new HashMap<>();
        ResponseDTO<HashMap<String,Object>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gdzczhtj

        responseDTO.setResponseData(gdzczhtj);
        return  responseDTO;
    }


}
