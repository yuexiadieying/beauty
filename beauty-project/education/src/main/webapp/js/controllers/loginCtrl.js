angular.module('controllers',[]).controller('loginCtrl',
    ['$scope','$rootScope','$stateParams','$state', '$interval', 'EducationUtil', 'staticGlobal',
        function ($scope,$rootScope,$stateParams,$state, $interval, EducationUtil, staticGlobal ) {

            $rootScope.title = "登录";

            $scope.info = {};
            $scope.showPwdFlag = true;
            $scope.loginMothed = "验证码登录";
            $scope.info.sendCode = "点击获取";
            var checkFlag = true;

            if(EducationUtil.getSchoolName() !== null){
                var school = EducationUtil.getSchoolName();
                $scope.schoolName = school;
            }
            else{
                $scope.schoolName = "没有选择学校";
            }


            //选择学校
            $scope.changeSchool = function () {
                $state.go("schoolChooseList");
            }


            //改变登录方式
            $scope.changeLogin = function () {
                if($scope.showPwdFlag){
                    $scope.showPwdFlag = false;
                    $scope.loginMothed = "学号/工号登录";
                }
                else{
                    $scope.showPwdFlag = true;
                    $scope.loginMothed = "验证码登录";
                }
            }

            //发送验证码
            $scope.sendCode = function () {
                if(!checkFlag){
                    return;
                }
                if($scope.info.phone !== undefined && $scope.info.phone !== ""){
                    if(checkFlag){
                        checkFlag = false;
                        var num = 60;
                        var stop = $interval(function(){
                            num--;
                            if(num === 0){
                                $interval.cancel(stop);
                                $scope.info.sendCode = "点击发送";
                                checkFlag = true;
                            }else{
                                $scope.info.sendCode = num;
                            }
                        }, 1000);
                    }
                }
                else{
                    EducationUtil.showToast("手机号不能为空");
                }
            }

            //登录
            $scope.goHome = function () {
                EducationUtil.saveLoginState();
                if(true){
                    $state.go("educationStudentHome");
                }
                else{
                    $state.go("educationTeacherHome");
                }

            }


        }]);
