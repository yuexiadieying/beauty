package com.meixiang.beauty.webapp.traffic.dao;

import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtEnterprisesDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TtlbbDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TGkmtEnterprisesDao {
    
    
    /**
     * 查询港口企业和码头单位名录数据总个数
     */
    Integer getTGkmtEnterprisesCount();
    
    
    /**
     * 根据条件查询港口企业和码头单位名录数据总个数
     */
    Integer getTGkmtEnterprisesCountByParams();
    
    /**
     * 分页获取港口企业和码头单位名录数据
	 * @param start
     * @param end
     */
    List<TGkmtEnterprisesDTO> getTGkmtEnterprisesByPageable(@Param("start") int start,
                                                            @Param("end") int end);
    
    /**
     * 根据条件分页获取港口企业和码头单位名录数据
	 * @param start
     * @param end
     */
    List<TGkmtEnterprisesDTO> getTGkmtEnterprisesByParamsPageable(@Param("start") int start,
                                                                  @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    TtlbbDTO getHomepageInfo();
}