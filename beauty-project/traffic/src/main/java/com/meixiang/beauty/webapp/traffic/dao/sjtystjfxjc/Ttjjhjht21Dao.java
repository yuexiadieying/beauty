package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht21DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjht21Dao {
    
    
    /**
     * 查询水路运输法人企业财务状况数据总个数
     */
    Integer getTtjjhjht21Count();
    
    
    /**
     * 根据条件查询水路运输法人企业财务状况数据总个数
     */
    Integer getTtjjhjht21CountByParams(@Param("info") String info);
    
    /**
     * 分页获取水路运输法人企业财务状况数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht21DTO> getTtjjhjht21ByPageable(@Param("start") int start,
                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取水路运输法人企业财务状况数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht21DTO> getTtjjhjht21ByParamsPageable(@Param("start") int start,
                                                      @Param("end") int end,
                                                      @Param("info") String info);
    /**
     * 营业性运输船舶燃料消耗情况数据
     * @param start
     * @param end
     */
    List<Ttjjhjht21DTO> getBusinessBoatFuelInfo(@Param("start") String start,
                                                @Param("end") String end);

    /**
     * 水路运输法人企业财务状况
     * @param start
     * @param end
     */
    List<Ttjjhjht21DTO> getWaterRoadTransportEnterpriseAccountInfo(@Param("start") String start,
                                                                   @Param("end") String end);


}