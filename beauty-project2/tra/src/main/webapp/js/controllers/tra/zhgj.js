'use strict';

/* Controllers */

app
  // Flot Chart controller 
  .controller('ZhgjCtrl', ['$scope','$stateParams','traUtil', '$http','Global','$state','$rootScope',
      function($scope,$stateParams,traUtil,$http,Global,$state,$rootScope) {

      $rootScope.goThirdPlatformName = '智慧公交第三方平台';
      traUtil.getUserInfo();

      $scope.param = {
          flag:false,
          index:0
      };

      if($stateParams.index !=''){
          $scope.param.index = $stateParams.index
      }
      $scope.showAndHide = function () {
          $scope.param.flag = !$scope.param.flag
      };
      $scope.btnChange  = function (index) {
          $scope.param.index = index;
          $scope.param.flag = false;
      }

      //初始化地图对象
      var map=L.map("mapDiv");
      //设置地图的中心和缩放级别
      var mymap = map.setView([29.05,111.68],13);
      //初始化瓦片图层
      var tileLayer=L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png');

      //地图添加图层
      map.addLayer(tileLayer);

  }]);