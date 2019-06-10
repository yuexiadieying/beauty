package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;

//道路客货站场增减情况
public class CskyjtglDataDTO {

    //名称
    @JSONField(name = "name")
    private String name;

    //管理信息
    @JSONField(name = "glxx")
    private String glxx;

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

    public String getGlxx() {
        return glxx;
    }

    public void setGlxx(String glxx) {
        this.glxx = glxx;
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
