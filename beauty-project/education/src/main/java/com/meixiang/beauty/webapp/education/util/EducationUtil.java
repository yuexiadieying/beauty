package com.meixiang.beauty.webapp.education.util;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.utils.JedisUtils;
import com.meixiang.beauty.sys.entity.Article;
import com.meixiang.beauty.sys.entity.MusicMessage;
import com.meixiang.beauty.sys.entity.NewsMessage;
import com.meixiang.beauty.sys.entity.TextMessage;
import com.meixiang.beauty.webapp.education.dto.SchoolDTO;
import com.meixiang.beauty.webapp.education.dto.StudentDTO;
import com.meixiang.beauty.webapp.education.dto.TeacherDTO;
import com.meixiang.beauty.webapp.education.dto.vpn.VpnUserDTO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.Writer;
import java.util.*;


public class EducationUtil {

	public static StudentDTO getStudentFromRedis(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Map<String, String> tokenValue = getHeadersInfo(request);
		String token = tokenValue.get("studentlogintoken");
		String userInfoStr = JedisUtils.get(token);
		StudentDTO studentDTO = (new Gson()).fromJson(userInfoStr,StudentDTO.class);
		return studentDTO;
	}

	public static TeacherDTO getTeacherFromRedis(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Map<String, String> tokenValue = getHeadersInfo(request);
		String token = tokenValue.get("teacherlogintoken");
		String userInfoStr = JedisUtils.get(token);
		TeacherDTO teacherDTO = (new Gson()).fromJson(userInfoStr,TeacherDTO.class);
		return teacherDTO;
	}

	public static VpnUserDTO getVpnUserFromRedis(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Map<String, String> tokenValue = getHeadersInfo(request);
		String token = tokenValue.get("logintoken");
		String userInfoStr = JedisUtils.get(token);
		VpnUserDTO vpnUserDTO = (new Gson()).fromJson(userInfoStr,VpnUserDTO.class);
		return vpnUserDTO;
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

	//自动推算出当前是第几周
	public static Integer getCurrentWeekIndex(Date startSchoolDate,Integer weekIndex)
	{
		//若weekData为空，则业务层自动算出当前所处的时间第几周
		if (weekIndex == 0) {
			try {
				int days = (int) ((new Date().getTime() - startSchoolDate.getTime()) / (1000*3600*24));
				Calendar c = Calendar.getInstance();
				int week = 1;
				weekIndex=1;
				c.setTime(startSchoolDate);
				for(int i=0;i<days;i++){
					c.add(Calendar.DATE,1);
					week = c.get(Calendar.DAY_OF_WEEK)-1;
					if(c.getTime().getTime()>=new Date().getTime()){
						break;
					}
					if(week==1){
						weekIndex++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return weekIndex;
	}

}
