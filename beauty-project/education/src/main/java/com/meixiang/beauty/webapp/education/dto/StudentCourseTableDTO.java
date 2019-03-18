package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashMap;
import java.util.List;

public class StudentCourseTableDTO {

    //表示是第几周
    @JSONField(name = "weekIndex")
    private Integer weekIndex;

    //值为周一、周二
    @JSONField(name = "weekName")
    private String weekName;

    //23号，26号
    @JSONField(name = "weekDate")
    private String weekDate;

    @JSONField(name = "courseId")
    private String courseId;

    @JSONField(name = "courseName")
    private String courseName;

    @JSONField(name = "classCourseId")
    private String classCourseId;

    @JSONField(name = "courseList")
    private List<CourseInfoDTO> courseList;

    public Integer getWeekIndex() {
        return weekIndex;
    }

    public void setWeekIndex(Integer weekIndex) {
        this.weekIndex = weekIndex;
    }

    public String getWeekName() {
        return weekName;
    }

    public void setWeekName(String weekName) {
        this.weekName = weekName;
    }

    public String getWeekDate() {
        return weekDate;
    }

    public void setWeekDate(String weekDate) {
        this.weekDate = weekDate;
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

    public String getClassCourseId() {
        return classCourseId;
    }

    public List<CourseInfoDTO> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseInfoDTO> courseList) {
        this.courseList = courseList;
    }

    public void setClassCourseId(String classCourseId) {
        this.classCourseId = classCourseId;
    }
}
