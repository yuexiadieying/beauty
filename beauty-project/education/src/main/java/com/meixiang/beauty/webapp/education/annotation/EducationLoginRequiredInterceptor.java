package com.meixiang.beauty.webapp.education.annotation;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.utils.JedisUtils;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import com.meixiang.beauty.webapp.education.dto.StudentDTO;
import com.meixiang.beauty.webapp.education.dto.TeacherDTO;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zbm84 on 2017/5/24.
 */
public class EducationLoginRequiredInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {

        // 判断该方法是否加了@LoginRequired 注解
        if(mi.getMethod().isAnnotationPresent(EducationLoginRequired.class)){

            ResponseDTO<String> responseDto = new ResponseDTO<>();

            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            Map<String, String> headerValue = getHeadersInfo(request);
            String userType = headerValue.get("educationusertype");

            //验证token有效性
            if(userType.equals("student"))
            {
                String token = headerValue.get("studentlogintoken");
                if(token==null||token.equals("")){
                    try {
                        token = request.getSession().getAttribute("studentlogintoken").toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        responseDto.setResult(StatusConstant.FAILURE);
                        responseDto.setErrorInfo(StatusConstant.TOKEN_ERROR);
                        return responseDto;
                    }
                }

                String userInfoStr = JedisUtils.get(token);
                StudentDTO studentDTO = (new Gson()).fromJson(userInfoStr,StudentDTO.class);

                String schoolId = headerValue.get("schoolid");
                if(studentDTO==null||!studentDTO.getSchoolId().equals(schoolId))
                {
                    responseDto.setResult(StatusConstant.FAILURE);
                    responseDto.setErrorInfo(StatusConstant.TOKEN_ERROR);
                    return responseDto;
                }
                JedisUtils.set(token,userInfoStr,ConfigConstant.logintokenPeriod);
            }
            else if(userType.equals("teacher"))
            {
                String token = headerValue.get("teacherlogintoken");
                if(token==null||token.equals("")){
                    try {
                        token=request.getSession().getAttribute("teacherlogintoken").toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        responseDto.setResult(StatusConstant.FAILURE);
                        responseDto.setErrorInfo(StatusConstant.TOKEN_ERROR);
                        return responseDto;
                    }
                }

                String userInfoStr = JedisUtils.get(token);

                TeacherDTO teacherDTO = (new Gson()).fromJson(userInfoStr,TeacherDTO.class);

                String schoolId = headerValue.get("schoolid");
                if(teacherDTO==null||!teacherDTO.getSchoolId().equals(schoolId))
                {
                    responseDto.setResult(StatusConstant.FAILURE);
                    responseDto.setErrorInfo(StatusConstant.TOKEN_ERROR);
                    return responseDto;
                }
                JedisUtils.set(token,userInfoStr,ConfigConstant.logintokenPeriod);
            }else{
                responseDto.setResult(StatusConstant.FAILURE);
                responseDto.setErrorInfo(StatusConstant.LOGIN_OUT);
                return responseDto;
            }
        }
        //执行被拦截的方法，切记，如果此方法不调用，则被拦截的方法不会被执行。
        return mi.proceed();
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