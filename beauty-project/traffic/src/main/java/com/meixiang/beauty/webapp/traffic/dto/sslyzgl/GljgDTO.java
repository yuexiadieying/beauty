package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

//管理机构
public class GljgDTO {

    //机构编码
    @JSONField(name = "jgbm")
    private String jgbm;

    //所在行政区划
    @JSONField(name = "szxzqh")
    private String szxzqh;

    //机构全称
    @JSONField(name = "jgqc")
    private String jgqc;

    //机构简称
    @JSONField(name = "jgjc")
    private String jgjc;

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

    public String getSzxzqh() {
        return szxzqh;
    }

    public void setSzxzqh(String szxzqh) {
        this.szxzqh = szxzqh;
    }

    public String getJgqc() {
        return jgqc;
    }

    public void setJgqc(String jgqc) {
        this.jgqc = jgqc;
    }

    public String getJgjc() {
        return jgjc;
    }

    public void setJgjc(String jgjc) {
        this.jgjc = jgjc;
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
