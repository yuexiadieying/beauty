package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhgsgljc01DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhgsgljc01Dao {
    
    
    /**
     * 查询高速公路货物运输量旬报数据总个数
     */
    Integer getTtjjhgsgljc01Count();
    
    
    /**
     * 根据条件查询高速公路货物运输量旬报数据总个数
     */
    Integer getTtjjhgsgljc01CountByParams(@Param("info") String info);
    
    /**
     * 分页获取高速公路货物运输量旬报数据
	 * @param start
     * @param end
     */
    List<Ttjjhgsgljc01DTO> getTtjjhgsgljc01ByPageable(@Param("start") int start,
                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取高速公路货物运输量旬报数据
	 * @param start
     * @param end
     */
    List<Ttjjhgsgljc01DTO> getTtjjhgsgljc01ByParamsPageable(@Param("start") int start,
                                                            @Param("end") int end,
                                                            @Param("info") String info);

}