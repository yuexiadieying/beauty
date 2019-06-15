package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsComplaintDTO;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsComplaintDao {
    
    
    /**
     * 查询社会投诉表数据总个数
     */
    Integer getTScxyTfBsComplaintCount();
    
    
    /**
     * 根据条件查询社会投诉表数据总个数
     */
    Integer getTScxyTfBsComplaintCountByParams();
    
    /**
     * 分页获取社会投诉表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsComplaintDTO> getTScxyTfBsComplaintByPageable(@Param("start") int start,
                                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取社会投诉表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsComplaintDTO> getTScxyTfBsComplaintByParamsPageable(@Param("start") int start,
                                                                      @Param("end") int end);

}