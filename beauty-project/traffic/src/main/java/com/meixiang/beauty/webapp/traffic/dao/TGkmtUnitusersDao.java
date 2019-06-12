package com.meixiang.beauty.webapp.traffic.dao;

import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtUnitusersDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TtlbbDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TGkmtUnitusersDao {
    
    
    /**
     * 查询行业管理人员表数据总个数
     */
    Integer getTGkmtUnitusersCount();
    
    
    /**
     * 根据条件查询行业管理人员表数据总个数
     */
    Integer getTGkmtUnitusersCountByParams();
    
    /**
     * 分页获取行业管理人员表数据
	 * @param start
     * @param end
     */
    List<TGkmtUnitusersDTO> getTGkmtUnitusersByPageable(@Param("start") int start,
                                                        @Param("end") int end);
    
    /**
     * 根据条件分页获取行业管理人员表数据
	 * @param start
     * @param end
     */
    List<TGkmtUnitusersDTO> getTGkmtUnitusersByParamsPageable(@Param("start") int start,
                                                              @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    TtlbbDTO getHomepageInfo();
}