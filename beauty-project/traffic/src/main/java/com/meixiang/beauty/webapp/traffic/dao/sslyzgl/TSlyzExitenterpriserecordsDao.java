package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzExitenterpriserecordsDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzExitenterpriserecordsDao {
    
    
    /**
     * 查询注销退出业户记录数据总个数
     */
    Integer getTSlyzExitenterpriserecordsCount();
    
    
    /**
     * 根据条件查询注销退出业户记录数据总个数
     */
    Integer getTSlyzExitenterpriserecordsCountByParams();
    
    /**
     * 分页获取注销退出业户记录数据
	 * @param start
     * @param end
     */
    List<TSlyzExitenterpriserecordsDTO> getTSlyzExitenterpriserecordsByPageable(@Param("start") int start,
                                                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取注销退出业户记录数据
	 * @param start
     * @param end
     */
    List<TSlyzExitenterpriserecordsDTO> getTSlyzExitenterpriserecordsByParamsPageable(@Param("start") int start,
                                                                                      @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}