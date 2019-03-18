angular.module('controllers',[]).controller('orderManagementCtrl',
    ['$scope','$rootScope','$stateParams','$state','GetBusinessOrderList','BusinessUtil','PutNeedPayOrderListToRedis','Global','DeleteOrderFromBuyCart','UpdateBusinessOrderStatus','$ionicPopup','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,GetBusinessOrderList,BusinessUtil,PutNeedPayOrderListToRedis,Global,DeleteOrderFromBuyCart,UpdateBusinessOrderStatus,$ionicPopup,$ionicLoading) {
            $scope.param = {
                orderList:[],
                orderType:""
            }
            $scope.chooseTab = function(type){
                $scope.param.orderList=[];
                $scope.param.orderType = type;
                GetBusinessOrderList.get({status:$scope.param.orderType},function(data){
                    $ionicLoading.hide();
                    BusinessUtil.checkResponseData(data,"orderManagement&"+$scope.param.orderType);
                    $scope.param.orderList = data.responseData;
                    if($scope.param.orderType==1&&$scope.param.orderList==undefined||$scope.param.orderType==0&&$scope.param.orderList==undefined||$scope.param.orderType==4&&$scope.param.orderList==undefined)
                    {
                     $(".pedingDelivery").show()
                    }else
                    {
                      $(".pedingDelivery").hide()
                    }
                })
            }

            $rootScope.title = "订单管理";

            $scope.goPay = function(item){
                var needPayOrderList = [];
                var payOrder = {
                    orderId:item.businessOrderId,
                    productFirstUrl:item.businessProductFirstUrl,
                    productId:item.businessProductId,
                    productName:item.businessProductName,
                    productNum:item.businessProductNum,
                    productPrice:item.businessProductPrice,
                    productSpec:item.productSpec
                }
                needPayOrderList.push(payOrder);
                //将needPayOrderList数据放入后台list中
                PutNeedPayOrderListToRedis.save({needPayOrderList:needPayOrderList},function(data){
                    if(data.result==Global.SUCCESS)
                    {
                        window.location.href = "orderPay.do?productType=offlineProduct&random="+Math.random();
                    }
                })
            }

            $scope.buyAgain = function(item){
                $state.go("offlineProductDetail",{productId:item.businessProductId})
            }

            $scope.reminding=function(){
                var alertPopup = $ionicPopup.alert({
                    template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.2rem">货品正在处理，请耐心等待哦~</span>',
                    okText:'确定'
                });
            }

            $scope.deleteOrder = function(item){
                var alertPopup = $ionicPopup.show({
                    template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">确定要删除订单了吗？</span>',
                    subTitle: '',
                    scope: $scope,
                    buttons: [
                        {
                            text: '否'
                        },
                        {
                            text: '是',
                            type: 'button-calm',
                            onTap: function() {
                                $scope.param.productSpec = "";
                                UpdateBusinessOrderStatus.save({businessOrderId:item.businessOrderId,status:'del'},function(data){
                                    if(data.result==Global.SUCCESS){
                                        GetBusinessOrderList.get({status:$scope.param.orderType},function(data){
                                            BusinessUtil.checkResponseData(data,"orderManagement&"+$scope.param.orderType);
                                            $scope.param.orderList = data.responseData;
                                            console.log(data.responseData)
                                        })
                                    }
                                })
                            }
                        }
                    ]
                });

            }

            $scope.confirmReceive = function(item){
                UpdateBusinessOrderStatus.save({businessOrderId:item.businessOrderId,status:'2'},function(data){
                    if(data.result==Global.SUCCESS){
                        GetBusinessOrderList.get({status:$scope.param.orderType},function(data){
                            BusinessUtil.checkResponseData(data,"orderManagement&"+$scope.param.orderType);
                            $scope.param.orderList = data.responseData;
                        })
                    }
                })
            }

            $scope.$on('$ionicView.enter', function(){
                $ionicLoading.show({
                    content: 'Loading',
                    animation: 'fade-in',
                    showBackdrop: true,
                    maxWidth: 200,
                    showDelay: 0
                });
                $scope.chooseTab($stateParams.type);
            })

}])