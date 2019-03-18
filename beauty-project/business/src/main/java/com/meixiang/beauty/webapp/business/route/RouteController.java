/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.webapp.business.route;

import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 工具 Controller
 *
 * @author ThinkGem
 * @version 2013-10-17
 */
@Controller
public class RouteController extends BaseController {


//    @RequestMapping(value ="native",method = {RequestMethod.POST, RequestMethod.GET})
//    public String elderNative(HttpServletResponse response) {
//        response.addHeader("Pragma","no-cache");
//        response.setHeader("Cache-Control","no-cache");
//        response.setHeader("Expires","0");
//        return "native/elderFirstPage";
//    }

    @RequestMapping(value ="ionic",method = {RequestMethod.POST, RequestMethod.GET})
    public String elderIonic(HttpServletResponse response) {
        response.addHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Expires","0");
        return "angular/businessIonicIndex";
    }

    @RequestMapping(value ="robotTest",method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO robotTest(@RequestBody HashMap<String,Object> testValue) {
        System.out.println("chenjiake="+testValue);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponseData("你好啊 hello");
        responseDTO.setResult("SUCCESS");
        return responseDTO;
    }

//    @RequestMapping(value ="login",method = {RequestMethod.POST, RequestMethod.GET})
//    public String elderLogin(HttpServletResponse response) {
//        response.addHeader("Pragma","no-cache");
//        response.setHeader("Cache-Control","no-cache");
//        response.setHeader("Expires","0");
//        return "native/login";
//    }

}

