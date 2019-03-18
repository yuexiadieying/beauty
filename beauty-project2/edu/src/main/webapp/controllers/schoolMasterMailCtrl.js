angular.module('controllers',[]).controller('schoolMasterMailCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce','SubmitMasterMail',"Global",
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce,SubmitMasterMail,Global) {

        $rootScope.title = "校长信箱";

        $scope.param = {
            message:""
        }

        $scope.submitMail = function () {
            console.log($scope.param.message);
            if($scope.param.message=="")
            {
                alert("请输入消息");
            }
            else
            {
                SubmitMasterMail.save({message:$scope.param.message},function (data) {
                    if(data.result==Global.SUCCESS)
                    {
                        history.back();
                    }
                })
            }
        }


}])
