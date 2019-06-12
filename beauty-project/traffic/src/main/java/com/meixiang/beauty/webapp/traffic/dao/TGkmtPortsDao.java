package com.meixiang.beauty.webapp.traffic.dao;

import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtPortsDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TtlbbDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TGkmtPortsDao {
    
    
    /**
     * 查询港口表数据总个数
     */
    Integer getTGkmtPortsCount();
    
    
    /**
     * 根据条件查询港口表数据总个数
     */
    Integer getTGkmtPortsCountByParams();
    
    /**
     * 分页获取港口表数据
	 * @param start
     * @param end
     */
    List<TGkmtPortsDTO> getTGkmtPortsByPageable(@Param("start") int start,
                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取港口表数据
	 * @param start
     * @param end
     */
    List<TGkmtPortsDTO> getTGkmtPortsByParamsPageable(@Param("start") int start,
                                                      @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    TtlbbDTO getHomepageInfo();
}