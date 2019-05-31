'use waterwayYunZheng';

/* Controllers */

app.controller('WaterwayYunZhengCtrl', ['$scope','$stateParams', function($scope,$stateParams) {



    $scope.folds = [
        {name: '行政区划', filter:'',url:'list'},
        {name: '管理机构', filter:'starred',url:'list'},
        {name: '许可申请记录', filter:'sent',url:'list'},
        {name: '水路运输业户台帐', filter:'important',url:'waterway'},
        {name: '水路运输企业人员', filter:'draft',url:'waterway'},
        {name: '运输辅助企业台帐', filter:'trash',url:'auxiliary'},
        {name: '运输辅助企业人员', filter:'y',url:'auxiliary'},
        {name: '年度审验业户记录', filter:'a',url:'auxiliary'},
        {name: '注销退出业户记录', filter:'b',url:'list'},
        {name: '企业违章记录', filter:'c',url:'list'},
        {name: '营运船舶信息', filter:'d',url:'list'},
        {name: '船舶类型代码', filter:'e',url:'list'},
        {name: '变更船舶记录', filter:'f',url:'list'},
        {name: '船舶违章记录', filter:'g',url:'list'},
        {name: '业户与船舶年审报数据', filter:'h',url:'list'},
        {name: '运输船舶名录', filter:'i',url:'list'},
        {name: '运政管理人员名录', filter:'j',url:'list'}

    ];
    $scope.fold = $stateParams.fold;
}]);

app.controller('WaterwayYunZhengListCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
        ['行政区划代码','行政区划名称'],
        ['机构编码','所在行政区划','机构全称','机构简称','机构负责人姓名','部门负责人','填报人姓名','联系电话'],
        ['申请机构编码','申请事项类型','申请说明','申请提交时间','提出许可申请对象的记录编号','许可机构等级','许可时间','许可结果','许可说明','许可机构']
    ]

}]);
app.controller('WaterwayYunZhengWaterwayCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
       ['经营者管理机构编码','经营者名称','经营者的经济类型','组织机构代码','注册资金','法人代表','详细地址','邮政编码','联系电话','传真号码','首次发证日期','批准机关','批准文号','许可证号','最近发证日期','经营期限','有效期的开始日期','有效期的截止日期','经营范围：客运','经营范围：货运',' 经营范围：兼营','经营范围分类','最近年审日期（冗余）','最近年审结果（冗余）','盈利状态（冗余）','注销日期（冗余）','许可申请号','许可申请状态','简要说明','台帐档案号'],
       ['人员编号','企业编号','人员姓名','性别','学历','职务类别','职务名称','身份证号','船员适任证号','船员适任证类型','适任证船员类型','船员适任证书等级','简要说明']
    ]

}]);
app.controller('WaterwayYunZhengAuxiliaryCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
       ['企业管理机构编码','企业名称','经济类型','组织机构代码','非个体经营者都有该代码','注册资金','法人代表','企业详细地','邮政编码','联系电话','传真号码','首次发证日期','批准机关','批准文号','许可证号','经营期限','最近发证日期','有效期起始日期','有效期截止日期','经营项目分类','经营项目（船舶管理许可证的经营范围）','行政区划范围','最近年审日期（冗余）','最近年审结果（冗余）','盈利状态（冗余）','注销日期','许可申请号','许可申请状态','简要说明','台帐档案号'],
       ['企业编号','人员姓名','职务类别','职务名称','性别','学历','身份证号','资格或从业培训证书名及编号号','简要说明','图片与资料文件夹']
    ]

}]);

