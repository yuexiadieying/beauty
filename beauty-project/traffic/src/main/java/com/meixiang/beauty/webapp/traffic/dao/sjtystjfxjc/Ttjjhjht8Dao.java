package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht8DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjht8Dao {
    
    
    /**
     * 查询水路运输工具拥有量数据总个数
     */
    Integer getTtjjhjht8Count();
    
    
    /**
     * 根据条件查询水路运输工具拥有量数据总个数
     */
    Integer getTtjjhjht8CountByParams(@Param("info") String info);
    
    /**
     * 分页获取水路运输工具拥有量数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht8DTO> getTtjjhjht8ByPageable(@Param("start") int start,
                                              @Param("end") int end);
    
    /**
     * 根据条件分页获取水路运输工具拥有量数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht8DTO> getTtjjhjht8ByParamsPageable(@Param("start") int start,
                                                    @Param("end") int end,
                                                    @Param("info") String info);

}