package com.meixiang.beauty.modules.weixin.event;

import com.meixiang.beauty.common.constant.ConfigConstant;
import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.dto.system.UserBusinessTypeDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinAttentionDTO;
import com.meixiang.beauty.common.dto.wexin.WeixinTokenDTO;
import com.meixiang.beauty.common.utils.*;
import com.meixiang.beauty.modules.account.AccountService;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.modules.system.util.WeixinTemplateMessageUtil;
import com.meixiang.beauty.sys.entity.Article;
import com.meixiang.beauty.sys.entity.ReceiveXmlEntity;
import com.meixiang.beauty.sys.entity.WeixinUserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenjiake on 2017/9/11.
 */
@Service
@Transactional(readOnly = false)
public class ProcessSubscribeEventService {

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @Autowired
    private MongoTemplate mongoTemplate;

    private static ExecutorService threadExecutorCached = Executors.newCachedThreadPool();

    //处理用户关注公众号事件
    public void processSubscribeEvent(ReceiveXmlEntity xmlEntity)
    {
        Query query = new Query(Criteria.where("weixinFlag").is(ConfigConstant.weixinFlag));
        WeixinTokenDTO weixinTokenDTO = this.mongoTemplate.findOne(query,WeixinTokenDTO.class,"weixinParameter");
        String token = weixinTokenDTO.getToken();

        //开启线程，处理用户是扫描关注的用户，还是搜索关注公众号的用户
        Runnable processSubscribeThread = new ProcessSubscribeThread(token,xmlEntity);
        threadExecutorCached.execute(processSubscribeThread);

        //开启线程，给关注的用户推送微信消息
        Runnable sendSubscribeMessageThread = new SendSubscribeMessageThread(token, xmlEntity);
        threadExecutorCached.execute(sendSubscribeMessageThread);
    }

    private class ProcessSubscribeThread extends Thread {

        private String token;
        private ReceiveXmlEntity xmlEntity;

        public ProcessSubscribeThread(String token, ReceiveXmlEntity xmlEntity) {
            this.token = token;
            this.xmlEntity = xmlEntity;
        }

        @Override
        public void run() {

            String openId = xmlEntity.getFromUserName();

            //判断用户是否是扫码微商用户的二维码关注，
            String businessParentPhone = "";
            if(StringUtils.isNotNull(xmlEntity.getEventKey())){
                businessParentPhone = xmlEntity.getEventKey().replace("mxbusinessshare_", "");
                String codeArray[] = businessParentPhone.split("_");
                businessParentPhone = codeArray[1];
            }

            //获取用户的微信信息
            WeixinUserBean weixinUserBean = WeixinUtil.getWeixinUserBean(token,openId);

            UserInfoDTO parentUserInfoDTO = new UserInfoDTO();
            if(!businessParentPhone.equals(""))
            {
                parentUserInfoDTO.setMobile(businessParentPhone);
                //从sys_user表中，查询父一级用户信息
                List<UserInfoDTO> parentUserInfoDTOList = userService.getUserInfo(parentUserInfoDTO);
                parentUserInfoDTO = parentUserInfoDTOList.get(0);
                if(null != parentUserInfoDTO){
                    //向父节点推送消息
                    WeixinTemplateMessageUtil.sendLowLevelBusinessTemplateWXMessage(weixinUserBean.getNickname(),"c级代理商","0元",token,
                            "",parentUserInfoDTO.getUserOpenid());
                }
            }

            //为关注公众号的用户创建新的或修订之前的账户
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setUserOpenid(openId);
            List<UserInfoDTO> userInfoDTOList = userService.getUserInfo(userInfoDTO);

            if(userInfoDTOList.size()>0)
            {
                //用户之前关注过
                userInfoDTO = userInfoDTOList.get(0);
                if(userInfoDTO.getWeixinAttentionStatus().equals("0"))
                {
                    userInfoDTO.setWeixinAttentionStatus("1");
                }
                userInfoDTO.setParentUserId(parentUserInfoDTO.getId());
                userInfoDTO.setLoginIp("");
                userService.updateUserInfo(userInfoDTO);
            }
            else
            {
                //用户第一次关注
                userInfoDTO.setId(UUID.randomUUID().toString());
                String nickname = null;
                try {
                    nickname = URLEncoder.encode(weixinUserBean.getNickname(), "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                userInfoDTO.setNickname(nickname);
                userInfoDTO.setUserType(ConfigConstant.businessC1);
                userInfoDTO.setParentUserId(parentUserInfoDTO.getId());
                userInfoDTO.setWeixinAttentionStatus("1");
                userInfoDTO.setPhoto(weixinUserBean.getHeadimgurl());
                userInfoDTO.setDelFlag("0");
                userInfoDTO.setLoginIp("");
                userInfoDTO.setCreateDate(new Date());
                userService.insertUserInfo(userInfoDTO);

                //为用户新建一个账户
                AccountDTO accountDTO = new AccountDTO();
                accountDTO.setId(UUID.randomUUID().toString());
                accountDTO.setSysUserId(userInfoDTO.getId());
                accountDTO.setUserOpenId(userInfoDTO.getUserOpenid());
                accountDTO.setBalance((float)0.00);
                accountDTO.setScore((float)0.00);
                accountDTO.setStatus("nomral");
                accountDTO.setUpdateDate(new Date());
                accountDTO.setBalanceDeny((float)0.00);
                accountService.createUserAccount(accountDTO);

                //查询用户当前user_business_type中是否有记录，没有则创建用户为C用户
                UserBusinessTypeDTO userBusinessTypeDTO = new UserBusinessTypeDTO();
                userBusinessTypeDTO.setSysUserId(userInfoDTO.getId());
                userBusinessTypeDTO.setStatus("1");
                List<UserBusinessTypeDTO> userBusinessTypeDTOS = userService.getUserBusinessType(userBusinessTypeDTO);
                if(userBusinessTypeDTOS.size()==0)
                {
                    userBusinessTypeDTO.setId(UUID.randomUUID().toString());
                    userBusinessTypeDTO.setParentUserId("");
                    userBusinessTypeDTO.setCreateDate(new Date());
                    userBusinessTypeDTO.setUserType(ConfigConstant.businessC1);
                    userBusinessTypeDTO.setStatus("1");
                    userService.insertUserBusinessType(userBusinessTypeDTO);
                }
            }

            //为用户的此次关注插入到mongodb记录中
            WeixinAttentionDTO weixinAttentionDTO = new WeixinAttentionDTO();
            weixinAttentionDTO.setDate(new Date());
            weixinAttentionDTO.setOpenid(openId);
            weixinAttentionDTO.setParentUserId(parentUserInfoDTO.getId());
            weixinAttentionDTO.setStatus("1");
            mongoTemplate.insert(weixinAttentionDTO, "weixinAttention");
        }
    }

    private class SendSubscribeMessageThread extends Thread {
        private String token;
        private ReceiveXmlEntity xmlEntity;

        public SendSubscribeMessageThread(String token, ReceiveXmlEntity xmlEntity) {
            this.token = token;
            this.xmlEntity = xmlEntity;
        }

        @Override
        public void run() {
            List<Article> articleList = new ArrayList<>();
            Article article = new Article();
//            article.setTitle("嗨!您终于来啦! ~\n");
            article.setTitle("做美享9小主，让你轻松过万!~\n");
//            article.setDescription(
//                    "在这里,可以边赚钱边美美哒 ~  \n" +
//                    " \n" +
//                    "点击「99课堂」，教你玩转社群营销 ~\n" +
//                    "点击「99商城」，分享即赚钱 ~\n" +
//                    "更多资讯,直接留言 ~");
            article.setDescription(
                            "重要提示：2018年2月14日至22日美享百万元现金红包，立即开抢！\n" +
                                    "\n" +
                                    "抢红包路径：点击『右下角』→『我要赚钱』→『抢红包』→『通关游戏』→『领取现金红包』\n" +
                                    "\n" +
                                    "点这里，抢百万红包！");
            article.setPicUrl("");
            article.setUrl("https://hd.faisco.cn/16058090/siGeShIrYO2T5EJCsCaysg/load.html?style=72");
            articleList.add(article);
            WeixinUtil.senImgMsgToWeixin(token,xmlEntity.getFromUserName(),articleList);
        }
    }

    //处理用户取消关注公众号事件
    public void processUnSubscribeEvent(ReceiveXmlEntity xmlEntity)
    {
        //开启线程，处理用户的取消关注事件
        Runnable processUnSubscribeThread = new ProcessUnSubscribeThread(xmlEntity);
        threadExecutorCached.execute(processUnSubscribeThread);
    }

    private class ProcessUnSubscribeThread extends Thread{

        private ReceiveXmlEntity xmlEntity;

        public ProcessUnSubscribeThread(ReceiveXmlEntity xmlEntity) {
            this.xmlEntity = xmlEntity;
        }

        @Override
        public void run() {

            //修改sys_user表中微信关注状态
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setUserOpenid(xmlEntity.getFromUserName());
            List<UserInfoDTO> userInfoDTOList = userService.getUserInfo(userInfoDTO);
            if(userInfoDTOList.size()>0)
            {
                userInfoDTO = userInfoDTOList.get(0);
                userInfoDTO.setWeixinAttentionStatus("0");
                userService.updateUserInfo(userInfoDTO);
            }

            //为用户的此次取消关注插入到mongodb记录中
            WeixinAttentionDTO weixinAttentionDTO = new WeixinAttentionDTO();
            weixinAttentionDTO.setDate(new Date());
            weixinAttentionDTO.setOpenid(xmlEntity.getFromUserName());
            weixinAttentionDTO.setParentUserId(userInfoDTO.getParentUserId());
            weixinAttentionDTO.setStatus("0");
            mongoTemplate.insert(weixinAttentionDTO, "weixinAttention");

        }
    }

}
