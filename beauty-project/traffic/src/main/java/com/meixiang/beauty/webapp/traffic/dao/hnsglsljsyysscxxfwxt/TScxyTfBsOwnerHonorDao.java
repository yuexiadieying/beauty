package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerHonorDTO;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsOwnerHonorDao {
    
    
    /**
     * 查询企业荣誉表数据总个数
     */
    Integer getTScxyTfBsOwnerHonorCount();
    
    
    /**
     * 根据条件查询企业荣誉表数据总个数
     */
    Integer getTScxyTfBsOwnerHonorCountByParams();
    
    /**
     * 分页获取企业荣誉表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsOwnerHonorDTO> getTScxyTfBsOwnerHonorByPageable(@Param("start") int start,
                                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取企业荣誉表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsOwnerHonorDTO> getTScxyTfBsOwnerHonorByParamsPageable(@Param("start") int start,
                                                                        @Param("end") int end);

}