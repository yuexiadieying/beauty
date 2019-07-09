package com.meixiang.beauty.webapp.traffic.dto.system;

import com.alibaba.fastjson.annotation.JSONField;

public class DepartmentDTO {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "departmentName")
    private String departmentName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
