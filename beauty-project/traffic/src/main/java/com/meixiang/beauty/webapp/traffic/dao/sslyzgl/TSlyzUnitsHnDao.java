package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzUnitsHnDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzUnitsHnDao {
    
    
    /**
     * 查询管理机构-水路运政数据总个数
     */
    Integer getTSlyzUnitsHnCount();
    
    
    /**
     * 根据条件查询管理机构-水路运政数据总个数
     */
    Integer getTSlyzUnitsHnCountByParams();
    
    /**
     * 分页获取管理机构-水路运政数据
	 * @param start
     * @param end
     */
    List<TSlyzUnitsHnDTO> getTSlyzUnitsHnByPageable(@Param("start") int start,
                                                    @Param("end") int end);
    
    /**
     * 根据条件分页获取管理机构-水路运政数据
	 * @param start
     * @param end
     */
    List<TSlyzUnitsHnDTO> getTSlyzUnitsHnByParamsPageable(@Param("start") int start,
                                                          @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}