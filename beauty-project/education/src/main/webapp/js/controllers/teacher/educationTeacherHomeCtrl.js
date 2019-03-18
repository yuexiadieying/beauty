angular.module('controllers',[]).controller('educationTeacherHomeCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading ) {

        $rootScope.title = "育湖系统";

        $scope.param = {
            missionTable:false,
            vacationApplyNum:3,
            maxCourseMissionListLength : 3,
            courseMissionList : [
                {
                    courseMissionId:'12323344',
                    courseName: '语文',
                    courseMissionContent:'背诵《雷电颂》最后两段。并完成模拟卷',
                    courseMissionClass:'初二2班',
                    classId:'124124',
                    alreadySubmitNum : 47,
                    notSubmitNum:11,
                    courseMissionDate:'06月12日'
                },
                {
                    courseMissionId:'12323344',
                    courseName: '语文',
                    courseMissionContent:'围绕“器”写一篇作文',
                    courseMissionClass:'初二6班',
                    classId:'124124',
                    alreadySubmitNum : 13,
                    notSubmitNum:45,
                    courseMissionDate:'06月12日'
                },
                {
                    courseMissionId:'12323344',
                    courseName: '语文',
                    courseMissionContent:'背诵《背影》前三段',
                    courseMissionClass:'初二4班',
                    classId:'124124',
                    alreadySubmitNum : 39,
                    notSubmitNum:19,
                    courseMissionDate:'06月12日'
                },
                {
                    courseMissionId:'12323344',
                    courseName: '语文',
                    courseMissionContent:'背诵《背影》前三段',
                    courseMissionClass:'初二2班',
                    classId:'124124',
                    alreadySubmitNum : 19,
                    notSubmitNum:35,
                    courseMissionDate:'06月12日'
                }
            ],
            maxCoursePrepareListLength:3,
            coursePrepareList:[
                {
                    courseId:'1232345',
                    courseName:'语文',
                    classId:'1232332',
                    className:'初二2班'
                },
                {
                    courseId:'1232345',
                    courseName:'语文',
                    classId:'1232332',
                    className:'初二6班'
                },
                {
                    courseId:'1232345',
                    courseName:'语文',
                    classId:'1232332',
                    className:'初二4班'
                }
            ],
            schoolMessageImportant:{
                newsId:'4324k2l4',
                newsTitle:'满分作文《写给2035年的你》',
                newsDate:'2018-04-18'
            },
            courseMission:{
                courseId:'',
                classId:''
            }
        }

        $scope.extendAllCourseMissionList = function () {
            $scope.param.maxCourseMissionListLength = $scope.param.courseMissionList.length;
        }
        
        $scope.extendAllCoursePrepareList = function () {
            $scope.param.maxCoursePrepareListLength = $scope.param.coursePrepareList.length;
        }
        
        $scope.goTeacherMissionList = function () {
            $state.go("teacherVacationList");
        }

        $scope.goCourseMission = function (courseId,classId) {
            $scope.param.courseMission = {
                courseId:courseId,
                classId:classId
            }
            $scope.param.missionTable = true;
        }

        $scope.goCourseMissionList = function (courseMissionId) {
            $state.go("teacherCourseMissionList");
        }

        $scope.cancel = function () {
            $scope.param.missionTable = false;
        }

        $scope.pushMission = function () {
            $state.go("teacherPushMission",{courseId:$scope.param.courseMission.courseId,classId:$scope.param.courseMission.classId});
        }
        
        $scope.discussStudent = function () {
            $state.go("teacherDiscussStud");
        }

        $scope.goTeacherCourseTable = function () {
            $state.go("teacherCourseTable");
        }

        $scope.goSchoolNews = function () {
            $state.go("schoolNewsList");
        }

        $scope.goSchoolMasterMail = function () {
            $state.go("schoolMasterMail");
        }

        $scope.goNewsDetail = function (newsId) {
            $state.go("schoolNewsDetail");
        }

        $scope.moreInfo = function () {
            $state.go("educationTeacherMoreInfo");
        }
        
        $scope.goTeacherMessage = function () {
            $state.go("educationTeacherMessage");
        }

        $scope.goTeacherCenter = function () {
            $state.go("educationTeacherCenter");
        }

}])
