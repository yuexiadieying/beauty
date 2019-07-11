package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsindustryinfoDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbsindustryinfoDao {
    
    
    /**
     * 查询工商信息数据总个数
     */
    Integer getTsjxttfbsindustryinfoCount();
    
    
    /**
     * 根据条件查询工商信息数据总个数
     */
    Integer getTsjxttfbsindustryinfoCountByParams(@Param("info") String info);
    
    /**
     * 分页获取工商信息数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsindustryinfoDTO> getTsjxttfbsindustryinfoByPageable(@Param("start") int start,
                                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取工商信息数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsindustryinfoDTO> getTsjxttfbsindustryinfoByParamsPageable(@Param("start") int start,
                                                                            @Param("end") int end,
                                                                            @Param("info") String info);

}