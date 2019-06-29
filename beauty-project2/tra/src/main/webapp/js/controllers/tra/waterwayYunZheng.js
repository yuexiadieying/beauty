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
        {name: '年度审验业户记录', filter:'a',url:'businessHouseholds'},
        {name: '注销退出业户记录', filter:'b',url:'businessHouseholds'},
        {name: '企业违章记录', filter:'c',url:'other'},
        {name: '营运船舶信息', filter:'d',url:'ship'},
        {name: '船舶类型代码', filter:'e',url:'ship'},
        {name: '年度审验船舶记录', filter:'z',url:'ship1'},
        {name: '变更船舶记录', filter:'f',url:'ship1'},
        {name: '船舶违章记录', filter:'g',url:'ship1'},
        {name: '业户与船舶年审报数据', filter:'h',url:'ship1'},
        {name: '运输船舶名录', filter:'i',url:'ship'},
        {name: '运政管理人员名录', filter:'j',url:'other'}

    ];
    $scope.fold = $stateParams.fold;
}]);

app.controller('WaterwayYunZhengListCtrl', ['$scope', '$stateParams','traUtil','$http','Global', function($scope, $stateParams,traUtil,$http,Global) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
        ['行政区划代码','行政区划名称'],
        ['机构编码','所在行政区划','机构全称','机构简称','机构负责人姓名','部门负责人','填报人姓名','联系电话'],
        ['申请机构编码','申请事项类型','申请说明','申请提交时间','提出许可申请对象的记录编号','许可机构等级','许可时间','许可结果','许可说明','许可机构']
    ]

    traUtil.getUserInfo();

    $scope.pageParam = {
        pageNo : 1,
        pageSize:10
    }

    $scope.loadPageData = function(){
        if($scope.fold=='')
        {
            $scope.sslyzgl_xzqh = [];
            $http.post('/traffic/sslyzgl/xzqh',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_xzqh = response.data.responseData.responseData;
                    }
                });
        }
        else if($scope.fold=='starred')
        {
            $scope.sslyzgl_gljg= [];
            $http.post('/traffic/sslyzgl/gljg',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_gljg = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_gljg);
                    }
                });
        }
        else if($scope.fold=='sent')
        {
            $scope.sslyzgl_xkzsqjkl = [];
            $http.post('/traffic/sslyzgl/xksqjl',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_xkzsqjkl = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_xkzsqjkl);
                    }
                });

        }
    }

    $scope.prevPage = function () {
        if($scope.pageParam.pageNo>1) {
            $scope.pageParam.pageNo--;
            $scope.loadPageData();
        }
    }

    $scope.nextPage = function () {
        $scope.pageParam.pageNo++;
        $scope.loadPageData();
    }

    $scope.pageIndex = function(pageNo){
        $scope.pageParam.pageNo = pageNo;
        $scope.loadPageData();
    }

    $scope.loadPageData();

}]);

app.controller('WaterwayYunZhengWaterwayCtrl', ['$scope', '$stateParams','traUtil','$http','Global', function($scope, $stateParams,traUtil,$http,Global) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
       ['序号','经营者管理机构编码','经营者名称','经营者的经济类型','组织机构代码','注册资金','法人代表','详细地址','邮政编码','联系电话','传真号码','首次发证日期','批准机关','批准文号','许可证号','最近发证日期','经营期限','有效期的开始日期','有效期的截止日期','经营范围：客运','经营范围：货运',' 经营范围：兼营','经营范围分类','最近年审日期（冗余）','最近年审结果（冗余）','盈利状态（冗余）','注销日期（冗余）','许可申请号','许可申请状态','简要说明','台帐档案号'],
       ['序号','人员编号','企业编号','人员姓名','性别','学历','职务类别','职务名称','身份证号','船员适任证号','船员适任证类型','适任证船员类型','船员适任证书等级','简要说明']
    ]

    traUtil.getUserInfo();

    $scope.pageParam = {
        pageNo : 1,
        pageSize:10,
        requestData:''
    }

    $scope.searchData = function(){
        $scope.loadPageData();
    }

    $scope.loadPageData = function(){
        if($scope.fold=='important')
        {
            $scope.sslyzgl_slysyhzt = [];
            $http.post('/traffic/sslyzgl/slysyhzt',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_slysyhzt = response.data.responseData.responseData;
                    }
                });
        }
        else if($scope.fold=='draft')
        {
            $scope.sslyzgl_slysqyry = [];
            $http.post('/traffic/sslyzgl/slysqyry',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_slysqyry = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_slysqyry);
                    }
                });

        }
    }

    $scope.prevPage = function () {
        if($scope.pageParam.pageNo>1) {
            $scope.pageParam.pageNo--;
            $scope.loadPageData();
        }
    }

    $scope.nextPage = function () {
        $scope.pageParam.pageNo++;
        $scope.loadPageData();
    }

    $scope.pageIndex = function(pageNo){
        $scope.pageParam.pageNo = pageNo;
        $scope.loadPageData();
    }

    $scope.loadPageData();


}]);

app.controller('WaterwayYunZhengAuxiliaryCtrl', ['$scope', '$stateParams','traUtil','$http','Global', function($scope, $stateParams,traUtil,$http,Global) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
       ['编号','企业管理机构编码','企业名称','经济类型','组织机构代码','非个体经营者都有该代码','注册资金','法人代表','企业详细地','邮政编码','联系电话','传真号码','首次发证日期','批准机关','批准文号','许可证号','经营期限','最近发证日期','有效期起始日期','有效期截止日期','经营项目分类','经营项目（船舶管理许可证的经营范围）','行政区划范围','最近年审日期（冗余）','最近年审结果（冗余）','盈利状态（冗余）','注销日期','许可申请号','许可申请状态','简要说明','台帐档案号'],
       ['编号','企业编号','人员姓名','职务类别','职务名称','性别','学历','身份证号','资格或从业培训证书名及编号号','简要说明','图片与资料文件夹']
    ]

    traUtil.getUserInfo();

    $scope.pageParam = {
        pageNo : 1,
        pageSize:10,
        requestData:''
    }

    $scope.searchData = function(){
        $scope.loadPageData();
    }

    $scope.loadPageData = function(){
        if($scope.fold=='trash')
        {
            $scope.sslyzgl_ysfzqytz = [];
            $http.post('/traffic/sslyzgl/ysfzqytz',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_ysfzqytz = response.data.responseData.responseData;
                    }
                });
        }
        else if($scope.fold=='y')
        {
            $scope.sslyzgl_ysfzqyry = [];
            $http.post('/traffic/sslyzgl/ysfzqyry',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_ysfzqyry = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_ysfzqyry);
                    }
                });
        }

    }

    $scope.prevPage = function () {
        if($scope.pageParam.pageNo>1) {
            $scope.pageParam.pageNo--;
            $scope.loadPageData();
        }
    }

    $scope.nextPage = function () {
        $scope.pageParam.pageNo++;
        $scope.loadPageData();
    }

    $scope.pageIndex = function(pageNo){
        $scope.pageParam.pageNo = pageNo;
        $scope.loadPageData();
    }

    $scope.loadPageData();

}]);

app.controller('WaterwayYunZhengBusinessHouseholdsCtrl', ['$scope', '$stateParams','traUtil','$http','Global', function($scope, $stateParams,traUtil,$http,Global) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
        ['编号','年审日期','年审结论','管辖机构编号','（水运或服务）企业编号','企业类别','经营者名称','法人代表','经济类型','注册地址','联系电话','许可证号','许可证发证日期','许可证有效截期','经营范围分类','运输或营业收入（万元）','运输或营业成本（万元）','备注'],
        ['共享ChangeNo','企业（含个体与服务业）编号','经营者类别','经营者名称','经营者地址','许可证编号','最近发证日期','经营范围分类','管理机构','注销原因','退出日期','简要说明','台账档案号']
    ]

    traUtil.getUserInfo();

    $scope.pageParam = {
        pageNo : 1,
        pageSize:10,
        requestData:''
    }

    $scope.searchData = function(){
        $scope.loadPageData();
    }

    $scope.loadPageData = function(){
        if($scope.fold=='a')
        {
            $scope.sslyzgl_ndsyyhjl = [];
            $http.post('/traffic/sslyzgl/ndsyyhjl',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_ndsyyhjl = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_ndsyyhjl);
                    }
                });
        }
        else if($scope.fold=='b')
        {
            $scope.sslyzgl_zxtcyhjl = [];
            $http.post('/traffic/sslyzgl/zxtcyhjl',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_zxtcyhjl = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_zxtcyhjl);
                    }
                });
        }

    }

    $scope.prevPage = function () {
        if($scope.pageParam.pageNo>1) {
            $scope.pageParam.pageNo--;
            $scope.loadPageData();
        }
    }

    $scope.nextPage = function () {
        $scope.pageParam.pageNo++;
        $scope.loadPageData();
    }

    $scope.pageIndex = function(pageNo){
        $scope.pageParam.pageNo = pageNo;
        $scope.loadPageData();
    }

    $scope.loadPageData();

}]);

app.controller('WaterwayYunZhengShipCtrl', ['$scope', '$stateParams', 'traUtil','$http','Global', function($scope, $stateParams,traUtil,$http,Global) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
        ['序号','水运企业或个体业主编号','船检登记号','船舶识别号','船籍港','船舶名称','曾用名','船舶类型编码','船舶标准类型','船舶材料','燃料类型','船舶总吨','总载重量','净载重量','车位数','载客量','箱位数','船舱容积立方米','主机台数','主机合计功率','总长（米）','型宽（米）','满载吃水（米）','航速（节）','建成日期','改建日期','航区','船旗国','控制状态','船舶所有人','船舶所有人电话','船舶管理人','船舶管理人许可证号','营运证制作机构编码','营运证号','营运证经营范围','制证日期','有效截至期','许可证有效截至日期（冗余）','最近年审日期（冗余）','最近年审结果（冗余）','最近变更日期（冗余）','最近变更（冗余）','许可申请号','许可申请状态'],
        ['序号','船舶类型代码','船舶类型名称'],
        ['序号','报表年份','船舶编码','唯一编码','船检登记号','管辖机构编码','船舶经营人','船名','船舶类型名','船旗国','航区','型宽（米）','满载吃水（米）','航速（节）','船舶总吨','总载重量','净载重量','载客量','箱位数','主机合计功率','简要说明']
    ]

    traUtil.getUserInfo();

    $scope.pageParam = {
        pageNo : 1,
        pageSize:10,
        requestData:''
    }

    $scope.searchData = function(){
        $scope.loadPageData();
    }

    $scope.loadPageData = function(){
        if($scope.fold=='d')
        {
            $scope.sslyzgl_yycbxx = [];
            $http.post('/traffic/sslyzgl/yycbxx',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_yycbxx = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_yycbxx);
                    }
                });
        }
        else if($scope.fold=='e')
        {
            $scope.sslyzgl_cblxdm = [];
            $http.post('/traffic/sslyzgl/cblxdm',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_cblxdm = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_cblxdm);
                    }
                });
        }
        else if($scope.fold=='i')
        {
            $scope.sslyzgl_yscbml = [];
            $http.post('/traffic/sslyzgl/yscbml',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_yscbml = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_yscbml);
                    }
                });
        }

    }

    $scope.prevPage = function () {
        if($scope.pageParam.pageNo>1) {
            $scope.pageParam.pageNo--;
            $scope.loadPageData();
        }
    }

    $scope.nextPage = function () {
        $scope.pageParam.pageNo++;
        $scope.loadPageData();
    }

    $scope.pageIndex = function(pageNo){
        $scope.pageParam.pageNo = pageNo;
        $scope.loadPageData();
    }

    $scope.loadPageData();


}]);

app.controller('WaterwayYunZhengShip1Ctrl', ['$scope', '$stateParams', 'traUtil','$http','Global', function($scope, $stateParams,traUtil,$http,Global) {
    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
        ['编号','船舶记录号','船检登记号','船名','船舶类型','经营者名','管辖机构','航区','船舶总吨','船舶总载重吨','船舶净载重吨','箱位数','载客量','功率','年审结论','年审合格证号','年度审验日期','年审合格证有效期限','年审合格证打印日期','备注'],
        ['编号','船舶记录号','船检登记号','船舶名称','船舶类型','船籍港','总吨','营运证号','营运证经营范围','营运证最近发证日期','船舶经营者','船舶所有人','管理机构','变更日期','变更类别','注销证号','注销登记证打印日期','简要说明'],
        ['编号','船舶编号','船名','船检登记号','超载载客','船舶违章','经营者名称','船舶所有人','许可证号','营运证号','记录登记日期','记录登记账号','记录登记机构','记录说明'],
        ['报表编号','审核年度','报表汇总机构','报表行号','列值']
    ]

    traUtil.getUserInfo();

    $scope.pageParam = {
        pageNo : 1,
        pageSize:10,
        requestData:''
    }

    $scope.searchData = function(){
        $scope.loadPageData();
    }

    $scope.loadPageData = function(){
        if($scope.fold=='z')
        {
            $scope.sslyzgl_ndsycbjl = [];
            $http.post('/traffic/sslyzgl/ndsycbjl',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_ndsycbjl = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_ndsycbjl);
                    }
                });
        }
        else if($scope.fold=='f')
        {
            $scope.sslyzgl_bgcbjl = [];
            $http.post('/traffic/sslyzgl/bgcbjl',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_bgcbjl = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_bgcbjl);
                    }
                });
        }
        else if($scope.fold=='g')
        {
            $scope.sslyzgl_cbwzjl = [];
            $http.post('/traffic/sslyzgl/cbwzjl',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_cbwzjl = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_cbwzjl);
                    }
                });
        }
        else if($scope.fold=='h')
        {
            $scope.sslyzgl_yhycbnsbsj = [];
            $http.post('/traffic/sslyzgl/yhycbnsbsj',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_yhycbnsbsj = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_yhycbnsbsj);
                    }
                });
        }
    }

    $scope.prevPage = function () {
        if($scope.pageParam.pageNo>1) {
            $scope.pageParam.pageNo--;
            $scope.loadPageData();
        }
    }

    $scope.nextPage = function () {
        $scope.pageParam.pageNo++;
        $scope.loadPageData();
    }

    $scope.pageIndex = function(pageNo){
        $scope.pageParam.pageNo = pageNo;
        $scope.loadPageData();
    }

    $scope.loadPageData();


}]);

app.controller('WaterwayYunZhengOtherCtrl', ['$scope', '$stateParams', 'traUtil','$http','Global', function($scope, $stateParams,traUtil,$http,Global) {

    $scope.fold = $stateParams.fold;
    $scope.tableTitle= [
        ['序号','水运或服务企业编号','奖励表彰','违章处罚','价格欺诈','客户投诉','生产事故','船舶违章','企业名称',
            '企业地址','法人代表','许可证号','记录登记日期','记录登记账号','记录登记机构','记录说明'],
        ['编号','所在机构编码','人名','性别','所在部门及职务','出生年份','联系电话','执法证名称及编号']
    ]

    traUtil.getUserInfo();

    $scope.pageParam = {
        pageNo : 1,
        pageSize:10,
        requestData:''
    }

    $scope.searchData = function(){
        $scope.loadPageData();
    }

    $scope.loadPageData = function(){
        if($scope.fold=='c')
        {
            $scope.sslyzgl_qywzjl = [];
            $http.post('/traffic/sslyzgl/qywzjl',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_qywzjl = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_qywzjl);
                    }
                });
        }
        else if($scope.fold=='j')
        {
            $scope.sslyzgl_yzglryml = [];
            $http.post('/traffic/sslyzgl/yzglryml',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_yzglryml = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_yzglryml);
                    }
                });
        }
    }

    $scope.prevPage = function () {
        if($scope.pageParam.pageNo>1) {
            $scope.pageParam.pageNo--;
            $scope.loadPageData();
        }
    }

    $scope.nextPage = function () {
        $scope.pageParam.pageNo++;
        $scope.loadPageData();
    }

    $scope.pageIndex = function(pageNo){
        $scope.pageParam.pageNo = pageNo;
        $scope.loadPageData();
    }

    $scope.loadPageData();

}]);




