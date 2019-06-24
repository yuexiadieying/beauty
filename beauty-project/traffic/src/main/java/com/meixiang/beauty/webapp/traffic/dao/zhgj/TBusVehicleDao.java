package com.meixiang.beauty.webapp.traffic.dao.zhgj;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.webapp.traffic.dto.zhgj.TBusVehicleDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@MyBatisDao
@Repository
public interface TBusVehicleDao {
    
    
    /**
     * 查询车辆信息表数据总个数
     */
    Integer getTBusVehicleCount();
    
    
    /**
     * 根据条件查询车辆信息表数据总个数
     */
    Integer getTBusVehicleCountByParams(@Param("info") String info);
    
    /**
     * 分页获取车辆信息表数据
	 * @param start
     * @param end
     */
    List<TBusVehicleDTO> getTBusVehicleByPageable(@Param("start") int start,
                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取车辆信息表数据
	 * @param start
     * @param end
     */
    List<TBusVehicleDTO> getTBusVehicleByParamsPageable(@Param("start") int start,
                                                        @Param("end") int end,
                                                        @Param("info") String info);

}