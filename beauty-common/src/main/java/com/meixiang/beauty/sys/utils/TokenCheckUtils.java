/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.utils;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.utils.JedisUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户工具类
 * @author ThinkGem
 * @version 2013-12-05
 */
public class TokenCheckUtils {

	public static void checkTokenValidate(HttpServletRequest request) throws Exception {

		Map<String, String> tokenValue = getHeadersInfo(request);
		String token = tokenValue.get("logintoken");

		//验证token有效性
		int logintokenPeriod = ConfigConstant.logintokenPeriod;
		UserInfoDTO user = (UserInfoDTO) JedisUtils.getObject(token);
		if(user==null)
		{
			throw new Exception("logintokenError");
		}
		JedisUtils.setObject(token, user, logintokenPeriod);
	}

	//get request headers
	private static Map<String, String> getHeadersInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}
}
