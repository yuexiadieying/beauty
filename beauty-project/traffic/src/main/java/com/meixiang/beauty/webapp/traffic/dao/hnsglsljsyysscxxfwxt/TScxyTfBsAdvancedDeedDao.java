package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsAdvancedDeedDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsAdvancedDeedDao {
    
    
    /**
     * 查询先进事迹表数据总个数
     */
    Integer getTScxyTfBsAdvancedDeedCount();
    
    
    /**
     * 根据条件查询先进事迹表数据总个数
     */
    Integer getTScxyTfBsAdvancedDeedCountByParams(@Param("info") String info);
    
    /**
     * 分页获取先进事迹表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsAdvancedDeedDTO> getTScxyTfBsAdvancedDeedByPageable(@Param("start") int start,
                                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取先进事迹表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsAdvancedDeedDTO> getTScxyTfBsAdvancedDeedByParamsPageable(@Param("start") int start,
                                                                            @Param("end") int end,
                                                                            @Param("info") String info);

}