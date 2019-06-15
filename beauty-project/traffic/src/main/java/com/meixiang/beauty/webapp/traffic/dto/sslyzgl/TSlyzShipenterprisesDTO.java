package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TSlyzShipenterprisesDTO {

    /**
     *编号算法见ServerMaxNo说明
    **/
    @JSONField(name="enterpriseno")
    private String enterpriseno;

    /**
     *经营者管理机构编码
    **/
    @JSONField(name="unitno")
    private String unitno;

    /**
     *经营者名称
    **/
    @JSONField(name="enterprisename")
    private String enterprisename;

    /**
     *经营者的经济类型
    **/
    @JSONField(name="jjkind")
    private String jjkind;

    /**
     *组织机构代码，非个体经营者都有该代码
    **/
    @JSONField(name="unitenrollcode")
    private String unitenrollcode;

    /**
     *注册资金，默认0
    **/
    @JSONField(name="enrollmoney")
    private Double enrollmoney;

    /**
     *法人代表
    **/
    @JSONField(name="lawman")
    private String lawman;

    /**
     *详细地址
    **/
    @JSONField(name="address")
    private String address;

    /**
     *邮政编码
    **/
    @JSONField(name="postcode")
    private String postcode;

    /**
     *联系电话
    **/
    @JSONField(name="telephone")
    private String telephone;

    /**
     *传真号码
    **/
    @JSONField(name="faxno")
    private String faxno;

    /**
     *首次发证日期
    **/
    @JSONField(name="opendate")
    private Date opendate;

    /**
     *批准机关
    **/
    @JSONField(name="approveunitno")
    private String approveunitno;

    /**
     *批准文号
    **/
    @JSONField(name="approvedocno")
    private String approvedocno;

    /**
     *许可证号
    **/
    @JSONField(name="xkzno")
    private String xkzno;

    /**
     *最近发证日期
    **/
    @JSONField(name="xkzprintdate")
    private Date xkzprintdate;

    /**
     *经营期限
    **/
    @JSONField(name="xkzperiod")
    private String xkzperiod;

    /**
     *有效期的开始日期
    **/
    @JSONField(name="xkzstartdate")
    private Date xkzstartdate;

    /**
     *有效期的截止日期
    **/
    @JSONField(name="xkzenddate")
    private Date xkzenddate;

    /**
     *经营范围：客运
    **/
    @JSONField(name="kyrunkind")
    private String kyrunkind;

    /**
     *经营范围：货运
    **/
    @JSONField(name="hyrunkind")
    private String hyrunkind;

    /**
     *经营范围：兼营
    **/
    @JSONField(name="jyrunkind")
    private String jyrunkind;

    /**
     *经营范围分类，可以组合
    **/
    @JSONField(name="runkinds")
    private String runkinds;

    /**
     *最近年审日期（冗余）
    **/
    @JSONField(name="lastyearcheckdate")
    private Date lastyearcheckdate;

    /**
     *最近年审结果（冗余）
    **/
    @JSONField(name="lastyearcheckresult")
    private String lastyearcheckresult;

    /**
     *盈利状态（冗余），默认0
    **/
    @JSONField(name="ylzt")
    private Integer ylzt;

    /**
     *注销日期（冗余）
    **/
    @JSONField(name="exitdate")
    private Date exitdate;

    /**
     *许可申请号
    **/
    @JSONField(name="applyno")
    private String applyno;

    /**
     *许可申请状态
    **/
    @JSONField(name="applystatus")
    private String applystatus;

    /**
     *简要说明
    **/
    @JSONField(name="note")
    private String note;

    /**
     *台帐档案号
    **/
    @JSONField(name="docno")
    private String docno;

    @JSONField(name="createdate")
    private Date createdate;

    @JSONField(name="lastmodifydate")
    private Date lastmodifydate;

    @JSONField(name="gkkind")
    private String gkkind;

    @JSONField(name="gkenterpriseno")
    private String gkenterpriseno;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getEnterpriseno() {
        return enterpriseno;
    }

    public void setEnterpriseno(String enterpriseno) {
        this.enterpriseno = enterpriseno;
    }

    public String getUnitno() {
        return unitno;
    }

    public void setUnitno(String unitno) {
        this.unitno = unitno;
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    public String getJjkind() {
        return jjkind;
    }

    public void setJjkind(String jjkind) {
        this.jjkind = jjkind;
    }

    public String getUnitenrollcode() {
        return unitenrollcode;
    }

    public void setUnitenrollcode(String unitenrollcode) {
        this.unitenrollcode = unitenrollcode;
    }

    public Double getEnrollmoney() {
        return enrollmoney;
    }

    public void setEnrollmoney(Double enrollmoney) {
        this.enrollmoney = enrollmoney;
    }

    public String getLawman() {
        return lawman;
    }

    public void setLawman(String lawman) {
        this.lawman = lawman;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFaxno() {
        return faxno;
    }

    public void setFaxno(String faxno) {
        this.faxno = faxno;
    }

    public Date getOpendate() {
        return opendate;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }

    public String getApproveunitno() {
        return approveunitno;
    }

    public void setApproveunitno(String approveunitno) {
        this.approveunitno = approveunitno;
    }

    public String getApprovedocno() {
        return approvedocno;
    }

    public void setApprovedocno(String approvedocno) {
        this.approvedocno = approvedocno;
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

    public String getXkzperiod() {
        return xkzperiod;
    }

    public void setXkzperiod(String xkzperiod) {
        this.xkzperiod = xkzperiod;
    }

    public Date getXkzstartdate() {
        return xkzstartdate;
    }

    public void setXkzstartdate(Date xkzstartdate) {
        this.xkzstartdate = xkzstartdate;
    }

    public Date getXkzenddate() {
        return xkzenddate;
    }

    public void setXkzenddate(Date xkzenddate) {
        this.xkzenddate = xkzenddate;
    }

    public String getKyrunkind() {
        return kyrunkind;
    }

    public void setKyrunkind(String kyrunkind) {
        this.kyrunkind = kyrunkind;
    }

    public String getHyrunkind() {
        return hyrunkind;
    }

    public void setHyrunkind(String hyrunkind) {
        this.hyrunkind = hyrunkind;
    }

    public String getJyrunkind() {
        return jyrunkind;
    }

    public void setJyrunkind(String jyrunkind) {
        this.jyrunkind = jyrunkind;
    }

    public String getRunkinds() {
        return runkinds;
    }

    public void setRunkinds(String runkinds) {
        this.runkinds = runkinds;
    }

    public Date getLastyearcheckdate() {
        return lastyearcheckdate;
    }

    public void setLastyearcheckdate(Date lastyearcheckdate) {
        this.lastyearcheckdate = lastyearcheckdate;
    }

    public String getLastyearcheckresult() {
        return lastyearcheckresult;
    }

    public void setLastyearcheckresult(String lastyearcheckresult) {
        this.lastyearcheckresult = lastyearcheckresult;
    }

    public Integer getYlzt() {
        return ylzt;
    }

    public void setYlzt(Integer ylzt) {
        this.ylzt = ylzt;
    }

    public Date getExitdate() {
        return exitdate;
    }

    public void setExitdate(Date exitdate) {
        this.exitdate = exitdate;
    }

    public String getApplyno() {
        return applyno;
    }

    public void setApplyno(String applyno) {
        this.applyno = applyno;
    }

    public String getApplystatus() {
        return applystatus;
    }

    public void setApplystatus(String applystatus) {
        this.applystatus = applystatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDocno() {
        return docno;
    }

    public void setDocno(String docno) {
        this.docno = docno;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getLastmodifydate() {
        return lastmodifydate;
    }

    public void setLastmodifydate(Date lastmodifydate) {
        this.lastmodifydate = lastmodifydate;
    }

    public String getGkkind() {
        return gkkind;
    }

    public void setGkkind(String gkkind) {
        this.gkkind = gkkind;
    }

    public String getGkenterpriseno() {
        return gkenterpriseno;
    }

    public void setGkenterpriseno(String gkenterpriseno) {
        this.gkenterpriseno = gkenterpriseno;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}