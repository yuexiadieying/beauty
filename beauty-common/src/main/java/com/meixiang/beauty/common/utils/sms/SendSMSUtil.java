package com.meixiang.beauty.common.utils.sms;

/**
 * 发送短信工具类
 * Created by Administrator on 2017/12/12.
 */
public class SendSMSUtil {
    public static boolean sendSMS(ISendSMS sendSMS){
        return sendSMS.sendSMS();
    }
}
