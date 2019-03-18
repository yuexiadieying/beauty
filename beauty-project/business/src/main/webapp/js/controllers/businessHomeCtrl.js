angular.module('controllers',[]).controller('businessHomeCtrl',
    ['$scope','$rootScope','$stateParams','$state','GetHomeBannerList','GetOfflineProductList','$ionicSlideBoxDelegate','$ionicLoading','GetBusinessOrderByProductId','Global','$ionicPopup','LoginGlobal','BusinessUtil',
        function ($scope,$rootScope,$stateParams,$state,GetHomeBannerList,GetOfflineProductList,$ionicSlideBoxDelegate,$ionicLoading,GetBusinessOrderByProductId,Global,$ionicPopup,LoginGlobal,BusinessUtil) {
            $rootScope.title = "美享99触屏版";
            $scope.param = {
                bannerList:{},
                productList:{},
                product2List:[[]],
                promoteProduct:true,
                promoteProductId:"201712101718100007"
            }
            $scope.$on('$ionicView.enter', function(){

                $ionicLoading.show({
                    content: 'Loading',
                    animation: 'fade-in',
                    showBackdrop: true,
                    maxWidth: 200,
                    showDelay: 0
                });
                GetHomeBannerList.save(function(data){
                    $scope.param.bannerList = data.responseData;
                    $ionicSlideBoxDelegate.update();
                    $ionicSlideBoxDelegate.loop(true);
                });
                $scope.clickCarousel=function(item){
                    BusinessUtil.twoParameters(LoginGlobal.MX_SC_BADJ,item);
                }
                $scope.enterDetails=function(item2){
                    BusinessUtil.twoParameters(LoginGlobal.MX_SC_ADJ,item2);
                    $state.go("offlineProductDetail",{productId:item2})
                }
                GetOfflineProductList.save({pageNo:0,pageSize:100},function(data){
                    $ionicLoading.hide();
                    $scope.param.productList = data.responseData;
                    console.log(data)

                    var partNames = [];
                    angular.forEach($scope.param.productList,function(value1,index1){
                        var same = false;
                        angular.forEach(partNames,function(value2,index){
                            if(value2==parseInt(value1.price)) {
                                same = true;
                            }
                        })
                        if(!same) {
                            partNames.push(parseInt(value1.price))
                        }
                    })
                    partNames.sort(function(a,b){return a-b});
                    var index=0;
                    angular.forEach(partNames,function (value1,index1) {
                        $scope.param.product2List[index] = {
                            name:value1,
                            data:[]
                        };
                        angular.forEach($scope.param.productList,function(value2,index2){
                            if(value1==parseInt(value2.price)) {
                                $scope.param.product2List[index].data.push(value2);
                            }
                        })
                        index++;
                    })

                    // console.log($scope.param.product2List);
                })
                //判断用户是否购买过新人大礼包产品
                GetBusinessOrderByProductId.get({productId:$scope.param.promoteProductId},function(data){
                    if(data.result==Global.SUCCESS)
                    {
                        console.log(Global.SUCCESS);
                        $scope.param.promoteProduct = true;
                    }
                    else if(data.result==Global.FAILURE)
                    {
                        console.log(Global.FAILURE);
                        $scope.param.promoteProduct = false;
                    }
                })

            });
            $scope.goPromoteProduct = function(item){
                BusinessUtil.twoParameters(LoginGlobal.MX_SC_ADJ,item);
                if($scope.param.promoteProduct)
                {
                    var alertPopup = $ionicPopup.alert({
                        template: '<span style="font-size: 0.3rem;color: #333333;margin-left: 0.2rem">你已经购买过促销产品，不能再次购买</span>',
                        okText:'确定'
                    });
                    // alert("你已经购买过促销产品，不能再次购买")
                }
                else
                {
                    $state.go("offlineProductDetail",{productId:$scope.param.promoteProductId});
                }
            }

        }])
