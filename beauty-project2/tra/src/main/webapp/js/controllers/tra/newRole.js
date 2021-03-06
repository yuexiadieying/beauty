'use newUser';

/* Controllers */
/*id为空时 新建
* id非空 修改
* */
app.controller('NewRoleCtrl', ['$scope','$stateParams','$timeout',
    '$http','Global','$state','traUtil','$rootScope','$interval',function($scope,$stateParams,$timeout,
                                                 $http,Global,$state,traUtil,$rootScope,$interval) {

    traUtil.getUserInfo();

    $scope.roleId = $stateParams.roleId;

    $scope.param = {
        data:[
            {
                id:'sjtystjfxjc',
                name:'省交通运输统计分析监测与投资计划管理',
                selectFlag:false
            },
            {
                id:'sdlyssjxtgl',
                name:'省道路运输三级协同管理',
                selectFlag:false
            },
            {
                id:'gljt',
                name:'公路交通',
                selectFlag:false
            },
            {
                id:'sslyzgl',
                name:'省水路运政管理',
                selectFlag:false
            },
            {
                id:'zhgj',
                name:'智慧公交',
                selectFlag:false
            },
            {
                id:'hnsglsljsyysscxxfwxt',
                name:'湖南省公路水路建设与运输市场信息服务系统',
                selectFlag:false
            },
            {
                id:'hnsgkqyymtdwttlbb',
                name:'湖南省港口企业与码头单位吞吐量报表',
                selectFlag:false
            },
            {
                id:'syaisxt',
                name:'水运AIS系统',
                selectFlag:false
            },
            {
                id:'skylwspxt',
                name:'省客运联网售票系统',
                selectFlag:false
            },
        ],
        roleData:[],
        roleInfo:{roleName:'',levels:[]},
    };

    $http.get('/traffic/user/getAllRoleList', {})
        .then(function(response) {
            if(response.data.result==Global.SUCCESS) {
                $scope.param.roleData = response.data.responseData;
                if($scope.roleId!=undefined||$scope.roleId!=undefined!='')
                {
                    angular.forEach($scope.param.roleData,function (val,index) {
                        if(val.id==$scope.roleId)
                        {
                            $scope.arr = [];
                            angular.forEach(val.levels,function (val1,index1) {
                                var data = {id:'',name:''};
                                angular.forEach($scope.param.data,function (val2,index1) {
                                    if(val1 == val2.id)
                                    {
                                        data.id = angular.copy(val1);
                                        data.name = angular.copy(val2.name);
                                    }
                                })
                                $scope.arr.push(data);
                            })
                            //$scope.arr = [{id:'w4444',name:'省水路运政管理'},{id:'w11111',name:'省交通运输统计分析监测与投资计划管理'}];  //假设这是用户的权限
                            for(var i=0;i<$scope.param.data.length;i++){
                                for(var j=0;j<$scope.arr.length;j++){
                                    if($scope.param.data[i].id ==$scope.arr[j].id ){
                                        $scope.param.data[i].selectFlag = true
                                        break;
                                    }else{
                                        $scope.param.data[i].selectFlag = false;
                                    }
                                }
                            }

                            $scope.param.roleInfo.roleName = val.roleName;
                        }
                    })
                }
            }else {
                alert(response.data.errorInfo);
            }}, function(x) {
            $scope.authError = 'Server Error';
        });

    $timeout(function () {
        $('#sel_search_role').multiselect({
            includeSelectAllOption: true,
            nonSelectedText : '--请选择--',
            buttonWidth: '90%',
        });

        $('#sel_search_level').multiselect({
            includeSelectAllOption: true,
            nonSelectedText : '--请选择--',
            buttonWidth: '90%',
        });

        $('#sel_search_role').change(function(){
            $state.go("access.newRole",{roleId:$('#sel_search_role').val()})
        });

    },1000);

    //新建用户
    $scope.newRole = function () {
        angular.forEach($("#sel_search_level").val(),function (val,index) {
            $scope.param.roleInfo.levels.push(val);
        })

        $http.post('/traffic/user/saveRole', $scope.param.roleInfo)
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










