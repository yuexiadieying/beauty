package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsRestudyrecordDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsRestudyrecordDao {
    
    
    /**
     * 查询继续教育记录表数据总个数
     */
    Integer getTScxyTfBsRestudyrecordCount();
    
    
    /**
     * 根据条件查询继续教育记录表数据总个数
     */
    Integer getTScxyTfBsRestudyrecordCountByParams(@Param("info") String info);
    
    /**
     * 分页获取继续教育记录表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsRestudyrecordDTO> getTScxyTfBsRestudyrecordByPageable(@Param("start") int start,
                                                                        @Param("end") int end);
    
    /**
     * 根据条件分页获取继续教育记录表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsRestudyrecordDTO> getTScxyTfBsRestudyrecordByParamsPageable(@Param("start") int start,
                                                                              @Param("end") int end,
                                                                              @Param("info") String info);

}