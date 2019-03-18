angular.module('controllers',[]).controller('teacherDiscussStudentSubmitCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading) {

        $rootScope.title = "学生点评";

        $scope.submitStudentDiscuss = function () {
            $state.go("teacherDiscussStud")
        }


        console.log($stateParams.type);
        $scope.discussType = $stateParams.type;
        console.log($rootScope.teacherDiscussStudents);
        
        $scope.chooseDiscussType = function (type) {
            $scope.discussStudentType = type;
        }

}])
