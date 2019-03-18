angular.module('controllers',[]).controller('educationStudentMessageCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

        $rootScope.title = "消息";

        //课堂点评
        $scope.goCourseComment = function () {
            $state.go("courseMission");
        }

        //任务评价
        $scope.goMissionDetail = function () {
            $state.go("missionDetail");
        }

        //请假详情页
        $scope.goVacateDetail = function (type) {
            if(type === 1){
                $state.go("studentVacationDetail", {vacateId : 1});
            }
            else if(type === 2){
                $state.go("studentVacationDetail", {vacateId : 2});
            }
        }

        //重新提交任务
        $scope.subminMission = function () {
            $state.go("commitMission");
        }

        //提交任务
        $scope.goCourseDetail = function () {
            $state.go("courseDetail");
        }

        $scope.goStudentHome = function () {
            $state.go("educationStudentHome");
        }

        $scope.goStudentCenter = function () {
            $state.go("educationStudentCenter");
        }

}])
