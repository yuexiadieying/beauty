angular.module('controllers',[]).controller('teacherVacationListCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','GetTeacherVacationApplyList','Global','ProcessVacationApply',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,GetTeacherVacationApplyList,Global,ProcessVacationApply) {

        $rootScope.title = "请假审批";

        $scope.param = {
            vacationApplyList : []
        }

        GetTeacherVacationApplyList.get({vacationStatus:"0"},function (data) {
            EducationUtil.checkResponseData(data,"educationTeacherHome&"+$rootScope.schoolId);
            if(data.result == Global.SUCCESS)
            {
                $scope.param.vacationApplyList = data.responseData;
                console.log($scope.param.vacationApplyList);
            }
        })

        $scope.goTeacherHistoryMissionList =function () {
            $state.go("teacherHistoryVacationList");
        }
        
        $scope.confirmApply = function (vacationId) {
            console.log(vacationId);
            ProcessVacationApply.get({vacationId:vacationId,status:"1"},function (data) {
                EducationUtil.checkResponseData(data,"educationTeacherHome&"+$rootScope.schoolId);
                if(data.result == Global.SUCCESS)
                {
                    GetTeacherVacationApplyList.get({vacationStatus:"0"},function (data) {
                        EducationUtil.checkResponseData(data,"educationTeacherHome&"+$rootScope.schoolId);
                        if(data.result == Global.SUCCESS)
                        {
                            $scope.param.vacationApplyList = data.responseData;
                        }
                    })
                }
            })
        }

        $scope.rejectApply = function (vacationId) {
            console.log(vacationId);
            ProcessVacationApply.get({vacationId:vacationId,status:"2"},function (data) {
                EducationUtil.checkResponseData(data,"educationTeacherHome&"+$rootScope.schoolId);
                if(data.result == Global.SUCCESS)
                {
                    GetTeacherVacationApplyList.get({vacationStatus:"0"},function (data) {
                        EducationUtil.checkResponseData(data,"educationTeacherHome&"+$rootScope.schoolId);
                        if(data.result == Global.SUCCESS)
                        {
                            $scope.param.vacationApplyList = data.responseData;
                        }
                    })
                }
            })
        }

}])
