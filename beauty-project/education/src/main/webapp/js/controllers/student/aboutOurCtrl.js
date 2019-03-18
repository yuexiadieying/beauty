angular.module('controllers',[]).controller('aboutOurCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

            $rootScope.title = "关于我们";


            $scope.goAgreement = function () {
                $state.go("userAgreement");
            }


        }]);
