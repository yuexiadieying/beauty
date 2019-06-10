'use throughputNextLevel';

/* Controllers */

app.controller('ThroughputNextLevelCtrl', ['$scope','$stateParams', function($scope,$stateParams) {

    $scope.folds = [
        {name: '全省泊位表', filter:'',url:'list'},
        {name: '港口企业和码头单位名录', filter:'starred',url:'port'},
        {name: '企业操作人员', filter:'sent',url:'management'},
        {name: '全省港区代码表', filter:'important',url:'port'},
        {name: '全省港口表', filter:'draft',url:'port'},
        {name: '港口快报吞吐量', filter:'express',url:'list'},
        {name: '港口吞吐量', filter:'a',url:'list'},
        {name: '行业管理机构', filter:'b',url:'management'},
        {name: '行业管理人员', filter:'c',url:'management'}
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
app.controller('ThroughputNextLevelPortCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
        ['唯一标识号','报表年份','辖机构编码','经济类型','联系电话','报表填报人(联系人)','创建报告期','注销时的报告期','企业状态'],
        ['序号','全国统一港区编号','港区名称','所在水域','所在水系','港区管理单位'],
        ['序号','全国统一港口编号','港口名称','港口归属机构编码','报告期类型','港口管理单位']
    ]

}]);
app.controller('ThroughputNextLevelManagementCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
        ['人员编号','所在企业编号','操作者名','密码','创建时间','帐号状态','最近修改密码时间','联系电话','操作权限','申请口令校验码','注销日期'],
        ['机构编码','机构全称','机构所在行政区划名称','机构负责人姓名','部门负责人','填报人姓名','联系电话'],
        ['人员编码','用户所在机构编码','操作者名','操作口令','创建时间','帐号状态','最近修改密码时间','联系电话','操作权限','申请口令校验码的MD5','注销日期']
    ]

}]);















































