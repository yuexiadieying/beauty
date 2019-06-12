package com.meixiang.beauty.webapp.traffic.controller.sjtystjfxjc;

import com.meixiang.beauty.common.dto.system.ResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//扶贫统计
@Controller
@RequestMapping(value = "sjtystjfxjc")
public class FptjController {

    //todo 高速和国省道的计划
    //todo monthDate 2019-12
    @RequestMapping(value = "gshgsddjh", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gshgsddjh(@RequestParam String monthDate){
        List<HashMap<String,Object>> gshgsddjhList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gshgsddjhList

        responseDTO.setResponseData(gshgsddjhList);
        return  responseDTO;
    }

    //todo 高速和国省道的计划投资完成情况
    //todo monthDate 2019-12
    @RequestMapping(value = "gshgsddjhtzwcqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gshgsddjhtzwcqk(@RequestParam String monthDate){
        List<HashMap<String,Object>>gshgsddjhtzwcqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gshgsddjhtzwcqkList

        responseDTO.setResponseData(gshgsddjhtzwcqkList);
        return  responseDTO;
    }

    //todo 农村公路的计划
    //todo monthDate 2019-12
    @RequestMapping(value = "ncgldjh", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> ncgldjh(@RequestParam String monthDate){
        List<HashMap<String,Object>> ncgldjhList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 ncgldjhList

        responseDTO.setResponseData(ncgldjhList);
        return  responseDTO;
    }

    //todo 农村公路的计划投资完成情况
    //todo monthDate 2019-12
    @RequestMapping(value = "ncgldjhncgldjh", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> ncgldjhncgldjh(@RequestParam String monthDate){
        List<HashMap<String,Object>> ncgldjhncgldjhList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 ncgldjhncgldjhList

        responseDTO.setResponseData(ncgldjhncgldjhList);
        return  responseDTO;
    }

    //todo 扶贫统计最低栏的综合统计表
    //todo choice为"cglzjdwqk"表示为村公路资金到位情况（万元），"xdzjdw"为县道资金到位， "xdzjdw"为乡道资金到位， "ncglzjdw"为农村公路资金到位， "wdw"未到位, "ydw"已到位
    @RequestMapping(value = "fptjzhtj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<HashMap<String,Object>> fptjzhtj(@RequestParam String choiceType){
        HashMap<String,Object> fptjzhtj = new HashMap<>();
        ResponseDTO<HashMap<String,Object>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 fptjzhtj

        responseDTO.setResponseData(fptjzhtj);
        return  responseDTO;
    }



}
