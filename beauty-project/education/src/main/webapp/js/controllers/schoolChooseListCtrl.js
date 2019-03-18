angular.module('controllers',[]).controller('schoolChooseListCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

            $rootScope.title = "选择学校";

            $scope.schoolList = [
                "北京13中","苹果园中学","牛栏山一中","潞河中学","北京10中","北京14中","北京十一学校","大峪中学",
                "北京171中","东直门中学","密云二中","八大处中学","北京工业大学附中","北京66中","北京109中","北方交大附中","北京55中"
            ]


            //
            $scope.changeSchool = function (index) {
                EducationUtil.saveSchoolName($scope.schoolList[index]);
                $state.go("login");
            }



        }]);
