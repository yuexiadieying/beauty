'use waterwayYunZheng';

/* Controllers */

app.controller('WaterwayYunZhengCtrl', ['$scope', function($scope) {

    $scope.data={
        business:{
            secondLevel:[
                ['机构编码','所在行政区划','机构全称','机构简称','机构负责人姓名','部门负责人','填报人姓名','联系电话']
            ]
        }
    }

    $scope.folds = [
        {name: '行政区划', filter:''},
        {name: '管理机构', filter:'starred'},
        {name: '许可申请记录', filter:'sent'},
        {name: '水路运输业户台帐', filter:'important'},
        {name: '水路运输企业人员', filter:'draft'},
        {name: '运输辅助企业台帐', filter:'trash'},
        {name: '年度审验业户记录', filter:'a'},
        {name: '注销退出业户记录', filter:'b'},
        {name: '企业违章记录', filter:'c'},
        {name: '营运船舶信息', filter:'d'},
        {name: '船舶类型代码', filter:'e'},
        {name: '变更船舶记录', filter:'f'},
        {name: '船舶违章记录', filter:'g'},
        {name: '业户与船舶年审报数据', filter:'h'},
        {name: '运输船舶名录', filter:'i'},
        {name: '运政管理人员名录', filter:'j'}
    ];

}]);

app.controller('WaterwayYunZhengListCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
}]);