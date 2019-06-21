package com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb;

import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtBerthsDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TtlbbDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TGkmtBerthsDao {
    
    
    /**
     * 查询全省泊位表数据总个数
     */
    Integer getTGkmtBerthsCount();
    
    
    /**
     * 根据条件查询全省泊位表数据总个数
     */
    Integer getTGkmtBerthsCountByParams();
    
    /**
     * 分页获取全省泊位表数据
	 * @param start
     * @param end
     */
    List<TGkmtBerthsDTO> getTGkmtBerthsByPageable(@Param("start") int start,
                                                  @Param("end") int end);
    
    /**
     * 根据条件分页获取全省泊位表数据
	 * @param start
     * @param end
     */
    List<TGkmtBerthsDTO> getTGkmtBerthsByParamsPageable(@Param("start") int start,
                                                        @Param("end") int end,
                                                        @Param("gkqy") String gkqy,
                                                        @Param("mtdw") String mtdw,
                                                        @Param("startDate") String startDate,
                                                        @Param("endDate") String endDate
    );
    
    /**
     * 查询首页信息
     */
    TtlbbDTO getHomepageInfo(@Param("year") int year);
}