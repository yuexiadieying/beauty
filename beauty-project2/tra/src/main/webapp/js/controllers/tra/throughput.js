'use throughput';

/* Controllers */

app
  .controller('ThroughputCtrl', ['$scope', '$http',"traUtil",'$http','$state','Global', function($scope,$http,traUtil,$http,$state,Global) {

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