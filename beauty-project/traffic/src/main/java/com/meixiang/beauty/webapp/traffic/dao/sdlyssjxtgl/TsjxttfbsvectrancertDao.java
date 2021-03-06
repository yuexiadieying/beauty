package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsvectrancertDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbsvectrancertDao {
    
    
    /**
     * 查询道路运输证数据总个数
     */
    Integer getTsjxttfbsvectrancertCount();
    
    
    /**
     * 根据条件查询道路运输证数据总个数
     */
    Integer getTsjxttfbsvectrancertCountByParams(@Param("info") String info);
    
    /**
     * 分页获取道路运输证数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsvectrancertDTO> getTsjxttfbsvectrancertByPageable(@Param("start") int start,
                                                                    @Param("end") int end);
    
    /**
     * 根据条件分页获取道路运输证数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsvectrancertDTO> getTsjxttfbsvectrancertByParamsPageable(@Param("start") int start,
                                                                          @Param("end") int end,
                                                                          @Param("info") String info);

}