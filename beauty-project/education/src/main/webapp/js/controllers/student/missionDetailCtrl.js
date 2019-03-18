angular.module('controllers',[]).controller('missionDetailCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce) {

        $rootScope.title = "任务详情";

        $scope.playURL = $sce.trustAsResourceUrl("https://mxavi.oss-cn-beijing.aliyuncs.com/jmcpavi/b56302140e3957f8e4267d85e2445dee.mp4");

        console.log($scope.playURL);

        $scope.againSub = function () {
            $state.go("commitMission");
        }

}]);
