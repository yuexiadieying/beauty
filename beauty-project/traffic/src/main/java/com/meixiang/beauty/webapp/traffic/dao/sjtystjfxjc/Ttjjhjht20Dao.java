package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjht20DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjht20Dao {
    
    
    /**
     * 查询公路运输法人企业财务状况数据总个数
     */
    Integer getTtjjhjht20Count();
    
    
    /**
     * 根据条件查询公路运输法人企业财务状况数据总个数
     */
    Integer getTtjjhjht20CountByParams(@Param("info") String info);
    
    /**
     * 分页获取公路运输法人企业财务状况数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht20DTO> getTtjjhjht20ByPageable(@Param("start") int start,
                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取公路运输法人企业财务状况数据
	 * @param start
     * @param end
     */
    List<Ttjjhjht20DTO> getTtjjhjht20ByParamsPageable(@Param("start") int start,
                                                      @Param("end") int end,
                                                      @Param("info") String info);
    /**
     * l   重点联系公路运输企业经营财务状况调查数据
     * @param start
     * @param end
     */
    List<Ttjjhjht20DTO> getRoadEnterpriseAccountInfo(@Param("start") String start,
                                                     @Param("end") String end);

    /**
     * 公路运输法人企业情况
     * @param start
     * @param end
     */
    List<Ttjjhjht20DTO> getRoadTransportJuridicalPersonEnterpriseInfo(@Param("start") String start,
                                                                      @Param("end") String end);

    /**
     * 营业性汽车运输效率和燃料消耗情况
     * @param start
     * @param end
     */
    List<Ttjjhjht20DTO> getBusinessCarTransportAndFuelInfo(@Param("start") String start,
                                                           @Param("end") String end);

    /**
     * 公路运输法人企业财务状况
     * @param start
     * @param end
     */
    List<Ttjjhjht20DTO> getRoadTransportEnterpriseAccountInfo(@Param("start") String start,
                                                              @Param("end") String end);


}