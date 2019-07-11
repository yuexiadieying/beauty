package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsjurctcDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbsjurctcDao {
    
    
    /**
     * 查询经营许可证表数据总个数
     */
    Integer getTsjxttfbsjurctcCount();
    
    
    /**
     * 根据条件查询经营许可证表数据总个数
     */
    Integer getTsjxttfbsjurctcCountByParams(@Param("info") String info);
    
    /**
     * 分页获取经营许可证表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsjurctcDTO> getTsjxttfbsjurctcByPageable(@Param("start") int start,
                                                          @Param("end") int end);
    
    /**
     * 根据条件分页获取经营许可证表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsjurctcDTO> getTsjxttfbsjurctcByParamsPageable(@Param("start") int start,
                                                                @Param("end") int end,
                                                                @Param("info") String info);

}