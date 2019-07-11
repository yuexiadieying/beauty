'use water_transportation';

/* Controllers */

app.controller('Water_transportationCtl', ['$scope','traUtil',function($scope,traUtil) {

    traUtil.getUserInfo();

}]);

