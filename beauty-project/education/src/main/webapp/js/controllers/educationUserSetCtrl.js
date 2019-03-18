angular.module('controllers',[]).controller('educationUserSetCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading', '$ionicPopup',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading, $ionicPopup) {

        $rootScope.title = "我的";

        //账号安全设置
        $scope.goSafety = function () {
            $state.go("accountSafety");
        }

        //关于我们
        $scope.goAbout = function () {
            $state.go("aboutOur");
        }

        //问题反馈
        $scope.question = function () {

        }

        //退出
        $scope.goExit = function () {
            // 一个确认对话框
            var confirmPopup = $ionicPopup.confirm({
                title: '确定登出吗？',
                template: '如果您登出了，您的课程信息也将暂时被屏蔽！',
                cancelText: '取消', // String (默认: 'Cancel')。一个取消按钮的文字。
                //cancelType: '', // String (默认: 'button-default')。取消按钮的类型。
                okText: '登出' // String (默认: 'OK')。OK按钮的文字。
                //okType: '', // String (默认: 'button-positive')。OK按钮的类型。
            });
            confirmPopup.then(function(res) {
                if(res) {
                    EducationUtil.removeLoginState();
                    $state.go("educationStudentHome");
                    console.log('You are sure');
                } else {
                    console.log('You are not sure');
                }
            });

        }

}]);
