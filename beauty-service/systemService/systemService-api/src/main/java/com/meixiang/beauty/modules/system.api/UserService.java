package com.meixiang.beauty.modules.system.api;

import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinShareDTO;
import com.meixiang.beauty.sys.entity.WeixinUserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zbm84 on 2017/5/27.
 */
public interface UserService {

    String login(String phone, String code, String loginIP,String openId) throws Exception;

    String loginOut(String logintoken);

    List<UserInfoDTO> getUserInfo(UserInfoDTO userInfoDTO);

    void updateUserInfo(UserInfoDTO userInfoDTO);

    void insertUserInfo(UserInfoDTO userInfoDTO);

    List<UserBusinessTypeDTO> getUserBusinessType(UserBusinessTypeDTO userBusinessTypeDTO);

    void insertUserBusinessType(UserBusinessTypeDTO userBusinessTypeDTO);

    WeixinShareDTO getWeixinShareInfo(UserInfoDTO userInfoDTO);

    void updateUserBusinessType(UserBusinessTypeDTO userBusinessTypeDTO);

    PageParamDTO<List<UserBusinessTypeDTO>> queryUserBusinessById(String sysUserId);

    PageParamDTO<List<UserInfoDTO>> queryUserInfoDTOByParameters(PageParamVoDTO<UserInfoDTO> pageParamVoDTO);

    String managerLogin(String userPhone, String code);
    //根据id查询下级代理
    PageParamDTO<List<UserInfoDTO>> queryNextUserById(String sysUserId);
}
