package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerReformDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsOwnerReformDao {
    
    
    /**
     * 查询业户责令整改表数据总个数
     */
    Integer getTScxyTfBsOwnerReformCount();
    
    
    /**
     * 根据条件查询业户责令整改表数据总个数
     */
    Integer getTScxyTfBsOwnerReformCountByParams(@Param("info") String info);
    
    /**
     * 分页获取业户责令整改表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsOwnerReformDTO> getTScxyTfBsOwnerReformByPageable(@Param("start") int start,
                                                                    @Param("end") int end);
    
    /**
     * 根据条件分页获取业户责令整改表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsOwnerReformDTO> getTScxyTfBsOwnerReformByParamsPageable(@Param("start") int start,
                                                                          @Param("end") int end,
                                                                          @Param("info") String info);

}