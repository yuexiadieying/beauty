package com.meixiang.beauty.modules.system.impl;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.system.UserOrderAddressDTO;
import com.meixiang.beauty.common.dto.system.ValidateCodeDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinShareDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinTokenDTO;
import com.meixiang.beauty.common.utils.JedisUtils;
import com.meixiang.beauty.common.utils.RedisLock;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.modules.system.api.UserOrderAddressService;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.modules.system.dao.UserDao;
import com.meixiang.beauty.modules.system.dao.UserOrderAddressDao;
import com.meixiang.beauty.modules.system.util.UserUtils;
import com.meixiang.beauty.sys.utils.RandomNumberUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = false)
public class UserOrderAddressServiceImpl implements UserOrderAddressService {

    @Autowired
    UserOrderAddressDao userOrderAddressDao;
    
    @Override
    public List<UserOrderAddressDTO> getUserAddressList(String userId) {
        List<UserOrderAddressDTO> userOrderAddressDTOList = userOrderAddressDao.getUserOrderAddress(userId);
        return userOrderAddressDTOList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUserAddress(UserOrderAddressDTO userOrderAddressDTO) {
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        userOrderAddressDTO.setDelFlag("0");
        userOrderAddressDTO.setSysUserId(userInfoDTO.getId());

        //先找出用户所有的未删除的地址列表
        this.cancelDefaultUserAddress(userOrderAddressDTO,userInfoDTO.getId());
        userOrderAddressDao.addUserAddress(userOrderAddressDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserAddress(UserOrderAddressDTO userOrderAddressDTO) throws Exception{
        UserInfoDTO userInfoDTO = UserUtils.getUserInfoFromRedis();
        //先找出用户所有的未删除的地址列表
        this.cancelDefaultUserAddress(userOrderAddressDTO,userInfoDTO.getId());
        userOrderAddressDao.updateUserAddress(userOrderAddressDTO);
    }

    @Override
    public void deleteUserAddress(String addressId) throws Exception{
        userOrderAddressDao.deleteUserAddress(addressId);
    }

    @Override
    public UserOrderAddressDTO findUserAddressById(String addressId) {
        UserOrderAddressDTO userOrderAddressDTO=userOrderAddressDao.findUserAddressById(addressId);
        return userOrderAddressDTO;
    }

    @Override
    public UserOrderAddressDTO getUserAddressUsedInfoByAddressId(String addressId) {
        return userOrderAddressDao.findUserAddressById(addressId);
    }

    @Override
    public List<UserOrderAddressDTO> getUserOrderAddress(String id, String s) {
        return userOrderAddressDao.getUserOrderAddress(id,s);
    }

    private void cancelDefaultUserAddress(UserOrderAddressDTO userOrderAddressDTO,String userId)
    {
        //先找出用户所有的未删除的地址列表
        if(userOrderAddressDTO.getStatus().equals("1"))
        {
            List<UserOrderAddressDTO> userOrderAddressDTOList =  userOrderAddressDao.getUserOrderAddress(userId);
            if(userOrderAddressDTOList.size()>0)
            {
                for(UserOrderAddressDTO userOrderAddressDTO1:userOrderAddressDTOList)
                {
                    if(userOrderAddressDTO1.getStatus().equals("1"))
                    {
                        userOrderAddressDTO1.setStatus("0");
                        userOrderAddressDao.updateUserAddress(userOrderAddressDTO1);
                    }

                }
            }
        }
    }

}
