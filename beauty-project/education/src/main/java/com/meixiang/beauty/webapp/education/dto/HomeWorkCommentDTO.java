package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class HomeWorkCommentDTO {

    @JSONField(name = "studentHomeWorkId")
    private String studentHomeWorkId;

    @JSONField(name = "homeWorkStatus")
    private String homeWorkStatus;

    @JSONField(name = "homeworkMessage")
    private String homeworkMessage;

    public String getStudentHomeWorkId() {
        return studentHomeWorkId;
    }

    public void setStudentHomeWorkId(String studentHomeWorkId) {
        this.studentHomeWorkId = studentHomeWorkId;
    }

    public String getHomeWorkStatus() {
        return homeWorkStatus;
    }

    public void setHomeWorkStatus(String homeWorkStatus) {
        this.homeWorkStatus = homeWorkStatus;
    }

    public String getHomeworkMessage() {
        return homeworkMessage;
    }

    public void setHomeworkMessage(String homeworkMessage) {
        this.homeworkMessage = homeworkMessage;
    }
}
