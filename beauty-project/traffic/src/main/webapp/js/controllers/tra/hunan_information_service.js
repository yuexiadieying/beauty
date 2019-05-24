'use hunan_information_service';


app.controller('Hunan_information_serviceCtrl', ['$scope', function($scope) {
     $scope.data={
         tables:[
             ['事故编号','车辆编码','车牌号码','从业资格证号码','驾驶员姓名','事故日期','事故时间','事故地点','死亡人数','车牌颜色','从业人员编号','身份证号码','事故原因','事故情况','记录人','直接经济损失','事故责任与性质','路况','二级维护情况','天气情况','轻伤人数','重伤人数','备注','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','审核状态','审核意见','从业资格证号','人员扣分','审核机构','审核人','审核时间','信用信息来源',]
         ]
     }
    $scope.folds = [
        {name: '交通责任事故表', filter:''},
        {name: '车辆信用考核表', filter:'starred'},
        {name: '车辆责令整改表', filter:'sent'},
        {name: '社会投诉表', filter:'important'},
        {name: '业户考核申报表', filter:'draft'},
        {name: '从业人员考核签注表', filter:'trash'},
        {name: '违规上访表', filter:'a'},
        {name: '设备档案表', filter:'b'},
        {name: '电子签章申报内容表', filter:'c'},
        {name: '设施档案表', filter:'d'},
        {name: '政府运输任务表', filter:'e'},
        {name: '经营违章表', filter:'f'},
        {name: '企业荣誉表', filter:'g'},
        {name: '业户责令整改表', filter:'h'},
        {name: '整改内容表', filter:'i'},
        {name: '规章制度表', filter:'j'},
        {name: '恶性服务事件表', filter:'k'},
        {name: '继续教育记录', filter:'l'},
        {name: '员工信息表', filter:'m'},
        {name: '先进事迹表', filter:'n'},
        {name: '申诉主表', filter:'o'}
    ];

  }]);
app.controller('Hunan_information_serviceListCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
}]);