package com.meixiang.beauty.webapp.traffic.dao.zhgj;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.webapp.traffic.dto.zhgj.TBusTopicGisHdDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@MyBatisDao
@Repository
public interface TBusTopicGisHdDao {
    
    
    /**
     * 查询进出站点表数据总个数
     */
    Integer getTBusTopicGisHdCount();
    
    
    /**
     * 根据条件查询进出站点表数据总个数
     */
    Integer getTBusTopicGisHdCountByParams(@Param("info") String info);
    
    /**
     * 分页获取进出站点表数据
	 * @param start
     * @param end
     */
    List<TBusTopicGisHdDTO> getTBusTopicGisHdByPageable(@Param("start") int start,
                                                        @Param("end") int end);
    
    /**
     * 根据条件分页获取进出站点表数据
	 * @param start
     * @param end
     */
    List<TBusTopicGisHdDTO> getTBusTopicGisHdByParamsPageable(@Param("start") int start,
                                                              @Param("end") int end,
                                                              @Param("info") String info);

}