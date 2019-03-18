angular.module('controllers',[]).controller('teacherHistoryVacationListCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','GetTeacherVacationApplyList','Global',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,GetTeacherVacationApplyList,Global) {

        $rootScope.title = "审批记录";

        $scope.param = {
            vacationApplyList : []
        }

        GetTeacherVacationApplyList.get({vacationStatus:"history"},function (data) {
            EducationUtil.checkResponseData(data,"educationTeacherHome&"+$rootScope.schoolId);
            if(data.result == Global.SUCCESS)
            {
                $scope.param.vacationApplyList = data.responseData;
                console.log($scope.param.vacationApplyList);
            }
        })

}])
