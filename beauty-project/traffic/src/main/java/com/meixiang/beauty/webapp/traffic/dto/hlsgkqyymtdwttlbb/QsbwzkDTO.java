package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

//全市泊位表中的统计数据
public class QsbwzkDTO {

    //唯一标识号
    @JSONField(name = "wybsh")
    private String wybsh;

    //表年份
    @JSONField(name = "bnf")
    private String bnf;

    //归属港区编号
    @JSONField(name = "gsgqbh")
    private String gsgqbh;

    //码头企业号
    @JSONField(name = "mtqyh")
    private String mtqyh;

    //泊位代码
    @JSONField(name = "bwdm")
    private String bwdm;

    //泊位名称
    @JSONField(name = "bwmc")
    private String bwmc;

    //生产类型
    @JSONField(name = "sclx")
    private String sclx;

    //服务类型
    @JSONField(name = "fwlx")
    private String fwlx;

    //货主类型
    @JSONField(name = "hzlx")
    private String hzlx;

    //泊位长度
    @JSONField(name = "bwcd")
    private String bwcd;

    //设计靠泊能力（吨级）
    @JSONField(name = "sjkbnl")
    private String sjkbnl;

    //增加的报告期
    @JSONField(name = "zjdbgq")
    private String zjdbgq;

    //报废的报告期
    @JSONField(name = "bfdbgq")
    private String bfdbgq;

    //泊位状态
    @JSONField(name = "bwzt")
    private String bwzt;

    public String getWybsh() {
        return wybsh;
    }

    public void setWybsh(String wybsh) {
        this.wybsh = wybsh;
    }

    public String getBnf() {
        return bnf;
    }

    public void setBnf(String bnf) {
        this.bnf = bnf;
    }

    public String getGsgqbh() {
        return gsgqbh;
    }

    public void setGsgqbh(String gsgqbh) {
        this.gsgqbh = gsgqbh;
    }

    public String getMtqyh() {
        return mtqyh;
    }

    public void setMtqyh(String mtqyh) {
        this.mtqyh = mtqyh;
    }

    public String getBwdm() {
        return bwdm;
    }

    public void setBwdm(String bwdm) {
        this.bwdm = bwdm;
    }

    public String getBwmc() {
        return bwmc;
    }

    public void setBwmc(String bwmc) {
        this.bwmc = bwmc;
    }

    public String getSclx() {
        return sclx;
    }

    public void setSclx(String sclx) {
        this.sclx = sclx;
    }

    public String getFwlx() {
        return fwlx;
    }

    public void setFwlx(String fwlx) {
        this.fwlx = fwlx;
    }

    public String getHzlx() {
        return hzlx;
    }

    public void setHzlx(String hzlx) {
        this.hzlx = hzlx;
    }

    public String getBwcd() {
        return bwcd;
    }

    public void setBwcd(String bwcd) {
        this.bwcd = bwcd;
    }

    public String getSjkbnl() {
        return sjkbnl;
    }

    public void setSjkbnl(String sjkbnl) {
        this.sjkbnl = sjkbnl;
    }

    public String getZjdbgq() {
        return zjdbgq;
    }

    public void setZjdbgq(String zjdbgq) {
        this.zjdbgq = zjdbgq;
    }

    public String getBfdbgq() {
        return bfdbgq;
    }

    public void setBfdbgq(String bfdbgq) {
        this.bfdbgq = bfdbgq;
    }

    public String getBwzt() {
        return bwzt;
    }

    public void setBwzt(String bwzt) {
        this.bwzt = bwzt;
    }
}
