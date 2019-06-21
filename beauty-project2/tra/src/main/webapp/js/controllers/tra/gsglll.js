'use strict';

/* Controllers */

app
  // Flot Chart controller 
  .controller('GsglllCtrl', ['$scope', function($scope) {
      $scope.d = [ [1,29],[2,16],[3,35],[4,58 ],[5,28],[6,9],[7,41] ];
      $scope.param = {
          tableTitle:['年份','路线标识','调查站标识','起点名称','起点桩号（公里）','止点名称','止点桩号（公里）','断面名称',' 断面桩号（公里）','描述','报警时间',' 设备ID','存储路径','报警ID'],
          flag:false,
          index:0
      };

      $scope.showAndHide = function () {
          $scope.param.flag = !$scope.param.flag
      };

      var map = L.map('mapDiv').setView([29.05,111.68],13);
      L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
          attribution: 'Map data &copy; 2011 OpenStreetMap contributors, Imagery &copy; 2011 CloudMade. Font Awesome by Dave Gandy',
          key: 'BC9A493B41014CAABB98F0471D759707',
          detectRetina: true
      }).addTo(map);


      var rndCoordinates = function(from, to, fixed) {
          return (Math.random() * (to - from) + from).toFixed(fixed) * 1;
      };
      var layers=[];
      var myGroup =''
      var creatMarker = function (colors,awesomeIcons) {
          layers=[]
          for (var i = 0; i <= 7; i++) {
              var geo = [rndCoordinates(29,29.059,3), rndCoordinates(111.601,111.789,3)];
              var marker = new L.marker(geo, {icon: L.AwesomeMarkers.icon({icon: colors, prefix: 'fa', markerColor: awesomeIcons})});
              layers.push(marker)
              marker.on({'click':function (i) {
                  alert(i.latlng)
              }});
          }
          myGroup=L.layerGroup(layers);
          map.addLayer(myGroup);
      }
      $scope.btnChange  = function (index) {
          $scope.param.index = index;
          if(layers.length>0){
              myGroup.clearLayers();
          }
          if(index == 1 ){
              creatMarker('ambulance','darkgreen')
          }else if(index ==2) {
              creatMarker('group','red')
          }
          $scope.param.flag = false;
      }


  }]);