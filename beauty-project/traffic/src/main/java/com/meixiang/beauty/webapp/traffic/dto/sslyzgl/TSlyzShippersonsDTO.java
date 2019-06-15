package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TSlyzShippersonsDTO {

    /**
     *编号算法见ServerMaxNo说明
    **/
    @JSONField(name="personno")
    private String personno;

    /**
     *企业编号
    **/
    @JSONField(name="enterpriseno")
    private String enterpriseno;

    /**
     *人员姓名
    **/
    @JSONField(name="personname")
    private String personname;

    /**
     *性别
    **/
    @JSONField(name="sexkind")
    private String sexkind;

    /**
     *学历
    **/
    @JSONField(name="educationgrade")
    private String educationgrade;

    /**
     *职务类别
    **/
    @JSONField(name="jobkind")
    private String jobkind;

    /**
     *职务名称
    **/
    @JSONField(name="jobname")
    private String jobname;

    /**
     *身份证号
    **/
    @JSONField(name="sfzno")
    private String sfzno;

    /**
     *船员适任证号
    **/
    @JSONField(name="srzno")
    private String srzno;

    /**
     *船员适任证类型
    **/
    @JSONField(name="srzkind")
    private String srzkind;

    /**
     *适任证船员类型
    **/
    @JSONField(name="srzshipkind")
    private String srzshipkind;

    /**
     *船员适任证书等级
    **/
    @JSONField(name="srzgrade")
    private String srzgrade;

    /**
     *简要说明
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

    public String getEnterpriseno() {
        return enterpriseno;
    }

    public void setEnterpriseno(String enterpriseno) {
        this.enterpriseno = enterpriseno;
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

    public String getEducationgrade() {
        return educationgrade;
    }

    public void setEducationgrade(String educationgrade) {
        this.educationgrade = educationgrade;
    }

    public String getJobkind() {
        return jobkind;
    }

    public void setJobkind(String jobkind) {
        this.jobkind = jobkind;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getSfzno() {
        return sfzno;
    }

    public void setSfzno(String sfzno) {
        this.sfzno = sfzno;
    }

    public String getSrzno() {
        return srzno;
    }

    public void setSrzno(String srzno) {
        this.srzno = srzno;
    }

    public String getSrzkind() {
        return srzkind;
    }

    public void setSrzkind(String srzkind) {
        this.srzkind = srzkind;
    }

    public String getSrzshipkind() {
        return srzshipkind;
    }

    public void setSrzshipkind(String srzshipkind) {
        this.srzshipkind = srzshipkind;
    }

    public String getSrzgrade() {
        return srzgrade;
    }

    public void setSrzgrade(String srzgrade) {
        this.srzgrade = srzgrade;
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