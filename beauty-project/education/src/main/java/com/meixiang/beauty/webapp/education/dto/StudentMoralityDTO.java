package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class StudentMoralityDTO {

    @JSONField(name = "studentId")
    private String studentId;

    //德育获得分数的项目名称
    @JSONField(name = "MoralityName")
    private String MoralityName;

    //德育获得分数的项目的详细内容
    @JSONField(name = "MoralityContent")
    private String MoralityContent;

    //德育获得分数的项目获得的分数
    @JSONField(name = "MoralityScore")
    private String MoralityScore;

    //德育获得分数的项目创建时间
    @JSONField(name = "MoralityCreateDate")
    private String MoralityCreateDate;

    //德育获得分数的项目创建老师姓名
    @JSONField(name = "MoralityTeacherName")
    private String MoralityTeacherName;

    @JSONField(name = "Semester")
    private String Semester;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMoralityName() {
        return MoralityName;
    }

    public void setMoralityName(String moralityName) {
        MoralityName = moralityName;
    }

    public String getMoralityContent() {
        return MoralityContent;
    }

    public void setMoralityContent(String moralityContent) {
        MoralityContent = moralityContent;
    }

    public String getMoralityScore() {
        return MoralityScore;
    }

    public void setMoralityScore(String moralityScore) {
        MoralityScore = moralityScore;
    }

    public String getMoralityCreateDate() {
        return MoralityCreateDate;
    }

    public void setMoralityCreateDate(String moralityCreateDate) {
        MoralityCreateDate = moralityCreateDate;
    }

    public String getMoralityTeacherName() {
        return MoralityTeacherName;
    }

    public void setMoralityTeacherName(String moralityTeacherName) {
        MoralityTeacherName = moralityTeacherName;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }
}
