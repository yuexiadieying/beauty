angular.module('controllers',[]).controller('educationStudentInfoCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','staticGlobal', 'Global', 'StudentInfo',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil, staticGlobal, Global, StudentInfo) {

            $rootScope.title = "我的";

            //学生个人信息
            StudentInfo.get(function (data) {
                if(data.result === Global.SUCCESS){
                    $scope.studentInfo = data.responseData;
                }
                else{
                    EducationUtil.showToast(staticGlobal.error);
                }
            })



}])
