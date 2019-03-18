package com.meixiang.beauty.webapp.education.controller;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinConfigDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinTokenDTO;
import com.meixiang.beauty.common.utils.*;
import com.meixiang.beauty.common.web.BaseController;
import com.meixiang.beauty.sys.entity.WeixinUserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chenjiake on 17/11/4.
 * 负责响应微商平台用户端微信公众平台的请求
 *
 */

@Controller
@RequestMapping(value = "weixin")
public class EducationWeixinController extends BaseController {


}
