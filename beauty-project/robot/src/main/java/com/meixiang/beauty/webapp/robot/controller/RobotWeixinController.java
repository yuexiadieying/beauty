package com.meixiang.beauty.webapp.robot.controller;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinConfigDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinShareDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinTokenDTO;
import com.meixiang.beauty.common.utils.*;
import com.meixiang.beauty.common.web.BaseController;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import com.meixiang.beauty.sys.entity.Article;
import com.meixiang.beauty.sys.entity.WeixinUserBean;
import com.meixiang.beauty.webapp.robot.service.RobotWeixinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenjiake on 17/11/4.
 * 负责响应微商平台用户端微信公众平台的请求
 *
 */

@Controller
@RequestMapping(value = "weixin")
public class RobotWeixinController extends BaseController {

    @Autowired
    private RobotWeixinService robotWeixinService;

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * *用户校验是否是微信服务器发送的请求
     * */
    @RequestMapping(value = "requestFromServer", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String requestFromServer(HttpServletRequest request,HttpServletResponse response) {
          String method = request.getMethod().toUpperCase();
          if ("GET".equals(method)) {
              // 微信加密签名
              String signature = request.getParameter("signature");
              // 时间戳
              String timestamp = request.getParameter("timestamp");
              // 随机数
              String nonce = request.getParameter("nonce");
              // 随机字符串
              String echostr = request.getParameter("echostr");

              // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
              if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                return echostr;
              }
              return "";
          }
          else {
              // 调用核心业务类接收消息、处理消息
              String respMessage = null;
              respMessage = robotWeixinService.processRobotWeixinRequest(request,response);
              return respMessage;
          }
      }

    /**
     * 公众号菜单引导页 081dazSU0Zf1iU1fGISU0q5ASU0dazSd 0815XmM70lSlvH1UnyN70OwBM705XmM9
     */
    @RequestMapping(value = "getRobotWeixinMenuId", method = {RequestMethod.POST, RequestMethod.GET})
    public String getUserWeixinMenu(HttpServletRequest request,
                                    HttpServletResponse response,
                                    HttpSession session) throws Exception
    {
        String url = java.net.URLDecoder.decode(request.getParameter("url"), "utf-8");

        if ("businessHome".equals(url)) {
            url = ConfigConstant.BUSINESS_WEB_URL + "businessHome";
        }
        else if ("shareHome".equals(url)) {
            url = ConfigConstant.BUSINESS_WEB_URL + "shareHome";
        }
        else if ("trainingProductList".equals(url)) {
            url = ConfigConstant.BUSINESS_WEB_URL + "trainingProductList";
        }
        else if ("myselfCenter".equals(url)) {
            url = ConfigConstant.BUSINESS_WEB_URL + "myselfCenter";
        }

        String openId = WeixinUtil.getOpenId(session,request);
        if (openId==null||openId.equals("")) {
            String code = request.getParameter("code");
            String get_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                    "appid="+ ConfigConstant.ROBOTCORPID +
                    "&secret=" + ConfigConstant.ROBOTSECTET +
                    "&code="+ code +
                    "&grant_type=authorization_code";
            WeixinUserBean weixinUserBean;
            int countNum = 0;
            do {
                String json = HttpRequestUtil.getConnectionResult(get_access_token_url, "GET", "");
                weixinUserBean = JsonUtil.getObjFromJsonStr(json, WeixinUserBean.class);
                if (countNum++ > 3) {
                    break;
                }
            } while (weixinUserBean == null);

            openId = weixinUserBean.getOpenid();
            session.setAttribute(ConfigConstant.OPEN_ID, openId);
            CookieUtils.setCookie(response, ConfigConstant.OPEN_ID, openId==null?"":openId,60*60*24*30,ConfigConstant.DOMAIN_VALUE);
        }

        return "redirect:" + url;
    }


    /**
     * 用户端微信JS-SDK获得初始化参数
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getConfig", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseDTO<WeixinConfigDTO> getConfig(HttpServletRequest request) throws Exception
    {
        ResponseDTO<WeixinConfigDTO> responseDTO = new ResponseDTO<>();
        String u = request.getParameter("url");
        Query query = new Query(Criteria.where("weixinFlag").is(ConfigConstant.weixinFlag));
        WeixinTokenDTO weixinTokenDTO = mongoTemplate.findOne(query,WeixinTokenDTO.class,"weixinParameter");
        String ticket = weixinTokenDTO.getTicket();
        WeixinConfigDTO WeixinConfigDTO = JsApiTicketUtil.sign(ticket, u);
        responseDTO.setResponseData(WeixinConfigDTO);
        return responseDTO;
    }

    /**
     * 验证主入口
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/fieldwork/author", method = RequestMethod.GET)
    public String Oauth2API(HttpServletRequest request) {
        String backUrl = request.getParameter("url");
        String oauth2Url = WeixinUtil.getOauth2Url(backUrl);
        return "redirect:" + oauth2Url;
    }

}
