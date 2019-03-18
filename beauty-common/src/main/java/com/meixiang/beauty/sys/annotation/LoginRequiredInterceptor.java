package com.meixiang.beauty.sys.annotation;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.utils.JedisUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zbm84 on 2017/5/24.
 */
public class LoginRequiredInterceptor implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {

        // 判断该方法是否加了@LoginRequired 注解
        if(mi.getMethod().isAnnotationPresent(LoginRequired.class)){

            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            Map<String, String> tokenValue = getHeadersInfo(request);
            String token = tokenValue.get("logintoken");
            if(token==null||token.equals("")){
                try {
                    token=request.getSession().getAttribute("token").toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    ResponseDTO<String> responseDto=new ResponseDTO<>();
                    responseDto.setResult(StatusConstant.FAILURE);
                    responseDto.setErrorInfo(StatusConstant.TOKEN_ERROR);
                    return responseDto;
                }
            }
            //验证token有效性
            String userInfoStr = JedisUtils.get(token);
            UserInfoDTO user = (new Gson()).fromJson(userInfoStr,UserInfoDTO.class);
            if(user==null)
            {
                ResponseDTO<String> responseDto=new ResponseDTO<>();
                responseDto.setResult(StatusConstant.FAILURE);
                responseDto.setErrorInfo(StatusConstant.TOKEN_ERROR);
                return responseDto;
            }
            JedisUtils.set(token,userInfoStr,ConfigConstant.logintokenPeriod);
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