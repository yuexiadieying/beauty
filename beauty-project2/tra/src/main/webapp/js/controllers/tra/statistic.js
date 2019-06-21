'use strict';

/* Controllers */

app
  // Flot Chart controller 
  .controller('StatisticCtrl', ['$scope', '$http', '$state','Global',function($scope, $http,$state,Global) {


      $http.get('/traffic/user/getUserInfo')
          .then(function(response) {
              if (response.data.result==Global.SUCCESS) {
                  $scope.userInfo = response.data.responseData;
                  console.log($scope.userInfo);
              }else{
                  $state.go('access.signin');
              }
          }, function(x) {
              $scope.authError = 'Server Error';
          });

      $scope.today = function() {
          $scope.dt = new Date();
      };
      $scope.today();

      $scope.clear = function () {
          $scope.dt = null;
      };

      // Disable weekend selection
      $scope.disabled = function(date, mode) {
          return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
      };

      $scope.toggleMin = function() {
          $scope.minDate = $scope.minDate ? null : new Date();
      };
      $scope.toggleMin();

      $scope.open = function($event) {
          $event.preventDefault();
          $event.stopPropagation();

          $scope.opened = true;
      };

      $scope.dateOptions = {
          formatYear: 'yy',
          startingDay: 1,
          class: 'datepicker',
          language: "zh-CN",
      };

      $scope.initDate = new Date('2019-05');
      $scope.formats = ['yyyy-mm','dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
      $scope.format = $scope.formats[0];

      $scope.d = [ [1,6.5],[2,6.5],[3,7],[4,8],[5,7.5],[6,7],[7,6.8],[8,7],[9,7.2],[10,7],[11,6.8],[12,7] ];

      $scope.d1_1 = [ [10, 120], [20, 70], [30, 70], [40, 60] ];

      $scope.d1_2 = [ [10, 50],  [20, 60], [30, 90],  [40, 35] ];

      $scope.d1_3 = [ [10, 80],  [20, 40], [30, 30],  [40, 20] ];

      $scope.d0_1 = [ [0,7],[1,6.5],[2,12.5],[3,7],[4,9],[5,6],[6,11],[7,6.5],[8,8],[9,7] ];

      $scope.d0_2 = [ [0,4],[1,4.5],[2,7],[3,4.5],[4,3],[5,3.5],[6,6],[7,3],[8,4],[9,3] ];

      $scope.d0_3 = [ [0,6],[1,5.5],[2,3],[3,3.5],[4,4],[5,4.5],[6,5],[7,4],[8,6],[9,2] ];

  }]);