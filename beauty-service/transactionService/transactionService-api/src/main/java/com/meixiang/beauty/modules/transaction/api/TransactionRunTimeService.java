package com.meixiang.beauty.modules.transaction.api;

import java.io.UnsupportedEncodingException;

/**
 * Created by zbm84 on 2017/5/10.
 */
public interface TransactionRunTimeService {

    void autoConfirmReceiveProduct();

    void autoProcessUserAccount();

    void autoMonthlyIncomeCalc();

    void autoCalculateUserType() throws UnsupportedEncodingException;

    void autoProcessNoPayRecordData();
}
