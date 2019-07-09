'use newUser';

/* Controllers */
/*id为空时 新建
* id非空 修改
* */
app.controller('NewUserCtrl', ['$scope','$stateParams','$timeout',
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
        roleData:[],
        departmentData:[],
    }

    console.log($scope.param.loginName);

    $http.get('/traffic/user/getAllRoleList', {})
        .then(function(response) {
            if(response.data.result==Global.SUCCESS) {
                $scope.param.roleData = response.data.responseData;

                $http.get('/traffic/user/getAllDepartmentList', {})
                    .then(function(response) {
                        if(response.data.result==Global.SUCCESS) {
                            $scope.param.departmentData = response.data.responseData;

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
                                            angular.forEach($scope.param.departmentData,function (val,index) {
                                                if(val.id==$scope.param.editUserInfo.department.id)
                                                {
                                                    val.selected = true;
                                                }else{
                                                    val.selected = false;
                                                }
                                            })

                                            angular.forEach($scope.param.roleData,function (val,index) {
                                                angular.forEach($scope.param.editUserInfo.roles,function (val1,index1) {
                                                    if(val.id==val1.id)
                                                    {
                                                        val.selected = true;
                                                    }
                                                })
                                                if(val.selected==undefined){
                                                    val.selected=false;
                                                }
                                            })

                                        }else {
                                            alert(response.data.errorInfo);
                                        }
                                    }, function(x) {
                                        $scope.authError = 'Server Error';
                                    });
                            }


                        }else {
                            alert(response.data.errorInfo);
                        }
                    }, function(x) {
                        $scope.authError = 'Server Error';
                    });

            }else {
                alert(response.data.errorInfo);
            }}, function(x) {
            $scope.authError = 'Server Error';
        });

    //新建用户
    $scope.newUser = function () {

        var department = {id:'',departmentName:''};
        department.id = $("#sel_search_department").val();
        $scope.param.editUserInfo.department = department;

        $scope.param.editUserInfo.roles = [];
        angular.forEach($("#sel_search_role").val(),function (val,index) {
            var roleData = {id:''}
            roleData.id = val;
            $scope.param.editUserInfo.roles.push(roleData);
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

    //修改用户
    $scope.modifyUser = function () {

        var department = {id:'',departmentName:''};
        department.id = $("#sel_search_department").val();
        $scope.param.editUserInfo.department = department;

        $scope.param.editUserInfo.roles = [];
        angular.forEach($("#sel_search_role").val(),function (val,index) {
            var roleData = {id:''}
            roleData.id = val;
            $scope.param.editUserInfo.roles.push(roleData);
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










