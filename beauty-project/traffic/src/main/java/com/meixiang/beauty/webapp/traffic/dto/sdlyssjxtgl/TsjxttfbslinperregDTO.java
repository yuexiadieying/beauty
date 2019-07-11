package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbslinperregDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *班线许可登记ID
    **/
    @JSONField(name="linperregid")
    private String linperregid;

    /**
     *业户ID
    **/
    @JSONField(name="ownerid")
    private String ownerid;

    /**
     *班线许可座位数
    **/
    @JSONField(name="passeanum")
    private Double passeanum;

    /**
     *是否班线循环
    **/
    @JSONField(name="cyclefatban")
    private String cyclefatban;

    /**
     *机构
    **/
    @JSONField(name="docdepcode")
    private String docdepcode;

    /**
     *天数
    **/
    @JSONField(name="days")
    private String days;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private Double iseffect;

    /**
     *许可状态
    **/
    @JSONField(name="perstatus")
    private Double perstatus;

    /**
     *修改时间
    **/
    @JSONField(name="editime")
    private String editime;

    /**
     *修改日期
    **/
    @JSONField(name="edidate")
    private String edidate;

    /**
     *修改者编号
    **/
    @JSONField(name="ediusrcode")
    private String ediusrcode;

    /**
     *创建时间
    **/
    @JSONField(name="cretime")
    private String cretime;

    /**
     *创建日期
    **/
    @JSONField(name="credate")
    private String credate;

    /**
     *创建者编号
    **/
    @JSONField(name="creusrcode")
    private String creusrcode;

    /**
     *经营期限止
    **/
    @JSONField(name="enddate")
    private String enddate;

    /**
     *经营期限起
    **/
    @JSONField(name="stadate")
    private String stadate;

    /**
     *对开业户名称
    **/
    @JSONField(name="biscltname")
    private String biscltname;

    /**
     *对开业户编号
    **/
    @JSONField(name="biscltid")
    private String biscltid;

    /**
     *许可车辆数
    **/
    @JSONField(name="pervecnum")
    private Double pervecnum;

    /**
     *日发班次
    **/
    @JSONField(name="times")
    private String times;

    /**
     *班车类别
    **/
    @JSONField(name="regctctype")
    private String regctctype;

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
     *是否公交线路
    **/
    @JSONField(name="isbus")
    private char isbus;

    /**
     *是否旅游线路
    **/
    @JSONField(name="istour")
    private char istour;

    /**
     *是否农村客运
    **/
    @JSONField(name="iscountry")
    private char iscountry;

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
    private char ishspeed;

    /**
     *高速里程
    **/
    @JSONField(name="heimil")
    private Double heimil;

    /**
     *总里程
    **/
    @JSONField(name="summil")
    private Double summil;

    /**
     *讫点行政区域代码
    **/
    @JSONField(name="endlindepcode")
    private String endlindepcode;

    /**
     *起点行政区域代码
    **/
    @JSONField(name="stalindepcode")
    private String stalindepcode;

    /**
     *途经主要地点
    **/
    @JSONField(name="bywayof")
    private String bywayof;

    /**
     *终到地
    **/
    @JSONField(name="enddepot")
    private String enddepot;

    /**
     *始发地
    **/
    @JSONField(name="stadepot")
    private String stadepot;

    /**
     *线路类型
    **/
    @JSONField(name="lintype")
    private char lintype;

    /**
     *经营区域
    **/
    @JSONField(name="busarea")
    private char busarea;

    /**
     *线路名称
    **/
    @JSONField(name="linname")
    private String linname;

    /**
     *时间戳
    **/
    @JSONField(name="sysopertime")
    private Double sysopertime;

    /**
     *备注
    **/
    @JSONField(name="remarkdoc")
    private String remarkdoc;

    /**
     *1运营2歇业
    **/
    @JSONField(name="linestatus")
    private String linestatus;

    /**
     *起始站点名称
    **/
    @JSONField(name="stacltname")
    private String stacltname;

    /**
     *讫点站点名称
    **/
    @JSONField(name="endcltname")
    private String endcltname;

    /**
     *停靠站点
    **/
    @JSONField(name="berth")
    private String berth;

    /**
     *是否接驳运输
    **/
    @JSONField(name="isconnects")
    private char isconnects;

    /**
     *接驳运输号
    **/
    @JSONField(name="connectsno")
    private String connectsno;

    /**
     *接驳点
    **/
    @JSONField(name="connectionpoint")
    private String connectionpoint;

    /**
     *状态起始日期
    **/
    @JSONField(name="stopstadate")
    private String stopstadate;

    /**
     *状态终止日期
    **/
    @JSONField(name="stopenddate")
    private String stopenddate;

    /**
     *发放日期
    **/
    @JSONField(name="gradate")
    private String gradate;

    @JSONField(name="stadepotname")
    private String stadepotname;

    @JSONField(name="enddepotname")
    private String enddepotname;

    /**
     *原班线许可ID
    **/
    @JSONField(name="oldlinperregid")
    private String oldlinperregid;

    /**
     *是否临时班次 1-是，2-否
    **/
    @JSONField(name="istemp")
    private String istemp;

    /**
     *标记台账中车辆id,以后导入更具车辆id关联班线更新导入
    **/
    @JSONField(name="tabcarid")
    private String tabcarid;

    /**
     *客运班次时间
    **/
    @JSONField(name="linetime")
    private String linetime;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getLinperregid() {
        return linperregid;
    }

    public void setLinperregid(String linperregid) {
        this.linperregid = linperregid;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public Double getPasseanum() {
        return passeanum;
    }

    public void setPasseanum(Double passeanum) {
        this.passeanum = passeanum;
    }

    public String getCyclefatban() {
        return cyclefatban;
    }

    public void setCyclefatban(String cyclefatban) {
        this.cyclefatban = cyclefatban;
    }

    public String getDocdepcode() {
        return docdepcode;
    }

    public void setDocdepcode(String docdepcode) {
        this.docdepcode = docdepcode;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Double getIseffect() {
        return iseffect;
    }

    public void setIseffect(Double iseffect) {
        this.iseffect = iseffect;
    }

    public Double getPerstatus() {
        return perstatus;
    }

    public void setPerstatus(Double perstatus) {
        this.perstatus = perstatus;
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

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getStadate() {
        return stadate;
    }

    public void setStadate(String stadate) {
        this.stadate = stadate;
    }

    public String getBiscltname() {
        return biscltname;
    }

    public void setBiscltname(String biscltname) {
        this.biscltname = biscltname;
    }

    public String getBiscltid() {
        return biscltid;
    }

    public void setBiscltid(String biscltid) {
        this.biscltid = biscltid;
    }

    public Double getPervecnum() {
        return pervecnum;
    }

    public void setPervecnum(Double pervecnum) {
        this.pervecnum = pervecnum;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getRegctctype() {
        return regctctype;
    }

    public void setRegctctype(String regctctype) {
        this.regctctype = regctctype;
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

    public char getIsbus() {
        return isbus;
    }

    public void setIsbus(char isbus) {
        this.isbus = isbus;
    }

    public char getIstour() {
        return istour;
    }

    public void setIstour(char istour) {
        this.istour = istour;
    }

    public char getIscountry() {
        return iscountry;
    }

    public void setIscountry(char iscountry) {
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

    public char getIshspeed() {
        return ishspeed;
    }

    public void setIshspeed(char ishspeed) {
        this.ishspeed = ishspeed;
    }

    public Double getHeimil() {
        return heimil;
    }

    public void setHeimil(Double heimil) {
        this.heimil = heimil;
    }

    public Double getSummil() {
        return summil;
    }

    public void setSummil(Double summil) {
        this.summil = summil;
    }

    public String getEndlindepcode() {
        return endlindepcode;
    }

    public void setEndlindepcode(String endlindepcode) {
        this.endlindepcode = endlindepcode;
    }

    public String getStalindepcode() {
        return stalindepcode;
    }

    public void setStalindepcode(String stalindepcode) {
        this.stalindepcode = stalindepcode;
    }

    public String getBywayof() {
        return bywayof;
    }

    public void setBywayof(String bywayof) {
        this.bywayof = bywayof;
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

    public char getLintype() {
        return lintype;
    }

    public void setLintype(char lintype) {
        this.lintype = lintype;
    }

    public char getBusarea() {
        return busarea;
    }

    public void setBusarea(char busarea) {
        this.busarea = busarea;
    }

    public String getLinname() {
        return linname;
    }

    public void setLinname(String linname) {
        this.linname = linname;
    }

    public Double getSysopertime() {
        return sysopertime;
    }

    public void setSysopertime(Double sysopertime) {
        this.sysopertime = sysopertime;
    }

    public String getRemarkdoc() {
        return remarkdoc;
    }

    public void setRemarkdoc(String remarkdoc) {
        this.remarkdoc = remarkdoc;
    }

    public String getLinestatus() {
        return linestatus;
    }

    public void setLinestatus(String linestatus) {
        this.linestatus = linestatus;
    }

    public String getStacltname() {
        return stacltname;
    }

    public void setStacltname(String stacltname) {
        this.stacltname = stacltname;
    }

    public String getEndcltname() {
        return endcltname;
    }

    public void setEndcltname(String endcltname) {
        this.endcltname = endcltname;
    }

    public String getBerth() {
        return berth;
    }

    public void setBerth(String berth) {
        this.berth = berth;
    }

    public char getIsconnects() {
        return isconnects;
    }

    public void setIsconnects(char isconnects) {
        this.isconnects = isconnects;
    }

    public String getConnectsno() {
        return connectsno;
    }

    public void setConnectsno(String connectsno) {
        this.connectsno = connectsno;
    }

    public String getConnectionpoint() {
        return connectionpoint;
    }

    public void setConnectionpoint(String connectionpoint) {
        this.connectionpoint = connectionpoint;
    }

    public String getStopstadate() {
        return stopstadate;
    }

    public void setStopstadate(String stopstadate) {
        this.stopstadate = stopstadate;
    }

    public String getStopenddate() {
        return stopenddate;
    }

    public void setStopenddate(String stopenddate) {
        this.stopenddate = stopenddate;
    }

    public String getGradate() {
        return gradate;
    }

    public void setGradate(String gradate) {
        this.gradate = gradate;
    }

    public String getStadepotname() {
        return stadepotname;
    }

    public void setStadepotname(String stadepotname) {
        this.stadepotname = stadepotname;
    }

    public String getEnddepotname() {
        return enddepotname;
    }

    public void setEnddepotname(String enddepotname) {
        this.enddepotname = enddepotname;
    }

    public String getOldlinperregid() {
        return oldlinperregid;
    }

    public void setOldlinperregid(String oldlinperregid) {
        this.oldlinperregid = oldlinperregid;
    }

    public String getIstemp() {
        return istemp;
    }

    public void setIstemp(String istemp) {
        this.istemp = istemp;
    }

    public String getTabcarid() {
        return tabcarid;
    }

    public void setTabcarid(String tabcarid) {
        this.tabcarid = tabcarid;
    }

    public String getLinetime() {
        return linetime;
    }

    public void setLinetime(String linetime) {
        this.linetime = linetime;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}