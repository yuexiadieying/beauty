package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class StudentVacationApplyDTO {

    @JSONField(name = "vacationId")
    private String vacationId;

    @JSONField(name = "studentId")
    private String studentId;

    @JSONField(name = "studyNo")
    private String studyNo;

    @JSONField(name = "studentName")
    private String studentName;

    @JSONField(name = "teacherId")
    private String teacherId;

    @JSONField(name = "teacherName")
    private String teacherName;

    @JSONField(name = "applyDate")
    private Date applyDate;

    @JSONField(name = "classId")
    private String classId;

    //初三4班
    @JSONField(name = "className")
    private String className;

    //病假，或事假
    @JSONField(name = "vacationType")
    private String vacationType;

    //请假原因，例如：办理入学手术
    @JSONField(name = "applyReason")
    private String applyReason;

    //请假开始时间
    @JSONField(name = "beginDate")
    private Date beginDate;

    //请假结束时间
    @JSONField(name = "endDate")
    private Date endDate;

    //请假时长，12小时
    @JSONField(name = "period")
    private String period;

    //请假去向，去医院，去宿舍
    @JSONField(name = "vacationPlace")
    private String vacationPlace;

    //请假状态, agree表示同意，reject表示拒绝
    @JSONField(name = "vacationStatus")
    private String vacationStatus;

    private String approvedTime;

    private String remark;

    public String getApprovedTime() {
        return approvedTime;
    }

    public void setApprovedTime(String approvedTime) {
        this.approvedTime = approvedTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVacationId() {
        return vacationId;
    }

    public void setVacationId(String vacationId) {
        this.vacationId = vacationId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudyNo() {
        return studyNo;
    }

    public void setStudyNo(String studyNo) {
        this.studyNo = studyNo;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getVacationType() {
        return vacationType;
    }

    public void setVacationType(String vacationType) {
        this.vacationType = vacationType;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getVacationPlace() {
        return vacationPlace;
    }

    public void setVacationPlace(String vacationPlace) {
        this.vacationPlace = vacationPlace;
    }

    public String getVacationStatus() {
        return vacationStatus;
    }

    public void setVacationStatus(String vacationStatus) {
        this.vacationStatus = vacationStatus;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
