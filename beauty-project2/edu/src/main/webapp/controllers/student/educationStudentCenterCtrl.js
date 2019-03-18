angular.module('controllers',[]).controller('educationStudentCenterCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil', 'staticGlobal', 'Global', 'StudentInfo',
        function ($scope,$rootScope,$stateParams,$state, EducationUtil, staticGlobal, Global, StudentInfo ) {

            $rootScope.title = "我的";

            //学生个人信息
            StudentInfo.get(function (data) {
                if(data.result === Global.SUCCESS){
                    $scope.studentInfo = data.responseData;
                    EducationUtil.saveStudentInfo(data.responseData);
                }
                else{
                    EducationUtil.showToast(staticGlobal.error);
                }
            })


            $scope.goStudentInfo = function () {
                $state.go("educationStudentInfo");
            }

            $scope.goStudentReward = function () {
                $state.go("educationStudentReward");
            }

            $scope.goStudentSet = function () {
                $state.go("educationUserSet");
            }

            $scope.goStudentMessage = function () {
                $state.go("educationStudentMessage");
            }

            $scope.goStudentHome = function () {
                $state.go("educationStudentHome",{schoolId:localStorage.getItem("schoolId")});
            }

}])
