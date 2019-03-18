/**
 * Created by Administrator on 2017/12/15.
 */
angular.module('controllers',[]).controller('invoiceCtrl',
    ['$scope','$rootScope','$stateParams','$state','Global','AddInvoiceInfo','$ionicPopup',
        function ($scope,$rootScope,$stateParams,$state,Global,AddInvoiceInfo,$ionicPopup) {

            $scope.param={
                companyName:"",
                taxpayerNumber:""
            };

            $scope.companys=false;
            $scope.company=function () {
                $scope.companys=true;
            };

            $scope.personal=function(){
                $scope.companys=false;
             };

            // 发票须知
            $scope.facePanel = false;
            $scope.showNote = function () {
                $scope.facePanel = true
            };

            $scope.know=function () {
                $scope.facePanel=false
            };

            //开发票
            $scope.sureInvoice=function(){
                var value=$(":input[name='names']:checked").val();
                if(value=="1"){
                    if($scope.param.companyName==""||$scope.param.taxpayerNumber==""){
                        var alertPopup = $ionicPopup.alert({
                            template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">请填写正确的公司名称及纳税号</span>',
                            okText:'确定'
                        });
                        return;
                    }
                }else if(value=="0"){
                    $scope.param.companyName="";
                    $scope.param.taxpayerNumber="";
                }
               AddInvoiceInfo.save({taxType:value,companyName:$scope.param.companyName,taxpayerNumber:$scope.param.taxpayerNumber,orderId:$stateParams.orderId},function(data) {
                 if(data.result==Global.SUCCESS){
                  window.location.href = "orderPay.do?productType=offlineProduct&random="+Math.random()+"a";
                }
               })
            }

}]);
