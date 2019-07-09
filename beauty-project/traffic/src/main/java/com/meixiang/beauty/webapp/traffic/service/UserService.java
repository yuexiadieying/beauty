package com.meixiang.beauty.webapp.traffic.service;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.webapp.traffic.dao.UserinfoDao;
import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.*;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import com.meixiang.beauty.webapp.traffic.dto.system.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WY on 2019/6/11.
 */
@Service
public class UserService {

    @Autowired
    private UserinfoDao userinfoDao;


    public String getUserInfoFromToken(String token, HttpSession httpSession) {
        String userInfoStr = httpSession.getAttribute(token).toString();
        return userInfoStr;
    }

    public void saveUserInfoToToken(String token, String userInfoStr, int logintokenPeriod) {

    }

    public Integer getUserinfoCountByParams(String account, String passwd) {
        return userinfoDao.getUserinfoCountByParams(account, passwd);
    }

    public UserInfoDTO getUserinfoByParam(String account, String passwd) {
        List<UserInfoDTO> res = userinfoDao.getUserinfoByParam(account, passwd);
        if (CollectionUtils.isEmpty(res)) {
            return res.get(0);
        }
        return new UserInfoDTO();
    }

    public void updateUserInfo(UserInfoDTO userInfoDTO) {
        String nikeName = userInfoDTO.getNickname();
        String userLevel = new Gson().toJson(userInfoDTO.getUserLevel());
        String id = userInfoDTO.getId();
        userinfoDao.updateUserInfo(nikeName, userLevel, id);
    }

}