package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsFacilityDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsFacilityDao {
    
    
    /**
     * 查询设施档案表数据总个数
     */
    Integer getTScxyTfBsFacilityCount();
    
    
    /**
     * 根据条件查询设施档案表数据总个数
     */
    Integer getTScxyTfBsFacilityCountByParams();
    
    /**
     * 分页获取设施档案表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsFacilityDTO> getTScxyTfBsFacilityByPageable(@Param("start") int start,
                                                              @Param("end") int end);
    
    /**
     * 根据条件分页获取设施档案表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsFacilityDTO> getTScxyTfBsFacilityByParamsPageable(@Param("start") int start,
                                                                    @Param("end") int end);

}