package com.meixiang.beauty.common.dto.transaction;

import com.alibaba.fastjson.annotation.JSONField;
import com.meixiang.beauty.common.dto.product.ProductDTO;

import java.util.Date;

/**
 * Created by zbm84 on 2017/8/3.
 */
public class BusinessOrderDTO {

    //订单编号ID
    @JSONField(name = "businessOrderId")
    private String businessOrderId;

    //用户id
    @JSONField(name = "sysUserId")
    private String sysUserId;

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

    //支付时间
    @JSONField(name = "payDate")
    private Date payDate;

    //变更时间
    @JSONField(name = "updateDate")
    private Date updateDate;

    //订单状态
    @JSONField(name = "status")
    private String status;



    @JSONField(name = "id")
    private String id;


    //订单地址id
    @JSONField(name = "userOrderAddressId")
    private String userOrderAddressId;
    //订单商品id
    @JSONField(name = "businessProductId")
    private String businessProductId;
    //订单类型
    @JSONField(name = "type")
    private String type;

    //创建时间
    @JSONField(name = "createDate")
    private Date createDate;

    //商品数量
    @JSONField(name = "businessProductNum")
    private int businessProductNum;
    //商品名字
    @JSONField(name = "businessProductName")
    private String businessProductName;
    //商品图片url
    @JSONField(name = "businessProductFirstUrl")
    private String businessProductFirstUrl;
    //商品价格
    @JSONField(name = "businessProductPrice")
    private float businessProductPrice;
    //此订单订单价格
    @JSONField(name = "amount")
    private String amount;


    //收货人姓名
    @JSONField(name = "userNameAddress")
    private String userNameAddress;
    //收货人联系方式
    @JSONField(name = "userPhoneAddress")
    private String userPhoneAddress;
    //收货地址
    @JSONField(name = "userAddress")
    private String userAddress;


    //商品型号
    @JSONField(name = "productSpec")
    private String productSpec;



    /**
     * 身份证号
     */
    @JSONField(name = "identifyNumber")
    private String identifyNumber;



    //支付状态
//    @JSONField(name = "payStatus")
//    private String payStatus;

    @JSONField(name = "senderAddress")
    private String senderAddress;

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

    public String getBusinessOrderId() {
        return businessOrderId;
    }

    public void setBusinessOrderId(String businessOrderId) {
        this.businessOrderId = businessOrderId;
    }

    public String getUserOrderAddressId() {
        return userOrderAddressId;
    }

    public void setUserOrderAddressId(String userOrderAddressId) {
        this.userOrderAddressId = userOrderAddressId;
    }

    public String getBusinessProductId() {
        return businessProductId;
    }

    public void setBusinessProductId(String businessProductId) {
        this.businessProductId = businessProductId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getBusinessProductNum() {
        return businessProductNum;
    }

    public void setBusinessProductNum(int businessProductNum) {
        this.businessProductNum = businessProductNum;
    }

    public String getBusinessProductName() {
        return businessProductName;
    }

    public void setBusinessProductName(String businessProductName) {
        this.businessProductName = businessProductName;
    }

    public String getBusinessProductFirstUrl() {
        return businessProductFirstUrl;
    }

    public void setBusinessProductFirstUrl(String businessProductFirstUrl) {
        this.businessProductFirstUrl = businessProductFirstUrl;
    }

    public float getBusinessProductPrice() {
        return businessProductPrice;
    }

    public void setBusinessProductPrice(float businessProductPrice) {
        this.businessProductPrice = businessProductPrice;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUserNameAddress() {
        return userNameAddress;
    }

    public void setUserNameAddress(String userNameAddress) {
        this.userNameAddress = userNameAddress;
    }

    public String getUserPhoneAddress() {
        return userPhoneAddress;
    }

    public void setUserPhoneAddress(String userPhoneAddress) {
        this.userPhoneAddress = userPhoneAddress;
    }

//    public String getPayStatus() {
//        return payStatus;
//    }
//
//    public void setPayStatus(String payStatus) {
//        this.payStatus = payStatus;
//    }
}
