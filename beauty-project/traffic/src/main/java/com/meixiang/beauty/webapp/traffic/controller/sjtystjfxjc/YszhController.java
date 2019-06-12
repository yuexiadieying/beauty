package com.meixiang.beauty.webapp.traffic.controller.sjtystjfxjc;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.CskyjtglDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.GlysfrqyqkDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.HyclgxqkDataDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.SlysfrqybgqkDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//运输综合
@Controller
@RequestMapping(value = "sjtystjfxjc")
public class YszhController {

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


    //todo 高速公路货车车流量和车货总重情况
    //todo choiceType为"cheliuliang"表示统计车流量，为"tongxingfei"表示统计通行费
    @RequestMapping(value = "gsglhccllhchzzqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gsglhccllhchzzqk(@RequestParam String startDate,
                                                               @RequestParam String endDate,
                                                               @RequestParam String choiceType){
        List<HashMap<String,Object>> gsglhccllhchzzqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gsglhccllhchzzqkList

        responseDTO.setResponseData(gsglhccllhchzzqkList);
        return  responseDTO;
    }

    //todo 公路客货运输量情况
    @RequestMapping(value = "glkhyslqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glkhyslqk(){
        List<HashMap<String,Object>> glkhyslqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glkhyslqkList

        responseDTO.setResponseData(glkhyslqkList);
        return  responseDTO;
    }

    //todo 公路运输业务量情况
    @RequestMapping(value = "glysywlqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glysywlqk(@RequestParam String startDate,
                                                        @RequestParam String endDate){
        List<HashMap<String,Object>> glysywlqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glysywlqkList

        responseDTO.setResponseData(glysywlqkList);
        return  responseDTO;
    }

    //todo 水路客货运输量情况
    @RequestMapping(value = "slkhyslqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> slkhyslqk(){
        List<HashMap<String,Object>> slkhyslqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 slkhyslqkList

        responseDTO.setResponseData(slkhyslqkList);
        return  responseDTO;
    }

    //todo 海事签字情况
    //todo monthDate 2019-08
    @RequestMapping(value = "hsqzqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> hsqzqk(@RequestParam String monthDate){
        List<HashMap<String,Object>> hsqzqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 hsqzqkList

        responseDTO.setResponseData(hsqzqkList);
        return  responseDTO;
    }

    //todo 公路分货运输量情况
    @RequestMapping(value = "glfhyslqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glfhyslqk(){
        List<HashMap<String,Object>> glfhyslqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glfhyslqkList

        responseDTO.setResponseData(glfhyslqkList);
        return  responseDTO;
    }

    //todo 公路旅客货物运营车辆拥有量情况
    @RequestMapping(value = "gllkhwyyclyylqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> gllkhwyyclyylqk(@RequestParam String startDate,
                                                              @RequestParam String endDate){
        List<HashMap<String,Object>> gllkhwyyclyylqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gllkhwyyclyylqkList

        responseDTO.setResponseData(gllkhwyyclyylqkList);
        return  responseDTO;
    }

    //todo 公路密度情况
    @RequestMapping(value = "glmdqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glmdqk(){
        List<HashMap<String,Object>> gglmdqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 gglmdqkList

        responseDTO.setResponseData(gglmdqkList);
        return  responseDTO;
    }

    //todo 公路桥梁隧道年底到达数量情况
    @RequestMapping(value = "glqlsdndddslqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> glqlsdndddslqk(@RequestParam String startDate,
                                                              @RequestParam String endDate){
        List<HashMap<String,Object>> glqlsdndddslqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 glqlsdndddslqkList

        responseDTO.setResponseData(glqlsdndddslqkList);
        return  responseDTO;
    }

    //todo 公路运输法人企业情况
    @RequestMapping(value = "glysfrqyqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<GlysfrqyqkDataDTO>>> glysfrqyqk(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<GlysfrqyqkDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<GlysfrqyqkDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 内河航道通航里程年底达到量情况
    @RequestMapping(value = "nhhdthlcndddlqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> nhhdthlcndddlqk(@RequestParam String startDate,
                                                             @RequestParam String endDate){
        List<HashMap<String,Object>> nhhdthlcndddlqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 nhhdthlcndddlqkList

        responseDTO.setResponseData(nhhdthlcndddlqkList);
        return  responseDTO;
    }

    //todo 货运车辆更新情况
    @RequestMapping(value = "hyclgxqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<HyclgxqkDataDTO>>> hyclgxqk(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<HyclgxqkDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<HyclgxqkDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 水路运输运输量情况
    @RequestMapping(value = "slysyslqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> slysyslqk(@RequestParam String startDate,
                                                        @RequestParam String endDate){
        List<HashMap<String,Object>> slysyslqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 slysyslqkList

        responseDTO.setResponseData(slysyslqkList);
        return  responseDTO;
    }

    //todo 水路运输法人情况变更情况
    @RequestMapping(value = "slysfrqybgqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<SlysfrqybgqkDataDTO>>> slysfrqybgqk(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<SlysfrqybgqkDataDTO>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<SlysfrqybgqkDataDTO>> paramDTO = new PageParamDTO<>();

        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 水路运输工具拥有量情况
    @RequestMapping(value = "slysgjyylqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> slysgjyylqk(@RequestParam String startDate,
                                                        @RequestParam String endDate){
        List<HashMap<String,Object>> slysgjyylqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 slysgjyylqkList

        responseDTO.setResponseData(slysgjyylqkList);
        return  responseDTO;
    }

    //todo 营业性汽车运输效率和燃烧消耗情况
    //todo monthDate 2019-08
    //todo choiceType为"yunsuxiaolv"表示统计运输效率，为"ranshaoxiaohao"表示统计燃烧消耗情况
    @RequestMapping(value = "yyxqcysxlhrsxhqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> yyxqcysxlhrsxhqk(@RequestParam String monthDate,
                                                            @RequestParam String choiceType){
        List<HashMap<String,Object>> yyxqcysxlhrsxhqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 yyxqcysxlhrsxhqkList

        responseDTO.setResponseData(yyxqcysxlhrsxhqkList);
        return  responseDTO;
    }

    //todo 营业性运输船舶燃烧消耗情况数据
    @RequestMapping(value = "yyxyscbrsxhqk", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<HashMap<String,Object>>> yyxyscbrsxhqk(@RequestParam String startDate,
                                                          @RequestParam String endDate){
        List<HashMap<String,Object>> yyxyscbrsxhqkList = new ArrayList<>();
        ResponseDTO<List<HashMap<String,Object>>> responseDTO = new ResponseDTO<>();

        //todo 通过业务层获取 yyxyscbrsxhqkList

        responseDTO.setResponseData(yyxyscbrsxhqkList);
        return  responseDTO;
    }

}
