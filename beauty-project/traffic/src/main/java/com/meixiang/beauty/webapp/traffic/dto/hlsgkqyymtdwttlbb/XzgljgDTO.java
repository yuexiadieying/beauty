package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

//行政管理机构
public class XzgljgDTO {

    //机构编码
    @JSONField(name = "jgbm")
    private String jgbm;

    //机构全称
    @JSONField(name = "jgqc")
    private String jgqc;

    //机构所在行政区划名称
    @JSONField(name = "jgszxzqhmc")
    private String jgszxzqhmc;

    //机构负责人姓名
    @JSONField(name = "jgfzrxm")
    private String jgfzrxm;

    //部门负责人
    @JSONField(name = "bmfzr")
    private String bmfzr;

    //填报人姓名
    @JSONField(name = "tbrxm")
    private String tbrxm;

    //联系电话
    @JSONField(name = "phone")
    private String phone;

    public String getJgbm() {
        return jgbm;
    }

    public void setJgbm(String jgbm) {
        this.jgbm = jgbm;
    }

    public String getJgqc() {
        return jgqc;
    }

    public void setJgqc(String jgqc) {
        this.jgqc = jgqc;
    }

    public String getJgszxzqhmc() {
        return jgszxzqhmc;
    }

    public void setJgszxzqhmc(String jgszxzqhmc) {
        this.jgszxzqhmc = jgszxzqhmc;
    }

    public String getJgfzrxm() {
        return jgfzrxm;
    }

    public void setJgfzrxm(String jgfzrxm) {
        this.jgfzrxm = jgfzrxm;
    }

    public String getBmfzr() {
        return bmfzr;
    }

    public void setBmfzr(String bmfzr) {
        this.bmfzr = bmfzr;
    }

    public String getTbrxm() {
        return tbrxm;
    }

    public void setTbrxm(String tbrxm) {
        this.tbrxm = tbrxm;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
