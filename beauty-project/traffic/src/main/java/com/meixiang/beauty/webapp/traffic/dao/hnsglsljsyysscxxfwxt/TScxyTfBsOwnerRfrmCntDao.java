package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerRfrmCntDTO;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsOwnerRfrmCntDao {
    
    
    /**
     * 查询整改内容表数据总个数
     */
    Integer getTScxyTfBsOwnerRfrmCntCount();
    
    
    /**
     * 根据条件查询整改内容表数据总个数
     */
    Integer getTScxyTfBsOwnerRfrmCntCountByParams();
    
    /**
     * 分页获取整改内容表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsOwnerRfrmCntDTO> getTScxyTfBsOwnerRfrmCntByPageable(@Param("start") int start,
                                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取整改内容表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsOwnerRfrmCntDTO> getTScxyTfBsOwnerRfrmCntByParamsPageable(@Param("start") int start,
                                                                            @Param("end") int end);

}