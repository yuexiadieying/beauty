package com.meixiang.beauty.webapp.vehicle.service;

import com.meixiang.beauty.webapp.vehicle.dao.ApprovalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApprovalService {

    @Autowired
    ApprovalDao approvalDao;

    public List<Map> getCheLiangList(String yesterday){
        return approvalDao.getCheLiangList(yesterday);
    }

    public List<Map> getJiaShiYuanTaiZhangList(String yesterday){
        return approvalDao.getJiaShiYuanTaiZhangList(yesterday);
    }

    public List<Map> getYeHuList(String yesterday){
        return approvalDao.getYeHuList(yesterday);
    }

    public void saveCheLiangList(Map map){
        approvalDao.saveCheLiangList(map);
    }

    public void saveJiaShiYuanTaiZhangList(Map map){
        approvalDao.saveJiaShiYuanTaiZhangList(map);
    }

    public void saveYeHuList(Map map){
        approvalDao.saveYeHuList(map);
    }

    public void saveFailData(Map map){
        approvalDao.saveFailData(map);
    }
}
