package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbsownertrainextDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *业户ID
    **/
    @JSONField(name="ownerid")
    private String ownerid;

    /**
     *企业ID
    **/
    @JSONField(name="epid")
    private String epid;

    /**
     *企业名称
    **/
    @JSONField(name="epname")
    private String epname;

    /**
     *培训机构编号
    **/
    @JSONField(name="custid")
    private String custid;

    /**
     *组织机构代码
    **/
    @JSONField(name="depcode")
    private String depcode;

    /**
     *法人代表
    **/
    @JSONField(name="legalrepresentative")
    private String legalrepresentative;

    /**
     *经营范围编码
    **/
    @JSONField(name="bnscope")
    private String bnscope;

    /**
     *分类等级
    **/
    @JSONField(name="classificationlevel")
    private String classificationlevel;

    /**
     *核定每期培训能力
    **/
    @JSONField(name="cheeactranum")
    private String cheeactranum;

    /**
     *服务方式
    **/
    @JSONField(name="servicemode")
    private char servicemode;

    /**
     *教练员总数
    **/
    @JSONField(name="coachnum")
    private String coachnum;

    /**
     *理论教练员数
    **/
    @JSONField(name="theoreticalcoachnum")
    private String theoreticalcoachnum;

    /**
     *驾驶操作教练员数
    **/
    @JSONField(name="praopercoachnum")
    private String praopercoachnum;

    /**
     *结业考核员数
    **/
    @JSONField(name="graassnum")
    private String graassnum;

    /**
     *安全管理人员数
    **/
    @JSONField(name="safmanagenum")
    private String safmanagenum;

    /**
     *教练车总数
    **/
    @JSONField(name="coachcarnum")
    private String coachcarnum;

    /**
     *大型客车总数
    **/
    @JSONField(name="motorbusnum")
    private String motorbusnum;

    /**
     *牵引车总数
    **/
    @JSONField(name="tractornum")
    private String tractornum;

    /**
     *城市公交车总数
    **/
    @JSONField(name="citybusnum")
    private String citybusnum;

    /**
     *中型客车总数
    **/
    @JSONField(name="mediumbusnum")
    private String mediumbusnum;

    /**
     *大型货车总数
    **/
    @JSONField(name="largetruecksnum")
    private String largetruecksnum;

    /**
     *小型汽车总数
    **/
    @JSONField(name="minicarnum")
    private String minicarnum;

    /**
     *低速汽车总数
    **/
    @JSONField(name="lowspeedcarnum")
    private String lowspeedcarnum;

    /**
     *残疾人教练车总数
    **/
    @JSONField(name="disablercoachnum")
    private String disablercoachnum;

    /**
     *"摩托车（含三轮摩托车、
二轮摩托车、轻便摩托
车）总数"
    **/
    @JSONField(name="motorcyclen")
    private String motorcyclen;

    /**
     *"其他车型（含轮式自行机
械车、无轨电车、有轨电
车）总数"
    **/
    @JSONField(name="othermodel")
    private String othermodel;

    /**
     *教室总面积
    **/
    @JSONField(name="classroomtotalarea")
    private String classroomtotalarea;

    /**
     *理论教室面积
    **/
    @JSONField(name="theorclassroomarea")
    private String theorclassroomarea;

    /**
     *多媒体教学设备总数
    **/
    @JSONField(name="multeachequi")
    private String multeachequi;

    /**
     *"多媒体理论教学软件总
数"
    **/
    @JSONField(name="multheoryteachsof")
    private String multheoryteachsof;

    /**
     *教学磁板总数
    **/
    @JSONField(name="magneticboard")
    private String magneticboard;

    /**
     *汽车驾驶模拟器总数
    **/
    @JSONField(name="drivingsimulator")
    private String drivingsimulator;

    /**
     *教练场总面积
    **/
    @JSONField(name="sitearea")
    private String sitearea;

    /**
     *其他教具和设备总数
    **/
    @JSONField(name="realiadevice")
    private String realiadevice;

    /**
     *场地驾驶教练场
    **/
    @JSONField(name="patterndriving")
    private String patterndriving;

    /**
     *实际道路驾驶教练路线
    **/
    @JSONField(name="actualroadroute")
    private String actualroadroute;

    /**
     *停车场面积
    **/
    @JSONField(name="parkingarea")
    private String parkingarea;

    /**
     *倒车入库数
    **/
    @JSONField(name="asternwarehousingnum")
    private String asternwarehousingnum;

    /**
     *倒车移位数
    **/
    @JSONField(name="reverseshiftnum")
    private String reverseshiftnum;

    /**
     *侧方停车数
    **/
    @JSONField(name="sideparkingnum")
    private String sideparkingnum;

    /**
     *坡道定点停车和起步数
    **/
    @JSONField(name="designatedparkstartnum")
    private String designatedparkstartnum;

    /**
     *直角转弯数
    **/
    @JSONField(name="quarterturnnum")
    private String quarterturnnum;

    /**
     *曲线行驶数
    **/
    @JSONField(name="curveroadnum")
    private String curveroadnum;

    /**
     *通过连续障碍数
    **/
    @JSONField(name="throughcontinuousbarriers")
    private String throughcontinuousbarriers;

    /**
     *通过单边桥数
    **/
    @JSONField(name="throughunilateralbridge")
    private String throughunilateralbridge;

    /**
     *通过限宽门数
    **/
    @JSONField(name="throughlimitdoornum")
    private String throughlimitdoornum;

    /**
     *起伏路行驶数
    **/
    @JSONField(name="roughroaddriving")
    private String roughroaddriving;

    /**
     *窄路调头数
    **/
    @JSONField(name="narrowroadturnnum")
    private String narrowroadturnnum;

    /**
     *模拟高速公路数
    **/
    @JSONField(name="simulatedhighway")
    private String simulatedhighway;

    /**
     *模拟连续急弯山区路数
    **/
    @JSONField(name="simulatedmountainroute")
    private String simulatedmountainroute;

    /**
     *模拟隧道数
    **/
    @JSONField(name="simulatedtunnelnum")
    private String simulatedtunnelnum;

    /**
     *模拟雨（雾）天湿滑路数
    **/
    @JSONField(name="simulatedrainway")
    private String simulatedrainway;

    /**
     *停靠站台数
    **/
    @JSONField(name="dockingplatformnum")
    private String dockingplatformnum;

    /**
     *停靠货台数
    **/
    @JSONField(name="dockinggoodnum")
    private String dockinggoodnum;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private String iseffect;

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
     *创建者编号
    **/
    @JSONField(name="creusrcode")
    private String creusrcode;

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
     *修改者编号
    **/
    @JSONField(name="ediusrcode")
    private String ediusrcode;

    /**
     *时间戳
    **/
    @JSONField(name="sysopertime")
    private Double sysopertime;

    /**
     *经度
    **/
    @JSONField(name="longitude")
    private String longitude;

    /**
     *纬度
    **/
    @JSONField(name="latitude")
    private String latitude;

    /**
     *场地审批状态
    **/
    @JSONField(name="cochareaapproval")
    private char cochareaapproval;

    /**
     *场地审批人
    **/
    @JSONField(name="cochareaapprovaluser")
    private String cochareaapprovaluser;

    /**
     *场地审批日期
    **/
    @JSONField(name="cochareaapprovaldate")
    private String cochareaapprovaldate;

    /**
     *场地审批时间
    **/
    @JSONField(name="cochareaapprovaltime")
    private String cochareaapprovaltime;

    /**
     *行政状态：0启用,1禁用学员报名，2禁用送审
    **/
    @JSONField(name="trainstatus")
    private String trainstatus;

    /**
     *备注
    **/
    @JSONField(name="remark")
    private String remark;

    @JSONField(name="isallowedprint")
    private char isallowedprint;

    @JSONField(name="isreport")
    private String isreport;

    @JSONField(name="trainarea")
    private String trainarea;

    @JSONField(name="business")
    private String business;

    /**
     *联盟ID
    **/
    @JSONField(name="alianceid")
    private String alianceid;

    @JSONField(name="inscode")
    private String inscode;

    @JSONField(name="shortname")
    private String shortname;

    @JSONField(name="operatperiod")
    private String operatperiod;

    @JSONField(name="depcodenum")
    private String depcodenum;

    @JSONField(name="inscodebak")
    private String inscodebak;

    @JSONField(name="creditcode")
    private String creditcode;

    @JSONField(name="licensenumber")
    private String licensenumber;

    @JSONField(name="licetime")
    private String licetime;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public String getEpid() {
        return epid;
    }

    public void setEpid(String epid) {
        this.epid = epid;
    }

    public String getEpname() {
        return epname;
    }

    public void setEpname(String epname) {
        this.epname = epname;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getDepcode() {
        return depcode;
    }

    public void setDepcode(String depcode) {
        this.depcode = depcode;
    }

    public String getLegalrepresentative() {
        return legalrepresentative;
    }

    public void setLegalrepresentative(String legalrepresentative) {
        this.legalrepresentative = legalrepresentative;
    }

    public String getBnscope() {
        return bnscope;
    }

    public void setBnscope(String bnscope) {
        this.bnscope = bnscope;
    }

    public String getClassificationlevel() {
        return classificationlevel;
    }

    public void setClassificationlevel(String classificationlevel) {
        this.classificationlevel = classificationlevel;
    }

    public String getCheeactranum() {
        return cheeactranum;
    }

    public void setCheeactranum(String cheeactranum) {
        this.cheeactranum = cheeactranum;
    }

    public char getServicemode() {
        return servicemode;
    }

    public void setServicemode(char servicemode) {
        this.servicemode = servicemode;
    }

    public String getCoachnum() {
        return coachnum;
    }

    public void setCoachnum(String coachnum) {
        this.coachnum = coachnum;
    }

    public String getTheoreticalcoachnum() {
        return theoreticalcoachnum;
    }

    public void setTheoreticalcoachnum(String theoreticalcoachnum) {
        this.theoreticalcoachnum = theoreticalcoachnum;
    }

    public String getPraopercoachnum() {
        return praopercoachnum;
    }

    public void setPraopercoachnum(String praopercoachnum) {
        this.praopercoachnum = praopercoachnum;
    }

    public String getGraassnum() {
        return graassnum;
    }

    public void setGraassnum(String graassnum) {
        this.graassnum = graassnum;
    }

    public String getSafmanagenum() {
        return safmanagenum;
    }

    public void setSafmanagenum(String safmanagenum) {
        this.safmanagenum = safmanagenum;
    }

    public String getCoachcarnum() {
        return coachcarnum;
    }

    public void setCoachcarnum(String coachcarnum) {
        this.coachcarnum = coachcarnum;
    }

    public String getMotorbusnum() {
        return motorbusnum;
    }

    public void setMotorbusnum(String motorbusnum) {
        this.motorbusnum = motorbusnum;
    }

    public String getTractornum() {
        return tractornum;
    }

    public void setTractornum(String tractornum) {
        this.tractornum = tractornum;
    }

    public String getCitybusnum() {
        return citybusnum;
    }

    public void setCitybusnum(String citybusnum) {
        this.citybusnum = citybusnum;
    }

    public String getMediumbusnum() {
        return mediumbusnum;
    }

    public void setMediumbusnum(String mediumbusnum) {
        this.mediumbusnum = mediumbusnum;
    }

    public String getLargetruecksnum() {
        return largetruecksnum;
    }

    public void setLargetruecksnum(String largetruecksnum) {
        this.largetruecksnum = largetruecksnum;
    }

    public String getMinicarnum() {
        return minicarnum;
    }

    public void setMinicarnum(String minicarnum) {
        this.minicarnum = minicarnum;
    }

    public String getLowspeedcarnum() {
        return lowspeedcarnum;
    }

    public void setLowspeedcarnum(String lowspeedcarnum) {
        this.lowspeedcarnum = lowspeedcarnum;
    }

    public String getDisablercoachnum() {
        return disablercoachnum;
    }

    public void setDisablercoachnum(String disablercoachnum) {
        this.disablercoachnum = disablercoachnum;
    }

    public String getMotorcyclen() {
        return motorcyclen;
    }

    public void setMotorcyclen(String motorcyclen) {
        this.motorcyclen = motorcyclen;
    }

    public String getOthermodel() {
        return othermodel;
    }

    public void setOthermodel(String othermodel) {
        this.othermodel = othermodel;
    }

    public String getClassroomtotalarea() {
        return classroomtotalarea;
    }

    public void setClassroomtotalarea(String classroomtotalarea) {
        this.classroomtotalarea = classroomtotalarea;
    }

    public String getTheorclassroomarea() {
        return theorclassroomarea;
    }

    public void setTheorclassroomarea(String theorclassroomarea) {
        this.theorclassroomarea = theorclassroomarea;
    }

    public String getMulteachequi() {
        return multeachequi;
    }

    public void setMulteachequi(String multeachequi) {
        this.multeachequi = multeachequi;
    }

    public String getMultheoryteachsof() {
        return multheoryteachsof;
    }

    public void setMultheoryteachsof(String multheoryteachsof) {
        this.multheoryteachsof = multheoryteachsof;
    }

    public String getMagneticboard() {
        return magneticboard;
    }

    public void setMagneticboard(String magneticboard) {
        this.magneticboard = magneticboard;
    }

    public String getDrivingsimulator() {
        return drivingsimulator;
    }

    public void setDrivingsimulator(String drivingsimulator) {
        this.drivingsimulator = drivingsimulator;
    }

    public String getSitearea() {
        return sitearea;
    }

    public void setSitearea(String sitearea) {
        this.sitearea = sitearea;
    }

    public String getRealiadevice() {
        return realiadevice;
    }

    public void setRealiadevice(String realiadevice) {
        this.realiadevice = realiadevice;
    }

    public String getPatterndriving() {
        return patterndriving;
    }

    public void setPatterndriving(String patterndriving) {
        this.patterndriving = patterndriving;
    }

    public String getActualroadroute() {
        return actualroadroute;
    }

    public void setActualroadroute(String actualroadroute) {
        this.actualroadroute = actualroadroute;
    }

    public String getParkingarea() {
        return parkingarea;
    }

    public void setParkingarea(String parkingarea) {
        this.parkingarea = parkingarea;
    }

    public String getAsternwarehousingnum() {
        return asternwarehousingnum;
    }

    public void setAsternwarehousingnum(String asternwarehousingnum) {
        this.asternwarehousingnum = asternwarehousingnum;
    }

    public String getReverseshiftnum() {
        return reverseshiftnum;
    }

    public void setReverseshiftnum(String reverseshiftnum) {
        this.reverseshiftnum = reverseshiftnum;
    }

    public String getSideparkingnum() {
        return sideparkingnum;
    }

    public void setSideparkingnum(String sideparkingnum) {
        this.sideparkingnum = sideparkingnum;
    }

    public String getDesignatedparkstartnum() {
        return designatedparkstartnum;
    }

    public void setDesignatedparkstartnum(String designatedparkstartnum) {
        this.designatedparkstartnum = designatedparkstartnum;
    }

    public String getQuarterturnnum() {
        return quarterturnnum;
    }

    public void setQuarterturnnum(String quarterturnnum) {
        this.quarterturnnum = quarterturnnum;
    }

    public String getCurveroadnum() {
        return curveroadnum;
    }

    public void setCurveroadnum(String curveroadnum) {
        this.curveroadnum = curveroadnum;
    }

    public String getThroughcontinuousbarriers() {
        return throughcontinuousbarriers;
    }

    public void setThroughcontinuousbarriers(String throughcontinuousbarriers) {
        this.throughcontinuousbarriers = throughcontinuousbarriers;
    }

    public String getThroughunilateralbridge() {
        return throughunilateralbridge;
    }

    public void setThroughunilateralbridge(String throughunilateralbridge) {
        this.throughunilateralbridge = throughunilateralbridge;
    }

    public String getThroughlimitdoornum() {
        return throughlimitdoornum;
    }

    public void setThroughlimitdoornum(String throughlimitdoornum) {
        this.throughlimitdoornum = throughlimitdoornum;
    }

    public String getRoughroaddriving() {
        return roughroaddriving;
    }

    public void setRoughroaddriving(String roughroaddriving) {
        this.roughroaddriving = roughroaddriving;
    }

    public String getNarrowroadturnnum() {
        return narrowroadturnnum;
    }

    public void setNarrowroadturnnum(String narrowroadturnnum) {
        this.narrowroadturnnum = narrowroadturnnum;
    }

    public String getSimulatedhighway() {
        return simulatedhighway;
    }

    public void setSimulatedhighway(String simulatedhighway) {
        this.simulatedhighway = simulatedhighway;
    }

    public String getSimulatedmountainroute() {
        return simulatedmountainroute;
    }

    public void setSimulatedmountainroute(String simulatedmountainroute) {
        this.simulatedmountainroute = simulatedmountainroute;
    }

    public String getSimulatedtunnelnum() {
        return simulatedtunnelnum;
    }

    public void setSimulatedtunnelnum(String simulatedtunnelnum) {
        this.simulatedtunnelnum = simulatedtunnelnum;
    }

    public String getSimulatedrainway() {
        return simulatedrainway;
    }

    public void setSimulatedrainway(String simulatedrainway) {
        this.simulatedrainway = simulatedrainway;
    }

    public String getDockingplatformnum() {
        return dockingplatformnum;
    }

    public void setDockingplatformnum(String dockingplatformnum) {
        this.dockingplatformnum = dockingplatformnum;
    }

    public String getDockinggoodnum() {
        return dockinggoodnum;
    }

    public void setDockinggoodnum(String dockinggoodnum) {
        this.dockinggoodnum = dockinggoodnum;
    }

    public String getIseffect() {
        return iseffect;
    }

    public void setIseffect(String iseffect) {
        this.iseffect = iseffect;
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

    public String getCreusrcode() {
        return creusrcode;
    }

    public void setCreusrcode(String creusrcode) {
        this.creusrcode = creusrcode;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public char getCochareaapproval() {
        return cochareaapproval;
    }

    public void setCochareaapproval(char cochareaapproval) {
        this.cochareaapproval = cochareaapproval;
    }

    public String getCochareaapprovaluser() {
        return cochareaapprovaluser;
    }

    public void setCochareaapprovaluser(String cochareaapprovaluser) {
        this.cochareaapprovaluser = cochareaapprovaluser;
    }

    public String getCochareaapprovaldate() {
        return cochareaapprovaldate;
    }

    public void setCochareaapprovaldate(String cochareaapprovaldate) {
        this.cochareaapprovaldate = cochareaapprovaldate;
    }

    public String getCochareaapprovaltime() {
        return cochareaapprovaltime;
    }

    public void setCochareaapprovaltime(String cochareaapprovaltime) {
        this.cochareaapprovaltime = cochareaapprovaltime;
    }

    public String getTrainstatus() {
        return trainstatus;
    }

    public void setTrainstatus(String trainstatus) {
        this.trainstatus = trainstatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public char getIsallowedprint() {
        return isallowedprint;
    }

    public void setIsallowedprint(char isallowedprint) {
        this.isallowedprint = isallowedprint;
    }

    public String getIsreport() {
        return isreport;
    }

    public void setIsreport(String isreport) {
        this.isreport = isreport;
    }

    public String getTrainarea() {
        return trainarea;
    }

    public void setTrainarea(String trainarea) {
        this.trainarea = trainarea;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getAlianceid() {
        return alianceid;
    }

    public void setAlianceid(String alianceid) {
        this.alianceid = alianceid;
    }

    public String getInscode() {
        return inscode;
    }

    public void setInscode(String inscode) {
        this.inscode = inscode;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getOperatperiod() {
        return operatperiod;
    }

    public void setOperatperiod(String operatperiod) {
        this.operatperiod = operatperiod;
    }

    public String getDepcodenum() {
        return depcodenum;
    }

    public void setDepcodenum(String depcodenum) {
        this.depcodenum = depcodenum;
    }

    public String getInscodebak() {
        return inscodebak;
    }

    public void setInscodebak(String inscodebak) {
        this.inscodebak = inscodebak;
    }

    public String getCreditcode() {
        return creditcode;
    }

    public void setCreditcode(String creditcode) {
        this.creditcode = creditcode;
    }

    public String getLicensenumber() {
        return licensenumber;
    }

    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber;
    }

    public String getLicetime() {
        return licetime;
    }

    public void setLicetime(String licetime) {
        this.licetime = licetime;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}