package com.meixiang.beauty.webapp.car.controller;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinTokenDTO;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.sys.utils.RandomNumberUtil;
import com.meixiang.beauty.webapp.car.dto.*;
import com.meixiang.beauty.webapp.car.service.CarSocketService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping(value = "")
public class CarController {

    @Autowired
    private MongoTemplate mongoTemplate;

    //点击开始按钮，进入主游戏流程
    @RequestMapping(value = "gameBegin", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<DeviceParamDTO>> gameBegin(@RequestParam String gamePlaceId){
        ResponseDTO responseDTO =  CarSocketService.getCarSocketService().startGame(gamePlaceId);
        return  responseDTO;
    }

    //点击结束按钮，结束游戏
    @RequestMapping(value = "gameStop", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO gameStop(@RequestParam String gamePlaceId) {
        ResponseDTO responseDTO = CarSocketService.getCarSocketService().endGame(gamePlaceId);
        return  responseDTO;
    }

    @RequestMapping(value = "deviceOnline", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO deviceOnline(@RequestParam String gamePlaceId) {
        ResponseDTO responseDTO = CarSocketService.getCarSocketService().getDeviceOnline(gamePlaceId);
        return  responseDTO;
    }

    @RequestMapping(value = "partTotalDamage", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO partTotalDamage(@RequestParam String gamePlaceId,@RequestParam String part) {
        ResponseDTO responseDTO = CarSocketService.getCarSocketService().getPartTotalDamage(gamePlaceId,part);
        return  responseDTO;
    }

    @RequestMapping(value = "goalResult", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO goalResult(@RequestParam String gamePlaceId,@RequestParam String part) {
        ResponseDTO responseDTO = CarSocketService.getCarSocketService().getGoalResult(gamePlaceId,part);
        return  responseDTO;
    }

    @RequestMapping(value = "carDamage", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO carDamage(@RequestParam String deviceId) {
        ResponseDTO responseDTO = CarSocketService.getCarSocketService().getCarDamage(deviceId);
        return  responseDTO;
    }

    @RequestMapping(value = "carQRCode", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String carQRCode(@RequestParam String deviceId) {

        Query query = new Query(Criteria.where("weixinFlag").is(ConfigConstant.weixinRobotFlag));
        WeixinTokenDTO weixinTokenDTO = mongoTemplate.findOne(query,WeixinTokenDTO.class,"weixinParameter");
        String token = weixinTokenDTO.getToken();
        String url= "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+token;
        String shareCode = "carGame_" + deviceId + "_" + RandomNumberUtil.getFourRandom();
        String jsonData="{\"expire_seconds\": 2592000, \"action_name\": \"QR_STR_SCENE\",\"action_info\": {\"scene\": {\"scene_str\"" + ":\"" + shareCode + "\"}}}";
        String reJson= WeixinUtil.post(url, jsonData,"POST");
        JSONObject jb=JSONObject.fromObject(reJson);
        String qrTicket = jb.getString("ticket");
        String QRCodeURI="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+qrTicket;

        return  QRCodeURI;
    }

}
