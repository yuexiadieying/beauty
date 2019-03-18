angular.module('controllers',[]).controller('suggestionCtrl',
    ['$scope','$rootScope','$stateParams','$state','SuggestionDetail','Global','GetUserInfo','BusinessUtil',
        function ($scope,$rootScope,$stateParams,$state,SuggestionDetail,Global,GetUserInfo,BusinessUtil) {

            $rootScope.title = "意见反馈";
            $scope.param = {
                suggestion:""
            }

            $scope.$on('$ionicView.enter', function(){
                GetUserInfo.get(function (data) {
                    BusinessUtil.checkResponseData(data,'suggestion');
                    $scope.param.userInfo = data.responseData;
                })
            });

           // 提交反馈
           $scope.submit=function(){
                console.log($scope.param.suggestion);
               SuggestionDetail.get({suggestion:$scope.param.suggestion},function(data){
                   if(Global.SUCCESS==data.result)
                   {
                       $state.go("myselfCenter");
                   }
               })
           }
        }])