package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzEnterpriseillegalrunrdDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzEnterpriseillegalrunrdDao {
    
    
    /**
     * 查询企业违章记录数据总个数
     */
    Integer getTSlyzEnterpriseillegalrunrdCount();
    
    
    /**
     * 根据条件查询企业违章记录数据总个数
     */
    Integer getTSlyzEnterpriseillegalrunrdCountByParams();
    
    /**
     * 分页获取企业违章记录数据
	 * @param start
     * @param end
     */
    List<TSlyzEnterpriseillegalrunrdDTO> getTSlyzEnterpriseillegalrunrdByPageable(@Param("start") int start,
                                                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取企业违章记录数据
	 * @param start
     * @param end
     */
    List<TSlyzEnterpriseillegalrunrdDTO> getTSlyzEnterpriseillegalrunrdByParamsPageable(@Param("start") int start,
                                                                                        @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}