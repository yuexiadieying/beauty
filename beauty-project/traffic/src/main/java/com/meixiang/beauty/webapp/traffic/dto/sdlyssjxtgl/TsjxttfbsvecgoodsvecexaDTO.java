package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbsvecgoodsvecexaDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *车辆信息ID
    **/
    @JSONField(name="cmvecid")
    private String cmvecid;

    /**
     *年审结果
    **/
    @JSONField(name="examineres")
    private String examineres;

    /**
     *本次年审日期
    **/
    @JSONField(name="examinedate")
    private String examinedate;

    /**
     *备注
    **/
    @JSONField(name="gooutcause")
    private String gooutcause;

    /**
     *创建人员
    **/
    @JSONField(name="creusrcode")
    private String creusrcode;

    /**
     *创建日期
    **/
    @JSONField(name="credate")
    private String credate;

    /**
     *创建时间
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
     *受理机构
    **/
    @JSONField(name="depcode")
    private String depcode;

    /**
     *时间戳
    **/
    @JSONField(name="sysopertime")
    private Double sysopertime;

    /**
     *下次年审日期
    **/
    @JSONField(name="nextexaminedate")
    private String nextexaminedate;

    /**
     *车辆年度审验有效期至
    **/
    @JSONField(name="oldexaminedate")
    private String oldexaminedate;

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

    public String getExamineres() {
        return examineres;
    }

    public void setExamineres(String examineres) {
        this.examineres = examineres;
    }

    public String getExaminedate() {
        return examinedate;
    }

    public void setExaminedate(String examinedate) {
        this.examinedate = examinedate;
    }

    public String getGooutcause() {
        return gooutcause;
    }

    public void setGooutcause(String gooutcause) {
        this.gooutcause = gooutcause;
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

    public String getDepcode() {
        return depcode;
    }

    public void setDepcode(String depcode) {
        this.depcode = depcode;
    }

    public Double getSysopertime() {
        return sysopertime;
    }

    public void setSysopertime(Double sysopertime) {
        this.sysopertime = sysopertime;
    }

    public String getNextexaminedate() {
        return nextexaminedate;
    }

    public void setNextexaminedate(String nextexaminedate) {
        this.nextexaminedate = nextexaminedate;
    }

    public String getOldexaminedate() {
        return oldexaminedate;
    }

    public void setOldexaminedate(String oldexaminedate) {
        this.oldexaminedate = oldexaminedate;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}