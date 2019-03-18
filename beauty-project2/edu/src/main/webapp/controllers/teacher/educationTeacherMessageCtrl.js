angular.module('controllers',[]).controller('educationTeacherMessageCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','GetTeacherClassCircle','Global',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,GetTeacherClassCircle,Global) {

        $rootScope.title = "班级圈";

        $scope.teacherMessageType = 'all';

        $scope.pageParam = {
            pageNo:0,
            pageSize:5
        }

        $scope.param = {
            classCircleMessageList : []
        }

        $scope.selectTeacherMessage = function (type) {
            $scope.teacherMessageType = type;
        }

        $scope.getMoreTeacherMessage = function () {
            $scope.pageParam.pageSize = $scope.pageParam.pageSize + 5;
            GetTeacherClassCircle.save($scope.pageParam, function (data) {
                if(data.result==Global.SUCCESS)
                {
                    $scope.param.classCircleMessageList = data.responseData;
                }
            })
        }

        $scope.goTeacherHome = function () {
            $state.go("educationTeacherHome",{schoolId:localStorage.getItem('schoolId')});
        }

        $scope.goTeacherCenter = function () {
            $state.go("educationTeacherCenter");
        }

        GetTeacherClassCircle.save($scope.pageParam, function (data) {
            if(data.result==Global.SUCCESS)
            {
                $scope.param.classCircleMessageList = data.responseData;
                console.log($scope.param.classCircleMessageList);
            }
        })

}])
