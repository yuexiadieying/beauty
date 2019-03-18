angular.module('controllers',[]).controller('teacherPushMissionCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading) {

        $rootScope.title = "布置作业";

        $scope.pushMission = function () {
            $state.go("teacherMissionDetail");
        }

        $scope.goTeacherCourseMissionTable = function () {
            $state.go("teacherCourseMissionTable");
        }


}])
