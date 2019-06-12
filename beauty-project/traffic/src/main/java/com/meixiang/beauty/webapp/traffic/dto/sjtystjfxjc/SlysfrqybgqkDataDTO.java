package com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc;

import com.alibaba.fastjson.annotation.JSONField;

//水路运输法人企业变更情况
public class SlysfrqybgqkDataDTO {

    //名称
    @JSONField(name = "name")
    private String name;

    //更新情况
    @JSONField(name = "gxqk")
    private String gxqk;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGxqk() {
        return gxqk;
    }

    public void setGxqk(String gxqk) {
        this.gxqk = gxqk;
    }
}
