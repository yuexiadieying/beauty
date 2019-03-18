package com.meixiang.beauty.modules.account.dao;

import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.account.WithDrawRecordDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.transaction.TransactionDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface WithdrawDao {
    /**
     * 查询所有提现信息
     * @param
     * @return
     */
    Page<WithDrawRecordDTO> queryAllWithdraw(Page<WithDrawRecordDTO> page);

    void addWithDrawRecord(WithDrawRecordDTO withDrawRecordDTO);

    /**
     * 修改提现状态
     * @param withdrawId
     * @param status
     */
    void updateWithdrawById(@Param("withdrawId") String withdrawId, @Param("status")String status);

    /**
     * 根据条件查询提现信息
     * @param phoneAndIdentify
     * @param applyStartTime
     * @param applyEndTime
     * @param updateStartTime
     * @param updateEndTime
     * @return
     */
    List<WithDrawRecordDTO> queryWithdrawsByParameters(@Param("phoneAndIdentify")String phoneAndIdentify,
                                                       @Param("applyStartTime")String applyStartTime,
                                                       @Param("applyEndTime")String applyEndTime,
                                                       @Param("updateStartTime")String updateStartTime,
                                                       @Param("updateEndTime")String updateEndTime,
                                                       @Param("pageStartNo")int pageStartNo,
                                                       @Param("pageSize")int pageSize);
    /**
     * 查询条件总条数
     */
    Integer queryWithdrawsCountByParameters(@Param("phoneAndIdentify")String phoneAndIdentify,
                                            @Param("applyStartTime")String applyStartTime,
                                            @Param("applyEndTime")String applyEndTime,
                                            @Param("updateStartTime")String updateStartTime,
                                            @Param("updateEndTime")String updateEndTime);
    /**
     * 查询总条数
     */
    //Integer getWithdrawCount();

    List<WithDrawRecordDTO> getWithdrawInfoByPage(@Param("userId") String userId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    WithDrawRecordDTO getWithdrawDetail(@Param("withDrawId") String transactionId);
}
