angular.module('controllers',[]).controller('accountSafetyCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading', '$ionicPopup',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading, $ionicPopup) {

            $rootScope.title = "账号与安全";
            $scope.data = {};
            var myPhonePopup;
            var myPwdPopup;

            var inputPhone = "<label class='item item-input'><span class='margin-right8'>+86</span><input type='number' placeholder='请输入手机号' ng-model='data.phone'/></label>";
            var sendCode = "<div class='item item-input-inset'><label class='item-input-wrapper'><input type='number' ng-model='data.code'></label><button class='button button-outline button-positive font-size14 min-height28'>点击获取</button></div>"

            var out = '<div class="list">' + inputPhone + sendCode +
                '</div>';


            $scope.showPhonePopup = function () {
                // 一个精心制作的自定义弹窗
                myPhonePopup = $ionicPopup.show({
                    template: out,
                    title: '手机号码',
                    /*subTitle: 'Please use normal things',*/
                    scope: $scope,
                    buttons: [
                        { text: '关闭' },
                        {
                            text: '确定',
                            type: 'button-positive',
                            onTap: function(e) {
                                if (!$scope.data.phone) {
                                    //不允许用户关闭，除非他键入wifi密码
                                    e.preventDefault();
                                } else {
                                    console.log("phone", $scope.data.phone);
                                    console.log("code", $scope.data.code);
                                    return $scope.data.phone + "," + $scope.data.code;
                                }
                            }
                        }
                    ]
                });

                myPhonePopup.then(function(res) {
                    console.log('Tapped!', res);
                });
            }

            $scope.showPwdPopup = function () {
                myPwdPopup = $ionicPopup.show({
                    template: '<div class="list"><label class="item item-input"><input type="password"  placeholder="请输入密码" ng-model="data.pwd"></label><label class="item item-input"><input type="password" placeholder="请在输入密码" ng-model="data.pwd2"></label></div>',
                    title: '修改密码',
                    /*subTitle: 'Please use normal things',*/
                    scope: $scope,
                    buttons: [
                        { text: '关闭' },
                        {
                            text: '确定',
                            type: 'button-positive',
                            onTap: function(e) {
                                if (!$scope.data.pwd) {
                                    //不允许用户关闭，除非他键入wifi密码
                                    e.preventDefault();
                                } else {
                                    console.log("phone", $scope.data.pwd);
                                    console.log("code", $scope.data.pwd2);
                                    return $scope.data.pwd + "," + $scope.data.pwd2;
                                }
                            }
                        }
                    ]
                });

                myPwdPopup.then(function(res) {
                    console.log('Tapped!', res);
                });
            }

        }]);
