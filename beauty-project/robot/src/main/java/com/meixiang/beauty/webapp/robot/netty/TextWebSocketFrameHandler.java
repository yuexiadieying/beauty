package com.meixiang.beauty.webapp.robot.netty;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.meixiang.beauty.common.utils.SpringContextHolder;
import com.meixiang.beauty.webapp.robot.service.RobotSocketService;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private transient static final Logger log = LoggerFactory.getLogger(TextWebSocketFrameHandler.class);

    private static ExecutorService threadExecutorCached = Executors.newCachedThreadPool();
    
    public TextWebSocketFrameHandler() {
        super();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
            throws Exception {
        if (evt == WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE) {
            ctx.pipeline().remove(HttpRequestHandler.class);
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                TextWebSocketFrame msg) throws Exception {

        String msgText = msg.text();
        Channel channel = ctx.channel();

        //开启线程处理所有的消息
        Runnable processMessageThread = new ProcessMessageThread(msgText,channel);
        threadExecutorCached.execute(processMessageThread);
    }

    private class ProcessMessageThread extends Thread {

        private String msgText;
        private Channel channel;

        public ProcessMessageThread(String msgText, Channel channel) {
            this.msgText = msgText;
            this.channel = channel;
        }

        @Override
        public void run() {

            Map<String, Object> msgMap = null;
            try
            {
                msgMap = (Map<String, Object>) JSON.parse(msgText);
                String messageType = String.valueOf(msgMap.get("messageType"));

                if("deviceOnline".equals(messageType))
                {
                    RobotSocketService.getRobotSocketService().processDeviceOnlineService(msgMap,channel);
                }
                else if("robotAttack".equals(messageType))
                {
                    RobotSocketService.getRobotSocketService().processRobotAttackService(msgMap,channel);
                }
                else if("robotGoal".equals(messageType))
                {
                    RobotSocketService.getRobotSocketService().processRobotGoalService(msgMap,channel);
                }
                else if("deviceProblem".equals(messageType))
                {
                    RobotSocketService.getRobotSocketService().processDeviceProblemService(msgMap,channel);
                }
                else if("gameServerHeart-Ctrl".equals(messageType))
                {
                    RobotSocketService.getRobotSocketService().processServerHeartBeatCtrl(msgMap,channel);
                }

            }
            catch (JSONException ex)
            {
                log.info("Parse json error: " + ex.getMessage() + " : " + msgText);
                return;
            }
        }
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        this.channelInactive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("enter channelInactive()");
        log.info("finish channelInactive()");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}
