'use userList';

/* Controllers */

app.controller('UserListCtrl', ['$scope', '$http','Global','traUtil',function($scope,$http,Global,traUtil) {

    traUtil.getUserInfo();

    $scope.param = {
        data:[],
        dataList:[]
    }

    $http.get('/traffic/user/getAllUserList', {})
        .then(function(response) {
            if(response.data.result==Global.SUCCESS) {
                console.log(response.data.responseData);
                angular.forEach(response.data.responseData,function (val,index) {
                    var flag = false;
                    var dataIndex = 0;
                    angular.forEach($scope.param.dataList,function (val1,index1) {
                        if(val.department.id == val1.firstetterL)
                        {
                            flag = true;
                            dataIndex = index1;
                        }
                    })
                    if(flag)
                    {
                        $scope.param.dataList[dataIndex].userInfoList.push(angular.copy(val));
                    }else {
                        $scope.param.dataList.push({'firstetterL':angular.copy(val.department.departmentName),'userInfoList':[angular.copy(val)]})
                    }

                })
                console.log($scope.param.dataList);
            }else {
                alert(response.data.errorInfo);
            }
        }, function(x) {
            $scope.authError = 'Server Error';
        });

}]);










