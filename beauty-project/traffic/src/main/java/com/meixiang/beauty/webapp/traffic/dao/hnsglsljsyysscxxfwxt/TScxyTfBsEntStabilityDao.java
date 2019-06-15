package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsEntStabilityDTO;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsEntStabilityDao {
    
    
    /**
     * 查询违规上访表数据总个数
     */
    Integer getTScxyTfBsEntStabilityCount();
    
    
    /**
     * 根据条件查询违规上访表数据总个数
     */
    Integer getTScxyTfBsEntStabilityCountByParams();
    
    /**
     * 分页获取违规上访表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsEntStabilityDTO> getTScxyTfBsEntStabilityByPageable(@Param("start") int start,
                                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取违规上访表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsEntStabilityDTO> getTScxyTfBsEntStabilityByParamsPageable(@Param("start") int start,
                                                                            @Param("end") int end);

}