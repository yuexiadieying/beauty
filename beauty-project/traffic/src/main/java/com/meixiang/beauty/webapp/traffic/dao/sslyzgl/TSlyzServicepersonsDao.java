package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzServicepersonsDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzServicepersonsDao {
    
    
    /**
     * 查询运输辅助企业人员数据总个数
     */
    Integer getTSlyzServicepersonsCount();
    
    
    /**
     * 根据条件查询运输辅助企业人员数据总个数
     */
    Integer getTSlyzServicepersonsCountByParams();
    
    /**
     * 分页获取运输辅助企业人员数据
	 * @param start
     * @param end
     */
    List<TSlyzServicepersonsDTO> getTSlyzServicepersonsByPageable(@Param("start") int start,
                                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取运输辅助企业人员数据
	 * @param start
     * @param end
     */
    List<TSlyzServicepersonsDTO> getTSlyzServicepersonsByParamsPageable(@Param("start") int start,
                                                                        @Param("end") int end,
                                                                        @Param("info") String info);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}