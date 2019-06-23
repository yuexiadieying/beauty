package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsQualityEventDTO;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsQualityEventDao {
    
    
    /**
     * 查询恶性服务事件表数据总个数
     */
    Integer getTScxyTfBsQualityEventCount();
    
    
    /**
     * 根据条件查询恶性服务事件表数据总个数
     */
    Integer getTScxyTfBsQualityEventCountByParams(@Param("info") String info);
    
    /**
     * 分页获取恶性服务事件表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsQualityEventDTO> getTScxyTfBsQualityEventByPageable(@Param("start") int start,
                                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取恶性服务事件表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsQualityEventDTO> getTScxyTfBsQualityEventByParamsPageable(@Param("start") int start,
                                                                            @Param("end") int end,
                                                                            @Param("info") String info);

}