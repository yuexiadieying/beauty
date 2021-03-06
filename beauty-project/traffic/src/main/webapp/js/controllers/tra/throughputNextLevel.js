'use throughputNextLevel';

/* Controllers */

app.controller('ThroughputNextLevelCtrl', ['$scope','$stateParams', function($scope,$stateParams) {

    $scope.folds = [
        {name: '全省泊位表', filter:''},
        {name: '港口企业和码头单位名录', filter:'starred'},
        {name: '企业操作人员', filter:'sent'},
        {name: '全省港区代码表', filter:'important'},
        {name: '全省港口表', filter:'draft'},
        {name: '港口快报吞吐量', filter:'express'},
        {name: '港口吞吐量', filter:'a'},
        {name: '行业管理机构', filter:'b'},
        {name: '行业管理人员', filter:'c'}
    ];
    $scope.fold = $stateParams.fold;

}]);

app.controller('ThroughputNextLevelListCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.d = [ [1,6.5],[2,6.5],[3,7],[4,8],[5,7.5],[6,7],[7,6.8],[8,7],[9,7.2],[10,7],[11,6.8],[12,7] ];
    $scope.d0_1 = [ [0,70],[1,60.5],[2,120.5],[3,70],[4,90],[5,60],[6,110],[7,60.5],[8,80],[9,70] ];
    $scope.d0_2 = [ [0,40],[1,40.5],[2,70],[3,40.5],[4,30],[5,30.5],[6,60],[7,30],[8,40],[9,30] ];
    $scope.tableTitle= [['表年份','归属港区编号','泊位代码','泊位名称','服务类型','货主类型','泊位长度','设计靠泊能力(吨级)','增加的报告期','报废的报告期','泊位状态','码头企业号'],['泊位编号','报表报告','报表行号','合计','外贸','出港数据','进港数据']]

}]);
