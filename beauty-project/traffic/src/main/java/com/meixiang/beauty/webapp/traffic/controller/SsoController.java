package com.meixiang.beauty.webapp.traffic.controller;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.DepartmentDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.RoleDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.webapp.traffic.utils.EncryptUtil;
import com.meixiang.beauty.webapp.traffic.annotation.TrafficLoginRequired;
import com.meixiang.beauty.webapp.traffic.dto.sso.SsoDTO;
import com.meixiang.beauty.webapp.traffic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

//智慧公交
@Controller
@RequestMapping(value = "sso")
public class SsoController {

    @Autowired
    private UserService userService;

    @Autowired
    private MongoTemplate mongoTemplate;

    //todo 同步用户
    @RequestMapping(value = "syncUser", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> login(@RequestBody SsoDTO ssoDTO){

        ResponseDTO<String> responseDTO = new ResponseDTO<>();

        synchronized(ssoDTO.getLoginName()){
            List<SsoDTO> ssoDTOS = mongoTemplate.findAll(SsoDTO.class,"sso");

            if(ssoDTOS.size()>0){

                for(SsoDTO ssoDTO1:ssoDTOS)
                {
                    if(ssoDTO1.getPlatformFlag().equals(ssoDTO.getPlatformFlag())&&ssoDTO1.getPlatformSecret().equals(ssoDTO.getPlatformSecret()))
                    {
                        UserInfoDTO userInfoDTO = new UserInfoDTO();
                        userInfoDTO.setNickname(ssoDTO.getLoginName());
                        userInfoDTO.setLoginName(ssoDTO.getLoginName());
                        userInfoDTO.setPassword(ssoDTO.getLoginPassword());
                        userInfoDTO.setUserType(ssoDTO.getPlatformFlag());

                        Query query = new Query(Criteria.where("loginName").is(ssoDTO.getLoginName()))
                                .addCriteria(Criteria.where("userType").is(ssoDTO.getPlatformFlag()));
                        UserInfoDTO userInfoDTO1 = mongoTemplate.findOne(query,UserInfoDTO.class,"userinfo");

                        if(userInfoDTO1==null)
                        {
                            query = new Query(Criteria.where("departmentName").is(ssoDTO1.getPlatformName()));
                            DepartmentDTO departmentDTO = mongoTemplate.findOne(query,DepartmentDTO.class,"department");
                            userInfoDTO.setDepartment(departmentDTO);

                            query = new Query(Criteria.where("roleName").is(ssoDTO1.getPlatformName()));
                            RoleDTO roleDTO = mongoTemplate.findOne(query,RoleDTO.class,"role");

                            List<RoleDTO> roleDTOS = new ArrayList<>();
                            roleDTOS.add(roleDTO);
                            userInfoDTO.setRoles(roleDTOS);

                            mongoTemplate.insert(userInfoDTO,"userinfo");

                            query = new Query(Criteria.where("platformFlag").is(ssoDTO.getPlatformFlag()));
                            Update update = new Update();
                            update.set("platformURL",ssoDTO.getPlatformURL());
                            mongoTemplate.updateFirst(query,update,SsoDTO.class,"sso");

                            responseDTO.setResult("Sync Success");
                        }else
                        {
                            responseDTO.setResult("Sync Failure");
                        }

                    }else
                    {
                        responseDTO.setResult("Sync Failure");
                    }

                }

            }else{
                responseDTO.setResult("Sync Failure");
            }
        }

        return  responseDTO;
    }

    @RequestMapping(value = "encryptSSO", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO<SsoDTO> encryptSSO(HttpSession httpSession){

        ResponseDTO<SsoDTO> responseDTO = new ResponseDTO<>();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> headerValue = getHeadersInfo(request);
        String token = headerValue.get("logintoken");
        String userInfoStr = userService.getUserInfoFromToken(token,httpSession);
        UserInfoDTO userInfoDTO = (new Gson()).fromJson(userInfoStr,UserInfoDTO.class);

        Query query = new Query(Criteria.where("id").is(userInfoDTO.getDepartment().getId()));
        DepartmentDTO departmentDTO = mongoTemplate.findOne(query,DepartmentDTO.class,"department");

        query = new Query(Criteria.where("platformName").is(departmentDTO.getDepartmentName()));
        SsoDTO ssoDTO = mongoTemplate.findOne(query,SsoDTO.class,"sso");

        if(ssoDTO!=null){
            String str = userInfoDTO.getLoginName()+":"+userInfoDTO.getPassword();
            String secretStr = EncryptUtil.getInstance().AESencode(str,ssoDTO.getPlatformSecret());
            ssoDTO.setPlatformEncrypt(secretStr);
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setResponseData(ssoDTO);
        }else{
            responseDTO.setResult(StatusConstant.FAILURE);
            responseDTO.setErrorInfo("对不起，你不是此系统平台的用户");
            responseDTO.setResponseData(ssoDTO);
        }

        return  responseDTO;
    }


    @RequestMapping(value = "zhgj", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> zhgj(@RequestParam String secretStr,@RequestParam String platformFlag){

        ResponseDTO<String> responseDTO = new ResponseDTO<>();

        Query query = new Query(Criteria.where("platformFlag").is(platformFlag));
        SsoDTO ssoDTO = mongoTemplate.findOne(query,SsoDTO.class,"sso");

        String value = EncryptUtil.getInstance().AESdecode(secretStr,ssoDTO.getPlatformSecret());

        responseDTO.setResult(StatusConstant.SUCCESS);
        responseDTO.setResponseData(value);
        return  responseDTO;
    }

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
