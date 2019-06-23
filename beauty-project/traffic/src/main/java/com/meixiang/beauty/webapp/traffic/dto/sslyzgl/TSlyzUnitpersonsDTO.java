package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TSlyzUnitpersonsDTO {

    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *编号算法见ServerMaxNo说明
    **/
    @JSONField(name="personno")
    private String personno;

    /**
     *所在机构编码
    **/
    @JSONField(name="unitno")
    private String unitno;

    /**
     *人名
    **/
    @JSONField(name="personname")
    private String personname;

    /**
     *性别
    **/
    @JSONField(name="sexkind")
    private String sexkind;

    /**
     *所在部门及职务
    **/
    @JSONField(name="branchandjob")
    private String branchandjob;

    /**
     *出生年份
    **/
    @JSONField(name="birthyear")
    private Integer birthyear;

    /**
     *联系电话
    **/
    @JSONField(name="telephone")
    private String telephone;

    /**
     *执法证名称及编号
    **/
    @JSONField(name="zfznameandno")
    private String zfznameandno;

    /**
     *操作说明
    **/
    @JSONField(name="personnote")
    private String personnote;

    @JSONField(name="createdate")
    private Date createdate;

    @JSONField(name="lastmodifydate")
    private Date lastmodifydate;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getPersonno() {
        return personno;
    }

    public void setPersonno(String personno) {
        this.personno = personno;
    }

    public String getUnitno() {
        return unitno;
    }

    public void setUnitno(String unitno) {
        this.unitno = unitno;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getSexkind() {
        return sexkind;
    }

    public void setSexkind(String sexkind) {
        this.sexkind = sexkind;
    }

    public String getBranchandjob() {
        return branchandjob;
    }

    public void setBranchandjob(String branchandjob) {
        this.branchandjob = branchandjob;
    }

    public Integer getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(Integer birthyear) {
        this.birthyear = birthyear;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getZfznameandno() {
        return zfznameandno;
    }

    public void setZfznameandno(String zfznameandno) {
        this.zfznameandno = zfznameandno;
    }

    public String getPersonnote() {
        return personnote;
    }

    public void setPersonnote(String personnote) {
        this.personnote = personnote;
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

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}