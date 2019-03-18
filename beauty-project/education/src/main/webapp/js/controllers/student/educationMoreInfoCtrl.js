angular.module('controllers',[]).controller('educationMoreInfoCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

        $rootScope.title = "育湖系统";

        $scope.moreInfoClose = function () {
            history.go(-1);
        }
        
        $scope.educationVacation = function () {
            $state.go('educationVacation');
        }
        
        $scope.studentChooseCourse = function () {
            $state.go("studentChooseCourse");
        }

}])
