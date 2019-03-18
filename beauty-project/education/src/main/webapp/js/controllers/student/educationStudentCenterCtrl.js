angular.module('controllers',[]).controller('educationStudentCenterCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

        $rootScope.title = "我的";

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
            $state.go("educationStudentHome");
        }

}])
