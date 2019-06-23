package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsDriverCreditDTO;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsDriverCreditDao {
    
    
    /**
     * 查询从业人员考核签注表数据总个数
     */
    Integer getTScxyTfBsDriverCreditCount();
    
    
    /**
     * 根据条件查询从业人员考核签注表数据总个数
     */
    Integer getTScxyTfBsDriverCreditCountByParams(@Param("info") String info);
    
    /**
     * 分页获取从业人员考核签注表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsDriverCreditDTO> getTScxyTfBsDriverCreditByPageable(@Param("start") int start,
                                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取从业人员考核签注表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsDriverCreditDTO> getTScxyTfBsDriverCreditByParamsPageable(@Param("start") int start,
                                                                            @Param("end") int end,
                                                                            @Param("info") String info);

}