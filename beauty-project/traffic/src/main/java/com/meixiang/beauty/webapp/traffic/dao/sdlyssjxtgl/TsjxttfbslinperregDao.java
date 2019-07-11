package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbslinperregDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbslinperregDao {
    
    
    /**
     * 查询班线基本信息表数据总个数
     */
    Integer getTsjxttfbslinperregCount();
    
    
    /**
     * 根据条件查询班线基本信息表数据总个数
     */
    Integer getTsjxttfbslinperregCountByParams(@Param("info") String info);
    
    /**
     * 分页获取班线基本信息表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbslinperregDTO> getTsjxttfbslinperregByPageable(@Param("start") int start,
                                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取班线基本信息表数据
	 * @param start
     * @param end
     */
    List<TsjxttfbslinperregDTO> getTsjxttfbslinperregByParamsPageable(@Param("start") int start,
                                                                      @Param("end") int end,
                                                                      @Param("info") String info);

}