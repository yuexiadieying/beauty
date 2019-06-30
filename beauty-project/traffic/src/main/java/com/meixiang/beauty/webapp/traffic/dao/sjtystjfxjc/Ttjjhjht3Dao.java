package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht3DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjht3Dao {
    
    
    /**
     * 查询公路隧道年底到达数数据总个数
     */
    Integer getTtjjhjht3Count();
    
    
    /**
     * 根据条件查询公路隧道年底到达数数据总个数
     */
    Integer getTtjjhjht3CountByParams(@Param("info") String info);
    
    /**
     * 分页获取公路隧道年底到达数数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht3DTO> getTtjjhjht3ByPageable(@Param("start") int start,
                                              @Param("end") int end);
    
    /**
     * 根据条件分页获取公路隧道年底到达数数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht3DTO> getTtjjhjht3ByParamsPageable(@Param("start") int start,
                                                    @Param("end") int end,
                                                    @Param("info") String info);

}