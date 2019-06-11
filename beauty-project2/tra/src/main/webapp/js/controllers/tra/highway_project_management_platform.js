'use highway_project_management_platform';

/* Controllers */

app.controller('Highway_project_management_platformCtrl', ['$scope','$stateParams', function($scope,$stateParams) {

    $scope.folds = [
        {name: '项目信息表', filter:'',url:'project'},
        {name: '项目列表', filter:'starred',url:'project'},
        {name: '项目周期', filter:'sent',url:'project'},
        {name: '标段周期', filter:'important',url:'block'},
        {name: '标段列表', filter:'draft',url:'block'},
        {name: '人员登记', filter:'express',url:'block'},
        {name: '单位管理', filter:'a',url:'unit'},
        {name: '质量台账', filter:'b',url:'unit'},
        {name: '施工图审批', filter:'c',url:'unit'},
        {name: '交工信息', filter:'d',url:'completion'},
        {name: '竣工信息', filter:'e',url:'completion'},
        {name: '台账修正（工程部分）', filter:'f',url:'completion'},
        {name: '台账修正(台账信息)', filter:'g',url:'parameter'},
        {name: '台账修正', filter:'h',url:'parameter'},
        {name: '工程台账（工程部分）', filter:'i',url:'parameter'},
        {name: '工程台账（台帐信息）', filter:'j',url:'engineering'},
        {name: '变更方案', filter:'k',url:'engineering'},
        {name: '变更申请', filter:'l',url:'engineering'}
    ];
    $scope.fold = $stateParams.fold;

}]);

app.controller('Highway_project_management_platformProjectCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
       ['项目编号','项目名称','项目图标','数据库地址','是否启用','项目描述'],
       ['项目编号','项目名称','建设单位','项目法人','建设标准','建设等级','项目简介','计划开工日期','计划完工日期','实际完工日期','实际竣工日期','工期','工程预算额','工程结算','线路走向','所属省份','审批状态','记录添加人','记录添加时间','是否锁定'],
       ['周期编号','起始日期','截止日期','周期名称','是否锁定','状态','备注','记录添加人','记录添加时间']
    ]

}]);

app.controller('Highway_project_management_platformBlockCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
        ['标段','周期编号','起始日期','截止日期','备注','周期名称','记录添加人','记录添加时间'],
        ['标段编号','标段名称','标段类型','施工类型','中标企业','中标企业组织机构代码','合同价','结算价','开工时间','完工时间','标段简介','状态','动员预付款','费率','单位','记录添加人','记录添加时间'],
        ['身份证','姓名','生日期','职务','职称','资质证书编号','安全生产考核证种类','安全生产考核证编号','注册单位','入职时间','离职时间','单位','状态','记录添加人','记录添加时间']
    ]

}]);
app.controller('Highway_project_management_platformUnitCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
        ['单位名称','负责人'],
        ['父节点','工程实体名称','节点编码','单元划分','关联工程划分','质量标准','关联质量标准','桩号类型','起始桩号','结束桩号','合同图号','变更图号','开工日期','完成日期','是否重点工程','工程状态','节点类型','投资额 (元)','权值','是否叶子节点','层级码','排序号','备注'],
        ['项目名称','项目法人','所在区域','建设地址','项目建设模式','起点','讫点','建设类别','建设性质','项目级别','施工图设计编制单位','计划开工日期','建设工期','建设依据','项目建设必要性','建设内容','线路走向','小桥','计划总设资','中桥','大桥','中央投资','国家预算内投资','停车区数量','停车区名称','服务区名称','服务区数量']
    ]
}]);

app.controller('Highway_project_management_platformCompletionCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
        ['项目名称','项目法人','工程验收时间','申请交工时间','工程验收号','合同段名称及编号','本合同段主要工程量','施工单位','设计单位','监理单位','工程质量执行情况','处理意见及有关决定','合同段问题意见','施工单位意见','设计单位意见','项目法人意见'],
        ['项目名称','项目法人','试运行期','开工时期','完工时期','法定代表人','传真','原批准概算','调整概算','竣工决算','联系人','工程位置','工程内容及规模','施工单位','设计单位'],
        ['修正编号','工程编号','工程名称','父级编号','起桩号','止桩号','是否新增','备注','记录添加人','记录添加时间','修正类型','自身编号','父级自身编号','层级','台账类型','排序号']
    ]
}]);

app.controller('Highway_project_management_platformParameterCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
        ['记录添加人','记录添加时间','修正编号','工程编号','序号','台账编号','账类型','清单编号','工程简称','规格型号','数量','修正数量','图号','是否新增','备注','台账名称','修正类型','监理数量','业主数量','起桩号','止桩号'],
        ['修正编号','修正名称','修正日期','修正内容','备注','审核状态','记录添加人','记录添加时间','是否锁定','生效日期','流程状态代码','流程状态说明','流程时间'],
        ['工程编号','工程名称','上级编号','起桩号','止桩号','是否新增','是否锁定','是否隐藏','备注','自身编号','父级自身编号','序号','记录添加人','记录添加时间','层级','账类型','关联变更令编号','关联修正编号','排序号']
    ]
}]);

app.controller('Highway_project_management_platformEngineeringCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
        ['工程编号','台账编号','台账类型','序号','清单编号','合同数量','修正数量','变更数量','起桩号','止桩号','规格型号','图号','变更图号','关联台账编号','生效日期','简称','是否新增','备注','记录添加人','记录添加时间','台账名称','关联变更令编号','关联修正编号'],
        ['方案编号','纪要编号','变更类型','变更等级','申请日期','变更金额','变更位置','变更原因','变更内容','变更依据','审批状态','变更方式','变更名称','记录添加人','记录添加时间','原图号','原图名','变更图号','备注','流程状态代码','流程状态说明','流程时间'],
        ['申请编号','变更名称','变更方式','原图号','原图名','变更图号','申请日期','变更类型','变更等级','变更金额','变更位置','变更原因','变更内容','变更依据','变更方案编号','审批状态','记录添加人','记录添加时间','备注','流程状态代码','流程状态说明','流程时间']
    ]
}]);
