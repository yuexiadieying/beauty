package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;

//道路客货站场增减情况
public class GlysfrqyqkDataDTO {

    //名称
    @JSONField(name = "name")
    private String name;

    //增长率
    @JSONField(name = "zzl")
    private String zzl;

    //月环比
    @JSONField(name = "yhb")
    private String yhb;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZzl() {
        return zzl;
    }

    public void setZzl(String zzl) {
        this.zzl = zzl;
    }

    public String getYhb() {
        return yhb;
    }

    public void setYhb(String yhb) {
        this.yhb = yhb;
    }
}
