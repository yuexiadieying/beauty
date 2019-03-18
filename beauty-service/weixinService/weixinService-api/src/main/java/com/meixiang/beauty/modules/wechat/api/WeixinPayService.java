package com.meixiang.beauty.modules.wechat.api;

import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 微信关注服务接口
 * @author wangbaowei
 * @date 2015-11-04
 */

@Service
@Transactional(readOnly = false)
public interface WeixinPayService {

	void handleOfflineProductPayNotifyInfo(String accountPay, PayRecordDTO payRecordDTO);

	void handleTrainingProductPayNotifyInfo(String accountNeedPay, PayRecordDTO payRecordDTO);
}
