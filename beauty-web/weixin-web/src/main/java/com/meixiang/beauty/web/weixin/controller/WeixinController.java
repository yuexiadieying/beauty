package com.meixiang.beauty.web.weixin.controller;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.account.WithDrawRecordDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinConfigDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinShareDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinTokenDTO;
import com.meixiang.beauty.common.utils.*;
import com.meixiang.beauty.common.web.BaseController;
import com.meixiang.beauty.modules.account.AccountService;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.modules.wechat.api.WeixinCoreService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import com.meixiang.beauty.sys.entity.Article;
import com.meixiang.beauty.sys.entity.WeixinUserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.meixiang.beauty.common.utils.FileUtils.readInputStream;

/**
 * Created by chenjiake on 17/11/4.
 * 负责响应微商平台用户端微信公众平台的请求
 *
 */

@Controller
@RequestMapping(value = "weixin")
public class WeixinController extends BaseController {

    @Autowired
    private WeixinCoreService weixinCoreService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserService userService;

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
          } else {
              // 调用核心业务类接收消息、处理消息
              String respMessage = null;
              try {
                  respMessage = weixinCoreService.processWeixinRequest(request,response);
              } catch (IOException e) {
                  e.printStackTrace();
              }
              return respMessage;
          }
      }

    /**
     * 公众号菜单引导页 081dazSU0Zf1iU1fGISU0q5ASU0dazSd 0815XmM70lSlvH1UnyN70OwBM705XmM9
     */
    @RequestMapping(value = "getBusinessWeixinMenuId", method = {RequestMethod.POST, RequestMethod.GET})
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
                    "appid="+ ConfigConstant.CORPID +
                    "&secret=" + ConfigConstant.SECTET +
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

    /**
     * 向微信客户端推送消息
     */
    @RequestMapping(value = "postInfoToWeixin", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String
    sendMsgToWeixin(HttpServletRequest request, HttpSession session) {
        String openId = (String) session.getAttribute("openId");
        if (!StringUtils.isNotNull(openId)) {
            openId = CookieUtils.getCookie(request, "openId");
        }
        Map<String, Object> parameter = null;//systemService.getWeixinParameter();
        String token = (String) parameter.get("token");

        List<Article> articleList = new ArrayList<>();
        Article article = new Article();
        article.setTitle("三甲医院儿科专家    咨询秒回不等待");
        article.setDescription("小儿内科:       24小时全天 \n\n小儿皮肤科/保健科:   8:00 ~ 23:00\n\n妇产科:   12:00-14:00，19:00-22:00\n" +
                "\n小儿其他专科:   19:00 ~ 21:00\n\n" +
                "(外科、眼科、耳鼻喉科、口腔科、预防接种科、中医科、心理科)\n\n好消息！可在线咨询北京儿童医院皮肤科专家啦！");
        article.setPicUrl("http://xiaoerke-wxapp-pic.oss-cn-hangzhou.aliyuncs.com/menu/%E6%8E%A8%E9%80%81%E6%B6%88%E6%81%AF2.png");
        article.setUrl("https://mp.weixin.qq.com/s?__biz=MzI2MDAxOTY3OQ==&mid=504236660&idx=1&sn=10d923526047a5276dd9452b7ed1e302&scene=1&srcid=0612OCo7d5ASBoGRr2TDgjfR&key=f5c31ae61525f82ed83c573369e70b8f9b853c238066190fb5eb7b8640946e0a090bbdb47e79b6d2e57b615c44bd82c5&ascene=0&uin=MzM2NjEyMzM1&devicetype=iMac+MacBookPro11%2C4+OSX+OSX+10.11.4+build(15E65)&version=11020201&pass_ticket=dG5W6eOP3JU1%2Fo3JXw19SFBAh1DgpSlQrAXTyirZuj970HMU7TYojM4D%2B2LdJI9n");
        articleList.add(article);
        WeixinUtil.senImgMsgToWeixin(token,openId,articleList);

        if (openId != null) {
            return "true";
        }
        return "false";
    }


    /**
     * 用户获取推广二维码
     */
    @RequestMapping(value = "getUserQRCode", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<WeixinShareDTO> getUserQRCode() {
        ResponseDTO<WeixinShareDTO> responseDTO = new ResponseDTO();

        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        WeixinShareDTO weixinShareDTO = userService.getWeixinShareInfo(userInfoDTO);
        if(weixinShareDTO==null)
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        else
        {
            weixinShareDTO.setQrCodeURL(saveImageToLocal(weixinShareDTO.getQrCodeURL(),weixinShareDTO.getSysUserId(),"qrCode"));
            weixinShareDTO.setUserImage(saveImageToLocal(weixinShareDTO.getUserImage(),weixinShareDTO.getSysUserId(),"userImage"));
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setResponseData(weixinShareDTO);
        }
        return responseDTO;
    }

    private static String saveImageToLocal(String urlToLocal,String userId,String type)
    {
        //将图片存入到本地
        String rootPath = getRootPath();
        String newUrl = "images/sharePage/" + userId + "_" + type + ".png";
        URL url = null;
        try {
            url = new URL(urlToLocal);
            //打开链接
            HttpURLConnection conn = null;
            conn = (HttpURLConnection)url.openConnection();
            //设置请求方式为"GET"
            conn.setRequestMethod("GET");
            //超时响应时间为5秒
            conn.setConnectTimeout(5 * 1000);
            //通过输入流获取图片数据
            InputStream inStream = conn.getInputStream();
            //得到图片的二进制数据，以二进制封装得到数据，具有通用性
            byte[] data = FileUtils.readInputStream(inStream);
            //new一个文件对象用来保存图片，默认保存当前工程根目录
            File imageFile = new File(rootPath + "/" + newUrl);
            //创建输出流
            FileOutputStream outStream = new FileOutputStream(imageFile);
            //写入数据
            outStream.write(data);
            //关闭输出流
            outStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return newUrl;
    }

    /**
     * TODO 获取根目录
     * @return
     * @author <a href="mailto:pheh.lin@gmail.com">PHeH</a><br>
     * Created On 2007-5-10 15:16:21
     */
    private static String getRootPath(){
        //因为类名为"Application"，因此" Application.class"一定能找到
        String result = WeixinController.class.getResource("WeixinController.class").toString();
        int index = result.indexOf("WEB-INF");
        if(index == -1){
            index = result.indexOf("bin");
        }
        result = result.substring(0,index);
        if(result.startsWith("jar")){
            // 当class文件在jar文件中时，返回"jar:file:/F:/ ..."样的路径
            result = result.substring(10);
        }else if(result.startsWith("file")){
            // 当class文件在class文件中时，返回"file:/F:/ ..."样的路径
            result = result.substring(6);
        }
        if(result.endsWith("/"))result = result.substring(0,result.length()-1);//不包含最后的"/"
        return result;
    }


    @RequestMapping(value = "weixinTemplateMessageTest", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO weixinTemplateMessageTest(HttpServletRequest request, HttpSession session) {
        ResponseDTO responseDTO = new ResponseDTO();

        Query query = new Query(Criteria.where("weixinFlag").is(ConfigConstant.weixinFlag));
        WeixinTokenDTO weixinTokenDTO = this.mongoTemplate.findOne(query,WeixinTokenDTO.class,"weixinParameter");
        String token = weixinTokenDTO.getToken();
        String first = "客官，您好！您的订单未支付，即将关闭。";
        String keynote1 = "2017年12月15日14：41";
        String keynote2 = "【20171215647289】";
        String remark = "还未付款，未付款的订单24时内关闭，请及时付款。感谢您对美享99商城的青睐！点击查看详情。";
        String url="http://mx99.kpbeauty.com.cn/business/ionic#/businessHome";
        String openid="oZe5rv2yeCL4frbL4IV9Yn0zKd3M";

        //WeixinTemplateMessageUtil.sendOrderNotPayTemplateWXMessage(keynote1,keynote2,token,url,openid);

        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

}
