package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsownertrainextDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbsownertrainextDao {
    
    
    /**
     * 查询驾培业户扩展表数据总个数
     */
    Integer getTsjxttfbsownertrainextCount();
    
    
    /**
     * 根据条件查询驾培业户扩展表数据总个数
     */
    Integer getTsjxttfbsownertrainextCountByParams(@Param("info") String info);
    
    /**
     * 分页获取驾培业户扩展表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsownertrainextDTO> getTsjxttfbsownertrainextByPageable(@Param("start") int start,
                                                                        @Param("end") int end);
    
    /**
     * 根据条件分页获取驾培业户扩展表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsownertrainextDTO> getTsjxttfbsownertrainextByParamsPageable(@Param("start") int start,
                                                                              @Param("end") int end,
                                                                              @Param("info") String info);

}