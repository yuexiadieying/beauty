package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtt4DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjtt4Dao {
    
    
    /**
     * 查询交通固定资产投资项目基本情况表数据总个数
     */
    Integer getTtjjhjtt4Count();
    
    
    /**
     * 根据条件查询交通固定资产投资项目基本情况表数据总个数
     */
    Integer getTtjjhjtt4CountByParams(@Param("info") String info);
    
    /**
     * 分页获取交通固定资产投资项目基本情况表数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtt4DTO> getTtjjhjtt4ByPageable(@Param("start") int start,
                                              @Param("end") int end);
    
    /**
     * 根据条件分页获取交通固定资产投资项目基本情况表数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtt4DTO> getTtjjhjtt4ByParamsPageable(@Param("start") int start,
                                                    @Param("end") int end,
                                                    @Param("info") String info);

}