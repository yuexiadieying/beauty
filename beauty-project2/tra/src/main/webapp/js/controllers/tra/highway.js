'use highway';

/* Controllers */

app.controller('HighwayCtrl', ['$scope','traUtil','$rootScope', function($scope,traUtil,$rootScope) {

    $rootScope.goThirdPlatformName = '公路交通第三方平台';
    traUtil.getUserInfo();


}]);

