package com.meixiang.beauty.webapp.traffic.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@MyBatisDao
@Repository
public interface UserinfoDao {
    
    
    /**
     * 查询用户信息数据总个数
     */
    Integer getUserinfoCount();
    
    
    /**
     * 根据条件查询用户信息数据总个数
     */
    Integer getUserinfoCountByParams(
            @Param("loginName") String loginName,
            @Param("password") String password
    );
    
    /**
     * 分页获取用户信息数据
	 * @param start
     * @param end
     */
    List<UserInfoDTO> getUserinfoByPageable(@Param("start") int start,
                                            @Param("end") int end);
    
    /**
     * 根据条件分页获取用户信息数据
     */
    List<UserInfoDTO> getUserinfoByParam(
            @Param("loginName") String loginName,
            @Param("password") String password
                                         );

    void updateUserInfo(@Param("nickName") String nickName,
                        @Param("userLevel") String userLevel,
                        @Param("id") String id
    );

}