'use strict';

/* Controllers */
  // signin controller
app.controller('SigninFormController', ['$scope', '$http', '$state', function($scope, $http, $state) {

    $scope.user = {};
    $scope.authError = null;

    $scope.login = function() {
      $scope.authError = null;
      // Try to login
      $http.post('/traffic/login', {username: $scope.user.username, password: $scope.user.password})
      .then(function(response) {

          console.log(response);

      }, function(x) {
        $scope.authError = 'Server Error';
      });
    };

}])
