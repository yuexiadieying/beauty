package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;

//交通固定资产投资额
public class JtgdzctzeDataDTO {

    //项目名称
    @JSONField(name = "name")
    private String name;

    //投资金额（万元）
    @JSONField(name = "tzje")
    private String tzje;

    //占比
    @JSONField(name = "zb")
    private String zb;

    //月环比
    @JSONField(name = "yhb")
    private String yhb;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTzje() {
        return tzje;
    }

    public void setTzje(String tzje) {
        this.tzje = tzje;
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
