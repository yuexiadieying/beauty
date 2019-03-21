package com.meixiang.beauty.webapp.car.netty;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
	
	private final String wsUri;
	
	public HttpRequestHandler(String wsUri) {
		super();
		this.wsUri = wsUri;
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg)
			throws Exception {
		ctx.fireChannelInactive();
		
		if(wsUri.equalsIgnoreCase(msg.getUri())){
			ctx.fireChannelRead(msg.retain());
		}
		
		Channel channel = ctx.channel();

		JSONObject obj = new JSONObject();
		obj.put("response", "connected");
		TextWebSocketFrame frame = new TextWebSocketFrame(obj.toJSONString());
		channel.writeAndFlush(frame.retain());

		ctx.fireChannelRead(msg.retain());
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		ctx.close();
		cause.printStackTrace(System.err);
	}

}