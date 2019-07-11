package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfbsdrivercreditDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfbsdrivercreditDao {
    
    
    /**
     * 查询驾驶员诚信考核(湖南个性化表-重命名)数据总个数
     */
    Integer getTsjxttfbsdrivercreditCount();
    
    
    /**
     * 根据条件查询驾驶员诚信考核(湖南个性化表-重命名)数据总个数
     */
    Integer getTsjxttfbsdrivercreditCountByParams(@Param("info") String info);
    
    /**
     * 分页获取驾驶员诚信考核(湖南个性化表-重命名)数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsdrivercreditDTO> getTsjxttfbsdrivercreditByPageable(@Param("start") int start,
                                                                      @Param("end") int end);
    
    /**
     * 根据条件分页获取驾驶员诚信考核(湖南个性化表-重命名)数据
	 * @param start
     * @param end
     */
    List<TsjxttfbsdrivercreditDTO> getTsjxttfbsdrivercreditByParamsPageable(@Param("start") int start,
                                                                            @Param("end") int end,
                                                                            @Param("info") String info);

}