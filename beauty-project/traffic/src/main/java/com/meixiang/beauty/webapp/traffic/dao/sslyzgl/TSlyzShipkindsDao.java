package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzShipkindsDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzShipkindsDao {
    
    
    /**
     * 查询船舶类型代码表数据总个数
     */
    Integer getTSlyzShipkindsCount();
    
    
    /**
     * 根据条件查询船舶类型代码表数据总个数
     */
    Integer getTSlyzShipkindsCountByParams();
    
    /**
     * 分页获取船舶类型代码表数据
	 * @param start
     * @param end
     */
    List<TSlyzShipkindsDTO> getTSlyzShipkindsByPageable(@Param("start") int start,
                                                        @Param("end") int end);
    
    /**
     * 根据条件分页获取船舶类型代码表数据
	 * @param start
     * @param end
     */
    List<TSlyzShipkindsDTO> getTSlyzShipkindsByParamsPageable(@Param("start") int start,
                                                              @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}