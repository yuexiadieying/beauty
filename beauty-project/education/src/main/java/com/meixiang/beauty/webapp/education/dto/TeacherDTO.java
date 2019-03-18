package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class TeacherDTO {

    @JSONField(name = "schoolId")
    private String schoolId;

    @JSONField(name = "schoolName")
    private String schoolName;

    @JSONField(name = "classId")
    private String classId;

    @JSONField(name = "className")
    private String className;

    @JSONField(name = "teacherNo")
    private String teacherNo;

    @JSONField(name = "teacherId")
    private String teacherId;

    @JSONField(name = "teacherName")
    private String teacherName;

    @JSONField(name = "teacherTypes")
    private List<String> teacherTypes;

    @JSONField(name = "level")
    private String level;

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

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
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

    public List<String> getTeacherTypes() {
        return teacherTypes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTeacherTypes(List<String> teacherTypes) {
        this.teacherTypes = teacherTypes;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
