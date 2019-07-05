package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhdlys001ngdDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhdlys001ngdDao {
    
    
    /**
     * 查询道路运输经营业户数据总个数
     */
    Integer getTtjjhdlys001ngdCount();
    
    
    /**
     * 根据条件查询道路运输经营业户数据总个数
     */
    Integer getTtjjhdlys001ngdCountByParams(@Param("info") String info);
    
    /**
     * 分页获取道路运输经营业户数据
	 * @param start
     * @param end
     */
    List<Ttjjhdlys001ngdDTO> getTtjjhdlys001ngdByPageable(@Param("start") int start,
                                                          @Param("end") int end);
    
    /**
     * 根据条件分页获取道路运输经营业户数据
	 * @param start
     * @param end
     */
    List<Ttjjhdlys001ngdDTO> getTtjjhdlys001ngdByParamsPageable(@Param("start") int start,
                                                                @Param("end") int end,
                                                                @Param("info") String info);
    /**
     * l   道路经营业户数据
     * @param start
     * @param end
     */
    List<Ttjjhdlys001ngdDTO> getRoadBusinessPersonInfo(@Param("start") String start,
                                                       @Param("end") String end);


}