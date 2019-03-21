package com.meixiang.beauty.webapp.car.service;

import com.alibaba.fastjson.JSONObject;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.utils.SpringContextHolder;
import com.meixiang.beauty.sys.entity.WeixinUserBean;
import com.meixiang.beauty.webapp.car.dto.*;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarSocketService {

    public static MongoTemplate mongoTemplate = SpringContextHolder.getBean(MongoTemplate.class);

    public static ExecutorService threadExecutorCached = Executors.newCachedThreadPool();

    private static CarSocketService carSocketService = new CarSocketService();

    public static CarSocketService getCarSocketService() {
        return carSocketService;
    }

    private CarSocketService(){
    }

    public final Map<String, String> deviceOnLineMapping = new ConcurrentHashMap<>();

    public final Map<String,Channel> deviceChannelMapping = new ConcurrentHashMap<>();

    public final Map<String, String> gameStatusMapping = new ConcurrentHashMap<>();

    public final Map<String, String> gameResultMapping = new ConcurrentHashMap<>();

    public final Map<String, String> damageLockMapping = new ConcurrentHashMap<>();

    public final Map<String, GameParamDTO> gameParamMapping = new ConcurrentHashMap<>();

    public final Map<String, Integer> deviceDeadMapping = new ConcurrentHashMap<>();

    public final Map<String, AttackParamDTO> attackParamMapping = new ConcurrentHashMap<>();

    public final Map<String, String> devicePartMapping = new ConcurrentHashMap<>();

    public final Map<String, String> carDamageMapping = new ConcurrentHashMap<>();

    public final Map<String, String> partTotalDamageMapping = new ConcurrentHashMap<>();

    public final Map<String, String> partTotalDeadMapping = new ConcurrentHashMap<>();

    public final Map<String, String> redGoalMapping = new ConcurrentHashMap<>();

    public final Map<String, String> blueGoalMapping = new ConcurrentHashMap<>();

    public final Map<String, String> deviceProblemMapping = new ConcurrentHashMap<>();

    public final Map<String, WeixinUserBean> carUserMapping = new ConcurrentHashMap<>();

    public final Map<String, String> userCarMapping = new ConcurrentHashMap<>();

    public void processDeviceOnlineService(Map<String, Object> msgMap, Channel channel) {

        String deviceId = String.valueOf(msgMap.get("deviceId"));

        deviceOnLineMapping.put(deviceId,"online");
        deviceChannelMapping.put(deviceId,channel);
    }

    public void processCarAttackService(Map<String, Object> msgMap, Channel channel) {

        String gamePlaceId = String.valueOf(msgMap.get("gamePlaceId"));
        String gameStatus = gameStatusMapping.get(gamePlaceId);
        String type = String.valueOf(msgMap.get("type"));
        String deviceId = String.valueOf(msgMap.get("deviceId"));

        if("ongoing".equals(gameStatus))
        {
            //根据deviceId判断此被打击的机器人是否处于不可受伤害模式
            String damageLock = damageLockMapping.get(deviceId);

            if(damageLock==null||damageLock.equals("false"))
            {
                synchronized(deviceId)
                {
                    List<String> attackParts = (List<String>) msgMap.get("attackParts");

                    GameParamDTO gameParamDTO = gameParamMapping.get(gamePlaceId);

                    Integer attackDamage = 0;
                    for(String attackPart : attackParts)
                    {
                        AttackParamDTO attackParamDTO =  attackParamMapping.get(gamePlaceId + attackPart);
                        attackDamage = attackDamage + attackParamDTO.getValue();
                    }

                    String carHP = carDamageMapping.get(deviceId);
                    if(carHP==null)
                    {
                        carHP = gameParamDTO.getMaxHP();
                        carHP = String.valueOf(Integer.parseInt(carHP)-attackDamage);
                    }
                    else
                    {
                        carHP = String.valueOf(Integer.parseInt(carHP)-attackDamage);
                    }

                    if(type.equals("red"))
                    {
                        String redTotalDamage = partTotalDamageMapping.get("red"+gamePlaceId);
                        if(redTotalDamage==null)
                        {
                            redTotalDamage = "0";
                        }
                        redTotalDamage = String.valueOf(Integer.parseInt(redTotalDamage)+attackDamage);
                        partTotalDamageMapping.put("red"+gamePlaceId,redTotalDamage);
                    }
                    else if(type.equals("blue"))
                    {
                        String blueTotalDamage = partTotalDamageMapping.get("blue"+gamePlaceId);
                        if(blueTotalDamage==null)
                        {
                            blueTotalDamage = "0";
                        }
                        blueTotalDamage = String.valueOf(Integer.parseInt(blueTotalDamage)+attackDamage);
                        partTotalDamageMapping.put("blue"+gamePlaceId,blueTotalDamage);
                    }

                    //进入晕厥状态
                    if(Integer.parseInt(carHP)<=0)
                    {
                        damageLockMapping.put(deviceId,"true");

                        carDamageMapping.put(deviceId,"0");
                        //死亡总数增加1
                        if(type.equals("red"))
                        {
                            if(partTotalDeadMapping.get("red"+gamePlaceId)==null)
                            {
                                partTotalDeadMapping.put("red"+gamePlaceId,"1");
                            }
                            else
                            {
                                partTotalDeadMapping.put("red"+gamePlaceId,String.valueOf(Integer.parseInt(String.valueOf(partTotalDeadMapping.get("red"+gamePlaceId)))+1));
                            }

                        }
                        else if(type.equals("blue"))
                        {
                            if(partTotalDeadMapping.get("blue"+gamePlaceId)==null)
                            {
                                partTotalDeadMapping.put("blue"+gamePlaceId,"1");
                            }
                            else
                            {
                                partTotalDeadMapping.put("blue"+gamePlaceId,String.valueOf(Integer.parseInt(String.valueOf(partTotalDeadMapping.get("blue"+gamePlaceId)))+1));
                            }
                        }

                        //启动晕厥处理线程
                        DeviceParamDTO deviceParamDTO = new DeviceParamDTO();
                        deviceParamDTO.setGamePlaceId(gamePlaceId);
                        deviceParamDTO.setType(type);
                        deviceParamDTO.setDeviceId(deviceId);
                        Runnable dizzyProcessThread = new DizzyProcessThread(deviceParamDTO,channel);
                        threadExecutorCached.execute(dizzyProcessThread);
                    }
                    else
                    {
                        carDamageMapping.put(deviceId,carHP);
                    }
                }
            }
        }
    }

    public void processCarGoalService(Map<String, Object> msgMap, Channel channel) {

        String deviceId = String.valueOf(msgMap.get("deviceId"));
        String gamePlaceId = String.valueOf(msgMap.get("gamePlaceId"));
        String type =  String.valueOf(msgMap.get("type"));
        
        String gameStatus = gameStatusMapping.get(gamePlaceId);

        if("ongoing".equals(gameStatus))
        {
            synchronized (deviceId)
            {
                //获取红方或者蓝方的进球数
           
                GameParamDTO gameParamDTO = gameParamMapping.get(gamePlaceId);

                if(type.equals("red"))
                {
                    String point = redGoalMapping.get(gamePlaceId);
                    point = String.valueOf(Integer.parseInt(point)+1);
                    redGoalMapping.put(gamePlaceId,point);

                    //判断是否达到了WinPoint，若达到了，则比赛结束，进入判分流程
                    if(Integer.parseInt(point)>=Integer.parseInt(gameParamDTO.getWinPoint()))
                    {
                        gameStatus = gameStatusMapping.get(gamePlaceId);
                        if(!gameStatus.equals("end"))
                        {
                            gameStatusMapping.put(gamePlaceId,"end");
                            gameResultMapping.put(gamePlaceId,"redPartWin");

                            //比赛结束
                            Runnable gameStopCtrlThread = new GameStopThread(gamePlaceId);
                            threadExecutorCached.execute(gameStopCtrlThread);
                        }
                    }
                }
                else if(type.equals("blue"))
                {
                    String point = blueGoalMapping.get(gamePlaceId);
                    point = String.valueOf(Integer.parseInt(point)+1);
                    blueGoalMapping.put(gamePlaceId,point);

                    //判断是否达到了WinPoint，若达到了，则比赛结束，进入判分流程
                    if(Integer.parseInt(point)>=Integer.parseInt(gameParamDTO.getWinPoint()))
                    {
                        gameStatus = gameStatusMapping.get(gamePlaceId);
                        if(!gameStatus.equals("end"))
                        {
                            gameResultMapping.put(gamePlaceId,"bluePartWin");
                            gameStatusMapping.put(gamePlaceId,"end");

                            Runnable gameStopCtrlThread = new GameStopThread(gamePlaceId);
                            threadExecutorCached.execute(gameStopCtrlThread);
                        }
                    }
                }
            }
        }
    }

    public void processDeviceProblemService(Map<String, Object> msgMap, Channel channel) {

        String gamePlaceId = String.valueOf(msgMap.get("gamePlaceId"));

        //如果有设备异常，终止所有比赛
        //根据gamePlaceId获取旗下所有的设备ID
        Query query = new Query(Criteria.where("gamePlaceId").is(gamePlaceId));
        List<DeviceParamDTO> deviceParamDTOS = mongoTemplate.find(query,DeviceParamDTO.class,"deviceParam");

        if(deviceParamDTOS.size()>0)
        {
            for(DeviceParamDTO deviceParamDTO:deviceParamDTOS)
            {
                Channel deviceChannel = deviceChannelMapping.get(deviceParamDTO.getDeviceId());

                //给设备发送游戏结束指令
                JSONObject obj = new JSONObject();
                obj.put("command", "gameStop");
                TextWebSocketFrame frame = new TextWebSocketFrame(obj.toJSONString());
                deviceChannel.writeAndFlush(frame.retain());

                gameResultMapping.put(gamePlaceId,"noPartWin");
                gameStatusMapping.put(gamePlaceId,"end");
            }
        }

        deviceProblemMapping.put("deviceProblem"+gamePlaceId,String.valueOf(msgMap.get("deviceProblemCode")));

        Runnable gameStopCtrlThread = new GameStopThread(gamePlaceId);
        threadExecutorCached.execute(gameStopCtrlThread);
    }

    public ResponseDTO startGame(String gamePlaceId) {

        ResponseDTO responseDTO = new ResponseDTO();

        String gameStatus = gameStatusMapping.get(gamePlaceId);

        if(gameStatus==null||"end".equals(gameStatus))
        {
            //初始化所有联机的设备变量
            synchronized (gamePlaceId)
            {
                removeCurrentHashMap(gameStatusMapping,gamePlaceId);
                removeCurrentHashMap(redGoalMapping,gamePlaceId);
                removeCurrentHashMap(blueGoalMapping,gamePlaceId);

                //根据gamePlaceId获取旗下所有的设备ID
                Query query = new Query(Criteria.where("gamePlaceId").is(gamePlaceId));
                List<DeviceParamDTO> deviceParamDTOS = mongoTemplate.find(query,DeviceParamDTO.class,"deviceParam");

                int doorOnlineNum = 0;
                int carOnlineNum = 0;
                int userBindNum = 0;

                if(deviceParamDTOS.size()>0)
                {
                    //进行分组操作
                    for(DeviceParamDTO deviceParamDTO:deviceParamDTOS)
                    {
                        String deviceOnlineStatus =  deviceOnLineMapping.get(deviceParamDTO.getDeviceId());
                        if(deviceOnlineStatus!=null)
                        {
                            if(deviceOnlineStatus.equals("online"))
                            {
                                if(deviceParamDTO.getDeviceType().equals("door"))
                                {
                                    doorOnlineNum++;
                                }else if(deviceParamDTO.getDeviceType().equals("car"))
                                {
                                    carOnlineNum++;
                                    if(carUserMapping.get(deviceParamDTO.getDeviceId())!=null)
                                    {
                                        userBindNum++;
                                    }
                                }

                            }
                        }
                    }
                }

                if(doorOnlineNum==2&&(carOnlineNum%2==0)&&(carOnlineNum!=0)&&(carOnlineNum==userBindNum))
                {
                    String doorPart = "red";
                    String carPart = "red";

                    //todo 初始化内存里面的参数
                    initialGameParam(gamePlaceId);

                    for(DeviceParamDTO deviceParamDTO:deviceParamDTOS)
                    {
                        removeCurrentHashMap(devicePartMapping,deviceParamDTO.getDeviceId());

                        //给设备发送游戏开始指令
                        Channel channel = deviceChannelMapping.get(deviceParamDTO.getDeviceId());

                        if(channel!=null)
                        {
                            TextWebSocketFrame frame = null;
                            JSONObject obj = new JSONObject();
                            obj.put("command", "gameBegin");
                            obj.put("gamePlaceId", gamePlaceId);

                            if(deviceParamDTO.getDeviceType().equals("door"))
                            {
                                deviceParamDTO.setDeviceType(doorPart);
                                if(doorPart.equals("red"))
                                {
                                    doorPart = "blue";
                                }
                                else if(doorPart.equals("blue"))
                                {
                                    doorPart = "red";
                                }
                                obj.put("part",doorPart);
                                obj.put("deviceType","door");
                                devicePartMapping.put(deviceParamDTO.getDeviceId(),doorPart);
                            }
                            else if(deviceParamDTO.getDeviceType().equals("car"))
                            {
                                deviceParamDTO.setDeviceType(carPart);
                                if(carPart.equals("red"))
                                {
                                    carPart = "blue";
                                    obj.put("part",carPart);
                                    obj.put("deviceType","car");
                                    devicePartMapping.put(deviceParamDTO.getDeviceId(),carPart);
                                }
                                else if(carPart.equals("blue"))
                                {
                                    carPart = "red";
                                    obj.put("part",carPart);
                                    obj.put("deviceType","car");
                                    devicePartMapping.put(deviceParamDTO.getDeviceId(),carPart);
                                }
                                deviceDeadMapping.put(deviceParamDTO.getDeviceId(),0);
                            }
                            frame = new TextWebSocketFrame(obj.toJSONString());
                            channel.writeAndFlush(frame.retain());
                        }
                    }

                    //设置游戏的时间，启动游戏线程
                    Runnable gameProcessThread = new GameProcessThread(gamePlaceId);
                    threadExecutorCached.execute(gameProcessThread);

                    responseDTO.setResponseData(deviceParamDTOS);
                    responseDTO.setResult(StatusConstant.SUCCESS);
                }
                else
                {
                    responseDTO.setResult(StatusConstant.FAILURE);
                }

            }
        }
        return responseDTO;
    }

    public ResponseDTO endGame(String gamePlaceId) {

        ResponseDTO responseDTO = new ResponseDTO();
        String gameStatus = gameStatusMapping.get(gamePlaceId);
        if("ongoing".equals(gameStatus))
        {
            //初始化所有联机的设备变量
            synchronized (gamePlaceId)
            {
                //启动游戏结束线程
                Runnable gameStopCtrlThread = new GameStopThread(gamePlaceId);
                threadExecutorCached.execute(gameStopCtrlThread);
            }
        }
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    public ResponseDTO getDeviceOnline(String gamePlaceId) {
        ResponseDTO responseDTO = new ResponseDTO();

        Query query = new Query(Criteria.where("gamePlaceId").is(gamePlaceId));
        List<DeviceParamDTO> deviceParamDTOS = mongoTemplate.find(query,DeviceParamDTO.class,"deviceParam");

        List<HashMap<String,Object>> hashMapList = new ArrayList<>();
        for(DeviceParamDTO deviceParamDTO:deviceParamDTOS)
        {
            HashMap<String,Object> hashMap = new HashMap<>();
            if(deviceOnLineMapping.get(deviceParamDTO.getDeviceId())!=null)
            {
                hashMap.put(deviceParamDTO.getDeviceId(),deviceOnLineMapping.get(deviceParamDTO.getDeviceId()));
                hashMapList.add(hashMap);
            }
        }
        responseDTO.setResponseData(hashMapList);
        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    public ResponseDTO getPartTotalDamage(String gamePlaceId,String part) {
        ResponseDTO responseDTO = new ResponseDTO();

        if(part.equals("red"))
        {
            responseDTO.setResponseData(partTotalDamageMapping.get("red"+gamePlaceId));
        }
        else if(part.equals("blue"))
        {
            responseDTO.setResponseData(partTotalDamageMapping.get("blue"+gamePlaceId));
        }

        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    public ResponseDTO getGoalResult(String gamePlaceId, String part) {
        ResponseDTO responseDTO = new ResponseDTO();

        if(part.equals("red"))
        {
            responseDTO.setResponseData(redGoalMapping.get(gamePlaceId));
        }
        else if(part.equals("blue"))
        {
            responseDTO.setResponseData(blueGoalMapping.get(gamePlaceId));
        }

        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    public ResponseDTO getCarDamage(String deviceId) {
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setResponseData(carDamageMapping.get(deviceId));

        responseDTO.setResult(StatusConstant.SUCCESS);
        return responseDTO;
    }

    public void bindUserAndCar(String carId, WeixinUserBean weixinUserBean) {
        carUserMapping.put(carId,weixinUserBean);
        userCarMapping.put(weixinUserBean.getOpenid(),carId);
    }

    public class GameStopThread extends Thread {
        public String gamePlaceId;

        public GameStopThread(String gamePlaceId) {
            this.gamePlaceId = gamePlaceId;
        }

        @Override
        public void run() {

            Query query = new Query(Criteria.where("gamePlaceId").is(gamePlaceId));
            List<DeviceParamDTO> deviceParamDTOS = mongoTemplate.find(query,DeviceParamDTO.class,"deviceParam");

            for(DeviceParamDTO deviceParamDTO:deviceParamDTOS)
            {
                //给设备发送游戏结束指令
                Channel channel = deviceChannelMapping.get(deviceParamDTO.getDeviceId());
                JSONObject obj = new JSONObject();
                obj.put("command", "gameStop");
                TextWebSocketFrame frame = new TextWebSocketFrame(obj.toJSONString());
                channel.writeAndFlush(frame.retain());

                removeCurrentHashMap(carDamageMapping,deviceParamDTO.getDeviceId());
                removeCurrentHashMap(damageLockMapping,deviceParamDTO.getDeviceId());
                //removeCurrentHashMap(devicePartMapping,deviceParamDTO.getDeviceId());
                removeCurrentHashMap(carDamageMapping,deviceParamDTO.getDeviceId());
                removeCurrentHashMap(carUserMapping,deviceParamDTO.getDeviceId());
                removeCurrentValueHashMap(userCarMapping,deviceParamDTO.getDeviceId());
            }

            //removeCurrentHashMap(gameResultMapping,gamePlaceId);
            removeCurrentHashMap(gameParamMapping,gamePlaceId);
            removeCurrentHashMap(partTotalDamageMapping,"red"+gamePlaceId);
            removeCurrentHashMap(partTotalDamageMapping,"blue"+gamePlaceId);
            removeCurrentHashMap(partTotalDeadMapping,"red"+gamePlaceId);
            removeCurrentHashMap(partTotalDeadMapping,"blue"+gamePlaceId);

            List<AttackParamDTO> attackParamDTOS = mongoTemplate.find(query,AttackParamDTO.class,"attackParam");
            for(AttackParamDTO attackParamDTO:attackParamDTOS)
            {
                removeCurrentHashMap(attackParamMapping,gamePlaceId+attackParamDTO.getPartName());
            }

            gameStatusMapping.put(gamePlaceId,"end");
            if(Integer.parseInt(blueGoalMapping.get(gamePlaceId))==Integer.parseInt(redGoalMapping.get(gamePlaceId)))
            {
                gameResultMapping.put(gamePlaceId,"noPartWin");
            }
            else if(Integer.parseInt(blueGoalMapping.get(gamePlaceId))>Integer.parseInt(redGoalMapping.get(gamePlaceId)))
            {
                gameResultMapping.put(gamePlaceId,"bluePartWin");
            }
            else if(Integer.parseInt(blueGoalMapping.get(gamePlaceId))<Integer.parseInt(redGoalMapping.get(gamePlaceId)))
            {
                gameResultMapping.put(gamePlaceId,"redPartWin");
            }
        }
    }

    public class GameProcessThread extends Thread {
        public String gamePlaceId;

        public GameProcessThread(String gamePlaceId) {
            this.gamePlaceId = gamePlaceId;
        }

        @Override
        public void run() {

            GameParamDTO gameParamDTO = gameParamMapping.get(gamePlaceId);
            gameStatusMapping.put(gamePlaceId,"ongoing");
            redGoalMapping.put(gamePlaceId,"0");
            blueGoalMapping.put(gamePlaceId,"0");
            int time = gameParamDTO.getGameTotalTime();
            while (time > 0) {
                time--;
                try {
                    Thread.sleep(1000);
                    gameParamDTO.setGameTotalTime(time);
                    gameParamMapping.put(gamePlaceId,gameParamDTO);

                    //读取游戏状态，如果游戏因为比分差距结束了，则退出游戏
                    String gameStatus = gameStatusMapping.get(gamePlaceId);
                    if(gameStatus.equals("end"))
                    {
                        gameParamDTO.setGameTotalTime(0);
                        gameParamMapping.put(gamePlaceId,gameParamDTO);
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //倒计时时间结束后，进行的游戏结束，启动判分流程
            //分别获取红方和蓝方的得分
            String gameStatus = gameStatusMapping.get(gamePlaceId);
            if(!gameStatus.equals("end"))
            {
                int redPartPoint = 0;
                int bluePartPoint = 0;
                Query query = new Query(Criteria.where("gamePlaceId").is(gamePlaceId));
                List<GamePointDTO> gamePointDTOS = mongoTemplate.find(query,GamePointDTO.class,"gamePointDTO");
                for(GamePointDTO gamePointDTO:gamePointDTOS)
                {
                    if(gamePointDTO.getPartType().equals("red"))
                    {
                        redPartPoint = gamePointDTO.getPoint();
                    }
                    else if(gamePointDTO.getPartType().equals("blue"))
                    {
                        bluePartPoint = gamePointDTO.getPoint();
                    }
                }
                if(redPartPoint>bluePartPoint){
                    gameResultMapping.put(gamePlaceId,"redPartWin");
                }else if(redPartPoint<bluePartPoint){
                    gameResultMapping.put(gamePlaceId,"bluePartWin");
                }else if(redPartPoint==bluePartPoint){
                    gameResultMapping.put(gamePlaceId,"noPartWin");
                }

                gameStatusMapping.put(gamePlaceId,"end");

                List<DeviceParamDTO> deviceParamDTOS = mongoTemplate.find(query,DeviceParamDTO.class,"deviceParam");

                for(DeviceParamDTO deviceParamDTO:deviceParamDTOS)
                {
                    Channel channel = deviceChannelMapping.get(deviceParamDTO.getDeviceId());
                    if(channel!=null)
                    {
                        JSONObject obj = new JSONObject();
                        obj.put("command", "gameStop");
                        TextWebSocketFrame frame = new TextWebSocketFrame(obj.toJSONString());
                        channel.writeAndFlush(frame.retain());
                    }
                }

                //启动游戏结束线程
                Runnable gameStopCtrlThread = new GameStopThread(gamePlaceId);
                threadExecutorCached.execute(gameStopCtrlThread);
            }
        }
    }

    public class DizzyProcessThread extends Thread {
        public DeviceParamDTO deviceParamDTO;
        public Channel channel;

        public DizzyProcessThread(DeviceParamDTO deviceParamDTO,Channel channel) {
            this.deviceParamDTO = deviceParamDTO;
            this.channel = channel;
        }

        @Override
        public void run() {

            synchronized (deviceParamDTO.getDeviceId())
            {
                GameParamDTO gameParamDTO = gameParamMapping.get(deviceParamDTO.getGamePlaceId());

                try {

                    int deadValue = deviceDeadMapping.get(deviceParamDTO.getDeviceId());
                    deviceDeadMapping.put(deviceParamDTO.getDeviceId(),deadValue++);

                    //死亡总数增加1
//                    if(deviceParamDTO.getType().equals("red"))
//                    {
//                        String redTotalDead = partTotalDeadMapping.get("red"+deviceParamDTO.getGamePlaceId());
//                        if(redTotalDead==null)
//                        {
//                            redTotalDead="0";
//                        }
//                        redTotalDead = String.valueOf(Integer.parseInt(redTotalDead)+1);
//                        partTotalDeadMapping.put("red"+deviceParamDTO.getGamePlaceId(),redTotalDead);
//                    }
//                    else if(deviceParamDTO.getType().equals("blue"))
//                    {
//                        String blueTotalDead = partTotalDeadMapping.get("blue"+deviceParamDTO.getGamePlaceId());
//                        if(blueTotalDead==null)
//                        {
//                            blueTotalDead="0";
//                        }
//                        blueTotalDead = String.valueOf(Integer.parseInt(blueTotalDead)+1);
//                        partTotalDeadMapping.put("blue"+deviceParamDTO.getGamePlaceId(),blueTotalDead);
//                    }

                    TextWebSocketFrame frame = null;
                    //获取晕厥时间，进入晕厥状态
                    //向机器人发送晕厥指令
                    JSONObject obj = new JSONObject();
                    obj.put("command", "carDizzy");
                    obj.put("operation", "on");
                    frame = new TextWebSocketFrame(obj.toJSONString());
                    channel.writeAndFlush(frame.retain());
                    Thread.sleep(gameParamDTO.getDizzyTime()*1000);
                    obj.put("command", "carDizzy");
                    obj.put("operation", "off");
                    frame = new TextWebSocketFrame(obj.toJSONString());
                    channel.writeAndFlush(frame.retain());

                    //发送无敌指令,设定无敌时间
                    obj.put("command", "invulnerable");
                    obj.put("operation", "on");
                    frame = new TextWebSocketFrame(obj.toJSONString());
                    channel.writeAndFlush(frame.retain());
                    Thread.sleep(gameParamDTO.getInvulnerableTime()*1000);
                    obj.put("command", "invulnerable");
                    obj.put("operation", "off");
                    frame = new TextWebSocketFrame(obj.toJSONString());
                    channel.writeAndFlush(frame.retain());

                    carDamageMapping.put(deviceParamDTO.getDeviceId(),gameParamDTO.getMaxHP());
                    damageLockMapping.put(deviceParamDTO.getDeviceId(),"false");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //todo 游戏开始的时候，初始化数据
    public void initialGameParam(String gamePlaceId)
    {
        Query query = new Query(Criteria.where("gamePlaceId").is(gamePlaceId));

        removeCurrentHashMap(gameResultMapping,gamePlaceId);
        removeCurrentHashMap(deviceProblemMapping,"deviceProblem"+gamePlaceId);

        List<AttackParamDTO> attackParamDTOS = mongoTemplate.find(query,AttackParamDTO.class,"attackParam");
        for(AttackParamDTO attackParamDTO:attackParamDTOS)
        {
            attackParamMapping.put(gamePlaceId+attackParamDTO.getPartName(),attackParamDTO);
        }

        List<GameParamDTO> gameParamDTOS = mongoTemplate.find(query,GameParamDTO.class,"gameParam");
        gameParamMapping.put(gamePlaceId,gameParamDTOS.get(0));
    }

    //清除内存中的数据
    public void removeCurrentHashMap(Map map,String id)
    {
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            if(key.equals(id))
            {
                map.remove(key);
            }
        }
    }

    public void removeCurrentValueHashMap(Map map,String value)
    {
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            if(map.get(key).equals(value))
            {
                map.remove(key);
            }
        }
    }

    public void processServerHeartBeatCtrl(Map<String, Object> msgMap, Channel channel) {

        String gamePlaceId = String.valueOf(msgMap.get("gamePlaceId"));
        Query query = new Query(Criteria.where("gamePlaceId").is(gamePlaceId));
        List<DeviceParamDTO> deviceParamDTOS = mongoTemplate.find(query,DeviceParamDTO.class,"deviceParam");
        List<DeviceParamDTO> bluePartCarList = new ArrayList<>();
        List<DeviceParamDTO> redPartCarList = new ArrayList<>();
        HashMap<String,String> doorMap = new HashMap<>();
        List<HashMap<String,String>> carDamageList = new ArrayList<>();
        List<HashMap<String,String>> carDeadList = new ArrayList<>();
        List<HashMap<String,Object>> carUserList = new ArrayList<>();
        for(DeviceParamDTO deviceParamDTO:deviceParamDTOS)
        {
            if("blue".equals(devicePartMapping.get(deviceParamDTO.getDeviceId())))
            {
                if(deviceParamDTO.getDeviceType().equals("door"))
                {
                    doorMap.put("blue","online");
                }
                else if(deviceParamDTO.getDeviceType().equals("car"))
                {
                    bluePartCarList.add(deviceParamDTO);
                }
            }
            else if("red".equals(devicePartMapping.get(deviceParamDTO.getDeviceId())))
            {
                if(deviceParamDTO.getDeviceType().equals("door"))
                {
                    doorMap.put("red","online");
                }
                else if(deviceParamDTO.getDeviceType().equals("car"))
                {
                    redPartCarList.add(deviceParamDTO);
                }
            }

            HashMap<String,String> carDamageMap = new HashMap<>();
            if(carDamageMapping.get(deviceParamDTO.getDeviceId())==null)
            {
                carDamageMap.put("deviceId",deviceParamDTO.getDeviceId());
                carDamageMap.put("value","100");
            }
            else
            {
                carDamageMap.put("deviceId",deviceParamDTO.getDeviceId());
                carDamageMap.put("value",carDamageMapping.get(deviceParamDTO.getDeviceId()));
            }
            carDamageList.add(carDamageMap);


            HashMap<String,String> carDeadMap = new HashMap<>();
            if(deviceDeadMapping.get(deviceParamDTO.getDeviceId())==null)
            {
                carDeadMap.put("deviceId",deviceParamDTO.getDeviceId());
                carDeadMap.put("value","0");
            }
            else
            {
                carDeadMap.put("deviceId",deviceParamDTO.getDeviceId());
                carDeadMap.put("value",String.valueOf(deviceDeadMapping.get(deviceParamDTO.getDeviceId())));
            }
            carDeadList.add(carDeadMap);

            HashMap<String,Object> carUserMap = new HashMap<>();
            if(carUserMapping.get(deviceParamDTO.getDeviceId())!=null)
            {
                carUserMap.put("carId",deviceParamDTO.getDeviceId());
                carUserMap.put("value",carUserMapping.get(deviceParamDTO.getDeviceId()));
                carUserList.add(carUserMap);
            }
        }

        JSONObject obj = new JSONObject();
        obj.put("bluePartCarList", bluePartCarList);
        obj.put("redPartCarList", redPartCarList);
        obj.put("doorMap", doorMap);
        obj.put("carDeadList",carDeadList);
        obj.put("carDamageList", carDamageList);
        obj.put("carUserList",carUserList);

        String gameStatus = gameStatusMapping.get(gamePlaceId);

        if(gameStatus==null)
        {
            obj.put("gameStatus", "gameNotStart");
        }
        if("ongoing".equals(gameStatus))
        {
            obj.put("gameStatus", "ongoing");
        }
        else if("end".equals(gameStatus))
        {
            obj.put("gameStatus", "end");
        }

        obj.put("gameResult", gameResultMapping.get(gamePlaceId)+";"+gamePlaceId);

        String redTotalDamage = partTotalDamageMapping.get("red"+gamePlaceId);
        if(redTotalDamage==null)
        {
            obj.put("redTotalDamage", "0");
        }
        else
        {
            obj.put("redTotalDamage", redTotalDamage);
        }

        String blueTotalDamage = partTotalDamageMapping.get("blue"+gamePlaceId);
        if(blueTotalDamage==null)
        {
            obj.put("blueTotalDamage", "0");
        }
        else
        {
            obj.put("blueTotalDamage", blueTotalDamage);
        }

        String redTotalDead = partTotalDeadMapping.get("red"+gamePlaceId);
        if(redTotalDead==null)
        {
            obj.put("redTotalDead", "0");
        }
        else
        {
            obj.put("redTotalDead", redTotalDead);
        }

        String blueTotalDead = partTotalDeadMapping.get("blue"+gamePlaceId);
        if(blueTotalDead==null)
        {
            obj.put("blueTotalDead", "0");
        }
        else
        {
            obj.put("blueTotalDead", blueTotalDead);
        }

        String redGoal = redGoalMapping.get(gamePlaceId);
        if(redGoal==null)
        {
            obj.put("redGoal", "0");
        }
        else
        {
            obj.put("redGoal", redGoal);
        }

        String blueGoal = blueGoalMapping.get(gamePlaceId);
        if(blueGoal==null)
        {
            obj.put("blueGoal", "0");
        }
        else
        {
            obj.put("blueGoal", blueGoal);
        }

        GameParamDTO gameParamDTO = gameParamMapping.get(gamePlaceId);

        obj.put("gameParam",gameParamDTO);

        TextWebSocketFrame frame = new TextWebSocketFrame(obj.toJSONString());
        channel.writeAndFlush(frame.retain());
    }
}
