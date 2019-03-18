angular.module('controllers',[]).controller('schoolNewsListCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

        $rootScope.title = "校园新闻列表";

        $scope.goSchoolNewsDetail = function () {
            $state.go("schoolNewsDetail");
        }

}]);
