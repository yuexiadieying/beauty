package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

//企业违章记录
public class QywzjlDTO {

    //水运或企业服务编号
    @JSONField(name = "qyfwbh")
    private String xzqhdm;

    //奖励表彰
    @JSONField(name = "jlbz")
    private String jlbz;

    //违章处罚
    @JSONField(name = "wzcf")
    private String wzcf;

    //价格欺诈
    @JSONField(name = "jgqz")
    private String jgqz;

    //客户投诉
    @JSONField(name = "khts")
    private String khts;

    //生产事故
    @JSONField(name = "scsg")
    private String scsg;

    //船舶违章
    @JSONField(name = "cbwz")
    private String cbwz;

    //企业名称
    @JSONField(name = "qymc")
    private String qymc;

    //企业地址
    @JSONField(name = "qydz")
    private String qydz;

    //法人代表
    @JSONField(name = "frdb")
    private String frdb;

    //许可证号
    @JSONField(name = "xkzh")
    private String xkzh;

    //记录登记日期
    @JSONField(name = "jldjrq")
    private String jldjrq;

    //记录登记账号
    @JSONField(name = "jldjzh")
    private String jldjzh;

    //记录登记机构
    @JSONField(name = "jldjjg")
    private String jldjjg;

    //记录说明
    @JSONField(name = "jlsm")
    private String jlsm;

    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm;
    }

    public String getJlbz() {
        return jlbz;
    }

    public void setJlbz(String jlbz) {
        this.jlbz = jlbz;
    }

    public String getWzcf() {
        return wzcf;
    }

    public void setWzcf(String wzcf) {
        this.wzcf = wzcf;
    }

    public String getJgqz() {
        return jgqz;
    }

    public void setJgqz(String jgqz) {
        this.jgqz = jgqz;
    }

    public String getKhts() {
        return khts;
    }

    public void setKhts(String khts) {
        this.khts = khts;
    }

    public String getScsg() {
        return scsg;
    }

    public void setScsg(String scsg) {
        this.scsg = scsg;
    }

    public String getCbwz() {
        return cbwz;
    }

    public void setCbwz(String cbwz) {
        this.cbwz = cbwz;
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getQydz() {
        return qydz;
    }

    public void setQydz(String qydz) {
        this.qydz = qydz;
    }

    public String getFrdb() {
        return frdb;
    }

    public void setFrdb(String frdb) {
        this.frdb = frdb;
    }

    public String getXkzh() {
        return xkzh;
    }

    public void setXkzh(String xkzh) {
        this.xkzh = xkzh;
    }

    public String getJldjrq() {
        return jldjrq;
    }

    public void setJldjrq(String jldjrq) {
        this.jldjrq = jldjrq;
    }

    public String getJldjzh() {
        return jldjzh;
    }

    public void setJldjzh(String jldjzh) {
        this.jldjzh = jldjzh;
    }

    public String getJldjjg() {
        return jldjjg;
    }

    public void setJldjjg(String jldjjg) {
        this.jldjjg = jldjjg;
    }

    public String getJlsm() {
        return jlsm;
    }

    public void setJlsm(String jlsm) {
        this.jlsm = jlsm;
    }
}
