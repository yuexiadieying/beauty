package com.meixiang.beauty.webapp.traffic.dao;

import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtReportdataDTO;
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
    //// TODO: 2019/6/10 xml待修改
    List<TGkmtReportdataDTO> getTGkmtReportdataByParamsPageable(@Param("start") int start,
                                                                @Param("end") int end,
                                                                @Param("bwbh") String bwbh,
                                                                @Param("mtdw") String mtdw,
                                                                @Param("startDate") String startDate,
                                                                @Param("endDate") String endDate);

}