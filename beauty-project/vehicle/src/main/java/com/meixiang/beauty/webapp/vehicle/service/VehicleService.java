package com.meixiang.beauty.webapp.vehicle.service;

import com.meixiang.beauty.webapp.vehicle.dao.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VehicleService {

    @Autowired
    VehicleDao vehicleDao;

    public List<Map> getCheLiangList(String yesterday){
        return vehicleDao.getCheLiangList(yesterday);
    }

    public List<Map> getJiaShiYuanTaiZhangList(String yesterday){
        return vehicleDao.getJiaShiYuanTaiZhangList(yesterday);
    }

    public List<Map> getYeHuList(String yesterday){
        return vehicleDao.getYeHuList(yesterday);
    }

    public void saveCheLiangList(Map map){
        vehicleDao.saveCheLiangList(map);
    }

    public void saveJiaShiYuanTaiZhangList(Map map){
        vehicleDao.saveJiaShiYuanTaiZhangList(map);
    }

    public void saveYeHuList(Map map){
        vehicleDao.saveYeHuList(map);
    }

    public void saveFailData(Map map){
        vehicleDao.saveFailData(map);
    }
}
