angular.module('controllers',[]).controller('schoolNewsDetailCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce','GetSchoolNewsDetail','Global',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce,GetSchoolNewsDetail,Global) {

        $rootScope.title = "新闻详情";

        $scope.param = {
            schoolNewsDetail : {}
        }

        GetSchoolNewsDetail.get({newsId:$stateParams.newsId},function (data) {
            console.log(data);
            if(data.result==Global.SUCCESS)
            {
                $scope.param.schoolNewsDetail = data.responseData;
            }
        })



}])
