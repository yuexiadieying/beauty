package com.meixiang.beauty.modules.weixin.impl;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.utils.*;
import com.meixiang.beauty.modules.wechat.api.WeixinCoreService;
import com.meixiang.beauty.modules.weixin.event.ProcessClickEventService;
import com.meixiang.beauty.modules.weixin.event.ProcessScanEventService;
import com.meixiang.beauty.modules.weixin.event.ProcessSubscribeEventService;
import com.meixiang.beauty.modules.weixin.event.ProcessViewEventService;
import com.meixiang.beauty.modules.weixin.util.MessageUtil;
import com.meixiang.beauty.sys.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.io.IOException;
import java.util.*;

/**
 * Created by chenjiake on 2017/9/11.
 */
@Service
@Transactional(readOnly = false)
public class WeixinCoreServiceImpl implements WeixinCoreService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    ProcessViewEventService processClickViewEvent;

    @Autowired
    ProcessScanEventService processScanEventService;

    @Autowired
    ProcessSubscribeEventService processSubscribeEventService;

    @Autowired
    ProcessClickEventService processClickEventService;

    @Override
    public String processWeixinRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
                processScanEventService.processEvent(xmlEntity);
            }
            else if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE))
            {
                //扫描关注公众号或者搜索关注公众号都在其中
                processSubscribeEventService.processSubscribeEvent(xmlEntity);
            }
            else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE))
            {
                // 取消订阅
                processSubscribeEventService.processUnSubscribeEvent(xmlEntity);
            }
            else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK))
            {
                // 自定义菜单点击事件
                respMessage = processClickEventService.processEvent(xmlEntity,request,response);
            }
            else if (eventType.equals(MessageUtil.EVENT_TYPE_VIEW))
            {
                //点击带URL菜单事件
                processClickViewEvent.processEvent(xmlEntity);
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

    @Override
    public void updateWeixinToken(){
        try {
            System.out.print("用户端微信参数更新");
            String token = WeixinUtil.getTokenFromTX(ConfigConstant.CORPID, ConfigConstant.SECTET);
            if(StringUtils.isNotNull(token)) {
                String ticket = WeixinUtil.getJsapiTicket(token);
                Query query = new Query().addCriteria(Criteria.where("weixinFlag").is(ConfigConstant.weixinFlag));
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
