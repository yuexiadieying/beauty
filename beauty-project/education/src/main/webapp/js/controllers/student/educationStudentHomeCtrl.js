angular.module('controllers',[]).controller('educationStudentHomeCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil', 'staticGlobal',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil, staticGlobal ) {

            $rootScope.title = "育湖系统";

            $scope.showMoreCourseFlag = true; //展开更多课程
            $scope.courseList = [0,1,2];

            if(!EducationUtil.getLoginState()){
                $scope.noLoginFlag = true;
            }else{
                $scope.noLoginFlag = false;
            }

            $scope.$on('$ionicView.enter', function(){
            });

            //更多
            $scope.moreInfo = function () {
                getLoginState("educationMoreInfo");
            }

            //查看课程任务
            $scope.goCourseMission = function () {
                $state.go("courseMission");
            }

            //点击展开更多课程
            $scope.showMoreCourse = function () {
                $scope.courseList = [0,1,2,3,4,5];
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
            $scope.goNewsDetail = function () {
                $state.go("schoolNewsDetail");
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
