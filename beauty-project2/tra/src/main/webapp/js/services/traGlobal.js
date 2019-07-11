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
                    var count = function(o){
                        var t = typeof o;

                        if(t == 'string'){
                            return o.length;

                        }else if(t == 'object'){

                            var n = 0;

                            for(var i in o){

                                n++;

                            }

                            return n;
                        }
                        return false;
                    };
                    $http.get('/traffic/user/getUserInfo')
                        .then(function(response) {
                            if (response.data.result==Global.SUCCESS) {

                                $http.get('/traffic/sso/encryptSSO')
                                    .then(function(response1) {
                                        console.log(response1.data);
                                        if (response1.data.result==Global.SUCCESS) {
                                            $rootScope.goThirdPlatformUrl = response1.data.responseData.platformURL
                                                +"?platformFlag="+response1.data.responseData.platformFlag+'&&'
                                                +'secretStr='+response1.data.responseData.platformEncrypt;
                                        }else{
                                            $rootScope.thirdPlatformError = response1.data.errorInfo;
                                        }

                                        $rootScope.userInfo = response.data.responseData;
                                        if(count($rootScope.userInfo.roles)==1)
                                        {
                                            if(count($rootScope.userInfo.roles[0].levels)==1)
                                            {
                                                $state.go('app.' + $rootScope.userInfo.roles[0].levels[0]);
                                            }
                                        }

                                    }, function(x) {
                                        $scope.authError = 'Server Error';
                                    });
                            }else{
                                $state.go('access.signin');
                            }
                        }, function(x) {
                            $scope.authError = 'Server Error';
                        });
                }
            };
        }]);
