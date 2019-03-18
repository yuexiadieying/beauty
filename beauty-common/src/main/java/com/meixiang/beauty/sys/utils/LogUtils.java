/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.utils;

import com.meixiang.beauty.common.config.Global;
import com.meixiang.beauty.common.utils.SpringContextHolder;
import com.meixiang.beauty.common.utils.StringUtils;
import com.meixiang.beauty.sys.dao.LogDao;
import com.meixiang.beauty.sys.entity.Log;
import com.meixiang.beauty.sys.entity.MongoLog;
import com.meixiang.beauty.sys.service.MongoDBService;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 字典工具类
 * @author ThinkGem
 * @version 2014-11-7
 */
public class LogUtils {

	private static MongoTemplate mongoTemplate = SpringContextHolder.getBean(MongoTemplate.class);

	private static ExecutorService threadExecutor = Executors.newCachedThreadPool();

	/**
	 * 保存日志
	 * @param request
	 * @param handler
	 * @param ex
	 * @param title
	 */
	public static void saveLog(HttpServletRequest request, Object handler, Exception ex, String title){
		Log log = new Log();
		log.setTitle(title);
//		log.setType(ex == null ? Log.TYPE_ACCESS : Log.TYPE_EXCEPTION);
//		log.setRemoteAddr(StringUtils.getRemoteAddr(request));
//		log.setUserAgent(request.getHeader("user-agent"));
//		log.setRequestUri(request.getRequestURI());
//		log.setParams(request.getParameterMap());
//		log.setMethod(request.getMethod());
//		log.setCreateDate(new Date());
		//插入用户的openId
//		log.setOpenId((String) request.getSession().getAttribute("openId"));
		// 异步保存日志
		Runnable thread = new SaveLogThread(log, handler, ex);
		threadExecutor.execute(thread);
	}

	/**
	 * 保存日志线程
	 */
	public static class SaveLogThread extends Thread{
		private Log log;
		private Object handler;
		private Exception ex;
		
		public SaveLogThread(Log log, Object handler, Exception ex){
			super(SaveLogThread.class.getSimpleName());
			this.log = log;
			this.handler = handler;
			this.ex = ex;

			//todo 此处将日志信息存入mongoDB库
			mongoTemplate.insert(log,"log");
		}

	}


}
