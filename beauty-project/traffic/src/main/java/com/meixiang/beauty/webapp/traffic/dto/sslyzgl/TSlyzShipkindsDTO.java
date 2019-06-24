package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TSlyzShipkindsDTO {

    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *船舶类型代码
    **/
    @JSONField(name="kindno")
    private String kindno;

    /**
     *船舶类型名称
    **/
    @JSONField(name="kindname")
    private String kindname;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getKindno() {
        return kindno;
    }

    public void setKindno(String kindno) {
        this.kindno = kindno;
    }

    public String getKindname() {
        return kindname;
    }

    public void setKindname(String kindname) {
        this.kindname = kindname;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}