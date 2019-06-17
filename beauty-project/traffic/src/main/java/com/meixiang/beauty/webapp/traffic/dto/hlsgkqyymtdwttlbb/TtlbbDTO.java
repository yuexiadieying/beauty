package com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb;

import com.alibaba.fastjson.annotation.JSONField;

//湖南省港口企业与码头单位吞吐量报表首页（参考首页的设计板块）
public class TtlbbDTO {

    //名称可为，全省泊位表，港口企业和码头单位名录，企业操作人员，全省刚去代码表等。。。
    @JSONField(name = "name")
    private String name;

    //二级名称，例如，行政区，所在机构，港口，刚去，泊位等。。
    @JSONField(name = "secondName")
    private String secondName;

    //二级名称对应的数据，例如，16个
    @JSONField(name = "secondValue")
    private String secondValue;

    //三级名称，例如，机构，人员，港口管理单位，港区管理单位等。。。
    @JSONField(name = "thirdName")
    private String thirdName;

    //三级名称对应的数据，例如，10个
    @JSONField(name = "thirdValue")
    private String thirdValue;

    //四级名称，例如，机构，人员，港口管理单位，港区管理单位等。。。
    @JSONField(name = "fourthName")
    private String fourthName;

    //四级名称对应的数据，例如，10个
    @JSONField(name = "fourthValue")
    private String fourthValue;

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

    public String getFourthName() {
        return fourthName;
    }

    public void setFourthName(String fourthName) {
        this.fourthName = fourthName;
    }

    public String getFourthValue() {
        return fourthValue;
    }

    public void setFourthValue(String fourthValue) {
        this.fourthValue = fourthValue;
    }
}
