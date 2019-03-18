package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CourseInfoDTO {

    @JSONField(name = "courseId")
    private String courseId;

    @JSONField(name = "courseName")
    private String courseName;

    @JSONField(name = "classId")
    private String classId;

    @JSONField(name = "className")
    private String className;

    @JSONField(name = "classCourseId")
    private String classCourseId;

    @JSONField(name = "coursePlace")
    private String coursePlace;

    @JSONField(name = "courseNo")
    private String courseNo;

    private List<HashMap<String,Object>> courseStatus;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassCourseId() {
        return classCourseId;
    }

    public void setClassCourseId(String classCourseId) {
        this.classCourseId = classCourseId;
    }

    public String getCoursePlace() {
        return coursePlace;
    }

    public void setCoursePlace(String coursePlace) {
        this.coursePlace = coursePlace;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public List<HashMap<String, Object>> getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(List<HashMap<String, Object>> courseStatus) {
        this.courseStatus = courseStatus;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }
}
