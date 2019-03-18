package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class TeacherMissionDTO {

    @JSONField(name = "courseMissionId")
    private String courseMissionId;

    @JSONField(name = "courseId")
    private String courseId;

    //课程名字，可能是语文，或者数学，或者化学等等
    @JSONField(name = "courseName")
    private String courseName;

    @JSONField(name = "classId")
    private String classId;

    //班级的名称，例如初二3班
    @JSONField(name = "courseMissionClass")
    private String courseMissionClass;

    //任务的具体内容，例如：背诵《雷电颂》最后两段。并完成模拟卷
    @JSONField(name = "courseMissionContent")
    private String courseMissionContent;

    //布置给此任务的班级，已经提交的人数
    @JSONField(name = "alreadySubmitNum")
    private String alreadySubmitNum;

    //布置给此任务的班级，没有提交的人数
    @JSONField(name = "notSubmitNum")
    private String notSubmitNum;

    //任务的截止日期，例如：06月12日
    @JSONField(name = "courseMissionDate")
    private String courseMissionDate;

    public String getCourseMissionId() {
        return courseMissionId;
    }

    public void setCourseMissionId(String courseMissionId) {
        this.courseMissionId = courseMissionId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getCourseMissionClass() {
        return courseMissionClass;
    }

    public void setCourseMissionClass(String courseMissionClass) {
        this.courseMissionClass = courseMissionClass;
    }

    public String getCourseMissionContent() {
        return courseMissionContent;
    }

    public void setCourseMissionContent(String courseMissionContent) {
        this.courseMissionContent = courseMissionContent;
    }

    public String getAlreadySubmitNum() {
        return alreadySubmitNum;
    }

    public void setAlreadySubmitNum(String alreadySubmitNum) {
        this.alreadySubmitNum = alreadySubmitNum;
    }

    public String getNotSubmitNum() {
        return notSubmitNum;
    }

    public void setNotSubmitNum(String notSubmitNum) {
        this.notSubmitNum = notSubmitNum;
    }

    public String getCourseMissionDate() {
        return courseMissionDate;
    }

    public void setCourseMissionDate(String courseMissionDate) {
        this.courseMissionDate = courseMissionDate;
    }
}
