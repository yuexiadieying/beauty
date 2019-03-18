package com.meixiang.beauty.webapp.education.dto.vpn;

import com.alibaba.fastjson.annotation.JSONField;
import com.meixiang.beauty.webapp.education.dto.StudentDTO;
import com.meixiang.beauty.webapp.education.dto.TeacherDTO;

import java.util.Date;
import java.util.List;

public class VpnUserDTO {

    @JSONField(name = "userEmail")
    private String userEmail;

    @JSONField(name = "userName")
    private String userName;

    @JSONField(name = "password")
    private String password;

    @JSONField(name = "birthDay")
    private String birthDay;

    @JSONField(name = "sex")
    private String sex;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
