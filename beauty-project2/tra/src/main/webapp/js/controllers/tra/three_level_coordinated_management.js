'use three_level_coordinated_management';

/* Controllers */

app
  //Flot Chart controller
  .controller('Three_level_coordinated_managementCtrl', ['$scope', 'traUtil','$rootScope',function($scope,traUtil,$rootScope) {

    $rootScope.goThirdPlatformName = '省道路运输三级协同管理第三方平台';
    traUtil.getUserInfo();

  }]);