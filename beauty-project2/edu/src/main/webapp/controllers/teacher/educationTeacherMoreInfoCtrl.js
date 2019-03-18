angular.module('controllers',[]).controller('educationTeacherMoreInfoCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

        $rootScope.title = "育湖系统";

        $scope.moreInfoClose = function () {
            history.go(-1);
        }
        
        $scope.educationVacation = function () {
            $state.go('teacherVacationList');
        }

        $scope.goRenRenTong = function () {
            $state.go("renrenList");
        }

        $scope.goJiaxiaoTong = function() {
            window.location.href = "http://xck.hlsenior.com/jeeplus/a/login;JSESSIONID=7ebb55662f4f4489af2c7e4e82d3c878"
        }
        
        $scope.educationMoral = function () {
            $state.go("educationMoralList");
        }


}])
