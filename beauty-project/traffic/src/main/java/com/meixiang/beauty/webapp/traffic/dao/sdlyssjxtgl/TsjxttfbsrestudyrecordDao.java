package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsrestudyrecordDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbsrestudyrecordDao {
    
    
    /**
     * 查询继续教育记录(湖南个性化表-重命名)数据总个数
     */
    Integer getTsjxttfbsrestudyrecordCount();
    
    
    /**
     * 根据条件查询继续教育记录(湖南个性化表-重命名)数据总个数
     */
    Integer getTsjxttfbsrestudyrecordCountByParams(@Param("info") String info);
    
    /**
     * 分页获取继续教育记录(湖南个性化表-重命名)数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsrestudyrecordDTO> getTsjxttfbsrestudyrecordByPageable(@Param("start") int start,
                                                                        @Param("end") int end);
    
    /**
     * 根据条件分页获取继续教育记录(湖南个性化表-重命名)数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsrestudyrecordDTO> getTsjxttfbsrestudyrecordByParamsPageable(@Param("start") int start,
                                                                              @Param("end") int end,
                                                                              @Param("info") String info);

}