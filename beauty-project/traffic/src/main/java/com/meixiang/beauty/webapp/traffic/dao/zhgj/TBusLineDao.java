package com.meixiang.beauty.webapp.traffic.dao.zhgj;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.webapp.traffic.dto.zhgj.TBusLineDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@MyBatisDao
@Repository
public interface TBusLineDao {
    
    
    /**
     * 查询公交线路表数据总个数
     */
    Integer getTBusLineCount();
    
    
    /**
     * 根据条件查询公交线路表数据总个数
     */
    Integer getTBusLineCountByParams(@Param("info") String info);
    
    /**
     * 分页获取公交线路表数据
	 * @param start
     * @param end
     */
    List<TBusLineDTO> getTBusLineByPageable(@Param("start") int start,
                                            @Param("end") int end);
    
    /**
     * 根据条件分页获取公交线路表数据
	 * @param start
     * @param end
     */
    List<TBusLineDTO> getTBusLineByParamsPageable(@Param("start") int start,
                                                  @Param("end") int end,
                                                  @Param("info") String info);

    /**
     * 根据线路名称查询线路信息
     * @param info 不允许为空或空字符串
     * @return
     */
    List<TBusLineDTO> getTBusLineBasiceInfo(@Param("info") String info);

}