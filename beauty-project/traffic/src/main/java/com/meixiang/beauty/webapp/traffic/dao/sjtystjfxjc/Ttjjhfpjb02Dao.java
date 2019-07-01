package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhfpjb02DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhfpjb02Dao {
    
    
    /**
     * 查询农村公路的计划、投资完成情况表数据总个数
     */
    Integer getTtjjhfpjb02Count();
    
    
    /**
     * 根据条件查询农村公路的计划、投资完成情况表数据总个数
     */
    Integer getTtjjhfpjb02CountByParams(@Param("info") String info);
    
    /**
     * 分页获取农村公路的计划、投资完成情况表数据
	 * @param start
     * @param end
     */
    List<Ttjjhfpjb02DTO> getTtjjhfpjb02ByPageable(@Param("start") int start,
                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取农村公路的计划、投资完成情况表数据
	 * @param start
     * @param end
     */
    List<Ttjjhfpjb02DTO> getTtjjhfpjb02ByParamsPageable(@Param("start") int start,
                                                        @Param("end") int end,
                                                        @Param("info") String info);

    /**
     * 农村公路的计划
     * @param start
     * @param end
     */
    List<Ttjjhfpjb02DTO> getVillageRoadInvestPlanInfo(@Param("start") String start,
                                                      @Param("end") String end);

    /**
     * 投资完成情况
     * @param start
     * @param end
     */
    List<Ttjjhfpjb02DTO> getVillageRoadInvestFinishInfo(@Param("start") String start,
                                                        @Param("end") String end);


}