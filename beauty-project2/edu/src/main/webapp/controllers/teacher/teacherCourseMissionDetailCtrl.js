angular.module('controllers',[]).controller('teacherCourseMissionDetailCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce','TeacherPushHomeWorkComment',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce,TeacherPushHomeWorkComment) {

        $rootScope.title = "作业详情";

        $scope.param = {
            courseResultCommit:false,
            homeWorkCommentStatus : {
                great : false,
                good: false,
                finish:false,
                improve:false
            },
            homeWorkImgList : []
        }

        if($rootScope.teacherCourseMissionDetail.homeWorkStatus=='1')
        {
            $scope.param.courseResultCommit = true;
        }

        $scope.commitCourseResult = function () {
            $scope.param.courseResultCommit = true;
            console.log($rootScope.teacherCourseMissionDetail);
            $rootScope.teacherCourseMissionDetail.homeWorkStatus = '1';
            TeacherPushHomeWorkComment.save($rootScope.teacherCourseMissionDetail,function (data) {
                console.log(data.result);
            })

        }

        console.log($rootScope.teacherCourseMissionDetail);

        $scope.param.homeWorkImgList = $rootScope.teacherCourseMissionDetail.homeWorkImgList.split(";");
        console.log($scope.param.homeWorkImgList);

        var loadMissionComment = function () {
            if($rootScope.teacherCourseMissionDetail.homeWorkCommentStatus == '1')
            {
                $scope.param.homeWorkCommentStatus.great=true;
                $scope.param.homeWorkCommentStatus.good=false;
                $scope.param.homeWorkCommentStatus.finish=false;
                $scope.param.homeWorkCommentStatus.improve=false;
            }
            else if($rootScope.teacherCourseMissionDetail.homeWorkCommentStatus == '2')
            {
                $scope.param.homeWorkCommentStatus.great=false;
                $scope.param.homeWorkCommentStatus.good=true;
                $scope.param.homeWorkCommentStatus.finish=false;
                $scope.param.homeWorkCommentStatus.improve=false;
            }
            else if($rootScope.teacherCourseMissionDetail.homeWorkCommentStatus == '3')
            {
                $scope.param.homeWorkCommentStatus.great=false;
                $scope.param.homeWorkCommentStatus.good=false;
                $scope.param.homeWorkCommentStatus.finish=true;
                $scope.param.homeWorkCommentStatus.improve=false;
            }
            else if($rootScope.teacherCourseMissionDetail.homeWorkCommentStatus == '4')
            {
                $scope.param.homeWorkCommentStatus.great=false;
                $scope.param.homeWorkCommentStatus.good=false;
                $scope.param.homeWorkCommentStatus.finish=false;
                $scope.param.homeWorkCommentStatus.improve=true;
            }
        }

        loadMissionComment();

        $scope.chooseLevel = function (level) {
            if(level=='great')
            {
                $rootScope.teacherCourseMissionDetail.homeWorkCommentStatus = '1';
            }
            else if(level=='good')
            {
                $rootScope.teacherCourseMissionDetail.homeWorkCommentStatus = '2';
            }
            else if(level=='finish')
            {
                $rootScope.teacherCourseMissionDetail.homeWorkCommentStatus = '3';
            }
            else if(level=='improve')
            {
                $rootScope.teacherCourseMissionDetail.homeWorkCommentStatus = '4';
            }
            loadMissionComment();
        }

}])
