angular.module('controllers',[]).controller('educationTeacherCenterCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

        $rootScope.title = "我的";

        $scope.goTeacherInfo = function () {
            $state.go("educationTeacherInfo");
        }
        
        $scope.goTeacherReward = function () {
            $state.go("educationTeacherReward");
        }

        $scope.goTeacherSet = function () {
            $state.go("educationUserSet");
        }

        $scope.goTeacherMessage = function () {
            $state.go("educationTeacherMessage");
        }

        $scope.goTeacherHome = function () {
            $state.go("educationTeacherHome");
        }

}])
