package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbscmpsnrecordDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    @JSONField(name="cmpsnrecordid")
    private String cmpsnrecordid;

    /**
     *从业人员id
    **/
    @JSONField(name="cmpsnid")
    private String cmpsnid;

    /**
     *备案机构
    **/
    @JSONField(name="managerdepcode")
    private String managerdepcode;

    /**
     *备案日期
    **/
    @JSONField(name="recorddate")
    private String recorddate;

    /**
     *办理人
    **/
    @JSONField(name="recordusername")
    private String recordusername;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private char iseffect;

    /**
     *编辑日期
    **/
    @JSONField(name="editime")
    private String editime;

    /**
     *编辑时间
    **/
    @JSONField(name="edidate")
    private String edidate;

    /**
     *编辑人员
    **/
    @JSONField(name="ediusrcode")
    private String ediusrcode;

    /**
     *创建时间
    **/
    @JSONField(name="cretime")
    private String cretime;

    /**
     *创建时期
    **/
    @JSONField(name="credate")
    private String credate;

    /**
     *创建人员
    **/
    @JSONField(name="creusrcode")
    private String creusrcode;

    /**
     *备注
    **/
    @JSONField(name="remarkdoc")
    private String remarkdoc;

    /**
     *备案状态 1
    **/
    @JSONField(name="recordstate")
    private char recordstate;

    /**
     *状态
    **/
    @JSONField(name="worstatus")
    private char worstatus;

    /**
     *1省内2省外
    **/
    @JSONField(name="recordtype")
    private char recordtype;

    /**
     *从业资格证号
    **/
    @JSONField(name="titno")
    private String titno;

    /**
     *从业资格类别
    **/
    @JSONField(name="beworscope")
    private String beworscope;

    /**
     *服务单位
    **/
    @JSONField(name="cmcltid")
    private String cmcltid;

    /**
     *入职时间
    **/
    @JSONField(name="beginworkdate")
    private String beginworkdate;

    /**
     *职务
    **/
    @JSONField(name="job")
    private String job;

    /**
     *证件有效期起
    **/
    @JSONField(name="startdate")
    private String startdate;

    /**
     *证件初领证时间
    **/
    @JSONField(name="gradate")
    private String gradate;

    /**
     *证件有效期止
    **/
    @JSONField(name="enddate")
    private String enddate;

    /**
     *交通事故记录次数
    **/
    @JSONField(name="accidentnum")
    private Integer accidentnum;

    /**
     *考生区域
    **/
    @JSONField(name="examineearea")
    private String examineearea;

    /**
     *资格等级
    **/
    @JSONField(name="beworlevel")
    private String beworlevel;

    /**
     *周期累计学时
    **/
    @JSONField(name="cycletime")
    private Integer cycletime;

    @JSONField(name="chedepcode")
    private String chedepcode;

    @JSONField(name="cheusrname")
    private String cheusrname;

    @JSONField(name="cheusrdate")
    private String cheusrdate;

    /**
     *创建方式 1-信息中心同步建档  2-手工建档
    **/
    @JSONField(name="creatortype")
    private String creatortype;

    @JSONField(name="enbeworrecordid")
    private String enbeworrecordid;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getCmpsnrecordid() {
        return cmpsnrecordid;
    }

    public void setCmpsnrecordid(String cmpsnrecordid) {
        this.cmpsnrecordid = cmpsnrecordid;
    }

    public String getCmpsnid() {
        return cmpsnid;
    }

    public void setCmpsnid(String cmpsnid) {
        this.cmpsnid = cmpsnid;
    }

    public String getManagerdepcode() {
        return managerdepcode;
    }

    public void setManagerdepcode(String managerdepcode) {
        this.managerdepcode = managerdepcode;
    }

    public String getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(String recorddate) {
        this.recorddate = recorddate;
    }

    public String getRecordusername() {
        return recordusername;
    }

    public void setRecordusername(String recordusername) {
        this.recordusername = recordusername;
    }

    public char getIseffect() {
        return iseffect;
    }

    public void setIseffect(char iseffect) {
        this.iseffect = iseffect;
    }

    public String getEditime() {
        return editime;
    }

    public void setEditime(String editime) {
        this.editime = editime;
    }

    public String getEdidate() {
        return edidate;
    }

    public void setEdidate(String edidate) {
        this.edidate = edidate;
    }

    public String getEdiusrcode() {
        return ediusrcode;
    }

    public void setEdiusrcode(String ediusrcode) {
        this.ediusrcode = ediusrcode;
    }

    public String getCretime() {
        return cretime;
    }

    public void setCretime(String cretime) {
        this.cretime = cretime;
    }

    public String getCredate() {
        return credate;
    }

    public void setCredate(String credate) {
        this.credate = credate;
    }

    public String getCreusrcode() {
        return creusrcode;
    }

    public void setCreusrcode(String creusrcode) {
        this.creusrcode = creusrcode;
    }

    public String getRemarkdoc() {
        return remarkdoc;
    }

    public void setRemarkdoc(String remarkdoc) {
        this.remarkdoc = remarkdoc;
    }

    public char getRecordstate() {
        return recordstate;
    }

    public void setRecordstate(char recordstate) {
        this.recordstate = recordstate;
    }

    public char getWorstatus() {
        return worstatus;
    }

    public void setWorstatus(char worstatus) {
        this.worstatus = worstatus;
    }

    public char getRecordtype() {
        return recordtype;
    }

    public void setRecordtype(char recordtype) {
        this.recordtype = recordtype;
    }

    public String getTitno() {
        return titno;
    }

    public void setTitno(String titno) {
        this.titno = titno;
    }

    public String getBeworscope() {
        return beworscope;
    }

    public void setBeworscope(String beworscope) {
        this.beworscope = beworscope;
    }

    public String getCmcltid() {
        return cmcltid;
    }

    public void setCmcltid(String cmcltid) {
        this.cmcltid = cmcltid;
    }

    public String getBeginworkdate() {
        return beginworkdate;
    }

    public void setBeginworkdate(String beginworkdate) {
        this.beginworkdate = beginworkdate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getGradate() {
        return gradate;
    }

    public void setGradate(String gradate) {
        this.gradate = gradate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Integer getAccidentnum() {
        return accidentnum;
    }

    public void setAccidentnum(Integer accidentnum) {
        this.accidentnum = accidentnum;
    }

    public String getExamineearea() {
        return examineearea;
    }

    public void setExamineearea(String examineearea) {
        this.examineearea = examineearea;
    }

    public String getBeworlevel() {
        return beworlevel;
    }

    public void setBeworlevel(String beworlevel) {
        this.beworlevel = beworlevel;
    }

    public Integer getCycletime() {
        return cycletime;
    }

    public void setCycletime(Integer cycletime) {
        this.cycletime = cycletime;
    }

    public String getChedepcode() {
        return chedepcode;
    }

    public void setChedepcode(String chedepcode) {
        this.chedepcode = chedepcode;
    }

    public String getCheusrname() {
        return cheusrname;
    }

    public void setCheusrname(String cheusrname) {
        this.cheusrname = cheusrname;
    }

    public String getCheusrdate() {
        return cheusrdate;
    }

    public void setCheusrdate(String cheusrdate) {
        this.cheusrdate = cheusrdate;
    }

    public String getCreatortype() {
        return creatortype;
    }

    public void setCreatortype(String creatortype) {
        this.creatortype = creatortype;
    }

    public String getEnbeworrecordid() {
        return enbeworrecordid;
    }

    public void setEnbeworrecordid(String enbeworrecordid) {
        this.enbeworrecordid = enbeworrecordid;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}