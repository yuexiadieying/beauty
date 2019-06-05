package com.meixiang.beauty.webapp.traffic.dao;

import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface AccountDao {

    void updateUserAccountInfo(AccountDTO accountDTO);

    /**
     * 根据条件查询余额信息
     * @param phoneAndIdentify
     * @param pageStartNo
     * @param pageSize
     * @return
     */
    List<AccountDTO> queryUserBalanceByParameters(@Param("phoneAndIdentify") String phoneAndIdentify,
                                                  @Param("pageStartNo") int pageStartNo,
                                                  @Param("pageSize") int pageSize);

    void insertUserAccountInfo(AccountDTO accountDTO);

}
