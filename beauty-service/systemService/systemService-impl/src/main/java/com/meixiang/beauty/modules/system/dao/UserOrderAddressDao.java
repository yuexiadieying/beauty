/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.modules.system.dao;

import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.system.UserOrderAddressDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
@Repository
public interface UserOrderAddressDao {

	List<UserOrderAddressDTO> getUserOrderAddress(@Param("userId") String userId, @Param("status") String status);

	List<UserOrderAddressDTO> getUserOrderAddress(@Param("userId")String userId);

	void addUserAddress(UserOrderAddressDTO userOrderAddressDTO);

	void updateUserAddress(UserOrderAddressDTO userOrderAddressDTO);

	void deleteUserAddress(@Param("addressId") String addressId);

	UserOrderAddressDTO findUserAddressById(@Param("addressId") String addressId);
}
