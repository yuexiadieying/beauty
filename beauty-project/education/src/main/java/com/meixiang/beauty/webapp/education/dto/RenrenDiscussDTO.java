package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class RenrenDiscussDTO<T> {

    //人人通的消息ID，是renrenDTO里面的ID
    @JSONField(name = "id")
    private String id;

    //userType为student表示是学生，为teacher表示为老师
    @JSONField(name = "userType")
    private String userType;

    //此处的T可以是StudentDTO，也可以是TeacherDTO
    @JSONField(name = "userInfo")
    private T userInfo;

    private String userId;

    //评论的内容
    @JSONField(name = "content")
    private String content;

    //评论的时间
    @JSONField(name = "dateTime")
    private String dateTime;

    public void setId(String id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public T getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(T userInfo) {
        this.userInfo = userInfo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

}
