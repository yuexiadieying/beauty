package com.meixiang.beauty.webapp.traffic.dto.zhsy;

import com.alibaba.fastjson.annotation.JSONField;

//调查站信息
public class DczxxDataDTO {

    //年份
    @JSONField(name = "yearDate")
    private String yearDate;

    //调查站标识，布尔型，true标识有，false表示无
    @JSONField(name = "tczbs")
    private boolean tczbs;

    //管理机构标识，布尔型，true标识有，false表示无
    @JSONField(name = "gljgbs")
    private boolean gljgbs;

    //路线标识，布尔型，true标识有，false表示无
    @JSONField(name = "lxbs")
    private boolean lxbs;

    public String getYearDate() {
        return yearDate;
    }

    public void setYearDate(String yearDate) {
        this.yearDate = yearDate;
    }

    public boolean isTczbs() {
        return tczbs;
    }

    public void setTczbs(boolean tczbs) {
        this.tczbs = tczbs;
    }

    public boolean isGljgbs() {
        return gljgbs;
    }

    public void setGljgbs(boolean gljgbs) {
        this.gljgbs = gljgbs;
    }

    public boolean isLxbs() {
        return lxbs;
    }

    public void setLxbs(boolean lxbs) {
        this.lxbs = lxbs;
    }
}
