angular.module('controllers',[]).controller('agencyParticularsCtrl',
    ['$scope','$interval','$rootScope','$stateParams','$state','Global','$timeout','QueryUserBusinessById','QueryNextUserById','ManagementUtil',
        function ($scope,$interval,$rootScope,$stateParams,$state,Global,$timeout,QueryUserBusinessById,QueryNextUserById,ManagementUtil) {

            $scope.mum = true;
            QueryUserBusinessById.get({
                sysUserId:$stateParams.id
            },function(data){
                ManagementUtil.checkResponseData(data,"");
                if(data.result == Global.SUCCESS){
                    $scope.mum = false;
                    $scope.selfMessage = data.responseData.responseData;

                    for(var i=0;i<$scope.selfMessage.length;i++){
                        $scope.selfMessage[i].userType = $scope.selfMessage[i].userType.substring(9,10)
                    }

                }
            });
            QueryNextUserById.get({
                sysUserId:$stateParams.id
            },function(data){
                ManagementUtil.checkResponseData(data,"");
                if(data.result == Global.SUCCESS){
                    $scope.mum = false;
                    if(data.responseData.responseData==undefined){
                        $scope.juniorMessage = []
                    }else{
                        $scope.juniorMessage = data.responseData.responseData;
                        for(var i=0;i<$scope.juniorMessage.length;i++){
                            $scope.juniorMessage[i].userType = $scope.juniorMessage[i].userType.substring(9,10);
                            if($scope.juniorMessage[i].weixinAttentionStatus == "1"){
                                $scope.juniorMessage[i].weixinAttentionStatus = "是"
                            }else if($scope.juniorMessage[i].weixinAttentionStatus == "0"){
                                $scope.juniorMessage[i].weixinAttentionStatus = "否"
                            }
                        }
                    }

                }
            });



/*日期插件*/
            $scope.dataS =  function(id){
                !function(id){
                    laydate.skin('danlan');//切换皮肤，可查看skins下面皮肤库
                    laydate({elem: id});//绑定元素
                }();
                //日期范围限制
                var start = {
                    elem: '#start',
                    format: 'YYYY-MM-DD',
                    min: laydate.now(), //设定最小日期为当前日期
                    max: '2099-06-16', //最大日期
                    istime: true,
                    istoday: false,
                    choose: function(datas){
                        end.min = datas; //开始日选好后，重置结束日的最小日期
                        end.start = datas //将结束日的初始值设定为开始日
                    }
                };

                var end = {
                    elem: '#end',
                    format: 'YYYY-MM-DD',
                    min: laydate.now(),
                    max: '2099-06-16',
                    istime: true,
                    istoday: false,
                    choose: function(datas){
                        start.max = datas; //结束日选好后，充值开始日的最大日期
                    }
                };
                laydate(start);
                laydate(end);
            };
            $scope.agencyIndex=0;
/*全部 A级 B级 按钮*/
            $scope.bgChangeAndSearch = function(index){
                $scope.agencyIndex = index;
                $scope.active = 'active';
            };
/*返回*/
            $scope.back = function(){
                history.back()
            }
/*搜索*/
            $scope.searchSubordinate = function(){

            }
        }]);