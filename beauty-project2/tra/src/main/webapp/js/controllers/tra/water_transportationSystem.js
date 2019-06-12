'use collaborative_management';

/* Controllers */

app.controller('Water_transportationSystemCtrl', ['$scope', function($scope) {

    $scope.folds = [
        {name: '船舶动态表', filter:'',index:0},
        {name: '船舶动态历史表', filter:'starred',index:1},
        {name: '船舶静态表', filter:'sent',index:2}
    ];

}]);

app.controller('Water_transportationSystemListCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.index = $stateParams.index;
    $scope.tableTitle=[['船名','时间',' 经度','纬度','速度','航向','艏向','状态','船舶类型','预留','MMS','转向速率','UTC时间','数据源'],['船名','时间',' 经度','纬度','速度','航向','艏向','状态','船舶类型','预留','MMS','转向速率','UTC时间','数据源'],['船名','单位编号','呼号','MMSI','SIM','船舶类型','船长','船宽','型深','安全吃水','载重','最大航速','电话','邮箱','天线距船头距离','天线距左舷距离','目的港','预抵时间','预留','IMO编号','船籍','联系方式','数据源','英文船名']]
}]);

