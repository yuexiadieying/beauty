package com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TsjxttfbsenbeworrecordDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *从业资格证编号
    **/
    @JSONField(name="enbeworrecordid")
    private String enbeworrecordid;

    /**
     *人员编号
    **/
    @JSONField(name="cmpsnid")
    private String cmpsnid;

    /**
     *从业资格类别
    **/
    @JSONField(name="wortype")
    private String wortype;

    /**
     *从业资格证号
    **/
    @JSONField(name="titno")
    private String titno;

    /**
     *证件初领时间
    **/
    @JSONField(name="startdate")
    private char startdate;

    /**
     *从业资格证有效期始
    **/
    @JSONField(name="gradate")
    private char gradate;

    /**
     *证件有效期止
    **/
    @JSONField(name="enddate")
    private char enddate;

    /**
     *证照状态
    **/
    @JSONField(name="licstatus")
    private String licstatus;

    /**
     *发证机关
    **/
    @JSONField(name="org")
    private String org;

    /**
     *补换证次数
    **/
    @JSONField(name="tratimes")
    private Double tratimes;

    /**
     *资格等级
    **/
    @JSONField(name="beworlevel")
    private String beworlevel;

    /**
     *全国流水号
    **/
    @JSONField(name="areaserial")
    private String areaserial;

    /**
     *档案号
    **/
    @JSONField(name="docno")
    private String docno;

    @JSONField(name="depcode")
    private String depcode;

    /**
     *考生区域
    **/
    @JSONField(name="examineearea")
    private char examineearea;

    /**
     *从业资格范围
    **/
    @JSONField(name="beworscope")
    private String beworscope;

    /**
     *从业附属资格范围
    **/
    @JSONField(name="appixscope")
    private String appixscope;

    /**
     *驾驶证号
    **/
    @JSONField(name="dricardno")
    private String dricardno;

    /**
     *准驾车型
    **/
    @JSONField(name="perdritype")
    private String perdritype;

    /**
     *驾驶证初领时间
    **/
    @JSONField(name="dristadate")
    private String dristadate;

    /**
     *维修已获得专业技术证书说明
    **/
    @JSONField(name="teccomment")
    private String teccomment;

    /**
     *维修专业技术等级
    **/
    @JSONField(name="tecgrade")
    private String tecgrade;

    /**
     *维修是否技术负责人
    **/
    @JSONField(name="isprincipal")
    private String isprincipal;

    /**
     *教练员准教车型
    **/
    @JSONField(name="percoavectype")
    private String percoavectype;

    /**
     *教练员准教类别
    **/
    @JSONField(name="teatype")
    private String teatype;

    /**
     *创建者编号
    **/
    @JSONField(name="creusrcode")
    private String creusrcode;

    /**
     *创建日期
    **/
    @JSONField(name="credate")
    private char credate;

    /**
     *创建时间
    **/
    @JSONField(name="cretime")
    private char cretime;

    /**
     *修改者编号
    **/
    @JSONField(name="ediusrcode")
    private String ediusrcode;

    /**
     *修改日期
    **/
    @JSONField(name="edidate")
    private char edidate;

    /**
     *修改时间
    **/
    @JSONField(name="editime")
    private char editime;

    /**
     *备注
    **/
    @JSONField(name="remarkdoc")
    private String remarkdoc;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private char iseffect;

    /**
     *发证类型
    **/
    @JSONField(name="gratype")
    private String gratype;

    /**
     *时间戳
    **/
    @JSONField(name="sysopertime")
    private Double sysopertime;

    /**
     *所属机构
    **/
    @JSONField(name="gradepcode")
    private String gradepcode;

    /**
     *报备机构
    **/
    @JSONField(name="reportdepcode")
    private String reportdepcode;

    /**
     *国际标示
    **/
    @JSONField(name="intltype")
    private String intltype;

    /**
     *原从业资格证号
    **/
    @JSONField(name="oldtitno")
    private String oldtitno;

    /**
     *稽查处理状态
    **/
    @JSONField(name="checkprstatus")
    private String checkprstatus;

    /**
     *交通事故记录次数
    **/
    @JSONField(name="accidentnum")
    private Double accidentnum;

    /**
     *周期累计学时
    **/
    @JSONField(name="cycletime")
    private Double cycletime;

    /**
     *管理工作年限
    **/
    @JSONField(name="managetime1")
    private String managetime1;

    /**
     *企业经营管理年限
    **/
    @JSONField(name="managetime2")
    private String managetime2;

    /**
     *维修技术证书发放日期
    **/
    @JSONField(name="tectgradate")
    private char tectgradate;

    /**
     *服务区域
    **/
    @JSONField(name="servicearea")
    private String servicearea;

    /**
     *注册日期
    **/
    @JSONField(name="registerdate")
    private char registerdate;

    /**
     *培训机构
    **/
    @JSONField(name="tradep")
    private String tradep;

    /**
     *期数
    **/
    @JSONField(name="traperiod")
    private String traperiod;

    /**
     *是否打印 0：未打印，1：已打印
    **/
    @JSONField(name="isprint")
    private String isprint;

    /**
     *打印位置
    **/
    @JSONField(name="printposition")
    private String printposition;

    /**
     *审核状态:0未审核1审核已通过2审核未通过
    **/
    @JSONField(name="auditstate")
    private char auditstate;

    /**
     *注销原因
    **/
    @JSONField(name="canceldoc")
    private String canceldoc;

    /**
     *证件发证机关CODE
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
     *归档状态.0已归档1待归档
    **/
    @JSONField(name="isfiled")
    private String isfiled;

    /**
     *打印受理书、决定书、成绩单
    **/
    @JSONField(name="archiveprint")
    private String archiveprint;

    /**
     *二维码图片ID
    **/
    @JSONField(name="objid")
    private String objid;

    /**
     *显示档案号
    **/
    @JSONField(name="showdocno")
    private String showdocno;

    @JSONField(name="creatortype")
    private String creatortype;

    /**
     *加载时间
    **/
    @JSONField(name="insertdate")
    private Date insertdate;

    public String getEnbeworrecordid() {
        return enbeworrecordid;
    }

    public void setEnbeworrecordid(String enbeworrecordid) {
        this.enbeworrecordid = enbeworrecordid;
    }

    public String getCmpsnid() {
        return cmpsnid;
    }

    public void setCmpsnid(String cmpsnid) {
        this.cmpsnid = cmpsnid;
    }

    public String getWortype() {
        return wortype;
    }

    public void setWortype(String wortype) {
        this.wortype = wortype;
    }

    public String getTitno() {
        return titno;
    }

    public void setTitno(String titno) {
        this.titno = titno;
    }

    public char getStartdate() {
        return startdate;
    }

    public void setStartdate(char startdate) {
        this.startdate = startdate;
    }

    public char getGradate() {
        return gradate;
    }

    public void setGradate(char gradate) {
        this.gradate = gradate;
    }

    public char getEnddate() {
        return enddate;
    }

    public void setEnddate(char enddate) {
        this.enddate = enddate;
    }

    public String getLicstatus() {
        return licstatus;
    }

    public void setLicstatus(String licstatus) {
        this.licstatus = licstatus;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Double getTratimes() {
        return tratimes;
    }

    public void setTratimes(Double tratimes) {
        this.tratimes = tratimes;
    }

    public String getBeworlevel() {
        return beworlevel;
    }

    public void setBeworlevel(String beworlevel) {
        this.beworlevel = beworlevel;
    }

    public String getAreaserial() {
        return areaserial;
    }

    public void setAreaserial(String areaserial) {
        this.areaserial = areaserial;
    }

    public String getDocno() {
        return docno;
    }

    public void setDocno(String docno) {
        this.docno = docno;
    }

    public String getDepcode() {
        return depcode;
    }

    public void setDepcode(String depcode) {
        this.depcode = depcode;
    }

    public char getExamineearea() {
        return examineearea;
    }

    public void setExamineearea(char examineearea) {
        this.examineearea = examineearea;
    }

    public String getBeworscope() {
        return beworscope;
    }

    public void setBeworscope(String beworscope) {
        this.beworscope = beworscope;
    }

    public String getAppixscope() {
        return appixscope;
    }

    public void setAppixscope(String appixscope) {
        this.appixscope = appixscope;
    }

    public String getDricardno() {
        return dricardno;
    }

    public void setDricardno(String dricardno) {
        this.dricardno = dricardno;
    }

    public String getPerdritype() {
        return perdritype;
    }

    public void setPerdritype(String perdritype) {
        this.perdritype = perdritype;
    }

    public String getDristadate() {
        return dristadate;
    }

    public void setDristadate(String dristadate) {
        this.dristadate = dristadate;
    }

    public String getTeccomment() {
        return teccomment;
    }

    public void setTeccomment(String teccomment) {
        this.teccomment = teccomment;
    }

    public String getTecgrade() {
        return tecgrade;
    }

    public void setTecgrade(String tecgrade) {
        this.tecgrade = tecgrade;
    }

    public String getIsprincipal() {
        return isprincipal;
    }

    public void setIsprincipal(String isprincipal) {
        this.isprincipal = isprincipal;
    }

    public String getPercoavectype() {
        return percoavectype;
    }

    public void setPercoavectype(String percoavectype) {
        this.percoavectype = percoavectype;
    }

    public String getTeatype() {
        return teatype;
    }

    public void setTeatype(String teatype) {
        this.teatype = teatype;
    }

    public String getCreusrcode() {
        return creusrcode;
    }

    public void setCreusrcode(String creusrcode) {
        this.creusrcode = creusrcode;
    }

    public char getCredate() {
        return credate;
    }

    public void setCredate(char credate) {
        this.credate = credate;
    }

    public char getCretime() {
        return cretime;
    }

    public void setCretime(char cretime) {
        this.cretime = cretime;
    }

    public String getEdiusrcode() {
        return ediusrcode;
    }

    public void setEdiusrcode(String ediusrcode) {
        this.ediusrcode = ediusrcode;
    }

    public char getEdidate() {
        return edidate;
    }

    public void setEdidate(char edidate) {
        this.edidate = edidate;
    }

    public char getEditime() {
        return editime;
    }

    public void setEditime(char editime) {
        this.editime = editime;
    }

    public String getRemarkdoc() {
        return remarkdoc;
    }

    public void setRemarkdoc(String remarkdoc) {
        this.remarkdoc = remarkdoc;
    }

    public char getIseffect() {
        return iseffect;
    }

    public void setIseffect(char iseffect) {
        this.iseffect = iseffect;
    }

    public String getGratype() {
        return gratype;
    }

    public void setGratype(String gratype) {
        this.gratype = gratype;
    }

    public Double getSysopertime() {
        return sysopertime;
    }

    public void setSysopertime(Double sysopertime) {
        this.sysopertime = sysopertime;
    }

    public String getGradepcode() {
        return gradepcode;
    }

    public void setGradepcode(String gradepcode) {
        this.gradepcode = gradepcode;
    }

    public String getReportdepcode() {
        return reportdepcode;
    }

    public void setReportdepcode(String reportdepcode) {
        this.reportdepcode = reportdepcode;
    }

    public String getIntltype() {
        return intltype;
    }

    public void setIntltype(String intltype) {
        this.intltype = intltype;
    }

    public String getOldtitno() {
        return oldtitno;
    }

    public void setOldtitno(String oldtitno) {
        this.oldtitno = oldtitno;
    }

    public String getCheckprstatus() {
        return checkprstatus;
    }

    public void setCheckprstatus(String checkprstatus) {
        this.checkprstatus = checkprstatus;
    }

    public Double getAccidentnum() {
        return accidentnum;
    }

    public void setAccidentnum(Double accidentnum) {
        this.accidentnum = accidentnum;
    }

    public Double getCycletime() {
        return cycletime;
    }

    public void setCycletime(Double cycletime) {
        this.cycletime = cycletime;
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

    public char getTectgradate() {
        return tectgradate;
    }

    public void setTectgradate(char tectgradate) {
        this.tectgradate = tectgradate;
    }

    public String getServicearea() {
        return servicearea;
    }

    public void setServicearea(String servicearea) {
        this.servicearea = servicearea;
    }

    public char getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(char registerdate) {
        this.registerdate = registerdate;
    }

    public String getTradep() {
        return tradep;
    }

    public void setTradep(String tradep) {
        this.tradep = tradep;
    }

    public String getTraperiod() {
        return traperiod;
    }

    public void setTraperiod(String traperiod) {
        this.traperiod = traperiod;
    }

    public String getIsprint() {
        return isprint;
    }

    public void setIsprint(String isprint) {
        this.isprint = isprint;
    }

    public String getPrintposition() {
        return printposition;
    }

    public void setPrintposition(String printposition) {
        this.printposition = printposition;
    }

    public char getAuditstate() {
        return auditstate;
    }

    public void setAuditstate(char auditstate) {
        this.auditstate = auditstate;
    }

    public String getCanceldoc() {
        return canceldoc;
    }

    public void setCanceldoc(String canceldoc) {
        this.canceldoc = canceldoc;
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

    public String getIsfiled() {
        return isfiled;
    }

    public void setIsfiled(String isfiled) {
        this.isfiled = isfiled;
    }

    public String getArchiveprint() {
        return archiveprint;
    }

    public void setArchiveprint(String archiveprint) {
        this.archiveprint = archiveprint;
    }

    public String getObjid() {
        return objid;
    }

    public void setObjid(String objid) {
        this.objid = objid;
    }

    public String getShowdocno() {
        return showdocno;
    }

    public void setShowdocno(String showdocno) {
        this.showdocno = showdocno;
    }

    public String getCreatortype() {
        return creatortype;
    }

    public void setCreatortype(String creatortype) {
        this.creatortype = creatortype;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

}