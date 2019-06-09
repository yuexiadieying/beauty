package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

//水路运输企业人员
public class SlysqyryDTO {

    //人员编号
    @JSONField(name = "rybh")
    private String xzqhdm;

    //企业编号
    @JSONField(name = "qybh")
    private String qybh;

    //人员姓名
    @JSONField(name = "ryxm")
    private String ryxm;

    //性别
    @JSONField(name = "xb")
    private String xb;

    //学历
    @JSONField(name = "xl")
    private String xl;

    //职务类型
    @JSONField(name = "zwlx")
    private String zwlx;

    //职务名称
    @JSONField(name = "zwmc")
    private String zwmc;

    //身份证号
    @JSONField(name = "sfzh")
    private String sfzh;

    //船员适任证号
    @JSONField(name = "cysrzh")
    private String cysrzh;

    //船员适任证类型
    @JSONField(name = "cysrzlx")
    private String cysrzlx;

    //船员适任证书等级
    @JSONField(name = "cysrzsdj")
    private String cysrzsdj;

    //简要说明
    @JSONField(name = "jysm")
    private String jysm;

    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getRyxm() {
        return ryxm;
    }

    public void setRyxm(String ryxm) {
        this.ryxm = ryxm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    public String getZwlx() {
        return zwlx;
    }

    public void setZwlx(String zwlx) {
        this.zwlx = zwlx;
    }

    public String getZwmc() {
        return zwmc;
    }

    public void setZwmc(String zwmc) {
        this.zwmc = zwmc;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getCysrzh() {
        return cysrzh;
    }

    public void setCysrzh(String cysrzh) {
        this.cysrzh = cysrzh;
    }

    public String getCysrzlx() {
        return cysrzlx;
    }

    public void setCysrzlx(String cysrzlx) {
        this.cysrzlx = cysrzlx;
    }

    public String getCysrzsdj() {
        return cysrzsdj;
    }

    public void setCysrzsdj(String cysrzsdj) {
        this.cysrzsdj = cysrzsdj;
    }

    public String getJysm() {
        return jysm;
    }

    public void setJysm(String jysm) {
        this.jysm = jysm;
    }
}
