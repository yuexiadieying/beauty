package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht10yDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjht10yDao {
    
    
    /**
     * 查询水路运力及客货运输量数据总个数
     */
    Integer getTtjjhjht10yCount();
    
    
    /**
     * 根据条件查询水路运力及客货运输量数据总个数
     */
    Integer getTtjjhjht10yCountByParams(@Param("info") String info);
    
    /**
     * 分页获取水路运力及客货运输量数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht10yDTO> getTtjjhjht10yByPageable(@Param("start") int start,
                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取水路运力及客货运输量数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht10yDTO> getTtjjhjht10yByParamsPageable(@Param("start") int start,
                                                        @Param("end") int end,
                                                        @Param("info") String info);
    /**
     * 公路水路运输量月度统计基础情况
     * @param start
     * @param end
     */
    List<Ttjjhjht10yDTO> getRoadAndWaterTransportNumInMonthInfo(@Param("start") String start,
                                                                @Param("end") String end);


}