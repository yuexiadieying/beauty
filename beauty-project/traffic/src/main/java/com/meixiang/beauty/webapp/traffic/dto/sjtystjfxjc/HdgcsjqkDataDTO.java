package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;

//航道（航标）工程设计情况
public class HdgcsjqkDataDTO {

    //名称
    @JSONField(name = "name")
    private String name;

    //设计情况
    @JSONField(name = "sjqk")
    private String sjqk;

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

    public String getSjqk() {
        return sjqk;
    }

    public void setSjqk(String sjqk) {
        this.sjqk = sjqk;
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
