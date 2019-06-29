package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhckt01DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhckt01Dao {
    
    
    /**
     * 查询城市（县城）客运交通管理信息表数据总个数
     */
    Integer getTtjjhckt01Count();
    
    
    /**
     * 根据条件查询城市（县城）客运交通管理信息表数据总个数
     */
    Integer getTtjjhckt01CountByParams(@Param("info") String info);
    
    /**
     * 分页获取城市（县城）客运交通管理信息表数据
	 * @param start
     * @param end
     */
    List<Ttjjhckt01DTO> getTtjjhckt01ByPageable(@Param("start") int start,
                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取城市（县城）客运交通管理信息表数据
	 * @param start
     * @param end
     */
    List<Ttjjhckt01DTO> getTtjjhckt01ByParamsPageable(@Param("start") int start,
                                                      @Param("end") int end,
                                                      @Param("info") String info);

    /**
     * 城市（县城）客运交通管理信息
     * @param start
     * @param end
     */
    List<Ttjjhckt01DTO> getPassengerTrafficManagerInfo(@Param("start") String start,
                                                       @Param("end") String end);


}