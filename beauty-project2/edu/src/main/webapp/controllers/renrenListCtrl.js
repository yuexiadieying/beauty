angular.module('controllers',[]).controller('renrenListCtrl',
    ['$scope','$rootScope','$stateParams','$state', '$interval', 'EducationUtil','Global',
        function ($scope,$rootScope,$stateParams,$state, $interval, EducationUtil,Global) {

            $rootScope.title = "人人通";



            $scope.goDetail = function () {
                $state.go("renrenDetail");
            }


            $scope.goRelease = function () {
                $state.go("renrenRelease");
            }




        }]);
