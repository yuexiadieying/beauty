'use water_transportation';

/* Controllers */

app.controller('Water_transportationCtl', ['$scope','traUtil','$rootScope',function($scope,traUtil,$rootScope) {

    $rootScope.goThirdPlatformName = '水运AIS系统第三方平台';

    traUtil.getUserInfo();

}]);

