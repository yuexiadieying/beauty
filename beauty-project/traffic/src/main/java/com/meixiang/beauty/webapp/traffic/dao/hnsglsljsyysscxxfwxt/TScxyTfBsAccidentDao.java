package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsAccidentDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsAccidentDao {
    
    
    /**
     * 查询交通责任事故表数据总个数
     */
    Integer getTScxyTfBsAccidentCount();
    
    
    /**
     * 根据条件查询交通责任事故表数据总个数
     */
    Integer getTScxyTfBsAccidentCountByParams(@Param("info") String info);
    
    /**
     * 分页获取交通责任事故表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsAccidentDTO> getTScxyTfBsAccidentByPageable(@Param("start") int start,
                                                              @Param("end") int end);
    
    /**
     * 根据条件分页获取交通责任事故表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsAccidentDTO> getTScxyTfBsAccidentByParamsPageable(@Param("start") int start,
                                                                    @Param("end") int end,
                                                                    @Param("info") String info);

}