package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsEsignCntRptDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsEsignCntRptDao {
    
    
    /**
     * 查询电子签章申报内容表数据总个数
     */
    Integer getTScxyTfBsEsignCntRptCount();
    
    
    /**
     * 根据条件查询电子签章申报内容表数据总个数
     */
    Integer getTScxyTfBsEsignCntRptCountByParams(@Param("info") String info);
    
    /**
     * 分页获取电子签章申报内容表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsEsignCntRptDTO> getTScxyTfBsEsignCntRptByPageable(@Param("start") int start,
                                                                    @Param("end") int end);
    
    /**
     * 根据条件分页获取电子签章申报内容表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsEsignCntRptDTO> getTScxyTfBsEsignCntRptByParamsPageable(@Param("start") int start,
                                                                          @Param("end") int end,
                                                                          @Param("info") String info);

}