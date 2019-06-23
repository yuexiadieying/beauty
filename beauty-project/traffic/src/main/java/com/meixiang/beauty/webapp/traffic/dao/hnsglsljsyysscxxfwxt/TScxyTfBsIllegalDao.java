package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsIllegalDTO;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsIllegalDao {
    
    
    /**
     * 查询经营违章表数据总个数
     */
    Integer getTScxyTfBsIllegalCount();
    
    
    /**
     * 根据条件查询经营违章表数据总个数
     */
    Integer getTScxyTfBsIllegalCountByParams(@Param("info") String info);
    
    /**
     * 分页获取经营违章表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsIllegalDTO> getTScxyTfBsIllegalByPageable(@Param("start") int start,
                                                            @Param("end") int end);
    
    /**
     * 根据条件分页获取经营违章表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsIllegalDTO> getTScxyTfBsIllegalByParamsPageable(@Param("start") int start,
                                                                  @Param("end") int end,
                                                                  @Param("info") String info);

}