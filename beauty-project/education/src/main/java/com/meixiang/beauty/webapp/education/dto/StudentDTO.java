package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class StudentDTO {

    @JSONField(name = "schoolId")
    private String schoolId;

    @JSONField(name = "schoolName")
    private String schoolName;

    @JSONField(name = "classId")
    private String classId;

    @JSONField(name = "className")
    private String className;

    @JSONField(name = "studentId")
    private String studentId;

    @JSONField(name = "studentName")
    private String studentName;

    //所在学校的学工号
    @JSONField(name = "studyNo")
    private String studyNo;

    //所在班级的学号
    @JSONField(name = "classNo")
    private String classNo;

    @JSONField(name = "studentScore")
    private String studentScore;

    @JSONField(name = "studentLevel")
    private String studentLevel;

    @JSONField(name = "password")
    private String password;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
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

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStudyNo(String studyNo) {
        this.studyNo = studyNo;
    }

    public String getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(String studentScore) {
        this.studentScore = studentScore;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }
}
