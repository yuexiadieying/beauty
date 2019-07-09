package com.meixiang.beauty.webapp.traffic.controller;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.DepartmentDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.RoleDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.sys.entity.Role;
import com.meixiang.beauty.webapp.traffic.annotation.TrafficLoginRequired;
import com.meixiang.beauty.webapp.traffic.service.UserService;
import com.mongodb.WriteResult;
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
@RequestMapping(value = "user")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @Autowired
    private MongoTemplate mongoTemplate;

    //todo 用户登录
    @RequestMapping(value = "login", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> login(@RequestBody UserInfoDTO userInfoDTO, HttpSession session){

        ResponseDTO<String> responseDTO = new ResponseDTO<>();

        Query query = new Query(Criteria.where("loginName").is(userInfoDTO.getLoginName()));
        UserInfoDTO userInfo = mongoTemplate.findOne(query,UserInfoDTO.class,"userinfo");

        if(userInfo!=null)
        {
            if(userInfoDTO.getPassword().equals(userInfo.getPassword()))
            {
                String logintoken = UUID.randomUUID().toString();
                String userInfoStr = (new Gson()).toJson(userInfo);
                session.setAttribute(logintoken, userInfoStr);
                responseDTO.setResponseData(logintoken);
                responseDTO.setResult(StatusConstant.SUCCESS);
            }else
            {
                responseDTO.setResult(StatusConstant.FAILURE);
                responseDTO.setErrorInfo("密码错误");
            }
        }
        else
        {
            responseDTO.setResult(StatusConstant.FAILURE);
            responseDTO.setErrorInfo("不存在此用户");
        }
        return  responseDTO;
    }

    //todo 用户退出登录
    @RequestMapping(value = "loginOut", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO loginOut(HttpSession session){
        ResponseDTO<UserInfoDTO> responseDTO = new ResponseDTO<>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> headerValue = getHeadersInfo(request);
        String token = headerValue.get("logintoken");
        session.removeAttribute(token);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return  responseDTO;
    }

    //todo 获取要修改的用户信息的接口
    @RequestMapping(value = "getEditUserInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO<UserInfoDTO> getEditUserInfo(@RequestParam String loginName,HttpSession httpSession){

        ResponseDTO<UserInfoDTO> responseDTO = new ResponseDTO<>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> headerValue = getHeadersInfo(request);
        String token = headerValue.get("logintoken");
        String userInfoStr = userService.getUserInfoFromToken(token,httpSession);
        UserInfoDTO userInfoDTO = (new Gson()).fromJson(userInfoStr,UserInfoDTO.class);
        
        if(userInfoDTO.getUserType().equals("管理员")||userInfoDTO.getLoginName().equals(loginName))
        {
            Query query = new Query(Criteria.where("loginName").is(loginName));
            UserInfoDTO userInfo = mongoTemplate.findOne(query,UserInfoDTO.class,"userinfo");

            if(userInfo.getDepartment()!=null)
            {
                query = new Query(Criteria.where("id").is(userInfo.getDepartment().getId()));
                DepartmentDTO departmentDTO = mongoTemplate.findOne(query,DepartmentDTO.class,"department");
                userInfo.setDepartment(departmentDTO);
            }

            if(userInfo.getRoles()!=null)
            {
                List<RoleDTO> roleDTOList = new ArrayList<>();
                for(RoleDTO roleDTO:userInfo.getRoles())
                {
                    query = new Query(Criteria.where("id").is(roleDTO.getId()));
                    roleDTO = mongoTemplate.findOne(query,RoleDTO.class,"role");
                    roleDTOList.add(roleDTO);
                }
                userInfo.setRoles(roleDTOList);
            }

            responseDTO.setResponseData(userInfo);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }
        else
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }

        return  responseDTO;
    }

    @RequestMapping(value = "getUserInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO<UserInfoDTO> getUserInfo(HttpSession session){

        ResponseDTO<UserInfoDTO> responseDTO = new ResponseDTO<>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> headerValue = getHeadersInfo(request);
        String token = headerValue.get("logintoken");
        String userInfoStr = userService.getUserInfoFromToken(token,session);
        UserInfoDTO userInfoDTO = (new Gson()).fromJson(userInfoStr,UserInfoDTO.class);

        if(userInfoDTO!=null){
            Query query = new Query(Criteria.where("loginName").is(userInfoDTO.getLoginName()));
            UserInfoDTO userInfo = mongoTemplate.findOne(query,UserInfoDTO.class,"userinfo");

            if(userInfo.getDepartment()!=null)
            {
                query = new Query(Criteria.where("id").is(userInfo.getDepartment().getId()));
                DepartmentDTO departmentDTO = mongoTemplate.findOne(query,DepartmentDTO.class,"department");
                userInfo.setDepartment(departmentDTO);
            }

            if(userInfo.getRoles()!=null)
            {
                List<RoleDTO> roleDTOList = new ArrayList<>();
                for(RoleDTO roleDTO:userInfo.getRoles())
                {
                    query = new Query(Criteria.where("id").is(roleDTO.getId()));
                    roleDTO = mongoTemplate.findOne(query,RoleDTO.class,"role");
                    roleDTOList.add(roleDTO);
                }
                userInfo.setRoles(roleDTOList);
            }

            responseDTO.setResponseData(userInfo);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }else
        {
            responseDTO.setErrorInfo("用户不存在");
            responseDTO.setResult(StatusConstant.FAILURE);
        }

        return  responseDTO;
    }

    //todo 储存用户的信息
    @RequestMapping(value = "saveUserInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO saveUserInfo(@RequestBody UserInfoDTO userInfoDTO,HttpSession session){

        ResponseDTO responseDTO = new ResponseDTO<>();

        //todo 存储用户的信息
        Query query = new Query(Criteria.where("id").is(userInfoDTO.getId()));
        UserInfoDTO userInfo = mongoTemplate.findOne(query,UserInfoDTO.class,"userinfo");

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> headerValue = getHeadersInfo(request);
        String token = headerValue.get("logintoken");
        String userInfoStr = userService.getUserInfoFromToken(token,session);
        UserInfoDTO userInfoDTO1 = (new Gson()).fromJson(userInfoStr,UserInfoDTO.class);

        if(userInfo!=null)
        {
            //todo 修改用户信息
            Update update = new Update();
            if(userInfoDTO1.getUserType().equals("管理员")&&userInfoDTO.getLoginName().equals(userInfoDTO1.getLoginName()))
            {
                update.set("loginName",userInfoDTO.getLoginName());
                update.set("password",userInfoDTO.getPassword());
                update.set("nickName",userInfoDTO.getNickname());
                mongoTemplate.updateFirst(query, update,UserInfoDTO.class, "userinfo");
            }
            else if(userInfoDTO1.getUserType().equals("管理员")&&!userInfoDTO.getLoginName().equals(userInfoDTO1.getLoginName()))
            {
                update.set("loginName",userInfoDTO.getLoginName());
                update.set("password",userInfoDTO.getPassword());
                update.set("nickName",userInfoDTO.getNickname());

                DepartmentDTO departmentDTO = new DepartmentDTO();
                departmentDTO.setId(userInfoDTO.getDepartment().getId());
                update.set("department",departmentDTO);

                List<RoleDTO> roleDTOS = userInfoDTO.getRoles();
                update.set("roles",roleDTOS);
                mongoTemplate.updateFirst(query, update,UserInfoDTO.class, "userinfo");
            }
            else if(!userInfoDTO1.getUserType().equals("管理员"))
            {
                update.set("loginName",userInfoDTO.getLoginName());
                update.set("password",userInfoDTO.getPassword());
                update.set("nickName",userInfoDTO.getNickname());
                mongoTemplate.updateFirst(query, update,UserInfoDTO.class, "userinfo");
            }
        }else
        {
            if(userInfoDTO1.getUserType().equals("管理员"))
            {
                //todo 新建用户
                mongoTemplate.insert(userInfoDTO,"userinfo");
            }
            else
            {
                responseDTO.setErrorInfo("没有权限创建用户");
            }

        }

        responseDTO.setResult(StatusConstant.SUCCESS);
        return  responseDTO;
    }

    //todo 获取系统中所有用户
    @RequestMapping(value = "getAllUserList", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO<List<UserInfoDTO>> getAllUserList(HttpSession session){

        ResponseDTO<List<UserInfoDTO>> responseDTO = new ResponseDTO<>();

        List<UserInfoDTO> userInfoDTOS = mongoTemplate.findAll(UserInfoDTO.class,"userinfo");

        for(UserInfoDTO userInfoDTO:userInfoDTOS)
        {
            if(userInfoDTO.getDepartment()!=null)
            {
                Query query = new Query(Criteria.where("id").is(userInfoDTO.getDepartment().getId()));
                DepartmentDTO departmentDTO = mongoTemplate.findOne(query,DepartmentDTO.class,"department");
                userInfoDTO.setDepartment(departmentDTO);
            }

            if(userInfoDTO.getRoles()!=null)
            {
                List<RoleDTO> roleDTOList = new ArrayList<>();
                for(RoleDTO roleDTO:userInfoDTO.getRoles())
                {
                    Query query = new Query(Criteria.where("id").is(roleDTO.getId()));
                    roleDTO = mongoTemplate.findOne(query,RoleDTO.class,"role");
                    roleDTOList.add(roleDTO);
                }
                userInfoDTO.setRoles(roleDTOList);
            }

        }

        if(userInfoDTOS.size()>0)
        {
            responseDTO.setResponseData(userInfoDTOS);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }else
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return  responseDTO;
    }

    //todo 获取系统中所有部门
    @RequestMapping(value = "getAllDepartmentList", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO<List<DepartmentDTO>> getAllDepartmentList(HttpSession session){

        ResponseDTO<List<DepartmentDTO>> responseDTO = new ResponseDTO<>();

        List<DepartmentDTO> departmentDTOS = mongoTemplate.findAll(DepartmentDTO.class,"department");

        if(departmentDTOS.size()>0)
        {
            responseDTO.setResponseData(departmentDTOS);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }else
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return  responseDTO;
    }

    //todo 新增或修改部门信息
    @RequestMapping(value = "saveDepartment", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO saveDepartment(@RequestBody DepartmentDTO departmentDTO, HttpSession session){

        ResponseDTO responseDTO = new ResponseDTO<>();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> headerValue = getHeadersInfo(request);
        String token = headerValue.get("logintoken");
        String userInfoStr = userService.getUserInfoFromToken(token,session);
        UserInfoDTO userInfoDTO = (new Gson()).fromJson(userInfoStr,UserInfoDTO.class);

        if(userInfoDTO.getUserType().equals("管理员"))
        {
            Query query = new Query(Criteria.where("id").is(departmentDTO.getId()));
            DepartmentDTO departmentDTO1 = mongoTemplate.findOne(query,DepartmentDTO.class,"department");

            if(departmentDTO1!=null)
            {
                Update update = new Update();
                update.set("departmentName",departmentDTO.getDepartmentName());
                mongoTemplate.updateFirst(query,update,DepartmentDTO.class,"department");
                responseDTO.setResult(StatusConstant.SUCCESS);
            }else
            {
                //todo 新增操作
                mongoTemplate.insert(departmentDTO,"department");
                responseDTO.setResult(StatusConstant.SUCCESS);
            }
        }
        else
        {
            responseDTO.setErrorInfo("没有权限创建部门");
            responseDTO.setResult(StatusConstant.FAILURE);
        }

        return  responseDTO;
    }

    //todo 获取系统中所有角色
    @RequestMapping(value = "getAllRoleList", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO<List<RoleDTO>> getAllRoleList(HttpSession session){

        ResponseDTO<List<RoleDTO>> responseDTO = new ResponseDTO<>();

        List<RoleDTO> roleDTOS = mongoTemplate.findAll(RoleDTO.class,"role");

        if(roleDTOS.size()>0)
        {
            responseDTO.setResponseData(roleDTOS);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }else
        {
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        return  responseDTO;
    }

    @RequestMapping(value = "saveRole", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @TrafficLoginRequired
    @ResponseBody
    ResponseDTO saveRole(@RequestBody RoleDTO roleDTO, HttpSession session){

        ResponseDTO responseDTO = new ResponseDTO<>();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> headerValue = getHeadersInfo(request);
        String token = headerValue.get("logintoken");
        String userInfoStr = userService.getUserInfoFromToken(token,session);
        UserInfoDTO userInfoDTO = (new Gson()).fromJson(userInfoStr,UserInfoDTO.class);

        if(userInfoDTO.getUserType().equals("管理员"))
        {
            Query query = new Query(Criteria.where("roleName").is(roleDTO.getRoleName()));
            RoleDTO roleDTO1 = mongoTemplate.findOne(query,RoleDTO.class,"role");

            if(roleDTO1!=null)
            {
                List<String> levels = new ArrayList<>();
                for(String level:roleDTO.getLevels())
                {
                    levels.add(level);
                }

                Update update = new Update();
                update.set("roleName",roleDTO.getRoleName());
                update.set("levels",levels);
                mongoTemplate.updateFirst(query,update,RoleDTO.class,"role");
                responseDTO.setResult(StatusConstant.SUCCESS);
            }else
            {
                //todo 新增操作
                mongoTemplate.insert(roleDTO,"role");
                responseDTO.setResult(StatusConstant.SUCCESS);
            }
        }
        else
        {
            responseDTO.setErrorInfo("没有权限创建角色");
            responseDTO.setResult(StatusConstant.FAILURE);
        }

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
