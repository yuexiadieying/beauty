package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzChangeshiprecordsDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzChangeshiprecordsDao {
    
    
    /**
     * 查询变更船舶记录数据总个数
     */
    Integer getTSlyzChangeshiprecordsCount();
    
    
    /**
     * 根据条件查询变更船舶记录数据总个数
     */
    Integer getTSlyzChangeshiprecordsCountByParams();
    
    /**
     * 分页获取变更船舶记录数据
	 * @param start
     * @param end
     */
    List<TSlyzChangeshiprecordsDTO> getTSlyzChangeshiprecordsByPageable(@Param("start") int start,
                                                                        @Param("end") int end);
    
    /**
     * 根据条件分页获取变更船舶记录数据
	 * @param start
     * @param end
     */
    List<TSlyzChangeshiprecordsDTO> getTSlyzChangeshiprecordsByParamsPageable(@Param("start") int start,
                                                                              @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}