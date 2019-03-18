package com.meixiang.beauty.modules.system.api;


import com.meixiang.beauty.common.dto.system.SuggestionDto;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinTokenDTO;

/**
 * Created by zbm84 on 2017/5/27.
 */
public interface SystemService {

    SuggestionDto addSuggestion(String userId, String suggestion);

    void sendUserValidateCode(String mobile);

}
