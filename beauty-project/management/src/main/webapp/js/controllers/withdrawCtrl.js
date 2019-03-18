angular.module('controllers',[]).controller('withdrawCtrl',
    ['$scope','$interval','$rootScope','$stateParams','$state','Global','$timeout','GetAllWithdraw','UpdateWithdrawById','ManagementUtil','QueryWithdrawsByParameters','ManagementUtil',
        function ($scope,$interval,$rootScope,$stateParams,$state,Global,$timeout,GetAllWithdraw,UpdateWithdrawById,ManagementUtil,QueryWithdrawsByParameters,ManagementUtil) {
            var applyStartTime = document.querySelector(".applyStartTime");
            var applyEndTime = document.querySelector(".applyEndTime");
            var updateStartTime = document.querySelector(".updateStartTime");
            var updateEndTime = document.querySelector(".updateEndTime");
            $scope.counnt ="";
            $scope.mum = true;
            var pattern = /^1[34578]\d{9}$/;
            var pattern1 = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
/*日期插件*/
            $scope.dataS =  function(id){
                !function(id){
                    laydate.skin('danlan');//切换皮肤，请查看skins下面皮肤库
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
            }






/*展示数据*/
            $scope.loadPageList = function(){
                GetAllWithdraw.save({
                    pageNo:$scope.pageNo,
                    pageSize:$scope.pageSize
                },function(data){
                    ManagementUtil.checkResponseData(data,"");
                    if(data.result == Global.SUCCESS){
                        $scope.copy(data)
                        $scope.mum = false;
                    }
                })
            };

/*搜索*/
/*sysUserId：账号
* startTime：提现的开始时间
* endTime：结束时间
* 0:没有时间
* 1：申请时间
* 2：提现时间
* */

            $scope.searchWithdraw = function(){
                var applyTime = applyStartTime.value+applyEndTime.value
                var updateTime = updateStartTime.value+updateEndTime.value
                if(applyTime !="" && updateTime!=""){
                    var startTime =applyStartTime.value;
                    var endTime = applyEndTime.value;
                    var type = "1";
                }else if(applyTime !=""){
                    var startTime =applyStartTime.value;
                    var endTime = applyEndTime.value;
                    var type = "1";

                }else if(updateTime !=""){
                    var startTime =updateStartTime.value;
                    var endTime = updateEndTime.value;
                    var type = "2"
                }else{
                    startTime = "";
                    endTime = "";
                    type = "0"
                }
                if(pattern.test($scope.counnt) == false && pattern1.test($scope.counnt)== false){
                    $scope.counnt='请填写正确的手机号或身份证号';
                    return
                }
                $scope.loadPageList = function(){
                    QueryWithdrawsByParameters.get({
                        startTime:startTime,
                        endTime:endTime,
                        phoneAndIdentify:$scope.counnt,
                        type:type,
                        pageNo:$scope.pageNo,
                        pageSize:$scope.pageSize
                    },function(data){
                        ManagementUtil.checkResponseData(data,"");
                        if(data.result == Global.SUCCESS){
                             $scope.copy(data)

                              /* updateStartTime.value= "";
                               updateEndTime.value= "";
                               applyStartTime.value= '';
                               applyEndTime.value= '';
                               $scope.counnt ="";*/
                        }else{
                            $scope.counnt='请填写手机号或身份证号'
                        }
                    })
                }
                $scope.loadPageList()
                $scope.choosePage(1)

            };
/*更改状态*/
/*id:id
* status:状态
* 0：申请中
* 1：提现成功
* 2：拒绝
* */
            $scope.flag = false;
            $scope.sendPrice = function(status,userAccountId,moneyAmount,id,sysUserId,moneyAmount){                                 if(status != "申请中")return;
                    $scope.status=status;
                    $scope.moneyAmount=moneyAmount;
                    $scope.userAccountId=userAccountId;
                    $scope.id = id;
                    $scope.flag = !$scope.flag;
                    $scope.sysUserId = sysUserId;
                    $scope.moneyAmount = moneyAmount;
            };
            $scope.changeWithdraw = function(status){
                var  pageParamDTO={
                    requestData:{
                        withdrawId:$scope.id,
                        status:status,
                        sysUserId:$scope.sysUserId,
                        moneyAmount:$scope.moneyAmount
                    }

                };
                UpdateWithdrawById.save(pageParamDTO,function(data){
                    ManagementUtil.checkResponseData(data,"");
                    if(data.result == Global.SUCCESS){
                        $scope.flag = false;
                        $scope.loadPageList();
                    }else{
                        alert("提现未成功");
                        $scope.flag = false;
                    }
                })
            };
            $scope.bgAll=function(){
                $scope.flag = false;
            };
/*状态的转换*/
            $scope.copy = function(data){
                if(data.responseData.totalCount == 0){
                      $scope.withdraw =[];
                      return
                  }
                if(data.responseData.responseData !=undefined){
                    for(var i=0;i<data.responseData.responseData.length;i++){
                        if(data.responseData.responseData[i].status == "0"){
                            data.responseData.responseData[i].status = "申请中"
                        }else if(data.responseData.responseData[i].status == "1"){
                            data.responseData.responseData[i].status = "完成"
                        }else if(data.responseData.responseData[i].status == "2"){
                            data.responseData.responseData[i].status = "拒绝"
                        }
                    }
                    $scope.withdraw = data.responseData.responseData;
                    $scope.response = {};
                    $scope.response.count = data.responseData.totalCount;
                    $scope.pageSize = 5;
                    $scope.param.pageFrom = ($scope.pageNo-1)*$scope.pageSize+1;
                    $scope.param.pageTo = ($scope.pageNo-1)*$scope.pageSize+$scope.pageSize;                         }

            }
        }]);
