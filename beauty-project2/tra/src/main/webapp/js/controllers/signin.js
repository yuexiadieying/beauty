'use strict';

/* Controllers */
  // signin controller
app.controller('SigninFormController', ['$scope', '$http', '$state', 'Global',function($scope, $http, $state,Global) {

    $scope.user = {};
    $scope.authError = null;

    $scope.login = function() {
      $scope.authError = null;
      // Try to login
      $http.post('/traffic/user/login', {loginName: $scope.user.username, password: $scope.user.password})
      .then(function(response) {
          if(response.data.result==Global.SUCCESS)
          {
              window.localStorage.setItem("logintoken",response.data.responseData);
              $state.go('app.statistic');
          }else {
              alert(response.data.errorInfo);
          }
      }, function(x) {
        $scope.authError = 'Server Error';
      });
    };

}])
