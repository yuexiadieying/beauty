angular.module('controllers',[]).controller('commitMissionCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

        $rootScope.title = "提交任务";

        $scope.submitMission = function(){
            console.log("go mission");
            $state.go("missionDetail");
        }

}])
