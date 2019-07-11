package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsvecgoodstecgrdDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbsvecgoodstecgrdDao {
    
    
    /**
     * 查询车辆技术等级表数据总个数
     */
    Integer getTsjxttfbsvecgoodstecgrdCount();
    
    
    /**
     * 根据条件查询车辆技术等级表数据总个数
     */
    Integer getTsjxttfbsvecgoodstecgrdCountByParams(@Param("info") String info);
    
    /**
     * 分页获取车辆技术等级表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsvecgoodstecgrdDTO> getTsjxttfbsvecgoodstecgrdByPageable(@Param("start") int start,
                                                                          @Param("end") int end);
    
    /**
     * 根据条件分页获取车辆技术等级表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsvecgoodstecgrdDTO> getTsjxttfbsvecgoodstecgrdByParamsPageable(@Param("start") int start,
                                                                                @Param("end") int end,
                                                                                @Param("info") String info);

}