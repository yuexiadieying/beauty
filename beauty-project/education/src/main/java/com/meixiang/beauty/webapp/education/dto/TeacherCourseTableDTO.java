package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

public class TeacherCourseTableDTO {

    //表示是第几周
    @JSONField(name = "weekIndex")
    private Integer weekIndex;

    //一般表示是第几月
    @JSONField(name = "weekMonth")
    private String weekMonth;

    //值为周一、周二
    @JSONField(name = "weekName")
    private String weekName;

    //23号，26号
    @JSONField(name = "weekDate")
    private String weekDate;

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

    public List<CourseInfoDTO> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseInfoDTO> courseList) {
        this.courseList = courseList;
    }

    public String getWeekMonth() {
        return weekMonth;
    }

    public void setWeekMonth(String weekMonth) {
        this.weekMonth = weekMonth;
    }
}
