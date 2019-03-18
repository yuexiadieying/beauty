var common = 'management/';
var operation ='operation/';
var order ='order/';
var operate ='operate/';
var agency ='agency/';
var finance ='finance/';
var people ='people/';
var account = 'account/';
var system = 'system/';


define(['appManagement'], function (app) {
    app
        .factory('UserLogin',['$resource',function ($resource){
            return $resource(common + 'login');
        }])
        .factory('UserLoginOut',['$resource',function ($resource){
            return $resource(common + 'loginOut');
        }])
        /*首页*/
        .factory('QueryAllProducts',['$resource',function ($resource){
            return $resource(operation + 'queryAllProducts');
        }])
        /*首页*/
        /*按钮的切换与搜索*/
        .factory('QueryProductsByParameters',['$resource',function ($resource){
            return $resource(operation + 'queryProductsByParameters');
        }])
        /*更改状态 上架*/
        .factory('PutAwayProductById',['$resource',function ($resource){
            return $resource(operation + 'putAwayProductById');
        }])
        /*更改状态 下架*/
        .factory('DelProductById',['$resource',function ($resource){
            return $resource(operation + 'delProductById');
        }])
        /*编辑*/
        .factory('FindProductById',['$resource',function ($resource){
            return $resource(operation + 'findProductById');
        }])
        /*上传图片*/
        .factory('ImageUploadToOSS',['$resource',function ($resource){
            return $resource(operation + 'imageUploadToOSS');
        }])
        /*保存*/
        .factory('UpdateProductByParameters',['$resource',function ($resource){
            return $resource(operation + 'updateProductByParameters');
        }])
        /*上传商品*/
        .factory('AddOfflineProduct',['$resource',function ($resource){
        return $resource(operation + 'addOfflineProduct');
    }])
         /*财务管理——提现*/
        /*改变状态*/
        .factory('UpdateWithdrawById',['$resource',function ($resource){
            return $resource(finance + 'updateWithdrawById');
        }])
        /*获得所有*/
        .factory('GetAllWithdraw',['$resource',function ($resource){
            return $resource(finance + 'getAllWithdraw');
        }])
        /*按条件查询*/
        .factory('QueryWithdrawsByParameters',['$resource',function ($resource){
            return $resource(finance + 'queryWithdrawsByParameters');
        }])
/*财务管理——余额*/
        /*搜索*/
        .factory('QueryUserBalanceByParameters',['$resource',function ($resource){
            return $resource(finance + 'queryUserBalanceByParameters');
        }])
        /*获得所有*/
        .factory('QueryAllUserBalance',['$resource',function ($resource){
            return $resource(finance + 'queryAllUserBalance');
        }])
  /*月结*/
        /*按条件查询*/
        .factory('QueryUserIncomeByParameters',['$resource',function ($resource){
            return $resource(finance + 'queryUserIncomeByParameters');
        }])
        /*展示所有*/
        .factory('QueryAllUserIncome',['$resource',function ($resource){
            return $resource(finance + 'queryAllUserIncome');
        }])
        /*详情 月度结算*/
        .factory('QueryMonthTransactionRecordByIncomeRecord',['$resource',function ($resource){
            return $resource(finance + 'queryMonthTransactionRecordByIncomeRecord');
        }])
        .factory('QueryMonthPayRecordByUserId',['$resource',function ($resource){
            return $resource(finance + 'queryMonthPayRecordByUserId');
        }])
        /*详情 即时奖励*/
        .factory('QueryInstanceInfoByTransactionId',['$resource',function ($resource){
            return $resource(finance + 'queryInstanceInfoByTransactionId');
        }])
        /*审核*/
        .factory('UpdateIncomeRecordStatusById',['$resource',function ($resource){
            return $resource(finance + 'updateIncomeRecordStatusById');
        }])

 /*账单*/
        /*获得所有数据与按条件查询*/
        .factory('QueryPayRecordsByParameters',['$resource',function ($resource){
            return $resource(finance + 'queryPayRecordsByParameters');
        }])
        /*订单*/
        .factory('QueryUserInfoDTOByParameters',['$resource',function ($resource){
            return $resource(finance + 'queryUserInfoDTOByParameters');
        }])
        /*登录*/
        /*验证码*/
        .factory('GetUserValidateCode',['$resource',function ($resource){
            return $resource(finance + 'getUserValidateCode');
        }])
        /*人员管理*/
        /*账号列表*/
        .factory('QueryUserInfoDTOByParameters',['$resource',function ($resource){
            return $resource(finance + 'queryUserInfoDTOByParameters');
        }])
        /*运营管理*/
        .factory('QueryAllTrainingProductDTO',['$resource',function ($resource){
            return $resource(finance + 'queryAllTrainingProductDTO');
        }])
        /*订单页  查询与 全部 确认收货。。*/
        .factory('QueryBusinessOrderByParameters',['$resource',function ($resource){
            return $resource(finance + 'queryBusinessOrderByParameters');
        }])
        /*展示所有*/
        .factory('QueryAllBusinessOrders',['$resource',function ($resource){
            return $resource(finance + 'queryAllBusinessOrders');
        }])
        /*导出列表*/
        .factory('ExportExcelToOSS',['$resource',function ($resource){
            return $resource(operation + 'exportExcelToOSS');
        }])
    /*详情*/
        .factory('QueryOrderDetailsById',['$resource',function ($resource){
            return $resource(finance + 'queryOrderDetailsById');
        }])
    /*编辑地址*/

        .factory('UpdateOrderAddress',['$resource',function ($resource){
            return $resource(finance + 'updateOrderAddress');
        }])
        /*管理员登录*/
        .factory('ManagerLogin',['$resource',function ($resource){
            return $resource(system + 'managerLogin');
        }])
/*代理*/
     /*代理详情*/
        .factory('QueryUserBusinessById',['$resource',function ($resource){
            return $resource(finance + 'queryUserBusinessById');
        }])
    /*发展的*用户/*/
        .factory('QueryNextUserById',['$resource',function ($resource){
            return $resource(finance + 'queryNextUserById');
        }])
});
