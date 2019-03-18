package com.meixiang.beauty.modules.account;

import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.account.IncomeRecordDTO;
import com.meixiang.beauty.common.dto.transaction.MonthTransactionRecordDTO;
import com.meixiang.beauty.common.persistence.Page;

import java.util.Date;
import java.util.List;

/**
 * Created by sunxiao on 2017/6/26.
 */
public interface IncomeRecordService {

    List<IncomeRecordDTO> getUserIncomeInfoByDate(String userId, Date date);

    void insertUserIncomeInfo(IncomeRecordDTO incomeRecordDTO);

    void updateIncomeInfo(IncomeRecordDTO incomeRecordDTO);

    List<IncomeRecordDTO> getUserIncomeRecordInfo(IncomeRecordDTO incomeRecordDTO);

    /**
     * 根据条件查询提成信息
     * @param phoneAndIdentify
     * @param applyStartTime
     * @param applyEndTime
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageParamDTO<List<IncomeRecordDTO>> queryUserIncomeByParameters(String phoneAndIdentify,String incomeType, String applyStartTime, String applyEndTime, Integer pageNo, Integer pageSize);

    PageParamDTO<List<IncomeRecordDTO>> queryAllUserIncome(PageParamDTO pageParamDTO);

    List<IncomeRecordDTO> getUserIncomeRecordInfoByPage(String userId, PageParamDTO pageParamDTO);

    IncomeRecordDTO getIncomeRecordDetail(String transactionId);
    //查询即时返现和统计推荐下的订单详情
    PageParamDTO<List<PayRecordDTO>> queryInstanceInfoByTransactionId(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO);

    //查询月结下的详情
    PageParamDTO<List<MonthTransactionRecordDTO>> queryMonthTransactionRecordByIncomeRecord(PageParamVoDTO<IncomeRecordDTO> page);
    //根据用户id查询这个月都消费了哪些订单
    PageParamDTO<List<PayRecordDTO>> queryMonthPayRecordByUserId(PageParamVoDTO<IncomeRecordDTO> page);
    //审核用户收入金额是否可以提现
    void updateIncomeRecordStatusById(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO);

}
