package com.meixiang.beauty.common.utils.sms.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.meixiang.beauty.common.utils.sms.DictSMS;
import com.meixiang.beauty.common.utils.sms.ISendSMS;
import com.meixiang.beauty.common.utils.sms.LoadProperties;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/12.
 */
public class SendSMS implements ISendSMS{

    private final static Logger log = Logger.getLogger(SendSMS.class);

    private static String aliyun_sms_region_id = "";    //阿里云regionId 地区id
    private static String aliyun_sms_access_key_id = "";    //阿里云 accessKeyId
    private static String aliyun_sms_access_key_secret = "";    //阿里云 accessKeySecret
    private static String aliyun_sms_end_point_name = "";   //阿里云end_point_name
    private static String aliyun_sms_product = "";  //阿里云产品
    private static String aliyun_sms_domain = "";   //阿里云调用短信服务平台接口域名

    private String signName;    //阿里云短信签名
    private String templateCode;    //阿里云短信模板Code
    private String paramString; //阿里云短信模板参数字符串
    private String recNum;  //发送短信手机号

    static{
        aliyun_sms_region_id = LoadProperties.readValue("aliyun_sms_region_id");
        aliyun_sms_access_key_id = LoadProperties.readValue("aliyun_sms_access_key_id");
        aliyun_sms_access_key_secret = LoadProperties.readValue("aliyun_sms_access_key_secret");
        aliyun_sms_end_point_name = LoadProperties.readValue("aliyun_sms_end_point_name");
        aliyun_sms_product = LoadProperties.readValue("aliyun_sms_product");
        aliyun_sms_domain = LoadProperties.readValue("aliyun_sms_domain");
    }

    /**
     * @description 方法描述
     * @param signName  如果signName为null或者空串，则取集团短信签名; 否则取signName值
     * @param templateId    1:验证短信模板, 2:通知短信模板, 3:推广短信模板
     * @param paramMap  短信模板中参数名为key,参数值为value
     * @param phoneNum  手机号数组,例：{"18888888888","19999999999"}
     * @author RenYY
     * @date 2016年12月29日
     */
    public SendSMS(String signName, int templateId, Map<String, String> paramMap, String[] phoneNum) {
        super();
        //短信签名: 如果signName为null或者空串，则取集团短信签名; 否则去signName值
        this.signName = (null == signName || "".equals(signName)) ? DictSMS.SIGN_NAME_PUXIN : signName;
        //短信模板
        switch (templateId) {
            case 1: this.templateCode = DictSMS.TEMPLATE_CODE_OF_VALIDATE; break;//验证短信模板
            case 2: this.templateCode = DictSMS.TEMPLATE_CODE_OF_INFORM; break;//通知短信模板
            case 3: this.templateCode = DictSMS.TEMPLATE_CODE_OF_PROMOTION; break;//推广短信模板
            default:this.templateCode = DictSMS.TEMPLATE_CODE_OF_PROMOTION; break;//以上三种均不匹配时，默认为  推广短信模板
        }
        //模板参数
        this.paramString = JSON.toJSONString(paramMap);
        //构造手机号字符串，多个手机号之间逗号分隔
        StringBuffer recNumSB = new StringBuffer();
        for(int i = 0; i < phoneNum.length; i++){
            if(i == phoneNum.length -1){
                recNumSB.append(phoneNum[i]);
            }else{
                recNumSB.append(phoneNum[i] + ",");
            }
        }
        this.recNum = recNumSB.toString();
    }
    /**
     * @description 发送短信
     * @return 发送成功返回 true,否则返回 false
     * @author RenYY
     * @date 2016年12月29日
     */
    @Override
    public boolean sendSMS() {
        boolean isSendSuccess = false;
        try {
            IClientProfile profile = DefaultProfile.getProfile(aliyun_sms_region_id, aliyun_sms_access_key_id, aliyun_sms_access_key_secret);
            DefaultProfile.addEndpoint(aliyun_sms_end_point_name, aliyun_sms_region_id, aliyun_sms_product,aliyun_sms_domain);
            IAcsClient client = new DefaultAcsClient(profile);
            SingleSendSmsRequest request = new SingleSendSmsRequest();
            request.setSignName(signName);
            request.setTemplateCode(templateCode);
            request.setParamString(paramString);
            request.setRecNum(recNum);
            SingleSendSmsResponse response = client.getAcsResponse(request);//短信发送
            isSendSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("*aliyun_sms_begin*");
            log.error(e.getMessage());
            log.error("*aliyun_sms_end*");
        }finally{
            return isSendSuccess;
        }
    }



}
