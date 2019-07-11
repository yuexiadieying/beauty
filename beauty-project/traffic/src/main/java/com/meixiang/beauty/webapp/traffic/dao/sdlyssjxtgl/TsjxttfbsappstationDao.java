package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsappstationDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbsappstationDao {
    
    
    /**
     * 查询场站扩展表(业务表)数据总个数
     */
    Integer getTsjxttfbsappstationCount();
    
    
    /**
     * 根据条件查询场站扩展表(业务表)数据总个数
     */
    Integer getTsjxttfbsappstationCountByParams(@Param("info") String info);
    
    /**
     * 分页获取场站扩展表(业务表)数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsappstationDTO> getTsjxttfbsappstationByPageable(@Param("start") int start,
                                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取场站扩展表(业务表)数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsappstationDTO> getTsjxttfbsappstationByParamsPageable(@Param("start") int start,
                                                                        @Param("end") int end,
                                                                        @Param("info") String info);

}