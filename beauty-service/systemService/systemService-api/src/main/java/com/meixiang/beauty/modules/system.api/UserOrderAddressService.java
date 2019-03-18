package com.meixiang.beauty.modules.system.api;

import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.system.UserOrderAddressDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinShareDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zbm84 on 2017/5/27.
 */
public interface UserOrderAddressService {

    List<UserOrderAddressDTO> getUserAddressList(String userId);

    @Transactional(rollbackFor = Exception.class)
    void addUserAddress(UserOrderAddressDTO userOrderAddressDTO);

    @Transactional(rollbackFor = Exception.class)
    void updateUserAddress(UserOrderAddressDTO userOrderAddressDTO) throws Exception;

    void deleteUserAddress(String addressId) throws Exception;

    UserOrderAddressDTO findUserAddressById(String addressId);

    UserOrderAddressDTO getUserAddressUsedInfoByAddressId(String addressId);

    List<UserOrderAddressDTO> getUserOrderAddress(String id, String s);
}
