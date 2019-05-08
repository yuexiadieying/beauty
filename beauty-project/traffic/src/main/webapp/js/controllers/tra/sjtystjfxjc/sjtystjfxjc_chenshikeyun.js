'use strict';

/* Controllers */

app
  // Flot Chart controller 
  .controller('SjtystjfxjcChenshikeyunCtrl', ['$scope', function($scope) {

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

  }]);