package com.meixiang.beauty.webapp.robot.service;

import com.meixiang.beauty.common.bean.WeixinArticle;
import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinAttentionDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinTokenDTO;
import com.meixiang.beauty.common.utils.ReceiveXmlProcess;
import com.meixiang.beauty.common.utils.SpringContextHolder;
import com.meixiang.beauty.common.utils.StringUtils;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.sys.entity.ReceiveXmlEntity;
import com.meixiang.beauty.sys.entity.TextMessage;
import com.meixiang.beauty.sys.entity.WeixinUserBean;
import com.meixiang.beauty.sys.utils.WeixinMessageUtil;
import com.meixiang.beauty.webapp.robot.util.MessageUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class RobotWeixinService {

    public static MongoTemplate mongoTemplate = SpringContextHolder.getBean(MongoTemplate.class);

    private static ExecutorService threadExecutorCached = Executors.newCachedThreadPool();

    public String processRobotWeixinRequest(HttpServletRequest request, HttpServletResponse response) {
        String respMessage = null;

        /** 解析xml数据 */
        ReceiveXmlEntity xmlEntity = new ReceiveXmlProcess().getMsgEntity(WeixinUtil.getXmlDataFromWeixin(request));
        String msgType = xmlEntity.getMsgType();

        // xml请求解析
        if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT))
        {
            // 事件类型
            String eventType = xmlEntity.getEvent();
            if(eventType.equals(MessageUtil.SCAN))
            {
                //已关注公众号的情况下扫描
                this.processRobotScanEvent(xmlEntity);
            }
            else if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE))
            {
                //扫描关注公众号或者搜索关注公众号都在其中
                this.processRobotSubscribeEvent(xmlEntity);
            }
            else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE))
            {
                // 取消订阅
                this.processRobotUnSubscribeEvent(xmlEntity);
            }
            else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK))
            {
                // 自定义菜单点击事件
                respMessage = this.processRobotEvent(xmlEntity,request,response);
            }
        }
        else
        {
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(xmlEntity.getFromUserName());
            textMessage.setFromUserName(xmlEntity.getToUserName());
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.TRANSFER_CUSTOMER_SERVICE);
            textMessage.setFuncFlag(0);
            respMessage = MessageUtil.textMessageToXml(textMessage);
        }
        return respMessage;
    }

    private String processRobotEvent(ReceiveXmlEntity xmlEntity, HttpServletRequest request, HttpServletResponse response) {

        return  null;
    }

    private void processRobotSubscribeEvent(ReceiveXmlEntity xmlEntity) {
    }

    private void processRobotScanEvent(ReceiveXmlEntity xmlEntity) {

        Query query = new Query(Criteria.where("weixinFlag").is(ConfigConstant.weixinRobotFlag));
        WeixinTokenDTO weixinTokenDTO = this.mongoTemplate.findOne(query,WeixinTokenDTO.class,"weixinParameter");
        String token = weixinTokenDTO.getToken();

        //开启线程，处理扫描机器人线程
        Runnable processRobotScanThread = new ProcessRobotScanThread(token,xmlEntity);
        threadExecutorCached.execute(processRobotScanThread);
    }

    private class ProcessRobotScanThread extends Thread {

        private String token;
        private ReceiveXmlEntity xmlEntity;

        public ProcessRobotScanThread(String token, ReceiveXmlEntity xmlEntity) {
            this.token = token;
            this.xmlEntity = xmlEntity;
        }

        @Override
        public void run() {

            String openId = xmlEntity.getFromUserName();

            //判断用户是否是扫码微商用户的二维码关注，
            String robotId = "";
            if(StringUtils.isNotNull(xmlEntity.getEventKey())){
                robotId = xmlEntity.getEventKey().replace("robotGame_", "");
                String codeArray[] = robotId.split("_");
                robotId = codeArray[0];
            }

            WeixinUserBean weixinUserBean =  RobotSocketService.getRobotSocketService().robotUserMapping.get(robotId);

            if(weixinUserBean==null)
            {
                String bindRobotId = RobotSocketService.getRobotSocketService().userRobotMapping.get(openId);

                if(bindRobotId==null)
                {
                    weixinUserBean = WeixinUtil.getWeixinUserBean(token,openId);

                    //获取到了用户扫描的机器人ID，将用户和机器人绑定到一起
                    RobotSocketService.getRobotSocketService().bindUserAndRobot(robotId,weixinUserBean);

                    ArrayList<Object> obj = new ArrayList<Object>();
                    WeixinArticle article = new WeixinArticle();
                    article.setTitle("【绑定机器人成功 】");
                    article.setDescription("您已成功绑定"+robotId+"号机器人，请等待游戏的开始" );
                    obj.add(article);
                    WeixinMessageUtil.sendMsgToWeixin(token,openId,obj);
                }
                else
                {
                    ArrayList<Object> obj = new ArrayList<Object>();
                    WeixinArticle article = new WeixinArticle();
                    article.setTitle("【不能重绑定机器人】");
                    article.setDescription("您已经绑定"+bindRobotId+"号机器人，请等待游戏的开始" );
                    obj.add(article);
                    WeixinMessageUtil.sendMsgToWeixin(token,openId,obj);
                }

            }
            else
            {
                ArrayList<Object> obj = new ArrayList<Object>();
                WeixinArticle article = new WeixinArticle();
                article.setTitle("【绑定机器人失败 】");
                article.setDescription("此机器人已经被其用户绑定了，请更换其他机器人" );
                obj.add(article);
                WeixinMessageUtil.sendMsgToWeixin(token,openId,obj);
            }
        }
    }


    private void processRobotUnSubscribeEvent(ReceiveXmlEntity xmlEntity)
    {

    }

    public void updateWeixinToken(){
        try {
            System.out.print("用户端微信参数更新");
            String token = WeixinUtil.getTokenFromTX(ConfigConstant.ROBOTCORPID, ConfigConstant.ROBOTSECTET);
            if(StringUtils.isNotNull(token)) {
                String ticket = WeixinUtil.getJsapiTicket(token);
                Query query = new Query().addCriteria(Criteria.where("weixinFlag").is(ConfigConstant.weixinRobotFlag));
                Update update = new Update();
                update.set("token",token);
                update.set("ticket",ticket);
                update.set("updateDate",new Date());
                mongoTemplate.updateFirst(query,update,"weixinParameter");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
