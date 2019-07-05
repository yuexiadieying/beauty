package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhfpjb04DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhfpjb04Dao {
    
    
    /**
     * 查询农村公路资金到位情况表数据总个数
     */
    Integer getTtjjhfpjb04Count();
    
    
    /**
     * 根据条件查询农村公路资金到位情况表数据总个数
     */
    Integer getTtjjhfpjb04CountByParams(@Param("info") String info);
    
    /**
     * 分页获取农村公路资金到位情况表数据
	 * @param start
     * @param end
     */
    List<Ttjjhfpjb04DTO> getTtjjhfpjb04ByPageable(@Param("start") int start,
                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取农村公路资金到位情况表数据
	 * @param start
     * @param end
     */
    List<Ttjjhfpjb04DTO> getTtjjhfpjb04ByParamsPageable(@Param("start") int start,
                                                        @Param("end") int end,
                                                        @Param("info") String info);
    /**
     * 村公路资金到位情况／县道 省级资金到位／乡道市级资金到位／农村县级公路资金到位／未到位个数，已到位个数
     * @param start
     * @param end
     */
    List<Ttjjhfpjb04DTO> getVillageRoadMoneyInPlaceInfo(@Param("start") String start,
                                                        @Param("end") String end);


}