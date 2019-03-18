angular.module('controllers',[]).controller('educationStudentMessageCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','GetStudentClassCircle','Global',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,GetStudentClassCircle,Global) {

        $rootScope.title = "班级圈";

        $scope.studentMessageType = 'all';

        $scope.pageParam = {
            pageNo:0,
            pageSize:5,
            requestData : 'all'
        }

        $scope.param = {
            studentMessageList : []
        }

        GetStudentClassCircle.save($scope.pageParam, function (data) {
            if(data.result === Global.SUCCESS) {
                console.log("ddd", data);
                $scope.param.studentMessageList = data.responseData;
            }
        })

        $scope.getMoreStudentMessage = function () {
            $scope.pageParam.pageSize = $scope.pageParam.pageSize + 5;
            GetStudentClassCircle.save($scope.pageParam, function (data) {
                if(data.result === Global.SUCCESS)
                {
                    $scope.param.studentMessageList = data.responseData;
                }
            })
        }

        $scope.selectStudentMessage = function (type) {
            $scope.studentMessageType = type;
            $scope.pageParam.requestData = type;
            GetStudentClassCircle.save($scope.pageParam,function (data) {
                if(data.result === Global.SUCCESS)
                {
                    console.log(data.responseData);
                    $scope.param.studentMessageList = data.responseData;
                }
            })


        }

        //课堂点评
        $scope.goCourseComment = function () {
            $state.go("courseMission");
        }

        //任务评价
        $scope.goMissionDetail = function (index) {
            var detail = $scope.param.studentMessageList[index];
            EducationUtil.saveMissionComment(detail);
            $state.go("missionDetail");
        }

        //请假详情页
        $scope.goVacateDetail = function (type, vacationId) {

            $state.go("studentVacationDetail", {type: type, vacateId : vacationId});

        }

        //重新提交任务
        $scope.subminMission = function () {
            $state.go("commitMission");
        }

        //提交任务
        $scope.goCourseDetail = function () {
            $state.go("courseDetail");
        }

        $scope.goStudentHome = function () {
            $state.go("educationStudentHome",{schoolId:localStorage.getItem('schoolId')});
        }

        $scope.goStudentCenter = function () {
            $state.go("educationStudentCenter");
        }


}])
