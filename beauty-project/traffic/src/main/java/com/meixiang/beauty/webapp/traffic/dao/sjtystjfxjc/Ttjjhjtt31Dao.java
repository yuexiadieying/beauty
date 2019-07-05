package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtt31DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjtt31Dao {
    
    
    /**
     * 查询交通固定资产投资完成情况快报数据总个数
     */
    Integer getTtjjhjtt31Count();
    
    
    /**
     * 根据条件查询交通固定资产投资完成情况快报数据总个数
     */
    Integer getTtjjhjtt31CountByParams(@Param("info") String info);
    
    /**
     * 分页获取交通固定资产投资完成情况快报数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtt31DTO> getTtjjhjtt31ByPageable(@Param("start") int start,
                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取交通固定资产投资完成情况快报数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtt31DTO> getTtjjhjtt31ByParamsPageable(@Param("start") int start,
                                                      @Param("end") int end,
                                                      @Param("info") String info);
    /**
     * 中央安排农村公路建设数／地方安排农村公路建设数
     * @param start
     * @param end
     */
    List<Ttjjhjtt31DTO> getVillageRoadBuildPlanInfo(@Param("start") String start,
                                                    @Param("end") String end);

    /**
     * 中央及地方安排农村公路建设情况
     * @param start
     * @param end
     */
    List<Ttjjhjtt31DTO> getVillageRoadBuildPlanInMonthInfo(@Param("start") String start,
                                                           @Param("end") String end);


}