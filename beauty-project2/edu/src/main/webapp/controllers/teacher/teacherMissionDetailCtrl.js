angular.module('controllers',[]).controller('teacherMissionDetailCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading) {

        $rootScope.title = "课程详情";

        $scope.goTeacherCourseMissionList = function () {
            $state.go("teacherCourseMissionList")
        }

        $scope.param = {
            courseInfo : {
                courseId:'312313',
                courseName:'语文',
                classId:'42342',
                className:'初二3班',
                week:'11周',
                coursePlace:"第三节、第四节、第七节",
                courseMissionList:[
                    {
                        courseMissionId:'12323344',
                        courseName: '语文',
                        courseMissionContent:'背诵《雷电颂》',
                        courseMissionDescription:'需要背诵最后两段，并完成模拟卷',
                        courseMissionClass:'初二2班',
                        classId:'124124',
                        alreadySubmitNum : 47,
                        notSubmitNum:11,
                        courseMissionDate:'06月12日',
                        courseMissionCreateDate:"06月10日"
                    },
                    {
                        courseMissionId:'12323344',
                        courseName: '语文',
                        courseMissionContent:'围绕“器”写一篇作文',
                        courseMissionDescription:'字数不能少于500字，主题要明确',
                        courseMissionClass:'初二6班',
                        classId:'124124',
                        alreadySubmitNum : 13,
                        notSubmitNum:45,
                        courseMissionDate:'06月12日',
                        courseMissionCreateDate:"06月10日"
                    },
                    {
                        courseMissionId:'12323344',
                        courseName: '语文',
                        courseMissionContent:'背诵《背影》前三段',
                        courseMissionDescription:'需要背诵前三段，需要背诵清晰完整',
                        courseMissionClass:'初二4班',
                        classId:'124124',
                        alreadySubmitNum : 39,
                        notSubmitNum:19,
                        courseMissionDate:'06月12日',
                        courseMissionCreateDate:"06月10日"
                    }
                ]
            }
        }

}])
