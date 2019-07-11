package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsvecgoodsvecexaDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbsvecgoodsvecexaDao {
    
    
    /**
     * 查询车辆年审表数据总个数
     */
    Integer getTsjxttfbsvecgoodsvecexaCount();
    
    
    /**
     * 根据条件查询车辆年审表数据总个数
     */
    Integer getTsjxttfbsvecgoodsvecexaCountByParams(@Param("info") String info);
    
    /**
     * 分页获取车辆年审表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsvecgoodsvecexaDTO> getTsjxttfbsvecgoodsvecexaByPageable(@Param("start") int start,
                                                                          @Param("end") int end);
    
    /**
     * 根据条件分页获取车辆年审表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsvecgoodsvecexaDTO> getTsjxttfbsvecgoodsvecexaByParamsPageable(@Param("start") int start,
                                                                                @Param("end") int end,
                                                                                @Param("info") String info);

}