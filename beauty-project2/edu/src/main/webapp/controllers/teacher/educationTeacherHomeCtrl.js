angular.module('controllers',[]).controller('educationTeacherHomeCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','GetSchoolInfo',
        'Global','TeacherMissionList','TeacherCoursePrepareList','GetTeacherVacationApplyList','GetSchoolNewsList',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,GetSchoolInfo,
                  Global,TeacherMissionList,TeacherCoursePrepareList,GetTeacherVacationApplyList,GetSchoolNewsList) {

        $rootScope.title = "育湖系统";

        localStorage.removeItem("schoolId");
        localStorage.setItem("schoolId", $stateParams.schoolId);
        $rootScope.prepareMissionList = [];

        $scope.param = {
            missionTable:false,
            vacationApplyNum:0,
            maxCourseMissionListLength : 3,
            courseMissionList : [],
            maxCoursePrepareListLength:3,
            coursePrepareList:[
            ],
            schoolNewsList:[],
            courseMission:{
                courseId:'',
                classId:''
            }
        }

        GetSchoolNewsList.get({schoolId:localStorage.getItem('schoolId')},function(data){
            if(data.result==Global.SUCCESS)
            {
                $scope.param.schoolNewsList = data.responseData;
            }
        })

        GetTeacherVacationApplyList.get({vacationStatus:"0"},function (data) {
            EducationUtil.checkResponseData(data,"educationTeacherHome&"+$rootScope.schoolId);
            if(data.result == Global.SUCCESS)
            {
                if(data.responseData!=undefined)
                {
                    $scope.param.vacationApplyNum = data.responseData.length;
                }
            }
        })

        GetSchoolInfo.get({schoolId:localStorage.getItem("schoolId")},function (data) {
            EducationUtil.checkResponseData(data,"educationTeacherHome&"+$rootScope.schoolId);
            if(data.result == Global.SUCCESS)
            {
                $rootScope.title = data.responseData.schoolName;
            }
        })

        TeacherMissionList.get({},function (data) {
            EducationUtil.checkResponseData(data,"educationTeacherHome&"+$rootScope.schoolId);
            if(data.result == Global.SUCCESS)
            {
                console.log(data.responseData);
                $scope.param.courseMissionList = data.responseData;
            }
        })
            
        TeacherCoursePrepareList.get({},function (data) {
            EducationUtil.checkResponseData(data,"educationTeacherHome&"+$rootScope.schoolId);
            if(data.result == Global.SUCCESS)
            {
                $scope.param.coursePrepareList = data.responseData;
            }
        })

        $scope.extendAllCourseMissionList = function () {
            $scope.param.maxCourseMissionListLength = $scope.param.courseMissionList.length;
        }
        
        $scope.extendAllCoursePrepareList = function () {
            $scope.param.maxCoursePrepareListLength = $scope.param.coursePrepareList.length;
        }
        
        $scope.goTeacherMissionList = function () {
            $state.go("teacherVacationList");
        }

        $scope.goCourseMission = function (item) {
            $rootScope.prepareMissionList.push(item);
            $scope.param.missionTable = true;
        }

        $scope.goCourseMissionList = function (courseMissionId) {
            $state.go("teacherCourseMissionList",{courseMissionId:courseMissionId});
        }

        $scope.cancel = function () {
            $rootScope.prepareMissionList = [];
            $scope.param.missionTable = false;
        }

        $scope.pushMission = function () {
            $state.go("teacherPushMission");
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
            $state.go("schoolNewsDetail",{newsId:newsId});
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
