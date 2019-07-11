package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbspermitlincardDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbspermitlincardDao {
    
    
    /**
     * 查询标志牌变更延续许可表,临时正式入库表数据总个数
     */
    Integer getTsjxttfbspermitlincardCount();
    
    
    /**
     * 根据条件查询标志牌变更延续许可表,临时正式入库表数据总个数
     */
    Integer getTsjxttfbspermitlincardCountByParams(@Param("info") String info);
    
    /**
     * 分页获取标志牌变更延续许可表,临时正式入库表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbspermitlincardDTO> getTsjxttfbspermitlincardByPageable(@Param("start") int start,
                                                                        @Param("end") int end);
    
    /**
     * 根据条件分页获取标志牌变更延续许可表,临时正式入库表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbspermitlincardDTO> getTsjxttfbspermitlincardByParamsPageable(@Param("start") int start,
                                                                              @Param("end") int end,
                                                                              @Param("info") String info);

}