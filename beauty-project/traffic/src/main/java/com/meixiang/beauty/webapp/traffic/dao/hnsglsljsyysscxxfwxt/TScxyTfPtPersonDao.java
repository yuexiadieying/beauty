package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfPtPersonDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfPtPersonDao {
    
    
    /**
     * 查询员工信息表数据总个数
     */
    Integer getTScxyTfPtPersonCount();
    
    
    /**
     * 根据条件查询员工信息表数据总个数
     */
    Integer getTScxyTfPtPersonCountByParams();
    
    /**
     * 分页获取员工信息表数据
	 * @param start
     * @param end
     */
    List<TScxyTfPtPersonDTO> getTScxyTfPtPersonByPageable(@Param("start") int start,
                                                          @Param("end") int end);
    
    /**
     * 根据条件分页获取员工信息表数据
	 * @param start
     * @param end
     */
    List<TScxyTfPtPersonDTO> getTScxyTfPtPersonByParamsPageable(@Param("start") int start,
                                                                @Param("end") int end);

}