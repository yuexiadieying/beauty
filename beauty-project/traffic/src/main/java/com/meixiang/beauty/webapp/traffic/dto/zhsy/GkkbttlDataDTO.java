package com.meixiang.beauty.webapp.traffic.dto.zhsy;

import com.alibaba.fastjson.annotation.JSONField;

//全市泊位
public class GkkbttlDataDTO {

    //进港吞吐量
    @JSONField(name = "jgttl")
    private String jgttl;

    //出港吞吐量
    @JSONField(name = "cgttl")
    private String cgttl;

    //日期，2019-04-06
    @JSONField(name = "date")
    private String date;

    //港口企业名称
    @JSONField(name = "gkqymc")
    private String gkqymc;

    //码头单位名称
    @JSONField(name = "mtdwmc")
    private String mtdwmc;

    public String getJgttl() {
        return jgttl;
    }

    public void setJgttl(String jgttl) {
        this.jgttl = jgttl;
    }

    public String getCgttl() {
        return cgttl;
    }

    public void setCgttl(String cgttl) {
        this.cgttl = cgttl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGkqymc() {
        return gkqymc;
    }

    public void setGkqymc(String gkqymc) {
        this.gkqymc = gkqymc;
    }

    public String getMtdwmc() {
        return mtdwmc;
    }

    public void setMtdwmc(String mtdwmc) {
        this.mtdwmc = mtdwmc;
    }
}
