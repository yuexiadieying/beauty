package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtgz030405DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjtgz030405Dao {
    
    
    /**
     * 查询港口吞吐量合计部分（按港口分）数据总个数
     */
    Integer getTtjjhjtgz030405Count();
    
    
    /**
     * 根据条件查询港口吞吐量合计部分（按港口分）数据总个数
     */
    Integer getTtjjhjtgz030405CountByParams(@Param("info") String info);
    
    /**
     * 分页获取港口吞吐量合计部分（按港口分）数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtgz030405DTO> getTtjjhjtgz030405ByPageable(@Param("start") int start,
                                                          @Param("end") int end);
    
    /**
     * 根据条件分页获取港口吞吐量合计部分（按港口分）数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtgz030405DTO> getTtjjhjtgz030405ByParamsPageable(@Param("start") int start,
                                                                @Param("end") int end,
                                                                @Param("info") String info);
    /**
     * l   内贸出港情况
     * @param start
     * @param end
     */
    List<Ttjjhjtgz030405DTO> getDomesticTradeLeavePortInfo(@Param("start") String start,
                                                            @Param("end") String end);

    /**
     * l   外贸出港情况
     * @param start
     * @param end
     */
    List<Ttjjhjtgz030405DTO> getForeignTradeLeavePortInfo(@Param("start") String start,
                                                          @Param("end") String end);


}