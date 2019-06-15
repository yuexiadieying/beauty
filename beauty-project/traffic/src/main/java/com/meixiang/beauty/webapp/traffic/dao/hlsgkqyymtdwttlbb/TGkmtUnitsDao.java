package com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb;

import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtUnitsDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TtlbbDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TGkmtUnitsDao {
    
    
    /**
     * 查询行业管理机构数据总个数
     */
    Integer getTGkmtUnitsCount();
    
    
    /**
     * 根据条件查询行业管理机构数据总个数
     */
    Integer getTGkmtUnitsCountByParams();
    
    /**
     * 分页获取行业管理机构数据
	 * @param start
     * @param end
     */
    List<TGkmtUnitsDTO> getTGkmtUnitsByPageable(@Param("start") int start,
                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取行业管理机构数据
	 * @param start
     * @param end
     */
    List<TGkmtUnitsDTO> getTGkmtUnitsByParamsPageable(@Param("start") int start,
                                                      @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    TtlbbDTO getHomepageInfo();
}