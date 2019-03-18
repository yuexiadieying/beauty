package com.meixiang.beauty.webapp.education.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.meixiang.beauty.webapp.education.util.ClassCircleMessage;

import java.util.Date;

public class ClassCircleMessageDTO<T> {

    @JSONField(name = "teacherId")
    private String teacherId;

    @JSONField(name = "messageType")
    private ClassCircleMessage messageType;

    @JSONField(name = "message")
    private T message;

    @JSONField(name = "createDate")
    private Date createDate;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public ClassCircleMessage getMessageType() {
        return messageType;
    }

    public void setMessageType(ClassCircleMessage messageType) {
        this.messageType = messageType;
    }
}
