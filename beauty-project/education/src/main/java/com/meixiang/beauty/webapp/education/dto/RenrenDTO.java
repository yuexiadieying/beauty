package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class RenrenDTO<T> {

    //人人通的消息ID
    @JSONField(name = "id")
    private String id;

    //userType为student表示是学生，为teacher表示为老师
    @JSONField(name = "userType")
    private String userType;

    //此处的T可以是StudentDTO，也可以是TeacherDTO
    @JSONField(name = "userInfo")
    private T userInfo;

    private String userId;

    //发表的话题的标题
    @JSONField(name = "title")
    private String title;

    //发表的话题的内容
    @JSONField(name = "content")
    private String content;

    //发表的图片信息，URL方式放入list中
    @JSONField(name = "picList")
    private List<String> picList;

    //点赞的数量
    @JSONField(name = "zanNum")
    private int zanNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JSONField(name = "renrenDiscussList")
    private List<RenrenDiscussDTO> renrenDiscussList;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }

    public int getZanNum() {
        return zanNum;
    }

    public void setZanNum(int zanNum) {
        this.zanNum = zanNum;
    }

    public List<RenrenDiscussDTO> getRenrenDiscussList() {
        return renrenDiscussList;
    }

    public void setRenrenDiscussList(List<RenrenDiscussDTO> renrenDiscussList) {
        this.renrenDiscussList = renrenDiscussList;
    }
}
