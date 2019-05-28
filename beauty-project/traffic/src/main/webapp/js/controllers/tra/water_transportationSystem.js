'use collaborative_management';

/* Controllers */

app.controller('Water_transportationSystemCtrl', ['$scope', function($scope) {

    $scope.folds = [
        {name: '经营业户信息', filter:'',index:0},
        {name: '营运车辆信息', filter:'starred',index:1},
        {name: '从业人员信息', filter:'sent',index:2}
    ];

}]);

app.controller('Water_transportationSystemListCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.index = $stateParams.index;
    $scope.tableTitle=[['船名','时间','船舶动态表',' 经度','纬度','速度','航向','艏向','状态','船舶类型','预留','MMS','转向速率','UTC时间','数据源'],['船名','时间','船舶动态表',' 经度','纬度','速度','航向','艏向','状态','船舶类型','预留','MMS','转向速率','UTC时间','数据源'],['船名2','时间','船舶动态表',' 经度','纬度','速度','航向','艏向','状态','船舶类型','预留','MMS','转向速率','UTC时间','数据源']]
}]);









