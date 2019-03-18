package com.meixiang.beauty.modules.wechat.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sunxiao on 2017/9/11.
 */
public interface WeixinCoreService {

    String processWeixinRequest(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void updateWeixinToken();
}
