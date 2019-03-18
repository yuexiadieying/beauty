package com.meixiang.beauty.modules.account;

import com.meixiang.beauty.common.dto.account.PrePayInfoDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by sunxiao on 2017/6/26.
 */
public interface PayRecordService {


    PrePayInfoDTO getPrepayInfo(HttpServletRequest request, HttpSession session, String productType);

    List<PayRecordDTO> getUserPayRecordList(PayRecordDTO payRecordDTO);

    void updatePayRecordStatus(PayRecordDTO payRecord);

    List<PayRecordDTO> getUserPayRecordListByDate(String userId, Date startDate, Date endDate);
}
