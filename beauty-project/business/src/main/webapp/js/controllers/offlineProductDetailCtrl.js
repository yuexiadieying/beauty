angular.module('controllers',[]).controller('offlineProductDetailCtrl',
    ['$scope','$rootScope','$stateParams','$state','GetOfflineProductDetail',
        'AddProduct2BuyCart','BusinessUtil','GetProductNumFromBuyCart','$ionicPopup',
        '$ionicSlideBoxDelegate','CreateBusinessOrder','PutNeedPayOrderListToRedis','Global','$ionicLoading',"$interval",'LoginGlobal',
        function ($scope,$rootScope,$stateParams,$state,GetOfflineProductDetail,
                  AddProduct2BuyCart,BusinessUtil,GetProductNumFromBuyCart,$ionicPopup,
                  $ionicSlideBoxDelegate,CreateBusinessOrder,PutNeedPayOrderListToRedis,Global,$ionicLoading,$interval,LoginGlobal) {

            $rootScope.title = "美享99产品详情";

            $scope.$on('$ionicView.enter', function(){

                $scope.param = {
                    product:{},
                    productSpec:"",
                    productUnPaidNum : "0",
                    currentIndex:0,
                    totalIndex:0
                };
                $ionicLoading.show({
                    content: 'Loading',
                    animation: 'fade-in',
                    showBackdrop: true,
                    maxWidth: 200,
                    showDelay: 0
                });
                GetOfflineProductDetail.get({productId:$stateParams.productId},function(data){
                    $ionicLoading.hide();
                    $scope.param.product = data.responseData;
                    // console.log($scope.param.product);
                    if($scope.param.product.productDetail.spec==undefined)
                    {
                        $scope.param.productSpec = "no";
                    }else if($scope.param.product.productDetail.spec.length==1){
                        $scope.param.productSpec=$scope.param.product.productDetail.spec[0];
                    }
                    $ionicSlideBoxDelegate.update();
                    $ionicSlideBoxDelegate.loop(true);
                    $interval(function(){
                        // console.log("currentIndex=" + $ionicSlideBoxDelegate.currentIndex());
                        // console.log("totalIndex=" + $ionicSlideBoxDelegate.slidesCount());
                        $scope.param.currentIndex =  $ionicSlideBoxDelegate.currentIndex()+1;
                        $scope.param.totalIndex =  $ionicSlideBoxDelegate.slidesCount()
                    },100);
                });

                GetProductNumFromBuyCart.get(function(data){
                    $scope.param.productUnPaidNum = data.responseData;
                });
            });

            $scope.confirmProductSpec = function(spec)
            {
                $scope.optionsPopup.close();
                $scope.param.productSpec = angular.copy(spec);
            }

            $scope.myObj = {
                background:"red",
                padding: "5px 20px",
            }
            // $scope.myPopup = {
            //     'isPopup':false
            // };
            $scope.chooseSpec = function($event){
                 if($scope.param.product.productDetail.spec.length==1){
                     return;
                 }
                $event.stopPropagation();
                // 自定义弹窗
                $scope.data = {};
                $scope.optionsPopup  = $ionicPopup.show({
                    template: '<div style="text-align: center;"><span ng-repeat="item in param.product.productDetail.spec"' +
                                'ng-click="confirmProductSpec(item)"  style="color:black;">' +
                                '<p style="display:inline;padding: 5px 20px;border: 1px solid #ff4a59;color: #ff4a59;height: 20px;" ng-if="param.productSpec==item">{{item}}</p>' +
                                '<p style="display:inline;padding:5px 20px;border: 1px solid #666666;height: 20px;" ng-if="param.productSpec!=item">{{item}}<p><br/></p></div>',
                    title: '请选择型号',
                    subTitle: '',
                    scope: $scope,
                });
                $scope.myPopup = {
                    'isPopup':true
                };
            };
           // 点击24小时发货显示说明
            $scope.explain=false;
            $scope.viewInstructions=function(){
                $scope.explain= true;
            }
            $scope.know=function(){
                $scope.explain=false;
            }
            $scope.addBuyCart = function(){
                BusinessUtil.twoParameters(LoginGlobal.MX_SC_AGW,$stateParams.productId);
                if($scope.param.productSpec=="")
                {
                    var alertPopup = $ionicPopup.alert({
                        template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">请选择产品的型号跟规格</span>',
                        okText:'确定'
                    });
                }else
                {
                    AddProduct2BuyCart.get({productId:$stateParams.productId,productSpec:$scope.param.productSpec},function(data){
                        BusinessUtil.checkResponseData(data,'offlineProductDetail&'+$stateParams.productId);
                        if(data.result==Global.FAILURE)
                        {
                            //alert("加入购物车失败")
                        }
                        else
                        {
                            GetProductNumFromBuyCart.get(function(data){
                                $scope.param.productUnPaidNum = data.responseData;
                            })
                        }
                    })
                }
            }

            $scope.goPay = function()
            {
                BusinessUtil.twoParameters(LoginGlobal.MX_SC_ACJ,$stateParams.productId);
                if($scope.param.productSpec=="")
                {
                    var alertPopup = $ionicPopup.alert({
                        template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">请选择产品的型号跟规格</span>',
                        okText:'确定'
                    });
                }
                else
                {
                    //先将此商品生成订单
                    CreateBusinessOrder.save({businessProductId:$scope.param.product.productId,productSpec:$scope.param.productSpec,type:'offline'},function (data) {
                        BusinessUtil.checkResponseData(data,'offlineProductDetail&'+$scope.param.product.productId);
                        console.log(data);
                        if(data.result==Global.FAILURE)
                        {
                            // var alertPopup = $ionicPopup.alert({
                            //     template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.5rem">直接购买失败</span>',
                            //     okText:'确定'
                            // });
                        }
                        else
                        {
                            //生成订单后再直接前往支付页面
                            var needPayOrderList = [];
                            var payOrder = {
                                orderId:data.responseData,
                                productFirstUrl:$scope.param.product.firstUrl,
                                productId:$scope.param.product.productId,
                                productName:$scope.param.product.productName,
                                productNum:1,
                                productPrice:$scope.param.product.price,
                                productSpec:$scope.param.productSpec
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

                    })

                }
            }
}])
//   .directive('closepopup', ['$ionicGesture',function($ionicGesture) {
//     return {
//         scope: false,//共享父scope
//         restrict: 'A',
//         replace: false,
//         link: function(scope, element, attrs, controller) {
//             //要在html上添加点击事件, 试了很久- -!
//             var  $htmlEl= angular.element(document.querySelector('html'));
//             $ionicGesture.on("touch", function(event) {
//                 if (event.target.nodeName === "HTML" && scope.myPopup.isPopup) {
//                     scope.optionsPopup.close();
//                     scope.myPopup.isPopup = false;
//                 }
//             },$htmlEl);
//         }
//     };
// }])