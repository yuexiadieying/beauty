package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhfpjb03DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhfpjb03Dao {
    
    
    /**
     * 查询县乡客运场站的计划、投资完成情况表数据总个数
     */
    Integer getTtjjhfpjb03Count();
    
    
    /**
     * 根据条件查询县乡客运场站的计划、投资完成情况表数据总个数
     */
    Integer getTtjjhfpjb03CountByParams(@Param("info") String info);
    
    /**
     * 分页获取县乡客运场站的计划、投资完成情况表数据
	 * @param start
     * @param end
     */
    List<Ttjjhfpjb03DTO> getTtjjhfpjb03ByPageable(@Param("start") int start,
                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取县乡客运场站的计划、投资完成情况表数据
	 * @param start
     * @param end
     */
    List<Ttjjhfpjb03DTO> getTtjjhfpjb03ByParamsPageable(@Param("start") int start,
                                                        @Param("end") int end,
                                                        @Param("info") String info);
    /**
     * 县乡客运场站的计划、
     * @param start
     * @param end
     */
    List<Ttjjhfpjb03DTO> getVillagePassengerStationInvestPlanInfo(@Param("start") String start,
                                                                  @Param("end") String end);

    /**
     * 投资完成情况表
     * @param start
     * @param end
     */
    List<Ttjjhfpjb03DTO> getVillagePassengerStationInvestFinishInfo(@Param("start") String start,
                                                                    @Param("end") String end);


}