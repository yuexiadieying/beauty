'use strict';

/* Controllers */

app
  // Flot Chart controller 
  .controller('SjtystjfxjcCtrl', ['$scope','$stateParams','traUtil', '$http','Global','$state','$rootScope',
      function($scope,$stateParams,traUtil,$http,Global,$state,$rootScope) {

      $rootScope.goThirdPlatformName = '省交通运输统计分析检测第三方平台';
      traUtil.getUserInfo();

      $scope.d3 = [
          { label: "指标一", data: 40 },
          { label: "指标二", data: 10 },
          { label: "指标三", data: 20 },
          { label: "指标四", data: 12 },
          { label: "指标五", data: 18 }
      ];

      $scope.d = [ [1,6.5],[2,6.5],[3,7],[4,8],[5,7.5],[6,7],[7,6.8],[8,7],[9,7.2],[10,7],[11,6.8],[12,7] ];

      $scope.d0_1 = [ [0,7],[1,6.5],[2,12.5],[3,7],[4,9],[5,6],[6,11],[7,6.5],[8,8],[9,7] ];

      $scope.d0_2 = [ [0,4],[1,4.5],[2,7],[3,4.5],[4,3],[5,3.5],[6,6],[7,3],[8,4],[9,3] ];

      $scope.d1_1 = [ [10, 120], [20, 70], [30, 70], [40, 60] ];

      $scope.d1_2 = [ [10, 50],  [20, 60], [30, 90],  [40, 35] ];

      $scope.d1_3 = [ [10, 80],  [20, 40], [30, 30],  [40, 20] ];

      $scope.getData = function (startDate,endDate) {
          console.log(startDate);
          console.log(endDate);
      }


  }]);