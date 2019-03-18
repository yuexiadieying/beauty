angular.module('controllers',[]).controller('schoolMasterMailCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce) {

        $rootScope.title = "校长信箱";

        $scope.submitMail = function () {
            $state.go("educationStudentHome");
        }


}])
