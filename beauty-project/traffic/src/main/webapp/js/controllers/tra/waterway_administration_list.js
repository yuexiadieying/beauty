'use waterway_administration_list';

/* Controllers */

app
  // Flot Chart controller 
  .controller('Waterway_administration_listCtrl', ['$scope', function($scope) {
     $scope.data={
         business:{
             secondLevel:['行政区划','管理机构','许可申请记录',' 水路运输业户台帐','水路运输企业人员','运输辅助企业台帐','运输辅助企业人员','年度审验业户记录','注销退出业户记录','企业违章记录','营运船舶信息','船舶类型代码',' 年度审验船舶记录','变更船舶记录','船舶违章记录','业户与船舶年审报数据','运输船舶名录','运政管理人员名录'],
             threeLevel:[
                 ['机构编码','所在行政区划','机构全称','机构简称','机构负责人姓名','部门负责人','填报人姓名','联系电话']
             ]















































         }
     }

  }]);