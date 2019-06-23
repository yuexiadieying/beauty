package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsOwnerRuleDTO;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsOwnerRuleDao {
    
    
    /**
     * 查询规章制度表数据总个数
     */
    Integer getTScxyTfBsOwnerRuleCount();
    
    
    /**
     * 根据条件查询规章制度表数据总个数
     */
    Integer getTScxyTfBsOwnerRuleCountByParams(@Param("info") String info);
    
    /**
     * 分页获取规章制度表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsOwnerRuleDTO> getTScxyTfBsOwnerRuleByPageable(@Param("start") int start,
                                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取规章制度表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsOwnerRuleDTO> getTScxyTfBsOwnerRuleByParamsPageable(@Param("start") int start,
                                                                      @Param("end") int end,
                                                                      @Param("info") String info);

}