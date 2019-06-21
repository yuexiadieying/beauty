package com.meixiang.beauty.webapp.traffic.constant;

/**
 * Created by sunxiao on 2017/8/15.
 */
public enum UserLevelEnum {

    SJTYSTJFXJC("sjtystjfxjc"),//省交通运输统计分析检测
    SDLYSSJXTGL("sdlyssjxtgl"),//省道路运输三级协同管理
    GLJT("gljt"),//公路交通
    SSLYZGL("sslyzgl"),//省水路运政管理
    ZHGJ("zhgj"),//智慧公交
    HNSGLSLJSYYSSCXXFWXT("hnsglsljsyysscxxfwxt"),//湖南省公路水路建设与运输市场信息服务系统
    HNSGKQYYMTDWTTLBB("hnsgkqyymtdwttlbb"),//湖南省港口企业与码头单位吞吐量报表
    SYAISXT("syaisxt"),//水运AIS系统
    SKYLWSPXT("skylwspxt");//省客运联网售票系统

    private final String value;

    UserLevelEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
