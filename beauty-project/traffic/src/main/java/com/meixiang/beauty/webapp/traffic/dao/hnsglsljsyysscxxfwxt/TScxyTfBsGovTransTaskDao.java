package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsGovTransTaskDTO;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsGovTransTaskDao {
    
    
    /**
     * 查询政府运输任务表数据总个数
     */
    Integer getTScxyTfBsGovTransTaskCount();
    
    
    /**
     * 根据条件查询政府运输任务表数据总个数
     */
    Integer getTScxyTfBsGovTransTaskCountByParams(@Param("info") String info);
    
    /**
     * 分页获取政府运输任务表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsGovTransTaskDTO> getTScxyTfBsGovTransTaskByPageable(@Param("start") int start,
                                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取政府运输任务表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsGovTransTaskDTO> getTScxyTfBsGovTransTaskByParamsPageable(@Param("start") int start,
                                                                            @Param("end") int end,
                                                                            @Param("info") String info);

}