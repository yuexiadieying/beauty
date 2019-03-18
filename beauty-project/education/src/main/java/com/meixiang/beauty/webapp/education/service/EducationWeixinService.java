package com.meixiang.beauty.webapp.education.service;

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
import com.meixiang.beauty.webapp.education.util.MessageUtil;
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
public class EducationWeixinService {

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
    }




}
