package com.meixiang.beauty.modules.account.dao;

import com.meixiang.beauty.common.dto.account.PayRecordDTO;
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
public interface PayRecordDao {

    void insertPayRecord(PayRecordDTO payRecordDTO);

    List<PayRecordDTO> getUserPayRecordList(PayRecordDTO payRecordDTO);

    void updatePayRecordStatus(PayRecordDTO payRecord);

    List<PayRecordDTO> getPayRecordInfo(PayRecordDTO payRecordDTO);

    int queryPayRecordCountByParameters(@Param("transactionIdOrOrderId")String transactionIdOrOrderId, @Param("applyStartTime")String applyStartTime, @Param("applyEndTime")String applyEndTime, @Param("updateStartTime")String updateStartTime, @Param("updateEndTime")String updateEndTime);

    List<PayRecordDTO> queryPayRecordsByParameters(@Param("transactionIdOrOrderId")String transactionIdOrOrderId,
                                                   @Param("applyStartTime")String applyStartTime,
                                                   @Param("applyEndTime")String applyEndTime,
                                                   @Param("updateStartTime")String updateStartTime,
                                                   @Param("updateEndTime")String updateEndTime,
                                                   @Param("pageStartNo")int pageStartNo,
                                                   @Param("pageSize")int pageSize);

    List<PayRecordDTO> getUserPayRecordListByDate(@Param("userId")String userId,
                                                  @Param("startDate")Date startDate,
                                                  @Param("endDate")Date endDate);
}
