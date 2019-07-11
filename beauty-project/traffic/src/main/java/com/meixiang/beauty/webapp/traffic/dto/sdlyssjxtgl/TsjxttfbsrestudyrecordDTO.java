package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbsrestudyrecordDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *教育ID
    **/
    @JSONField(name="restudyid")
    private String restudyid;

    /**
     *从业资格类别序号
    **/
    @JSONField(name="cerid")
    private String cerid;

    /**
     *证件号码
    **/
    @JSONField(name="cardno")
    private String cardno;

    /**
     *从业资格类别
    **/
    @JSONField(name="wortype")
    private String wortype;

    /**
     *继续教育机构
    **/
    @JSONField(name="org")
    private String org;

    /**
     *教育批次
    **/
    @JSONField(name="batchno")
    private String batchno;

    /**
     *开始时间
    **/
    @JSONField(name="startdate")
    private String startdate;

    /**
     *结束时间
    **/
    @JSONField(name="enddate")
    private String enddate;

    /**
     *继续教育原因
    **/
    @JSONField(name="reason")
    private String reason;

    /**
     *备注
    **/
    @JSONField(name="remark")
    private String remark;

    @JSONField(name="credate")
    private String credate;

    @JSONField(name="editime")
    private String editime;

    @JSONField(name="edidate")
    private String edidate;

    @JSONField(name="ediusrcode")
    private String ediusrcode;

    @JSONField(name="iseffect")
    private char iseffect;

    @JSONField(name="cretime")
    private String cretime;

    @JSONField(name="creusrcode")
    private String creusrcode;

    /**
     *姓名
    **/
    @JSONField(name="name")
    private String name;

    /**
     *性别
    **/
    @JSONField(name="sex")
    private String sex;

    /**
     *培训驾校
    **/
    @JSONField(name="schname")
    private String schname;

    /**
     *报名日期
    **/
    @JSONField(name="sapplydate")
    private String sapplydate;

    /**
     *结业日期
    **/
    @JSONField(name="graduatedate")
    private String graduatedate;

    /**
     *学时
    **/
    @JSONField(name="studytime")
    private String studytime;

    /**
     *考试成绩
    **/
    @JSONField(name="examgrade")
    private String examgrade;

    /**
     *培训结果
    **/
    @JSONField(name="examresult")
    private String examresult;

    /**
     *继续教育周期
    **/
    @JSONField(name="cycle")
    private String cycle;

    /**
     *是否使用 0 未使用,1 已使用
    **/
    @JSONField(name="isuse")
    private char isuse;

    /**
     *图片1
    **/
    @JSONField(name="restudyimg1")
    private String restudyimg1;

    /**
     *图片2
    **/
    @JSONField(name="restudyimg2")
    private String restudyimg2;

    /**
     *继续教育类型
    **/
    @JSONField(name="restudyreason")
    private String restudyreason;

    /**
     *办理机构
    **/
    @JSONField(name="chedepname")
    private String chedepname;

    /**
     *考试日期
    **/
    @JSONField(name="examdate")
    private String examdate;

    /**
     *办理日期
    **/
    @JSONField(name="cheusrdate")
    private String cheusrdate;

    /**
     *办理人
    **/
    @JSONField(name="cheusrname")
    private String cheusrname;

    /**
     *签注人
    **/
    @JSONField(name="qianzhuusrname")
    private String qianzhuusrname;

    /**
     *继续教育有效期起
    **/
    @JSONField(name="cyclestart")
    private String cyclestart;

    /**
     *签注时间
    **/
    @JSONField(name="qianzhudate")
    private String qianzhudate;

    /**
     *是否签注,0 未签注,1 签注
    **/
    @JSONField(name="isqianzhu")
    private String isqianzhu;

    /**
     *从业资格证编号
    **/
    @JSONField(name="enbeworrecordid")
    private String enbeworrecordid;

    /**
     *继续教育有效期止
    **/
    @JSONField(name="cycleend")
    private String cycleend;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getRestudyid() {
        return restudyid;
    }

    public void setRestudyid(String restudyid) {
        this.restudyid = restudyid;
    }

    public String getCerid() {
        return cerid;
    }

    public void setCerid(String cerid) {
        this.cerid = cerid;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getWortype() {
        return wortype;
    }

    public void setWortype(String wortype) {
        this.wortype = wortype;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCredate() {
        return credate;
    }

    public void setCredate(String credate) {
        this.credate = credate;
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

    public char getIseffect() {
        return iseffect;
    }

    public void setIseffect(char iseffect) {
        this.iseffect = iseffect;
    }

    public String getCretime() {
        return cretime;
    }

    public void setCretime(String cretime) {
        this.cretime = cretime;
    }

    public String getCreusrcode() {
        return creusrcode;
    }

    public void setCreusrcode(String creusrcode) {
        this.creusrcode = creusrcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchname() {
        return schname;
    }

    public void setSchname(String schname) {
        this.schname = schname;
    }

    public String getSapplydate() {
        return sapplydate;
    }

    public void setSapplydate(String sapplydate) {
        this.sapplydate = sapplydate;
    }

    public String getGraduatedate() {
        return graduatedate;
    }

    public void setGraduatedate(String graduatedate) {
        this.graduatedate = graduatedate;
    }

    public String getStudytime() {
        return studytime;
    }

    public void setStudytime(String studytime) {
        this.studytime = studytime;
    }

    public String getExamgrade() {
        return examgrade;
    }

    public void setExamgrade(String examgrade) {
        this.examgrade = examgrade;
    }

    public String getExamresult() {
        return examresult;
    }

    public void setExamresult(String examresult) {
        this.examresult = examresult;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public char getIsuse() {
        return isuse;
    }

    public void setIsuse(char isuse) {
        this.isuse = isuse;
    }

    public String getRestudyimg1() {
        return restudyimg1;
    }

    public void setRestudyimg1(String restudyimg1) {
        this.restudyimg1 = restudyimg1;
    }

    public String getRestudyimg2() {
        return restudyimg2;
    }

    public void setRestudyimg2(String restudyimg2) {
        this.restudyimg2 = restudyimg2;
    }

    public String getRestudyreason() {
        return restudyreason;
    }

    public void setRestudyreason(String restudyreason) {
        this.restudyreason = restudyreason;
    }

    public String getChedepname() {
        return chedepname;
    }

    public void setChedepname(String chedepname) {
        this.chedepname = chedepname;
    }

    public String getExamdate() {
        return examdate;
    }

    public void setExamdate(String examdate) {
        this.examdate = examdate;
    }

    public String getCheusrdate() {
        return cheusrdate;
    }

    public void setCheusrdate(String cheusrdate) {
        this.cheusrdate = cheusrdate;
    }

    public String getCheusrname() {
        return cheusrname;
    }

    public void setCheusrname(String cheusrname) {
        this.cheusrname = cheusrname;
    }

    public String getQianzhuusrname() {
        return qianzhuusrname;
    }

    public void setQianzhuusrname(String qianzhuusrname) {
        this.qianzhuusrname = qianzhuusrname;
    }

    public String getCyclestart() {
        return cyclestart;
    }

    public void setCyclestart(String cyclestart) {
        this.cyclestart = cyclestart;
    }

    public String getQianzhudate() {
        return qianzhudate;
    }

    public void setQianzhudate(String qianzhudate) {
        this.qianzhudate = qianzhudate;
    }

    public String getIsqianzhu() {
        return isqianzhu;
    }

    public void setIsqianzhu(String isqianzhu) {
        this.isqianzhu = isqianzhu;
    }

    public String getEnbeworrecordid() {
        return enbeworrecordid;
    }

    public void setEnbeworrecordid(String enbeworrecordid) {
        this.enbeworrecordid = enbeworrecordid;
    }

    public String getCycleend() {
        return cycleend;
    }

    public void setCycleend(String cycleend) {
        this.cycleend = cycleend;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}