angular.module('controllers',[]).controller('loginCtrl',
    ['$scope','$rootScope','$stateParams','$state', '$interval', 'EducationUtil', 'staticGlobal','EducationLogin','Global','EducationPasswordChange',
        function ($scope,$rootScope,$stateParams,$state, $interval, EducationUtil, staticGlobal,EducationLogin,Global,EducationPasswordChange) {

            $rootScope.title = "登录";

            $scope.info = {
                educationNumber : '',
                educationPassword:'',
                newEducationPassword1:'',
                newEducationPassword2:''
            };

            $scope.passwordFlag = false;

            $scope.changePassword = function () {
                $scope.passwordFlag = true;
            }

            $scope.confirmNewPassword = function () {
                if(window.localStorage.getItem("userType")!=undefined||window.localStorage.getItem("userType")!=null)
                {
                    if($scope.info.newEducationPassword1!=$scope.info.newEducationPassword2)
                    {
                        alert("两次要更新的密码不一致");
                    }
                    else
                    {
                        EducationPasswordChange.get({educationNumber:$scope.info.educationNumber,
                            oldPassword:$scope.info.educationPassword,
                            newPassword:$scope.info.newEducationPassword1,
                            schoolId:$rootScope.schoolId,
                            userType:window.localStorage.getItem("userType")},function (data) {
                            if(data.result==Global.SUCCESS)
                            {
                                $scope.passwordFlag = false;
                                alert("密码修改成功");
                            }
                            else
                            {
                                alert("密码修改失败");
                            }
                        })
                    }
                }
            }

            $scope.goLogin = function () {

                if(window.localStorage.getItem("userType")!=undefined||window.localStorage.getItem("userType")!=null)
                {
                    EducationLogin.get({educationNumber:$scope.info.educationNumber,
                        educationPassword:$scope.info.educationPassword,userType:window.localStorage.getItem("userType"),
                        schoolId:localStorage.getItem("schoolId")},function(data){
                        if(data.result==Global.FAILURE)
                        {
                            alert(data.errorInfo);
                        }
                        else
                        {
                            if(window.localStorage.getItem("userType")==Global.userType.STUDENT)
                            {
                                window.localStorage.removeItem("studentlogintoken");
                                window.localStorage.setItem("studentlogintoken",data.responseData);
                            }
                            else if(window.localStorage.getItem("userType")==Global.userType.TEACHER)
                            {
                                window.localStorage.removeItem("teacherlogintoken");
                                window.localStorage.setItem("teacherlogintoken",data.responseData);
                            }

                            if($stateParams.redirectUrl=='')
                            {
                                window.location.href = "";
                            }
                            else
                            {
                                window.location.href = "#/" + $stateParams.redirectUrl.replace("&","/");
                            }
                        }
                    })

                }

            }

}]);
