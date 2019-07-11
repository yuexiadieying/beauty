package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbsappstationDTO {


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
     *车站名称
    **/
    @JSONField(name="canname")
    private String canname;

    /**
     *车站ID
    **/
    @JSONField(name="canid")
    private String canid;

    /**
     *行政区划代码
    **/
    @JSONField(name="cancode")
    private String cancode;

    /**
     *行政区划地址
    **/
    @JSONField(name="cancodeaddress")
    private String cancodeaddress;

    /**
     *详细地址
    **/
    @JSONField(name="address")
    private String address;

    /**
     *邮政编码
    **/
    @JSONField(name="postalcode")
    private String postalcode;

    /**
     *经济类型
    **/
    @JSONField(name="economictype")
    private String economictype;

    /**
     *负责人
    **/
    @JSONField(name="principal")
    private String principal;

    /**
     *电话号码
    **/
    @JSONField(name="priphone")
    private String priphone;

    /**
     *主管部门
    **/
    @JSONField(name="deptcode")
    private String deptcode;

    /**
     *建站日期
    **/
    @JSONField(name="builddate")
    private String builddate;

    /**
     *站房面积
    **/
    @JSONField(name="plantarea")
    private String plantarea;

    /**
     *停车场面积
    **/
    @JSONField(name="prklotarea")
    private String prklotarea;

    /**
     *投资规模（万元）
    **/
    @JSONField(name="investscale")
    private String investscale;

    /**
     *是否站运分离
    **/
    @JSONField(name="isstatranssepa")
    private Integer isstatranssepa;

    /**
     *是否采用电子计算机售票
    **/
    @JSONField(name="iscompaytic")
    private Integer iscompaytic;

    /**
     *日发班次（班）
    **/
    @JSONField(name="times")
    private String times;

    /**
     *日发班次（天）
    **/
    @JSONField(name="days")
    private String days;

    /**
     *设计班次（班）
    **/
    @JSONField(name="designtimes")
    private String designtimes;

    /**
     *设计班次（天）
    **/
    @JSONField(name="designdays")
    private String designdays;

    /**
     *联网售票情况
    **/
    @JSONField(name="networkticketsituation")
    private Integer networkticketsituation;

    /**
     *是否开放
    **/
    @JSONField(name="isopen")
    private Integer isopen;

    /**
     *申报级别
    **/
    @JSONField(name="appgrade")
    private String appgrade;

    /**
     *类型，06表示客运站，07表示货运站
    **/
    @JSONField(name="stationtype")
    private String stationtype;

    /**
     *占地面积
    **/
    @JSONField(name="area")
    private Double area;

    /**
     *建筑面积
    **/
    @JSONField(name="buildarea")
    private Double buildarea;

    /**
     *日均旅客发送量
    **/
    @JSONField(name="daycapacity")
    private Integer daycapacity;

    /**
     *设计旅客日发送量
    **/
    @JSONField(name="descapacity")
    private Integer descapacity;

    /**
     *竣工日期
    **/
    @JSONField(name="completedate")
    private String completedate;

    /**
     *场站级别
    **/
    @JSONField(name="grade")
    private String grade;

    /**
     *验收日期
    **/
    @JSONField(name="acceptdate")
    private String acceptdate;

    /**
     *拟投入运营日期
    **/
    @JSONField(name="workingdate")
    private String workingdate;

    /**
     *时间戳
    **/
    @JSONField(name="sysopertime")
    private Double sysopertime;

    /**
     *申报单位
    **/
    @JSONField(name="clitname")
    private String clitname;

    /**
     *客运站行政区划地址
    **/
    @JSONField(name="unitcancodeaddress")
    private String unitcancodeaddress;

    /**
     *客运站详细地址
    **/
    @JSONField(name="unitaddress")
    private String unitaddress;

    /**
     *客运站行政区划
    **/
    @JSONField(name="unitcancode")
    private String unitcancode;

    /**
     *备注
    **/
    @JSONField(name="remarkdoc")
    private String remarkdoc;

    /**
     *经办人姓名
    **/
    @JSONField(name="doper")
    private String doper;

    /**
     *经办人电话
    **/
    @JSONField(name="doperphone")
    private String doperphone;

    /**
     *联系电话
    **/
    @JSONField(name="phone")
    private String phone;

    /**
     *电子邮箱
    **/
    @JSONField(name="email")
    private String email;

    /**
     *业户主页
    **/
    @JSONField(name="homeresidents")
    private String homeresidents;

    /**
     *传真电话
    **/
    @JSONField(name="faxphone")
    private String faxphone;

    /**
     *法定代表人
    **/
    @JSONField(name="jurperson")
    private String jurperson;

    /**
     *法人身份证
    **/
    @JSONField(name="ctcno")
    private String ctcno;

    /**
     *法定代表人证件类型
    **/
    @JSONField(name="jurctctype")
    private String jurctctype;

    /**
     *法人联系电话
    **/
    @JSONField(name="jurctcphone")
    private String jurctcphone;

    /**
     *法人手机
    **/
    @JSONField(name="jurctcmobile")
    private String jurctcmobile;

    /**
     *许可证字
    **/
    @JSONField(name="perword")
    private String perword;

    /**
     *许可证号
    **/
    @JSONField(name="licensenumber")
    private String licensenumber;

    /**
     *车站代码
    **/
    @JSONField(name="camcpde")
    private String camcpde;

    /**
     *简称
    **/
    @JSONField(name="shotitle")
    private String shotitle;

    /**
     *助记符
    **/
    @JSONField(name="eastofind")
    private String eastofind;

    /**
     *别名
    **/
    @JSONField(name="othername")
    private String othername;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private Integer iseffect;

    /**
     *实收资本
    **/
    @JSONField(name="paiclupcapital")
    private String paiclupcapital;

    /**
     *营业期限
    **/
    @JSONField(name="operatingperiod")
    private String operatingperiod;

    /**
     *组织机构代码
    **/
    @JSONField(name="organizationcode")
    private String organizationcode;

    /**
     *应急值班电话
    **/
    @JSONField(name="emergenciesphone")
    private String emergenciesphone;

    /**
     *工商注册号
    **/
    @JSONField(name="busiregnumber")
    private String busiregnumber;

    /**
     *注册资金
    **/
    @JSONField(name="registeredcapital")
    private String registeredcapital;

    /**
     *成立日期
    **/
    @JSONField(name="establishdate")
    private String establishdate;

    /**
     *投诉电话
    **/
    @JSONField(name="complaintsphone")
    private String complaintsphone;

    /**
     *所属部门
    **/
    @JSONField(name="depttype")
    private String depttype;

    /**
     *成立日期
    **/
    @JSONField(name="gradate")
    private String gradate;

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

    public String getCanname() {
        return canname;
    }

    public void setCanname(String canname) {
        this.canname = canname;
    }

    public String getCanid() {
        return canid;
    }

    public void setCanid(String canid) {
        this.canid = canid;
    }

    public String getCancode() {
        return cancode;
    }

    public void setCancode(String cancode) {
        this.cancode = cancode;
    }

    public String getCancodeaddress() {
        return cancodeaddress;
    }

    public void setCancodeaddress(String cancodeaddress) {
        this.cancodeaddress = cancodeaddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getEconomictype() {
        return economictype;
    }

    public void setEconomictype(String economictype) {
        this.economictype = economictype;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPriphone() {
        return priphone;
    }

    public void setPriphone(String priphone) {
        this.priphone = priphone;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getBuilddate() {
        return builddate;
    }

    public void setBuilddate(String builddate) {
        this.builddate = builddate;
    }

    public String getPlantarea() {
        return plantarea;
    }

    public void setPlantarea(String plantarea) {
        this.plantarea = plantarea;
    }

    public String getPrklotarea() {
        return prklotarea;
    }

    public void setPrklotarea(String prklotarea) {
        this.prklotarea = prklotarea;
    }

    public String getInvestscale() {
        return investscale;
    }

    public void setInvestscale(String investscale) {
        this.investscale = investscale;
    }

    public Integer getIsstatranssepa() {
        return isstatranssepa;
    }

    public void setIsstatranssepa(Integer isstatranssepa) {
        this.isstatranssepa = isstatranssepa;
    }

    public Integer getIscompaytic() {
        return iscompaytic;
    }

    public void setIscompaytic(Integer iscompaytic) {
        this.iscompaytic = iscompaytic;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDesigntimes() {
        return designtimes;
    }

    public void setDesigntimes(String designtimes) {
        this.designtimes = designtimes;
    }

    public String getDesigndays() {
        return designdays;
    }

    public void setDesigndays(String designdays) {
        this.designdays = designdays;
    }

    public Integer getNetworkticketsituation() {
        return networkticketsituation;
    }

    public void setNetworkticketsituation(Integer networkticketsituation) {
        this.networkticketsituation = networkticketsituation;
    }

    public Integer getIsopen() {
        return isopen;
    }

    public void setIsopen(Integer isopen) {
        this.isopen = isopen;
    }

    public String getAppgrade() {
        return appgrade;
    }

    public void setAppgrade(String appgrade) {
        this.appgrade = appgrade;
    }

    public String getStationtype() {
        return stationtype;
    }

    public void setStationtype(String stationtype) {
        this.stationtype = stationtype;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getBuildarea() {
        return buildarea;
    }

    public void setBuildarea(Double buildarea) {
        this.buildarea = buildarea;
    }

    public Integer getDaycapacity() {
        return daycapacity;
    }

    public void setDaycapacity(Integer daycapacity) {
        this.daycapacity = daycapacity;
    }

    public Integer getDescapacity() {
        return descapacity;
    }

    public void setDescapacity(Integer descapacity) {
        this.descapacity = descapacity;
    }

    public String getCompletedate() {
        return completedate;
    }

    public void setCompletedate(String completedate) {
        this.completedate = completedate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAcceptdate() {
        return acceptdate;
    }

    public void setAcceptdate(String acceptdate) {
        this.acceptdate = acceptdate;
    }

    public String getWorkingdate() {
        return workingdate;
    }

    public void setWorkingdate(String workingdate) {
        this.workingdate = workingdate;
    }

    public Double getSysopertime() {
        return sysopertime;
    }

    public void setSysopertime(Double sysopertime) {
        this.sysopertime = sysopertime;
    }

    public String getClitname() {
        return clitname;
    }

    public void setClitname(String clitname) {
        this.clitname = clitname;
    }

    public String getUnitcancodeaddress() {
        return unitcancodeaddress;
    }

    public void setUnitcancodeaddress(String unitcancodeaddress) {
        this.unitcancodeaddress = unitcancodeaddress;
    }

    public String getUnitaddress() {
        return unitaddress;
    }

    public void setUnitaddress(String unitaddress) {
        this.unitaddress = unitaddress;
    }

    public String getUnitcancode() {
        return unitcancode;
    }

    public void setUnitcancode(String unitcancode) {
        this.unitcancode = unitcancode;
    }

    public String getRemarkdoc() {
        return remarkdoc;
    }

    public void setRemarkdoc(String remarkdoc) {
        this.remarkdoc = remarkdoc;
    }

    public String getDoper() {
        return doper;
    }

    public void setDoper(String doper) {
        this.doper = doper;
    }

    public String getDoperphone() {
        return doperphone;
    }

    public void setDoperphone(String doperphone) {
        this.doperphone = doperphone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeresidents() {
        return homeresidents;
    }

    public void setHomeresidents(String homeresidents) {
        this.homeresidents = homeresidents;
    }

    public String getFaxphone() {
        return faxphone;
    }

    public void setFaxphone(String faxphone) {
        this.faxphone = faxphone;
    }

    public String getJurperson() {
        return jurperson;
    }

    public void setJurperson(String jurperson) {
        this.jurperson = jurperson;
    }

    public String getCtcno() {
        return ctcno;
    }

    public void setCtcno(String ctcno) {
        this.ctcno = ctcno;
    }

    public String getJurctctype() {
        return jurctctype;
    }

    public void setJurctctype(String jurctctype) {
        this.jurctctype = jurctctype;
    }

    public String getJurctcphone() {
        return jurctcphone;
    }

    public void setJurctcphone(String jurctcphone) {
        this.jurctcphone = jurctcphone;
    }

    public String getJurctcmobile() {
        return jurctcmobile;
    }

    public void setJurctcmobile(String jurctcmobile) {
        this.jurctcmobile = jurctcmobile;
    }

    public String getPerword() {
        return perword;
    }

    public void setPerword(String perword) {
        this.perword = perword;
    }

    public String getLicensenumber() {
        return licensenumber;
    }

    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber;
    }

    public String getCamcpde() {
        return camcpde;
    }

    public void setCamcpde(String camcpde) {
        this.camcpde = camcpde;
    }

    public String getShotitle() {
        return shotitle;
    }

    public void setShotitle(String shotitle) {
        this.shotitle = shotitle;
    }

    public String getEastofind() {
        return eastofind;
    }

    public void setEastofind(String eastofind) {
        this.eastofind = eastofind;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public Integer getIseffect() {
        return iseffect;
    }

    public void setIseffect(Integer iseffect) {
        this.iseffect = iseffect;
    }

    public String getPaiclupcapital() {
        return paiclupcapital;
    }

    public void setPaiclupcapital(String paiclupcapital) {
        this.paiclupcapital = paiclupcapital;
    }

    public String getOperatingperiod() {
        return operatingperiod;
    }

    public void setOperatingperiod(String operatingperiod) {
        this.operatingperiod = operatingperiod;
    }

    public String getOrganizationcode() {
        return organizationcode;
    }

    public void setOrganizationcode(String organizationcode) {
        this.organizationcode = organizationcode;
    }

    public String getEmergenciesphone() {
        return emergenciesphone;
    }

    public void setEmergenciesphone(String emergenciesphone) {
        this.emergenciesphone = emergenciesphone;
    }

    public String getBusiregnumber() {
        return busiregnumber;
    }

    public void setBusiregnumber(String busiregnumber) {
        this.busiregnumber = busiregnumber;
    }

    public String getRegisteredcapital() {
        return registeredcapital;
    }

    public void setRegisteredcapital(String registeredcapital) {
        this.registeredcapital = registeredcapital;
    }

    public String getEstablishdate() {
        return establishdate;
    }

    public void setEstablishdate(String establishdate) {
        this.establishdate = establishdate;
    }

    public String getComplaintsphone() {
        return complaintsphone;
    }

    public void setComplaintsphone(String complaintsphone) {
        this.complaintsphone = complaintsphone;
    }

    public String getDepttype() {
        return depttype;
    }

    public void setDepttype(String depttype) {
        this.depttype = depttype;
    }

    public String getGradate() {
        return gradate;
    }

    public void setGradate(String gradate) {
        this.gradate = gradate;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}