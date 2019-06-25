package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhdlsy005ngdDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhdlsy005ngdDao {
    
    
    /**
     * 查询道路客货运站表数据总个数
     */
    Integer getTtjjhdlsy005ngdCount();
    
    
    /**
     * 根据条件查询道路客货运站表数据总个数
     */
    Integer getTtjjhdlsy005ngdCountByParams(@Param("info") String info);
    
    /**
     * 分页获取道路客货运站表数据
	 * @param start
     * @param end
     */
    List<Ttjjhdlsy005ngdDTO> getTtjjhdlsy005ngdByPageable(@Param("start") int start,
                                                          @Param("end") int end);
    
    /**
     * 根据条件分页获取道路客货运站表数据
	 * @param start
     * @param end
     */
    List<Ttjjhdlsy005ngdDTO> getTtjjhdlsy005ngdByParamsPageable(@Param("start") int start,
                                                                @Param("end") int end,
                                                                @Param("info") String info);

}