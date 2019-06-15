package com.meixiang.beauty.webapp.traffic.dao.sslyzgl;

import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.TSlyzApproveapplyrecordsDTO;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TSlyzApproveapplyrecordsDao {
    
    
    /**
     * 查询许可申请表数据总个数
     */
    Integer getTSlyzApproveapplyrecordsCount();
    
    
    /**
     * 根据条件查询许可申请表数据总个数
     */
    Integer getTSlyzApproveapplyrecordsCountByParams();
    
    /**
     * 分页获取许可申请表数据
	 * @param start
     * @param end
     */
    List<TSlyzApproveapplyrecordsDTO> getTSlyzApproveapplyrecordsByPageable(@Param("start") int start,
                                                                            @Param("end") int end);
    
    /**
     * 根据条件分页获取许可申请表数据
	 * @param start
     * @param end
     */
    List<TSlyzApproveapplyrecordsDTO> getTSlyzApproveapplyrecordsByParamsPageable(@Param("start") int start,
                                                                                  @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    SslyzglDTO getHomepageInfo();
}