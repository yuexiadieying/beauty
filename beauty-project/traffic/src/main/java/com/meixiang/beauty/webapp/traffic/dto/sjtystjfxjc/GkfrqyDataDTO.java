package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;

//港口法人企业数据
public class GkfrqyDataDTO {

    //名称
    @JSONField(name = "name")
    private String name;

    //完成率
    @JSONField(name = "wcl")
    private String wcl;

    //月环比
    @JSONField(name = "yhb")
    private String yhb;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWcl() {
        return wcl;
    }

    public void setWcl(String wcl) {
        this.wcl = wcl;
    }

    public String getYhb() {
        return yhb;
    }

    public void setYhb(String yhb) {
        this.yhb = yhb;
    }
}
