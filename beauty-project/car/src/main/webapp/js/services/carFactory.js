var car = '/car/';


define(['appCar'], function (app) {
    app
        .factory('GameBegin',['$resource',function ($resource){
            return $resource(car + 'gameBegin');
        }])
        .factory('GameStop',['$resource',function ($resource){
            return $resource(car + 'gameStop');
        }])
        .factory('GetGoalNum',['$resource',function ($resource){
            return $resource(car + 'getGoalNum');
        }])
        .factory('GetDizzyNum',['$resource',function ($resource){
            return $resource(car + 'getDizzyNum');
        }])
        .factory('GetTotalAttackNum',['$resource',function ($resource){
            return $resource(car + 'getTotalAttackNum');
        }])
        .factory('GetConnectDeviceParam',['$resource',function ($resource){
            return $resource(car + 'getConnectDeviceParam');
        }])
});
