'use highway';

/* Controllers */

app.controller('HighwayCtrl', ['$scope','traUtil', function($scope,traUtil) {

    traUtil.getUserInfo();


}]);

