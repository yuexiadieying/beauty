angular.module('controllers',[]).controller('studentChooseCourseCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce) {

        $rootScope.title = "选课";

        $scope.chooseCourse = function () {
            $state.go("studentChooseCourseList");
        }


}])
