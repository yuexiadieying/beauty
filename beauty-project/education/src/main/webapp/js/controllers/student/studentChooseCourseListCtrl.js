angular.module('controllers',[]).controller('studentChooseCourseListCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce) {

        $rootScope.title = "选课列表";

        $scope.goStudentChooseCourse = function () {
            $state.go("studentChooseCourse");
        }


}])
