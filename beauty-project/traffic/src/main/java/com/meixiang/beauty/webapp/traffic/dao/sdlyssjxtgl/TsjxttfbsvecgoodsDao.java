package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsvecgoodsDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbsvecgoodsDao {
    
    
    /**
     * 查询车辆基础表数据总个数
     */
    Integer getTsjxttfbsvecgoodsCount();
    
    
    /**
     * 根据条件查询车辆基础表数据总个数
     */
    Integer getTsjxttfbsvecgoodsCountByParams(@Param("info") String info);
    
    /**
     * 分页获取车辆基础表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsvecgoodsDTO> getTsjxttfbsvecgoodsByPageable(@Param("start") int start,
                                                              @Param("end") int end);
    
    /**
     * 根据条件分页获取车辆基础表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsvecgoodsDTO> getTsjxttfbsvecgoodsByParamsPageable(@Param("start") int start,
                                                                    @Param("end") int end,
                                                                    @Param("info") String info);

}