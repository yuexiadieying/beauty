package com.meixiang.beauty.webapp.traffic.service;

import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.webapp.traffic.dao.AccountDao;
import com.meixiang.beauty.webapp.traffic.dto.DeviceParamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotSocketService {

    @Autowired
    private AccountDao accountDao;

    public List<DeviceParamDTO> getRobotSocketService() {
        AccountDTO accountDTO = new AccountDTO();
        accountDao.insertUserAccountInfo(accountDTO);
        return null;
    }

}
