package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtt3DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjtt3Dao {
    
    
    /**
     * 查询交通固定资产投资新增生产能力快报表数据总个数
     */
    Integer getTtjjhjtt3Count();
    
    
    /**
     * 根据条件查询交通固定资产投资新增生产能力快报表数据总个数
     */
    Integer getTtjjhjtt3CountByParams(@Param("info") String info);
    
    /**
     * 分页获取交通固定资产投资新增生产能力快报表数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtt3DTO> getTtjjhjtt3ByPageable(@Param("start") int start,
                                              @Param("end") int end);
    
    /**
     * 根据条件分页获取交通固定资产投资新增生产能力快报表数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtt3DTO> getTtjjhjtt3ByParamsPageable(@Param("start") int start,
                                                    @Param("end") int end,
                                                    @Param("info") String info);

}