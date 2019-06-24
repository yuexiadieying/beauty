package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TSlyzXzqhsDTO {

    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *行政区划代码
    **/
    @JSONField(name="xzqhno")
    private String xzqhno;

    /**
     *行政区划名称
    **/
    @JSONField(name="xzqhname")
    private String xzqhname;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getXzqhno() {
        return xzqhno;
    }

    public void setXzqhno(String xzqhno) {
        this.xzqhno = xzqhno;
    }

    public String getXzqhname() {
        return xzqhname;
    }

    public void setXzqhname(String xzqhname) {
        this.xzqhname = xzqhname;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}