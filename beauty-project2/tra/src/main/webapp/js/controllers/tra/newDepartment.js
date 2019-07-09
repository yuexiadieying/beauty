'use newUser';

/* Controllers */
/*id为空时 新建
* id非空 修改
* */
app.controller('NewDepartmentCtrl', ['$scope','$stateParams','$timeout',
    '$http','Global','$state','traUtil','$rootScope',function($scope,$stateParams,$timeout,
                                                 $http,Global,$state,traUtil,$rootScope) {

    traUtil.getUserInfo();

    $scope.param={
        department:{id:'',departmentName:''},
        data:[]
    }

    $scope.select=[];

    $http.get('/traffic/user/getAllDepartmentList', {})
            .then(function(response) {
                if(response.data.result==Global.SUCCESS) {
                    $scope.param.data = response.data.responseData;
                }else {
                    alert(response.data.errorInfo);
                }
            }, function(x) {
                $scope.authError = 'Server Error';
            });


    $timeout(function () {
        $('#sel_search_orderstatus').multiselect({
            includeSelectAllOption: true,
            nonSelectedText : '--请选择--',
            buttonWidth: '90%',
        });
    },1000);


    $scope.newDepartment = function () {

        console.log($("#sel_search_orderstatus").val());//回显的值

        $scope.param.department.id = $("#sel_search_orderstatus").val();

        $http.post('/traffic/user/saveDepartment', $scope.param.department)
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










