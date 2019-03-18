package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class CourseHomeWorkStudentDTO {

    @JSONField(name = "homeWorkId")
    private String homeWorkId;

    @JSONField(name = "homeWorkCommentId")
    private String homeWorkCommentId;

    @JSONField(name = "homeWorkStudentRelId")
    private String homeWorkStudentRelId;

    @JSONField(name = "studentId")
    private String studentId;

    @JSONField(name = "studentName")
    private String studentName;

    @JSONField(name = "teacherId")
    private String teacherId;

    @JSONField(name = "teacherName")
    private String teacherName;

    @JSONField(name = "classCourseId")
    private String classCourseId;

    @JSONField(name = "classId")
    private String classId;

    @JSONField(name = "className")
    private String className;

    @JSONField(name = "courseId")
    private String courseId;

    @JSONField(name = "courseName")
    private String courseName;

    @JSONField(name = "classTime")
    private Date classTime;

    @JSONField(name = "weekIndex")
    private String weekIndex;

    private String week;

    @JSONField(name = "coursePlace")
    private String coursePlace;

    //家庭作业名称
    @JSONField(name = "homeWorkName")
    private String homeWorkName;

    //作业完成时间
    @JSONField(name = "homeWorkTime")
    private Date homeWorkTime;

    @JSONField(name = "homeWorkDesc")
    private String homeWorkDesc;

    @JSONField(name = "homeWorkVideoList")
    private String homeWorkVideoList;

    @JSONField(name = "homeWorkUrlList")
    private String homeWorkUrlList;

    @JSONField(name = "homeWorkAttachList")
    private String homeWorkAttachList;

    @JSONField(name = "homeWorkImgList")
    private String homeWorkImgList;

    @JSONField(name = "homeWorkCommentMsg")
    private String homeWorkCommentMsg;

    @JSONField(name = "homeWorkCommentStatus")
    private String homeWorkCommentStatus;

    //任务老师的批改状态，0表示未批改，1表示已批改
    @JSONField(name = "homeWorkStatus")
    private String homeWorkStatus;

    //任务学生是否超时未提交，0表示超时了，1表示没有超时，2代表没有提交
    @JSONField(name = "commitStatus")
    private String commitStatus;

    @JSONField(name = "homeWorkCreateDate")
    private Date homeWorkCreateDate;

    @JSONField(name = "homeWorkCommentCreateDate")
    private Date homeWorkCommentCreateDate;

    //是否有作业
    private String homeWorkFlag;

    public String getHomeWorkId() {
        return homeWorkId;
    }

    public void setHomeWorkId(String homeWorkId) {
        this.homeWorkId = homeWorkId;
    }

    public String getHomeWorkCommentId() {
        return homeWorkCommentId;
    }

    public void setHomeWorkCommentId(String homeWorkCommentId) {
        this.homeWorkCommentId = homeWorkCommentId;
    }

    public String getHomeWorkStudentRelId() {
        return homeWorkStudentRelId;
    }

    public void setHomeWorkStudentRelId(String homeWorkStudentRelId) {
        this.homeWorkStudentRelId = homeWorkStudentRelId;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
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

    public String getHomeWorkFlag() {
        return homeWorkFlag;
    }

    public void setHomeWorkFlag(String homeWorkFlag) {
        this.homeWorkFlag = homeWorkFlag;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public Date getClassTime() {
        return classTime;
    }

    public void setClassTime(Date classTime) {
        this.classTime = classTime;
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

    public String getClassCourseId() {
        return classCourseId;
    }

    public void setClassCourseId(String classCourseId) {
        this.classCourseId = classCourseId;
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

    public String getWeekIndex() {
        return weekIndex;
    }

    public void setWeekIndex(String weekIndex) {
        this.weekIndex = weekIndex;
    }

    public String getCoursePlace() {
        return coursePlace;
    }

    public void setCoursePlace(String coursePlace) {
        this.coursePlace = coursePlace;
    }

    public String getHomeWorkName() {
        return homeWorkName;
    }

    public void setHomeWorkName(String homeWorkName) {
        this.homeWorkName = homeWorkName;
    }

    public Date getHomeWorkTime() {
        return homeWorkTime;
    }

    public void setHomeWorkTime(Date homeWorkTime) {
        this.homeWorkTime = homeWorkTime;
    }

    public String getHomeWorkDesc() {
        return homeWorkDesc;
    }

    public void setHomeWorkDesc(String homeWorkDesc) {
        this.homeWorkDesc = homeWorkDesc;
    }

    public String getHomeWorkVideoList() {
        return homeWorkVideoList;
    }

    public void setHomeWorkVideoList(String homeWorkVideoList) {
        this.homeWorkVideoList = homeWorkVideoList;
    }

    public String getHomeWorkUrlList() {
        return homeWorkUrlList;
    }

    public void setHomeWorkUrlList(String homeWorkUrlList) {
        this.homeWorkUrlList = homeWorkUrlList;
    }

    public String getHomeWorkAttachList() {
        return homeWorkAttachList;
    }

    public void setHomeWorkAttachList(String homeWorkAttachList) {
        this.homeWorkAttachList = homeWorkAttachList;
    }

    public String getHomeWorkImgList() {
        return homeWorkImgList;
    }

    public void setHomeWorkImgList(String homeWorkImgList) {
        this.homeWorkImgList = homeWorkImgList;
    }

    public String getHomeWorkCommentMsg() {
        return homeWorkCommentMsg;
    }

    public void setHomeWorkCommentMsg(String homeWorkCommentMsg) {
        this.homeWorkCommentMsg = homeWorkCommentMsg;
    }

    public String getHomeWorkCommentStatus() {
        return homeWorkCommentStatus;
    }

    public void setHomeWorkCommentStatus(String homeWorkCommentStatus) {
        this.homeWorkCommentStatus = homeWorkCommentStatus;
    }

    public String getHomeWorkStatus() {
        return homeWorkStatus;
    }

    public void setHomeWorkStatus(String homeWorkStatus) {
        this.homeWorkStatus = homeWorkStatus;
    }

    public String getCommitStatus() {
        return commitStatus;
    }

    public void setCommitStatus(String commitStatus) {
        this.commitStatus = commitStatus;
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

    public Date getHomeWorkCreateDate() {
        return homeWorkCreateDate;
    }

    public void setHomeWorkCreateDate(Date homeWorkCreateDate) {
        this.homeWorkCreateDate = homeWorkCreateDate;
    }

    public Date getHomeWorkCommentCreateDate() {
        return homeWorkCommentCreateDate;
    }

    public void setHomeWorkCommentCreateDate(Date homeWorkCommentCreateDate) {
        this.homeWorkCommentCreateDate = homeWorkCommentCreateDate;
    }
}
