angular.module('controllers',[]).controller('addressEditCtrl',
    ['$scope','$rootScope','$stateParams','$state','AddUserAddress','Global','DeleteUserAddress','GetUserAddressList','FindUserAddressById','BusinessUtil','UpdateUserAddress','$ionicPopup',
        function ($scope,$rootScope,$stateParams,$state,AddUserAddress,Global,DeleteUserAddress,GetUserAddressList,FindUserAddressById,BusinessUtil,UpdateUserAddress,$ionicPopup) {

            //手机号码格式验证
            // var phoneReg=/^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|5|6|7|8|9]|147|177)\d{8}$/;
            var phoneReg=/^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9]|147|177)\d{8}$/;
            $scope.$on('$ionicView.enter', function(){
                $scope.param = {
                    editType : $stateParams.type,
                    userAddressInfo :{
                        userName:"",
                        userPhone:"",
                        province:"",
                        city:"",
                        detailAddress:"",
                        status:false
                    }
                };

                if($scope.param.editType=='edit')
                {
                    //编辑
                    FindUserAddressById.get({addressId:$stateParams.addressId},function(data){
                        BusinessUtil.checkResponseData(data,"addressEdit&edit,"+$stateParams.addressId);
                        $scope.param.userAddressInfo = data.responseData;
                        if($scope.param.userAddressInfo.status=="1")
                        {
                            $scope.param.userAddressInfo.status = true;
                        }
                        else
                        {
                            $scope.param.userAddressInfo.status = false;
                        }
                        console.log($scope.param.userAddressInfo);
                    });
                }
            });

            $scope.saveAddress = function(){

                if(phoneReg.test($scope.param.userAddressInfo.userPhone))
                {
                    if($scope.param.userAddressInfo.userName==""||$scope.param.userAddressInfo.detailAddress=="")
                    {
                        var alertPopup = $ionicPopup.alert({
                            template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">请输入收件人姓名或收件人的详细地址</span>',
                            okText:'确定'
                        });
                    }
                    else
                    {
                        if($scope.param.editType=='edit')
                        {
                            if($scope.param.userAddressInfo.status)
                            {
                                $scope.param.userAddressInfo.status = "1";
                            }
                            else
                            {
                                $scope.param.userAddressInfo.status = "0";
                            }
                            UpdateUserAddress.save($scope.param.userAddressInfo, function(data) {
                                if(Global.SUCCESS==data.result)
                                {
                                    $state.go("addressManagement");
                                }
                            })
                        }
                        else if($scope.param.editType=='add')
                        {
                            if($scope.param.userAddressInfo.status)
                            {
                                $scope.param.userAddressInfo.status = "1";
                            }
                            else
                            {
                                $scope.param.userAddressInfo.status = "0";
                            }
                            AddUserAddress.save($scope.param.userAddressInfo, function(data) {
                                if(Global.SUCCESS==data.result)
                                {
                                    $state.go("addressManagement");
                                }
                            });

                        }
                    }
                }
                else
                {
                    var alertPopup = $ionicPopup.alert({
                        template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">手机号格式不正确，请重新输入</span>',
                        okText:'确定'
                    });
                }
            };

            //删除地址需要像后台传递ID进行操作
            $scope.deleteAddress=function () {
                DeleteUserAddress.get({addressId:$stateParams.addressId}, function(data){
                    BusinessUtil.checkResponseData(data,"addressEdit&edit,"+$stateParams.addressId);
                    if(data.result==Global.SUCCESS)
                    {
                        var alertPopup = $ionicPopup.alert({
                            template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">成功删除地址</span>',
                            okText:'确定'
                        });
                        $state.go("addressManagement",{routePath:$rootScope.routePath});
                    }else{
                        var alertPopup = $ionicPopup.alert({
                            template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">删除地址失败</span>',
                            okText:'确定'
                        });
                    }
                })
            };

        }]);