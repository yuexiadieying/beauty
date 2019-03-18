angular.module('controllers',[]).controller('teacherCourseMissionDetailCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce) {

        $rootScope.title = "作业详情";

        $scope.param = {
            courseResultCommit:false,
            missionComment : {
                great : false,
                good: false,
                finish:false,
                improve:false
            }
        }

        if($rootScope.teacherCourseMissionDetail.missionStatus=='1')
        {
            $scope.param.courseResultCommit = true;
        }

        $scope.commitCourseResult = function () {
            $scope.param.courseResultCommit = true;
        }

        angular.forEach($rootScope.teacherCourseMissionDetail.missionContentList,function (val,index) {
            val.playUrl = angular.copy($sce.trustAsResourceUrl(val.playUrl));
        })
        console.log($rootScope.teacherCourseMissionDetail);

        var loadMissionComment = function () {
            if($rootScope.teacherCourseMissionDetail.missionComment == '1')
            {
                $scope.param.missionComment.great=true;
                $scope.param.missionComment.good=false;
                $scope.param.missionComment.finish=false;
                $scope.param.missionComment.improve=false;
            }
            else if($rootScope.teacherCourseMissionDetail.missionComment == '2')
            {
                $scope.param.missionComment.great=false;
                $scope.param.missionComment.good=true;
                $scope.param.missionComment.finish=false;
                $scope.param.missionComment.improve=false;
            }
            else if($rootScope.teacherCourseMissionDetail.missionComment == '3')
            {
                $scope.param.missionComment.great=false;
                $scope.param.missionComment.good=false;
                $scope.param.missionComment.finish=true;
                $scope.param.missionComment.improve=false;
            }
            else if($rootScope.teacherCourseMissionDetail.missionComment == '4')
            {
                $scope.param.missionComment.great=false;
                $scope.param.missionComment.good=false;
                $scope.param.missionComment.finish=false;
                $scope.param.missionComment.improve=true;
            }
        }

        loadMissionComment();

        $scope.chooseLevel = function (level) {
            if(level=='great')
            {
                $rootScope.teacherCourseMissionDetail.missionComment = '1';
            }
            else if(level=='good')
            {
                $rootScope.teacherCourseMissionDetail.missionComment = '2';
            }
            else if(level=='finish')
            {
                $rootScope.teacherCourseMissionDetail.missionComment = '3';
            }
            else if(level=='improve')
            {
                $rootScope.teacherCourseMissionDetail.missionComment = '4';
            }
            loadMissionComment();
        }

}])
