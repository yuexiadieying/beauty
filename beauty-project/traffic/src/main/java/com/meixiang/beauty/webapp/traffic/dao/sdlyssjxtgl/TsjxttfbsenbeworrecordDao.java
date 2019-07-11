package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsenbeworrecordDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbsenbeworrecordDao {
    
    
    /**
     * 查询从业资格证表数据总个数
     */
    Integer getTsjxttfbsenbeworrecordCount();
    
    
    /**
     * 根据条件查询从业资格证表数据总个数
     */
    Integer getTsjxttfbsenbeworrecordCountByParams(@Param("info") String info);
    
    /**
     * 分页获取从业资格证表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsenbeworrecordDTO> getTsjxttfbsenbeworrecordByPageable(@Param("start") int start,
                                                                        @Param("end") int end);
    
    /**
     * 根据条件分页获取从业资格证表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsenbeworrecordDTO> getTsjxttfbsenbeworrecordByParamsPageable(@Param("start") int start,
                                                                              @Param("end") int end,
                                                                              @Param("info") String info);

}