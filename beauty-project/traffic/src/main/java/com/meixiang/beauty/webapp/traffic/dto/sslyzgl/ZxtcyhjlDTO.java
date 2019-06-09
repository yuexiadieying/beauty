package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

//注销退出业户记录
public class ZxtcyhjlDTO {

    //共享ChangeNo
    @JSONField(name = "changeNo")
    private String changeNo;

    //企业（含个体与服务业）编号
    @JSONField(name = "qybh")
    private String qybh;

    //经营者类别
    @JSONField(name = "jyzlb")
    private String jyzlb;

    //经营者名称
    @JSONField(name = "jyzmc")
    private String jyzmc;

    //经营者地址
    @JSONField(name = "jyzdz")
    private String jyzdz;

    //许可证编号
    @JSONField(name = "xkzbh")
    private String xkzbh;

    //最近发证日期
    @JSONField(name = "zjfzrq")
    private String zjfzrq;

    //经营范围分类
    @JSONField(name = "jyfwfl")
    private String jyfwfl;

    //管理机构
    @JSONField(name = "gljg")
    private String gljg;

    //注销原因
    @JSONField(name = "zxyy")
    private String zxyy;

    //退出日期
    @JSONField(name = "tcrq")
    private String tcrq;

    //简要说明
    @JSONField(name = "jysm")
    private String jysm;

    //台账档案号
    @JSONField(name = "tzdah")
    private String tzdah;

    public String getChangeNo() {
        return changeNo;
    }

    public void setChangeNo(String changeNo) {
        this.changeNo = changeNo;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getJyzlb() {
        return jyzlb;
    }

    public void setJyzlb(String jyzlb) {
        this.jyzlb = jyzlb;
    }

    public String getJyzmc() {
        return jyzmc;
    }

    public void setJyzmc(String jyzmc) {
        this.jyzmc = jyzmc;
    }

    public String getJyzdz() {
        return jyzdz;
    }

    public void setJyzdz(String jyzdz) {
        this.jyzdz = jyzdz;
    }

    public String getXkzbh() {
        return xkzbh;
    }

    public void setXkzbh(String xkzbh) {
        this.xkzbh = xkzbh;
    }

    public String getZjfzrq() {
        return zjfzrq;
    }

    public void setZjfzrq(String zjfzrq) {
        this.zjfzrq = zjfzrq;
    }

    public String getJyfwfl() {
        return jyfwfl;
    }

    public void setJyfwfl(String jyfwfl) {
        this.jyfwfl = jyfwfl;
    }

    public String getGljg() {
        return gljg;
    }

    public void setGljg(String gljg) {
        this.gljg = gljg;
    }

    public String getZxyy() {
        return zxyy;
    }

    public void setZxyy(String zxyy) {
        this.zxyy = zxyy;
    }

    public String getTcrq() {
        return tcrq;
    }

    public void setTcrq(String tcrq) {
        this.tcrq = tcrq;
    }

    public String getJysm() {
        return jysm;
    }

    public void setJysm(String jysm) {
        this.jysm = jysm;
    }

    public String getTzdah() {
        return tzdah;
    }

    public void setTzdah(String tzdah) {
        this.tzdah = tzdah;
    }
}
