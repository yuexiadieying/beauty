angular.module('controllers',[]).controller('studentHistoryVacationListCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil', 'staticGlobal', 'Global', 'StudentVacationApplyList',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil, staticGlobal, Global, StudentVacationApplyList) {

            $rootScope.title = "请假记录";


            StudentVacationApplyList.get(function (data) {
                if(data.result === Global.SUCCESS){
                    $scope.vacationList = data.responseData;
                }
                else {
                    EducationUtil.showToast(staticGlobal.error);
                }
            })

            //去详情页
            $scope.goDetail = function (type, vacationId) {

                $state.go("studentVacationDetail", {type : type,vacateId : vacationId});

            }

        }]);