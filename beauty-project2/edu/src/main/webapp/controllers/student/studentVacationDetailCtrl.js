angular.module('controllers',[]).controller('studentVacationDetailCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil', 'staticGlobal', 'Global', 'StudentApplyVacationDetail',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil, staticGlobal, Global, StudentApplyVacationDetail) {

            $rootScope.title = "请假详情";

            $scope.vacatedFlag = false; //请假有结果
            $scope.agreeVacateFlag = true; //同意请假
            $scope.approveFlag = false; //审批中


            $scope.$on('$ionicView.enter', function(){
                if($stateParams.type === '0'){//申请中
                    $scope.vacatedFlag = false;
                    $scope.approveFlag = true;
                }
                else if ($stateParams.type === '1'){//同意
                    $scope.vacatedFlag = true;
                    $scope.approveFlag = false;
                    $scope.agreeVacateFlag = true;
                    $(".d-icon").attr("src", "images/agree.png");

                }
                else if ($stateParams.type === '2'){//拒绝
                    $scope.vacatedFlag = true;
                    $scope.agreeVacateFlag = false;
                    $(".d-icon").attr("src", "images/reject.png");
                }
                StudentApplyVacationDetail.get({vacationId: String($stateParams.vacateId)}, function (data) {
                    if(data.result === Global.SUCCESS){
                        $scope.details = data.responseData;
                    }
                    else {
                        EducationUtil.showToast(staticGlobal.error);
                    }

                })

            });


        }]);