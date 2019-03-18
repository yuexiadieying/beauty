angular.module('controllers',[]).controller('balanceCtrl',
    ['$scope','$interval','$rootScope','$stateParams','$state','Global','$timeout','QueryAllUserBalance','QueryUserBalanceByParameters','ManagementUtil',
        function ($scope,$interval,$rootScope,$stateParams,$state,Global,$timeout,QueryAllUserBalance,QueryUserBalanceByParameters,ManagementUtil) {
            $scope.BalanceAounnt = "";
            $scope.mum = true;
            var pattern = /^1[34578]\d{9}$/;
            var pattern1 = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
/*展示*/
            $scope.loadPageList = function(){
                if($scope.BalanceAounnt==""){
                    QueryAllUserBalance.save({
                        pageNo:$scope.pageNo,
                        pageSize:$scope.pageSize
                    },function(data){
                        ManagementUtil.checkResponseData(data,"");
                        if(data.responseData.responseData == undefined){
                            $scope.balanceLis=[];
                            return
                        }
                        if(data.result == Global.SUCCESS){
                            $scope.balanceLis = data.responseData.responseData;
                            $scope.response = {};
                            $scope.response.count = data.responseData.totalCount;
                            $scope.pageSize = 5;
                            $scope.param.pageFrom = ($scope.pageNo-1)*$scope.pageSize+1;
                            $scope.param.pageTo = ($scope.pageNo-1)*$scope.pageSize+$scope.pageSize;
                            $scope.mum = false;
                        }
                    })
                }else{
                    if(pattern.test($scope.BalanceAounnt) == false && pattern1.test($scope.BalanceAounnt)== false){
                        $scope.BalanceAounnt='请填写正确的手机号或身份证号';
                    }else{

                            QueryUserBalanceByParameters.get({
                                phoneAndIdentify:$scope.BalanceAounnt,
                                pageNo:$scope.pageNo,
                                pageSize:$scope.pageSize
                            },function(data){
                                ManagementUtil.checkResponseData(data,"");
                                if(data.result == Global.SUCCESS){
                                    $scope.balanceLis = data.responseData.responseData;
                                    $scope.response = {};
                                    $scope.response.count = data.responseData.totalCount;
                                    $scope.pageSize = 5;
                                    $scope.param.pageFrom = ($scope.pageNo-1)*$scope.pageSize+1;
                                    $scope.param.pageTo = ($scope.pageNo-1)*$scope.pageSize+$scope.pageSize;
                                    /* $scope.BalanceAounnt = "";*/
                                }
                            })


                    }
                }


            };
/*搜索*/

            $scope.searchBalance = function(){
                $scope.loadPageList()
                $scope.choosePage(1)
                }
        }]);