'use hunan_information_service';


app.controller('Hunan_information_serviceCtrl', ['$scope','$stateParams', function($scope,$stateParams) {

    $scope.folds = [
        {name: '交通责任事故表', filter:'',url:'vehicle'},
        {name: '车辆信用考核表', filter:'starred',url:'vehicle'},
        {name: '车辆责令整改表', filter:'sent',url:'vehicle'},
        {name: '社会投诉表', filter:'important',url:'complaint'},
        {name: '业户考核申报表', filter:'draft',url:'complaint'},
        {name: '从业人员考核签注表', filter:'trash',url:'complaint'},
        {name: '违规上访表', filter:'a',url:'petition'},
        {name: '设备档案表', filter:'b',url:'petition'},
        {name: '电子签章申报内容表', filter:'c',url:'petition'},
        {name: '设施档案表', filter:'d',url:'facilities'},
        {name: '政府运输任务表', filter:'e',url:'facilities'},
        {name: '经营违章表', filter:'f',url:'facilities'},
        {name: '企业荣誉表', filter:'g',url:'honor'},
        {name: '业户责令整改表', filter:'h',url:'honor'},
        {name: '整改内容表', filter:'i',url:'honor'},
        {name: '规章制度表', filter:'j',url:'rules'},
        {name: '恶性服务事件表', filter:'k',url:'rules'},
        {name: '继续教育记录', filter:'l',url:'rules'},
        {name: '员工信息表', filter:'m',url:'employee'},
        {name: '先进事迹表', filter:'n',url:'employee'},
        {name: '申诉主表', filter:'o',url:'employee'}
    ];
    $scope.fold = $stateParams.fold;
  }]);

app.controller('Hunan_information_serviceVehicleCtrl', ['$scope', '$stateParams', 'traUtil','$http','Global',function($scope, $stateParams,traUtil,$http,Global) {
    $scope.fold = $stateParams.fold;
    $scope.data={
        tables:[
            ['序号','事故编号','车辆编码','车牌号码','从业资格证号码','驾驶员姓名','事故日期','事故时间','事故地点','死亡人数','车牌颜色','从业人员编号','身份证号码','事故原因','事故情况','记录人','直接经济损失','事故责任与性质','路况','二级维护情况','天气情况','轻伤人数','重伤人数','备注','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','审核状态','审核意见','从业资格证号','人员扣分','审核机构','审核人','审核时间','信用信息来源'],
            ['序号','考核年度','业户','考核等','累计记分','系统记分','备注','时间戳','修改时间','修改日期','修改人','创建时间','创建日期','创建人','是否有效'],
            ['序号','整改号','备注','考核年度','业户','整改开始时间','下发日期','报告提交日期','整改报告','验收结果','验收人员','验收时间','整改状态','整改结束时间','时间戳','修改时间','修改日期','修改人','创建时间','创建日期','创建人','是否有效','检查机构','验收意见','系统评分','考核等级']
        ]
    }

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
        if($scope.fold=='')
        {
            $scope.sslyzgl_jtzrsgb = [];
            $http.post('/traffic/hnsglsljsyysscxxfwxt/jtzrsgb',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_jtzrsgb = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_jtzrsgb);
                    }
                });
        }
        else if($scope.fold=='starred')
        {
            $scope.sslyzgl_clxykhb = [];
            $http.post('/traffic/hnsglsljsyysscxxfwxt/clxykhb',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_clxykhb = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_clxykhb);
                    }
                });
        }
        else if($scope.fold=='sent')
        {
            $scope.sslyzgl_clzlzgb = [];
            $http.post('/traffic/hnsglsljsyysscxxfwxt/clzlzgb',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_clzlzgb = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_clzlzgb);
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

app.controller('Hunan_information_serviceComplaintCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.data={
        tables:[
            ['序号','投诉号','投诉人','投诉日期','投诉内容','投诉部门','社会影响','违法事实','处理情况','投诉电话','投诉人来源','被投诉人','电子邮件','媒体曝光','处罚类型','投诉类型','投诉人联系电话','记录人单位','记录人电话','记录人','处理日期','处理部门','处理部门意见','处理结果意见','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','时间戳','审核状态','车辆编号','审核意见','人员扣分','从业资格证号','审核机构','审核人','审核时间','信用信息来源','身份证号','驾驶员姓名'],
            ['序号','申报号','申报日期','考核年度','申报类型','申报内容','申报状态','自评得分','自评等级','考核得分','考核等级','初评机构','税务登记号','工商营业执照号','经营状态','联系电话','经营负责人','法定代表人证件类别','法定代表人联系电话','法定代表人','经济类型','行政区域代码','邮政编码','业户地址','分支机构编码','上级业户编码','管理机构编码','发证机关','有效期止','许可证号','经营范围','企业实体类型','企业名称','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','时间戳','初评分数','初评等级','综评分数','综评等级','复评分数','复评等级','回复意见'],
            ['序号','从业人员','考核年度','考核周期起始日期','结束日期','得分','累计积分','状态','从业资格类别','考核级别','备注','评定人','评定时间','评定备注','时间戳','修改时间','修改日期','修改人','创建时间','创建日期','创建人','是否有效','从业资格证编号','从业资格证照片1','从业资格证照片2']
        ]
    }

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
            $scope.sslyzgl_shtsb = [];
            $http.post('/traffic/hnsglsljsyysscxxfwxt/shtsb',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_shtsb = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_shtsb);
                    }
                });
        }
        else if($scope.fold=='draft')
        {
            $scope.sslyzgl_yhkhsbb = [];
            $http.post('/traffic/hnsglsljsyysscxxfwxt/yhkhsbb',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_yhkhsbb = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_yhkhsbb);
                    }
                });
        }
        else if($scope.fold=='trash')
        {
            $scope.sslyzgl_cyrykhqzb = [];
            $http.post('/traffic/hnsglsljsyysscxxfwxt/cyrykhqzb',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_cyrykhqzb = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_cyrykhqzb);
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

app.controller('Hunan_information_servicePetitionCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.data={
        tables:[
            ['上访号','违规上访情况简介','事件时间','主要原因','事件经过','参加人数','上访地址','社会影响','投诉人','来访车号','反映问题','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','时间戳','审核状态','审核意见','审核机构','审核人','审核时间','信用信息来源','处理情况','扣分分值'],
            ['设备名称','设备类型','自有数量','设备号码','规格型号','购买日期','生产日期','报废年限','生产厂商','是否外协','外协数量','检定日期','检定报告编号','备注','时间戳','修改时间','修改日期','修改人','创建时间','创建日期','创建人','是否有效'],
            ['材料名称','排序号','时间戳','修改时间','修改日期','修改人','创建时间','创建日期','创建人','是否有效']
        ]
    }

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
            $scope.sslyzgl_wgsfb = [];
            $http.post('/traffic/hnsglsljsyysscxxfwxt/wgsfb',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_wgsfb = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_wgsfb);
                    }
                });
        }
        else if($scope.fold=='b')
        {
            $scope.sslyzgl_sbdab = [];
            $http.post('/traffic/hnsglsljsyysscxxfwxt/sbdab',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_sbdab = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_sbdab);
                    }
                });
        }
        else if($scope.fold=='c')
        {
            $scope.sslyzgl_dzqzsbnrb = [];
            $http.post('/traffic/hnsglsljsyysscxxfwxt/dzqzsbnrb',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_dzqzsbnrb = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_dzqzsbnrb);
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

app.controller('Hunan_information_serviceFacilitiesCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.data={
        tables:[
            ['设施名称','设施数量','设施单位','标准数量','备注','时间戳','修改时间','修改日期','修改人','创建时间','创建日期','创建人','是否有效'],
            ['任务号','任务说明','完成情况','投入运力','完成运量','下达部门','完成时间','备注','时间戳','修改时间','修改日期','修改人','创建时间','创建日期','创建人','是否有效'],
            ['执法单号','违法日期','违法时间','责任人','违法地点','违法事实','处罚情况','违法处罚日期','记录人','执法人员1','执法证号1','执法人员2','执法证号2','备注','是否有效','创建人','创建日期','创建时间','修改人','修改日期','经营违章表','修改时间','时间戳','审核意见','从业资格证编号','审核机构','审核人','审核时间','信用信息来源','身份证号','驾驶员姓名']
        ]
    }

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
            $scope.sslyzgl_ssdab = [];
            $http.post('/traffic/hnsglsljsyysscxxfwxt/ssdab',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_ssdab = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_ssdab);
                    }
                });
        }
        else if($scope.fold=='e')
        {
            $scope.sslyzgl_zfysrwb = [];
            $http.post('/traffic/hnsglsljsyysscxxfwxt/zfysrwb',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_zfysrwb = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_zfysrwb);
                    }
                });
        }
        else if($scope.fold=='f')
        {
            $scope.sslyzgl_jywzb = [];
            $http.post('/traffic/hnsglsljsyysscxxfwxt/jywzb',$scope.pageParam)
                .then(function(response) {
                    if (response.data.result==Global.SUCCESS) {
                        $scope.sslyzgl_jywzb = response.data.responseData.responseData;
                        console.log($scope.sslyzgl_jywzb);
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

app.controller('Hunan_information_serviceHonorCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.data={
        tables:[
            ['荣誉级别','荣誉名称','荣誉描述','创建人','创建日期','创建时间','修改人','修改日期','修改时间','时间戳','审核状态','审核意见','获得日期','备注','是否有效','审核机构','审核人','审核时间'],
            ['整改编号','整改标题','申请单号','检查人员','检查内容','开始整改日期','先进事迹表','结束整改日期','法律法规','整改报告','报告提交日期','验收时间','验收人员','下发日期','检查日期','检查机构','验收结果','整改状态','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','时间戳','验收意见'],
            ['整改内容','排序']
        ]
    }
}]);

app.controller('Hunan_information_serviceRulesCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.data={
        tables:[
            ['制度分类','制度标题','制度内容','执行日期','生效日期','发布日期','关键字','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','时间戳'],
            ['发生时间','发生日期','事件原因','发生地点','发生事实','记录人','责任人','车辆','备注','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','时间戳','审核状态','审核意见','从业人员编号','从业资格证号','恶性服务事件表','审核机构','审核人','审核时间','信用信息来源','身份证号','驾驶员姓名','被媒体曝光'],
            ['从业资格类别序号','证件号码','从业资格类别','继续教育机构','教育批次','开始时间','结束时间','继续教育原因','备注','姓名','性别','培训驾校','报名日期','结业日期','学时','考试成绩','培训结果','继续教育周期','继续教育记录','是否使用','图片1','图片2','从业资格证编号','考试日期','继续教育有效期起','继续教育有效期止','办理机构','办理人','办理日期','是否签注','签注人','签注时间','继续教育类型']
        ]
    }
}]);

app.controller('Hunan_information_serviceEmployeeCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.fold = $stateParams.fold;
    $scope.data={
        tables:[
            ['人员姓名','人员性别','出生日期','身份证号','民族','籍贯','联系电话','联系地址','电子邮件','邮政编码','文化程度','技术等级','健康状况','从业状态','驾驶证号','准驾车型','驾驶证初领时间','从业资格证号','从业资格类别','核发日期','有效期起','有效期止','证照状态','发证机关','补换证次数','管理机构','资格等级','档案号','考生区域','从业资格范围','时间戳','修改时间','修改日期','修改人','创建时间','创建日期','创建人','是否有效','职位','考核年度','考核等级','考核状态'],
            ['从业资格证编号','先进事迹发生日期','先进事迹发生时间','当事人','当事人证件号码','联系方式','事迹类型','涉及物品','涉及金额','加分','先进事迹经过','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','时间戳','从业人员编号','经办人','经办人电话'],
            ['申诉号','申诉日期','申诉时间','申报类型','企业实体类型','申诉标题','申诉内容','申诉状态','是否有效','创建人','创建日期','创建时间','修改人','修改日期','修改时间','时间戳','管理机构编码','企业名称','申诉年份','申报状态']
        ]
    }
}]);



































