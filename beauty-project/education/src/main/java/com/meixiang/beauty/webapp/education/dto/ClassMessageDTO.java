package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class ClassMessageDTO<T> {

    @JSONField(name = "messageId")
    private String messageId;

    //0代表课堂点评，1代表请假审批，2代表作业点评
    @JSONField(name = "messageType")
    private String messageType;

    //消息关联的学生ID
    @JSONField(name = "studentId")
    private String studentId;

    //消息关联的学生名称
    @JSONField(name = "studentName")
    private String studentName;

    //消息关联的老师ID
    @JSONField(name = "teacherId")
    private String teacherId;

    //消息关联的老师名称
    @JSONField(name = "teacherName")
    private String teacherName;

    //这个消息是关于我的内容，0表示未读，1表示已读
    @JSONField(name = "messageStatus")
    private String messageStatus;

    //messageType为0时，T表示StudentCourseCommentDTO
    //messageType为1时，T表示StudentVacationApplyDTO
    //messageType为2时，T表示StudentCourseMissionDTO
    @JSONField(name = "messageContent")
    private T messageContent;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public T getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(T messageContent) {
        this.messageContent = messageContent;
    }
}
