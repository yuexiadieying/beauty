package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbsvecgoodstecgrdDTO {


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
     *本次评定日期
    **/
    @JSONField(name="tecgrdtodate")
    private String tecgrdtodate;

    /**
     *下次评定日期
    **/
    @JSONField(name="nexttecgrdtodate")
    private String nexttecgrdtodate;

    /**
     *技术等级
    **/
    @JSONField(name="tecgrd")
    private String tecgrd;

    /**
     *等级评定单位
    **/
    @JSONField(name="ctrltypeinscmcltid")
    private String ctrltypeinscmcltid;

    /**
     *检测单号
    **/
    @JSONField(name="vindrepno")
    private String vindrepno;

    /**
     *授权签字人姓名
    **/
    @JSONField(name="authorizedname")
    private String authorizedname;

    /**
     *综合性能检测结果
    **/
    @JSONField(name="detresult")
    private String detresult;

    /**
     *备注
    **/
    @JSONField(name="remarkc")
    private String remarkc;

    /**
     *检测日期
    **/
    @JSONField(name="vinregdate")
    private String vinregdate;

    /**
     *技术等级评定人
    **/
    @JSONField(name="cheusername")
    private String cheusername;

    @JSONField(name="vecsafchk")
    private String vecsafchk;

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

    public String getTecgrdtodate() {
        return tecgrdtodate;
    }

    public void setTecgrdtodate(String tecgrdtodate) {
        this.tecgrdtodate = tecgrdtodate;
    }

    public String getNexttecgrdtodate() {
        return nexttecgrdtodate;
    }

    public void setNexttecgrdtodate(String nexttecgrdtodate) {
        this.nexttecgrdtodate = nexttecgrdtodate;
    }

    public String getTecgrd() {
        return tecgrd;
    }

    public void setTecgrd(String tecgrd) {
        this.tecgrd = tecgrd;
    }

    public String getCtrltypeinscmcltid() {
        return ctrltypeinscmcltid;
    }

    public void setCtrltypeinscmcltid(String ctrltypeinscmcltid) {
        this.ctrltypeinscmcltid = ctrltypeinscmcltid;
    }

    public String getVindrepno() {
        return vindrepno;
    }

    public void setVindrepno(String vindrepno) {
        this.vindrepno = vindrepno;
    }

    public String getAuthorizedname() {
        return authorizedname;
    }

    public void setAuthorizedname(String authorizedname) {
        this.authorizedname = authorizedname;
    }

    public String getDetresult() {
        return detresult;
    }

    public void setDetresult(String detresult) {
        this.detresult = detresult;
    }

    public String getRemarkc() {
        return remarkc;
    }

    public void setRemarkc(String remarkc) {
        this.remarkc = remarkc;
    }

    public String getVinregdate() {
        return vinregdate;
    }

    public void setVinregdate(String vinregdate) {
        this.vinregdate = vinregdate;
    }

    public String getCheusername() {
        return cheusername;
    }

    public void setCheusername(String cheusername) {
        this.cheusername = cheusername;
    }

    public String getVecsafchk() {
        return vecsafchk;
    }

    public void setVecsafchk(String vecsafchk) {
        this.vecsafchk = vecsafchk;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}