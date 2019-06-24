package com.meixiang.beauty.webapp.traffic.dao.hnsglsljsyysscxxfwxt;

import com.meixiang.beauty.webapp.traffic.dto.hnsglsljsyysscxxfwxt.TScxyTfBsEquipmentDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TScxyTfBsEquipmentDao {
    
    
    /**
     * 查询设备档案表数据总个数
     */
    Integer getTScxyTfBsEquipmentCount();
    
    
    /**
     * 根据条件查询设备档案表数据总个数
     */
    Integer getTScxyTfBsEquipmentCountByParams(@Param("info") String info);
    
    /**
     * 分页获取设备档案表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsEquipmentDTO> getTScxyTfBsEquipmentByPageable(@Param("start") int start,
                                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取设备档案表数据
	 * @param start
     * @param end
     */
    List<TScxyTfBsEquipmentDTO> getTScxyTfBsEquipmentByParamsPageable(@Param("start") int start,
                                                                      @Param("end") int end,
                                                                      @Param("info") String info);

}