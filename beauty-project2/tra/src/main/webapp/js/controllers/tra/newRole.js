'use newUser';

/* Controllers */
/*id为空时 新建
* id非空 修改
* */
app.controller('NewRoleCtrl', ['$scope','$stateParams','$timeout',
    '$http','Global','$state','traUtil','$rootScope',function($scope,$stateParams,$timeout,
                                                 $http,Global,$state,traUtil,$rootScope) {

    traUtil.getUserInfo();

    $scope.param={
        loginName:$stateParams.loginName,
        data:[
            {
                id:'sjtystjfxjc',
                name:'省交通运输统计分析监测与投资计划管理'
            },
            {
                id:'sdlyssjxtgl',
                name:'省道路运输三级协同管理'
            },
            {
                id:'gljt',
                name:'公路交通'
            },
            {
                id:'sslyzgl',
                name:'省水路运政管理'
            },
            {
                id:'zhgj',
                name:'智慧公交'
            },
            {
                id:'hnsglsljsyysscxxfwxt',
                name:'湖南省公路水路建设与运输市场信息服务系统'
            },
            {
                id:'hnsgkqyymtdwttlbb',
                name:'湖南省港口企业与码头单位吞吐量报表'
            },
            {
                id:'syaisxt',
                name:'水运AIS系统'
            },
            {
                id:'skylwspxt',
                name:'省客运联网售票系统'
            },
        ],
        editUserInfo:{},
        selectLevel:[]
    }

    $scope.select=[]

    if($scope.param.loginName != ''){
        $http.get('/traffic/user/getEditUserInfo', {
            params: {
                loginName: $scope.param.loginName
            }
        })
            .then(function(response) {
                if(response.data.result==Global.SUCCESS)
                {
                    $scope.param.editUserInfo = response.data.responseData;
                    $scope.arr = [];
                    console.log($scope.param.editUserInfo);
                    angular.forEach($scope.param.editUserInfo.userLevel,function (val,index) {
                        var data = {id:'',name:''};
                        angular.forEach($scope.param.data,function (val1,index1) {
                            if(val == val1.id)
                            {
                                data.id = angular.copy(val);
                                data.name = angular.copy(val1.name);
                            }
                        })
                        $scope.arr.push(data);
                    })
                    console.log($scope.arr);
                    //$scope.arr = [{id:'w4444',name:'省水路运政管理'},{id:'w11111',name:'省交通运输统计分析监测与投资计划管理'}];  //假设这是用户的权限
                    for(var i=0;i<$scope.param.data.length;i++){
                        for(var j=0;j<$scope.arr.length;j++){
                            if($scope.param.data[i].id ==$scope.arr[j].id ){
                                $scope.param.selectLevel[i] = 'select'
                                break;
                            }else{
                                $scope.param.selectLevel[i] = ''
                            }
                        }
                    }
                    console.log($scope.param.selectLevel);
                }else {
                    alert(response.data.errorInfo);
                }
            }, function(x) {
                $scope.authError = 'Server Error';
            });
    }

    $timeout(function () {
        $('#sel_search_orderstatus').multiselect({
            includeSelectAllOption: true,
            nonSelectedText : '--请选择--',
            buttonWidth: '90%',
        });
    },1000);

    //新建用户
    $scope.newUser = function () {

        console.log($("#sel_search_orderstatus").val());//回显的值

        $scope.param.editUserInfo.userLevel = [];

        angular.forEach($("#sel_search_orderstatus").val(),function (val,index) {
            $scope.param.editUserInfo.userLevel.push(val);
        })

        $http.post('/traffic/user/saveUserInfo', $scope.param.editUserInfo)
            .then(function(response) {
                if(response.data.result==Global.SUCCESS)
                {
                    $state.go('app.statistic');
                }else {
                    alert(response.data.errorInfo);
                }
            }, function(x) {
                $scope.authError = 'Server Error';
            });

    }
    //修改用户
    $scope.modifyUser = function () {

        console.log($("#sel_search_orderstatus").val());//回显的值

        $scope.param.editUserInfo.userLevel = [];

        angular.forEach($("#sel_search_orderstatus").val(),function (val,index) {
            $scope.param.editUserInfo.userLevel.push(val);
        })

        console.log($scope.param.editUserInfo);

        $http.post('/traffic/user/saveUserInfo', $scope.param.editUserInfo)
            .then(function(response) {
                if(response.data.result==Global.SUCCESS)
                {
                    $state.go('app.statistic');
                }else {
                    alert(response.data.errorInfo);
                }
            }, function(x) {
                $scope.authError = 'Server Error';
            });
    }



}]);










