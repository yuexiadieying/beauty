package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtgz01f1DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjtgz01f1Dao {
    
    
    /**
     * 查询港口码头单位一览表数据总个数
     */
    Integer getTtjjhjtgz01f1Count();
    
    
    /**
     * 根据条件查询港口码头单位一览表数据总个数
     */
    Integer getTtjjhjtgz01f1CountByParams(@Param("info") String info);
    
    /**
     * 分页获取港口码头单位一览表数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtgz01f1DTO> getTtjjhjtgz01f1ByPageable(@Param("start") int start,
                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取港口码头单位一览表数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtgz01f1DTO> getTtjjhjtgz01f1ByParamsPageable(@Param("start") int start,
                                                            @Param("end") int end,
                                                            @Param("info") String info);

}