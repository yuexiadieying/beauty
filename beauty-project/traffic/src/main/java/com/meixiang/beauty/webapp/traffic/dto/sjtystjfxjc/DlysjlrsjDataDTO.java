package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;

//道路从业人员数据
public class DlysjlrsjDataDTO {

    //名称
    @JSONField(name = "name")
    private String name;

    //达标率
    @JSONField(name = "dbl")
    private String dbl;

    //月环比
    @JSONField(name = "yhb")
    private String yhb;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDbl() {
        return dbl;
    }

    public void setDbl(String dbl) {
        this.dbl = dbl;
    }

    public String getYhb() {
        return yhb;
    }

    public void setYhb(String yhb) {
        this.yhb = yhb;
    }
}
