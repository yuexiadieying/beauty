package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhfpjb01DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhfpjb01Dao {
    
    
    /**
     * 查询高速和国省道的计划、投资完成情况表数据总个数
     */
    Integer getTtjjhfpjb01Count();
    
    
    /**
     * 根据条件查询高速和国省道的计划、投资完成情况表数据总个数
     */
    Integer getTtjjhfpjb01CountByParams(@Param("info") String info);
    
    /**
     * 分页获取高速和国省道的计划、投资完成情况表数据
	 * @param start
     * @param end
     */
    List<Ttjjhfpjb01DTO> getTtjjhfpjb01ByPageable(@Param("start") int start,
                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取高速和国省道的计划、投资完成情况表数据
	 * @param start
     * @param end
     */
    List<Ttjjhfpjb01DTO> getTtjjhfpjb01ByParamsPageable(@Param("start") int start,
                                                        @Param("end") int end,
                                                        @Param("info") String info);

}