angular.module('controllers',[]).controller('withDrawCtrl',
    ['$scope','$rootScope','$stateParams','$state','GetUserAccountInfo','Global','BusinessUtil','WithDrawMoneyFromAccount','$ionicPopup',
        function ($scope,$rootScope,$stateParams,$state,GetUserAccountInfo,Global,BusinessUtil,WithDrawMoneyFromAccount,$ionicPopup) {

            $rootScope.title = "提现";

            $scope.$on('$ionicView.enter', function(){
                $scope.param = {
                    accountInfo:{},
                    withDrawAmount:"",
                    userName:"",
                    userIdentifyNumber:"",
                    bankCardNumber:"",
                    bankAddress:""
                }

                GetUserAccountInfo.get(function(data){
                    BusinessUtil.checkResponseData(data,'withDraw');
                    $scope.param.accountInfo = data.responseData;
                    if($scope.param.accountInfo.identifyNumber!=undefined)
                    {
                        $scope.param.userIdentifyNumber = $scope.param.accountInfo.identifyNumber;
                    }
                    if($scope.param.accountInfo.bankCardInfo!=undefined)
                    {
                        $scope.param.userName = $scope.param.accountInfo.bankCardInfo.userName;
                        $scope.param.bankCardNumber = $scope.param.accountInfo.bankCardInfo.bankCardNumber;
                    }
                })
            });

            $scope.withDrawAll = function(){
                $scope.param.withDrawAmount = ($scope.param.accountInfo.balance - $scope.param.accountInfo.balanceDeny).toFixed(0)-1;
            }

            $scope.confirmWithDraw = function(){

                if($scope.param.userIdentifyNumber!='')
                {
                    console.log($scope.param.withDrawAmount);
                    if($scope.param.withDrawAmount<=0)
                    {
                        var alertPopup = $ionicPopup.alert({
                            template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">提现金额不能小于或者为0</span>',
                            okText:'确定'
                        });
                    }
                    else if($scope.param.withDrawAmount>$scope.param.accountInfo.balance - $scope.param.accountInfo.balanceDeny)
                    {
                        var alertPopup = $ionicPopup.alert({
                            template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">提现金额不能大于最大提现额度</span>',
                            okText:'确定'
                        });
                    }
                    else
                    {
                        WithDrawMoneyFromAccount.get({moneyAmount:$scope.param.withDrawAmount,
                                                      identifyNumber:$scope.param.userIdentifyNumber,
                                                      userName:$scope.param.userName,
                                                      bankCardNumber:$scope.param.bankCardNumber},function(data){
                            BusinessUtil.checkResponseData(data,'withDraw');
                            if(data.result==Global.SUCCESS)
                            {
                                $state.go("account");
                            }
                            else
                            {
                                if(data.errorInfo=="noIdentify")
                                {
                                    var alertPopup = $ionicPopup.alert({
                                        template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">请输入身份证号码</span>',
                                        okText:'确定'
                                    });
                                }
                            }
                        })
                    }
                }

            }
        }])