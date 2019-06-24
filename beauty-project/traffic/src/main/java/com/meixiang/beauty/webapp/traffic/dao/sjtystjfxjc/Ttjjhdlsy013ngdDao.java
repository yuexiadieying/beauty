package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhdlsy013ngdDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhdlsy013ngdDao {
    
    
    /**
     * 查询港澳台及外商投资道路运输业数据总个数
     */
    Integer getTtjjhdlsy013ngdCount();
    
    
    /**
     * 根据条件查询港澳台及外商投资道路运输业数据总个数
     */
    Integer getTtjjhdlsy013ngdCountByParams(@Param("info") String info);
    
    /**
     * 分页获取港澳台及外商投资道路运输业数据
	 * @param start
     * @param end
     */
    List<Ttjjhdlsy013ngdDTO> getTtjjhdlsy013ngdByPageable(@Param("start") int start,
                                                          @Param("end") int end);
    
    /**
     * 根据条件分页获取港澳台及外商投资道路运输业数据
	 * @param start
     * @param end
     */
    List<Ttjjhdlsy013ngdDTO> getTtjjhdlsy013ngdByParamsPageable(@Param("start") int start,
                                                                @Param("end") int end,
                                                                @Param("info") String info);

}