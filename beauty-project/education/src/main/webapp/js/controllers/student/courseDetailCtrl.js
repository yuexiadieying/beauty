angular.module('controllers',[]).controller('courseDetailCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce) {

        $rootScope.title = "课程详情";

        $scope.commitMission = function () {
            $state.go("commitMission")
        }

}])
