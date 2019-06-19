'use strict';

/* Controllers */

app
  // Flot Chart controller 
  .controller('KylwspCtrl', ['$scope', function($scope) {
     $scope.param = {
         tableTip:['序号','线路名称','发车站编码','发车站名','终到站编码','终到站名','企业代码','企业名称','车牌号码','车牌颜色','运营方式','发班间隔时间','途经站点','座位数','乘车站编码','乘车站','售票站编码','售票站地址','日期','班次号','班次时间','票型','票价','座位','到达站','到达站名','里程','免票儿童','售票类型','条码','票号','候车厅','检票口','停车位','操作员工号','售票员姓名','售票时间','乘客手机','用户名','证件类别','证件号码','订单号','提交时间','取票时间','取票人姓名','取票人手机号码','取票人证件类别','取票人证件号码','取票所在场站','备注']
     }

      var map=L.map("mapDiv");

      var mymap = map.setView([29.05,111.68],13);
      //初始化瓦片图层
      var tileLayer=L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png');
       L.marker([29.066,111.688]).addTo(mymap)
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