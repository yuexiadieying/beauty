package com.meixiang.beauty.webapp.traffic.controller.sjtystjfxjc;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//港口综合
@Controller
@RequestMapping(value = "sjtystjfxjc")
public class GkzhController {

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

    //todo 国际分航线进出港旅客人数情况
    @RequestMapping(value = "gjfhxjcglkrsqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gjfhxjcglkrsqk(){
        List<HashMap<String,Object>> gjfhxjcglkrsqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gjfhxjcglkrsqkList

        responseDTO.setResponseData(gjfhxjcglkrsqkList);
        return  responseDTO;
    }

    //todo 国内分航线进出港旅客人数情况
    @RequestMapping(value = "gnfhxjcglkrsqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gnfhxjcglkrsqk(@RequestParam String startDate,
                                                           @RequestParam String endDate){
        List<HashMap<String,Object>> gnfhxjcglkrsqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gnfhxjcglkrsqkList

        responseDTO.setResponseData(gnfhxjcglkrsqkList);
        return  responseDTO;
    }

    //todo 内贸情况
    @RequestMapping(value = "nmqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> nmqk(){
        List<HashMap<String,Object>> nmqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 nmqkList

        responseDTO.setResponseData(nmqkList);
        return  responseDTO;
    }

    //todo 分货类吞吐
    @RequestMapping(value = "fhltt", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> fhltt(@RequestParam String startDate,
                                                    @RequestParam String endDate){
        List<HashMap<String,Object>> fhlttList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 fhlttList

        responseDTO.setResponseData(fhlttList);
        return  responseDTO;
    }

    //todo 内贸出港情况
    @RequestMapping(value = "nmcgqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> nmcgqk(){
        List<HashMap<String,Object>> nmcgqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 nmcgqkList

        responseDTO.setResponseData(nmcgqkList);
        return  responseDTO;
    }

    //todo 国际航线进出港集装箱吞吐
    @RequestMapping(value = "gjhxjcgjzxtt", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gjhxjcgjzxtt(@RequestParam String startDate,
                                                    @RequestParam String endDate){
        List<HashMap<String,Object>> gjhxjcgjzxttList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gjhxjcgjzxttList

        responseDTO.setResponseData(gjhxjcgjzxttList);
        return  responseDTO;
    }

    //todo 外贸情况
    @RequestMapping(value = "wmqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> wmqk(){
        List<HashMap<String,Object>> wmqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 wmqkList

        responseDTO.setResponseData(wmqkList);
        return  responseDTO;
    }

    //todo 内支线进出港集装箱吞吐
    @RequestMapping(value = "nzxjcgjzxtt", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> nzxjcgjzxtt(@RequestParam String startDate,
                                                           @RequestParam String endDate){
        List<HashMap<String,Object>> nzxjcgjzxttList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 nzxjcgjzxttList

        responseDTO.setResponseData(nzxjcgjzxttList);
        return  responseDTO;
    }

    //todo 分货类分运输集疏运情况
    @RequestMapping(value = "fhlfysfsjsyqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> fhlfysfsjsyqk(){
        List<HashMap<String,Object>> fhlfysfsjsyqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 fhlfysfsjsyqkList

        responseDTO.setResponseData(fhlfysfsjsyqkList);
        return  responseDTO;
    }

    //todo 内外贸船舶停泊时间
    @RequestMapping(value = "nwmcbtbsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> nwmcbtbsj(@RequestParam String startDate,
                                                          @RequestParam String endDate){
        List<HashMap<String,Object>> nwmcbtbsjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 nwmcbtbsjList

        responseDTO.setResponseData(nwmcbtbsjList);
        return  responseDTO;
    }

    //todo 港口法人企业
    @RequestMapping(value = "gkfrqy", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<GkfrqyDataDTO>>> cskyjtgl(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<GkfrqyDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<GkfrqyDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 港口码头单位数据
    @RequestMapping(value = "gkmtdwsj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gkmtdwsj(){
        List<HashMap<String,Object>> gkmtdwsjList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gkmtdwsjList

        responseDTO.setResponseData(gkmtdwsjList);
        return  responseDTO;
    }

}
