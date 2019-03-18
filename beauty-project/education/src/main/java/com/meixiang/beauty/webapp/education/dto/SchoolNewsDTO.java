package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class SchoolNewsDTO {

    @JSONField(name = "schoolNewsId")
    private String schoolNewsId;

    @JSONField(name = "schoolId")
    private String schoolId;

    @JSONField(name = "schoolNewsTitle")
    private String schoolNewsTitle;

    @JSONField(name = "schoolNewsApartment")
    private String schoolNewsApartment;

    @JSONField(name = "schoolNewsDate")
    private Date schoolNewsDate;

    @JSONField(name = "schoolNewsContent")
    private String schoolNewsContent;

    @JSONField(name = "schoolNewsStatus")
    private String schoolNewsStatus;

    public String getSchoolNewsId() {
        return schoolNewsId;
    }

    public void setSchoolNewsId(String schoolNewsId) {
        this.schoolNewsId = schoolNewsId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolNewsApartment() {
        return schoolNewsApartment;
    }

    public void setSchoolNewsApartment(String schoolNewsApartment) {
        this.schoolNewsApartment = schoolNewsApartment;
    }

    public String getSchoolNewsTitle() {
        return schoolNewsTitle;
    }

    public void setSchoolNewsTitle(String schoolNewsTitle) {
        this.schoolNewsTitle = schoolNewsTitle;
    }

    public Date getSchoolNewsDate() {
        return schoolNewsDate;
    }

    public void setSchoolNewsDate(Date schoolNewsDate) {
        this.schoolNewsDate = schoolNewsDate;
    }

    public String getSchoolNewsContent() {
        return schoolNewsContent;
    }

    public void setSchoolNewsContent(String schoolNewsContent) {
        this.schoolNewsContent = schoolNewsContent;
    }

    public String getSchoolNewsStatus() {
        return schoolNewsStatus;
    }

    public void setSchoolNewsStatus(String schoolNewsStatus) {
        this.schoolNewsStatus = schoolNewsStatus;
    }
}
