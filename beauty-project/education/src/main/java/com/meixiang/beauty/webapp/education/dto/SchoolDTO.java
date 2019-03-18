package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class SchoolDTO {

    @JSONField(name = "schoolId")
    private String schoolId;

    @JSONField(name = "schoolName")
    private String schoolName;

    @JSONField(name = "schoolAddress")
    private String schoolAddress;

    @JSONField(name = "teacherList")
    private List<TeacherDTO> teacherList;

    private Date startSchoolDate;

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

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public List<TeacherDTO> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherDTO> teacherList) {
        this.teacherList = teacherList;
    }

    public Date getStartSchoolDate() {
        return startSchoolDate;
    }

    public void setStartSchoolDate(Date startSchoolDate) {
        this.startSchoolDate = startSchoolDate;
    }

}
