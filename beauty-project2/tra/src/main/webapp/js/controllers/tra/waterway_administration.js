'use waterway_administration';

/* Controllers */

app
  // Flot Chart controller 
  .controller('Waterway_administrationCtrl', ['$scope','Global',"traUtil",'$http','$state','$rootScope',
      function($scope, Global,traUtil,$http,$state,$rootScope) {

      $rootScope.goThirdPlatformName = '省水路运政管理第三方平台';

        $scope.sslyzglHomeData = []

        traUtil.getUserInfo();

        $http.get('/traffic/sslyzgl/homePage')
            .then(function(response) {
              if (response.data.result==Global.SUCCESS) {
                angular.forEach(response.data.responseData,function (val,index) {
                    if(val!='')
                    {
                      $scope.sslyzglHomeData.push(val);
                    }
                })
              }
            });

  }]);