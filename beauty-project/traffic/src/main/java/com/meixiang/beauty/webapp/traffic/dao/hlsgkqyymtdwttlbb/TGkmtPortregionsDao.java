package com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb;

import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtPortregionsDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TtlbbDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TGkmtPortregionsDao {
    
    
    /**
     * 查询港区代码表数据总个数
     */
    Integer getTGkmtPortregionsCount();
    
    
    /**
     * 根据条件查询港区代码表数据总个数
     */
    Integer getTGkmtPortregionsCountByParams();
    
    /**
     * 分页获取港区代码表数据
	 * @param start
     * @param end
     */
    List<TGkmtPortregionsDTO> getTGkmtPortregionsByPageable(@Param("start") int start,
                                                            @Param("end") int end);
    
    /**
     * 根据条件分页获取港区代码表数据
	 * @param start
     * @param end
     */
    List<TGkmtPortregionsDTO> getTGkmtPortregionsByParamsPageable(@Param("start") int start,
                                                                  @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    TtlbbDTO getHomepageInfo();
}