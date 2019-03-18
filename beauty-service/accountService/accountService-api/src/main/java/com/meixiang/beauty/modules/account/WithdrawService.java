package com.meixiang.beauty.modules.account;

import com.meixiang.beauty.common.dto.account.WithDrawRecordDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.UserBankCardInfoDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface WithdrawService {

    /**
     * 修改体提现状态
     */
    void updateWithdrawById(PageParamDTO<WithDrawRecordDTO> pageParamDTO);

    /**
     * 根据条件查询提现信息
     * @param phoneAndIdentify
     * @param applyStartTime
     * @param applyEndTime
     * @param updateStartTime
     * @param updateEndTime
     * @return
     */
    PageParamDTO<List<WithDrawRecordDTO>> queryWithdrawsByParameters(String phoneAndIdentify, String applyStartTime, String applyEndTime, String updateStartTime, String updateEndTime,int pageNo,int pageSize);

    void withDrawMoneyFromAccount(float moneyAmount, HttpServletRequest request, String openid, UserBankCardInfoDTO userBankCardInfoDTO) throws Exception;

    /**
     * 分页查询所有提现信息
     * @param pageParamDTO
     * @return
     */
    PageParamDTO<List<WithDrawRecordDTO>> queryAllWithdraw(PageParamDTO pageParamDTO);


    List<WithDrawRecordDTO> getWithdrawInfoByPage(String userId, PageParamDTO pageParamDTO);

    WithDrawRecordDTO getWithdrawDetail(String transactionId);

}
