angular.module('controllers',[]).controller('gameControlCtrl',
    ['$scope','$interval','$rootScope','$stateParams','$state','Global','$timeout','CarUtil','GameBegin','GameStop',
        function ($scope,$interval,$rootScope,$stateParams,$state,Global,$timeout,CarUtil,GameBegin,GameStop) {

    //0x10000000

            $scope.param = {
                gameBegin: false,
                bluePartCarList:[],
                redPartCarList:[],
                doorMap:{},
                gameResult:{},
                gameStatus:"end",
                redTotalDamage:0,
                blueTotalDamage:0,
                redTotalDead:0,
                blueTotalDead:0,
                redGoal:0,
                blueGoal:0,
                carDamage:{},
                carUserList:[],
                inputGamePlaceId : ""
            }

            $scope.gamePlaceId = "none";

            $scope.confirmGamePlace = function(){
                $scope.gamePlaceId  = $scope.param.inputGamePlaceId;
            }

            //加载element模块
            layui.use('element', function () {
                var element = layui.element;
            });

            //加载form模块
            layui.use('form', function () {
                var form = layui.form;

                //各种基于事件的操作
            });

            //layui相关操作写在这里
            layui.use('layer', function () {
                var layer = layui.layer;

                //退出控制台
                $scope.quit = function () {
                    layer.confirm('确定要退出登录吗？', {
                        title: '退出确认'
                    }, function (index) {
                        //do something

                        layer.close(index);
                    });
                }

            });

            $scope.clickStartGame = function (){
                GameBegin.get({gamePlaceId:$scope.gamePlaceId},function (data) {
                    if(data.result==Global.FAILURE)
                    {
                        alert("游戏启动失败，接入设备达不到启动需求")
                    }
                })
            }

            $scope.clickEndGame = function(){
                GameStop.get({gamePlaceId:$scope.gamePlaceId},function (data) {
                })
            }

            //禁止玩家加入
            $scope.playerJoin = '禁止';
            $scope.gameStatus = '等待玩家加入';
            $scope.join = function() {
                layer.open({
                    title:'提示',
                    content: '您已'+ $scope.playerJoin +'玩家加入'
                }, function(index) {
                    layer.close(index);
                });
                if($scope.playerJoin == '禁止') {
                    $scope.playerJoin = '允许';
                    $scope.gameStatus = '禁止玩家加入';
                } else {
                    $scope.playerJoin = '禁止';
                    $scope.gameStatus = '等待玩家加入';
                }
            }

            //重启
            $scope.restart = function() {
                layer.confirm('确定要重启该设备吗？', {
                    title: '重启确认'
                }, function(index) {
                    //do something

                    layer.close(index);
                });
            }

            //关机
            $scope.close = function() {
                layer.confirm('确定要关闭该设备吗？', {
                    title: '关闭确认'
                }, function(index) {
                    //do something
                    layer.close(index);
                });
            }

            //tab切换
            $scope.pageType = 'controlPage';
            $scope.control = function() {
                $scope.pageType = 'controlPage';
            }
            $scope.rule = function() {
                $scope.pageType = 'rulePage';
            }

            //规则修改
            //演示数据
            var data1 = {
                maxTime: 120,
                gameSystem: 1,
                winNum: 20,
                gameMaxNum: 200,
                blueMaxNum: 100,
                redMaxNum: 100,
                bloodNum: 1000,
                faintTime: 280,
                invincibleTime: 190,
                oneNum: 2,
                twoNum: 3,
                threeNum: 7
            }
            var data2 = {
                maxTime: 120,
                gameSystem: 1,
                winNum: 20,
                gameMaxNum: 200,
                blueMaxNum: 100,
                redMaxNum: 100,
                bloodNum: 1000,
                faintTime: 280,
                invincibleTime: 190,
                oneNum: 2,
                twoNum: 3,
                threeNum: 7
            }
            $scope.data = data1;
            $scope.revampNum = false;
            $scope.changeNum = function() {
                console.log(data1)
                for(var i in data2) {
                    if(data2[i] != $scope.data[i]) {
                        $scope.revampNum = true;
                    }
                }
            }

            //确认修改规则
            $scope.submit = function() {
                if($scope.revampNum){
                    layer.open({
                        title: '',
                        content: '修改成功'
                    });
                    $scope.revampNum = false;
                }
            }

            //放弃修改规则
            $scope.restore = function() {
                if($scope.revampNum){
                    $scope.revampNum = false;
                    $scope.data = {
                        maxTime: 120,
                        gameSystem: 1,
                        winNum: 20,
                        gameMaxNum: 200,
                        blueMaxNum: 100,
                        redMaxNum: 100,
                        bloodNum: 1000,
                        faintTime: 280,
                        invincibleTime: 190,
                        oneNum: 2,
                        twoNum: 3,
                        threeNum: 7
                    }
                }
            }

            $scope.socketServerFirst = "";
            if (!window.WebSocket) {
                window.WebSocket = window.MozWebSocket;
            }
            if (window.WebSocket){
                console.log("socket is ok ");
                $scope.socketServerAddress = "119.23.236.55";
                $scope.socketServerFirst = new WebSocket("ws://" + $scope.socketServerAddress +":8080");
            }

            $scope.socketServerFirst.onmessage = function (event) {
                var consultData = JSON.parse(event.data);
                console.log(consultData);
                $scope.param.bluePartCarList = consultData.bluePartCarList;
                $scope.param.redPartCarList = consultData.redPartCarList;
                $scope.param.doorMap = consultData.doorMap;
                $scope.param.gameResult = consultData.gameResult;
                $scope.param.gameStatus = consultData.gameStatus;
                $scope.param.redTotalDamage = consultData.redTotalDamage;
                $scope.param.blueTotalDamage = consultData.blueTotalDamage;
                $scope.param.redTotalDead = consultData.redTotalDead;
                $scope.param.blueTotalDead = consultData.blueTotalDead;
                $scope.param.redGoal = consultData.redGoal;
                $scope.param.blueGoal = consultData.blueGoal;
                $scope.param.carDamageList = consultData.carDamageList;
                $scope.param.carDeadList = consultData.carDeadList;
                $scope.param.gameParam = consultData.gameParam;
                $scope.param.carUserList = consultData.carUserList;

                if($scope.param.gameParam!=undefined) {
                    $scope.param.gameTime = formatSeconds($scope.param.gameParam.gameTotalTime);
                }
                else {
                    $scope.param.gameTime = "";
                }

                $scope.$apply();
            };

            function formatSeconds(value) {
                var secondTime = parseInt(value);// 秒
                var minuteTime = 0;// 分
                var hourTime = 0;// 小时
                if(secondTime > 60) {//如果秒数大于60，将秒数转换成整数
                    //获取分钟，除以60取整数，得到整数分钟
                    minuteTime = parseInt(secondTime / 60);
                    //获取秒数，秒数取佘，得到整数秒数
                    secondTime = parseInt(secondTime % 60);
                    //如果分钟大于60，将分钟转换成小时
                    if(minuteTime > 60) {
                        //获取小时，获取分钟除以60，得到整数小时
                        hourTime = parseInt(minuteTime / 60);
                        //获取小时后取佘的分，获取分钟除以60取佘的分
                        minuteTime = parseInt(minuteTime % 60);
                    }
                }
                var result = "" + parseInt(secondTime) + "秒";

                if(minuteTime > 0) {
                    result = "" + parseInt(minuteTime) + "分" + result;
                }
                if(hourTime > 0) {
                    result = "" + parseInt(hourTime) + "小时" + result;
                }

                if(secondTime==0&&minuteTime==0&&hourTime==0)
                {
                    GameStop.get({gamePlaceId:$scope.gamePlaceId},function (data) {
                    })
                }
                return result;
            }

            $scope.socketServerFirst.onopen = function (event) {
                console.log("open"+event);
                //每隔一秒执行一次
                setInterval(function(){

                    var heartBeatMessage = {
                        "gamePlaceId":$scope.gamePlaceId,
                        "messageType":"gameServerHeart-Ctrl"
                    }

                    $scope.socketServerFirst.send(JSON.stringify(heartBeatMessage));

                }, 500);
            };
}]);