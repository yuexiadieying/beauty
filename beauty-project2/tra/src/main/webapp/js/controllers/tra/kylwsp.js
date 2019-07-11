'use strict';

/* Controllers */

app
  // Flot Chart controller 
  .controller('KylwspCtrl', ['$scope','traUtil', function($scope,traUtil) {

      traUtil.getUserInfo();

     $scope.param = {
         tableTip:['序号','线路名称','发车站编码','发车站名','终到站编码','终到站名','企业代码','企业名称','车牌号码','车牌颜色','运营方式','发班间隔时间','途经站点','座位数','乘车站编码','乘车站','售票站编码','售票站地址','日期','班次号','班次时间','票型','票价','座位','到达站','到达站名','里程','免票儿童','售票类型','条码','票号','候车厅','检票口','停车位','操作员工号','售票员姓名','售票时间','乘客手机','用户名','证件类别','证件号码','订单号','提交时间','取票时间','取票人姓名','取票人手机号码','取票人证件类别','取票人证件号码','取票所在场站','备注']
     }
      var map = L.map('mapDiv').setView([29.05,111.68],13);

      L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
          attribution: 'Map data &copy; 2011 OpenStreetMap contributors, Imagery &copy; 2011 CloudMade. Font Awesome by Dave Gandy',
          key: 'BC9A493B41014CAABB98F0471D759707',
          detectRetina: true
      }).addTo(map);


      var rndCoordinates = function(from, to, fixed) {
          return (Math.random() * (to - from) + from).toFixed(fixed) * 1;
      };
      var markerArray = [];
      for (var i = 0; i <= 7; i++) {
          var geo = [rndCoordinates(29,29.059,3), rndCoordinates(111.601,111.789,3)];

          var marker = L.marker(geo, {icon: L.AwesomeMarkers.icon({icon: 'star', prefix: 'fa', markerColor: 'blue'})});
          marker.addTo(map);
          marker.on({'click':function (i) {
              alert(i.latlng)
          }});
      }


  }]);