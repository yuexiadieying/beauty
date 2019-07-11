package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsvehicleinsuranceDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbsvehicleinsuranceDao {
    
    
    /**
     * 查询车辆投保记录表数据总个数
     */
    Integer getTsjxttfbsvehicleinsuranceCount();
    
    
    /**
     * 根据条件查询车辆投保记录表数据总个数
     */
    Integer getTsjxttfbsvehicleinsuranceCountByParams(@Param("info") String info);
    
    /**
     * 分页获取车辆投保记录表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsvehicleinsuranceDTO> getTsjxttfbsvehicleinsuranceByPageable(@Param("start") int start,
                                                                              @Param("end") int end);
    
    /**
     * 根据条件分页获取车辆投保记录表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsvehicleinsuranceDTO> getTsjxttfbsvehicleinsuranceByParamsPageable(@Param("start") int start,
                                                                                    @Param("end") int end,
                                                                                    @Param("info") String info);

}