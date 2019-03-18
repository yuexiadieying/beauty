package com.meixiang.beauty.sys.utils;

import com.meixiang.beauty.common.bean.WeixinArticle;
import com.meixiang.beauty.common.utils.StringUtils;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by wangbaowei on 15/12/7.
 */

public class BusinessMsgTemplate {
    
    /**
     * 提现成功 ---微信
     * @param openId 用户微信的唯一标示
     * @param token 微信的access_token
     * @param url 模板链接
     * */
    public static void withdrawalsSuccess2Weixin(String openId,String token,String url,String returnMoney,String returnDate){
        ArrayList<Object> obj = new ArrayList<Object>();
        WeixinArticle article = new WeixinArticle();
        article.setTitle("【提现成功通知 】");
        article.setDescription("您的提现资金已到账" + "\n提现金额：" + returnMoney +  "\n提现时间：" + returnDate +  "\n\n您的提现已经付款到您的微信钱包，请注意查收（到账时间以微信钱包查询结果为准）" );
        article.setUrl(url);
        obj.add(article);
        if(StringUtils.isNotNull(openId))
        {
            WeixinMessageUtil.sendMsgToWeixin(token,openId, obj);
        }
    }

}
