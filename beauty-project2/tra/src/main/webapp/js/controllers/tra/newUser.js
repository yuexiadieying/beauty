'use newUser';

/* Controllers */
/*id为空时 新建
* id非空 修改
* */
app.controller('NewUserCtrl', ['$scope','$stateParams','$timeout',function($scope,$stateParams,$timeout) {

    $scope.param={
        id:$stateParams.id,
        data:[{
            id:'w11111',
            name:'省交通运输统计分析监测与投资计划管理'
        },
            {
                id:'w2222',
                name:'省道路运输三级协同管理'
            },

            {
                id:'w33333',
                name:'公路交通'
            },

            {
                id:'w4444',
                name:'省水路运政管理'
            },
            {
                id:'w5555',
                name:'智慧公交'
            },
            {
                id:'w66666',
                name:'湖南省公路水路建设与运输市场信息服务系统'
            },
            {
                id:'w77777',
                name:'湖南省港口企业与码头单位吞吐量报表'
            },
            {
                id:'w88888',
                name:'水运AIS系统'
            },
            {
                id:'w99999',
                name:'省客运联网售票系统'
            },
        ]
    }
    $scope.select=[]
    if($scope.param.id != ''){
        $scope.arr = [{id:'w4444',name:'省水路运政管理'},{id:'w11111',name:'省交通运输统计分析监测与投资计划管理'}];  //假设这是用户的权限
        for(var i=0;i<$scope.param.data.length;i++){
            for(var j=0;j<$scope.arr.length;j++){
                if($scope.param.data[i].id ==$scope.arr[j].id ){
                    $scope.select[i] = 'select'
                    console.log(i,'a');
                    break;
                }else{
                    $scope.select[i] = ''
                    console.log(i,'b');
                }
            }

        }
        console.log($scope.select);
    }
    $timeout(function () {
        $('#sel_search_orderstatus').multiselect({
            includeSelectAllOption: true,
            nonSelectedText : '--请选择--',
            buttonWidth: '90%',
        });
    });



    //新建用户
    $scope.newUser = function () {
        console.log($("#sel_search_orderstatus").val());//回显的值
    }
    //修改用户
    $scope.modifyUser = function () {
        console.log($("#sel_search_orderstatus").val());//回显的值

    }



}]);










