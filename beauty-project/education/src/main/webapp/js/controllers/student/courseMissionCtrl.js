angular.module('controllers',[]).controller('courseMissionCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

        $rootScope.title = "查看课程";

        $scope.commitMission = function(){
            $state.go("commitMission");
        }
        
        $scope.goCourseDetail = function () {
            $state.go("courseDetail");
        }

}])
