angular.module('controllers',[]).controller('operationClassParticularsCtrl',
    ['$scope','$interval','$rootScope','$stateParams','$state','Global','$timeout','ManagementUtil',
        function ($scope,$interval,$rootScope,$stateParams,$state,Global,$timeout,ManagementUtil) {
            $scope.hintPic1='';
            $scope.saveClass = function(){
                $state.go("operation")
            }
            var big = document.querySelector("#list_viewPic");
            var div = document.createElement('div');
            div.className="classUrl";
            div.innerHTML=  $stateParams.url;
            big.appendChild(div);
        }]);