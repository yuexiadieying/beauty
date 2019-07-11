package com.meixiang.beauty.webapp.traffic.controller.sdlyssjxtgl;

import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.CskyjtglDataDTO;
import com.meixiang.beauty.webapp.traffic.service.sdlyssjxtgl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Objects;

//经营业户信息
@Controller
@RequestMapping(value = "sdlyssjxtgl")
public class JyyhxxController {
    @Autowired
    private TsjxttfptownerService tsjxttfptownerService;

    @Autowired
    private TsjxttfbsjurctcService tsjxttfbsjurctcService;

    @Autowired
    private TsjxttfbscreditcheckService tsjxttfbscreditcheckService;

    @Autowired
    private TsjxttfbsindustryinfoService tsjxttfbsindustryinfoService;

    @Autowired
    private TsjxttfbsappstationService tsjxttfbsappstationService;

    @Autowired
    private TsjxttfbsownertrainextService tsjxttfbsownertrainextService;

    @Autowired
    private TsjxttfbsvectrancertService tsjxttfbsvectrancertService;

    @Autowired
    private TsjxttfbsvecgoodsvecexaService tsjxttfbsvecgoodsvecexaService;

    @Autowired
    private TsjxttfbsvecgoodsService tsjxttfbsvecgoodsService;

    @Autowired
    private TsjxttfbsvecgoodstecgrdService tsjxttfbsvecgoodstecgrdService;

    @Autowired
    private TsjxttfbsvecgoodsvindService tsjxttfbsvecgoodsvindService;

    @Autowired
    private TsjxttfbsvehicleinsuranceService tsjxttfbsvehicleinsuranceService;

    @Autowired
    private TsjxttfptcmpsnService tsjxttfptcmpsnService;

    @Autowired
    private TsjxttfbscmpsnrecordService tsjxttfbscmpsnrecordService;

    @Autowired
    private TsjxttfbsrestudyrecordService tsjxttfbsrestudyrecordService;

    @Autowired
    private TsjxttfbscaseinfoService tsjxttfbscaseinfoService;

    @Autowired
    private TsjxttfbsenbeworrecordService tsjxttfbsenbeworrecordService;

    @Autowired
    private TsjxttfbsdrivercreditService tsjxttfbsdrivercreditService;

    @Autowired
    private TsjxttfbslinperregService tsjxttfbslinperregService;

    @Autowired
    private TsjxttfbspermitlincardService tsjxttfbspermitlincardService;

    //todo 经营业户基本信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jyyhjbxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> jyyhjbxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());

        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfptownerService
                .getTsjxttfptownerByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(), param));

        paramDTO.setTotalCount(tsjxttfptownerService.getTsjxttfptownerCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路运输经营许可证信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlysjyxkzxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> dlysjyxkzxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());

        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfbsjurctcService
                .getTsjxttfbsjurctcByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(), param));
        paramDTO.setTotalCount(tsjxttfbsjurctcService.getTsjxttfbsjurctcCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路运输经营许可证换证信息 删除
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlyxjyxkzhzxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> dlyxjyxkzhzxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());

        //todo 通过业务层获取 paramDTO

        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 经营业户质量信誉考核信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jyyhzlxykhxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> jyyhzlxykhxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());

        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfbscreditcheckService
                .getTsjxttfbscreditcheckByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(), param));
        paramDTO.setTotalCount(tsjxttfbscreditcheckService.getTsjxttfbscreditcheckCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 经营业户工商注册信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jyyhgszcxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> jyyhgszcxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO

        paramDTO.setRequestData(tsjxttfbsindustryinfoService
                .getTsjxttfbsindustryinfoByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(), param));

        paramDTO.setTotalCount(tsjxttfbsindustryinfoService.getTsjxttfbsindustryinfoCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 经营业户税务登记信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jyyhswdjxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> jyyhswdjxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路客运站专项信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlkyzzxxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> dlkyzzxxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = "06";
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfbsappstationService
                .getTsjxttfbsappstationByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(), param));
        paramDTO.setTotalCount(tsjxttfbsappstationService.getTsjxttfbsappstationCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 道路货运站专项信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "dlhyzzxxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> dlhyzzxxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = "07";
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfbsappstationService
                .getTsjxttfbsappstationByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(), param));
        paramDTO.setTotalCount(tsjxttfbsappstationService.getTsjxttfbsappstationCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 机动车维修经营业户专项信息 删除
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jdcwxjyyhzxxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> jdcwxjyyhzxxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 机动车驾驶员培训业户专项信息
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jdcjsypxyhzxxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> jdcjsypxyhzxxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO
        paramDTO.setRequestData(tsjxttfbsownertrainextService
                .getTsjxttfbsownertrainextByPageable(pageParamDTO.getPageStartNo(),
                        pageParamDTO.getPageStartNo() + pageParamDTO.getPageSize(), param));
        paramDTO.setTotalCount(tsjxttfbsownertrainextService.getTsjxttfbsownertrainextCount(param));
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }

    //todo 经营业户安全生产事故信息 删除
    //todo PageParamDTO里面的requestData为查询参数
    @RequestMapping(value = "jyyhaqscsgxx", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<PageParamDTO<List<Map<String,Object>>>> jyyhaqscsgxx(@RequestBody PageParamDTO pageParamDTO){

        ResponseDTO<PageParamDTO<List<Map<String,Object>>>> responseDTO = new ResponseDTO<>();
        PageParamDTO<List<Map<String,Object>>> paramDTO = new PageParamDTO<>();
        String param = Objects.isNull(pageParamDTO.getRequestData()) ? "" :
                String.valueOf(pageParamDTO.getRequestData());
        //todo 通过业务层获取 paramDTO

        paramDTO.setTotalCount(10);
        responseDTO.setResponseData(paramDTO);
        return  responseDTO;
    }


}
