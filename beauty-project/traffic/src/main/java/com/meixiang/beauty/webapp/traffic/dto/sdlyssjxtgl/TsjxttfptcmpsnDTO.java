package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfptcmpsnDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *从业人员id
    **/
    @JSONField(name="cmpsnid")
    private String cmpsnid;

    /**
     *姓名
    **/
    @JSONField(name="name")
    private String name;

    /**
     *性别
    **/
    @JSONField(name="sex")
    private char sex;

    /**
     *出生日期
    **/
    @JSONField(name="birthday")
    private String birthday;

    /**
     *身份证号
    **/
    @JSONField(name="cardno")
    private String cardno;

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
     *联系电话
    **/
    @JSONField(name="phone")
    private String phone;

    /**
     *联系地址
    **/
    @JSONField(name="address")
    private String address;

    /**
     *邮箱
    **/
    @JSONField(name="email")
    private String email;

    /**
     *邮件编码
    **/
    @JSONField(name="maicoding")
    private String maicoding;

    /**
     *文化程度
    **/
    @JSONField(name="education")
    private String education;

    /**
     *技术职称
    **/
    @JSONField(name="tecclass")
    private String tecclass;

    /**
     *健康状况
    **/
    @JSONField(name="health")
    private String health;

    /**
     *创建人员编号
    **/
    @JSONField(name="creusrcode")
    private String creusrcode;

    /**
     *创建人员日期
    **/
    @JSONField(name="credate")
    private String credate;

    /**
     *创建人员时间
    **/
    @JSONField(name="cretime")
    private String cretime;

    /**
     *修改人员编号
    **/
    @JSONField(name="ediusrcode")
    private String ediusrcode;

    /**
     *修改人员日期
    **/
    @JSONField(name="edidate")
    private String edidate;

    /**
     *修改人员时间
    **/
    @JSONField(name="editime")
    private String editime;

    /**
     *业户编号
    **/
    @JSONField(name="cmcltid")
    private String cmcltid;

    /**
     *从业状态
    **/
    @JSONField(name="worstatus")
    private String worstatus;

    /**
     *培训次数
    **/
    @JSONField(name="stutimes")
    private Integer stutimes;

    /**
     *理论成绩
    **/
    @JSONField(name="df1")
    private String df1;

    /**
     *专业知识应用能力成绩
    **/
    @JSONField(name="df2")
    private String df2;

    @JSONField(name="df3")
    private String df3;

    @JSONField(name="df4")
    private String df4;

    @JSONField(name="df5")
    private String df5;

    @JSONField(name="df6")
    private String df6;

    /**
     *实体类型
    **/
    @JSONField(name="entype")
    private Integer entype;

    /**
     *状态
    **/
    @JSONField(name="status")
    private String status;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private Integer iseffect;

    /**
     *出租车培训
    **/
    @JSONField(name="taxlesson")
    private char taxlesson;

    /**
     *政治面貌
    **/
    @JSONField(name="politicsface")
    private String politicsface;

    @JSONField(name="inicmcltid")
    private String inicmcltid;

    /**
     *业户名称
    **/
    @JSONField(name="clitname")
    private String clitname;

    /**
     *备注
    **/
    @JSONField(name="markdoc")
    private String markdoc;

    /**
     *时间戳
    **/
    @JSONField(name="sysopertime")
    private Double sysopertime;

    /**
     *已经考取的旅客或货物运输从业资格证号
    **/
    @JSONField(name="lhtitno")
    private String lhtitno;

    /**
     *旅客或货物运输从业资格证初领时间
    **/
    @JSONField(name="lhstadate")
    private String lhstadate;

    @JSONField(name="managetime1")
    private String managetime1;

    @JSONField(name="managetime2")
    private String managetime2;

    /**
     *锁定状态
    **/
    @JSONField(name="tmstatus")
    private String tmstatus;

    /**
     *培训时间
    **/
    @JSONField(name="meettraindate")
    private String meettraindate;

    /**
     *是否参加应急培训
    **/
    @JSONField(name="ismeettrain")
    private char ismeettrain;

    /**
     *培训期号
    **/
    @JSONField(name="trainperoid")
    private String trainperoid;

    /**
     *是否在不适岗名单内
    **/
    @JSONField(name="innotpostlist")
    private char innotpostlist;

    /**
     *是否首次包车
    **/
    @JSONField(name="isfirstcharter")
    private char isfirstcharter;

    /**
     *聘用时间
    **/
    @JSONField(name="bingdate")
    private String bingdate;

    @JSONField(name="bclock")
    private String bclock;

    /**
     *建档机构
    **/
    @JSONField(name="docdepcode")
    private String docdepcode;

    /**
     *办理人
    **/
    @JSONField(name="cheusername")
    private String cheusername;

    /**
     *驾驶证初领日期
    **/
    @JSONField(name="dristadate")
    private String dristadate;

    /**
     *驾驶证号
    **/
    @JSONField(name="dricardno")
    private String dricardno;

    /**
     *委托机构
    **/
    @JSONField(name="managerdepcode")
    private String managerdepcode;

    /**
     *锁定前从业状态
    **/
    @JSONField(name="worstatusbflocked")
    private String worstatusbflocked;

    /**
     *准驾车型
    **/
    @JSONField(name="perdritype")
    private String perdritype;

    /**
     *国籍
    **/
    @JSONField(name="country")
    private String country;

    /**
     *备案类型
    **/
    @JSONField(name="recordtype")
    private char recordtype;

    /**
     *驾证有效期起
    **/
    @JSONField(name="drigradate")
    private String drigradate;

    /**
     *驾证有效期止
    **/
    @JSONField(name="drienddate")
    private String drienddate;

    /**
     *补换证次数
    **/
    @JSONField(name="tratimes")
    private Integer tratimes;

    /**
     *身份证地址
    **/
    @JSONField(name="idcardaddress")
    private String idcardaddress;

    /**
     *备案日期
    **/
    @JSONField(name="joindate")
    private String joindate;

    /**
     *工作
    **/
    @JSONField(name="job")
    private String job;

    @JSONField(name="servicearea")
    private String servicearea;

    /**
     *运管机构意见
    **/
    @JSONField(name="remarkdoc")
    private String remarkdoc;

    /**
     *档案号
    **/
    @JSONField(name="docno")
    private String docno;

    /**
     *上传照片路径
    **/
    @JSONField(name="objid")
    private String objid;

    /**
     *发证机关
    **/
    @JSONField(name="liauthority")
    private String liauthority;

    /**
     *行政区划对应地址
    **/
    @JSONField(name="cancodeaddress")
    private String cancodeaddress;

    /**
     *省（代码）
    **/
    @JSONField(name="cancodeaddress1")
    private String cancodeaddress1;

    /**
     *市（代码）
    **/
    @JSONField(name="cancodeaddress2")
    private String cancodeaddress2;

    /**
     *区（代码）
    **/
    @JSONField(name="cancodeaddress3")
    private String cancodeaddress3;

    /**
     *证件类型
    **/
    @JSONField(name="documenttype")
    private String documenttype;

    /**
     *办理机构CODE
    **/
    @JSONField(name="chedepcode")
    private String chedepcode;

    /**
     *办理人
    **/
    @JSONField(name="cheusrname")
    private String cheusrname;

    /**
     *办理时间
    **/
    @JSONField(name="cheusrdate")
    private String cheusrdate;

    /**
     *身份证地址
    **/
    @JSONField(name="cardnoaddress")
    private String cardnoaddress;

    /**
     *身份证省（代码）
    **/
    @JSONField(name="cardnoaddress1")
    private String cardnoaddress1;

    /**
     *身份证市（代码）
    **/
    @JSONField(name="cardnoaddress2")
    private String cardnoaddress2;

    /**
     *身份证区（代码）
    **/
    @JSONField(name="cardnoaddress3")
    private String cardnoaddress3;

    /**
     *注册有效期起
    **/
    @JSONField(name="regstartdate")
    private String regstartdate;

    /**
     *注册有效期止
    **/
    @JSONField(name="regenddate")
    private String regenddate;

    @JSONField(name="isexaminer")
    private String isexaminer;

    @JSONField(name="issecurityguard")
    private String issecurityguard;

    /**
     *临时解锁 0 正常  1 临时解锁 2 临时解锁锁定
    **/
    @JSONField(name="templock")
    private String templock;

    @JSONField(name="coachnum")
    private String coachnum;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getCmpsnid() {
        return cmpsnid;
    }

    public void setCmpsnid(String cmpsnid) {
        this.cmpsnid = cmpsnid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaicoding() {
        return maicoding;
    }

    public void setMaicoding(String maicoding) {
        this.maicoding = maicoding;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTecclass() {
        return tecclass;
    }

    public void setTecclass(String tecclass) {
        this.tecclass = tecclass;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
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

    public String getCmcltid() {
        return cmcltid;
    }

    public void setCmcltid(String cmcltid) {
        this.cmcltid = cmcltid;
    }

    public String getWorstatus() {
        return worstatus;
    }

    public void setWorstatus(String worstatus) {
        this.worstatus = worstatus;
    }

    public Integer getStutimes() {
        return stutimes;
    }

    public void setStutimes(Integer stutimes) {
        this.stutimes = stutimes;
    }

    public String getDf1() {
        return df1;
    }

    public void setDf1(String df1) {
        this.df1 = df1;
    }

    public String getDf2() {
        return df2;
    }

    public void setDf2(String df2) {
        this.df2 = df2;
    }

    public String getDf3() {
        return df3;
    }

    public void setDf3(String df3) {
        this.df3 = df3;
    }

    public String getDf4() {
        return df4;
    }

    public void setDf4(String df4) {
        this.df4 = df4;
    }

    public String getDf5() {
        return df5;
    }

    public void setDf5(String df5) {
        this.df5 = df5;
    }

    public String getDf6() {
        return df6;
    }

    public void setDf6(String df6) {
        this.df6 = df6;
    }

    public Integer getEntype() {
        return entype;
    }

    public void setEntype(Integer entype) {
        this.entype = entype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIseffect() {
        return iseffect;
    }

    public void setIseffect(Integer iseffect) {
        this.iseffect = iseffect;
    }

    public char getTaxlesson() {
        return taxlesson;
    }

    public void setTaxlesson(char taxlesson) {
        this.taxlesson = taxlesson;
    }

    public String getPoliticsface() {
        return politicsface;
    }

    public void setPoliticsface(String politicsface) {
        this.politicsface = politicsface;
    }

    public String getInicmcltid() {
        return inicmcltid;
    }

    public void setInicmcltid(String inicmcltid) {
        this.inicmcltid = inicmcltid;
    }

    public String getClitname() {
        return clitname;
    }

    public void setClitname(String clitname) {
        this.clitname = clitname;
    }

    public String getMarkdoc() {
        return markdoc;
    }

    public void setMarkdoc(String markdoc) {
        this.markdoc = markdoc;
    }

    public Double getSysopertime() {
        return sysopertime;
    }

    public void setSysopertime(Double sysopertime) {
        this.sysopertime = sysopertime;
    }

    public String getLhtitno() {
        return lhtitno;
    }

    public void setLhtitno(String lhtitno) {
        this.lhtitno = lhtitno;
    }

    public String getLhstadate() {
        return lhstadate;
    }

    public void setLhstadate(String lhstadate) {
        this.lhstadate = lhstadate;
    }

    public String getManagetime1() {
        return managetime1;
    }

    public void setManagetime1(String managetime1) {
        this.managetime1 = managetime1;
    }

    public String getManagetime2() {
        return managetime2;
    }

    public void setManagetime2(String managetime2) {
        this.managetime2 = managetime2;
    }

    public String getTmstatus() {
        return tmstatus;
    }

    public void setTmstatus(String tmstatus) {
        this.tmstatus = tmstatus;
    }

    public String getMeettraindate() {
        return meettraindate;
    }

    public void setMeettraindate(String meettraindate) {
        this.meettraindate = meettraindate;
    }

    public char getIsmeettrain() {
        return ismeettrain;
    }

    public void setIsmeettrain(char ismeettrain) {
        this.ismeettrain = ismeettrain;
    }

    public String getTrainperoid() {
        return trainperoid;
    }

    public void setTrainperoid(String trainperoid) {
        this.trainperoid = trainperoid;
    }

    public char getInnotpostlist() {
        return innotpostlist;
    }

    public void setInnotpostlist(char innotpostlist) {
        this.innotpostlist = innotpostlist;
    }

    public char getIsfirstcharter() {
        return isfirstcharter;
    }

    public void setIsfirstcharter(char isfirstcharter) {
        this.isfirstcharter = isfirstcharter;
    }

    public String getBingdate() {
        return bingdate;
    }

    public void setBingdate(String bingdate) {
        this.bingdate = bingdate;
    }

    public String getBclock() {
        return bclock;
    }

    public void setBclock(String bclock) {
        this.bclock = bclock;
    }

    public String getDocdepcode() {
        return docdepcode;
    }

    public void setDocdepcode(String docdepcode) {
        this.docdepcode = docdepcode;
    }

    public String getCheusername() {
        return cheusername;
    }

    public void setCheusername(String cheusername) {
        this.cheusername = cheusername;
    }

    public String getDristadate() {
        return dristadate;
    }

    public void setDristadate(String dristadate) {
        this.dristadate = dristadate;
    }

    public String getDricardno() {
        return dricardno;
    }

    public void setDricardno(String dricardno) {
        this.dricardno = dricardno;
    }

    public String getManagerdepcode() {
        return managerdepcode;
    }

    public void setManagerdepcode(String managerdepcode) {
        this.managerdepcode = managerdepcode;
    }

    public String getWorstatusbflocked() {
        return worstatusbflocked;
    }

    public void setWorstatusbflocked(String worstatusbflocked) {
        this.worstatusbflocked = worstatusbflocked;
    }

    public String getPerdritype() {
        return perdritype;
    }

    public void setPerdritype(String perdritype) {
        this.perdritype = perdritype;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public char getRecordtype() {
        return recordtype;
    }

    public void setRecordtype(char recordtype) {
        this.recordtype = recordtype;
    }

    public String getDrigradate() {
        return drigradate;
    }

    public void setDrigradate(String drigradate) {
        this.drigradate = drigradate;
    }

    public String getDrienddate() {
        return drienddate;
    }

    public void setDrienddate(String drienddate) {
        this.drienddate = drienddate;
    }

    public Integer getTratimes() {
        return tratimes;
    }

    public void setTratimes(Integer tratimes) {
        this.tratimes = tratimes;
    }

    public String getIdcardaddress() {
        return idcardaddress;
    }

    public void setIdcardaddress(String idcardaddress) {
        this.idcardaddress = idcardaddress;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getServicearea() {
        return servicearea;
    }

    public void setServicearea(String servicearea) {
        this.servicearea = servicearea;
    }

    public String getRemarkdoc() {
        return remarkdoc;
    }

    public void setRemarkdoc(String remarkdoc) {
        this.remarkdoc = remarkdoc;
    }

    public String getDocno() {
        return docno;
    }

    public void setDocno(String docno) {
        this.docno = docno;
    }

    public String getObjid() {
        return objid;
    }

    public void setObjid(String objid) {
        this.objid = objid;
    }

    public String getLiauthority() {
        return liauthority;
    }

    public void setLiauthority(String liauthority) {
        this.liauthority = liauthority;
    }

    public String getCancodeaddress() {
        return cancodeaddress;
    }

    public void setCancodeaddress(String cancodeaddress) {
        this.cancodeaddress = cancodeaddress;
    }

    public String getCancodeaddress1() {
        return cancodeaddress1;
    }

    public void setCancodeaddress1(String cancodeaddress1) {
        this.cancodeaddress1 = cancodeaddress1;
    }

    public String getCancodeaddress2() {
        return cancodeaddress2;
    }

    public void setCancodeaddress2(String cancodeaddress2) {
        this.cancodeaddress2 = cancodeaddress2;
    }

    public String getCancodeaddress3() {
        return cancodeaddress3;
    }

    public void setCancodeaddress3(String cancodeaddress3) {
        this.cancodeaddress3 = cancodeaddress3;
    }

    public String getDocumenttype() {
        return documenttype;
    }

    public void setDocumenttype(String documenttype) {
        this.documenttype = documenttype;
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

    public String getCardnoaddress() {
        return cardnoaddress;
    }

    public void setCardnoaddress(String cardnoaddress) {
        this.cardnoaddress = cardnoaddress;
    }

    public String getCardnoaddress1() {
        return cardnoaddress1;
    }

    public void setCardnoaddress1(String cardnoaddress1) {
        this.cardnoaddress1 = cardnoaddress1;
    }

    public String getCardnoaddress2() {
        return cardnoaddress2;
    }

    public void setCardnoaddress2(String cardnoaddress2) {
        this.cardnoaddress2 = cardnoaddress2;
    }

    public String getCardnoaddress3() {
        return cardnoaddress3;
    }

    public void setCardnoaddress3(String cardnoaddress3) {
        this.cardnoaddress3 = cardnoaddress3;
    }

    public String getRegstartdate() {
        return regstartdate;
    }

    public void setRegstartdate(String regstartdate) {
        this.regstartdate = regstartdate;
    }

    public String getRegenddate() {
        return regenddate;
    }

    public void setRegenddate(String regenddate) {
        this.regenddate = regenddate;
    }

    public String getIsexaminer() {
        return isexaminer;
    }

    public void setIsexaminer(String isexaminer) {
        this.isexaminer = isexaminer;
    }

    public String getIssecurityguard() {
        return issecurityguard;
    }

    public void setIssecurityguard(String issecurityguard) {
        this.issecurityguard = issecurityguard;
    }

    public String getTemplock() {
        return templock;
    }

    public void setTemplock(String templock) {
        this.templock = templock;
    }

    public String getCoachnum() {
        return coachnum;
    }

    public void setCoachnum(String coachnum) {
        this.coachnum = coachnum;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}