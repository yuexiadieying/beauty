'use throughput';

/* Controllers */

app
  .controller('ThroughputCtrl', ['$scope', '$http',"traUtil",'$http','$state','Global','$rootScope',
      function($scope,$http,traUtil,$http,$state,Global,$rootScope) {

          $rootScope.goThirdPlatformName = '湖南省港口企业与码头单位吞吐量报表第三方平台';

    $scope.mtdwttlHomeData = []

    traUtil.getUserInfo();

    $http.get('/traffic/hlsgkqyymtdwttlbb/ttlbb')
        .then(function(response) {
          if (response.data.result==Global.SUCCESS) {
              console.log(response.data);
            angular.forEach(response.data.responseData,function (val,index) {
              if(val!='')
              {
                $scope.mtdwttlHomeData.push(val);
              }
            })
          }
        });

  }]);