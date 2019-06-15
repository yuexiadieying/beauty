package com.meixiang.beauty.webapp.traffic.dto.sslyzgl;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

public class TSlyzExitenterpriserecordsDTO {

    /**
     *编号算法见ServerMaxNo说明，共享ChangeNo
    **/
    @JSONField(name="exitno")
    private String exitno;

    /**
     *企业（含个体与服务业）编号
    **/
    @JSONField(name="enterpriseno")
    private String enterpriseno;

    /**
     *经营者类别
    **/
    @JSONField(name="enterprisekind")
    private String enterprisekind;

    /**
     *经营者名称
    **/
    @JSONField(name="enterprisename")
    private String enterprisename;

    /**
     *经营者地址
    **/
    @JSONField(name="address")
    private String address;

    /**
     *法人代表
    **/
    @JSONField(name="lawman")
    private String lawman;

    /**
     *许可证编号
    **/
    @JSONField(name="xkzno")
    private String xkzno;

    /**
     *最近发证日期
    **/
    @JSONField(name="xkzprintdate")
    private Date xkzprintdate;

    /**
     *经营范围分类
    **/
    @JSONField(name="runkinds")
    private String runkinds;

    /**
     *管理机构
    **/
    @JSONField(name="unitno")
    private String unitno;

    /**
     *注销原因
    **/
    @JSONField(name="exitkind")
    private String exitkind;

    /**
     *退出日期
    **/
    @JSONField(name="exitdate")
    private Date exitdate;

    /**
     *简要说明
    **/
    @JSONField(name="exitnote")
    private String exitnote;

    /**
     *台账档案号
    **/
    @JSONField(name="docno")
    private String docno;

    @JSONField(name="createdate")
    private Date createdate;

    /**
     *加载时间
    **/
    @JSONField(name="insertDate")
    private Date insertDate;

    public String getExitno() {
        return exitno;
    }

    public void setExitno(String exitno) {
        this.exitno = exitno;
    }

    public String getEnterpriseno() {
        return enterpriseno;
    }

    public void setEnterpriseno(String enterpriseno) {
        this.enterpriseno = enterpriseno;
    }

    public String getEnterprisekind() {
        return enterprisekind;
    }

    public void setEnterprisekind(String enterprisekind) {
        this.enterprisekind = enterprisekind;
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLawman() {
        return lawman;
    }

    public void setLawman(String lawman) {
        this.lawman = lawman;
    }

    public String getXkzno() {
        return xkzno;
    }

    public void setXkzno(String xkzno) {
        this.xkzno = xkzno;
    }

    public Date getXkzprintdate() {
        return xkzprintdate;
    }

    public void setXkzprintdate(Date xkzprintdate) {
        this.xkzprintdate = xkzprintdate;
    }

    public String getRunkinds() {
        return runkinds;
    }

    public void setRunkinds(String runkinds) {
        this.runkinds = runkinds;
    }

    public String getUnitno() {
        return unitno;
    }

    public void setUnitno(String unitno) {
        this.unitno = unitno;
    }

    public String getExitkind() {
        return exitkind;
    }

    public void setExitkind(String exitkind) {
        this.exitkind = exitkind;
    }

    public Date getExitdate() {
        return exitdate;
    }

    public void setExitdate(Date exitdate) {
        this.exitdate = exitdate;
    }

    public String getExitnote() {
        return exitnote;
    }

    public void setExitnote(String exitnote) {
        this.exitnote = exitnote;
    }

    public String getDocno() {
        return docno;
    }

    public void setDocno(String docno) {
        this.docno = docno;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

}