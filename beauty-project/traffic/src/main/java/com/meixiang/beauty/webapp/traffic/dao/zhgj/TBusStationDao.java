package com.meixiang.beauty.webapp.traffic.dao.zhgj;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.webapp.traffic.dto.zhgj.TBusStationDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@MyBatisDao
@Repository
public interface TBusStationDao {
    
    
    /**
     * 查询公交站点表数据总个数
     */
    Integer getTBusStationCount();
    
    
    /**
     * 根据条件查询公交站点表数据总个数
     */
    Integer getTBusStationCountByParams(@Param("info") String info);
    
    /**
     * 分页获取公交站点表数据
	 * @param start
     * @param end
     */
    List<TBusStationDTO> getTBusStationByPageable(@Param("start") int start,
                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取公交站点表数据
	 * @param start
     * @param end
     */
    List<TBusStationDTO> getTBusStationByParamsPageable(@Param("start") int start,
                                                        @Param("end") int end,
                                                        @Param("info") String info);

}