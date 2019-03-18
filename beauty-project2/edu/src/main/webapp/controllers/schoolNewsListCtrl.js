angular.module('controllers',[]).controller('schoolNewsListCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','GetSchoolNewsList','Global',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,GetSchoolNewsList,Global) {

        $rootScope.title = "校园新闻列表";

        $scope.goSchoolNewsDetail = function (newsId) {
            $state.go("schoolNewsDetail",{newsId:newsId});
        }

        $scope.param = {
            schoolNewsList :[]
        }

        GetSchoolNewsList.get({schoolId:localStorage.getItem('schoolId')},function(data){
            if(data.result==Global.SUCCESS)
            {
                $scope.param.schoolNewsList = data.responseData;
                console.log($scope.param.schoolNewsList)
            }
        })

        $scope.goSchoolNewsDetail = function (newsId) {
            $state.go("schoolNewsDetail",{newsId:newsId});
        }
}]);
