package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

//年度审验业户记录
public class NdsyyhjlDTO {

    //年审日期
    @JSONField(name = "nsrq")
    private String nsrq;

    //年审结论
    @JSONField(name = "nsjl")
    private String nsjl;

    //管辖机构编号
    @JSONField(name = "gxjgbh")
    private String gxjgbh;

    //（水运或服务）企业编号
    @JSONField(name = "qybh")
    private String qybh;

    //企业类别
    @JSONField(name = "qylb")
    private String qylb;

    //经营者名称
    @JSONField(name = "jyzmc")
    private String jyzmc;

    //法人代表
    @JSONField(name = "frdb")
    private String frdb;

    //经济类型
    @JSONField(name = "jjlx")
    private String jjlx;

    //注册地址
    @JSONField(name = "zcdz")
    private String zcdz;

    //联系电话
    @JSONField(name = "phone")
    private String phone;

    //许可证号
    @JSONField(name = "xkzh")
    private String xkzh;

    //许可证发证日期
    @JSONField(name = "zkzfzrq")
    private String zkzfzrq;

    //许可证有效截期
    @JSONField(name = "xkzyxjq")
    private String xkzyxjq;

    //经营范围分类
    @JSONField(name = "jyfwfl")
    private String jyfwfl;

    //运输或营业收入（万元）
    @JSONField(name = "yshyysr")
    private String yshyysr;

    //运输或营业成本（万元）
    @JSONField(name = "yshyycb")
    private String yshyycb;

    //备注
    @JSONField(name = "bz")
    private String bz;

    public String getNsrq() {
        return nsrq;
    }

    public void setNsrq(String nsrq) {
        this.nsrq = nsrq;
    }

    public String getNsjl() {
        return nsjl;
    }

    public void setNsjl(String nsjl) {
        this.nsjl = nsjl;
    }

    public String getGxjgbh() {
        return gxjgbh;
    }

    public void setGxjgbh(String gxjgbh) {
        this.gxjgbh = gxjgbh;
    }

    public String getQybh() {
        return qybh;
    }

    public void setQybh(String qybh) {
        this.qybh = qybh;
    }

    public String getQylb() {
        return qylb;
    }

    public void setQylb(String qylb) {
        this.qylb = qylb;
    }

    public String getJyzmc() {
        return jyzmc;
    }

    public void setJyzmc(String jyzmc) {
        this.jyzmc = jyzmc;
    }

    public String getFrdb() {
        return frdb;
    }

    public void setFrdb(String frdb) {
        this.frdb = frdb;
    }

    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    public String getZcdz() {
        return zcdz;
    }

    public void setZcdz(String zcdz) {
        this.zcdz = zcdz;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getXkzh() {
        return xkzh;
    }

    public void setXkzh(String xkzh) {
        this.xkzh = xkzh;
    }

    public String getZkzfzrq() {
        return zkzfzrq;
    }

    public void setZkzfzrq(String zkzfzrq) {
        this.zkzfzrq = zkzfzrq;
    }

    public String getXkzyxjq() {
        return xkzyxjq;
    }

    public void setXkzyxjq(String xkzyxjq) {
        this.xkzyxjq = xkzyxjq;
    }

    public String getJyfwfl() {
        return jyfwfl;
    }

    public void setJyfwfl(String jyfwfl) {
        this.jyfwfl = jyfwfl;
    }

    public String getYshyysr() {
        return yshyysr;
    }

    public void setYshyysr(String yshyysr) {
        this.yshyysr = yshyysr;
    }

    public String getYshyycb() {
        return yshyycb;
    }

    public void setYshyycb(String yshyycb) {
        this.yshyycb = yshyycb;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
