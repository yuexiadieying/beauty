angular.module('controllers',[]).controller('courseDetailCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','staticGlobal','Global', 'StudentCourseMissionDetail',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,staticGlobal,Global, StudentCourseMissionDetail) {

            $rootScope.title = "课程详情";
            $scope.missionFlag = false;

            var time = moment(parseInt($stateParams.time)).format('YYYY-MM-DD');
            StudentCourseMissionDetail.get({classCourseId : $stateParams.classCourseId, courseDate : time}, function (data) {
                console.log("dta", data);
                if(data.result === Global.SUCCESS){
                    if(data.responseData.missionDescription !== undefined && data.responseData.missionDescription !== null){
                        $scope.missionFlag = true;
                        $scope.missionDescription = data.responseData.missionDescription;
                        $scope.createDate = data.responseData.createDate;
                        $scope.missionEndDate = data.responseData.missionEndDate;
                        $scope.missionName = data.responseData.missionName;
                        $scope.missionId = data.responseData.missionId;
                    }
                    else{
                        $scope.missionFlag = false;
                    }
                    $scope.courseName = data.responseData.courseName;
                    $scope.className = data.responseData.className;
                    $scope.courseWeek = data.responseData.courseWeek; //周几
                    $scope.coursePlace = data.responseData.coursePlace; //第几节
                    $scope.teacherName = data.responseData.teacherName;
                    $scope.weekIndex = data.responseData.weekIndex; //周数
                }
                else{
                    EducationUtil.showToast(staticGlobal.error);
                }
            });

            $scope.commitMission = function () {
                $state.go("commitMission", {missionId : $scope.missionId, classCourseId : $stateParams.classCourseId, time: $scope.missionEndDate });
            }

    }])
