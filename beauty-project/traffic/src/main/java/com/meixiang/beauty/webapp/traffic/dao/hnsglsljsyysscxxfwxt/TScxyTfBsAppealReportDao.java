package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsAppealReportDTO;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsAppealReportDao {
    
    
    /**
     * 查询申诉主表数据总个数
     */
    Integer getTScxyTfBsAppealReportCount();
    
    
    /**
     * 根据条件查询申诉主表数据总个数
     */
    Integer getTScxyTfBsAppealReportCountByParams(@Param("info") String info);
    
    /**
     * 分页获取申诉主表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsAppealReportDTO> getTScxyTfBsAppealReportByPageable(@Param("start") int start,
                                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取申诉主表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsAppealReportDTO> getTScxyTfBsAppealReportByParamsPageable(@Param("start") int start,
                                                                            @Param("end") int end,
                                                                            @Param("info") String info);

}