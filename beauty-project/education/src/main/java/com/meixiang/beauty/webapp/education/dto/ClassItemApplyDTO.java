package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class ClassItemApplyDTO {

    @JSONField(name = "applyId")
    private String applyId;

    @JSONField(name = "applyType")
    private String applyType;

    @JSONField(name = "applyPlace")
    private String applyPlace;

    @JSONField(name = "applyReason")
    private String applyReason;

    @JSONField(name = "applyStartTime")
    private Date applyStartTime;

    @JSONField(name = "applyEndTime")
    private Date applyEndTime;

    @JSONField(name = "applyCreateDate")
    private Date applyCreateDate;

    @JSONField(name = "applyExtension")
    private String applyExtension;

    @JSONField(name = "classId")
    private String classId;

    @JSONField(name = "className")
    private String className;

    @JSONField(name = "applyStudentId")
    private String applyStudentId;

    @JSONField(name = "applyStudentName")
    private String applyStudentName;

    @JSONField(name = "teacherId")
    private String teacherId;

    @JSONField(name = "teacherName")
    private String teacherName;

    @JSONField(name = "applyStatus")
    private String applyStatus;

    @JSONField(name = "applyProcessReason")
    private String applyProcessReason;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getApplyPlace() {
        return applyPlace;
    }

    public void setApplyPlace(String applyPlace) {
        this.applyPlace = applyPlace;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public Date getApplyStartTime() {
        return applyStartTime;
    }

    public void setApplyStartTime(Date applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    public Date getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(Date applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public Date getApplyCreateDate() {
        return applyCreateDate;
    }

    public void setApplyCreateDate(Date applyCreateDate) {
        this.applyCreateDate = applyCreateDate;
    }

    public String getApplyExtension() {
        return applyExtension;
    }

    public void setApplyExtension(String applyExtension) {
        this.applyExtension = applyExtension;
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

    public String getApplyStudentId() {
        return applyStudentId;
    }

    public void setApplyStudentId(String applyStudentId) {
        this.applyStudentId = applyStudentId;
    }

    public String getApplyStudentName() {
        return applyStudentName;
    }

    public void setApplyStudentName(String applyStudentName) {
        this.applyStudentName = applyStudentName;
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

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getApplyProcessReason() {
        return applyProcessReason;
    }

    public void setApplyProcessReason(String applyProcessReason) {
        this.applyProcessReason = applyProcessReason;
    }
}
