package com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TScxyTfBsCreditReportDTO {

    /**
     *申报ID
    **/
    @JSONField(name="reportId")
    private String reportId;

    /**
     *OWNER_ID
    **/
    @JSONField(name="ownerId")
    private String ownerId;

    /**
     *申报日期
    **/
    @JSONField(name="reportDate")
    private String reportDate;

    /**
     *考核年度
    **/
    @JSONField(name="reportYear")
    private String reportYear;

    /**
     *申报类型(1-信用，2-安全）
    **/
    @JSONField(name="reportType")
    private String reportType;

    /**
     *申报内容
    **/
    @JSONField(name="reportContent")
    private String reportContent;

    /**
     *申报状态
    **/
    @JSONField(name="reportStatus")
    private String reportStatus;

    /**
     *自评得分
    **/
    @JSONField(name="cltScore")
    private Double cltScore;

    /**
     *自评等级
    **/
    @JSONField(name="cltLevel")
    private String cltLevel;

    /**
     *考核得分
    **/
    @JSONField(name="reportScore")
    private Double reportScore;

    /**
     *考核等级
    **/
    @JSONField(name="reportLevel")
    private String reportLevel;

    /**
     *初评机构
    **/
    @JSONField(name="firstOrg")
    private String firstOrg;

    /**
     *税务登记号
    **/
    @JSONField(name="taxRegNumber")
    private String taxRegNumber;

    /**
     *工商营业执照号
    **/
    @JSONField(name="busiRegNumber")
    private String busiRegNumber;

    /**
     *经营状态
    **/
    @JSONField(name="operatingState")
    private String operatingState;

    /**
     *联系电话
    **/
    @JSONField(name="phone")
    private String phone;

    /**
     *经营负责人
    **/
    @JSONField(name="principal")
    private String principal;

    /**
     *邮政编码
    **/
    @JSONField(name="ctcno")
    private String ctcno;

    /**
     *法定代表人证件类别
    **/
    @JSONField(name="jurctcType")
    private String jurctcType;

    /**
     *法定代表人联系电话
    **/
    @JSONField(name="jurctcPhone")
    private String jurctcPhone;

    /**
     *法定代表人
    **/
    @JSONField(name="jurperson")
    private String jurperson;

    /**
     *经济类型
    **/
    @JSONField(name="economicType")
    private String economicType;

    /**
     *行政区域代码
    **/
    @JSONField(name="cancode")
    private String cancode;

    /**
     *邮政编码
    **/
    @JSONField(name="postalCode")
    private String postalCode;

    /**
     *业户地址
    **/
    @JSONField(name="address")
    private String address;

    /**
     *分支机构编码
    **/
    @JSONField(name="branchCode")
    private String branchCode;

    /**
     *上级业户编码
    **/
    @JSONField(name="headOffice")
    private String headOffice;

    /**
     *管理机构编码
    **/
    @JSONField(name="depcode")
    private String depcode;

    /**
     *发证机关
    **/
    @JSONField(name="gradepcode")
    private String gradepcode;

    /**
     *有效期止
    **/
    @JSONField(name="endDate")
    private String endDate;

    /**
     *有效期起
    **/
    @JSONField(name="startDate")
    private String startDate;

    /**
     *核发日期
    **/
    @JSONField(name="gradate")
    private String gradate;

    /**
     *许可证号
    **/
    @JSONField(name="licenseNumber")
    private String licenseNumber;

    /**
     *许可证字
    **/
    @JSONField(name="perword")
    private String perword;

    /**
     *经营范围
    **/
    @JSONField(name="scopeBusiness")
    private String scopeBusiness;

    /**
     *企业实体类型
    **/
    @JSONField(name="ownerType")
    private String ownerType;

    /**
     *企业名称
    **/
    @JSONField(name="ownerName")
    private String ownerName;

    /**
     *是否有效
    **/
    @JSONField(name="iseffect")
    private String iseffect;

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
     *时间戳
    **/
    @JSONField(name="sysopertime")
    private String sysopertime;

    /**
     *初评分数
    **/
    @JSONField(name="firstScore")
    private Double firstScore;

    /**
     *初评等级
    **/
    @JSONField(name="firstLevel")
    private String firstLevel;

    /**
     *综评分数
    **/
    @JSONField(name="lastScore")
    private Double lastScore;

    /**
     *综评等级
    **/
    @JSONField(name="lastLevel")
    private String lastLevel;

    /**
     *复评分数
    **/
    @JSONField(name="finalScore")
    private Double finalScore;

    /**
     *复评等级
    **/
    @JSONField(name="finalLevel")
    private String finalLevel;

    /**
     *回复意见
    **/
    @JSONField(name="notion")
    private String notion;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportYear() {
        return reportYear;
    }

    public void setReportYear(String reportYear) {
        this.reportYear = reportYear;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Double getCltScore() {
        return cltScore;
    }

    public void setCltScore(Double cltScore) {
        this.cltScore = cltScore;
    }

    public String getCltLevel() {
        return cltLevel;
    }

    public void setCltLevel(String cltLevel) {
        this.cltLevel = cltLevel;
    }

    public Double getReportScore() {
        return reportScore;
    }

    public void setReportScore(Double reportScore) {
        this.reportScore = reportScore;
    }

    public String getReportLevel() {
        return reportLevel;
    }

    public void setReportLevel(String reportLevel) {
        this.reportLevel = reportLevel;
    }

    public String getFirstOrg() {
        return firstOrg;
    }

    public void setFirstOrg(String firstOrg) {
        this.firstOrg = firstOrg;
    }

    public String getTaxRegNumber() {
        return taxRegNumber;
    }

    public void setTaxRegNumber(String taxRegNumber) {
        this.taxRegNumber = taxRegNumber;
    }

    public String getBusiRegNumber() {
        return busiRegNumber;
    }

    public void setBusiRegNumber(String busiRegNumber) {
        this.busiRegNumber = busiRegNumber;
    }

    public String getOperatingState() {
        return operatingState;
    }

    public void setOperatingState(String operatingState) {
        this.operatingState = operatingState;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getCtcno() {
        return ctcno;
    }

    public void setCtcno(String ctcno) {
        this.ctcno = ctcno;
    }

    public String getJurctcType() {
        return jurctcType;
    }

    public void setJurctcType(String jurctcType) {
        this.jurctcType = jurctcType;
    }

    public String getJurctcPhone() {
        return jurctcPhone;
    }

    public void setJurctcPhone(String jurctcPhone) {
        this.jurctcPhone = jurctcPhone;
    }

    public String getJurperson() {
        return jurperson;
    }

    public void setJurperson(String jurperson) {
        this.jurperson = jurperson;
    }

    public String getEconomicType() {
        return economicType;
    }

    public void setEconomicType(String economicType) {
        this.economicType = economicType;
    }

    public String getCancode() {
        return cancode;
    }

    public void setCancode(String cancode) {
        this.cancode = cancode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getHeadOffice() {
        return headOffice;
    }

    public void setHeadOffice(String headOffice) {
        this.headOffice = headOffice;
    }

    public String getDepcode() {
        return depcode;
    }

    public void setDepcode(String depcode) {
        this.depcode = depcode;
    }

    public String getGradepcode() {
        return gradepcode;
    }

    public void setGradepcode(String gradepcode) {
        this.gradepcode = gradepcode;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getGradate() {
        return gradate;
    }

    public void setGradate(String gradate) {
        this.gradate = gradate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getPerword() {
        return perword;
    }

    public void setPerword(String perword) {
        this.perword = perword;
    }

    public String getScopeBusiness() {
        return scopeBusiness;
    }

    public void setScopeBusiness(String scopeBusiness) {
        this.scopeBusiness = scopeBusiness;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getIseffect() {
        return iseffect;
    }

    public void setIseffect(String iseffect) {
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

    public String getSysopertime() {
        return sysopertime;
    }

    public void setSysopertime(String sysopertime) {
        this.sysopertime = sysopertime;
    }

    public Double getFirstScore() {
        return firstScore;
    }

    public void setFirstScore(Double firstScore) {
        this.firstScore = firstScore;
    }

    public String getFirstLevel() {
        return firstLevel;
    }

    public void setFirstLevel(String firstLevel) {
        this.firstLevel = firstLevel;
    }

    public Double getLastScore() {
        return lastScore;
    }

    public void setLastScore(Double lastScore) {
        this.lastScore = lastScore;
    }

    public String getLastLevel() {
        return lastLevel;
    }

    public void setLastLevel(String lastLevel) {
        this.lastLevel = lastLevel;
    }

    public Double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }

    public String getFinalLevel() {
        return finalLevel;
    }

    public void setFinalLevel(String finalLevel) {
        this.finalLevel = finalLevel;
    }

    public String getNotion() {
        return notion;
    }

    public void setNotion(String notion) {
        this.notion = notion;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}