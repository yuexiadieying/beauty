package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsBusReformRecordDTO;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsBusReformRecordDao {
    
    
    /**
     * 查询车辆责令整改表数据总个数
     */
    Integer getTScxyTfBsBusReformRecordCount();
    
    
    /**
     * 根据条件查询车辆责令整改表数据总个数
     */
    Integer getTScxyTfBsBusReformRecordCountByParams(@Param("info") String info);
    
    /**
     * 分页获取车辆责令整改表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsBusReformRecordDTO> getTScxyTfBsBusReformRecordByPageable(@Param("start") int start,
                                                                            @Param("end") int end);
    
    /**
     * 根据条件分页获取车辆责令整改表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsBusReformRecordDTO> getTScxyTfBsBusReformRecordByParamsPageable(@Param("start") int start,
                                                                                  @Param("end") int end,
                                                                                  @Param("info") String info);

}