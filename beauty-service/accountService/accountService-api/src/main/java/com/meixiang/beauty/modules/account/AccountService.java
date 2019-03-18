package com.meixiang.beauty.modules.account;

import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sunxiao on 2017/6/26.
 */
public interface AccountService {

    AccountDTO getUserAccountInfo(String userId);

    /**
     * 查询所有用户及账户余额余额
     * @param pageParamDTO
     * @return
     */
    PageParamDTO<List<AccountDTO>> queryAllUserBalance(PageParamDTO pageParamDTO);

    /**
     * 根据条件查询余额信息
     * @param phoneAndIdentify
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageParamDTO<List<AccountDTO>> queryUserBalanceByParameters(String phoneAndIdentify, int pageNo, int pageSize);

    void createUserAccount(AccountDTO accountDTO);

    void updateUserAccountInfo(AccountDTO accountDTO);
}
