package com.meixiang.beauty.webapp.vehicle.service;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.webapp.vehicle.dao.TransportDao;
import com.rabbitmq.client.Channel;
import org.apache.commons.collections.ListUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class ActivityListener implements ChannelAwareMessageListener {

    private static final Logger log =  LoggerFactory.getLogger(ActivityListener.class);

    @Autowired
    TransportDao transportDao;

    static SqlSession sqlSession = (SqlSession) new ClassPathXmlApplicationContext("classpath:spring-context-sqlserver.xml").getBean("sqlSession");

    @Override
    @Transactional
    public void onMessage(Message message, Channel channel) {
        try {
            System.out.printf("插入信息：%tc%n",new Date());
            String news = new String(message.getBody(),"utf-8");
            Gson gson = new Gson();
            List<Map> list = gson.fromJson(news, List.class);
            /*for(int i=0;i<list.size();i++){
                transportDao.insert_T_CheLiangJiBenXinXi(list.get(i));
            }*/
            //transportDao.insert_T_CheLiangJiBenXinXiBatch(list);
            sqlSession.insert("insert_T_CheLiangJiBenXinXiBatch",list);

            System.out.printf("插入信息：%tc%n",new Date());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}