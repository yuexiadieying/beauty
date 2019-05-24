'use throughputNextLevel';

/* Controllers */

app.controller('ThroughputNextLevelCtrl', ['$scope', function($scope) {

    $scope.data={
        business:{
            secondLevel:[
                ['机构编码','所在行政区划','机构全称','机构简称','机构负责人姓名','部门负责人','填报人姓名','联系电话']
            ]
        }
    }

    $scope.folds = [
        {name: '全省泊位表', filter:''},
        {name: '港口企业和码头单位名录', filter:'starred'},
        {name: '企业操作人员', filter:'sent'},
        {name: '全省港区代码表', filter:'important'},
        {name: '全省港口表', filter:'draft'},
        {name: '港口快报吞吐量', filter:'trash'},
        {name: '港口吞吐量', filter:'a'},
        {name: '行业管理机构', filter:'b'},
        {name: '行业管理人员', filter:'c'}
    ];

}]);

app.controller('ThroughputNextLevelListCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
}]);