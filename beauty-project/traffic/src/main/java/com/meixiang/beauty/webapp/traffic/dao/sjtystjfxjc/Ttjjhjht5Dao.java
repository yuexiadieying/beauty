package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht5DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjht5Dao {
    
    
    /**
     * 查询公路密度及通达情况数据总个数
     */
    Integer getTtjjhjht5Count();
    
    
    /**
     * 根据条件查询公路密度及通达情况数据总个数
     */
    Integer getTtjjhjht5CountByParams(@Param("info") String info);
    
    /**
     * 分页获取公路密度及通达情况数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht5DTO> getTtjjhjht5ByPageable(@Param("start") int start,
                                              @Param("end") int end);
    
    /**
     * 根据条件分页获取公路密度及通达情况数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht5DTO> getTtjjhjht5ByParamsPageable(@Param("start") int start,
                                                    @Param("end") int end,
                                                    @Param("info") String info);

}