'use strict';

/* Controllers */

app
  // Flot Chart controller 
  .controller('GsglllCtrl', ['$scope','traUtil', function($scope,traUtil) {

      traUtil.getUserInfo();

      $scope.d = [ [1,29],[2,16],[3,35],[4,58 ],[5,28],[6,9],[7,41] ];
      $scope.param = {
          tableTitle:[['年份','路线标识','调查站标识','起点名称','起点桩号（公里）','止点名称','止点桩号（公里）','断面名称',' 断面桩号（公里）','描述','报警时间',' 设备ID','存储路径','报警ID'],
              ['年份','管理机构标识','父管理机构标识','行政区划标识','管理机构编号','管理机构名称','管理机构状态','联系人','联系人身份证','电话','传真','地址','邮编','描述','创建者','创建时间','修改者','修改时间','管理机构分类','单位负责人','统计负责人'],
          ['年份','调查站标识','管理机构标识','行政区划标识','路线标识','出临行政区划标识','调查站编号','调查站名称','调查站类型','调查站状态','建站时间','调查方法','停测月份','起点名称','起点桩号','止点桩号','止点名称','上行名称','下行名称','观测里程','技术等级','技术等级唯一标识','一级里程','二级里程','三级里程','四级里程','高速里程','等外里程','车道特征','路面类型','路面宽度','设计时速','地貌','描述','创建者','创建时间','修改者','修改时间','桩号(公里)','适应交通量','供电方式','通讯方式','公路功能','调查人员数量','为县道对应路线用'],
          ['年份','型号标识','厂商标识','产品型号','设备用途','设备功能','设备主工作方式','设备传输方式','设备使用温度类别']],
          flag:false,
          index:0,
          trafficInfo:[[],['行驶方向','年份','调查站标识',' 跟车百分比（%）','平均车头间距（米）','时间占有率（%）','创建者','创建时间','修改者','修改时间','描述','中小客车','小型货车','大客车','当量数','中型货车','大型货车','特大型货车','集装箱车','摩托车','拖拉机','人力车','自行车'],
          ['小型车 ','','中型车','','大型车','','特大车型','','中小客车','','小型货车','','大客车','','中型货车','','大型货车','','特大型货车','','集装箱车','','摩托车','','拖拉机','','人力车','畜力车','自行车'],[]]
      };

      for(var i=0;i<$scope.param.trafficInfo[1].length;i++){
          $scope.param.trafficInfo[0][i] = ''
          $scope.param.trafficInfo[0][11]     = '当量数'
      }

      for(var i=0;i<$scope.param.trafficInfo[2].length;i++){
         if($scope.param.trafficInfo[2][i]!=''){
             $scope.param.trafficInfo[3][i] = '自然数'
         }else{
             $scope.param.trafficInfo[3][i] = '车速'
         }
      }
























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
          }else if(index ==3) {
              creatMarker('barcode','cadetblue')
          }else if(index ==4) {
              creatMarker('tags','orange')
          }else if(index ==5) {
              creatMarker('certificate','red')
          }
          $scope.param.flag = false;
      }


  }]);