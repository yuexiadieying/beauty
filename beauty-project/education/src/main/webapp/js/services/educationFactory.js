var system = 'system/';
var product = 'product/';
var transaction = 'transaction/';
var account = 'account/';
var weixin = 'weixin/';

define(['appEducation'], function (app) {
    app

        //获取用户的参加在线课堂列表
        .factory('GetUserValidateCode',['$resource',function ($resource){
            return $resource(system + 'getUserValidateCode')
        }])
        //获取用户的推广二维码
        .factory('GetQRCodeURL',['$resource',function ($resource){
            return $resource(weixin + 'getUserQRCode')
        }])

});
