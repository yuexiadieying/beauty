package com.meixiang.beauty.modules.system.util;

import com.meixiang.beauty.common.bean.TemplateData;
import com.meixiang.beauty.common.bean.WxTemplate;
import com.meixiang.beauty.common.config.Global;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.utils.HttpRequestUtil;
import com.meixiang.beauty.modules.system.util.UserUtils;
import net.sf.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信消息目前主要包含是模板消息以及微信多客服消息
 * Created by wangbaowei on 15/11/30
 */
public class WeixinTemplateMessageUtil {

    //订单未支付通知模板ID
    public static final String ORDER_NOT_PAY = Global.getConfig("ORDER_NOT_PAY");

    //订单支付成功模板ID
    protected static final String ORDER_PAY_SUCCESS = Global.getConfig("ORDER_PAY_SUCCESS");

    //商品已发出通知模板ID
    protected static final String PRODUCT_ALREADY_SEND = Global.getConfig("PRODUCT_ALREADY_SEND");

    //订单自动确认收货通知模板ID
    protected static final String ORDER_CONFIRM_RECEIVE = Global.getConfig("ORDER_CONFIRM_RECEIVE");

    //到账通知--月度返现模板
    protected static final String MONTH_INCOME = Global.getConfig("MONTH_INCOME");

    //返现到账通知--即时返现模板ID
    protected static final String INSTANCE_INCOME = Global.getConfig("INSTANCE_INCOME");

    //会员到期模板ID
    protected static final String BUSINESS_MEMBER_DEADLINE = Global.getConfig("BUSINESS_MEMBER_DEADLINE");

    //下级代理商加入提醒模板ID
    protected static final String LOW_LEVEL_BUSINESS_JOIN = Global.getConfig("LOW_LEVEL_BUSINESS_JOIN");

    //会员消费通知模板ID
    protected static final String LOW_LEVEL_BUSINESS_EXPENSE = Global.getConfig("LOW_LEVEL_BUSINESS_EXPENSE");

    //退款申请模板ID
    protected static final String REFUND_APPLY = Global.getConfig("REFUND_APPLY");

    //退款成功模板ID
    protected static final String REFUND_SUCCESS = Global.getConfig("REFUND_SUCCESS");

	//退款失败模板ID
	protected static final String REFUND_FAILURE = Global.getConfig("REFUND_FAILURE");

    //会员升级通知--同级推荐20个模板ID
    protected static final String BUSINESS_PROMOTE_FOR_RECOMMEND = Global.getConfig("BUSINESS_PROMOTE_FOR_RECOMMEND");
	//提现失败通知
    protected static final String WITHDRAW_FAILURE_NOTIFY = Global.getConfig("WITHDRAW_FAILURE_NOTIFY");

    /**
	 * 订单未支付通知模板 ORDER_NOT_PAY
	 * @Param ordertape 下单时间
	 * @Param ordeId 订单号
	 * @Param 微信消息发送所需的token
	 * @Param url 跳转的URL
	 * @Param 用户的微信ID
	**/
	public static void sendOrderNotPayTemplateWXMessage(String ordertape, String ordeID, String token, String url, String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(ORDER_NOT_PAY);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("客官，您好！您的订单未支付，即将关闭。");
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(ordertape);
		m.put("ordertape", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(ordeID);
		m.put("ordeID", templateData);


		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("还未付款，未付款的订单24时内关闭，请及时付款。感谢您对美享99商城的青睐！点击查看详情。");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}

	/**
	 * 订单支付成功通知模板 ORDER_PAY_SUCCESS
	 * @Param orderMoneySum 支付金额
	 * @Param orderProductName 商品名称
	 * @Param 微信消息发送所需的token
	 * @Param url 跳转的URL
	 * @Param 用户的微信ID
	 **/
	public static void sendOrderPaySuccessTemplateWXMessage(String orderMoneySum,String orderProductName,String token,String url, String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(ORDER_PAY_SUCCESS);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("我们已收到您的货款，开始为您打包商品，请耐心等待");
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(orderMoneySum);
		m.put("orderMoneySum", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(orderProductName);
		m.put("orderProductName", templateData);


		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("如有问题请致电400-000-0000，小美将第一时间为您服务！");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}

	/**
	 * 商品已发出通知模板 PRODUCT_ALREADY_SEND
	 * @Param delivername 快递公司名称
	 * @Param ordername 快递单号
	 * @Param 微信消息发送所需的token
	 * @Param url 跳转的URL
	 * @Param 用户的微信ID
	 * todo 此模板接口还有参数不齐全，待下阶段完善
	 **/
	public static void sendProductAlreadySendTemplateWXMessage(String delivername,String ordername,String token,String url, String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(PRODUCT_ALREADY_SEND);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("亲，宝贝已经启程了，好想快点来到你的身边");
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(delivername);
		m.put("delivername", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(ordername);
		m.put("ordername", templateData);


		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("备注：如有疑问，请致电400-000-0000，小美将在第一时间为您服务！");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}

	/**
	 * 订单自动确认收货通知模板 ORDER_CONFIRM_RECEIVE
	 * @Param keyword1 订单编号
	 * @Param keyword2 订单商品
	 * @Param keyword3 发货时间
	 * @Param keyword4 自动确认收货时间
	 * @Param 微信消息发送所需的token
	 * @Param url 跳转的URL
	 * @Param 用户的微信ID
	 **/
	public static void sendOrderConfirmReceiveTemplateWXMessage(String keyword1,String keyword2,String keyword3,String keyword4,String token,String url, String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(ORDER_CONFIRM_RECEIVE);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("尊敬的客户，您的订单将在1小时后自动签收！");
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword1);
		m.put("keyword1", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword2);
		m.put("keyword2", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword3);
		m.put("keyword3", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword4);
		m.put("ordeID", templateData);


		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("如无异议，请等待系统自动确认收货，或您主动确认收货，谢谢！");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}

	/**
	 * 到账通知--月度返现模板 MONTH_INCOME
	 * @Param keyword1 账户名称
	 * @Param keyword2 数量金额
	 * @Param keyword3 时间
	 * @Param 微信消息发送所需的token
	 * @Param url 跳转的URL
	 * @Param 用户的微信ID
	 **/
	public static void sendMonthIncomeTemplateWXMessage(String keyword1,String keyword2,String keyword3,String token,String url, String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(MONTH_INCOME);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("您好，您的月度结算佣金已到账，请注意查收！");
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword1);
		m.put("ordertape", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword2);
		m.put("ordeID", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword3);
		m.put("ordeID", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("再接再厉，继续努力");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}

	/**
	 * 返现到账通知--即时返现模板 INSTANCE_INCOME
	 * @Param order 订单号
	 * @Param money 数量金额
	 * @Param 微信消息发送所需的token
	 * @Param url 跳转的URL
	 * @Param 用户的微信ID
	 **/
	public static void sendInstanceIncomeTemplateWXMessage(String order,String money,String token,String url, String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(INSTANCE_INCOME);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
		try {
			templateData.setValue("尊敬的"+ URLDecoder.decode(userInfoDTO.getNickname(),"utf-8")+"您好，佣金返现已充入您的现金账户！");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(order);
		m.put("order", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(money);
		m.put("money", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("点击详情查看现金账户明细。");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}

	/**
	 * 会员到期模板 BUSINESS_MEMBER_DEADLINE
	 * @Param name A店或者B店名称
	 * @Param expDate 到期日期
	 * @Param 微信消息发送所需的token
	 * @Param url 跳转的URL
	 * @Param 用户的微信ID
	 **/
	public static void sendBusinessMemberDeadlineTemplateWXMessage(String name,String expDate,String token,String url, String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(BUSINESS_MEMBER_DEADLINE);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("您好，您的会员即将到期，请您注意。");
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(name);
		m.put("name", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(expDate);
		m.put("expDate", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("请您注意时间，防止过期失效。");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}

	/**
	 * 下级代理商加入提醒模板 LOW_LEVEL_BUSINESS_JOIN
	 * @Param keyword1 姓名
	 * @Param keyword2 级别，A店还是B店
	 * @Param keyword3 收入金额
	 * @Param 微信消息发送所需的token
	 * @Param url 跳转的URL
	 * @Param 用户的微信ID
	 **/
	public static void sendLowLevelBusinessTemplateWXMessage(String keyword1,String keyword2,String keyword3,String token, String url, String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(LOW_LEVEL_BUSINESS_JOIN);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("恭喜您，有下级代理商加入");
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword1);
		m.put("keyword1", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword2);
		m.put("keyword2", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword3);
		m.put("keyword3", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("若有疑问，请致电400-000-0000，小美将在第一时间为您解决。");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}

	/**
	 * 会员消费通知模板 LOW_LEVEL_BUSINESS_EXPENSE
	 * @Param keyword1 用户名称
	 * @Param keyword2 消费金额
	 * @Param keyword3 消费时间
	 * @Param 微信消息发送所需的token
	 * @Param url 跳转的URL
	 * @Param 用户的微信ID
	 **/
	public static void sendLowLevelBusinessExpenseTemplateWXMessage(String keyword1,String keyword2,String keyword3,String token, String url, String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(LOW_LEVEL_BUSINESS_EXPENSE);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("您好，您的下级代理已成功消费。");
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword1);
		m.put("keyword1", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword2);
		m.put("keyword2", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword3);
		m.put("keyword3", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("下级确认收货后，为您结算佣金。");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}

	/**
	 * 退款申请模板 REFUND_APPLY
	 * @Param orderProductPrice 退款金额
	 * @Param orderProductName 商品详情
	 * @Param orderName 订单编号
	 * @Param 微信消息发送所需的token
	 * @Param url 跳转的URL
	 * @Param 用户的微信ID
	 **/
	public static void sendRefundApplyTemplateWXMessage(String orderProductPrice,String orderProductName,String orderName,String token, String url, String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(REFUND_APPLY);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("您已申请退款，等待商家确认退款信息");
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(orderProductPrice);
		m.put("orderProductPrice", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(orderProductName);
		m.put("orderProductName", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(orderName);
		m.put("orderName", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("如有问题请致电400-000-0000，小美将在第一时间为您服务。");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}

	/**
	 * 退款成功通知 REFUND_SUCCESS
	 * @Param orderId 订单号
	 * @Param keyword1 退款商品名称
	 * @Param keyword2 退款金额
	 * @Param keyword3 退款时间
	 * @Param 微信消息发送所需的token
	 * @Param url 跳转的URL
	 * @Param 用户的微信ID
	 **/
	public static void sendRefundSuccessTemplateWXMessage(String orderId,String frist,String keyword1,String keyword2,String keyword3,String token, String url, String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(REFUND_SUCCESS);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("您的订单【" + orderId +"】已完成退款，"+frist+"元已经退回您的付款账户，请注意查收。");
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword1);
		m.put("keyword1", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword2);
		m.put("keyword2", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword3);
		m.put("keyword3", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("如有问题请致电400-000-0000，小美将在第一时间为您服务。");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}

	/**
	 * 会员升级通知--同级推荐20个模板 BUSINESS_PROMOTE_FOR_RECOMMEND
	 * @Param keyword1 会员编号
	 * @Param keyword2 有效时间
	 * @Param 微信消息发送所需的token
	 * @Param url 跳转的URL
	 * @Param 用户的微信ID
	 **/
	public static void sendBusinessPromoteForRecommendTemplateWXMessage(String keyword1,String keyword2,String token, String url, String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(BUSINESS_PROMOTE_FOR_RECOMMEND);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
		try {
			templateData.setValue("尊敬的"+ URLDecoder.decode(userInfoDTO.getNickname(),"utf-8")+"您已成功推荐20个会员，系统将您自动升级为钻石店主。");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword1);
		m.put("keyword1", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword2);
		m.put("keyword2", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("如有问题请致电400-000-0000，小美将在第一时间为您服务。");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}

	/**
	 * 退款失败通知 REFUND_FAILURE
	 * @Param keyword1 订单编号
	 * @Param keyword2 退款时间
	 * @Param keyword3 退款金额
	 * @Param keyword4 失败原因
	 * @Param 微信消息发送所需的token
	 * @Param url 跳转的URL
	 * @Param 用户的微信ID
	 **/
	public static void sendRefundFailureTemplateWXMessage(String keyword1,String keyword2,String keyword3,String keyword4,String token, String url, String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(REFUND_FAILURE);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("您的退款审核被拒绝");
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword1);
		m.put("keyword1", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword2);
		m.put("keyword2", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword3);
		m.put("keyword3", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(keyword4);
		m.put("keyword4", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("具体信息请查看详情");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}

	/**
	 * 提现失败通知 WITHDRAW_FAILURE_NOTIFY
	 * @param money
	 * @param time
	 * @param token
	 * @param url
	 * @param openid
	 */
	public static void sendWithDrawTemplateFailureMessage(String money,String time,String token,String url,String openid){
		WxTemplate t = new WxTemplate();
		t.setUrl(url);
		t.setTouser(openid);
		t.setTopcolor("#000000");
		t.setTemplate_id(WITHDRAW_FAILURE_NOTIFY);
		Map<String,TemplateData> m = new HashMap<>();

		TemplateData templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("小美提示您，您的提现申请被拒绝，已将资金退回至“美享99”余额中，请核对您的个人信息，再次提现，给您带来的不便，敬请谅解。");
		m.put("first", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(money);
		m.put("money", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue(time);
		m.put("time", templateData);

		templateData = new TemplateData();
		templateData.setColor("#000000");
		templateData.setValue("如有疑问请联系客服18611010799。");
		m.put("remark", templateData);

		t.setData(m);
		String jsonobj = HttpRequestUtil.httpsRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+
				token+"","POST", JSONObject.fromObject(t).toString());
		JSONObject jsonObject = JSONObject.fromObject(jsonobj.replaceAll("200>>>>",""));
		if(jsonobj!=null){
			if("0".equals(jsonObject.getString("errcode"))){
				System.out.println("发送模板消息成功！");
			}else{
				System.out.println(jsonObject.getString("errcode"));
			}
		}
	}
}
