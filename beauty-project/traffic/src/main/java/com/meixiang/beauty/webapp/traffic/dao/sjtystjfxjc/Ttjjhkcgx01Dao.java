package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhkcgx01DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhkcgx01Dao {
    
    
    /**
     * 查询客运车辆更新表数据总个数
     */
    Integer getTtjjhkcgx01Count();
    
    
    /**
     * 根据条件查询客运车辆更新表数据总个数
     */
    Integer getTtjjhkcgx01CountByParams(@Param("info") String info);
    
    /**
     * 分页获取客运车辆更新表数据
	 * @param start
     * @param end
     */
    List<Ttjjhkcgx01DTO> getTtjjhkcgx01ByPageable(@Param("start") int start,
                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取客运车辆更新表数据
	 * @param start
     * @param end
     */
    List<Ttjjhkcgx01DTO> getTtjjhkcgx01ByParamsPageable(@Param("start") int start,
                                                        @Param("end") int end,
                                                        @Param("info") String info);

}