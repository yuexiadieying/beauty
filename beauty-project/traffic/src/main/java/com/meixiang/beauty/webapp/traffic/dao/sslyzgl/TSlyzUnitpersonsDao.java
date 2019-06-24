package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzUnitpersonsDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzUnitpersonsDao {
    
    
    /**
     * 查询运政管理人员名录数据总个数
     */
    Integer getTSlyzUnitpersonsCount();
    
    
    /**
     * 根据条件查询运政管理人员名录数据总个数
     */
    Integer getTSlyzUnitpersonsCountByParams();
    
    /**
     * 分页获取运政管理人员名录数据
	 * @param start
     * @param end
     */
    List<TSlyzUnitpersonsDTO> getTSlyzUnitpersonsByPageable(@Param("start") int start,
                                                            @Param("end") int end);
    
    /**
     * 根据条件分页获取运政管理人员名录数据
	 * @param start
     * @param end
     */
    List<TSlyzUnitpersonsDTO> getTSlyzUnitpersonsByParamsPageable(@Param("start") int start,
                                                                  @Param("end") int end,
                                                                  @Param("info") String info);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}