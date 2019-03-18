package com.meixiang.beauty.webapp.education.controller;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.product.InvoiceDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.utils.DateUtils;
import com.meixiang.beauty.common.utils.JedisUtils;
import com.meixiang.beauty.sys.utils.CodeGenUtil;
import com.meixiang.beauty.webapp.education.annotation.EducationLoginRequired;
import com.meixiang.beauty.webapp.education.annotation.VpnLoginRequired;
import com.meixiang.beauty.webapp.education.dto.*;
import com.meixiang.beauty.webapp.education.dto.vpn.StatusDTO;
import com.meixiang.beauty.webapp.education.dto.vpn.VpnOrderDTO;
import com.meixiang.beauty.webapp.education.dto.vpn.VpnUserDTO;
import com.meixiang.beauty.webapp.education.service.StudentService;
import com.meixiang.beauty.webapp.education.util.EducationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.meixiang.beauty.webapp.education.util.EducationUtil.getHeadersInfo;


@Controller
@RequestMapping(value = "vpnservice")
public class VPNController {

    @Autowired
    private MongoTemplate mongoTemplate;

    //todo 用户注册接口
    @RequestMapping(value = "registerUser", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO registerUser(@RequestBody VpnUserDTO vpnUserDTO){

        ResponseDTO responseDTO = new ResponseDTO<>();

        //用户注册
        Query query = new Query().addCriteria(Criteria.where("userEmail").is(vpnUserDTO.getUserEmail()));
        VpnUserDTO vpnUserDTO1 = mongoTemplate.findOne(query, VpnUserDTO.class,"vpnUser");
        if(vpnUserDTO1!=null)
        {
            responseDTO.setErrorInfo("Sorry, The Email you input has already been registered");
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        else
        {
            mongoTemplate.insert(vpnUserDTO,"vpnUser");
            responseDTO.setResult(StatusConstant.SUCCESS);
        }
        return  responseDTO;
    }

    public class SimpleAuthenticator extends Authenticator {

        private String username;

        private String password;

        public SimpleAuthenticator(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.username, this.password);

        }

    }

    //todo 找回密码
    @RequestMapping(value = "findPassword", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO findPassword(@RequestBody VpnUserDTO vpnUserDTO){

        ResponseDTO responseDTO = new ResponseDTO();

        // 收件人电子邮箱
        String to = vpnUserDTO.getUserEmail();

        // 发件人电子邮箱
        String from = "ultimium.vpn@gmail.com";

        // 指定发送邮件的主机为 localhost
        String host = "smtp.gmail.com";

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");
        properties.put("mail.stmp.user" , "ultimium.vpn@gmail.com");
        properties.put("mail.smtp.password" , "shabicry");

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new SimpleAuthenticator("ultimium.vpn@gmail.com", "shabicry"));

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("your vpn password!");

            // 设置消息体
            Query query = new Query().addCriteria(Criteria.where("userEmail").is(vpnUserDTO.getUserEmail()));
            VpnUserDTO vpnUserDTO1 = mongoTemplate.findOne(query, VpnUserDTO.class,"vpnUser");
            message.setText(vpnUserDTO1.getPassword());

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }

        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    //todo 用户登录接口
    @RequestMapping(value = "loginUser", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> loginUser(@RequestBody VpnUserDTO vpnUserDTO){

        ResponseDTO<String> responseDTO = new ResponseDTO<>();

        //用户登录接口
        Query query = new Query().addCriteria(Criteria.where("userEmail").is(vpnUserDTO.getUserEmail()));
        VpnUserDTO vpnUserDTO1 = mongoTemplate.findOne(query, VpnUserDTO.class,"vpnUser");
        if(vpnUserDTO1==null)
        {
            responseDTO.setErrorInfo("Sorry, you have not register this account");
            responseDTO.setResponseData(null);
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        else if(!vpnUserDTO1.getPassword().equals(vpnUserDTO.getPassword()))
        {
            responseDTO.setErrorInfo("Sorry, the password you input is not correct");
            responseDTO.setResponseData(null);
            responseDTO.setResult(StatusConstant.FAILURE);
        }
        else
        {
            String vpnUserStr = (new Gson()).toJson(vpnUserDTO);
            String loginToken = UUID.randomUUID().toString();
            JedisUtils.set(loginToken,vpnUserStr,ConfigConstant.logintokenPeriod);
            responseDTO.setResponseData(loginToken);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }
        return  responseDTO;
    }

    //todo 用户成功购买VPN服务
    @RequestMapping(value = "buyVpnService", method = {RequestMethod.POST, RequestMethod.GET})
    @VpnLoginRequired
    public
    @ResponseBody
    ResponseDTO<VpnOrderDTO> buyVpnService(@RequestParam String vpnServiceStartDate,
                                           @RequestParam String vpnServiceEndDate){

        ResponseDTO<VpnOrderDTO> responseDTO = new ResponseDTO<>();

        //用户成功购买VPN服务
        VpnUserDTO vpnUserDTO = EducationUtil.getVpnUserFromRedis();
        Query query = new Query().addCriteria(Criteria.where("userEmail").is(vpnUserDTO.getUserEmail())).addCriteria(Criteria.where("status").is("1"));;
        List<VpnOrderDTO> vpnOrderDTOS = mongoTemplate.find(query, VpnOrderDTO.class,"vpnOrder");
        if(vpnOrderDTOS.size()>0)
        {
            VpnOrderDTO vpnOrderDTO = vpnOrderDTOS.get(0);
            Update update = new Update();
            update.set("orderId",vpnOrderDTO.getOrderId());
            update.set("status","0");
            update.set("userEmail",vpnOrderDTO.getUserEmail());
            update.set("vpnServiceStartDate",vpnOrderDTO.getVpnServiceStartDate());
            update.set("vpnServiceEndDate",vpnServiceEndDate);
            mongoTemplate.updateFirst(query,update,"vpnOrder");

            responseDTO.setResponseData(vpnOrderDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }
        else
        {
            String orderId = CodeGenUtil.getOrderCodeNumber();
            VpnOrderDTO vpnOrderDTO = new VpnOrderDTO();
            vpnOrderDTO.setOrderId(orderId);
            vpnOrderDTO.setStatus("1");
            vpnOrderDTO.setVpnServiceStartDate(vpnServiceStartDate);
            vpnOrderDTO.setVpnServiceEndDate(vpnServiceEndDate);
            vpnOrderDTO.setUserEmail(vpnUserDTO.getUserEmail());
            mongoTemplate.insert(vpnOrderDTO,"vpnOrder");
            responseDTO.setResponseData(vpnOrderDTO);
            responseDTO.setResult(StatusConstant.SUCCESS);
        }

        return  responseDTO;
    }

    //todo 客户端查询vpn服务是否到期
    @RequestMapping(value = "status", method = {RequestMethod.POST, RequestMethod.GET})
    @VpnLoginRequired
    public
    @ResponseBody
    ResponseDTO<StatusDTO> status(){

        ResponseDTO<StatusDTO> responseDTO = new ResponseDTO<>();
        StatusDTO statusDTO = new StatusDTO();

        //通过业务层的代码，实现新闻ID，获取新闻的详细内容。
        VpnUserDTO vpnUserDTO = EducationUtil.getVpnUserFromRedis();
        Query query = new Query().addCriteria(Criteria.where("userEmail").is(vpnUserDTO.getUserEmail())).addCriteria(Criteria.where("status").is("1"));;
        List<VpnOrderDTO> vpnOrderDTOS = mongoTemplate.find(query, VpnOrderDTO.class,"vpnOrder");
        if(vpnOrderDTOS.size()>0)
        {
            VpnOrderDTO vpnOrderDTO = vpnOrderDTOS.get(0);
            String serviceEndDate = vpnOrderDTO.getVpnServiceEndDate();
            int flag = compare_date(serviceEndDate,DateUtils.getDate());
            statusDTO.setOrderId(vpnOrderDTO.getOrderId());
            statusDTO.setVpnServiceStartDate(vpnOrderDTO.getVpnServiceStartDate());
            statusDTO.setVpnServiceEndDate(vpnOrderDTO.getVpnServiceEndDate());
            responseDTO.setResponseData(statusDTO);
            if(flag==1)
            {
                responseDTO.setErrorInfo("you have a active vpn service");
                responseDTO.setResult(StatusConstant.SUCCESS);
            }
            else if(flag==-1)
            {
                Update update = new Update();
                update.set("orderId",vpnOrderDTO.getOrderId());
                update.set("status","0");
                update.set("userEmail",vpnOrderDTO.getUserEmail());
                update.set("vpnServiceStartDate",vpnOrderDTO.getVpnServiceStartDate());
                update.set("vpnServiceEndDate",vpnOrderDTO.getVpnServiceEndDate());
                mongoTemplate.updateFirst(query,update,"vpnOrder");

                responseDTO.setErrorInfo("Sorry,your vpn service is out of date");
                responseDTO.setResult(StatusConstant.FAILURE);
            }
        }
        else
        {
            responseDTO.setErrorInfo("Sorry,you have a active vpn service");
            responseDTO.setResponseData(null);
            responseDTO.setResult(StatusConstant.FAILURE);
        }

        return  responseDTO;
    }

    public static int compare_date(String DATE1, String DATE2) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

}
