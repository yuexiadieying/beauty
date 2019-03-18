package com.meixiang.beauty.modules.system.impl;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.account.PageParamVoDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.system.ValidateCodeDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinShareDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinTokenDTO;
import com.meixiang.beauty.common.utils.CookieUtils;
import com.meixiang.beauty.common.utils.JedisUtils;
import com.meixiang.beauty.common.utils.RedisLock;
import com.meixiang.beauty.common.utils.WeixinUtil;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.modules.system.dao.UserDao;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    protected MongoTemplate mongoTemplate;

    private Gson gson = new Gson();

    @Override
    public String login(String phone, String code, String loginIP, String openId) throws Exception {

        //判断validateCode是否还有效
        Query query = new Query().addCriteria(Criteria.where("mobile").is(phone))
                .addCriteria(Criteria.where("code").is(code));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "createDate")));
        List<ValidateCodeDTO> data = mongoTemplate.find(query, ValidateCodeDTO.class,"validateCode");
        if(data==null)
        {
            return StatusConstant.VALIDATECODE_ERROR;
        }
        else
        {
            ValidateCodeDTO validateCodeDTO = data.get(0);
            Date dateStr = validateCodeDTO.getCreateDate();
            long period =  (new Date()).getTime() - dateStr.getTime();

            //验证码过了5分钟了
            if(period>300000)
            {
                return  StatusConstant.VALIDATECODE_ERROR;
            }
        }

        //validateCode有效后，判断sys_user表中，是否存在此用户，如果存在，则成功返回登录，如果不存在，则创建用户后，返回登录成功
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setMobile(phone);
        List<UserInfoDTO> userInfoDTOList = userDao.getUserByInfo(userInfoDTO);
        RedisLock redisLock = new RedisLock("userInfo");
        redisLock.lock();
        try {
            if(userInfoDTOList.size()>0)
            {
                //用户曾经绑定过手机号，更新用户登录信息
                userInfoDTO = userInfoDTOList.get(0);
                userInfoDTO.setLoginDate(new Date());
                userInfoDTO.setLoginIp(loginIP);
                userDao.updateUserInfo(userInfoDTO);
            }
            else
            {
                UserInfoDTO userInfoDTO1 = new UserInfoDTO();
                userInfoDTO1.setUserOpenid(openId);
                List<UserInfoDTO> userInfoDTOS = userDao.getUserByInfo(userInfoDTO1);

                //用户从未绑定过手机号，且用户没有关注公众号
                if(userInfoDTOS.size()>0)
                {
                    userInfoDTO1 = userInfoDTOS.get(0);
                    userInfoDTO1.setMobile(phone);
                    userInfoDTO1.setLoginDate(new Date());
                    userInfoDTO1.setLoginIp(loginIP);
                    userDao.updateUserInfo(userInfoDTO1);

                    userInfoDTO = userInfoDTO1;
                }
                else
                {
                    //用户从未绑定过手机号，但用户关注了公众号
                    return StatusConstant.WEIXIN_ATTENTION_ERROR;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            redisLock.unlock();
        }

        //登录成功后，将用户信息放置到redis中，生成logintoken供前端使用
        String logintoken = UUID.randomUUID().toString();
        String userInfoStr = gson.toJson(userInfoDTO);
        JedisUtils.set(logintoken,userInfoStr,ConfigConstant.logintokenPeriod);
        return logintoken;
    }

    @Override
    public String loginOut(String logintoken) {
        JedisUtils.del(logintoken);
        return StatusConstant.LOGIN_OUT;
    }

    @Override
    public List<UserInfoDTO> getUserInfo(UserInfoDTO userInfoDTO) {
        return  userDao.getUserByInfo(userInfoDTO);
    }

    @Override
    public void updateUserInfo(UserInfoDTO userInfoDTO) {
        RedisLock redisLock = new RedisLock("userInfo"+userInfoDTO.getId());
        try{
            userDao.updateUserInfo(userInfoDTO);

            //更新redis
            if(RequestContextHolder.getRequestAttributes()!=null)
            {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                Map<String, String> tokenValue = UserUtils.getHeadersInfo(request);
                if(tokenValue!=null)
                {
                    String logintoken = tokenValue.get("logintoken");
                    String userInfoStr = (new Gson()).toJson(userInfoDTO);
                    JedisUtils.set(logintoken,userInfoStr,ConfigConstant.logintokenPeriod);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisLock.unlock();
        }
    }

    @Override
    public void insertUserInfo(UserInfoDTO userInfoDTO) {
        RedisLock redisLock = new RedisLock("userInfo");
        try{
            userDao.insertUserInfo(userInfoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisLock.unlock();
        }
    }

    @Override
    public List<UserBusinessTypeDTO> getUserBusinessType(UserBusinessTypeDTO userBusinessTypeDTO) {
        return  userDao.getUserBusinessType(userBusinessTypeDTO);
    }

    @Override
    public void insertUserBusinessType(UserBusinessTypeDTO userBusinessTypeDTO) {
        userDao.insertUserBusinessType(userBusinessTypeDTO);
    }

    @Override
    public WeixinShareDTO getWeixinShareInfo(UserInfoDTO userInfoDTO) {
        WeixinShareDTO weixinShareDTO = new WeixinShareDTO();

        weixinShareDTO.setSysUserId(userInfoDTO.getId());
        weixinShareDTO.setUserPhone(userInfoDTO.getMobile());
        weixinShareDTO.setUserImage(userInfoDTO.getPhoto());

        //获取shareCode
        String shareCode = ConfigConstant.SHARE_CODE_VALUE + userInfoDTO.getMobile() + "_" + RandomNumberUtil.getFourRandom();
        weixinShareDTO.setShareCode(shareCode);

        //获取qrCodeUrl
        String qrCodeUrl = this.getUserQRCode(shareCode);
        weixinShareDTO.setQrCodeURL(qrCodeUrl);

        mongoTemplate.insert(weixinShareDTO, "weixinShare");

        return weixinShareDTO;
    }

    @Override
    public void updateUserBusinessType(UserBusinessTypeDTO userBusinessTypeDTO) {
        userDao.updateUserBusinessType(userBusinessTypeDTO);
    }

    /**
     * 根据信息生成二维码
     * @param info
     * @return
     */
    private String getUserQRCode(String info) {
        Query query = new Query(Criteria.where("weixinFlag").is(ConfigConstant.weixinFlag));
        WeixinTokenDTO weixinTokenDTO = this.mongoTemplate.findOne(query,WeixinTokenDTO.class,"weixinParameter");
        String token = weixinTokenDTO.getToken();
        String url= "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+token;
        String jsonData="{\"expire_seconds\": 626400, \"action_name\": \"QR_STR_SCENE\",\"action_info\": {\"scene\": {\"scene_str\"" + ":\"" + info + "\"}}}";
        String reJson= WeixinUtil.post(url, jsonData,"POST");
        JSONObject jb=JSONObject.fromObject(reJson);
        String qrTicket = jb.getString("ticket");
        String QRCodeURI="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+qrTicket;
        return QRCodeURI;
    }

    @Override
    public PageParamDTO<List<UserBusinessTypeDTO>> queryUserBusinessById(String sysUserId) {
        PageParamDTO<List<UserBusinessTypeDTO>> page = new  PageParamDTO<>();
        /*page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int pageStartNo = (pageNo-1)*pageSize;
        int count = userDao.queryUserBusinessTypeCountByParameters(
                phoneAndIdentify,applyStartTime,applyEndTime,status);
        page.setTotalCount(count);*/
        List<UserBusinessTypeDTO> userBusinessTypeDTOList = userDao.queryUserBusinessById(sysUserId);

        /*for(UserBusinessTypeDTO userBusinessTypeDTO : commissionDTOList){
            try {
                userBusinessTypeDTO.setNickName(URLDecoder.decode(userBusinessTypeDTO.getNickName(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }*/
        page.setResponseData(userBusinessTypeDTOList);

        return page;
    }

    /**
     * 条件查询用户List分页
     * @return
     */
    @Override
    public PageParamDTO<List<UserInfoDTO>> queryUserInfoDTOByParameters(PageParamVoDTO<UserInfoDTO> pageParamVoDTO) {
        PageParamDTO<List<UserInfoDTO>> page = new  PageParamDTO<>();

        int count = userDao.queryUserInfoDTOCountByParameters(pageParamVoDTO);
        List<UserInfoDTO> userInfoDTOList = userDao.queryUserInfoDTOByParameters(pageParamVoDTO);
        for(UserInfoDTO userInfoDTO : userInfoDTOList){
            try {
                userInfoDTO.setNickname(URLDecoder.decode(userInfoDTO.getNickname(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        page.setTotalCount(count);
        page.setResponseData(userInfoDTOList);

        return page;
    }

    @Override
    public String managerLogin(String userPhone, String code) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setMobile(userPhone);
        userInfoDTO.setPassword(code);
        userInfoDTO.setUserType("manager-1");
        List<UserInfoDTO> userInfoDTOList = userDao.getUserByInfo(userInfoDTO);
        if(userInfoDTOList.size()>0)
        {
            //登录成功后，将用户信息放置到redis中，生成logintoken供前端使用
            String logintoken = UUID.randomUUID().toString();
            String userInfoStr = gson.toJson(userInfoDTOList.get(0));
            JedisUtils.set(logintoken,userInfoStr,ConfigConstant.logintokenPeriod);
            return logintoken;
        }else{
            return StatusConstant.FAILURE;
        }
    }
    //根据用户id查询下级代理
    @Override
    public PageParamDTO<List<UserInfoDTO>> queryNextUserById(String sysUserId) {
        PageParamDTO<List<UserInfoDTO>> page = new  PageParamDTO<>();
        List<UserInfoDTO> userInfoDTOList = userDao.queryNextUserById(sysUserId);
        for(UserInfoDTO userInfoDTO : userInfoDTOList){
            try {
                userInfoDTO.setNickname(URLDecoder.decode(userInfoDTO.getNickname(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        page.setResponseData(userInfoDTOList);
        return page;
    }

}
