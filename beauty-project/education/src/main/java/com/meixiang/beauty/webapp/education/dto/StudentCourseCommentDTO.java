package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class StudentCourseCommentDTO {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "classCourseId")
    private String classCourseId;

    @JSONField(name = "courseName")
    private String courseName;

    @JSONField(name = "teacherId")
    private String teacherId;

    @JSONField(name = "teacherName")
    private String teacherName;

    @JSONField(name = "studentId")
    private String studentId;

    @JSONField(name = "studentName")
    private String studentName;

    //学生的学号
    @JSONField(name = "studentNo")
    private String studentNo;

    //0表示表扬，1表示批评，2表示建议，3表示老师对此学生在此课堂上的表现没有评论
    @JSONField(name = "courseCommentStatus")
    private String courseCommentStatus;

    //学生在课程上点评文字，例如：学生上课表现很好，认真听课
    @JSONField(name = "courseCommentMsg")
    private String courseCommentMsg;

    @JSONField(name = "courseCommentCreateDate")
    private Date courseCommentCreateDate;

    //课堂表现的附件列表，数组中放的是老师拍的照片的URL
    @JSONField(name = "courseCommentURLs")
    private String courseCommentURLs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassCourseId() {
        return classCourseId;
    }

    public void setClassCourseId(String classCourseId) {
        this.classCourseId = classCourseId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getCourseCommentStatus() {
        return courseCommentStatus;
    }

    public void setCourseCommentStatus(String courseCommentStatus) {
        this.courseCommentStatus = courseCommentStatus;
    }

    public String getCourseCommentMsg() {
        return courseCommentMsg;
    }

    public void setCourseCommentMsg(String courseCommentMsg) {
        this.courseCommentMsg = courseCommentMsg;
    }

    public String getCourseCommentURLs() {
        return courseCommentURLs;
    }

    public void setCourseCommentURLs(String courseCommentURLs) {
        this.courseCommentURLs = courseCommentURLs;
    }

    public Date getCourseCommentCreateDate() {
        return courseCommentCreateDate;
    }

    public void setCourseCommentCreateDate(Date courseCommentCreateDate) {
        this.courseCommentCreateDate = courseCommentCreateDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
