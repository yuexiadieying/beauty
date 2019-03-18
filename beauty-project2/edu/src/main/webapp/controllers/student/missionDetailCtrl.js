angular.module('controllers',[]).controller('missionDetailCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce) {

        $rootScope.title = "任务详情";

        $scope.playURL = $sce.trustAsResourceUrl("https://mxavi.oss-cn-beijing.aliyuncs.com/jmcpavi/b56302140e3957f8e4267d85e2445dee.mp4");

        console.log($scope.playURL);

        var missionDetail = EducationUtil.getMissionComment();
        if(!missionDetail){
            EducationUtil.showToast("没有任务点评");
        }
        else{
            $scope.homeWorkName = missionDetail.message.homeWorkName;
            $scope.homeWorkId = missionDetail.message.homeWorkId;
            $scope.homeWorkCreateDate = missionDetail.message.homeWorkCreateDate;
            if(missionDetail.message.homeWorkCommentMsg !== undefined && missionDetail.message.homeWorkCommentMsg !== ""){
                $scope.homeWorkCommentMsg = missionDetail.message.homeWorkCommentMsg;
            }
            else{
                $scope.homeWorkCommentMsg = "老师目前还没有点评，去休息一下吧";
            }

            $scope.homeWorkImgList = missionDetail.message.homeWorkImgList;

        }

        $scope.againSub = function () {
            $state.go("commitMission", {missionId: $scope.homeWorkId, classCourseId : "", time : $scope.homeWorkCreateDate});
        }

}]);
