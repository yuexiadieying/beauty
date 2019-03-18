angular.module('controllers',[]).controller('teacherCourseMissionListCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','GetTeacherCourseMissionList','Global',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,GetTeacherCourseMissionList,Global) {

        $rootScope.title = "作业详情";
        
        $scope.goTeacherCourseMissionDetail = function (missionDetail) {
            $rootScope.teacherCourseMissionDetail = missionDetail;
            $state.go("teacherCourseMissionDetail");
        }

        $scope.param = {
            studentCourseMissionList:[],
            unCommitMissionNum : 0,
            commitMissionNum : 0,
            tabChoose : 'commit',
            courseMissionId:$stateParams.courseMissionId
        }

        GetTeacherCourseMissionList.get({courseMissionId:$scope.param.courseMissionId},function (data) {
            if(data.result==Global.SUCCESS)
            {
                console.log(data.responseData);
                $scope.param.studentCourseMissionList = data.responseData;
                angular.forEach($scope.param.studentCourseMissionList,function (val,index) {
                    if(val.commitStatus==undefined)
                    {
                        val.commitStatus = '0';
                        $scope.param.unCommitMissionNum++;
                    }
                    else
                    {
                        $scope.param.commitMissionNum++;
                    }
                })
            }
        })

        $scope.chooseCommitStudent = function () {
            $scope.param.tabChoose = 'commit';
        }
        
        $scope.chooseUnCommitStudent = function () {
            $scope.param.tabChoose = 'unCommit';
        }
}])
