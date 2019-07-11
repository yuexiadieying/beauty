package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsvecgoodsvindDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbsvecgoodsvindDao {
    
    
    /**
     * 查询车辆二级维护表数据总个数
     */
    Integer getTsjxttfbsvecgoodsvindCount();
    
    
    /**
     * 根据条件查询车辆二级维护表数据总个数
     */
    Integer getTsjxttfbsvecgoodsvindCountByParams(@Param("info") String info);
    
    /**
     * 分页获取车辆二级维护表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsvecgoodsvindDTO> getTsjxttfbsvecgoodsvindByPageable(@Param("start") int start,
                                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取车辆二级维护表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsvecgoodsvindDTO> getTsjxttfbsvecgoodsvindByParamsPageable(@Param("start") int start,
                                                                            @Param("end") int end,
                                                                            @Param("info") String info);

}