angular.module('controllers',[]).controller('educationStudentMoreInfoCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

        $rootScope.title = "更多";

        $scope.moreInfoClose = function () {
            history.go(-1);
        }
        
        $scope.educationVacation = function () {
            $state.go('educationVacation');
        }
        
        $scope.studentChooseCourse = function () {
            $state.go("studentChooseCourse");
        }
        
        $scope.goRenRenTong = function () {
            $state.go("renrenList");
        }

        $scope.goJiaxiaoTong = function() {
            window.location.href = "http://xck.hlsenior.com/jeeplus/a/login;JSESSIONID=7ebb55662f4f4489af2c7e4e82d3c878"
        }
}])
