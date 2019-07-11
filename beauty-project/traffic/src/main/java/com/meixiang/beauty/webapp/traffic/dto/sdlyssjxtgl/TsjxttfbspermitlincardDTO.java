package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbspermitlincardDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *标志牌许可ID
    **/
    @JSONField(name="baseid")
    private String baseid;

    /**
     *许可决定客车类型
    **/
    @JSONField(name="bustyperating")
    private String bustyperating;

    /**
     *许可决定客车等级
    **/
    @JSONField(name="pasgrade")
    private String pasgrade;

    /**
     *许可决定车辆技术等级
    **/
    @JSONField(name="tecgrd")
    private String tecgrd;

    /**
     *许可决定核定载客位
    **/
    @JSONField(name="chenum")
    private String chenum;

    /**
     *许可决定车牌号码
    **/
    @JSONField(name="branum")
    private String branum;

    /**
     *许可决定车牌颜色
    **/
    @JSONField(name="bracolor")
    private String bracolor;

    /**
     *许可决定车牌ID
    **/
    @JSONField(name="cmvecid")
    private String cmvecid;

    /**
     *许可决定途经地点
    **/
    @JSONField(name="bywayof")
    private String bywayof;

    /**
     *许可决定有效期限起
    **/
    @JSONField(name="stadate")
    private String stadate;

    /**
     *许可决定有效期限止
    **/
    @JSONField(name="enddate")
    private String enddate;

    /**
     *许可决定班车类型
    **/
    @JSONField(name="regctctype")
    private String regctctype;

    /**
     *许可决定停靠站点
    **/
    @JSONField(name="berth")
    private String berth;

    /**
     *许可决定日发班次
    **/
    @JSONField(name="times")
    private String times;

    /**
     *许可决定讫点站名
    **/
    @JSONField(name="endcltname")
    private String endcltname;

    /**
     *许可决定起点站名
    **/
    @JSONField(name="stacltname")
    private String stacltname;

    /**
     *业户ID
    **/
    @JSONField(name="cmcltid")
    private String cmcltid;

    /**
     *许可决定起点站ID
    **/
    @JSONField(name="stacltid")
    private String stacltid;

    /**
     *许可决定讫点站ID
    **/
    @JSONField(name="endcltid")
    private String endcltid;

    /**
     *0正式牌,1临时牌,8延续许可,9变更许可，只有正式牌时方可进行相关的许可操作
    **/
    @JSONField(name="lincartype")
    private String lincartype;

    @JSONField(name="iseffect")
    private Double iseffect;

    @JSONField(name="cretime")
    private String cretime;

    @JSONField(name="credate")
    private String credate;

    @JSONField(name="creusrcode")
    private String creusrcode;

    @JSONField(name="editime")
    private String editime;

    @JSONField(name="edidate")
    private String edidate;

    @JSONField(name="ediusrcode")
    private String ediusrcode;

    @JSONField(name="sysopertime")
    private Double sysopertime;

    /**
     *用于标志牌各许可流程中进行关联的唯一值
    **/
    @JSONField(name="permitlincarid")
    private String permitlincarid;

    /**
     *标志牌ID
    **/
    @JSONField(name="lincarid")
    private String lincarid;

    /**
     *线路ID
    **/
    @JSONField(name="linperregid")
    private String linperregid;

    /**
     *线路名称
    **/
    @JSONField(name="linename")
    private String linename;

    /**
     *标志牌号
    **/
    @JSONField(name="lidcardno")
    private String lidcardno;

    /**
     *总里程
    **/
    @JSONField(name="summil")
    private String summil;

    /**
     *客运班线类型
    **/
    @JSONField(name="lintype")
    private String lintype;

    /**
     *讫点地名
    **/
    @JSONField(name="enddepot")
    private String enddepot;

    /**
     *起点地名
    **/
    @JSONField(name="stadepot")
    private String stadepot;

    /**
     *1  原车经营2  更换车辆3  报废更新
    **/
    @JSONField(name="conmothod")
    private String conmothod;

    /**
     *线路讫点名称
    **/
    @JSONField(name="enddepotname")
    private String enddepotname;

    /**
     *线路起点名称
    **/
    @JSONField(name="stadepotname")
    private String stadepotname;

    /**
     *是否班线循环
    **/
    @JSONField(name="cyclefatban")
    private String cyclefatban;

    /**
     *是否公交线路
    **/
    @JSONField(name="isbus")
    private String isbus;

    /**
     *是否旅游线路
    **/
    @JSONField(name="istour")
    private String istour;

    /**
     *是否农村客运
    **/
    @JSONField(name="iscountry")
    private String iscountry;

    /**
     *高速出口
    **/
    @JSONField(name="wayout")
    private String wayout;

    /**
     *高速入口
    **/
    @JSONField(name="entry")
    private String entry;

    /**
     *是否高速
    **/
    @JSONField(name="ishspeed")
    private String ishspeed;

    /**
     *高速里程
    **/
    @JSONField(name="heimil")
    private Double heimil;

    /**
     *对开业户编号
    **/
    @JSONField(name="biscltid")
    private String biscltid;

    /**
     *对开业户编号
    **/
    @JSONField(name="biscltname")
    private String biscltname;

    /**
     *机构
    **/
    @JSONField(name="docdepcode")
    private String docdepcode;

    /**
     *许可案例编号
    **/
    @JSONField(name="perid")
    private String perid;

    /**
     *许可决定书号
    **/
    @JSONField(name="perdecno")
    private String perdecno;

    /**
     *许可状态
    **/
    @JSONField(name="perstatus")
    private Double perstatus;

    /**
     *许可车辆数
    **/
    @JSONField(name="pervecnum")
    private Double pervecnum;

    /**
     *班线许可座位数
    **/
    @JSONField(name="passeanum")
    private Double passeanum;

    /**
     *经营区域
    **/
    @JSONField(name="busarea")
    private String busarea;

    /**
     *全流程许可状态
    **/
    @JSONField(name="permitstatus")
    private String permitstatus;

    /**
     *许可决定日期为了填写小台帐线下走流程时
    **/
    @JSONField(name="perdecdate")
    private String perdecdate;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getBaseid() {
        return baseid;
    }

    public void setBaseid(String baseid) {
        this.baseid = baseid;
    }

    public String getBustyperating() {
        return bustyperating;
    }

    public void setBustyperating(String bustyperating) {
        this.bustyperating = bustyperating;
    }

    public String getPasgrade() {
        return pasgrade;
    }

    public void setPasgrade(String pasgrade) {
        this.pasgrade = pasgrade;
    }

    public String getTecgrd() {
        return tecgrd;
    }

    public void setTecgrd(String tecgrd) {
        this.tecgrd = tecgrd;
    }

    public String getChenum() {
        return chenum;
    }

    public void setChenum(String chenum) {
        this.chenum = chenum;
    }

    public String getBranum() {
        return branum;
    }

    public void setBranum(String branum) {
        this.branum = branum;
    }

    public String getBracolor() {
        return bracolor;
    }

    public void setBracolor(String bracolor) {
        this.bracolor = bracolor;
    }

    public String getCmvecid() {
        return cmvecid;
    }

    public void setCmvecid(String cmvecid) {
        this.cmvecid = cmvecid;
    }

    public String getBywayof() {
        return bywayof;
    }

    public void setBywayof(String bywayof) {
        this.bywayof = bywayof;
    }

    public String getStadate() {
        return stadate;
    }

    public void setStadate(String stadate) {
        this.stadate = stadate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getRegctctype() {
        return regctctype;
    }

    public void setRegctctype(String regctctype) {
        this.regctctype = regctctype;
    }

    public String getBerth() {
        return berth;
    }

    public void setBerth(String berth) {
        this.berth = berth;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getEndcltname() {
        return endcltname;
    }

    public void setEndcltname(String endcltname) {
        this.endcltname = endcltname;
    }

    public String getStacltname() {
        return stacltname;
    }

    public void setStacltname(String stacltname) {
        this.stacltname = stacltname;
    }

    public String getCmcltid() {
        return cmcltid;
    }

    public void setCmcltid(String cmcltid) {
        this.cmcltid = cmcltid;
    }

    public String getStacltid() {
        return stacltid;
    }

    public void setStacltid(String stacltid) {
        this.stacltid = stacltid;
    }

    public String getEndcltid() {
        return endcltid;
    }

    public void setEndcltid(String endcltid) {
        this.endcltid = endcltid;
    }

    public String getLincartype() {
        return lincartype;
    }

    public void setLincartype(String lincartype) {
        this.lincartype = lincartype;
    }

    public Double getIseffect() {
        return iseffect;
    }

    public void setIseffect(Double iseffect) {
        this.iseffect = iseffect;
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

    public Double getSysopertime() {
        return sysopertime;
    }

    public void setSysopertime(Double sysopertime) {
        this.sysopertime = sysopertime;
    }

    public String getPermitlincarid() {
        return permitlincarid;
    }

    public void setPermitlincarid(String permitlincarid) {
        this.permitlincarid = permitlincarid;
    }

    public String getLincarid() {
        return lincarid;
    }

    public void setLincarid(String lincarid) {
        this.lincarid = lincarid;
    }

    public String getLinperregid() {
        return linperregid;
    }

    public void setLinperregid(String linperregid) {
        this.linperregid = linperregid;
    }

    public String getLinename() {
        return linename;
    }

    public void setLinename(String linename) {
        this.linename = linename;
    }

    public String getLidcardno() {
        return lidcardno;
    }

    public void setLidcardno(String lidcardno) {
        this.lidcardno = lidcardno;
    }

    public String getSummil() {
        return summil;
    }

    public void setSummil(String summil) {
        this.summil = summil;
    }

    public String getLintype() {
        return lintype;
    }

    public void setLintype(String lintype) {
        this.lintype = lintype;
    }

    public String getEnddepot() {
        return enddepot;
    }

    public void setEnddepot(String enddepot) {
        this.enddepot = enddepot;
    }

    public String getStadepot() {
        return stadepot;
    }

    public void setStadepot(String stadepot) {
        this.stadepot = stadepot;
    }

    public String getConmothod() {
        return conmothod;
    }

    public void setConmothod(String conmothod) {
        this.conmothod = conmothod;
    }

    public String getEnddepotname() {
        return enddepotname;
    }

    public void setEnddepotname(String enddepotname) {
        this.enddepotname = enddepotname;
    }

    public String getStadepotname() {
        return stadepotname;
    }

    public void setStadepotname(String stadepotname) {
        this.stadepotname = stadepotname;
    }

    public String getCyclefatban() {
        return cyclefatban;
    }

    public void setCyclefatban(String cyclefatban) {
        this.cyclefatban = cyclefatban;
    }

    public String getIsbus() {
        return isbus;
    }

    public void setIsbus(String isbus) {
        this.isbus = isbus;
    }

    public String getIstour() {
        return istour;
    }

    public void setIstour(String istour) {
        this.istour = istour;
    }

    public String getIscountry() {
        return iscountry;
    }

    public void setIscountry(String iscountry) {
        this.iscountry = iscountry;
    }

    public String getWayout() {
        return wayout;
    }

    public void setWayout(String wayout) {
        this.wayout = wayout;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getIshspeed() {
        return ishspeed;
    }

    public void setIshspeed(String ishspeed) {
        this.ishspeed = ishspeed;
    }

    public Double getHeimil() {
        return heimil;
    }

    public void setHeimil(Double heimil) {
        this.heimil = heimil;
    }

    public String getBiscltid() {
        return biscltid;
    }

    public void setBiscltid(String biscltid) {
        this.biscltid = biscltid;
    }

    public String getBiscltname() {
        return biscltname;
    }

    public void setBiscltname(String biscltname) {
        this.biscltname = biscltname;
    }

    public String getDocdepcode() {
        return docdepcode;
    }

    public void setDocdepcode(String docdepcode) {
        this.docdepcode = docdepcode;
    }

    public String getPerid() {
        return perid;
    }

    public void setPerid(String perid) {
        this.perid = perid;
    }

    public String getPerdecno() {
        return perdecno;
    }

    public void setPerdecno(String perdecno) {
        this.perdecno = perdecno;
    }

    public Double getPerstatus() {
        return perstatus;
    }

    public void setPerstatus(Double perstatus) {
        this.perstatus = perstatus;
    }

    public Double getPervecnum() {
        return pervecnum;
    }

    public void setPervecnum(Double pervecnum) {
        this.pervecnum = pervecnum;
    }

    public Double getPasseanum() {
        return passeanum;
    }

    public void setPasseanum(Double passeanum) {
        this.passeanum = passeanum;
    }

    public String getBusarea() {
        return busarea;
    }

    public void setBusarea(String busarea) {
        this.busarea = busarea;
    }

    public String getPermitstatus() {
        return permitstatus;
    }

    public void setPermitstatus(String permitstatus) {
        this.permitstatus = permitstatus;
    }

    public String getPerdecdate() {
        return perdecdate;
    }

    public void setPerdecdate(String perdecdate) {
        this.perdecdate = perdecdate;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}