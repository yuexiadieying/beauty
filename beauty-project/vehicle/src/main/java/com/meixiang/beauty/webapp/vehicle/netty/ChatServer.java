package com.meixiang.beauty.webapp.vehicle.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class ChatServer {
	private final EventLoopGroup workerGroup = new NioEventLoopGroup();
	
	private Channel channel;
	
	public ChannelFuture start(InetSocketAddress address){
		try {
			ServerBootstrap boot = new ServerBootstrap();
			boot.group(workerGroup).channel(NioServerSocketChannel.class).childHandler(createInitializer());

			//绑定端口
			ChannelFuture f = boot.bind(address).syncUninterruptibly();
			channel = f.channel();
			return f;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	protected ChannelHandler createInitializer() {
		return new ChatServerInitializer();
	}
	
	public void destroy(){
		if(channel != null)
			channel.close();
		workerGroup.shutdownGracefully();
	}

}
