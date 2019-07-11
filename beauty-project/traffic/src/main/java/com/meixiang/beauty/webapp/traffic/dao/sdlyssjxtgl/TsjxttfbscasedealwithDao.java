package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbscasedealwithDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbscasedealwithDao {
    
    
    /**
     * 查询案件详情数据总个数
     */
    Integer getTsjxttfbscasedealwithCount();
    
    
    /**
     * 根据条件查询案件详情数据总个数
     */
    Integer getTsjxttfbscasedealwithCountByParams(@Param("info") String info);
    
    /**
     * 分页获取案件详情数据
	 * @param start
     * @param end
     */
    List<TsjxttfbscasedealwithDTO> getTsjxttfbscasedealwithByPageable(@Param("start") int start,
                                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取案件详情数据
	 * @param start
     * @param end
     */
    List<TsjxttfbscasedealwithDTO> getTsjxttfbscasedealwithByParamsPageable(@Param("start") int start,
                                                                            @Param("end") int end,
                                                                            @Param("info") String info);

}