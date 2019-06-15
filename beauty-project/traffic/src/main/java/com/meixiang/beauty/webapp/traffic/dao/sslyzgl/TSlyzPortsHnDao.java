package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzPortsHnDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzPortsHnDao {
    
    
    /**
     * 查询港-水路运政数据总个数
     */
    Integer getTSlyzPortsHnCount();
    
    
    /**
     * 根据条件查询港-水路运政数据总个数
     */
    Integer getTSlyzPortsHnCountByParams();
    
    /**
     * 分页获取港-水路运政数据
	 * @param start
     * @param end
     */
    List<TSlyzPortsHnDTO> getTSlyzPortsHnByPageable(@Param("start") int start,
                                                    @Param("end") int end);
    
    /**
     * 根据条件分页获取港-水路运政数据
	 * @param start
     * @param end
     */
    List<TSlyzPortsHnDTO> getTSlyzPortsHnByParamsPageable(@Param("start") int start,
                                                          @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}