package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzServiceenterprisesDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzServiceenterprisesDao {
    
    
    /**
     * 查询运输辅助企业台帐数据总个数
     */
    Integer getTSlyzServiceenterprisesCount();
    
    
    /**
     * 根据条件查询运输辅助企业台帐数据总个数
     */
    Integer getTSlyzServiceenterprisesCountByParams();
    
    /**
     * 分页获取运输辅助企业台帐数据
	 * @param start
     * @param end
     */
    List<TSlyzServiceenterprisesDTO> getTSlyzServiceenterprisesByPageable(@Param("start") int start,
                                                                          @Param("end") int end);
    
    /**
     * 根据条件分页获取运输辅助企业台帐数据
	 * @param start
     * @param end
     */
    List<TSlyzServiceenterprisesDTO> getTSlyzServiceenterprisesByParamsPageable(@Param("start") int start,
                                                                                @Param("end") int end,
                                                                                @Param("info") String info);

    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}