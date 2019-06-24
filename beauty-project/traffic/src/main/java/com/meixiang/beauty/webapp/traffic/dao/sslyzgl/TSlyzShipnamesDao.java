package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzShipnamesDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzShipnamesDao {
    
    
    /**
     * 查询运输船舶名录数据总个数
     */
    Integer getTSlyzShipnamesCount();
    
    
    /**
     * 根据条件查询运输船舶名录数据总个数
     */
    Integer getTSlyzShipnamesCountByParams();
    
    /**
     * 分页获取运输船舶名录数据
	 * @param start
     * @param end
     */
    List<TSlyzShipnamesDTO> getTSlyzShipnamesByPageable(@Param("start") int start,
                                                        @Param("end") int end);
    
    /**
     * 根据条件分页获取运输船舶名录数据
	 * @param start
     * @param end
     */
    List<TSlyzShipnamesDTO> getTSlyzShipnamesByParamsPageable(@Param("start") int start,
                                                              @Param("end") int end,
                                                              @Param("info") String info);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}