package com.meixiang.beauty.modules.account.impl;

import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.modules.account.AccountService;
import com.meixiang.beauty.modules.account.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created by sunxiao on 2017/6/26.
 */

@Service
@Transactional(readOnly = false)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public AccountDTO getUserAccountInfo(String userId) {
        AccountDTO accountDTO = accountDao.getUserAccountInfoByUserId(userId);
        return accountDTO;
    }

    @Override
    public PageParamDTO<List<AccountDTO>>  queryAllUserBalance(PageParamDTO pageParamDTO) {
        String phoneAndIdentify = "";
        int count = accountDao.queryUserBalanceCountByParameters(phoneAndIdentify);
        pageParamDTO.setTotalCount(count);
        List<AccountDTO> accountDTOList = accountDao.queryAllUserBalance(pageParamDTO);
        for(AccountDTO accountDTO : accountDTOList){
            try {
                accountDTO.setNickName(URLDecoder.decode(accountDTO.getNickName(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        pageParamDTO.setResponseData(accountDTOList);
        return pageParamDTO;
    }

    @Override
    public PageParamDTO<List<AccountDTO>> queryUserBalanceByParameters(String phoneAndIdentify, int pageNo, int pageSize) {
        PageParamDTO<List<AccountDTO>> page = new  PageParamDTO<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int pageStartNo = (pageNo-1)*pageSize;
        int count = accountDao.queryUserBalanceCountByParameters(phoneAndIdentify);
        page.setTotalCount(count);
        List<AccountDTO> accountDTOList = accountDao.queryUserBalanceByParameters(
                phoneAndIdentify,pageStartNo,pageSize);
        for(AccountDTO accountDTO : accountDTOList){
            try {
                accountDTO.setNickName(URLDecoder.decode(accountDTO.getNickName(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        page.setResponseData(accountDTOList);

        return page;
    }

    @Override
    public void createUserAccount(AccountDTO accountDTO) {
        accountDao.insertUserAccountInfo(accountDTO);
    }

    @Override
    public void updateUserAccountInfo(AccountDTO accountDTO) {
        accountDao.updateUserAccountInfo(accountDTO);
    }

}
