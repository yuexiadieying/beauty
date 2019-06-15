package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzShipsDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzShipsDao {
    
    
    /**
     * 查询营运船舶信息数据总个数
     */
    Integer getTSlyzShipsCount();
    
    
    /**
     * 根据条件查询营运船舶信息数据总个数
     */
    Integer getTSlyzShipsCountByParams();
    
    /**
     * 分页获取营运船舶信息数据
	 * @param start
     * @param end
     */
    List<TSlyzShipsDTO> getTSlyzShipsByPageable(@Param("start") int start,
                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取营运船舶信息数据
	 * @param start
     * @param end
     */
    List<TSlyzShipsDTO> getTSlyzShipsByParamsPageable(@Param("start") int start,
                                                      @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}