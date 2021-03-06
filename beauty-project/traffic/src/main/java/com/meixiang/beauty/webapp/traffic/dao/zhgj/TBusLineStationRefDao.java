package com.meixiang.beauty.webapp.traffic.dao.zhgj;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.webapp.traffic.dto.zhgj.TBusLineStationRefDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@MyBatisDao
@Repository
public interface TBusLineStationRefDao {
    
    
    /**
     * 查询线路站点关系表数据总个数
     */
    Integer getTBusLineStationRefCount();
    
    
    /**
     * 根据条件查询线路站点关系表数据总个数
     */
    Integer getTBusLineStationRefCountByParams(@Param("info") String info);
    
    /**
     * 分页获取线路站点关系表数据
	 * @param start
     * @param end
     */
    List<TBusLineStationRefDTO> getTBusLineStationRefByPageable(@Param("start") int start,
                                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取线路站点关系表数据
	 * @param start
     * @param end
     */
    List<TBusLineStationRefDTO> getTBusLineStationRefByParamsPageable(@Param("start") int start,
                                                                      @Param("end") int end,
                                                                      @Param("info") String info);

    /**
     * 根据线路名称查询线路基本信息
     * @param info 不能为空或空字符串
     * @return
     */
    List<TBusLineStationRefDTO> getTBusLineStationBasicInfo(@Param("info") String info);

    /**
     * 根据线路名称查询线路站点信息
     * @param info 不能为空或空字符串
     * @return
     */
    List<TBusLineStationRefDTO> getTBusLineStationPositionInfoByLineName(@Param("info") String info);

    /**
     * 根据车牌查询线路站点信息
     * @param info 不能为空或空字符串
     * @return
     */
    List<TBusLineStationRefDTO> getTBusLineStationPositionInfoByLicensePlate(@Param("info") String info);

}