package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class StudentMoralDTO {

    @JSONField(name = "studentId")
    private String studentId;

    @JSONField(name = "classId")
    private String classId;

    @JSONField(name = "schoolId")
    private String schoolId;

    @JSONField(name = "moralTitle")
    private String moralTitle;

    @JSONField(name = "moralContent")
    private String moralContent;

    @JSONField(name = "moralScore")
    private String moralScore;

    @JSONField(name = "date")
    private Date date;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getMoralTitle() {
        return moralTitle;
    }

    public void setMoralTitle(String moralTitle) {
        this.moralTitle = moralTitle;
    }

    public String getMoralContent() {
        return moralContent;
    }

    public void setMoralContent(String moralContent) {
        this.moralContent = moralContent;
    }

    public String getMoralScore() {
        return moralScore;
    }

    public void setMoralScore(String moralScore) {
        this.moralScore = moralScore;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
