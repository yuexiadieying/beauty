'use strict';

/* Controllers */

app
  // Flot Chart controller 
  .controller('SjtystjfxjcCtrl', ['$scope', function($scope) {

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
      };
      $scope.appArray = [{
          id:'cskyW01',/*城市（县城）客运交通管理信息*/
          status:false
         },
          {
          id:'cskyW02',/*城市客运主要统计指标快速年报信息*/
          status:false
          },
          {
              id:'cskyW03',/*出租汽车运营情况（单位：万元） */
              status:false
          },
          {
              id:'cskyW04',/*公共汽电车运营情况*/
              status:false
          },
          {
              id:'cskyW05',/*城市公交运营情况(单位：万元) */
              status:false
          },
          {
              id:'dlysW01',/*道路运输统计（半年，年）涵盖道路客运站信息（单位：%）*/
              status:false
          },
          {
              id:'dlysW02',/*道路客户站场增减情况*/
              status:false
          },
          {
              id:'dlysW03',/*道路危险货物运输数据 */
              status:false
          },
          {
              id:'dlysW04',/*道路从业人员数据 */
              status:false
          },
          {
              id:'dlysW05',/*道路货运场站数据(单位:%)*/
              status:false
          },
          {
              id:'dlysW06',/*道路运输经理人数据*/
              status:false
          },
          {
              id:'dlysW07',/*港澳台及外商投资道路运输业情况数据（单位：%）*/
              status:false
          },
          {
              id:'dlysW08',/*道路经营业户数据*/
              status:false
          },
          {
              id:'dlysW09',/*道路运输统计（企业）涵盖公路货运企业运输量调查数据*/
              status:false
          },
          {
              id:'dlysW010',/*公路客运企业运输量调查*/
              status:false
          },
          {
              id:'dlysW011',/*重点联系公路运输企业经营财务状况调查数据(单位：%)*/
              status:false
          },
          {
              id:'dlysW012',/*湖南省交通公路装卸搬运企业统计*/
              status:false
          },
          {
              id:'gkzhW01',/*分航线进出港旅客人数情况（单位：百万人次）*/
              status:false
          },
          {
              id:'gkzhW02',/*国际分航线进出港旅客人数情况*/
              status:false
          },
          {
              id:'gkzhW03',/*国内分航线进出港旅客人数情况(单位：百万人次)*/
              status:false
          },
          {
              id:'gkzhW04',/*内贸情况  */
              status:false
          },
          {
              id:'gkzhW05',/*分货类吞吐(单位：万吨)*/
              status:false
          },
          {
              id:'gkzhW06',/*内贸出港情况*/
              status:false
          },
          {
              id:'gkzhW07',/*国际航线进出港集装箱吞吐（单位：万吨）*/
              status:false
          },
          {
              id:'gkzhW08',/*外贸情况*/
              status:false
          },
          {
              id:'gkzhW09',/*国内航线进出港集装箱吞吐（单位：万吨）*/
              status:false
          },
          {
              id:'gkzhW010',/*外贸出港情况*/
              status:false
          },
          {
              id:'gkzhW011',/*内支线进出港集装箱吞吐（单位：万吨）*/
              status:false
          },
          {
              id:'gkzhW012',/*分货类分运输方式集疏运情况*/
              status:false
          },
          {
              id:'gkzhW013',/*内外贸船舶停泊时间*/
              status:false
          },{
              id:'gkzhW014',/*港口法人企业    */
              status:false
          },{
              id:'gkzhW015',/*港口码头单位数据*/
              status:false
          },{
              id:'gljdW01',/*路段平均日交通量统计（单位：万台）*/
              status:false
          },{
              id:'gljdW02',/*小时交通量记录（单位：万辆）*/
              status:false
          },{
              id:'gljdW03',/*日交通量统计*/
              status:false
          },{
              id:'nhhdW01',/*分叉辅助段基础数据 */
              status:false
          },{
              id:'nhhdW02',/*过河建筑物基础数据 */
              status:false
          },{
              id:'nhhdW03',/*航段基础数据（单位：万元）*/
              status:false
          },{
              id:'nhhdW04',/*临河设施基础数据 */
              status:false
          },{
              id:'nhhdW05',/*瓶颈区段基础数据 */
              status:false
          },{
              id:'nhhdW06',/*枢纽基础数据等数据 */
              status:false
          },{
              id:'yszhW01',/*公路水路运输量月度统计基础情况（单位：万吨） */
              status:false
          },{
              id:'yszhW02',/*高速公路车流量和通行费情况 */
              status:false
          },{
              id:'yszhW03',/*高速公路货车车流量和车货总重情况  */
              status:false
          },{
              id:'yszhW04',/*公路客货运输量情况  */
              status:false
          },{
              id:'yszhW05',/*公路运输业务量情况（单位：万吨） */
              status:false
          },{
              id:'yszhW06',/*水路客货运输量情况 */
              status:false
          },{
              id:'yszhW07',/*海事签字情况（单位：%） */
              status:false
          },{
              id:'yszhW08',/* 公路分货运运输量情况*/
              status:false
          },{
              id:'yszhW09',/*公路旅客货物运营车辆拥有量情况（单位：万吨） */
              status:false
          },{
              id:'yszhW10',/*公路密度情况 */
              status:false
          },{
              id:'yszhW11',/*公路桥梁隧道年底到达数情况（单位：万辆）*/
              status:false
          },{
              id:'yszhW12',/*公路运输法人企业情况  */
              status:false
          },{
              id:'yszhW13',/*内河航道通航里程年底达到量情况（单位：万吨） */
              status:false
          },{
              id:'yszhW14',/*货运车辆更新情况 */
              status:false
          },{
              id:'yszhW15',/*水路运输运输量情况（单位：万辆）*/
              status:false
          },{
              id:'yszhW16',/*水路运输法人企业变更情况*/
              status:false
          },{
              id:'yszhW17',/*水路运输工具拥有量情况(单位：万吨) */
              status:false
          },{
              id:'yszhW18',/*营业性汽车运输效率和燃料消耗情况  */
              status:false
          },{
              id:'yszhW19',/*营业性运输船舶燃料消耗情况数据（单位：%） */
              status:false
          },
      ];



      $scope.indexFun = function (id) {
         for(var i=0;i<$scope.appArray.length;i++) {
             if($scope.appArray[i].id == id) {
                 return i
             }
         }
      };

      $scope.addMindApp = function (id) {
          $scope.appArray[$scope.indexFun(id)].status =  !$scope.appArray[$scope.indexFun(id)].status;
          console.log($scope.appArray);
      }

  }]);