'use hunan_information_service';


app.controller('Hunan_information_serviceCtrl', ['$scope','$stateParams', function($scope,$stateParams) {

    $scope.folds = [
        {name: '交通责任事故表', filter:'',url:'vehicle'},
        {name: '车辆信用考核表', filter:'starred',url:'vehicle'},
        {name: '车辆责令整改表', filter:'sent',url:'vehicle'},
        {name: '社会投诉表', filter:'important',url:'complaint'},
        {name: '业户考核申报表', filter:'draft',url:'complaint'},
        {name: '从业人员考核签注表', filter:'trash',url:'complaint'},
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
app.controller('Hunan_information_serviceVehicleCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.data={
        tables:[
            ['事故编号','车辆编码','车牌号码','从业资格证号码','驾驶员姓名','事故日期','事故时间','事故地点','死亡人数','车牌颜色','从业人员编号','身份证号码','事故原因','事故情况','记录人','直接经济损失','事故责任与性质','路况','二级维护情况','天气情况','轻伤人数','重伤人数','备注','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','审核状态','审核意见','从业资格证号','人员扣分','审核机构','审核人','审核时间','信用信息来源'],
            ['考核年度','业户','考核等','累计记分','系统记分','备注','时间戳','修改时间','修改日期','修改人','创建时间','创建日期','创建人','是否有效'],
            ['整改号','备注','考核年度','业户','整改开始时间','下发日期','报告提交日期','整改报告','验收结果','验收人员','验收时间','整改状态','整改结束时间','时间戳','修改时间','修改日期','修改人','创建时间','创建日期','创建人','是否有效','检查机构','验收意见','系统评分','考核等级']
        ]
    }
}]);
app.controller('Hunan_information_serviceComplaintCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.data={
        tables:[
            ['投诉号','投诉人','投诉日期','投诉内容','投诉部门','社会影响','违法事实','处理情况','投诉电话','投诉人来源','被投诉人','电子邮件','媒体曝光','处罚类型','投诉类型','投诉人联系电话','记录人单位','记录人电话','记录人','处理日期','处理部门','处理部门意见','处理结果意见','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','时间戳','审核状态','车辆编号','审核意见','人员扣分','从业资格证号','审核机构','审核人','审核时间','信用信息来源','身份证号','驾驶员姓名'],
            ['申报号','申报日期','考核年度','申报类型','申报内容','申报状态','自评得分','自评等级','考核得分','考核等级','初评机构','税务登记号','工商营业执照号','经营状态','联系电话','经营负责人','法定代表人证件类别','法定代表人联系电话','法定代表人','经济类型','行政区域代码','邮政编码','业户地址','分支机构编码','上级业户编码','管理机构编码','发证机关','有效期止','许可证号','经营范围','企业实体类型','企业名称','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','时间戳','初评分数','初评等级','综评分数','综评等级','复评分数','复评等级','回复意见'],
            ['从业人员','考核年度','考核周期起始日期','结束日期','得分','累计积分','状态','从业资格类别','考核级别','备注','评定人','评定时间','评定备注','时间戳','修改时间','修改日期','修改人','创建时间','创建日期','创建人','是否有效','从业资格证编号','从业资格证照片1','从业资格证照片2']
            ]
    }
}]);
