package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

//运输辅助企业人员
public class YsfzqyryDTO {

    //企业编号
    @JSONField(name = "qybh")
    private String qybh;

    //人员姓名
    @JSONField(name = "ryxm")
    private String ryxm;

    //职务类型
    @JSONField(name = "zwlx")
    private String zwlx;

    //职务名称
    @JSONField(name = "zwmc")
    private String zwmc;

    //性别
    @JSONField(name = "xb")
    private String xb;

    //学历
    @JSONField(name = "xl")
    private String xl;

    //身份证号
    @JSONField(name = "sfzh")
    private String sfzh;

    //资格或从业培训证书名及编号号
    @JSONField(name = "zghcypxzsmjbhh")
    private String zghcypxzsmjbhh;

    //简要说明
    @JSONField(name = "jysm")
    private String jysm;

    //图片与资料文件夹
    @JSONField(name = "tpyzlwjj")
    private String tpyzlwjj;

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

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getZghcypxzsmjbhh() {
        return zghcypxzsmjbhh;
    }

    public void setZghcypxzsmjbhh(String zghcypxzsmjbhh) {
        this.zghcypxzsmjbhh = zghcypxzsmjbhh;
    }

    public String getJysm() {
        return jysm;
    }

    public void setJysm(String jysm) {
        this.jysm = jysm;
    }

    public String getTpyzlwjj() {
        return tpyzlwjj;
    }

    public void setTpyzlwjj(String tpyzlwjj) {
        this.tpyzlwjj = tpyzlwjj;
    }
}
