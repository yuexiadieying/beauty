package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbsvecgoodsvindDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *车辆ID
    **/
    @JSONField(name="cmvecid")
    private String cmvecid;

    /**
     *本次二级维护日期（评定日期、客车档次评定日期）
    **/
    @JSONField(name="vinddate")
    private String vinddate;

    /**
     *下次二级维护日期
    **/
    @JSONField(name="vindnextdate")
    private String vindnextdate;

    /**
     *维修企业id
    **/
    @JSONField(name="cmcltid")
    private String cmcltid;

    /**
     *维修合同号
    **/
    @JSONField(name="vindconno")
    private String vindconno;

    /**
     *竣工出厂合格证号
    **/
    @JSONField(name="vindgrdno")
    private String vindgrdno;

    /**
     *竣工检测报告单号
    **/
    @JSONField(name="vindrepno")
    private String vindrepno;

    /**
     *检测机构名称
    **/
    @JSONField(name="inscmcltid")
    private String inscmcltid;

    /**
     *间隔里程
    **/
    @JSONField(name="intervalmileage")
    private String intervalmileage;

    /**
     *间隔时间
    **/
    @JSONField(name="intervaldate")
    private String intervaldate;

    /**
     *维修人员
    **/
    @JSONField(name="repairstaff")
    private String repairstaff;

    /**
     *检测类型
    **/
    @JSONField(name="testtype")
    private String testtype;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getCmvecid() {
        return cmvecid;
    }

    public void setCmvecid(String cmvecid) {
        this.cmvecid = cmvecid;
    }

    public String getVinddate() {
        return vinddate;
    }

    public void setVinddate(String vinddate) {
        this.vinddate = vinddate;
    }

    public String getVindnextdate() {
        return vindnextdate;
    }

    public void setVindnextdate(String vindnextdate) {
        this.vindnextdate = vindnextdate;
    }

    public String getCmcltid() {
        return cmcltid;
    }

    public void setCmcltid(String cmcltid) {
        this.cmcltid = cmcltid;
    }

    public String getVindconno() {
        return vindconno;
    }

    public void setVindconno(String vindconno) {
        this.vindconno = vindconno;
    }

    public String getVindgrdno() {
        return vindgrdno;
    }

    public void setVindgrdno(String vindgrdno) {
        this.vindgrdno = vindgrdno;
    }

    public String getVindrepno() {
        return vindrepno;
    }

    public void setVindrepno(String vindrepno) {
        this.vindrepno = vindrepno;
    }

    public String getInscmcltid() {
        return inscmcltid;
    }

    public void setInscmcltid(String inscmcltid) {
        this.inscmcltid = inscmcltid;
    }

    public String getIntervalmileage() {
        return intervalmileage;
    }

    public void setIntervalmileage(String intervalmileage) {
        this.intervalmileage = intervalmileage;
    }

    public String getIntervaldate() {
        return intervaldate;
    }

    public void setIntervaldate(String intervaldate) {
        this.intervaldate = intervaldate;
    }

    public String getRepairstaff() {
        return repairstaff;
    }

    public void setRepairstaff(String repairstaff) {
        this.repairstaff = repairstaff;
    }

    public String getTesttype() {
        return testtype;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}