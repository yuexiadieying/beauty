package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzShipillegalrunrecordsDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzShipillegalrunrecordsDao {
    
    
    /**
     * 查询船舶违章记录数据总个数
     */
    Integer getTSlyzShipillegalrunrecordsCount();
    
    
    /**
     * 根据条件查询船舶违章记录数据总个数
     */
    Integer getTSlyzShipillegalrunrecordsCountByParams();
    
    /**
     * 分页获取船舶违章记录数据
	 * @param start
     * @param end
     */
    List<TSlyzShipillegalrunrecordsDTO> getTSlyzShipillegalrunrecordsByPageable(@Param("start") int start,
                                                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取船舶违章记录数据
	 * @param start
     * @param end
     */
    List<TSlyzShipillegalrunrecordsDTO> getTSlyzShipillegalrunrecordsByParamsPageable(@Param("start") int start,
                                                                                      @Param("end") int end,
                                                                                      @Param("info") String info);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}