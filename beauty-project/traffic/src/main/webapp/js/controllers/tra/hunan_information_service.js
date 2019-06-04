'use hunan_information_service';


app.controller('Hunan_information_serviceCtrl', ['$scope','$stateParams', function($scope,$stateParams) {

    $scope.folds = [
        {name: '交通责任事故表', filter:'',url:'vehicle'},
        {name: '车辆信用考核表', filter:'starred',url:'vehicle'},
        {name: '车辆责令整改表', filter:'sent',url:'vehicle'},
        {name: '社会投诉表', filter:'important',url:'vehicle'},
        {name: '业户考核申报表', filter:'draft',url:'vehicle'},
        {name: '从业人员考核签注表', filter:'trash',url:'vehicle'},
        {name: '违规上访表', filter:'a',url:'vehicle'},
        {name: '设备档案表', filter:'b',url:'vehicle'},
        {name: '电子签章申报内容表', filter:'c',url:'vehicle'},
        {name: '设施档案表', filter:'d',url:'vehicle'},
        {name: '政府运输任务表', filter:'e',url:'vehicle'},
        {name: '经营违章表', filter:'f',url:'vehicle'},
        {name: '企业荣誉表', filter:'g',url:'vehicle'},
        {name: '业户责令整改表', filter:'h',url:'vehicle'},
        {name: '整改内容表', filter:'i',url:'vehicle'},
        {name: '规章制度表', filter:'j',url:'vehicle'},
        {name: '恶性服务事件表', filter:'k',url:'vehicle'},
        {name: '继续教育记录', filter:'l',url:'vehicle'},
        {name: '员工信息表', filter:'m',url:'vehicle'},
        {name: '先进事迹表', filter:'n',url:'vehicle'},
        {name: '申诉主表', filter:'o',url:'vehicle'}
    ];
    $scope.fold = $stateParams.fold;
  }]);
app.controller('Hunan_information_serviceListCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.data={
        tables:[
            ['事故编号','车辆编码','车牌号码','从业资格证号码','驾驶员姓名','事故日期','事故时间','事故地点','死亡人数','车牌颜色','从业人员编号','身份证号码','事故原因','事故情况','记录人','直接经济损失','事故责任与性质','路况','二级维护情况','天气情况','轻伤人数','重伤人数','备注','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','审核状态','审核意见','从业资格证号','人员扣分','审核机构','审核人','审核时间','信用信息来源'],
            ['考核年度','业户','考核等','累计记分','系统记分','备注','时间戳','修改时间','修改日期','修改人','创建时间','创建日期','创建人','是否有效'],
            ['整改号','备注','考核年度','业户','整改开始时间','下发日期','报告提交日期','整改报告','验收结果','验收人员','验收时间','整改状态','整改结束时间','时间戳','修改时间','修改日期','修改人','创建时间','创建日期','创建人','是否有效','检查机构','验收意见','系统评分','考核等级']
        ]
    }
}]);