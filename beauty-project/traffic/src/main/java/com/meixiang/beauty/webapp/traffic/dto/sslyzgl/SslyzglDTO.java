package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

//湖南省港口企业与码头单位吞吐量报表首页（参考首页的设计板块）
public class SslyzglDTO {

    //名称可为，行政区划，管理机构，许可申请记录等。。。
    @JSONField(name = "name")
    private String name;

    //二级名称，例如，行政区划，管理机构，申请机构，经营管理机构等。。
    @JSONField(name = "secondName")
    private String secondName;

    //二级名称对应的数据，例如，16个
    @JSONField(name = "secondValue")
    private String secondValue;

    //三级名称，例如，所在行政区划，机构等级，类型，船员适任证类型等。。。
    @JSONField(name = "thirdName")
    private String thirdName;

    //三级名称对应的数据，例如，10个或者5类
    @JSONField(name = "thirdValue")
    private String thirdValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(String secondValue) {
        this.secondValue = secondValue;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getThirdValue() {
        return thirdValue;
    }

    public void setThirdValue(String thirdValue) {
        this.thirdValue = thirdValue;
    }
}
