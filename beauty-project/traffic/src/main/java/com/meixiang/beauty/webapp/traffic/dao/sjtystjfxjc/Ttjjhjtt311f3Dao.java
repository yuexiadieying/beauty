package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtt311f3DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjtt311f3Dao {
    
    
    /**
     * 查询续表（三）新增、改善内河航道明细表数据总个数
     */
    Integer getTtjjhjtt311f3Count();
    
    
    /**
     * 根据条件查询续表（三）新增、改善内河航道明细表数据总个数
     */
    Integer getTtjjhjtt311f3CountByParams(@Param("info") String info);
    
    /**
     * 分页获取续表（三）新增、改善内河航道明细表数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtt311f3DTO> getTtjjhjtt311f3ByPageable(@Param("start") int start,
                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取续表（三）新增、改善内河航道明细表数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtt311f3DTO> getTtjjhjtt311f3ByParamsPageable(@Param("start") int start,
                                                            @Param("end") int end,
                                                            @Param("info") String info);
    /**
     * 内河航道通航里程年底达到量情况
     * @param start
     * @param end
     */
    List<Ttjjhjtt311f3DTO> getEndOfYearMileageInfo(@Param("start") String start,
                                                   @Param("end") String end);


}