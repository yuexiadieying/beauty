package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TSlyzShipsDTO {

    /**
     * 序列号
     **/
    @JSONField(name="serialNo")
    private Integer serialNo;

    /**
     *编号算法见ServerMaxNo说明
    **/
    @JSONField(name="shipno")
    private String shipno;

    /**
     *水运企业或个体业主编号
    **/
    @JSONField(name="enterpriseno")
    private String enterpriseno;

    /**
     *船检登记号，数字字母串
    **/
    @JSONField(name="shipcheckno")
    private String shipcheckno;

    /**
     *船舶登记号，数字串
    **/
    @JSONField(name="shipenrollno")
    private String shipenrollno;

    /**
     *船舶识别号，数字字母串
    **/
    @JSONField(name="shipidentifyno")
    private String shipidentifyno;

    /**
     *船籍港
    **/
    @JSONField(name="portname")
    private String portname;

    /**
     *船舶名称
    **/
    @JSONField(name="shipname")
    private String shipname;

    /**
     *曾用名
    **/
    @JSONField(name="shipoldname")
    private String shipoldname;

    /**
     *船舶类型编码
    **/
    @JSONField(name="kindno")
    private String kindno;

    /**
     *船舶标准类型
    **/
    @JSONField(name="standardkind")
    private String standardkind;

    /**
     *船舶材料
    **/
    @JSONField(name="material")
    private String material;

    /**
     *燃料类型
    **/
    @JSONField(name="fuel")
    private String fuel;

    /**
     *船舶总吨，默认0
    **/
    @JSONField(name="totalton")
    private Integer totalton;

    /**
     *总载重量，默认0
    **/
    @JSONField(name="totalcarry")
    private Integer totalcarry;

    /**
     *净载重量，默认0
    **/
    @JSONField(name="ton")
    private Integer ton;

    /**
     *车位数，默认0
    **/
    @JSONField(name="carplace")
    private Integer carplace;

    /**
     *载客量，默认0
    **/
    @JSONField(name="seat")
    private Integer seat;

    /**
     *箱位数，默认0
    **/
    @JSONField(name="teu")
    private Integer teu;

    /**
     *船舱容积立方米，默认0
    **/
    @JSONField(name="volume")
    private Double volume;

    /**
     *主机台数，默认为1
    **/
    @JSONField(name="motorcount")
    private Integer motorcount;

    /**
     *主机合计功率，默认0
    **/
    @JSONField(name="power")
    private Double power;

    /**
     *总长（米），默认0
    **/
    @JSONField(name="length")
    private Double length;

    /**
     *型宽（米），默认0
    **/
    @JSONField(name="width")
    private Double width;

    /**
     *满载吃水（米），默认0
    **/
    @JSONField(name="eatwater")
    private Double eatwater;

    /**
     *航速（节），默认0
    **/
    @JSONField(name="speed")
    private Double speed;

    /**
     *建成日期，默认null
    **/
    @JSONField(name="builddate")
    private Date builddate;

    /**
     *改建日期，默认null
    **/
    @JSONField(name="rebuilddate")
    private Date rebuilddate;

    /**
     *航区，默认内河
    **/
    @JSONField(name="voyagearea")
    private String voyagearea;

    /**
     *船旗国，默认中国
    **/
    @JSONField(name="nationkind")
    private String nationkind;

    /**
     *控制状态，默认自有
    **/
    @JSONField(name="controlstatus")
    private String controlstatus;

    /**
     *船舶所有人
    **/
    @JSONField(name="ownername")
    private String ownername;

    /**
     *船舶所有人电话
    **/
    @JSONField(name="ownertelephone")
    private String ownertelephone;

    /**
     *船舶管理人
    **/
    @JSONField(name="shipmanager")
    private String shipmanager;

    /**
     *船舶管理人许可证号
    **/
    @JSONField(name="shipmanagerxkzno")
    private String shipmanagerxkzno;

    /**
     *营运证制作机构编码
    **/
    @JSONField(name="yyzunitno")
    private String yyzunitno;

    /**
     *营运证号
    **/
    @JSONField(name="yyzno")
    private String yyzno;

    /**
     *营运证经营范围
    **/
    @JSONField(name="yyzrunkind")
    private String yyzrunkind;

    /**
     *制证日期，默认null
    **/
    @JSONField(name="yyzprintdate")
    private Date yyzprintdate;

    /**
     *有效截至期，默认null
    **/
    @JSONField(name="yyzenddate")
    private Date yyzenddate;

    /**
     *许可证有效截至日期（冗余）
    **/
    @JSONField(name="xkzenddate")
    private Date xkzenddate;

    /**
     *最近年审日期（冗余）
    **/
    @JSONField(name="nshgzdate")
    private Date nshgzdate;

    /**
     *最近年审结果（冗余）
    **/
    @JSONField(name="nshgzresult")
    private String nshgzresult;

    /**
     *最近变更日期（冗余）
    **/
    @JSONField(name="lastchangedate")
    private Date lastchangedate;

    /**
     *最近变更（冗余）
    **/
    @JSONField(name="lastchangekind")
    private String lastchangekind;

    /**
     *许可申请号
    **/
    @JSONField(name="applyno")
    private String applyno;

    /**
     *许可申请状态
    **/
    @JSONField(name="applystatus")
    private String applystatus;

    /**
     *简要说明
    **/
    @JSONField(name="shipnote")
    private String shipnote;

    @JSONField(name="createdate")
    private Date createdate;

    @JSONField(name="lastmodifydate")
    private Date lastmodifydate;

    @JSONField(name="shipdocno")
    private String shipdocno;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getShipno() {
        return shipno;
    }

    public void setShipno(String shipno) {
        this.shipno = shipno;
    }

    public String getEnterpriseno() {
        return enterpriseno;
    }

    public void setEnterpriseno(String enterpriseno) {
        this.enterpriseno = enterpriseno;
    }

    public String getShipcheckno() {
        return shipcheckno;
    }

    public void setShipcheckno(String shipcheckno) {
        this.shipcheckno = shipcheckno;
    }

    public String getShipenrollno() {
        return shipenrollno;
    }

    public void setShipenrollno(String shipenrollno) {
        this.shipenrollno = shipenrollno;
    }

    public String getShipidentifyno() {
        return shipidentifyno;
    }

    public void setShipidentifyno(String shipidentifyno) {
        this.shipidentifyno = shipidentifyno;
    }

    public String getPortname() {
        return portname;
    }

    public void setPortname(String portname) {
        this.portname = portname;
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname;
    }

    public String getShipoldname() {
        return shipoldname;
    }

    public void setShipoldname(String shipoldname) {
        this.shipoldname = shipoldname;
    }

    public String getKindno() {
        return kindno;
    }

    public void setKindno(String kindno) {
        this.kindno = kindno;
    }

    public String getStandardkind() {
        return standardkind;
    }

    public void setStandardkind(String standardkind) {
        this.standardkind = standardkind;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Integer getTotalton() {
        return totalton;
    }

    public void setTotalton(Integer totalton) {
        this.totalton = totalton;
    }

    public Integer getTotalcarry() {
        return totalcarry;
    }

    public void setTotalcarry(Integer totalcarry) {
        this.totalcarry = totalcarry;
    }

    public Integer getTon() {
        return ton;
    }

    public void setTon(Integer ton) {
        this.ton = ton;
    }

    public Integer getCarplace() {
        return carplace;
    }

    public void setCarplace(Integer carplace) {
        this.carplace = carplace;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getTeu() {
        return teu;
    }

    public void setTeu(Integer teu) {
        this.teu = teu;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Integer getMotorcount() {
        return motorcount;
    }

    public void setMotorcount(Integer motorcount) {
        this.motorcount = motorcount;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getEatwater() {
        return eatwater;
    }

    public void setEatwater(Double eatwater) {
        this.eatwater = eatwater;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Date getBuilddate() {
        return builddate;
    }

    public void setBuilddate(Date builddate) {
        this.builddate = builddate;
    }

    public Date getRebuilddate() {
        return rebuilddate;
    }

    public void setRebuilddate(Date rebuilddate) {
        this.rebuilddate = rebuilddate;
    }

    public String getVoyagearea() {
        return voyagearea;
    }

    public void setVoyagearea(String voyagearea) {
        this.voyagearea = voyagearea;
    }

    public String getNationkind() {
        return nationkind;
    }

    public void setNationkind(String nationkind) {
        this.nationkind = nationkind;
    }

    public String getControlstatus() {
        return controlstatus;
    }

    public void setControlstatus(String controlstatus) {
        this.controlstatus = controlstatus;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getOwnertelephone() {
        return ownertelephone;
    }

    public void setOwnertelephone(String ownertelephone) {
        this.ownertelephone = ownertelephone;
    }

    public String getShipmanager() {
        return shipmanager;
    }

    public void setShipmanager(String shipmanager) {
        this.shipmanager = shipmanager;
    }

    public String getShipmanagerxkzno() {
        return shipmanagerxkzno;
    }

    public void setShipmanagerxkzno(String shipmanagerxkzno) {
        this.shipmanagerxkzno = shipmanagerxkzno;
    }

    public String getYyzunitno() {
        return yyzunitno;
    }

    public void setYyzunitno(String yyzunitno) {
        this.yyzunitno = yyzunitno;
    }

    public String getYyzno() {
        return yyzno;
    }

    public void setYyzno(String yyzno) {
        this.yyzno = yyzno;
    }

    public String getYyzrunkind() {
        return yyzrunkind;
    }

    public void setYyzrunkind(String yyzrunkind) {
        this.yyzrunkind = yyzrunkind;
    }

    public Date getYyzprintdate() {
        return yyzprintdate;
    }

    public void setYyzprintdate(Date yyzprintdate) {
        this.yyzprintdate = yyzprintdate;
    }

    public Date getYyzenddate() {
        return yyzenddate;
    }

    public void setYyzenddate(Date yyzenddate) {
        this.yyzenddate = yyzenddate;
    }

    public Date getXkzenddate() {
        return xkzenddate;
    }

    public void setXkzenddate(Date xkzenddate) {
        this.xkzenddate = xkzenddate;
    }

    public Date getNshgzdate() {
        return nshgzdate;
    }

    public void setNshgzdate(Date nshgzdate) {
        this.nshgzdate = nshgzdate;
    }

    public String getNshgzresult() {
        return nshgzresult;
    }

    public void setNshgzresult(String nshgzresult) {
        this.nshgzresult = nshgzresult;
    }

    public Date getLastchangedate() {
        return lastchangedate;
    }

    public void setLastchangedate(Date lastchangedate) {
        this.lastchangedate = lastchangedate;
    }

    public String getLastchangekind() {
        return lastchangekind;
    }

    public void setLastchangekind(String lastchangekind) {
        this.lastchangekind = lastchangekind;
    }

    public String getApplyno() {
        return applyno;
    }

    public void setApplyno(String applyno) {
        this.applyno = applyno;
    }

    public String getApplystatus() {
        return applystatus;
    }

    public void setApplystatus(String applystatus) {
        this.applystatus = applystatus;
    }

    public String getShipnote() {
        return shipnote;
    }

    public void setShipnote(String shipnote) {
        this.shipnote = shipnote;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getLastmodifydate() {
        return lastmodifydate;
    }

    public void setLastmodifydate(Date lastmodifydate) {
        this.lastmodifydate = lastmodifydate;
    }

    public String getShipdocno() {
        return shipdocno;
    }

    public void setShipdocno(String shipdocno) {
        this.shipdocno = shipdocno;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}