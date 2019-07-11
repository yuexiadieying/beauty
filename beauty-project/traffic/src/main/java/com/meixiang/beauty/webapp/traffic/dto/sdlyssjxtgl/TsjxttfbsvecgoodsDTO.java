package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbsvecgoodsDTO {


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
     *业户ID
    **/
    @JSONField(name="ownerid")
    private String ownerid;

    /**
     *购车价格(万元)
    **/
    @JSONField(name="buyprice")
    private Double buyprice;

    /**
     *后轮距
    **/
    @JSONField(name="befwhetread")
    private Double befwhetread;

    /**
     *制造厂名称
    **/
    @JSONField(name="prdfactory")
    private String prdfactory;

    /**
     *防抱制动装置
    **/
    @JSONField(name="havabs")
    private char havabs;

    /**
     *气/液压制动
    **/
    @JSONField(name="hydformat")
    private String hydformat;

    /**
     *前照灯制式
    **/
    @JSONField(name="beflapformat")
    private char beflapformat;

    /**
     *燃料电喷装置
    **/
    @JSONField(name="fuespoutformat")
    private char fuespoutformat;

    /**
     *后悬架型式
    **/
    @JSONField(name="aftpdtformat")
    private char aftpdtformat;

    /**
     *前悬架型式
    **/
    @JSONField(name="befpdtformat")
    private char befpdtformat;

    /**
     *变速器型式
    **/
    @JSONField(name="tsmformat")
    private char tsmformat;

    /**
     *外转向轮转角
    **/
    @JSONField(name="wottraangle")
    private Double wottraangle;

    /**
     *内转向轮转角
    **/
    @JSONField(name="wittraangle")
    private Double wittraangle;

    /**
     *最高车速
    **/
    @JSONField(name="msthigspeed")
    private Double msthigspeed;

    /**
     *轮胎规格
    **/
    @JSONField(name="tyrstandard")
    private String tyrstandard;

    /**
     *核定载质量
    **/
    @JSONField(name="chelodmass")
    private Double chelodmass;

    /**
     *转向形式
    **/
    @JSONField(name="turformat")
    private String turformat;

    /**
     *额定扭矩转速
    **/
    @JSONField(name="engtormomrotspeed")
    private Double engtormomrotspeed;

    /**
     *发动机扭矩
    **/
    @JSONField(name="engtormoment")
    private Double engtormoment;

    /**
     *额定转速
    **/
    @JSONField(name="ratrotspeed")
    private Double ratrotspeed;

    /**
     *发动机排量
    **/
    @JSONField(name="engdismoment")
    private Double engdismoment;

    /**
     *国产/进口
    **/
    @JSONField(name="isforeign")
    private char isforeign;

    /**
     *定位系统安装状态
    **/
    @JSONField(name="gotosysstat")
    private String gotosysstat;

    /**
     *行车记录仪安装状态
    **/
    @JSONField(name="logappstat")
    private String logappstat;

    /**
     *定位模式
    **/
    @JSONField(name="tracker")
    private String tracker;

    /**
     *定位平台运营商
    **/
    @JSONField(name="facilitator")
    private String facilitator;

    /**
     *卫星定位设备型号
    **/
    @JSONField(name="devicetype")
    private String devicetype;

    /**
     *有效通讯工具号码
    **/
    @JSONField(name="commtool")
    private String commtool;

    /**
     *是否出入境
    **/
    @JSONField(name="isinout")
    private char isinout;

    /**
     *整备总质量KG
    **/
    @JSONField(name="fulequip")
    private Double fulequip;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private Double iseffect;

    /**
     *经营方式
    **/
    @JSONField(name="bustype")
    private String bustype;

    /**
     *报废年限
    **/
    @JSONField(name="years")
    private Double years;

    /**
     *营运状态
    **/
    @JSONField(name="vecbusstatus")
    private String vecbusstatus;

    /**
     *里程数
    **/
    @JSONField(name="milage")
    private Double milage;

    /**
     *驱动方式
    **/
    @JSONField(name="dritype")
    private String dritype;

    /**
     *百公里耗油
    **/
    @JSONField(name="hunmiluseoil")
    private Double hunmiluseoil;

    /**
     *车辆档案变更人员编号
    **/
    @JSONField(name="ediusrcode")
    private String ediusrcode;

    /**
     *车辆档案变更时间
    **/
    @JSONField(name="editime")
    private String editime;

    /**
     *车辆档案变更日期
    **/
    @JSONField(name="edidate")
    private String edidate;

    /**
     *车辆建档人员编号
    **/
    @JSONField(name="creusrcode")
    private String creusrcode;

    /**
     *车辆建档时间
    **/
    @JSONField(name="cretime")
    private String cretime;

    /**
     *车辆建档日期
    **/
    @JSONField(name="credate")
    private String credate;

    /**
     *档位
    **/
    @JSONField(name="arcsplace")
    private String arcsplace;

    /**
     *后轴钢板弹簧片数
    **/
    @JSONField(name="sprnum")
    private Double sprnum;

    /**
     *车轴数
    **/
    @JSONField(name="axlnum")
    private Double axlnum;

    /**
     *车宽
    **/
    @JSONField(name="vecwide")
    private Double vecwide;

    /**
     *车高
    **/
    @JSONField(name="vechigh")
    private Double vechigh;

    /**
     *车长
    **/
    @JSONField(name="veclength")
    private Double veclength;

    /**
     *轮胎数
    **/
    @JSONField(name="tyrenum")
    private Double tyrenum;

    /**
     *轴距
    **/
    @JSONField(name="whebase")
    private Double whebase;

    /**
     *轮距
    **/
    @JSONField(name="whetread")
    private Double whetread;

    /**
     *落户日期
    **/
    @JSONField(name="setdate")
    private String setdate;

    /**
     *购车日期
    **/
    @JSONField(name="buydate")
    private String buydate;

    /**
     *出厂日期
    **/
    @JSONField(name="prodate")
    private String prodate;

    /**
     *售车单位
    **/
    @JSONField(name="selvecshop")
    private String selvecshop;

    /**
     *发动机核定功率
    **/
    @JSONField(name="chepower")
    private Double chepower;

    /**
     *发动机功率
    **/
    @JSONField(name="engpower")
    private Double engpower;

    /**
     *燃料类型
    **/
    @JSONField(name="eldtype")
    private String eldtype;

    /**
     *车辆识别码
    **/
    @JSONField(name="franum")
    private String franum;

    /**
     *发动机号
    **/
    @JSONField(name="engnum")
    private String engnum;

    /**
     *发动机型号
    **/
    @JSONField(name="engtype")
    private String engtype;

    /**
     *车身颜色
    **/
    @JSONField(name="veccolor")
    private String veccolor;

    /**
     *车辆类型
    **/
    @JSONField(name="vectype")
    private String vectype;

    /**
     *实体类别
    **/
    @JSONField(name="vecentype")
    private String vecentype;

    /**
     *型号
    **/
    @JSONField(name="model")
    private String model;

    /**
     *厂牌
    **/
    @JSONField(name="factype")
    private String factype;

    /**
     *车牌号码
    **/
    @JSONField(name="branum")
    private String branum;

    /**
     *车牌颜色
    **/
    @JSONField(name="bracolor")
    private String bracolor;

    /**
     *车籍地
    **/
    @JSONField(name="vecaddr")
    private String vecaddr;

    /**
     *所属机构
    **/
    @JSONField(name="depcode")
    private String depcode;

    /**
     *时间戳
    **/
    @JSONField(name="sysopertime")
    private Double sysopertime;

    /**
     *建档日期
    **/
    @JSONField(name="currentdatefricredocdate")
    private String currentdatefricredocdate;

    /**
     *是否燃料核查车辆
    **/
    @JSONField(name="fuetype")
    private String fuetype;

    /**
     *总质量
    **/
    @JSONField(name="totalmass")
    private String totalmass;

    /**
     *燃料核查ID
    **/
    @JSONField(name="fuelcheckid")
    private String fuelcheckid;

    /**
     *产品名称
    **/
    @JSONField(name="brandname")
    private String brandname;

    /**
     *驱动型式
    **/
    @JSONField(name="cmvecunit")
    private String cmvecunit;

    /**
     *底盘型号
    **/
    @JSONField(name="chassistype")
    private String chassistype;

    /**
     *核定座位
    **/
    @JSONField(name="cheseats")
    private Double cheseats;

    /**
     *备注
    **/
    @JSONField(name="remarks")
    private String remarks;

    /**
     *运力来源
    **/
    @JSONField(name="regype")
    private String regype;

    /**
     *技术档案号
    **/
    @JSONField(name="technicalnumber")
    private String technicalnumber;

    /**
     *注册日期
    **/
    @JSONField(name="registrationdate")
    private String registrationdate;

    /**
     *发证日期
    **/
    @JSONField(name="lssuingdate")
    private String lssuingdate;

    /**
     *行驶证检验有效期至
    **/
    @JSONField(name="drilicenddate")
    private String drilicenddate;

    /**
     *配备通讯工具
    **/
    @JSONField(name="iscommtool")
    private String iscommtool;

    /**
     *车辆接入卫星定位平台名称
    **/
    @JSONField(name="platformname")
    private String platformname;

    /**
     *车辆接入卫星定位平台代码
    **/
    @JSONField(name="platformcode")
    private String platformcode;

    /**
     *排放标准
    **/
    @JSONField(name="standard")
    private String standard;

    /**
     *改装及附加置
    **/
    @JSONField(name="refit")
    private String refit;

    /**
     *最低耗油率
    **/
    @JSONField(name="lowfuelrate")
    private String lowfuelrate;

    /**
     *最大爬坡率
    **/
    @JSONField(name="maxclimbingrate")
    private String maxclimbingrate;

    /**
     *制动模式
    **/
    @JSONField(name="brakingmode")
    private String brakingmode;

    /**
     *制动距离
    **/
    @JSONField(name="brakingdistance")
    private String brakingdistance;

    /**
     *上传图片ID
    **/
    @JSONField(name="objid")
    private String objid;

    /**
     *管理档案号
    **/
    @JSONField(name="hnarcno")
    private String hnarcno;

    /**
     *轴型
    **/
    @JSONField(name="hnaxltype")
    private String hnaxltype;

    /**
     *卫星定位装置是否安装
    **/
    @JSONField(name="isgotosys")
    private String isgotosys;

    /**
     *初次注册日期
    **/
    @JSONField(name="firstdate")
    private String firstdate;

    /**
     *车辆备注信息
    **/
    @JSONField(name="vecremark")
    private String vecremark;

    @JSONField(name="vinnextdate")
    private String vinnextdate;

    /**
     *运输介质
    **/
    @JSONField(name="transporttype")
    private String transporttype;

    @JSONField(name="carnum")
    private String carnum;

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

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public Double getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(Double buyprice) {
        this.buyprice = buyprice;
    }

    public Double getBefwhetread() {
        return befwhetread;
    }

    public void setBefwhetread(Double befwhetread) {
        this.befwhetread = befwhetread;
    }

    public String getPrdfactory() {
        return prdfactory;
    }

    public void setPrdfactory(String prdfactory) {
        this.prdfactory = prdfactory;
    }

    public char getHavabs() {
        return havabs;
    }

    public void setHavabs(char havabs) {
        this.havabs = havabs;
    }

    public String getHydformat() {
        return hydformat;
    }

    public void setHydformat(String hydformat) {
        this.hydformat = hydformat;
    }

    public char getBeflapformat() {
        return beflapformat;
    }

    public void setBeflapformat(char beflapformat) {
        this.beflapformat = beflapformat;
    }

    public char getFuespoutformat() {
        return fuespoutformat;
    }

    public void setFuespoutformat(char fuespoutformat) {
        this.fuespoutformat = fuespoutformat;
    }

    public char getAftpdtformat() {
        return aftpdtformat;
    }

    public void setAftpdtformat(char aftpdtformat) {
        this.aftpdtformat = aftpdtformat;
    }

    public char getBefpdtformat() {
        return befpdtformat;
    }

    public void setBefpdtformat(char befpdtformat) {
        this.befpdtformat = befpdtformat;
    }

    public char getTsmformat() {
        return tsmformat;
    }

    public void setTsmformat(char tsmformat) {
        this.tsmformat = tsmformat;
    }

    public Double getWottraangle() {
        return wottraangle;
    }

    public void setWottraangle(Double wottraangle) {
        this.wottraangle = wottraangle;
    }

    public Double getWittraangle() {
        return wittraangle;
    }

    public void setWittraangle(Double wittraangle) {
        this.wittraangle = wittraangle;
    }

    public Double getMsthigspeed() {
        return msthigspeed;
    }

    public void setMsthigspeed(Double msthigspeed) {
        this.msthigspeed = msthigspeed;
    }

    public String getTyrstandard() {
        return tyrstandard;
    }

    public void setTyrstandard(String tyrstandard) {
        this.tyrstandard = tyrstandard;
    }

    public Double getChelodmass() {
        return chelodmass;
    }

    public void setChelodmass(Double chelodmass) {
        this.chelodmass = chelodmass;
    }

    public String getTurformat() {
        return turformat;
    }

    public void setTurformat(String turformat) {
        this.turformat = turformat;
    }

    public Double getEngtormomrotspeed() {
        return engtormomrotspeed;
    }

    public void setEngtormomrotspeed(Double engtormomrotspeed) {
        this.engtormomrotspeed = engtormomrotspeed;
    }

    public Double getEngtormoment() {
        return engtormoment;
    }

    public void setEngtormoment(Double engtormoment) {
        this.engtormoment = engtormoment;
    }

    public Double getRatrotspeed() {
        return ratrotspeed;
    }

    public void setRatrotspeed(Double ratrotspeed) {
        this.ratrotspeed = ratrotspeed;
    }

    public Double getEngdismoment() {
        return engdismoment;
    }

    public void setEngdismoment(Double engdismoment) {
        this.engdismoment = engdismoment;
    }

    public char getIsforeign() {
        return isforeign;
    }

    public void setIsforeign(char isforeign) {
        this.isforeign = isforeign;
    }

    public String getGotosysstat() {
        return gotosysstat;
    }

    public void setGotosysstat(String gotosysstat) {
        this.gotosysstat = gotosysstat;
    }

    public String getLogappstat() {
        return logappstat;
    }

    public void setLogappstat(String logappstat) {
        this.logappstat = logappstat;
    }

    public String getTracker() {
        return tracker;
    }

    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    public String getFacilitator() {
        return facilitator;
    }

    public void setFacilitator(String facilitator) {
        this.facilitator = facilitator;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }

    public String getCommtool() {
        return commtool;
    }

    public void setCommtool(String commtool) {
        this.commtool = commtool;
    }

    public char getIsinout() {
        return isinout;
    }

    public void setIsinout(char isinout) {
        this.isinout = isinout;
    }

    public Double getFulequip() {
        return fulequip;
    }

    public void setFulequip(Double fulequip) {
        this.fulequip = fulequip;
    }

    public Double getIseffect() {
        return iseffect;
    }

    public void setIseffect(Double iseffect) {
        this.iseffect = iseffect;
    }

    public String getBustype() {
        return bustype;
    }

    public void setBustype(String bustype) {
        this.bustype = bustype;
    }

    public Double getYears() {
        return years;
    }

    public void setYears(Double years) {
        this.years = years;
    }

    public String getVecbusstatus() {
        return vecbusstatus;
    }

    public void setVecbusstatus(String vecbusstatus) {
        this.vecbusstatus = vecbusstatus;
    }

    public Double getMilage() {
        return milage;
    }

    public void setMilage(Double milage) {
        this.milage = milage;
    }

    public String getDritype() {
        return dritype;
    }

    public void setDritype(String dritype) {
        this.dritype = dritype;
    }

    public Double getHunmiluseoil() {
        return hunmiluseoil;
    }

    public void setHunmiluseoil(Double hunmiluseoil) {
        this.hunmiluseoil = hunmiluseoil;
    }

    public String getEdiusrcode() {
        return ediusrcode;
    }

    public void setEdiusrcode(String ediusrcode) {
        this.ediusrcode = ediusrcode;
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

    public String getCreusrcode() {
        return creusrcode;
    }

    public void setCreusrcode(String creusrcode) {
        this.creusrcode = creusrcode;
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

    public String getArcsplace() {
        return arcsplace;
    }

    public void setArcsplace(String arcsplace) {
        this.arcsplace = arcsplace;
    }

    public Double getSprnum() {
        return sprnum;
    }

    public void setSprnum(Double sprnum) {
        this.sprnum = sprnum;
    }

    public Double getAxlnum() {
        return axlnum;
    }

    public void setAxlnum(Double axlnum) {
        this.axlnum = axlnum;
    }

    public Double getVecwide() {
        return vecwide;
    }

    public void setVecwide(Double vecwide) {
        this.vecwide = vecwide;
    }

    public Double getVechigh() {
        return vechigh;
    }

    public void setVechigh(Double vechigh) {
        this.vechigh = vechigh;
    }

    public Double getVeclength() {
        return veclength;
    }

    public void setVeclength(Double veclength) {
        this.veclength = veclength;
    }

    public Double getTyrenum() {
        return tyrenum;
    }

    public void setTyrenum(Double tyrenum) {
        this.tyrenum = tyrenum;
    }

    public Double getWhebase() {
        return whebase;
    }

    public void setWhebase(Double whebase) {
        this.whebase = whebase;
    }

    public Double getWhetread() {
        return whetread;
    }

    public void setWhetread(Double whetread) {
        this.whetread = whetread;
    }

    public String getSetdate() {
        return setdate;
    }

    public void setSetdate(String setdate) {
        this.setdate = setdate;
    }

    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }

    public String getProdate() {
        return prodate;
    }

    public void setProdate(String prodate) {
        this.prodate = prodate;
    }

    public String getSelvecshop() {
        return selvecshop;
    }

    public void setSelvecshop(String selvecshop) {
        this.selvecshop = selvecshop;
    }

    public Double getChepower() {
        return chepower;
    }

    public void setChepower(Double chepower) {
        this.chepower = chepower;
    }

    public Double getEngpower() {
        return engpower;
    }

    public void setEngpower(Double engpower) {
        this.engpower = engpower;
    }

    public String getEldtype() {
        return eldtype;
    }

    public void setEldtype(String eldtype) {
        this.eldtype = eldtype;
    }

    public String getFranum() {
        return franum;
    }

    public void setFranum(String franum) {
        this.franum = franum;
    }

    public String getEngnum() {
        return engnum;
    }

    public void setEngnum(String engnum) {
        this.engnum = engnum;
    }

    public String getEngtype() {
        return engtype;
    }

    public void setEngtype(String engtype) {
        this.engtype = engtype;
    }

    public String getVeccolor() {
        return veccolor;
    }

    public void setVeccolor(String veccolor) {
        this.veccolor = veccolor;
    }

    public String getVectype() {
        return vectype;
    }

    public void setVectype(String vectype) {
        this.vectype = vectype;
    }

    public String getVecentype() {
        return vecentype;
    }

    public void setVecentype(String vecentype) {
        this.vecentype = vecentype;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFactype() {
        return factype;
    }

    public void setFactype(String factype) {
        this.factype = factype;
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

    public String getVecaddr() {
        return vecaddr;
    }

    public void setVecaddr(String vecaddr) {
        this.vecaddr = vecaddr;
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

    public String getCurrentdatefricredocdate() {
        return currentdatefricredocdate;
    }

    public void setCurrentdatefricredocdate(String currentdatefricredocdate) {
        this.currentdatefricredocdate = currentdatefricredocdate;
    }

    public String getFuetype() {
        return fuetype;
    }

    public void setFuetype(String fuetype) {
        this.fuetype = fuetype;
    }

    public String getTotalmass() {
        return totalmass;
    }

    public void setTotalmass(String totalmass) {
        this.totalmass = totalmass;
    }

    public String getFuelcheckid() {
        return fuelcheckid;
    }

    public void setFuelcheckid(String fuelcheckid) {
        this.fuelcheckid = fuelcheckid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getCmvecunit() {
        return cmvecunit;
    }

    public void setCmvecunit(String cmvecunit) {
        this.cmvecunit = cmvecunit;
    }

    public String getChassistype() {
        return chassistype;
    }

    public void setChassistype(String chassistype) {
        this.chassistype = chassistype;
    }

    public Double getCheseats() {
        return cheseats;
    }

    public void setCheseats(Double cheseats) {
        this.cheseats = cheseats;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRegype() {
        return regype;
    }

    public void setRegype(String regype) {
        this.regype = regype;
    }

    public String getTechnicalnumber() {
        return technicalnumber;
    }

    public void setTechnicalnumber(String technicalnumber) {
        this.technicalnumber = technicalnumber;
    }

    public String getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(String registrationdate) {
        this.registrationdate = registrationdate;
    }

    public String getLssuingdate() {
        return lssuingdate;
    }

    public void setLssuingdate(String lssuingdate) {
        this.lssuingdate = lssuingdate;
    }

    public String getDrilicenddate() {
        return drilicenddate;
    }

    public void setDrilicenddate(String drilicenddate) {
        this.drilicenddate = drilicenddate;
    }

    public String getIscommtool() {
        return iscommtool;
    }

    public void setIscommtool(String iscommtool) {
        this.iscommtool = iscommtool;
    }

    public String getPlatformname() {
        return platformname;
    }

    public void setPlatformname(String platformname) {
        this.platformname = platformname;
    }

    public String getPlatformcode() {
        return platformcode;
    }

    public void setPlatformcode(String platformcode) {
        this.platformcode = platformcode;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getRefit() {
        return refit;
    }

    public void setRefit(String refit) {
        this.refit = refit;
    }

    public String getLowfuelrate() {
        return lowfuelrate;
    }

    public void setLowfuelrate(String lowfuelrate) {
        this.lowfuelrate = lowfuelrate;
    }

    public String getMaxclimbingrate() {
        return maxclimbingrate;
    }

    public void setMaxclimbingrate(String maxclimbingrate) {
        this.maxclimbingrate = maxclimbingrate;
    }

    public String getBrakingmode() {
        return brakingmode;
    }

    public void setBrakingmode(String brakingmode) {
        this.brakingmode = brakingmode;
    }

    public String getBrakingdistance() {
        return brakingdistance;
    }

    public void setBrakingdistance(String brakingdistance) {
        this.brakingdistance = brakingdistance;
    }

    public String getObjid() {
        return objid;
    }

    public void setObjid(String objid) {
        this.objid = objid;
    }

    public String getHnarcno() {
        return hnarcno;
    }

    public void setHnarcno(String hnarcno) {
        this.hnarcno = hnarcno;
    }

    public String getHnaxltype() {
        return hnaxltype;
    }

    public void setHnaxltype(String hnaxltype) {
        this.hnaxltype = hnaxltype;
    }

    public String getIsgotosys() {
        return isgotosys;
    }

    public void setIsgotosys(String isgotosys) {
        this.isgotosys = isgotosys;
    }

    public String getFirstdate() {
        return firstdate;
    }

    public void setFirstdate(String firstdate) {
        this.firstdate = firstdate;
    }

    public String getVecremark() {
        return vecremark;
    }

    public void setVecremark(String vecremark) {
        this.vecremark = vecremark;
    }

    public String getVinnextdate() {
        return vinnextdate;
    }

    public void setVinnextdate(String vinnextdate) {
        this.vinnextdate = vinnextdate;
    }

    public String getTransporttype() {
        return transporttype;
    }

    public void setTransporttype(String transporttype) {
        this.transporttype = transporttype;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}