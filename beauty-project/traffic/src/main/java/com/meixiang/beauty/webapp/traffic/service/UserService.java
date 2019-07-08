package com.meixiang.beauty.webapp.traffic.service;

import com.meixiang.beauty.webapp.traffic.dao.sslyzgl.*;
import com.meixiang.beauty.webapp.traffic.dto.sslyzgl.SslyzglDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WY on 2019/6/11.
 */
@Service
public class UserService {


    public String getUserInfoFromToken(String token, HttpSession httpSession) {
        String userInfoStr = httpSession.getAttribute(token).toString();
        return userInfoStr;
    }
}