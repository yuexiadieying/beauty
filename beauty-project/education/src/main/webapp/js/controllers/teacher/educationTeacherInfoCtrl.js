angular.module('controllers',[]).controller('educationTeacherInfoCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

        $rootScope.title = "我的";

        $scope.moreInfo = function () {
            $state.go("educationMoreInfo");
        }
        
        $scope.goCourseMission = function () {
            $state.go("courseMission");
        }

        $scope.goNewsDetail = function () {
            $state.go("newsDetail");
        }

}])
