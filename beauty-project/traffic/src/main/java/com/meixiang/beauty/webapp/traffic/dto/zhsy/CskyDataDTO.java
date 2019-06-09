package com.meixiang.beauty.webapp.traffic.dto.zhsy;

import com.alibaba.fastjson.annotation.JSONField;

//城市客运
public class CskyDataDTO {

    //公共汽电车,万人次
    @JSONField(name = "ggqdc")
    private String ggqdc;

    //出租汽车,万人次
    @JSONField(name = "czqc")
    private String czqc;

    //轨道交通,万人次
    @JSONField(name = "gdjt")
    private String gdjt;

    //月份 2019-03
    @JSONField(name = "monthDate")
    private String monthDate;

    public String getGgqdc() {
        return ggqdc;
    }

    public void setGgqdc(String ggqdc) {
        this.ggqdc = ggqdc;
    }

    public String getCzqc() {
        return czqc;
    }

    public void setCzqc(String czqc) {
        this.czqc = czqc;
    }

    public String getGdjt() {
        return gdjt;
    }

    public void setGdjt(String gdjt) {
        this.gdjt = gdjt;
    }

    public String getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(String monthDate) {
        this.monthDate = monthDate;
    }
}
