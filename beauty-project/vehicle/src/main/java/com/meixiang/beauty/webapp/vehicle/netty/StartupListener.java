package com.meixiang.beauty.webapp.vehicle.netty;

import io.netty.channel.ChannelFuture;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.InetSocketAddress;

public class StartupListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		Runnable rn = new Runnable() {
		    public void run() {
		    	final ChatServer chatServer = new ChatServer();
				ChannelFuture f1 = chatServer.start(new InetSocketAddress(8888));

				System.out.println("server start................");
				Runtime.getRuntime().addShutdownHook(new Thread() {
					@Override
					public void run() {
						chatServer.destroy();
					}
				});
				f1.channel().closeFuture().syncUninterruptibly();
		    }
		};
		
		new Thread(rn).start();
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
