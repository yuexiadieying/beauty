package com.meixiang.beauty.webapp.traffic.dto.zhgj;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TBusVehicleDTO {


    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *修改人
    **/
    @JSONField(name="lastModifier")
    private String lastModifier;

    /**
     *修改时间
    **/
    @JSONField(name="lastModifiedTime")
    private String lastModifiedTime;

    /**
     *创建人
    **/
    @JSONField(name="creator")
    private String creator;

    /**
     *备注
    **/
    @JSONField(name="remark")
    private String remark;

    /**
     *系统标识
    **/
    @JSONField(name="sysFlag")
    private char sysFlag;

    /**
     *所属公司名称
    **/
    @JSONField(name="departmentName")
    private String departmentName;

    /**
     *所属公司id
    **/
    @JSONField(name="departmentId")
    private String departmentId;

    /**
     *线路名称
    **/
    @JSONField(name="routeName")
    private String routeName;

    /**
     *线路id
    **/
    @JSONField(name="routeId")
    private String routeId;

    /**
     *车辆名称
    **/
    @JSONField(name="name")
    private String name;

    /**
     *车牌号
    **/
    @JSONField(name="licensePlate")
    private String licensePlate;

    /**
     *设备id
    **/
    @JSONField(name="onBoardid")
    private String onBoardid;

    /**
     *车辆id
    **/
    @JSONField(name="id")
    private String id;

    /**
     *主键
    **/
    @JSONField(name="pid")
    private String pid;

    /**
     *创建时间
    **/
    @JSONField(name="createTime")
    private String createTime;

    public String getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public char getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(char sysFlag) {
        this.sysFlag = sysFlag;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getOnBoardid() {
        return onBoardid;
    }

    public void setOnBoardid(String onBoardid) {
        this.onBoardid = onBoardid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}