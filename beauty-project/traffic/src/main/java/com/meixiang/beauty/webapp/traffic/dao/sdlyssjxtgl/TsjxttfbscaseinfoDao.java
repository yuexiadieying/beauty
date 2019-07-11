package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbscaseinfoDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbscaseinfoDao {
    
    
    /**
     * 查询案件信息数据总个数
     */
    Integer getTsjxttfbscaseinfoCount();
    
    
    /**
     * 根据条件查询案件信息数据总个数
     */
    Integer getTsjxttfbscaseinfoCountByParams(@Param("info") String info);
    
    /**
     * 分页获取案件信息数据
	 * @param start
     * @param end
     */
    List<TsjxttfbscaseinfoDTO> getTsjxttfbscaseinfoByPageable(@Param("start") int start,
                                                              @Param("end") int end);
    
    /**
     * 根据条件分页获取案件信息数据
	 * @param start
     * @param end
     */
    List<TsjxttfbscaseinfoDTO> getTsjxttfbscaseinfoByParamsPageable(@Param("start") int start,
                                                                    @Param("end") int end,
                                                                    @Param("info") String info);

}