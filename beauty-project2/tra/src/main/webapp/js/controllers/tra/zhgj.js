'use strict';

/* Controllers */

app
  // Flot Chart controller 
  .controller('ZhgjCtrl', ['$scope', function($scope) {
      $scope.param = {
          flag:false,
          index:0
      }

      $scope.showAndHide = function () {
          $scope.param.flag = !$scope.param.flag
      };
      $scope.btnChange  = function (index) {
          $scope.param.index = index;
          $scope.param.flag = false;
      }
      //添加瓦片图层
      /*var layers = [];
       layers.push(new L.TileLayer.TDT.Vector());
       layers.push(new L.TileLayer.TDT.VectorAnno());
       map = new L.map('mapDiv', { layers: layers, attribution: false ,crs: L.CRS.CustomLevel});
       map.setView([29.92831, 121.5484], 11);*/
      //初始化地图对象
      var map=L.map("mapDiv");
      //设置地图的中心和缩放级别
      var mymap = map.setView([29.05,111.68],13);
      //初始化瓦片图层
      var tileLayer=L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png');
      /* L.marker([39.9788, 116.30226]).addTo(mymap).bindPopup("北京大厦<br>").openPopup();
       L.circle([39.9908, 116.26625], 500, {  color: 'red',  fillColor: '#f03',  fillOpacity: 0.5 }).addTo(mymap).bindPopup("颐和园欢迎你");
       L.polygon([  [39.92096, 116.38591],  [39.91079, 116.38676],  [39.91118, 116.3962],  [39.92014, 116.39482] ]).addTo(mymap).bindPopup("故宫");*/
      /*  var popup = L.popup().setLatLng([51.5, -0.09]) .setContent("I am a standalone popup.").openOn(mymap);*/
      var popup = L.popup();
      function onMapClick(e) {
          popup
              .setLatLng(e.latlng)
              .setContent("You clicked the map at " + e.latlng.toString())
              .openOn(mymap);
      }
      mymap.on('click', onMapClick);


      //地图添加图层
      map.addLayer(tileLayer);


  }]);