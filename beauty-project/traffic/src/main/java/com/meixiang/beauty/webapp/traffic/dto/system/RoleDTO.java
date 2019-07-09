package com.meixiang.beauty.webapp.traffic.dto.system;

import com.alibaba.fastjson.annotation.JSONField;

public class RoleDTO {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "roleName")
    private String roleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
