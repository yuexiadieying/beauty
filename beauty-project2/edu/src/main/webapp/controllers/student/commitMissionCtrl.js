angular.module('controllers',[]).controller('commitMissionCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','staticGlobal', 'Global', 'studentPushCourseMission',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,staticGlobal,Global, studentPushCourseMission ) {

        $rootScope.title = "提交任务";

        $scope.input = {};
        var homeWorkId = $stateParams.missionId;
        $scope.missionEndDate = $stateParams.time;
        var classCourseId = $stateParams.classCourseId;


        $scope.submitMission = function(){
            if($scope.input.desc === undefined || $scope.input.desc === ""){
                EducationUtil.showToast("请填写说明！");
                return
            }
            var obj = {
                homeWorkId : homeWorkId,
                homeWorkDesc : $scope.input.desc,
                homeWorkAttachList : "11",
                homeWorkTime : $scope.missionEndDate
            }
            studentPushCourseMission.save(obj, function (data) {
                if(data.result === Global.SUCCESS){
                    EducationUtil.showToast("提交成功");
                    $state.go("missionDetail");
                }
                else{
                    EducationUtil.showToast(staticGlobal.error);
                }
            });

        }

}])
