package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzTfBsRestudyrecordScDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzTfBsRestudyrecordScDao {
    
    
    /**
     * 查询继续教育记录(湖南个性化表-重命名)信用系统数据总个数
     */
    Integer getTSlyzTfBsRestudyrecordScCount();
    
    
    /**
     * 根据条件查询继续教育记录(湖南个性化表-重命名)信用系统数据总个数
     */
    Integer getTSlyzTfBsRestudyrecordScCountByParams();
    
    /**
     * 分页获取继续教育记录(湖南个性化表-重命名)信用系统数据
	 * @param start
     * @param end
     */
    List<TSlyzTfBsRestudyrecordScDTO> getTSlyzTfBsRestudyrecordScByPageable(@Param("start") int start,
                                                                            @Param("end") int end);
    
    /**
     * 根据条件分页获取继续教育记录(湖南个性化表-重命名)信用系统数据
	 * @param start
     * @param end
     */
    List<TSlyzTfBsRestudyrecordScDTO> getTSlyzTfBsRestudyrecordScByParamsPageable(@Param("start") int start,
                                                                                  @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}