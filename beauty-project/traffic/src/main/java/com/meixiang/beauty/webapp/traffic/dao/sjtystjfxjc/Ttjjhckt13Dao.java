package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhckt13DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhckt13Dao {
    
    
    /**
     * 查询城市客运主要统计指标快速年报数据总个数
     */
    Integer getTtjjhckt13Count();
    
    
    /**
     * 根据条件查询城市客运主要统计指标快速年报数据总个数
     */
    Integer getTtjjhckt13CountByParams(@Param("info") String info);
    
    /**
     * 分页获取城市客运主要统计指标快速年报数据
	 * @param start
     * @param end
     */
    List<Ttjjhckt13DTO> getTtjjhckt13ByPageable(@Param("start") int start,
                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取城市客运主要统计指标快速年报数据
	 * @param start
     * @param end
     */
    List<Ttjjhckt13DTO> getTtjjhckt13ByParamsPageable(@Param("start") int start,
                                                      @Param("end") int end,
                                                      @Param("info") String info);

    /**
     * 城市客运主要统计指标快速年报信息
     * @param year
     */
    List<Ttjjhckt13DTO> getCityPassengerTrafficStatisticInfo(@Param("year") String year);


}