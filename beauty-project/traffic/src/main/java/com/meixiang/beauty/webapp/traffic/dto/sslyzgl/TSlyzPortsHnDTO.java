package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TSlyzPortsHnDTO {

    /**
     *全国统一港口编号
    **/
    @JSONField(name="portno")
    private String portno;

    /**
     *港口名称
    **/
    @JSONField(name="portname")
    private String portname;

    /**
     *港口所在行政区划
    **/
    @JSONField(name="xzqhno")
    private String xzqhno;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getPortno() {
        return portno;
    }

    public void setPortno(String portno) {
        this.portno = portno;
    }

    public String getPortname() {
        return portname;
    }

    public void setPortname(String portname) {
        this.portname = portname;
    }

    public String getXzqhno() {
        return xzqhno;
    }

    public void setXzqhno(String xzqhno) {
        this.xzqhno = xzqhno;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}