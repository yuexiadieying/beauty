/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.webapp.business.pay;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.web.BaseController;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * 工具 Controller
 *
 * @author ThinkGem
 * @version 2013-10-17
 */
@Controller
public class OrderPayController extends BaseController {

    /**
     *
     * 处理来自微信服务器的请求
     *
     */
    @LoginRequired
    @RequestMapping(value = "orderPay.do", method = {RequestMethod.POST, RequestMethod.GET})
    public String wxPay(@RequestParam String productType, @RequestParam(required=false) String productId, Model model) {

        if(productType.equals("offlineProduct")){
            model.addAttribute("productType", productType);
            return "native/orderPay";
        }
        else if(productType.equals("trainingProduct"))
        {
            model.addAttribute("productType", productType);
            model.addAttribute("productId", productId);
            return "native/orderPay";
        }
        else
        {
            return null;
        }
    }

}

