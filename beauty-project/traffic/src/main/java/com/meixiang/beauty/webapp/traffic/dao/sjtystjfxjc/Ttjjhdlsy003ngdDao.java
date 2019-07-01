package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhdlsy003ngdDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhdlsy003ngdDao {
    
    
    /**
     * 查询道路运输从业人员数据总个数
     */
    Integer getTtjjhdlsy003ngdCount();
    
    
    /**
     * 根据条件查询道路运输从业人员数据总个数
     */
    Integer getTtjjhdlsy003ngdCountByParams(@Param("info") String info);
    
    /**
     * 分页获取道路运输从业人员数据
	 * @param start
     * @param end
     */
    List<Ttjjhdlsy003ngdDTO> getTtjjhdlsy003ngdByPageable(@Param("start") int start,
                                                          @Param("end") int end);
    
    /**
     * 根据条件分页获取道路运输从业人员数据
	 * @param start
     * @param end
     */
    List<Ttjjhdlsy003ngdDTO> getTtjjhdlsy003ngdByParamsPageable(@Param("start") int start,
                                                                @Param("end") int end,
                                                                @Param("info") String info);

    /**
     * l   道路从业人员数据
     * @param start
     * @param end
     */
    List<Ttjjhdlsy003ngdDTO> getRoadWorkersInfo(@Param("start") String start,
                                                @Param("end") String end);


}