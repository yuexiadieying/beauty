package com.meixiang.beauty.webapp.traffic.controller.sjtystjfxjc;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.DlkhzczjqkDataDTO;
import com.meixiang.beauty.webapp.traffic.service.RobotSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//省交通运输统计分析监测
@Controller
@RequestMapping(value = "sjtystjfxjc")
public class SjtystjfxjcController {

    //todo 出租车汽车运营情况
    @RequestMapping(value = "czcyyqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> czcyyqk(@RequestParam String startDate,
                                                      @RequestParam String endDate){
        List<HashMap<String,Object>> czcyyqklList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 czcyyqklList

        responseDTO.setResponseData(czcyyqklList);
        return  responseDTO;
    }

    //todo 城市客运主要统计指标快速年报信息
    @RequestMapping(value = "cskyzytjzbksnbxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> cskyzytjzbksnbxx(){
        List<HashMap<String,Object>> cskyzytjzbksnbxxList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 cskyzytjzbksnbxxList

        responseDTO.setResponseData(cskyzytjzbksnbxxList);
        return  responseDTO;
    }

    //todo 城市公交运营情况
    @RequestMapping(value = "csgjyyqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> csgjyyqk(@RequestParam String startDate,
                                                       @RequestParam String endDate){
        List<HashMap<String,Object>> csgjyyqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 csgjyyqkList

        responseDTO.setResponseData(csgjyyqkList);
        return  responseDTO;
    }


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

    //todo 分航线进出港旅客人数情况
    @RequestMapping(value = "fhxjcglkrsqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> fhxjcglkrsqk(@RequestParam String startDate,
                                                       @RequestParam String endDate){
        List<HashMap<String,Object>> fhxjcglkrsqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 fhxjcglkrsqkList

        responseDTO.setResponseData(fhxjcglkrsqkList);
        return  responseDTO;
    }

    //todo 国际航线进出港旅客人数情况
    @RequestMapping(value = "gjfhxjcglkrsqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gjfhxjcglkrsqk(@RequestParam String startDate,
                                                           @RequestParam String endDate){
        List<HashMap<String,Object>> gjfhxjcglkrsqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gjfhxjcglkrsqkList

        responseDTO.setResponseData(gjfhxjcglkrsqkList);
        return  responseDTO;
    }

    //todo 路段平均日交通量统计
    @RequestMapping(value = "ldpjrjtltj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> ldpjrjtltj(@RequestParam String luduan,
                                                         @RequestParam String startDate,
                                                         @RequestParam String endDate){
        List<HashMap<String,Object>> ldpjrjtltjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 ldpjrjtltjList

        responseDTO.setResponseData(ldpjrjtltjList);
        return  responseDTO;
    }

    //todo 分叉辅助段基础数据
    //todo monthDate 2019-08
    @RequestMapping(value = "fcfzdjcsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> fcfzdjcsj(@RequestParam String monthDate){
        List<HashMap<String,Object>> ldpjrjtltjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 ldpjrjtltjList

        responseDTO.setResponseData(ldpjrjtltjList);
        return  responseDTO;
    }

    //todo 过河建筑物基础数据
    @RequestMapping(value = "ghjzwjcsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> ghjzwjcsj(){
        List<HashMap<String,Object>> ghjzwjcsjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 ghjzwjcsjList

        responseDTO.setResponseData(ghjzwjcsjList);
        return  responseDTO;
    }

    //todo 公路水路运输量阅读统计基础情况
    //todo monthDate 2019-08
    @RequestMapping(value = "glslyslydtjjcqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glslyslydtjjcqk(@RequestParam String monthDate){
        List<HashMap<String,Object>> glslyslydtjjcqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glslyslydtjjcqkList

        responseDTO.setResponseData(glslyslydtjjcqkList);
        return  responseDTO;
    }

    //todo 高速公路车流量和通行费情况
    //todo monthDate 2019-08
    //todo choiceType为"cheliuliang"表示统计车流量，为"tongxingfei"表示统计通行费
    @RequestMapping(value = "gsglcllhtxfqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gsglcllhtxfqk(@RequestParam String monthDate,
                                                            @RequestParam String choiceType){
        List<HashMap<String,Object>> gsglcllhtxfqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gsglcllhtxfqkList

        responseDTO.setResponseData(gsglcllhtxfqkList);
        return  responseDTO;
    }


}
