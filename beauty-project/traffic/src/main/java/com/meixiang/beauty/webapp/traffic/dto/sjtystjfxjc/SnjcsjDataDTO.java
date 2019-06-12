package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;

//道路客货站场增减情况
public class SnjcsjDataDTO {

    //名称
    @JSONField(name = "name")
    private String name;

    //数据
    @JSONField(name = "data")
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
