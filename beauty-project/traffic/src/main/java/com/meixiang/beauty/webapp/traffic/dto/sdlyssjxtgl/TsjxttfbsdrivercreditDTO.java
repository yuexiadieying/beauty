package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbsdrivercreditDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    @JSONField(name="cdguid")
    private String cdguid;

    /**
     *考核周期开始时间
    **/
    @JSONField(name="startdate")
    private String startdate;

    /**
     *考核周期结束时间
    **/
    @JSONField(name="enddate")
    private String enddate;

    /**
     *得分
    **/
    @JSONField(name="score")
    private Integer score;

    @JSONField(name="cmpsnid")
    private String cmpsnid;

    /**
     *状态
    **/
    @JSONField(name="status")
    private char status;

    /**
     *再教育开始时间
    **/
    @JSONField(name="restudydate")
    private String restudydate;

    /**
     *再教育结束时间
    **/
    @JSONField(name="restudyenddate")
    private String restudyenddate;

    /**
     *录入人员
    **/
    @JSONField(name="creusrcode")
    private String creusrcode;

    /**
     *录入日期
    **/
    @JSONField(name="credate")
    private String credate;

    /**
     *录入时间
    **/
    @JSONField(name="cretime")
    private String cretime;

    /**
     *修改人员
    **/
    @JSONField(name="ediusrcode")
    private String ediusrcode;

    /**
     *修改日期
    **/
    @JSONField(name="edidate")
    private String edidate;

    /**
     *修改时间
    **/
    @JSONField(name="editime")
    private String editime;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private Integer iseffect;

    @JSONField(name="enbeworrecordid")
    private String enbeworrecordid;

    @JSONField(name="lev")
    private String lev;

    /**
     *计分开始时间
    **/
    @JSONField(name="calcdate")
    private String calcdate;

    /**
     *继续教育次数
    **/
    @JSONField(name="restudycount")
    private Integer restudycount;

    /**
     *经营行为
    **/
    @JSONField(name="act")
    private char act;

    /**
     *开单日期
    **/
    @JSONField(name="lawdate")
    private String lawdate;

    /**
     *执法人员1
    **/
    @JSONField(name="lawepsn")
    private String lawepsn;

    /**
     *执法证号1
    **/
    @JSONField(name="lecardno")
    private String lecardno;

    /**
     *执法人员2
    **/
    @JSONField(name="lawepsn2")
    private String lawepsn2;

    /**
     *执法证还2
    **/
    @JSONField(name="lecardno2")
    private String lecardno2;

    /**
     *执法机构
    **/
    @JSONField(name="laworg")
    private String laworg;

    /**
     *备注
    **/
    @JSONField(name="remark")
    private String remark;

    /**
     *评定人
    **/
    @JSONField(name="auditperson")
    private String auditperson;

    /**
     *评定时间
    **/
    @JSONField(name="auditdate")
    private String auditdate;

    /**
     *评定意见
    **/
    @JSONField(name="auditremark")
    private String auditremark;

    /**
     *继续教育通知书编号
    **/
    @JSONField(name="studycode")
    private String studycode;

    /**
     *继续教育类型
    **/
    @JSONField(name="studytype")
    private char studytype;

    /**
     *考核单位
    **/
    @JSONField(name="auditdep")
    private String auditdep;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getCdguid() {
        return cdguid;
    }

    public void setCdguid(String cdguid) {
        this.cdguid = cdguid;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCmpsnid() {
        return cmpsnid;
    }

    public void setCmpsnid(String cmpsnid) {
        this.cmpsnid = cmpsnid;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getRestudydate() {
        return restudydate;
    }

    public void setRestudydate(String restudydate) {
        this.restudydate = restudydate;
    }

    public String getRestudyenddate() {
        return restudyenddate;
    }

    public void setRestudyenddate(String restudyenddate) {
        this.restudyenddate = restudyenddate;
    }

    public String getCreusrcode() {
        return creusrcode;
    }

    public void setCreusrcode(String creusrcode) {
        this.creusrcode = creusrcode;
    }

    public String getCredate() {
        return credate;
    }

    public void setCredate(String credate) {
        this.credate = credate;
    }

    public String getCretime() {
        return cretime;
    }

    public void setCretime(String cretime) {
        this.cretime = cretime;
    }

    public String getEdiusrcode() {
        return ediusrcode;
    }

    public void setEdiusrcode(String ediusrcode) {
        this.ediusrcode = ediusrcode;
    }

    public String getEdidate() {
        return edidate;
    }

    public void setEdidate(String edidate) {
        this.edidate = edidate;
    }

    public String getEditime() {
        return editime;
    }

    public void setEditime(String editime) {
        this.editime = editime;
    }

    public Integer getIseffect() {
        return iseffect;
    }

    public void setIseffect(Integer iseffect) {
        this.iseffect = iseffect;
    }

    public String getEnbeworrecordid() {
        return enbeworrecordid;
    }

    public void setEnbeworrecordid(String enbeworrecordid) {
        this.enbeworrecordid = enbeworrecordid;
    }

    public String getLev() {
        return lev;
    }

    public void setLev(String lev) {
        this.lev = lev;
    }

    public String getCalcdate() {
        return calcdate;
    }

    public void setCalcdate(String calcdate) {
        this.calcdate = calcdate;
    }

    public Integer getRestudycount() {
        return restudycount;
    }

    public void setRestudycount(Integer restudycount) {
        this.restudycount = restudycount;
    }

    public char getAct() {
        return act;
    }

    public void setAct(char act) {
        this.act = act;
    }

    public String getLawdate() {
        return lawdate;
    }

    public void setLawdate(String lawdate) {
        this.lawdate = lawdate;
    }

    public String getLawepsn() {
        return lawepsn;
    }

    public void setLawepsn(String lawepsn) {
        this.lawepsn = lawepsn;
    }

    public String getLecardno() {
        return lecardno;
    }

    public void setLecardno(String lecardno) {
        this.lecardno = lecardno;
    }

    public String getLawepsn2() {
        return lawepsn2;
    }

    public void setLawepsn2(String lawepsn2) {
        this.lawepsn2 = lawepsn2;
    }

    public String getLecardno2() {
        return lecardno2;
    }

    public void setLecardno2(String lecardno2) {
        this.lecardno2 = lecardno2;
    }

    public String getLaworg() {
        return laworg;
    }

    public void setLaworg(String laworg) {
        this.laworg = laworg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAuditperson() {
        return auditperson;
    }

    public void setAuditperson(String auditperson) {
        this.auditperson = auditperson;
    }

    public String getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(String auditdate) {
        this.auditdate = auditdate;
    }

    public String getAuditremark() {
        return auditremark;
    }

    public void setAuditremark(String auditremark) {
        this.auditremark = auditremark;
    }

    public String getStudycode() {
        return studycode;
    }

    public void setStudycode(String studycode) {
        this.studycode = studycode;
    }

    public char getStudytype() {
        return studytype;
    }

    public void setStudytype(char studytype) {
        this.studytype = studytype;
    }

    public String getAuditdep() {
        return auditdep;
    }

    public void setAuditdep(String auditdep) {
        this.auditdep = auditdep;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}