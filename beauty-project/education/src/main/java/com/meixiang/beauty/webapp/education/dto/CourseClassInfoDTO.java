package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CourseClassInfoDTO {

    @JSONField(name = "courseId")
    private String courseId;

    //语文、数学或者化学
    @JSONField(name = "courseName")
    private String courseName;

    @JSONField(name = "classCourseId")
    private String classCourseId;

    @JSONField(name = "className")
    private String className;

    @JSONField(name = "classId")
    private String classId;

    //当前周数，11表示第11周，16表示第16周
    @JSONField(name = "weekIndex")
    private String weekIndex;

    //表示该课程，当天的节数，例如：周三第四节、第五节，或者周二第六节、第七节
    @JSONField(name = "coursePlace")
    private String coursePlace;

    @JSONField(name = "teacherId")
    private String teacherId;

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

    public void setClassCourseId(String classCourseId) {
        this.classCourseId = classCourseId;
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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}
