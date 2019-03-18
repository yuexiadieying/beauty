angular.module('controllers',[]).controller('teacherVacationDetailCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading) {

        $rootScope.title = "请假详情";

        $scope.rejectVacation = function () {
            $state.go("teacherHistoryVacationList");
        }
        
        $scope.agreeVacation = function () {
            $state.go("teacherHistoryVacationList");
        }

}])
