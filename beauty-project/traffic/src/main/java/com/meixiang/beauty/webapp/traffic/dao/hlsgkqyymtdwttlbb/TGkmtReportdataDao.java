package com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb;

import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtReportdataDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TtlbbDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TGkmtReportdataDao {
    
    
    /**
     * 查询港口吞吐量表数据总个数
     */
    Integer getTGkmtReportdataCount();
    
    
    /**
     * 根据条件查询港口吞吐量表数据总个数
     */
    Integer getTGkmtReportdataCountByParams();
    
    /**
     * 分页获取港口吞吐量表数据
	 * @param start
     * @param end
     */
    List<TGkmtReportdataDTO> getTGkmtReportdataByPageable(@Param("start") int start,
                                                          @Param("end") int end);
    
    /**
     * 根据条件分页获取港口吞吐量表数据
	 * @param start
     * @param end
     */
    List<TGkmtReportdataDTO> getTGkmtReportdataByParamsPageable(@Param("start") int start,
                                                                @Param("end") int end,
                                                                @Param("gkqy") String gkqy,
                                                                @Param("mtdw") String mtdw,
                                                                @Param("startDate") String startDate,
                                                                @Param("endDate") String endDate
                                                                );
    
    /**
     * 查询首页信息
     */
    TtlbbDTO getHomepageInfo();
}