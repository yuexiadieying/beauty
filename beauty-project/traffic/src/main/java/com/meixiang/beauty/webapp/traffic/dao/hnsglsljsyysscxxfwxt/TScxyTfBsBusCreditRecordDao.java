package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsBusCreditRecordDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsBusCreditRecordDao {
    
    
    /**
     * 查询车辆信用考核表数据总个数
     */
    Integer getTScxyTfBsBusCreditRecordCount();
    
    
    /**
     * 根据条件查询车辆信用考核表数据总个数
     */
    Integer getTScxyTfBsBusCreditRecordCountByParams(@Param("info") String info);
    
    /**
     * 分页获取车辆信用考核表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsBusCreditRecordDTO> getTScxyTfBsBusCreditRecordByPageable(@Param("start") int start,
                                                                            @Param("end") int end);
    
    /**
     * 根据条件分页获取车辆信用考核表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsBusCreditRecordDTO> getTScxyTfBsBusCreditRecordByParamsPageable(@Param("start") int start,
                                                                                  @Param("end") int end,
                                                                                  @Param("info") String info);

}