package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzXzqhsDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzXzqhsDao {
    
    
    /**
     * 查询行政区划数据总个数
     */
    Integer getTSlyzXzqhsCount();
    
    
    /**
     * 根据条件查询行政区划数据总个数
     */
    Integer getTSlyzXzqhsCountByParams();
    
    /**
     * 分页获取行政区划数据
	 * @param start
     * @param end
     */
    List<TSlyzXzqhsDTO> getTSlyzXzqhsByPageable(@Param("start") int start,
                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取行政区划数据
	 * @param start
     * @param end
     */
    List<TSlyzXzqhsDTO> getTSlyzXzqhsByParamsPageable(@Param("start") int start,
                                                      @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}