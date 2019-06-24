package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht2DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjht2Dao {
    
    
    /**
     * 查询T_TJJH_JHT2数据总个数
     */
    Integer getTtjjhjht2Count();
    
    
    /**
     * 根据条件查询T_TJJH_JHT2数据总个数
     */
    Integer getTtjjhjht2CountByParams(@Param("info") String info);
    
    /**
     * 分页获取T_TJJH_JHT2数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht2DTO> getTtjjhjht2ByPageable(@Param("start") int start,
                                              @Param("end") int end);
    
    /**
     * 根据条件分页获取T_TJJH_JHT2数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht2DTO> getTtjjhjht2ByParamsPageable(@Param("start") int start,
                                                    @Param("end") int end,
                                                    @Param("info") String info);

}