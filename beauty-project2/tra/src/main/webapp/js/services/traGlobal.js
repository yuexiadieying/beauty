angular.module('traGlobal',[])
    .constant("Global",
        {
            SUCCESS : '0x00001',
            FAILURE : '0x00002',
            ONLINE : '0x00003',
            OFFLINE : '0x00004',
            LOGIN_OUT: '0x00005',
            TOKEN_ERROR: '0x00006',
            PARAM_ERROR: '0x00007',
            LOGIN_SUCCESS_SECOND : '0x00008',
        })
    .factory('traUtil', ['Global','$state','$http','$rootScope',
        function(Global,$state,$http,$rootScope) {
            return {
                checkResponseData: function(data) {
                    if(data.result==Global.FAILURE)
                    {
                        if(data.errorInfo==Global.TOKEN_ERROR){
                            $state.go("register");
                        }
                    }
                },
                getAddDate:function(date,days){
                    var d=new Date(date);
                    d.setDate(d.getDate()+days);
                    var month=d.getMonth()+1;
                    var day = d.getDate();
                    if(month<10){
                        month = "0"+month;
                    }
                    if(day<10){
                        day = "0"+day;
                    }
                    var val = d.getFullYear()+"-"+month+"-"+day;
                    return val;
                },
                getUserInfo:function(){
                    $http.get('/traffic/user/getUserInfo')
                        .then(function(response) {
                            if (response.data.result==Global.SUCCESS) {
                                $rootScope.userInfo = response.data.responseData;
                            }else{
                                $state.go('access.signin');
                            }
                        }, function(x) {
                            $scope.authError = 'Server Error';
                        });
                }
            };
        }]);
