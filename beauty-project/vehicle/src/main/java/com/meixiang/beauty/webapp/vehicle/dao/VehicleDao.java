package com.meixiang.beauty.webapp.vehicle.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface VehicleDao {

    public List<Map> getCheLiangList(String yesterday);

    public List<Map> getJiaShiYuanTaiZhangList(String yesterday);

    public List<Map> getYeHuList(String yesterday);

    public void saveCheLiangList(Map map);

    public void saveJiaShiYuanTaiZhangList(Map map);

    public void saveYeHuList(Map map);

    void saveFailData(Map map);

}
