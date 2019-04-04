package com.meixiang.beauty.webapp.car.service;

import com.meixiang.beauty.common.bean.WeixinArticle;
import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.dto.wexin.WeixinTokenDTO;
import com.meixiang.beauty.common.utils.ReceiveXmlProcess;
import com.meixiang.beauty.common.utils.SpringContextHolder;
import com.meixiang.beauty.common.utils.StringUtils;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.sys.entity.ReceiveXmlEntity;
import com.meixiang.beauty.sys.entity.TextMessage;
import com.meixiang.beauty.sys.entity.WeixinUserBean;
import com.meixiang.beauty.sys.utils.WeixinMessageUtil;
import com.meixiang.beauty.webapp.car.util.MessageUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class CarWeixinService {

    public static MongoTemplate mongoTemplate = SpringContextHolder.getBean(MongoTemplate.class);

    private static ExecutorService threadExecutorCached = Executors.newCachedThreadPool();

    public String processCarWeixinRequest(HttpServletRequest request, HttpServletResponse response) {
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
                this.processCarScanEvent(xmlEntity);
            }
            else if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE))
            {
                //扫描关注公众号或者搜索关注公众号都在其中
                this.processCarSubscribeEvent(xmlEntity);
            }
            else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE))
            {
                // 取消订阅
                this.processCarUnSubscribeEvent(xmlEntity);
            }
            else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK))
            {
                // 自定义菜单点击事件
                respMessage = this.processCarEvent(xmlEntity,request,response);
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

    private String processCarEvent(ReceiveXmlEntity xmlEntity, HttpServletRequest request, HttpServletResponse response) {

        return  null;
    }

    private void processCarSubscribeEvent(ReceiveXmlEntity xmlEntity) {
    }

    private void processCarScanEvent(ReceiveXmlEntity xmlEntity) {

        Query query = new Query(Criteria.where("weixinFlag").is(ConfigConstant.weixinRobotFlag));
        WeixinTokenDTO weixinTokenDTO = this.mongoTemplate.findOne(query,WeixinTokenDTO.class,"weixinParameter");
        String token = weixinTokenDTO.getToken();

        //开启线程，处理扫描机器人线程
        Runnable processCarScanThread = new ProcessCarScanThread(token,xmlEntity);
        threadExecutorCached.execute(processCarScanThread);
    }

    private class ProcessCarScanThread extends Thread {

        private String token;
        private ReceiveXmlEntity xmlEntity;

        public ProcessCarScanThread(String token, ReceiveXmlEntity xmlEntity) {
            this.token = token;
            this.xmlEntity = xmlEntity;
        }

        @Override
        public void run() {

            String openId = xmlEntity.getFromUserName();

            //判断用户是否是扫码微商用户的二维码关注，
            String carId = "";
            if(StringUtils.isNotNull(xmlEntity.getEventKey())){
                carId = xmlEntity.getEventKey().replace("carGame_", "");
                String codeArray[] = carId.split("_");
                carId = codeArray[0];
            }

            WeixinUserBean weixinUserBean =  CarSocketService.getCarSocketService().carUserMapping.get(carId);

            if(weixinUserBean==null)
            {
                String bindCarId = CarSocketService.getCarSocketService().userCarMapping.get(openId);

                if(bindCarId==null)
                {
                    weixinUserBean = WeixinUtil.getWeixinUserBean(token,openId);

                    //获取到了用户扫描的机器人ID，将用户和机器人绑定到一起
                    CarSocketService.getCarSocketService().bindUserAndCar(carId,weixinUserBean);

                    ArrayList<Object> obj = new ArrayList<Object>();
                    WeixinArticle article = new WeixinArticle();
                    article.setTitle("【绑定机器人成功 】");
                    article.setDescription("您已成功绑定"+carId+"号机器人，请等待游戏的开始" );
                    obj.add(article);
                    WeixinMessageUtil.sendMsgToWeixin(token,openId,obj);
                }
                else
                {
                    ArrayList<Object> obj = new ArrayList<Object>();
                    WeixinArticle article = new WeixinArticle();
                    article.setTitle("【不能重绑定机器人】");
                    article.setDescription("您已经绑定"+bindCarId+"号机器人，请等待游戏的开始" );
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


    private void processCarUnSubscribeEvent(ReceiveXmlEntity xmlEntity)
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
