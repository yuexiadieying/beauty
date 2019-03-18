/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.modules.system.util;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.utils.JedisUtils;
import com.meixiang.beauty.common.utils.SpringContextHolder;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.sys.entity.ReceiveXmlEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用户工具类
 * @author ThinkGem
 * @version 2013-12-05
 */
public class UserUtils {

	private static UserService userService = (UserService) SpringContextHolder.getBean(UserService.class);

	private static ExecutorService threadExecutorCached = Executors.newCachedThreadPool();

	private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

	public static UserInfoDTO getUserInfoFromRedis(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Map<String, String> tokenValue = getHeadersInfo(request);
		String token = tokenValue.get("logintoken");
		String userInfoStr = JedisUtils.get(token);
		UserInfoDTO userInfoDTO = (new Gson()).fromJson(userInfoStr,UserInfoDTO.class);

		//开启一个线程，主要用来同步userType信息到redis中
		Runnable processUserInfoSynchronize = new processUserInfoSynchronize(token,userInfoDTO);
		threadExecutorCached.execute(processUserInfoSynchronize);

		return userInfoDTO;
	}

	private static class processUserInfoSynchronize extends Thread {

		private String logintoken;
		private UserInfoDTO userInfoDTO;

		public processUserInfoSynchronize(String logintoken,UserInfoDTO userInfoDTO) {
			this.logintoken = logintoken;
			this.userInfoDTO = userInfoDTO;
		}

		@Override
		public void run() {

			UserBusinessTypeDTO userBusinessTypeDTO = new UserBusinessTypeDTO();
			userBusinessTypeDTO.setStatus("1");
			userBusinessTypeDTO.setSysUserId(userInfoDTO.getId());
			List<UserBusinessTypeDTO> userBusinessTypeDTOList = userService.getUserBusinessType(userBusinessTypeDTO);
			if(userBusinessTypeDTOList.size()>0)
			{
				if(!userBusinessTypeDTOList.get(0).getUserType().equals(userInfoDTO.getUserType()))
				{
					userInfoDTO.setUserType(userBusinessTypeDTOList.get(0).getUserType());
					String userInfoStr = (new Gson()).toJson(userInfoDTO);
					JedisUtils.set(logintoken,userInfoStr,ConfigConstant.logintokenPeriod);
				}
			}
		}
	}

	public static Map<String, String> getHeadersInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}

	public static UserInfoDTO getUserInfoFromUserId(String sysUserId) {
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO.setId(sysUserId);
		List<UserInfoDTO> userInfoDTOS = userService.getUserInfo(userInfoDTO);
		if(userInfoDTOS.size()>0)
		{
			return userInfoDTOS.get(0);
		}else
		{
			return new UserInfoDTO();
		}
	}
}
