package com.meixiang.beauty.webapp.vehicle.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@MyBatisDao
@Repository
public interface ApprovalDao {

    List<Map> getCheLiangList(String yesterday);

    List<Map> getJiaShiYuanTaiZhangList(String yesterday);

    List<Map> getYeHuList(String yesterday);

    void saveCheLiangList(Map map);

    void saveJiaShiYuanTaiZhangList(Map map);

    void saveYeHuList(Map map);

    void saveFailData(Map map);
}
