package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;

//高速公路服务器及出口明细
public class GsglfwqjckmxDataDTO {

    //服务区
    @JSONField(name = "fwq")
    private String fwq;

    //出口明细
    @JSONField(name = "ckmx")
    private String ckmx;

    //占比
    @JSONField(name = "zb")
    private String zb;

    //月环比
    @JSONField(name = "yhb")
    private String yhb;

    public String getFwq() {
        return fwq;
    }

    public void setFwq(String fwq) {
        this.fwq = fwq;
    }

    public String getCkmx() {
        return ckmx;
    }

    public void setCkmx(String ckmx) {
        this.ckmx = ckmx;
    }

    public String getZb() {
        return zb;
    }

    public void setZb(String zb) {
        this.zb = zb;
    }

    public String getYhb() {
        return yhb;
    }

    public void setYhb(String yhb) {
        this.yhb = yhb;
    }
}
