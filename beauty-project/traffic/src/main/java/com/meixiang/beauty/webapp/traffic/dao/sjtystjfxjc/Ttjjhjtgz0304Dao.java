package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtgz0304DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjtgz0304Dao {
    
    
    /**
     * 查询港口吞吐量集装箱合计部分（按港口分）数据总个数
     */
    Integer getTtjjhjtgz0304Count();
    
    
    /**
     * 根据条件查询港口吞吐量集装箱合计部分（按港口分）数据总个数
     */
    Integer getTtjjhjtgz0304CountByParams(@Param("info") String info);
    
    /**
     * 分页获取港口吞吐量集装箱合计部分（按港口分）数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtgz0304DTO> getTtjjhjtgz0304ByPageable(@Param("start") int start,
                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取港口吞吐量集装箱合计部分（按港口分）数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtgz0304DTO> getTtjjhjtgz0304ByParamsPageable(@Param("start") int start,
                                                            @Param("end") int end,
                                                            @Param("info") String info);

}