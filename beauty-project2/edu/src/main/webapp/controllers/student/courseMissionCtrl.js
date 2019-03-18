angular.module('controllers',[]).controller('courseMissionCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil', 'staticGlobal', 'Global', 'StudentCourseMissionDetail', 'getCourseMissionComment',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil, staticGlobal, Global,StudentCourseMissionDetail, getCourseMissionComment) {

            $rootScope.title = "查看课程任务";
            $scope.showMissionFlag = false;
            $scope.showCommentFlag = false;

            getCourseMissionComment.get({classCourseId : $stateParams.classCourseId}, function (data) {
                if(data.result === Global.SUCCESS){
                    if(data.responseData === undefined){
                        $scope.showCommentFlag = false;
                    }
                    else {
                        $scope.showCommentFlag = true;
                        $scope.commentList = data.responseData;
                    }
                }
                else{
                    EducationUtil.showToast(staticGlobal.error);
                }
            });

            var time = moment(parseInt($stateParams.time)).format('YYYY-MM-DD');
            StudentCourseMissionDetail.get({classCourseId : $stateParams.classCourseId, courseDate : time}, function (data) {
               if(data.result === Global.SUCCESS){
                   if(data.responseData === undefined){
                       $scope.showMissionFlag = false;
                   }
                   else{
                       $scope.showMissionFlag = true;
                       $scope.missionDescription = data.responseData.missionDescription;
                       $scope.createDate = data.responseData.createDate;
                       $scope.missionEndDate = data.responseData.missionEndDate;
                       $scope.missionName = data.responseData.missionName;
                       $scope.missionId = data.responseData.missionId;
                   }
               }
               else{
                   EducationUtil.showToast(staticGlobal.error);
               }
            });


            //提交任务
            $scope.commitMission = function(){
                $state.go("commitMission", {missionId : $scope.missionId, classCourseId : $stateParams.classCourseId, time: $scope.missionEndDate });
            }

            //进入课程
            $scope.goCourseDetail = function () {
                $state.go("courseDetail", {classCourseId : $stateParams.classCourseId, time : time});
            }

}])
