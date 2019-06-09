package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

//运营船舶信息
public class CblxdmDTO {

    //行政区划代码
    @JSONField(name = "xzqhdm")
    private String xzqhdm;

    //行政区划名称
    @JSONField(name = "xzqhmc")
    private String xzqhmc;

    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm;
    }

    public String getXzqhmc() {
        return xzqhmc;
    }

    public void setXzqhmc(String xzqhmc) {
        this.xzqhmc = xzqhmc;
    }
}
