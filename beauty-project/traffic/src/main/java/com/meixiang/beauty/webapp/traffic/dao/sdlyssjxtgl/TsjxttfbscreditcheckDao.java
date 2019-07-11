package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbscreditcheckDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbscreditcheckDao {
    
    
    /**
     * 查询信誉考核信息表数据总个数
     */
    Integer getTsjxttfbscreditcheckCount();
    
    
    /**
     * 根据条件查询信誉考核信息表数据总个数
     */
    Integer getTsjxttfbscreditcheckCountByParams(@Param("info") String info);
    
    /**
     * 分页获取信誉考核信息表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbscreditcheckDTO> getTsjxttfbscreditcheckByPageable(@Param("start") int start,
                                                                    @Param("end") int end);
    
    /**
     * 根据条件分页获取信誉考核信息表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbscreditcheckDTO> getTsjxttfbscreditcheckByParamsPageable(@Param("start") int start,
                                                                          @Param("end") int end,
                                                                          @Param("info") String info);

}