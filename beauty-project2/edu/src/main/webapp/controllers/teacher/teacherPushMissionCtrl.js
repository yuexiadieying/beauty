angular.module('controllers',[]).controller('teacherPushMissionCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','TeacherPushMission','Global',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,TeacherPushMission,Global) {

        $rootScope.title = "布置作业";

        $scope.param = {
            courseId:$stateParams.courseId,
            classId:$stateParams.classId,
            month:'',
            day:'',
            hour:'',
            minute:'',
            missionBaseInfo:{
                missionName: $rootScope.tempMissionBaseInfo.missionName,
                missionDescription : $rootScope.tempMissionBaseInfo.missionDescription,
                missionEndDate : '',
                classIdList:[]
            }
        }

        $scope.pushMission = function () {
            var date = new Date;
            var year = date.getFullYear();
            $scope.param.missionBaseInfo.missionEndDate = new Date(year + "-"+
                $scope.param.month + "-" + $scope.param.day + " "+ $scope.param.hour+":"+$scope.param.minute);
            $rootScope.tempMissionBaseInfo.missionName = $scope.param.missionBaseInfo.missionName;
            $rootScope.tempMissionBaseInfo.missionDescription = $scope.param.missionBaseInfo.missionDescription;
            var courseHomeWorkStudentDTOS = [];
            angular.forEach($rootScope.prepareMissionList,function (val,index) {
                var courseHomeWork = {};
                courseHomeWork.homeWorkDesc = $rootScope.tempMissionBaseInfo.missionDescription;
                courseHomeWork.homeWorkTime = $scope.param.missionBaseInfo.missionEndDate;
                courseHomeWork.homeWorkName = $rootScope.tempMissionBaseInfo.missionName;
                courseHomeWork.classId = val.classId;
                courseHomeWork.className = val.className;
                courseHomeWork.courseId = val.courseId;
                courseHomeWork.courseName = val.courseName;
                courseHomeWork.weekIndex = val.weekIndex;
                courseHomeWork.coursePlace = val.coursePlace;
                courseHomeWorkStudentDTOS.push(courseHomeWork);
            })
            console.log(courseHomeWorkStudentDTOS);
            TeacherPushMission.save(courseHomeWorkStudentDTOS,function (data) {
                EducationUtil.checkResponseData(data,'teacherPushMission&'+$scope.param.courseId+","+$scope.param.classId);
                if(data.result==Global.SUCCESS)
                {
                    $state.go("teacherMissionDetail");
                }
            })
        }

        $scope.goTeacherCourseMissionTable = function () {
            $rootScope.tempMissionBaseInfo.missionName = $scope.param.missionBaseInfo.missionName;
            $rootScope.tempMissionBaseInfo.missionDescription = $scope.param.missionBaseInfo.missionDescription;
            $state.go("teacherCourseMissionTable");
        }


}])
