var system = 'system/';
var product = 'product/';
var transaction = 'transaction/';
var account = 'account/';
var weixin = 'weixin/';

define(['appBusiness'], function (app) {
    app

        //获取用户的参加在线课堂列表
        .factory('GetUserValidateCode',['$resource',function ($resource){
            return $resource(system + 'getUserValidateCode')
        }])
        //获取用户的推广二维码
        .factory('GetQRCodeURL',['$resource',function ($resource){
            return $resource(weixin + 'getUserQRCode')
        }])
        .factory('UserLogin',['$resource',function ($resource){
            return $resource(system + 'userLogin')
        }])
        //退出登录
        .factory('LoginOut',['$resource',function ($resource){
            return $resource(system + 'loginOut')
        }])
        .factory('GetHomeBannerList',['$resource',function ($resource){
            return $resource(system + 'getHomeBannerList')
        }])

        .factory('GetTrainingProductDetail',['$resource',function ($resource){
            return $resource(product + 'getTrainingProductDetail')
        }])
        .factory('GetBusinessProductInfo',['$resource',function ($resource){
            return $resource(product + 'getBusinessProductInfo')
        }])
        .factory('GetTrainingProductPlayNum',['$resource',function ($resource){
            return $resource(product + 'getTrainingProductPlayNum')
        }])
        .factory('GetOfflineProductList',['$resource',function ($resource){
            return $resource(product + 'getOfflineProductList')
        }])
        .factory('GetTrainingProductList',['$resource',function ($resource){
            return $resource(product + 'getTrainingProductList')
        }])
        .factory('GetOfflineProductDetail',['$resource',function ($resource){
            return $resource(product + 'getOfflineProductDetail')
        }])
        .factory('GetBusinessOrderByProductId',['$resource',function ($resource){
            return $resource(transaction + 'getBusinessOrderByProductId')
        }])
        .factory('AddTrainingProductPlayNum',['$resource',function ($resource){
            return $resource(product + 'AddTrainingProductPlayNum')
        }])
        // 点击查看是否购买视频
         .factory('GetTrainingBusinessOrder',['$resource',function ($resource){
             return $resource(transaction + 'getTrainingBusinessOrder')
         }])
        .factory('AddProduct2BuyCart',['$resource',function ($resource){
            return $resource(transaction + 'addProduct2BuyCart')
        }])
        .factory('MinusProduct2BuyCart',['$resource',function ($resource){
            return $resource(transaction + 'minusProduct2BuyCart')
        }])
        .factory('GetProductNumFromBuyCart',['$resource',function ($resource){
            return $resource(transaction + 'getProductNumFromBuyCart')
        }])
        .factory('GetBuyCartInfo',['$resource',function ($resource){
            return $resource(transaction + 'buyCart')
        }])
        .factory('DeleteOrderFromBuyCart',['$resource',function ($resource){
            return $resource(transaction + 'deleteOrderFromBuyCart')
        }])
        .factory('PutNeedPayOrderListToRedis',['$resource',function ($resource){
            return $resource(transaction + 'putNeedPayOrderListToRedis')
        }])
        .factory('GetUserAddressList',['$resource',function ($resource){
            return $resource(transaction + 'userAddressList')
        }])
        .factory('AddUserAddress',['$resource',function ($resource){
            return $resource(transaction + 'addUserAddress')
        }])
        .factory('UpdateUserAddress',['$resource',function ($resource){
            return $resource(transaction + 'updateUserAddress')
        }])
        .factory('DeleteUserAddress',['$resource',function ($resource){
            return $resource(transaction + 'deleteUserAddress')
        }])
        .factory('GetTransactionList',['$resource',function ($resource){
            return $resource(transaction + 'getTransactionList')
        }])
        .factory('GetUserTransactionDetail',['$resource',function ($resource){
            return $resource(transaction + 'getUserTransactionDetail')
        }])
        .factory('GetBusinessOrderList',['$resource',function ($resource){
            return $resource(transaction + 'businessOrderList')
        }])
        .factory('UpdateBusinessOrderStatus',['$resource',function ($resource){
            return $resource(transaction + 'updateBusinessOrderStatus')
        }])
        .factory('CreateBusinessOrder',['$resource',function ($resource){
            return $resource(transaction + 'createBusinessOrder')
        }])
        .factory('FindUserAddressById',['$resource',function ($resource){
            return $resource(transaction + 'findUserAddressById')
        }])
        .factory('GetUserAccountInfo',['$resource',function ($resource){
            return $resource(account + 'userAccountInfo')
        }])
        .factory('WithDrawMoneyFromAccount',['$resource',function ($resource){
            return $resource(account + 'withDrawMoneyFromAccount')
        }])
        .factory('GetUserInfo',['$resource',function ($resource){
            return $resource(system + 'getUserInfo')
        }])
        .factory('GetUserInfoByOpenId',['$resource',function ($resource){
            return $resource(system + 'getUserInfoByOpenId')
        }])
        .factory('SuggestionDetail',['$resource',function ($resource){
            return $resource(system + 'suggestionDetail')
        }])
        //发票
        .factory('AddInvoiceInfo',['$resource',function ($resource){
            return $resource( product+ 'addInvoiceInfo')
         }])
        .factory('GetAttentionTeacherStatus',['$resource',function ($resource){
            return $resource( transaction+ 'getAttentionTeacherStatus')
        }])
        .factory('AttentionTeacher',['$resource',function ($resource){
            return $resource( transaction+ 'attentionTeacher')
        }])
        .factory('BuriedPoint',['$resource',function ($resource){
            return $resource( "http://mx99test1.kpbeauty.com.cn:3000/dotLog");
        }])

});
