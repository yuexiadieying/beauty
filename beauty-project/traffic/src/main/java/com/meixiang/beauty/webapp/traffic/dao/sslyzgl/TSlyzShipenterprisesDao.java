package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzShipenterprisesDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzShipenterprisesDao {
    
    
    /**
     * 查询水路运输业户台帐数据总个数
     */
    Integer getTSlyzShipenterprisesCount();
    
    
    /**
     * 根据条件查询水路运输业户台帐数据总个数
     */
    Integer getTSlyzShipenterprisesCountByParams();
    
    /**
     * 分页获取水路运输业户台帐数据
	 * @param start
     * @param end
     */
    List<TSlyzShipenterprisesDTO> getTSlyzShipenterprisesByPageable(@Param("start") int start,
                                                                    @Param("end") int end);
    
    /**
     * 根据条件分页获取水路运输业户台帐数据
	 * @param start
     * @param end
     */
    List<TSlyzShipenterprisesDTO> getTSlyzShipenterprisesByParamsPageable(@Param("start") int start,
                                                                          @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}