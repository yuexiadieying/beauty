package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbscaseinfoDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *案件ID(主键)
    **/
    @JSONField(name="caseid")
    private String caseid;

    /**
     *所属机构
    **/
    @JSONField(name="organcode")
    private String organcode;

    /**
     *违章主体
    **/
    @JSONField(name="cheobject")
    private String cheobject;

    /**
     *执法单位id
    **/
    @JSONField(name="ieunitid")
    private String ieunitid;

    /**
     *执法队伍id
    **/
    @JSONField(name="lesectionid")
    private String lesectionid;

    /**
     *案件登记号
    **/
    @JSONField(name="applyid")
    private String applyid;

    /**
     *案件编号
    **/
    @JSONField(name="casenum")
    private String casenum;

    /**
     *违法行为
    **/
    @JSONField(name="casename")
    private String casename;

    /**
     *执法队伍
    **/
    @JSONField(name="lawlessaction")
    private String lawlessaction;

    /**
     *处罚内容
    **/
    @JSONField(name="punishcontent")
    private String punishcontent;

    /**
     *立案依据
    **/
    @JSONField(name="regitemname")
    private String regitemname;

    /**
     *处罚依据
    **/
    @JSONField(name="punitemname")
    private String punitemname;

    /**
     *违章日期
    **/
    @JSONField(name="pecdate")
    private String pecdate;

    /**
     *违章时间
    **/
    @JSONField(name="pectime")
    private String pectime;

    /**
     *违章地点
    **/
    @JSONField(name="prcsite")
    private String prcsite;

    /**
     *从业人员ID
    **/
    @JSONField(name="cmpsnid")
    private String cmpsnid;

    /**
     *当事人姓名
    **/
    @JSONField(name="psnname")
    private String psnname;

    /**
     *国籍
    **/
    @JSONField(name="country")
    private String country;

    /**
     *性别
    **/
    @JSONField(name="sex")
    private String sex;

    /**
     *年龄
    **/
    @JSONField(name="age")
    private Integer age;

    /**
     *民族
    **/
    @JSONField(name="nation")
    private String nation;

    /**
     *籍贯
    **/
    @JSONField(name="natplace")
    private String natplace;

    /**
     *工作单位
    **/
    @JSONField(name="jobdep")
    private String jobdep;

    /**
     *职务
    **/
    @JSONField(name="tecclass")
    private String tecclass;

    /**
     *当事人联系地址
    **/
    @JSONField(name="address")
    private String address;

    /**
     *联系电话
    **/
    @JSONField(name="psnphone")
    private String psnphone;

    /**
     *证件类型
    **/
    @JSONField(name="psnctctype")
    private String psnctctype;

    /**
     *证件号码
    **/
    @JSONField(name="psnctcno")
    private String psnctcno;

    /**
     *业户ID
    **/
    @JSONField(name="cmcltid")
    private String cmcltid;

    /**
     *业户名称
    **/
    @JSONField(name="cltname")
    private String cltname;

    /**
     *法人代表
    **/
    @JSONField(name="jurperson")
    private String jurperson;

    /**
     *业户地址
    **/
    @JSONField(name="cltadress")
    private String cltadress;

    /**
     *电话号码
    **/
    @JSONField(name="phone")
    private String phone;

    /**
     *经营许可证号
    **/
    @JSONField(name="pernum")
    private String pernum;

    /**
     *联系人
    **/
    @JSONField(name="conperson")
    private String conperson;

    /**
     *邮政编码
    **/
    @JSONField(name="maicoding")
    private String maicoding;

    /**
     *车辆ID
    **/
    @JSONField(name="cmvecid")
    private String cmvecid;

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
     *车辆型号
    **/
    @JSONField(name="vecmdltype")
    private String vecmdltype;

    /**
     *发动机号
    **/
    @JSONField(name="vecengno")
    private String vecengno;

    /**
     *车 架 号
    **/
    @JSONField(name="vecfanno")
    private String vecfanno;

    /**
     *车辆vin码
    **/
    @JSONField(name="vecvin")
    private String vecvin;

    /**
     *车 籍 地
    **/
    @JSONField(name="vecplace")
    private String vecplace;

    /**
     *强制措施决定书号
    **/
    @JSONField(name="detainno")
    private String detainno;

    /**
     *执法人员
    **/
    @JSONField(name="lawepsnone")
    private String lawepsnone;

    /**
     *执法证号
    **/
    @JSONField(name="lecardnoone")
    private String lecardnoone;

    /**
     *执法人员2
    **/
    @JSONField(name="lawepsntwo")
    private String lawepsntwo;

    /**
     *执法证号2
    **/
    @JSONField(name="lecardnotwo")
    private String lecardnotwo;

    /**
     *执法单位
    **/
    @JSONField(name="lawedep")
    private String lawedep;

    /**
     *登记人
    **/
    @JSONField(name="regpsn")
    private String regpsn;

    /**
     *登记日期
    **/
    @JSONField(name="regdate")
    private String regdate;

    /**
     *处罚金额
    **/
    @JSONField(name="decmoney")
    private Double decmoney;

    /**
     *执行金额(元)
    **/
    @JSONField(name="exemoney")
    private Double exemoney;

    /**
     *已缴金额(元)
    **/
    @JSONField(name="reamoney")
    private Double reamoney;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private Integer iseffect;

    /**
     *创建人
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
     *修改人
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
     *当事人本月累计处罚次数
    **/
    @JSONField(name="puncount")
    private String puncount;

    /**
     *案件状态
    **/
    @JSONField(name="iscon")
    private String iscon;

    /**
     *道路运输证号
    **/
    @JSONField(name="trano")
    private String trano;

    /**
     *车辆类型
    **/
    @JSONField(name="vectype")
    private String vectype;

    /**
     *法人证件号码
    **/
    @JSONField(name="ctcno")
    private String ctcno;

    /**
     *法人邮政编码
    **/
    @JSONField(name="mialcode")
    private String mialcode;

    /**
     *车轴数
    **/
    @JSONField(name="axlnum")
    private Integer axlnum;

    /**
     *车货总长
    **/
    @JSONField(name="vecfretotallenght")
    private Double vecfretotallenght;

    /**
     *车货总宽
    **/
    @JSONField(name="vecfretotalwidth")
    private Double vecfretotalwidth;

    /**
     *车货总高
    **/
    @JSONField(name="vecfretotalheight")
    private Double vecfretotalheight;

    /**
     *超长
    **/
    @JSONField(name="oversteplenght")
    private Double oversteplenght;

    /**
     *超宽
    **/
    @JSONField(name="overstepwidth")
    private Double overstepwidth;

    /**
     *超高
    **/
    @JSONField(name="overstepheight")
    private Double overstepheight;

    /**
     *车货总重
    **/
    @JSONField(name="vecfrgrossweight")
    private Double vecfrgrossweight;

    /**
     *超重
    **/
    @JSONField(name="oversteptonnage")
    private Double oversteptonnage;

    /**
     *核定吨(座)位
    **/
    @JSONField(name="chenum")
    private Double chenum;

    /**
     *货物名称
    **/
    @JSONField(name="freightname")
    private String freightname;

    /**
     *起运点
    **/
    @JSONField(name="sectionstart")
    private String sectionstart;

    /**
     *目的地
    **/
    @JSONField(name="destination")
    private String destination;

    /**
     *途经路线
    **/
    @JSONField(name="bywayofline")
    private String bywayofline;

    /**
     *已行驶公里数(km)
    **/
    @JSONField(name="runkilometre")
    private String runkilometre;

    /**
     *大写处罚金额
    **/
    @JSONField(name="capitalmoney")
    private String capitalmoney;

    /**
     *证据主要内容
    **/
    @JSONField(name="promaicomment")
    private String promaicomment;

    /**
     *车牌类型
    **/
    @JSONField(name="licetype")
    private String licetype;

    /**
     *案件类型
    **/
    @JSONField(name="casetype")
    private String casetype;

    /**
     *实际处罚金额
    **/
    @JSONField(name="deratemoney")
    private Double deratemoney;

    /**
     *是否减免
    **/
    @JSONField(name="isderate")
    private String isderate;

    @JSONField(name="applyderate")
    private String applyderate;

    /**
     *大写处罚金额3
    **/
    @JSONField(name="bigderatemoney")
    private String bigderatemoney;

    /**
     *案情内容
    **/
    @JSONField(name="punishcontenting")
    private String punishcontenting;

    /**
     *处罚依据2
    **/
    @JSONField(name="punitemnamebyend")
    private String punitemnamebyend;

    /**
     *处罚告知金额
    **/
    @JSONField(name="firstderatemoney")
    private Double firstderatemoney;

    @JSONField(name="appeal")
    private String appeal;

    /**
     *行为
    **/
    @JSONField(name="behavior")
    private String behavior;

    /**
     *超限率
    **/
    @JSONField(name="overrate")
    private String overrate;

    /**
     *文化程度
    **/
    @JSONField(name="education")
    private String education;

    /**
     *质量限值(吨)
    **/
    @JSONField(name="qualitynum")
    private Double qualitynum;

    /**
     *附加处罚
    **/
    @JSONField(name="otherpuns")
    private String otherpuns;

    /**
     *证据保存清单号
    **/
    @JSONField(name="evidenceno")
    private String evidenceno;

    @JSONField(name="hasforce")
    private char hasforce;

    /**
     *当事人是否在场
    **/
    @JSONField(name="partyonscene")
    private char partyonscene;

    /**
     *案件种类
    **/
    @JSONField(name="wfid")
    private String wfid;

    /**
     *案件当前环节
    **/
    @JSONField(name="curnode")
    private String curnode;

    /**
     *与案件关系
    **/
    @JSONField(name="relationscode")
    private char relationscode;

    /**
     *案件当前状态
    **/
    @JSONField(name="appperstatues")
    private String appperstatues;

    /**
     *审批案由
    **/
    @JSONField(name="appcasename")
    private String appcasename;

    /**
     *案件备注
    **/
    @JSONField(name="caseremark")
    private String caseremark;

    /**
     *案件来源
    **/
    @JSONField(name="casesource")
    private String casesource;

    /**
     *项目名称
    **/
    @JSONField(name="projectname")
    private String projectname;

    /**
     *时间戳
    **/
    @JSONField(name="sysopertime")
    private Double sysopertime;

    /**
     *内容模板ID
    **/
    @JSONField(name="templateid")
    private String templateid;

    /**
     *是否外省从业人员
    **/
    @JSONField(name="iscmpsn")
    private String iscmpsn;

    /**
     *是否经营业户
    **/
    @JSONField(name="iscltname")
    private char iscltname;

    /**
     *从业人员（驾驶员）ID
    **/
    @JSONField(name="oldcmpsnid")
    private String oldcmpsnid;

    /**
     *驾驶员姓名
    **/
    @JSONField(name="oldpsnname")
    private String oldpsnname;

    /**
     *驾驶员国籍
    **/
    @JSONField(name="oldcountry")
    private String oldcountry;

    /**
     *驾驶员性别
    **/
    @JSONField(name="oldsex")
    private String oldsex;

    /**
     *驾驶员年龄
    **/
    @JSONField(name="oldage")
    private Integer oldage;

    /**
     *驾驶员民族
    **/
    @JSONField(name="oldnation")
    private String oldnation;

    /**
     *驾驶员籍贯
    **/
    @JSONField(name="oldnatplace")
    private String oldnatplace;

    /**
     *驾驶员工作单位
    **/
    @JSONField(name="oldjobdep")
    private String oldjobdep;

    /**
     *驾驶员职务
    **/
    @JSONField(name="oldtecclass")
    private String oldtecclass;

    /**
     *驾驶员联系地址
    **/
    @JSONField(name="oldaddress")
    private String oldaddress;

    /**
     *驾驶员联系电话
    **/
    @JSONField(name="oldpsnphone")
    private String oldpsnphone;

    /**
     *驾驶员证件类型
    **/
    @JSONField(name="oldpsnctctype")
    private String oldpsnctctype;

    /**
     *驾驶员证件号码
    **/
    @JSONField(name="oldpsnctcno")
    private String oldpsnctcno;

    /**
     *驾驶员与案件关系
    **/
    @JSONField(name="oldrelationscode")
    private char oldrelationscode;

    /**
     *驾驶员是否外省从业人员
    **/
    @JSONField(name="oldiscmpsn")
    private String oldiscmpsn;

    /**
     *驾驶员邮政编码
    **/
    @JSONField(name="oldmaicoding")
    private String oldmaicoding;

    /**
     *是否取得从业资格证
    **/
    @JSONField(name="isacquirecert")
    private String isacquirecert;

    /**
     *驾驶员是否取得从业资格证
    **/
    @JSONField(name="oldisacquirecert")
    private String oldisacquirecert;

    @JSONField(name="oldiseffect")
    private Integer oldiseffect;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }

    public String getOrgancode() {
        return organcode;
    }

    public void setOrgancode(String organcode) {
        this.organcode = organcode;
    }

    public String getCheobject() {
        return cheobject;
    }

    public void setCheobject(String cheobject) {
        this.cheobject = cheobject;
    }

    public String getIeunitid() {
        return ieunitid;
    }

    public void setIeunitid(String ieunitid) {
        this.ieunitid = ieunitid;
    }

    public String getLesectionid() {
        return lesectionid;
    }

    public void setLesectionid(String lesectionid) {
        this.lesectionid = lesectionid;
    }

    public String getApplyid() {
        return applyid;
    }

    public void setApplyid(String applyid) {
        this.applyid = applyid;
    }

    public String getCasenum() {
        return casenum;
    }

    public void setCasenum(String casenum) {
        this.casenum = casenum;
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public String getLawlessaction() {
        return lawlessaction;
    }

    public void setLawlessaction(String lawlessaction) {
        this.lawlessaction = lawlessaction;
    }

    public String getPunishcontent() {
        return punishcontent;
    }

    public void setPunishcontent(String punishcontent) {
        this.punishcontent = punishcontent;
    }

    public String getRegitemname() {
        return regitemname;
    }

    public void setRegitemname(String regitemname) {
        this.regitemname = regitemname;
    }

    public String getPunitemname() {
        return punitemname;
    }

    public void setPunitemname(String punitemname) {
        this.punitemname = punitemname;
    }

    public String getPecdate() {
        return pecdate;
    }

    public void setPecdate(String pecdate) {
        this.pecdate = pecdate;
    }

    public String getPectime() {
        return pectime;
    }

    public void setPectime(String pectime) {
        this.pectime = pectime;
    }

    public String getPrcsite() {
        return prcsite;
    }

    public void setPrcsite(String prcsite) {
        this.prcsite = prcsite;
    }

    public String getCmpsnid() {
        return cmpsnid;
    }

    public void setCmpsnid(String cmpsnid) {
        this.cmpsnid = cmpsnid;
    }

    public String getPsnname() {
        return psnname;
    }

    public void setPsnname(String psnname) {
        this.psnname = psnname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNatplace() {
        return natplace;
    }

    public void setNatplace(String natplace) {
        this.natplace = natplace;
    }

    public String getJobdep() {
        return jobdep;
    }

    public void setJobdep(String jobdep) {
        this.jobdep = jobdep;
    }

    public String getTecclass() {
        return tecclass;
    }

    public void setTecclass(String tecclass) {
        this.tecclass = tecclass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPsnphone() {
        return psnphone;
    }

    public void setPsnphone(String psnphone) {
        this.psnphone = psnphone;
    }

    public String getPsnctctype() {
        return psnctctype;
    }

    public void setPsnctctype(String psnctctype) {
        this.psnctctype = psnctctype;
    }

    public String getPsnctcno() {
        return psnctcno;
    }

    public void setPsnctcno(String psnctcno) {
        this.psnctcno = psnctcno;
    }

    public String getCmcltid() {
        return cmcltid;
    }

    public void setCmcltid(String cmcltid) {
        this.cmcltid = cmcltid;
    }

    public String getCltname() {
        return cltname;
    }

    public void setCltname(String cltname) {
        this.cltname = cltname;
    }

    public String getJurperson() {
        return jurperson;
    }

    public void setJurperson(String jurperson) {
        this.jurperson = jurperson;
    }

    public String getCltadress() {
        return cltadress;
    }

    public void setCltadress(String cltadress) {
        this.cltadress = cltadress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPernum() {
        return pernum;
    }

    public void setPernum(String pernum) {
        this.pernum = pernum;
    }

    public String getConperson() {
        return conperson;
    }

    public void setConperson(String conperson) {
        this.conperson = conperson;
    }

    public String getMaicoding() {
        return maicoding;
    }

    public void setMaicoding(String maicoding) {
        this.maicoding = maicoding;
    }

    public String getCmvecid() {
        return cmvecid;
    }

    public void setCmvecid(String cmvecid) {
        this.cmvecid = cmvecid;
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

    public String getVecmdltype() {
        return vecmdltype;
    }

    public void setVecmdltype(String vecmdltype) {
        this.vecmdltype = vecmdltype;
    }

    public String getVecengno() {
        return vecengno;
    }

    public void setVecengno(String vecengno) {
        this.vecengno = vecengno;
    }

    public String getVecfanno() {
        return vecfanno;
    }

    public void setVecfanno(String vecfanno) {
        this.vecfanno = vecfanno;
    }

    public String getVecvin() {
        return vecvin;
    }

    public void setVecvin(String vecvin) {
        this.vecvin = vecvin;
    }

    public String getVecplace() {
        return vecplace;
    }

    public void setVecplace(String vecplace) {
        this.vecplace = vecplace;
    }

    public String getDetainno() {
        return detainno;
    }

    public void setDetainno(String detainno) {
        this.detainno = detainno;
    }

    public String getLawepsnone() {
        return lawepsnone;
    }

    public void setLawepsnone(String lawepsnone) {
        this.lawepsnone = lawepsnone;
    }

    public String getLecardnoone() {
        return lecardnoone;
    }

    public void setLecardnoone(String lecardnoone) {
        this.lecardnoone = lecardnoone;
    }

    public String getLawepsntwo() {
        return lawepsntwo;
    }

    public void setLawepsntwo(String lawepsntwo) {
        this.lawepsntwo = lawepsntwo;
    }

    public String getLecardnotwo() {
        return lecardnotwo;
    }

    public void setLecardnotwo(String lecardnotwo) {
        this.lecardnotwo = lecardnotwo;
    }

    public String getLawedep() {
        return lawedep;
    }

    public void setLawedep(String lawedep) {
        this.lawedep = lawedep;
    }

    public String getRegpsn() {
        return regpsn;
    }

    public void setRegpsn(String regpsn) {
        this.regpsn = regpsn;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public Double getDecmoney() {
        return decmoney;
    }

    public void setDecmoney(Double decmoney) {
        this.decmoney = decmoney;
    }

    public Double getExemoney() {
        return exemoney;
    }

    public void setExemoney(Double exemoney) {
        this.exemoney = exemoney;
    }

    public Double getReamoney() {
        return reamoney;
    }

    public void setReamoney(Double reamoney) {
        this.reamoney = reamoney;
    }

    public Integer getIseffect() {
        return iseffect;
    }

    public void setIseffect(Integer iseffect) {
        this.iseffect = iseffect;
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

    public String getPuncount() {
        return puncount;
    }

    public void setPuncount(String puncount) {
        this.puncount = puncount;
    }

    public String getIscon() {
        return iscon;
    }

    public void setIscon(String iscon) {
        this.iscon = iscon;
    }

    public String getTrano() {
        return trano;
    }

    public void setTrano(String trano) {
        this.trano = trano;
    }

    public String getVectype() {
        return vectype;
    }

    public void setVectype(String vectype) {
        this.vectype = vectype;
    }

    public String getCtcno() {
        return ctcno;
    }

    public void setCtcno(String ctcno) {
        this.ctcno = ctcno;
    }

    public String getMialcode() {
        return mialcode;
    }

    public void setMialcode(String mialcode) {
        this.mialcode = mialcode;
    }

    public Integer getAxlnum() {
        return axlnum;
    }

    public void setAxlnum(Integer axlnum) {
        this.axlnum = axlnum;
    }

    public Double getVecfretotallenght() {
        return vecfretotallenght;
    }

    public void setVecfretotallenght(Double vecfretotallenght) {
        this.vecfretotallenght = vecfretotallenght;
    }

    public Double getVecfretotalwidth() {
        return vecfretotalwidth;
    }

    public void setVecfretotalwidth(Double vecfretotalwidth) {
        this.vecfretotalwidth = vecfretotalwidth;
    }

    public Double getVecfretotalheight() {
        return vecfretotalheight;
    }

    public void setVecfretotalheight(Double vecfretotalheight) {
        this.vecfretotalheight = vecfretotalheight;
    }

    public Double getOversteplenght() {
        return oversteplenght;
    }

    public void setOversteplenght(Double oversteplenght) {
        this.oversteplenght = oversteplenght;
    }

    public Double getOverstepwidth() {
        return overstepwidth;
    }

    public void setOverstepwidth(Double overstepwidth) {
        this.overstepwidth = overstepwidth;
    }

    public Double getOverstepheight() {
        return overstepheight;
    }

    public void setOverstepheight(Double overstepheight) {
        this.overstepheight = overstepheight;
    }

    public Double getVecfrgrossweight() {
        return vecfrgrossweight;
    }

    public void setVecfrgrossweight(Double vecfrgrossweight) {
        this.vecfrgrossweight = vecfrgrossweight;
    }

    public Double getOversteptonnage() {
        return oversteptonnage;
    }

    public void setOversteptonnage(Double oversteptonnage) {
        this.oversteptonnage = oversteptonnage;
    }

    public Double getChenum() {
        return chenum;
    }

    public void setChenum(Double chenum) {
        this.chenum = chenum;
    }

    public String getFreightname() {
        return freightname;
    }

    public void setFreightname(String freightname) {
        this.freightname = freightname;
    }

    public String getSectionstart() {
        return sectionstart;
    }

    public void setSectionstart(String sectionstart) {
        this.sectionstart = sectionstart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBywayofline() {
        return bywayofline;
    }

    public void setBywayofline(String bywayofline) {
        this.bywayofline = bywayofline;
    }

    public String getRunkilometre() {
        return runkilometre;
    }

    public void setRunkilometre(String runkilometre) {
        this.runkilometre = runkilometre;
    }

    public String getCapitalmoney() {
        return capitalmoney;
    }

    public void setCapitalmoney(String capitalmoney) {
        this.capitalmoney = capitalmoney;
    }

    public String getPromaicomment() {
        return promaicomment;
    }

    public void setPromaicomment(String promaicomment) {
        this.promaicomment = promaicomment;
    }

    public String getLicetype() {
        return licetype;
    }

    public void setLicetype(String licetype) {
        this.licetype = licetype;
    }

    public String getCasetype() {
        return casetype;
    }

    public void setCasetype(String casetype) {
        this.casetype = casetype;
    }

    public Double getDeratemoney() {
        return deratemoney;
    }

    public void setDeratemoney(Double deratemoney) {
        this.deratemoney = deratemoney;
    }

    public String getIsderate() {
        return isderate;
    }

    public void setIsderate(String isderate) {
        this.isderate = isderate;
    }

    public String getApplyderate() {
        return applyderate;
    }

    public void setApplyderate(String applyderate) {
        this.applyderate = applyderate;
    }

    public String getBigderatemoney() {
        return bigderatemoney;
    }

    public void setBigderatemoney(String bigderatemoney) {
        this.bigderatemoney = bigderatemoney;
    }

    public String getPunishcontenting() {
        return punishcontenting;
    }

    public void setPunishcontenting(String punishcontenting) {
        this.punishcontenting = punishcontenting;
    }

    public String getPunitemnamebyend() {
        return punitemnamebyend;
    }

    public void setPunitemnamebyend(String punitemnamebyend) {
        this.punitemnamebyend = punitemnamebyend;
    }

    public Double getFirstderatemoney() {
        return firstderatemoney;
    }

    public void setFirstderatemoney(Double firstderatemoney) {
        this.firstderatemoney = firstderatemoney;
    }

    public String getAppeal() {
        return appeal;
    }

    public void setAppeal(String appeal) {
        this.appeal = appeal;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getOverrate() {
        return overrate;
    }

    public void setOverrate(String overrate) {
        this.overrate = overrate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Double getQualitynum() {
        return qualitynum;
    }

    public void setQualitynum(Double qualitynum) {
        this.qualitynum = qualitynum;
    }

    public String getOtherpuns() {
        return otherpuns;
    }

    public void setOtherpuns(String otherpuns) {
        this.otherpuns = otherpuns;
    }

    public String getEvidenceno() {
        return evidenceno;
    }

    public void setEvidenceno(String evidenceno) {
        this.evidenceno = evidenceno;
    }

    public char getHasforce() {
        return hasforce;
    }

    public void setHasforce(char hasforce) {
        this.hasforce = hasforce;
    }

    public char getPartyonscene() {
        return partyonscene;
    }

    public void setPartyonscene(char partyonscene) {
        this.partyonscene = partyonscene;
    }

    public String getWfid() {
        return wfid;
    }

    public void setWfid(String wfid) {
        this.wfid = wfid;
    }

    public String getCurnode() {
        return curnode;
    }

    public void setCurnode(String curnode) {
        this.curnode = curnode;
    }

    public char getRelationscode() {
        return relationscode;
    }

    public void setRelationscode(char relationscode) {
        this.relationscode = relationscode;
    }

    public String getAppperstatues() {
        return appperstatues;
    }

    public void setAppperstatues(String appperstatues) {
        this.appperstatues = appperstatues;
    }

    public String getAppcasename() {
        return appcasename;
    }

    public void setAppcasename(String appcasename) {
        this.appcasename = appcasename;
    }

    public String getCaseremark() {
        return caseremark;
    }

    public void setCaseremark(String caseremark) {
        this.caseremark = caseremark;
    }

    public String getCasesource() {
        return casesource;
    }

    public void setCasesource(String casesource) {
        this.casesource = casesource;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public Double getSysopertime() {
        return sysopertime;
    }

    public void setSysopertime(Double sysopertime) {
        this.sysopertime = sysopertime;
    }

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }

    public String getIscmpsn() {
        return iscmpsn;
    }

    public void setIscmpsn(String iscmpsn) {
        this.iscmpsn = iscmpsn;
    }

    public char getIscltname() {
        return iscltname;
    }

    public void setIscltname(char iscltname) {
        this.iscltname = iscltname;
    }

    public String getOldcmpsnid() {
        return oldcmpsnid;
    }

    public void setOldcmpsnid(String oldcmpsnid) {
        this.oldcmpsnid = oldcmpsnid;
    }

    public String getOldpsnname() {
        return oldpsnname;
    }

    public void setOldpsnname(String oldpsnname) {
        this.oldpsnname = oldpsnname;
    }

    public String getOldcountry() {
        return oldcountry;
    }

    public void setOldcountry(String oldcountry) {
        this.oldcountry = oldcountry;
    }

    public String getOldsex() {
        return oldsex;
    }

    public void setOldsex(String oldsex) {
        this.oldsex = oldsex;
    }

    public Integer getOldage() {
        return oldage;
    }

    public void setOldage(Integer oldage) {
        this.oldage = oldage;
    }

    public String getOldnation() {
        return oldnation;
    }

    public void setOldnation(String oldnation) {
        this.oldnation = oldnation;
    }

    public String getOldnatplace() {
        return oldnatplace;
    }

    public void setOldnatplace(String oldnatplace) {
        this.oldnatplace = oldnatplace;
    }

    public String getOldjobdep() {
        return oldjobdep;
    }

    public void setOldjobdep(String oldjobdep) {
        this.oldjobdep = oldjobdep;
    }

    public String getOldtecclass() {
        return oldtecclass;
    }

    public void setOldtecclass(String oldtecclass) {
        this.oldtecclass = oldtecclass;
    }

    public String getOldaddress() {
        return oldaddress;
    }

    public void setOldaddress(String oldaddress) {
        this.oldaddress = oldaddress;
    }

    public String getOldpsnphone() {
        return oldpsnphone;
    }

    public void setOldpsnphone(String oldpsnphone) {
        this.oldpsnphone = oldpsnphone;
    }

    public String getOldpsnctctype() {
        return oldpsnctctype;
    }

    public void setOldpsnctctype(String oldpsnctctype) {
        this.oldpsnctctype = oldpsnctctype;
    }

    public String getOldpsnctcno() {
        return oldpsnctcno;
    }

    public void setOldpsnctcno(String oldpsnctcno) {
        this.oldpsnctcno = oldpsnctcno;
    }

    public char getOldrelationscode() {
        return oldrelationscode;
    }

    public void setOldrelationscode(char oldrelationscode) {
        this.oldrelationscode = oldrelationscode;
    }

    public String getOldiscmpsn() {
        return oldiscmpsn;
    }

    public void setOldiscmpsn(String oldiscmpsn) {
        this.oldiscmpsn = oldiscmpsn;
    }

    public String getOldmaicoding() {
        return oldmaicoding;
    }

    public void setOldmaicoding(String oldmaicoding) {
        this.oldmaicoding = oldmaicoding;
    }

    public String getIsacquirecert() {
        return isacquirecert;
    }

    public void setIsacquirecert(String isacquirecert) {
        this.isacquirecert = isacquirecert;
    }

    public String getOldisacquirecert() {
        return oldisacquirecert;
    }

    public void setOldisacquirecert(String oldisacquirecert) {
        this.oldisacquirecert = oldisacquirecert;
    }

    public Integer getOldiseffect() {
        return oldiseffect;
    }

    public void setOldiseffect(Integer oldiseffect) {
        this.oldiseffect = oldiseffect;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}