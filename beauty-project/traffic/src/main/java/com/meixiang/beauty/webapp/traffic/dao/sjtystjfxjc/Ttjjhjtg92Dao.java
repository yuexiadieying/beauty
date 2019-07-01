package com.meixiang.beauty.webapp.traffic.dao.sjtystjfxjc;

import com.meixiang.beauty.webapp.traffic.dto.sjtystjfxjc.Ttjjhjtg92DTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface Ttjjhjtg92Dao {
    
    
    /**
     * 查询吞吐量指标电讯快报合计数据总个数
     */
    Integer getTtjjhjtg92Count();
    
    
    /**
     * 根据条件查询吞吐量指标电讯快报合计数据总个数
     */
    Integer getTtjjhjtg92CountByParams(@Param("info") String info);
    
    /**
     * 分页获取吞吐量指标电讯快报合计数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtg92DTO> getTtjjhjtg92ByPageable(@Param("start") int start,
                                                @Param("end") int end);
    
    /**
     * 根据条件分页获取吞吐量指标电讯快报合计数据
	 * @param start
     * @param end
     */
    List<Ttjjhjtg92DTO> getTtjjhjtg92ByParamsPageable(@Param("start") int start,
                                                      @Param("end") int end,
                                                      @Param("info") String info);
    /**
     * 分航线进出港旅客人数情况
     * @param start
     * @param end
     */
    List<Ttjjhjtg92DTO> getLineInAndOutPersonNumInfo(@Param("start") String start,
                                                     @Param("end") String end);

    /**
     * 国际分航线进出港旅客人数情况
     * @param start
     * @param end
     */
    List<Ttjjhjtg92DTO> getInternationalLineInAndOutPersonNumInfo(@Param("start") String start,
                                                                  @Param("end") String end);

    /**
     * l   国内分航线进出港旅客人数情况
     * @param start
     * @param end
     */
    List<Ttjjhjtg92DTO> getCountryLineInAndOutPersonNumInfo(@Param("start") String start,
                                                            @Param("end") String end);

    /**
     * l   内贸情况
     * @param start
     * @param end
     */
    List<Ttjjhjtg92DTO> getDomesticTradeInfo(@Param("start") String start,
                                             @Param("end") String end);

    /**
     * l   分货类吞吐
     * @param start
     * @param end
     */
    List<Ttjjhjtg92DTO> getGoodsTypeInAndOutInfo(@Param("start") String start,
                                                 @Param("end") String end);

    /**
     * l   外贸情况
     * @param start
     * @param end
     */
    List<Ttjjhjtg92DTO> getForeignTradeInfo(@Param("start") String start,
                                            @Param("end") String end);


}