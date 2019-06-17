'use strict';

/* Controllers */
  // signin controller
app.controller('SigninFormController', ['$scope', '$http', '$state', 'Global',function($scope, $http, $state,Global) {

    $scope.user = {};
    $scope.authError = null;

    $scope.login = function() {
      $scope.authError = null;
      // Try to login
      $http.post('/traffic/login', {username: $scope.user.username, password: $scope.user.password})
      .then(function(data) {
          if(data.result==Global.SUCCESS)
          {
              window.localStorage.setItem("logintoken",data.responseData);
              $state.go('app.statistic');
          }
      }, function(x) {
        $scope.authError = 'Server Error';
      });
    };

}])
