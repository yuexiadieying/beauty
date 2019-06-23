package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TSlyzEnterpriseillegalrunrdDTO {

    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *编号算法见ServerMaxNo说明
    **/
    @JSONField(name="illegalrecordno")
    private String illegalrecordno;

    /**
     *水运或服务企业编号
    **/
    @JSONField(name="enterpriseno")
    private String enterpriseno;

    /**
     *奖励表彰、违章处罚、价格欺诈、客户投诉、生产事故、船舶违章
    **/
    @JSONField(name="kind")
    private String kind;

    /**
     *企业名称
    **/
    @JSONField(name="enterprisename")
    private String enterprisename;

    /**
     *企业地址
    **/
    @JSONField(name="address")
    private String address;

    /**
     *法人代表
    **/
    @JSONField(name="lawman")
    private String lawman;

    /**
     *许可证号
    **/
    @JSONField(name="xkzno")
    private String xkzno;

    /**
     *记录登记日期
    **/
    @JSONField(name="recorddate")
    private Date recorddate;

    /**
     *记录登记账号
    **/
    @JSONField(name="recordusernoandname")
    private String recordusernoandname;

    /**
     *记录登记机构
    **/
    @JSONField(name="recordunitno")
    private String recordunitno;

    /**
     *记录说明
    **/
    @JSONField(name="illegalrunnote")
    private String illegalrunnote;

    @JSONField(name="createdate")
    private Date createdate;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getIllegalrecordno() {
        return illegalrecordno;
    }

    public void setIllegalrecordno(String illegalrecordno) {
        this.illegalrecordno = illegalrecordno;
    }

    public String getEnterpriseno() {
        return enterpriseno;
    }

    public void setEnterpriseno(String enterpriseno) {
        this.enterpriseno = enterpriseno;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLawman() {
        return lawman;
    }

    public void setLawman(String lawman) {
        this.lawman = lawman;
    }

    public String getXkzno() {
        return xkzno;
    }

    public void setXkzno(String xkzno) {
        this.xkzno = xkzno;
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }

    public String getRecordusernoandname() {
        return recordusernoandname;
    }

    public void setRecordusernoandname(String recordusernoandname) {
        this.recordusernoandname = recordusernoandname;
    }

    public String getRecordunitno() {
        return recordunitno;
    }

    public void setRecordunitno(String recordunitno) {
        this.recordunitno = recordunitno;
    }

    public String getIllegalrunnote() {
        return illegalrunnote;
    }

    public void setIllegalrunnote(String illegalrunnote) {
        this.illegalrunnote = illegalrunnote;
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