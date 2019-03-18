package com.meixiang.beauty.modules.account.dao;

import com.meixiang.beauty.common.dto.account.IncomeRecordDTO;
import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.account.PayRecordDTO;
import com.meixiang.beauty.common.dto.transaction.MonthTransactionRecordDTO;
import com.meixiang.beauty.common.dto.transaction.TransactionDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by sunxiao on 2017/6/20.
 */
@MyBatisDao
@Repository
public interface IncomeRecordDao {


    List<IncomeRecordDTO> getUserIncomeInfoByDate(@Param("userId") String userId, @Param("date") Date date);

    void insertUserIncomeInfo(IncomeRecordDTO incomeRecordDTO);

    void updateIncomeInfo(IncomeRecordDTO incomeRecordDTO);

    List<IncomeRecordDTO> getUserIncomeInfo(IncomeRecordDTO incomeRecordDTO);

    /**
     * 根据条件查询提现信息
     * @param phoneAndIdentify
     * @param applyStartTime
     * @param applyEndTime
     * @param pageStartNo
     * @param pageSize
     * @return
     */
    List<IncomeRecordDTO> queryUserIncomeByParameters(@Param("phoneAndIdentify")String phoneAndIdentify,
                                                      @Param("incomeType")String incomeType,
                                                      @Param("createStartDate")String applyStartTime,
                                                      @Param("createEndDate")String applyEndTime,
                                                      @Param("pageStartNo")int pageStartNo,
                                                      @Param("pageSize")int pageSize);

    /**
     * 获取提现信息Count根据条件
     * @param phoneAndIdentify
     * @param applyStartTime
     * @param applyEndTime
     * @return
     */
    int queryUserIncomeCountByParameters(@Param("phoneAndIdentify")String phoneAndIdentify,
                                         @Param("incomeType")String incomeType,
                                         @Param("createStartDate")String applyStartTime,
                                         @Param("createEndDate")String applyEndTime);

    //查询所有提现信息
    Page<IncomeRecordDTO> queryAllUserIncome(Page<IncomeRecordDTO> page);

    List<IncomeRecordDTO> getUserIncomeRecordInfoByPage(@Param("userId") String userId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    IncomeRecordDTO getIncomeRecordDetail(@Param("transactionId") String transactionId);
    //查询即时返现和统计推荐下的订单详情
    List<PayRecordDTO> queryInstanceInfoByTransactionId(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO);

    //查询月结下的详情
    Page<MonthTransactionRecordDTO> queryMonthTransactionRecordByIncomeRecord(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO,Page<MonthTransactionRecordDTO> page);
    //审核用户收入的金额是否可提现
    void updateIncomeRecordStatusById(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO);

    //根据用户id查询这个月都消费了哪些订单
    Page<PayRecordDTO> queryMonthPayRecordByUserId(PageParamVoDTO<IncomeRecordDTO> pageParamVoDTO,Page<PayRecordDTO> page);
}
