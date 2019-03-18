angular.module('controllers',[]).controller('bigShowCtrl',
    ['$scope','$interval','$rootScope','$stateParams','$state','Global','$timeout','RobotUtil',
        function ($scope,$interval,$rootScope,$stateParams,$state,Global,$timeout,RobotUtil) {

            //加载element模块
            layui.use('element', function(){
                var element = layui.element;
            });

            //layui相关操作写在这里
            layui.use('layer', function(){
                var layer = layui.layer;
            });

            // $scope.gamePlaceId = "0x10000000"

            $scope.param = {
                gameBegin: false,
                bluePartRobotList:[],
                redPartRobotList:[],
                robotUserList:[],
                doorMap:{},
                gameResult:{},
                gameStatus:"end",
                redTotalDamage:0,
                blueTotalDamage:0,
                redTotalDead:0,
                blueTotalDead:0,
                redGoal:0,
                blueGoal:0,
                robotDamage:{},
                gameOver: "false",
                inputGamePlaceId : ""
            }

            $scope.gamePlaceId = "none";

            $scope.start = false;
            $scope.start1 = true;
            $scope.startGame = false;
            $scope.gamePartWinResult = {
                gamePlaceId:$scope.gamePlaceId,
                gameResultValue:""
            };


            $scope.confirmGamePlace = function(){
                $scope.gamePlaceId  = $scope.param.inputGamePlaceId;
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
                $scope.param.gameStatus = consultData.gameStatus;
                $scope.param.gameResult = consultData.gameResult;
                $scope.param.redGoal = consultData.redGoal;
                $scope.param.blueGoal = consultData.blueGoal;
                $scope.param.bluePartRobotList = consultData.bluePartRobotList;
                $scope.param.redPartRobotList = consultData.redPartRobotList;
                if($scope.param.gameStatus=="ongoing")
                {
                    $scope.param.gameOver = "false";
                    $scope.param.doorMap = consultData.doorMap;
                    $scope.param.redTotalDamage = consultData.redTotalDamage;
                    $scope.param.blueTotalDamage = consultData.blueTotalDamage;
                    $scope.param.redTotalDead = consultData.redTotalDead;
                    $scope.param.blueTotalDead = consultData.blueTotalDead;
                    $scope.param.robotDamageList = consultData.robotDamageList;
                    $scope.param.robotDeadList = consultData.robotDeadList;
                    $scope.param.gameParam = consultData.gameParam;
                    $scope.param.robotUserList = consultData.robotUserList;
                    $scope.param.gameTime = formatSeconds($scope.param.gameParam.gameTotalTime);

                    if(!$scope.start)
                    {
                        //演示数据
                        $scope.start = false;
                        $scope.start1 = true;

                        $timeout(function(){
                            $scope.start = true;
                            //首页倒计时
                            $scope.hostCount = 5;
                            setInterval(function(){
                                if($scope.hostCount > 1){
                                    $scope.hostCount--;
                                }else{
                                    $scope.start1 = false;
                                    $scope.startGame = true;
                                }
                            },1000)
                        },1000)
                    }
                }
                else if($scope.param.gameStatus=="end")
                {
                    $scope.start = false;
                    $scope.start1 = true;
                    $scope.startGame = false;
                    $scope.param.gameOver = "true";

                    if($scope.param.gameResult.indexOf('redPartWin')!=-1)
                    {
                        var value =  $scope.param.gameResult.split(";");
                        $scope.gamePartWinResult.gamePlaceId = value[1];
                        $scope.gamePartWinResult.gameResultValue = 'redPartWin';
                    }
                    else if($scope.param.gameResult.indexOf('bluePartWin')!=-1)
                    {
                        var value =  $scope.param.gameResult.split(";");
                        $scope.gamePartWinResult.gamePlaceId = value[1];
                        $scope.gamePartWinResult.gameResultValue = 'bluePartWin';
                    }
                    else if($scope.param.gameResult.indexOf('noPartWin')!=-1)
                    {
                        var value =  $scope.param.gameResult.split(";");
                        $scope.gamePartWinResult.gamePlaceId = value[1];
                        $scope.gamePartWinResult.gameResultValue = 'noPartWin';
                    }
                }

                console.log($scope.param);

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