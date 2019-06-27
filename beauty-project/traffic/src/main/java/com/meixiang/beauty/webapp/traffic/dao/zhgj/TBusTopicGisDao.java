package com.meixiang.beauty.webapp.traffic.dao.zhgj;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.webapp.traffic.dto.zhgj.TBusTopicGisDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@MyBatisDao
@Repository
public interface TBusTopicGisDao {
    
    
    /**
     * 查询车辆位置表数据总个数
     */
    Integer getTBusTopicGisCount();
    
    
    /**
     * 根据条件查询车辆位置表数据总个数
     */
    Integer getTBusTopicGisCountByParams(@Param("info") String info);
    
    /**
     * 分页获取车辆位置表数据
	 * @param start
     * @param end
     */
    List<TBusTopicGisDTO> getTBusTopicGisByPageable(@Param("start") int start,
                                                    @Param("end") int end);
    
    /**
     * 根据条件分页获取车辆位置表数据
	 * @param start
     * @param end
     */
    List<TBusTopicGisDTO> getTBusTopicGisByParamsPageable(@Param("start") int start,
                                                          @Param("end") int end,
                                                          @Param("info") String info);

    /**
     * 根据条件获取车辆位置表数据
     * @param date 日期 yyyymmdd
     * @param info 车牌
     */
    List<TBusTopicGisDTO> getTBusTopicGisInfo(@Param("date") String date,
                                                          @Param("info") String info);

}