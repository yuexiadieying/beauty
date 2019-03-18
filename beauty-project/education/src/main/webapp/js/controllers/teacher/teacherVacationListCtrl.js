angular.module('controllers',[]).controller('teacherVacationListCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading) {

        $rootScope.title = "请假审批";

        $scope.goTeacherHistoryMissionList =function () {
            $state.go("teacherHistoryVacationList");
        }
        
        $scope.goTeacherVacationDetail = function () {
            $state.go("teacherVacationDetail");
        }

}])
