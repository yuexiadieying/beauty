package com.meixiang.beauty.common.dto.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class WithDrawRecordDTO {

    /**
     * 提现id
     */
    @JSONField(name = "id")
    private String id;

    /**
     * 用户系统id
     */
    @JSONField(name = "sysUserId")
    private String sysUserId;

    /**
     *
     */
    @JSONField(name = "userOpenId")
    private String userOpenId;

    /**
     * 用户账户id
     */
    @JSONField(name = "userAccountId")
    private String userAccountId;

    /**
     * 提现金额
     */
    @JSONField(name = "moneyAmount")
    private float moneyAmount;

    /**
     * 提现状态，0表示未审核，1表示审核通过，2表示审核拒绝
     */
    @JSONField(name = "status")
    private String status;

    /**
     * 提现申请创建时间
     */
    @JSONField(name = "createDate")
    private Date createDate;

    /**
     * 交易流水号
     */
    @JSONField(name = "withdrawId")
    private String withdrawId;

    /**
     * 提现申请更新时间
     */
    @JSONField(name = "updateDate")
    private Date updateDate;

    /**
     * 用户名
     */
    @JSONField(name = "nickName")
    private String nickName;

    /**
     * 手机号
     */
    @JSONField(name = "mobile")
    private String mobile;

    /**
     * 身份证号
     */
    @JSONField(name = "identifyNumber")
    private String identifyNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    public float getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(float moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getWithdrawId() {
        return withdrawId;
    }

    public void setWithdrawId(String withdrawId) {
        this.withdrawId = withdrawId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}