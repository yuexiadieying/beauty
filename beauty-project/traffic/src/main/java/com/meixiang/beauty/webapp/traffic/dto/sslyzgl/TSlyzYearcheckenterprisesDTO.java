package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TSlyzYearcheckenterprisesDTO {

    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *编号算法见ServerMaxNo说明
    **/
    @JSONField(name="yearcheckno")
    private String yearcheckno;

    /**
     *年审日期
    **/
    @JSONField(name="yearcheckdate")
    private Date yearcheckdate;

    /**
     *年审结论
    **/
    @JSONField(name="yearcheckresult")
    private String yearcheckresult;

    /**
     *管辖机构编号
    **/
    @JSONField(name="unitno")
    private String unitno;

    /**
     *（水运或服务）企业编号
    **/
    @JSONField(name="enterpriseno")
    private String enterpriseno;

    /**
     *企业类别
    **/
    @JSONField(name="enterprisekind")
    private String enterprisekind;

    /**
     *经营者名称
    **/
    @JSONField(name="enterprisename")
    private String enterprisename;

    /**
     *法人代表
    **/
    @JSONField(name="lawman")
    private String lawman;

    /**
     *经济类型
    **/
    @JSONField(name="jjkind")
    private String jjkind;

    /**
     *注册地址
    **/
    @JSONField(name="address")
    private String address;

    /**
     *联系电话
    **/
    @JSONField(name="telephone")
    private String telephone;

    /**
     *许可证号
    **/
    @JSONField(name="xkzno")
    private String xkzno;

    /**
     *许可证发证日期
    **/
    @JSONField(name="xkzprintdate")
    private Date xkzprintdate;

    /**
     *许可证有效截期
    **/
    @JSONField(name="xkzenddate")
    private Date xkzenddate;

    /**
     *经营范围分类
    **/
    @JSONField(name="runkinds")
    private String runkinds;

    /**
     *运输或营业收入（万元）
    **/
    @JSONField(name="runincome")
    private Double runincome;

    /**
     *运输或营业成本（万元）
    **/
    @JSONField(name="runcost")
    private Double runcost;

    /**
     *备注
    **/
    @JSONField(name="yearchecknote")
    private String yearchecknote;

    @JSONField(name="createdate")
    private Date createdate;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getYearcheckno() {
        return yearcheckno;
    }

    public void setYearcheckno(String yearcheckno) {
        this.yearcheckno = yearcheckno;
    }

    public Date getYearcheckdate() {
        return yearcheckdate;
    }

    public void setYearcheckdate(Date yearcheckdate) {
        this.yearcheckdate = yearcheckdate;
    }

    public String getYearcheckresult() {
        return yearcheckresult;
    }

    public void setYearcheckresult(String yearcheckresult) {
        this.yearcheckresult = yearcheckresult;
    }

    public String getUnitno() {
        return unitno;
    }

    public void setUnitno(String unitno) {
        this.unitno = unitno;
    }

    public String getEnterpriseno() {
        return enterpriseno;
    }

    public void setEnterpriseno(String enterpriseno) {
        this.enterpriseno = enterpriseno;
    }

    public String getEnterprisekind() {
        return enterprisekind;
    }

    public void setEnterprisekind(String enterprisekind) {
        this.enterprisekind = enterprisekind;
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    public String getLawman() {
        return lawman;
    }

    public void setLawman(String lawman) {
        this.lawman = lawman;
    }

    public String getJjkind() {
        return jjkind;
    }

    public void setJjkind(String jjkind) {
        this.jjkind = jjkind;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getXkzno() {
        return xkzno;
    }

    public void setXkzno(String xkzno) {
        this.xkzno = xkzno;
    }

    public Date getXkzprintdate() {
        return xkzprintdate;
    }

    public void setXkzprintdate(Date xkzprintdate) {
        this.xkzprintdate = xkzprintdate;
    }

    public Date getXkzenddate() {
        return xkzenddate;
    }

    public void setXkzenddate(Date xkzenddate) {
        this.xkzenddate = xkzenddate;
    }

    public String getRunkinds() {
        return runkinds;
    }

    public void setRunkinds(String runkinds) {
        this.runkinds = runkinds;
    }

    public Double getRunincome() {
        return runincome;
    }

    public void setRunincome(Double runincome) {
        this.runincome = runincome;
    }

    public Double getRuncost() {
        return runcost;
    }

    public void setRuncost(Double runcost) {
        this.runcost = runcost;
    }

    public String getYearchecknote() {
        return yearchecknote;
    }

    public void setYearchecknote(String yearchecknote) {
        this.yearchecknote = yearchecknote;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}