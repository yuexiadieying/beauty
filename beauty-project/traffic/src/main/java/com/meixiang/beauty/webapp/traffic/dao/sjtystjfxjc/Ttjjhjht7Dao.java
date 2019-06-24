package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht7DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjht7Dao {
    
    
    /**
     * 查询公路货物营运车辆拥有量数据总个数
     */
    Integer getTtjjhjht7Count();
    
    
    /**
     * 根据条件查询公路货物营运车辆拥有量数据总个数
     */
    Integer getTtjjhjht7CountByParams(@Param("info") String info);
    
    /**
     * 分页获取公路货物营运车辆拥有量数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht7DTO> getTtjjhjht7ByPageable(@Param("start") int start,
                                              @Param("end") int end);
    
    /**
     * 根据条件分页获取公路货物营运车辆拥有量数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht7DTO> getTtjjhjht7ByParamsPageable(@Param("start") int start,
                                                    @Param("end") int end,
                                                    @Param("info") String info);

}