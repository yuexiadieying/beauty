package com.meixiang.beauty.webapp.traffic.dao.sdlyssjxtgl;

import com.meixiang.beauty.webapp.traffic.dto.sdlyssjxtgl.TsjxttfptownerDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface TsjxttfptownerDao {
    
    
    /**
     * 查询业户基本信息表数据总个数
     */
    Integer getTsjxttfptownerCount();
    
    
    /**
     * 根据条件查询业户基本信息表数据总个数
     */
    Integer getTsjxttfptownerCountByParams(@Param("info") String info);
    
    /**
     * 分页获取业户基本信息表数据
	 * @param start
     * @param end
     */
    List<TsjxttfptownerDTO> getTsjxttfptownerByPageable(@Param("start") int start,
                                                        @Param("end") int end);
    
    /**
     * 根据条件分页获取业户基本信息表数据
	 * @param start
     * @param end
     */
    List<TsjxttfptownerDTO> getTsjxttfptownerByParamsPageable(@Param("start") int start,
                                                              @Param("end") int end,
                                                              @Param("info") String info);

}