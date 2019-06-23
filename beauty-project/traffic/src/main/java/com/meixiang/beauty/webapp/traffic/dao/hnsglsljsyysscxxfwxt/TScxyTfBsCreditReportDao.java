package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsCreditReportDTO;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsCreditReportDao {
    
    
    /**
     * 查询业户考核申报表数据总个数
     */
    Integer getTScxyTfBsCreditReportCount();
    
    
    /**
     * 根据条件查询业户考核申报表数据总个数
     */
    Integer getTScxyTfBsCreditReportCountByParams(@Param("info") String info);
    
    /**
     * 分页获取业户考核申报表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsCreditReportDTO> getTScxyTfBsCreditReportByPageable(@Param("start") int start,
                                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取业户考核申报表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsCreditReportDTO> getTScxyTfBsCreditReportByParamsPageable(@Param("start") int start,
                                                                            @Param("end") int end,
                                                                            @Param("info") String info);

}