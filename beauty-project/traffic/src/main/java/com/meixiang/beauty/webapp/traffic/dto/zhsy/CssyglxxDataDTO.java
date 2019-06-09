package com.meixiang.beauty.webapp.traffic.dto.zhsy;

import com.alibaba.fastjson.annotation.JSONField;

//城市客运
public class CssyglxxDataDTO {

    //水运船舶，单位：艘
    @JSONField(name = "sycb")
    private String sycb;

    //月份 2019-03
    @JSONField(name = "monthDate")
    private String monthDate;

    public String getSycb() {
        return sycb;
    }

    public void setSycb(String sycb) {
        this.sycb = sycb;
    }

    public String getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(String monthDate) {
        this.monthDate = monthDate;
    }
}
