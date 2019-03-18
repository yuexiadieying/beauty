package com.meixiang.beauty.web.account.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dataSource.DataSourceInstances;
import com.meixiang.beauty.common.dataSource.DataSourceSwitch;
import com.meixiang.beauty.common.dto.account.PrePayInfoDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import com.meixiang.beauty.common.utils.RedisLock;
import com.meixiang.beauty.common.utils.XMLUtil;
import com.meixiang.beauty.modules.account.AccountService;
import com.meixiang.beauty.modules.account.PayRecordService;
import com.meixiang.beauty.modules.wechat.api.WeixinPayService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * 微信页面参数获取相关的控制类
 * Created by baoweiw on 2015/7/27.
 */

@Controller
@RequestMapping(value = "account")
public class AccountPayController {

    @Autowired
    private PayRecordService payRecordService;

    @Autowired
    private WeixinPayService weixinPayService;

    /**
     * js支付
     */
    @RequestMapping(value = "pay/{productType}", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<PrePayInfoDTO> userPay(HttpServletRequest request, HttpSession session, @PathVariable String productType) throws Exception {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);

        ResponseDTO<PrePayInfoDTO> responseDTO = new ResponseDTO<>();

        //获取统一支付接口参数
        PrePayInfoDTO prePayInfoDTO = payRecordService.getPrepayInfo(request, session, productType);

        if(prePayInfoDTO.getResult().equals(StatusConstant.FAILURE))
        {
            responseDTO.setResult(StatusConstant.FAILURE);
            responseDTO.setErrorInfo("支付失败");
        }
        else if(prePayInfoDTO.getResult().equals(StatusConstant.SUCCESS))
        {
            responseDTO.setResult(StatusConstant.SUCCESS);
            responseDTO.setResponseData(prePayInfoDTO);
        }

        return responseDTO;
    }

    /**
     * 接收支付成后微信notify_url参数中传来的参数
     * 支付完成 后服务器故障 事物无法回滚
     * */
    @RequestMapping(value = "getOfflineProductPayNotifyInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String getOfflineProductPayNotifyInfo(HttpServletRequest request) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);

        InputStream inStream = null;
        try {
            inStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            inStream.close();
            String result  = new String(outSteam.toByteArray(),"utf-8");
            Map<String, Object> map = XMLUtil.doXMLParse(result);
            //放入service层进行事物控制
            if("SUCCESS".equals(map.get("return_code"))){
                String accountNeedPay = (String) map.get("attach");//未来此处，作为账户余额支付的入口
                PayRecordDTO payRecordDTO = new PayRecordDTO();
                payRecordDTO.setOutTradeNo((String) map.get("out_trade_no"));
                payRecordDTO.setStatus("0");

                weixinPayService.handleOfflineProductPayNotifyInfo(accountNeedPay, payRecordDTO);
            }
            return  XMLUtil.setXML("SUCCESS", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 接收支付成后微信notify_url参数中传来的参数
     * 支付完成 后服务器故障 事物无法回滚
     * */
    @RequestMapping(value = "getTrainingProductPayNotifyInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String getTrainingProductPayNotifyInfo(HttpServletRequest request) {
        DataSourceSwitch.setDataSourceType(DataSourceInstances.WRITE);

        RedisLock redisLock = new RedisLock("trainingProductPayNotifyInfo");
        redisLock.lock();
        InputStream inStream = null;
        try {
            inStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            inStream.close();
            String result  = new String(outSteam.toByteArray(),"utf-8");
            Map<String, Object> map = XMLUtil.doXMLParse(result);

            //放入service层进行事物控制
            if("SUCCESS".equals(map.get("return_code"))){
                String accountNeedPay = (String) map.get("attach");
                PayRecordDTO payRecordDTO = new PayRecordDTO();
                payRecordDTO.setOutTradeNo((String) map.get("out_trade_no"));
                payRecordDTO.setStatus("0");
                weixinPayService.handleTrainingProductPayNotifyInfo(accountNeedPay, payRecordDTO);
            }
            return  XMLUtil.setXML("SUCCESS", "");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            redisLock.unlock();
        }
        return "";
    }

}
