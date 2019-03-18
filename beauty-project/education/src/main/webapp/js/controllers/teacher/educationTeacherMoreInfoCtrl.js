angular.module('controllers',[]).controller('educationTeacherMoreInfoCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

        $rootScope.title = "育湖系统";

        $scope.moreInfoClose = function () {
            history.go(-1);
        }
        
        $scope.educationVacation = function () {
            $state.go('teacherVacationList');
        }

}])
