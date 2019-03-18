angular.module('controllers',[]).controller('educationStudentHomeCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil', 'staticGlobal','GetSchoolInfo','Global',
        'StudentShortMessage', 'StudentCourseMissionList', 'StudentMoralityList', 'StudentCourseTableBaseInfo','GetSchoolNewsList',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil, staticGlobal,GetSchoolInfo ,Global,
                  StudentShortMessage, StudentCourseMissionList, StudentMoralityList, StudentCourseTableBaseInfo,GetSchoolNewsList) {

            $rootScope.title = "好课堂";

            localStorage.removeItem("schoolId");
            localStorage.setItem("schoolId", $stateParams.schoolId);

            $scope.showMoreCourseFlag = true; //展开更多课程
            $scope.courseList = [0,1,2];

            $scope.param = {
                courseMissionLength:3,
                studentCourseMissionList:[],
                schoolNewsList:[]
            }

            GetSchoolNewsList.get({schoolId:localStorage.getItem('schoolId')},function(data){
                if(data.result === Global.SUCCESS)
                {
                    $scope.param.schoolNewsList = data.responseData;
                }
            })

            GetSchoolInfo.get({schoolId:$stateParams.schoolId},function (data) {
                EducationUtil.checkResponseData(data,"educationStudentHome&"+$stateParams.schoolId);
                console.log("data", data);
                if(data.result === Global.SUCCESS) {
                    if(data.responseData !== undefined){
                        $rootScope.title = data.responseData.schoolName;
                    }
                }
            })

            //学生获取自己最新的未读的通知消息
            StudentShortMessage.get(function (data) {
                console.log("Data", data);
                if(data.result === Global.SUCCESS){
                    if(data.responseData !== undefined){
                        $scope.noticeFlag = true;
                    }
                    else{
                        $scope.noticeFlag = false;
                    }
                }
                else{
                    EducationUtil.showToast(staticGlobal.error);
                }
            })

            //学生获取自己某天的所有课程任务
            var currTime = moment().format('YYYY-MM-DD');
            StudentCourseMissionList.get({courseDate : currTime}, function (data) {
                console.log("自己某天的所有课程任务", data);
                if(data.result === Global.SUCCESS){
                    if(data.responseData !== undefined){
                        $scope.showMoreCourseFlag = true;
                        $scope.param.studentCourseMissionList = data.responseData;
                    }
                    else{
                        $scope.showMoreCourseFlag = false;
                        $scope.param.studentCourseMissionList = [];
                    }
                }
                else{
                    EducationUtil.showToast(staticGlobal.error);
                }
            })

            //学生获取德育量化分数列表，按日期由近到远的排序
            StudentMoralityList.get(function (data) {
                console.log("德育量化", data);
            })


            //更多
            $scope.moreInfo = function () {
                getLoginState("educationMoreInfo");
            }

            //查看课程任务
            $scope.goCourseMission = function (index) {
                var id = $scope.param.studentCourseMissionList[index].classCourseId;
                var time = $scope.param.studentCourseMissionList[index].classTime;

                if($scope.param.studentCourseMissionList[index].homeWorkFlag === "1"){
                    $state.go("courseMission", {classCourseId : id, time : time});
                }
                else{
                    $state.go("courseDetail", {classCourseId : id, time : time});
                }

            }

            //点击展开更多课程
            $scope.showMoreCourse = function () {
                $scope.param.courseMissionLength = $scope.param.studentCourseMissionList.length;
                $scope.showMoreCourseFlag = false;
            }

            //课表
            $scope.goStudentCourseTable = function () {
                getLoginState("studentCourseTable");
            }

            //课表
            $scope.goCourseTable = function () {
                getLoginState("studentCourseTable");
            }

            //见闻
            $scope.goSchoolNews = function () {
                $state.go("schoolNewsList");
            }

            //校长信箱
            $scope.goSchoolMasterMail = function () {
                $state.go("schoolMasterMail");
            }

            //请假详情
            $scope.goVacationDetail = function () {
                $state.go("studentVacationDetail");
            }

            //去新闻详细
            $scope.goNewsDetail = function (newsId) {
                $state.go("schoolNewsDetail",{newsId:newsId});
            }

            //消息
            $scope.goStudentMessage = function () {
                getLoginState("educationStudentMessage");
            }

            //我的
            $scope.goStudentCenter = function () {
                getLoginState("educationStudentCenter");
            }

            var getLoginState = function (data) {
                if($scope.noLoginFlag){
                    $state.go("schoolChooseList");
                }else{
                    $state.go(data);
                }
            }
        }]);
