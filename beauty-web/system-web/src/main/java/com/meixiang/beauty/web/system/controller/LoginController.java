/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.web.system.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.LoginDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinTokenDTO;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.common.web.BaseController;
import com.meixiang.beauty.modules.system.api.SystemService;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import com.meixiang.beauty.sys.entity.WeixinUserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录 Controller
 *
 * @author 张博
 * @version 2017-5-5
 */
@Controller
@RequestMapping(value = "system")
public class LoginController extends BaseController {


    @Autowired
    private UserService userService;

    @Autowired
    private SystemService systemService;


    /**
     * 用户通过微信中的H5，实现手机号绑定登录
     */
    @RequestMapping(value = "userLogin", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> userLogin(@RequestBody LoginDTO loginDTO,
                                  HttpServletRequest request,
                                  HttpSession session) throws Exception {
        ResponseDTO<String> result = new ResponseDTO<>();

        //获取用户的基本信息 todo 需要完成注释部分的代码
        String openid = WeixinUtil.getOpenId(session,request);
//        if(openid==null||openid.equals(""))
//        {
//            result.setResult(StatusConstant.FAILURE);
//            result.setErrorInfo("没有openid，请在微信公众号中注册登录");
//            return result;
//        }

        String loginResult = userService.login(loginDTO.getUserPhone(), loginDTO.getCode(), request.getRemoteAddr().toString(),openid);

        if (loginResult.equals(StatusConstant.VALIDATECODE_ERROR))
        {
            result.setResult(StatusConstant.FAILURE);
            result.setErrorInfo("验证码输入不正确");
            return result;
        }
        else if (loginResult.equals(StatusConstant.WEIXIN_ATTENTION_ERROR))
        {
            result.setResult(StatusConstant.FAILURE);
            result.setErrorInfo("请在关注公众号后，再绑定登录");
            return result;
        }
        else
        {
            result.setResult(StatusConstant.SUCCESS);
            result.setErrorInfo("调用成功");
            result.setResponseData(loginResult);
            return result;
        }
    }

    @RequestMapping(value = "managerLogin", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> managerLogin(@RequestBody LoginDTO loginDTO,
                                     HttpServletRequest request,
                                     HttpSession session) throws Exception {
        ResponseDTO<String> result = new ResponseDTO<>();

        String loginResult = userService.managerLogin(loginDTO.getUserPhone(),loginDTO.getCode());

        if (loginResult.equals(StatusConstant.FAILURE))
        {
            result.setResult(StatusConstant.FAILURE);
            result.setErrorInfo("用户登录失败");
            return result;
        }
        else
        {
            result.setResult(StatusConstant.SUCCESS);
            result.setErrorInfo("用户登录成功");
            result.setResponseData(loginResult);
            return result;
        }
    }


    /**
     * 退出登录
     */
    @RequestMapping(value = "loginOut", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> loginOut(HttpServletRequest request) {
        String logintoken = request.getHeader("logintoken");
        if(logintoken==null||logintoken.equals("")){
            logintoken=request.getSession().getAttribute("token").toString();
        }
        String status = userService.loginOut(logintoken);
        ResponseDTO<UserInfoDTO> result = new ResponseDTO<>();
        result.setResult(StatusConstant.SUCCESS);
        result.setErrorInfo(status.equals(StatusConstant.LOGIN_OUT) ? "退出登录" : "保持在线");
        return result;
    }

    /**
     * 发送验证码
     */
    @RequestMapping(value = "getUserValidateCode", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO getUserValidateCode(@RequestBody UserInfoDTO userInfoDto) {
        ResponseDTO result = new ResponseDTO<>();
        try
        {
            systemService.sendUserValidateCode(userInfoDto.getMobile());
            result.setResult(StatusConstant.SUCCESS);
        }
        catch (Exception e)
        {
            result.setResult(StatusConstant.FAILURE);
        }
        return result;
    }
}
