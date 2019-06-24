package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzShippersonsDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzShippersonsDao {
    
    
    /**
     * 查询水路运输企业人员数据总个数
     */
    Integer getTSlyzShippersonsCount();
    
    
    /**
     * 根据条件查询水路运输企业人员数据总个数
     */
    Integer getTSlyzShippersonsCountByParams();
    
    /**
     * 分页获取水路运输企业人员数据
	 * @param start
     * @param end
     */
    List<TSlyzShippersonsDTO> getTSlyzShippersonsByPageable(@Param("start") int start,
                                                            @Param("end") int end);
    
    /**
     * 根据条件分页获取水路运输企业人员数据
	 * @param start
     * @param end
     */
    List<TSlyzShippersonsDTO> getTSlyzShippersonsByParamsPageable(@Param("start") int start,
                                                                  @Param("end") int end,
                                                                  @Param("info") String info);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}