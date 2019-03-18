package com.meixiang.beauty.modules.account.dao;

import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunxiao on 2017/6/20.
 */
@MyBatisDao
@Repository
public interface AccountDao {

    AccountDTO getUserAccountInfoByUserId(@Param("userId") String userId);

    /**
     * 查询所有用户及用户余额
     * @param pageParamDTO
     * @return
     */
    List<AccountDTO> queryAllUserBalance(PageParamDTO pageParamDTO);

    void updateUserAccountInfo(AccountDTO accountDTO);

    /**
     * 根据条件查询余额信息
     * @param phoneAndIdentify
     * @param pageStartNo
     * @param pageSize
     * @return
     */
    List<AccountDTO> queryUserBalanceByParameters(@Param("phoneAndIdentify")String phoneAndIdentify,
                                                  @Param("pageStartNo")int pageStartNo,
                                                  @Param("pageSize")int pageSize);

    /**
     * 查询条件总条数
     */
    Integer queryUserBalanceCountByParameters(@Param("phoneAndIdentify")String phoneAndIdentify);

    void insertUserAccountInfo(AccountDTO accountDTO);

    /**
     * 查询总条数
     * @return
     */
    int getAccountCount();

}
