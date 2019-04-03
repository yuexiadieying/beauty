package com.meixiang.beauty.webapp.vehicle.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface TransportDao {

    List<Map> getDataList(@Param("table") String table, @Param("start") int start, @Param("end") int end);

    void insert_T_CheLiangJiBenXinXi(Map map);

    void insert_T_CheLiangJiBenXinXiBatch(List list);
    void insert_personBatch(@Param("list") List list);
}
