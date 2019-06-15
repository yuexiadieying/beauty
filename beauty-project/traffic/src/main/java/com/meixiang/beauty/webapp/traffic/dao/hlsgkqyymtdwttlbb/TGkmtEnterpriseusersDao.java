package com.meixiang.beauty.webapp.traffic.dao.hlsgkqyymtdwttlbb;

import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TGkmtEnterpriseusersDTO;
import com.meixiang.beauty.webapp.traffic.dto.hlsgkqyymtdwttlbb.TtlbbDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TGkmtEnterpriseusersDao {
    
    
    /**
     * 查询企业操作人员表数据总个数
     */
    Integer getTGkmtEnterpriseusersCount();
    
    
    /**
     * 根据条件查询企业操作人员表数据总个数
     */
    Integer getTGkmtEnterpriseusersCountByParams();
    
    /**
     * 分页获取企业操作人员表数据
	 * @param start
     * @param end
     */
    List<TGkmtEnterpriseusersDTO> getTGkmtEnterpriseusersByPageable(@Param("start") int start,
                                                                    @Param("end") int end);
    
    /**
     * 根据条件分页获取企业操作人员表数据
	 * @param start
     * @param end
     */
    List<TGkmtEnterpriseusersDTO> getTGkmtEnterpriseusersByParamsPageable(@Param("start") int start,
                                                                          @Param("end") int end);
    
    /**
     * 查询首页信息
     */
    TtlbbDTO getHomepageInfo();
}