angular.module('controllers',[]).controller('studentHistoryVacationListCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil) {

            $rootScope.title = "请假记录";

            $scope.vacationList = [
                {
                    type : 0
                },
                {
                    type : 1
                },
                {
                    type : 2
                }
            ];


            //去详情页
            $scope.goDetail = function (type) {
                if(type === 0){
                    $state.go("studentVacationDetail", {vacateId : "1"});
                }
                else if(type === 1){
                    $state.go("studentVacationDetail", {vacateId : "2"});
                }
                else if(type === 2){
                    $state.go("studentVacationDetail", {vacateId : "0"});
                }
            }

        }]);