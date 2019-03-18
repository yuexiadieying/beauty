angular.module('controllers',[]).controller('myselfCenterCtrl',
    ['$scope','$rootScope','$stateParams','$state','GetUserAccountInfo','Global','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,GetUserAccountInfo,Global,$ionicLoading) {
            $rootScope.title = "个人中心";

            $scope.param = {
                userLogin : false,
                accountInfo:{}
            };

            $scope.$on('$ionicView.enter', function(){
                $ionicLoading.show({
                    content: 'Loading',
                    animation: 'fade-in',
                    showBackdrop: true,
                    maxWidth: 200,
                    showDelay: 0
                });

                GetUserAccountInfo.get(function(data){
                    $ionicLoading.hide();
                    console.log(data)
                    if(data.result==Global.FAILURE)
                    {
                        $scope.param.userLogin = false;
                        $(".smallBox").hide()
                    }
                    else if(data.result==Global.SUCCESS)
                    {
                        $scope.param.userLogin = true;
                        $scope.param.accountInfo = data.responseData;
                        $(".smallBox").show()
                        console.log(data.responseData)
                    }
                })
            });

            $scope.goMyselfSetting = function(){
              $state.go("personalInformation")
            }

            $scope.goSuggestion = function(){
                $state.go("suggestion")
            }

            $scope.goAboutUs = function(){
                $state.go("aboutMine")
            }
            $scope.goOrderManagement = function(type){
                $state.go("orderManagement",{"type":type});

            }

            $scope.myselfLogin = function(){
                $state.go("login",{redirectUrl:"myselfCenter"})

            }

            $scope.goSelfAccount = function () {
                $state.go("account");
            }
            $scope.goShare = function () {
                $state.go("shareHome");
            }
        }])