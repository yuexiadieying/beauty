package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzYearcheckshipsDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzYearcheckshipsDao {
    
    
    /**
     * 查询年度审验船舶记录表数据总个数
     */
    Integer getTSlyzYearcheckshipsCount();
    
    
    /**
     * 根据条件查询年度审验船舶记录表数据总个数
     */
    Integer getTSlyzYearcheckshipsCountByParams();
    
    /**
     * 分页获取年度审验船舶记录表数据
	 * @param start
     * @param end
     */
    List<TSlyzYearcheckshipsDTO> getTSlyzYearcheckshipsByPageable(@Param("start") int start,
                                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取年度审验船舶记录表数据
	 * @param start
     * @param end
     */
    List<TSlyzYearcheckshipsDTO> getTSlyzYearcheckshipsByParamsPageable(@Param("start") int start,
                                                                        @Param("end") int end,
                                                                        @Param("info") String info);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}