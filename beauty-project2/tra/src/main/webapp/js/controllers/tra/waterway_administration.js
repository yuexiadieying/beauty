'use waterway_administration';

/* Controllers */

app
  // Flot Chart controller 
  .controller('Waterway_administrationCtrl', ['$scope','Global',"traUtil",'$http','$state', function($scope, Global,traUtil,$http,$state) {

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