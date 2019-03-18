angular.module('controllers',[]).controller('educationTeacherMessageCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

        $rootScope.title = "消息";

        $scope.goTeacherHome = function () {
            $state.go("educationTeacherHome");
        }

        $scope.goTeacherCenter = function () {
            $state.go("educationTeacherCenter");
        }

}])
