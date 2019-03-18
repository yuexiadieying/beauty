var robot = '/robot/';


define(['appRobot'], function (app) {
    app
        .factory('GameBegin',['$resource',function ($resource){
            return $resource(robot + 'gameBegin');
        }])
        .factory('GameStop',['$resource',function ($resource){
            return $resource(robot + 'gameStop');
        }])
        .factory('GetGoalNum',['$resource',function ($resource){
            return $resource(robot + 'getGoalNum');
        }])
        .factory('GetDizzyNum',['$resource',function ($resource){
            return $resource(robot + 'getDizzyNum');
        }])
        .factory('GetTotalAttackNum',['$resource',function ($resource){
            return $resource(robot + 'getTotalAttackNum');
        }])
        .factory('GetConnectDeviceParam',['$resource',function ($resource){
            return $resource(robot + 'getConnectDeviceParam');
        }])
});
