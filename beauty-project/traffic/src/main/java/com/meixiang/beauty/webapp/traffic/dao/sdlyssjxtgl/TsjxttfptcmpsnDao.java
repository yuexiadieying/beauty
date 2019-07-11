package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfptcmpsnDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfptcmpsnDao {
    
    
    /**
     * 查询从业人员表数据总个数
     */
    Integer getTsjxttfptcmpsnCount();
    
    
    /**
     * 根据条件查询从业人员表数据总个数
     */
    Integer getTsjxttfptcmpsnCountByParams(@Param("info") String info);
    
    /**
     * 分页获取从业人员表数据
	 * @param start
     * @param end
     */
    List<TsjxttfptcmpsnDTO> getTsjxttfptcmpsnByPageable(@Param("start") int start,
                                                        @Param("end") int end);
    
    /**
     * 根据条件分页获取从业人员表数据
	 * @param start
     * @param end
     */
    List<TsjxttfptcmpsnDTO> getTsjxttfptcmpsnByParamsPageable(@Param("start") int start,
                                                              @Param("end") int end,
                                                              @Param("info") String info);

}