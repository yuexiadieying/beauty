package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhckt04DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhckt04Dao {
    
    
    /**
     * 查询出租汽车运营情况数据总个数
     */
    Integer getTtjjhckt04Count();
    
    
    /**
     * 根据条件查询出租汽车运营情况数据总个数
     */
    Integer getTtjjhckt04CountByParams(@Param("info") String info);
    
    /**
     * 分页获取出租汽车运营情况数据
	 * @param start
     * @param end
     */
    List<Ttjjhckt04DTO> getTtjjhckt04ByPageable(@Param("start") int start,
                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取出租汽车运营情况数据
	 * @param start
     * @param end
     */
    List<Ttjjhckt04DTO> getTtjjhckt04ByParamsPageable(@Param("start") int start,
                                                      @Param("end") int end,
                                                      @Param("info") String info);

}