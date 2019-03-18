package com.meixiang.beauty.common.constant;


public class ConfigConstant {

	//redis中存储的登陆后的token的有效期，目前是30天
	public static final int logintokenPeriod = 60*60*24*30;

	public static final String practitionerDomain = "101.201.209.61";

	public static final String elderVersion = "1.0.1";

	public static final String practitionerVersion = "1.0.1";

	public static final String hospitalVersion = "1.0.1";

	public static final String businessC1 = "business-C-1";

	public static final String businessC2 = "business-C-2";

	public static final String businessB1 = "business-B-1";

	public static final String businessB2 = "business-B-2";

	public static final String businessA1 = "business-A-1";

	public static final String businessA2 = "business-A-2";

	public static final String weixinFlag = "businessOnlineOperation";

	public static final String weixinRobotFlag = "robotOnlineOperation";

	public static final String CORPID = "wx1e929f283aa42de5";//测试号

	public static final String SECTET = "6b173d8df684febcf8994fee8313d944";//测试号

	public static final String ROBOTCORPID = "wxd4d77a6ff4c7cfea";//测试号

	public static final String ROBOTSECTET = "89c164d49272bbae87051ed173d4dcc0";//测试号

//	public static final String CORPID = "wxa62609dff1842cd8";//商用号
//
//	public static final String SECTET = "e2bf27273f48715d12f16fcafca0bb75";//商用号

	public static final String DOMAIN_VALUE = "kpbeauty.com.cn";

	public static final String BUSINESS_WEB_URL = "http://mx99test1.kpbeauty.com.cn/business/ionic#/";

	public static final String OFFLINE_PRODUCT_BUY_NOTIFY_URL = "http://mx99test1.kpbeauty.com.cn/business/account/getOfflineProductPayNotifyInfo";

	public static final String TRAINING_PRODUCT_BUY_NOTIFY_URL = "http://mx99test1.kpbeauty.com.cn/business/account/getTrainingProductPayNotifyInfo";

	public static final String APP_ID = "";

	public static final String MCH_ID = "";

	public static final String DEVICE_INFO = "WEB";

	public static final String BODY = "business";

	public static final String OUT_TRADE_NO  = "";

	public static final String FEE_TYPE = "CNY";

	public static final String GATE_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	public static final String SIGN_METHOD = "MD5";

    public static final String TRANSFERS = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

	public static final String SHARE_CODE_VALUE = "mxbusinessshare_";

	public static final int AUTO_CONFIRM_RECEIVE_PRODUCT_DAY = 15;

	public static final int AUTO_NOTIFY_PRODUCT_PAY = 3;

	public static final int AUTO_DELETE_BUSINESS_ORDER = 3;

	public static final float PROMOTE_B_LEVEL_MIN_EXPENSE = 498;

	public static final float PROMOTE_B_LEVEL_MAX_EXPENSE = 9899;

	public static final float PROMOTE_A_LEVEL_MIN_EXPENSE = 9900;

	public static final float MONTH_A_INCOME_MAX_EXPENSE = -1;//10000;

	public static final float MONTH_A_INCOME_PERCENTAGE = 35;

	public static final float MONTH_B_INCOME_MAX_EXPENSE = -1;//1000;

	public static final float MONTH_B_INCOME_PERCENTAGE = 10;

	public static final float USER_TYPE_PERIOD = 365;//用户等级可保留的时间，365天

	public static final String PARTNER_KEY = "FDSKLJjklsjJKLJKLjkl98908789kljl";

	public static final String OPEN_ID = "meixiang99MX";


}
