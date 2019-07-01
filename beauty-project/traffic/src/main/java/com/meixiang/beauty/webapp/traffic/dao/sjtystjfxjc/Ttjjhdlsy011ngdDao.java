package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhdlsy011ngdDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhdlsy011ngdDao {
    
    
    /**
     * 查询道路危险货物运输数据总个数
     */
    Integer getTtjjhdlsy011ngdCount();
    
    
    /**
     * 根据条件查询道路危险货物运输数据总个数
     */
    Integer getTtjjhdlsy011ngdCountByParams(@Param("info") String info);
    
    /**
     * 分页获取道路危险货物运输数据
	 * @param start
     * @param end
     */
    List<Ttjjhdlsy011ngdDTO> getTtjjhdlsy011ngdByPageable(@Param("start") int start,
                                                          @Param("end") int end);
    
    /**
     * 根据条件分页获取道路危险货物运输数据
	 * @param start
     * @param end
     */
    List<Ttjjhdlsy011ngdDTO> getTtjjhdlsy011ngdByParamsPageable(@Param("start") int start,
                                                                @Param("end") int end,
                                                                @Param("info") String info);
    /**
     *  道路危险货物运输数据
     * @param start
     * @param end
     */
    List<Ttjjhdlsy011ngdDTO> getDangerThingsTransportNumInfo(@Param("start") String start,
                                                             @Param("end") String end);


}