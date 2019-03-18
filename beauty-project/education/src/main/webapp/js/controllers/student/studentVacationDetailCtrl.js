angular.module('controllers',[]).controller('studentVacationDetailCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil) {

            $rootScope.title = "请假详情";

            $scope.vacatedFlag = false; //请假有结果
            $scope.agreeVacateFlag = true; //同意请假
            $scope.approveFlag = false; //审批中


            $scope.$on('$ionicView.enter', function(){
                if($stateParams.vacateId === '0'){//申请中
                    $scope.vacatedFlag = false;
                    $scope.approveFlag = true;
                }
                else if ($stateParams.vacateId === '1'){//同意
                    $scope.vacatedFlag = true;
                    $scope.approveFlag = false;
                    $scope.agreeVacateFlag = true;
                    $(".d-icon").attr("src", "images/agree.png");

                }
                else if ($stateParams.vacateId === '2'){//拒绝
                    $scope.vacatedFlag = true;
                    $scope.agreeVacateFlag = false;
                    $(".d-icon").attr("src", "images/reject.png");
                }
            });


        }]);