/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.modules.system.dao;

import java.util.List;

import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.account.WithDrawRecordDTO;
import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;

/**
 * 用户DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
@Repository
public interface UserDao {

	List<UserInfoDTO> getUserByInfo(UserInfoDTO userInfoDTO);

	void updateUserInfo(UserInfoDTO userInfoDTO);

	void insertUserInfo(UserInfoDTO userInfoDTO);

	List<UserBusinessTypeDTO> getUserBusinessType(UserBusinessTypeDTO userBusinessTypeDTO);

	void insertUserBusinessType(UserBusinessTypeDTO userBusinessTypeDTO);

    void updateUserBusinessType(UserBusinessTypeDTO userBusinessTypeDTO);

	/**
	 * 根据条件查询提现信息
	 * @param phoneAndIdentify
	 * @param applyStartTime
	 * @param applyEndTime
	 * @param updateStartTime
	 * @param updateEndTime
	 * @return
	 */
	List<WithDrawRecordDTO> queryWithdrawsByParameters(@Param("phoneAndIdentify")String phoneAndIdentify,
													   @Param("applyStartTime")String applyStartTime,
													   @Param("applyEndTime")String applyEndTime,
													   @Param("updateStartTime")String updateStartTime,
													   @Param("updateEndTime")String updateEndTime,
													   @Param("pageStartNo")int pageStartNo,
													   @Param("pageSize")int pageSize);
	/**
	 * 查询条件总条数
	 */
	Integer queryWithdrawsCountByParameters(@Param("phoneAndIdentify")String phoneAndIdentify,
											@Param("applyStartTime")String applyStartTime,
											@Param("applyEndTime")String applyEndTime,
											@Param("updateStartTime")String updateStartTime,
											@Param("updateEndTime")String updateEndTime);

	/*int queryUserBusinessTypeCountByParameters(@Param("phoneAndIdentify") String phoneAndIdentify,
											   @Param("applyStartTime") String applyStartTime,
											   @Param("applyEndTime") String applyEndTime,
											   @Param("status") String status);*/

	List<UserBusinessTypeDTO> queryUserBusinessById(@Param("sysUserId") String sysUserId);

	int queryUserInfoDTOCountByParameters(PageParamVoDTO<UserInfoDTO> pageParamVoDTO);

	List<UserInfoDTO> queryUserInfoDTOByParameters(PageParamVoDTO<UserInfoDTO> pageParamVoDTO);
	//根据用户id查询下级代理
	List<UserInfoDTO> queryNextUserById(@Param("sysUserId") String sysUserId);
}
