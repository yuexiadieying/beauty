package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;

//道路客货站场增减情况
public class DlkhzczjqkDataDTO {

    //站场名称
    @JSONField(name = "zcname")
    private String zcname;

    //增速率
    @JSONField(name = "zsl")
    private String zsl;

    //月环比
    @JSONField(name = "yhb")
    private String yhb;

    public String getZcname() {
        return zcname;
    }

    public void setZcname(String zcname) {
        this.zcname = zcname;
    }

    public String getZsl() {
        return zsl;
    }

    public void setZsl(String zsl) {
        this.zsl = zsl;
    }

    public String getYhb() {
        return yhb;
    }

    public void setYhb(String yhb) {
        this.yhb = yhb;
    }
}
