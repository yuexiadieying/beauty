package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhckt02DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhckt02Dao {
    
    
    /**
     * 查询公共汽电车运营情况数据总个数
     */
    Integer getTtjjhckt02Count();
    
    
    /**
     * 根据条件查询公共汽电车运营情况数据总个数
     */
    Integer getTtjjhckt02CountByParams(@Param("info") String info);
    
    /**
     * 分页获取公共汽电车运营情况数据
	 * @param start
     * @param end
     */
    List<Ttjjhckt02DTO> getTtjjhckt02ByPageable(@Param("start") int start,
                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取公共汽电车运营情况数据
	 * @param start
     * @param end
     */
    List<Ttjjhckt02DTO> getTtjjhckt02ByParamsPageable(@Param("start") int start,
                                                      @Param("end") int end,
                                                      @Param("info") String info);

}