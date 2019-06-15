package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzYearcheckenterprisesDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzYearcheckenterprisesDao {
    
    
    /**
     * 查询年度审验业户记录数据总个数
     */
    Integer getTSlyzYearcheckenterprisesCount();
    
    
    /**
     * 根据条件查询年度审验业户记录数据总个数
     */
    Integer getTSlyzYearcheckenterprisesCountByParams();
    
    /**
     * 分页获取年度审验业户记录数据
	 * @param start
     * @param end
     */
    List<TSlyzYearcheckenterprisesDTO> getTSlyzYearcheckenterprisesByPageable(@Param("start") int start,
                                                                              @Param("end") int end);
    
    /**
     * 根据条件分页获取年度审验业户记录数据
	 * @param start
     * @param end
     */
    List<TSlyzYearcheckenterprisesDTO> getTSlyzYearcheckenterprisesByParamsPageable(@Param("start") int start,
                                                                                    @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}