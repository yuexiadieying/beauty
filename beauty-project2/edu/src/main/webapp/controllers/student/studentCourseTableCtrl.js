angular.module('controllers',[]).controller('studentCourseTableCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce',
        'StudentCourseTableList','StudentCourseTableBaseInfo','Global', 'staticGlobal',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce,
                  StudentCourseTableList,StudentCourseTableBaseInfo,Global, staticGlobal) {

            $rootScope.title = "课程表";

            $scope.param = {
                courseBaseInfo:{},
                courseList : [],
                weekList : [],
                weekIndex: 0
            }

            $scope.studentChooseWeek = false;

            var courseTable = function (index) {
                StudentCourseTableList.get({weekIndex:index},function (data) {
                    EducationUtil.checkResponseData(data,'studentCourseTable');
                    console.log("data2", data);
                    if(data.result === Global.SUCCESS) {
                        if(data.responseData !== undefined){
                            $scope.param.courseBaseInfo.className = data.responseData.semester.className;
                            $scope.param.courseBaseInfo.semester = data.responseData.semester.semester;
                            $scope.param.weekIndex = data.responseData.semester.weekIndex;
                            $scope.param.tempWeekIndex = data.responseData.semester.weekIndex;
                            $scope.param.courseList = data.responseData.studentCourseDTOList;
                        }
                    }
                    else{
                        EducationUtil.showToast(staticGlobal.error);
                    }
                })
            }

            courseTable(0);

            //选择具体第几周课表
            $scope.confirmWeek = function (index) {
                $scope.studentChooseWeek = false;
                $scope.param.weekIndex = index;
                $scope.param.tempWeekIndex = index;
                courseTable(index);
            }

            //查看课程
            $scope.chooseCourse = function (time, courseStatus, classCourseId) {
                if(courseStatus[0].yellowFlag){
                    $state.go("courseMission", {classCourseId : classCourseId, time : time});
                }
                else if(courseStatus[1].redFlag){
                    $state.go("courseMission", {classCourseId : classCourseId, time : time});
                }
                else if(courseStatus[2].greenFlag){
                    $state.go("courseMission", {classCourseId : classCourseId, time : time});
                }
                else{
                    $state.go("courseDetail", {classCourseId : classCourseId, time : time});
                }
            }

            var getWeekList = function (weekIndex) {
                $scope.param.weekList = [];
                for(var i = 0; i< 4; i++)
                {
                    $scope.param.weekList.push(weekIndex + i);
                }
            }

            //显示之前周
            $scope.preWeek = function () {
                $scope.param.tempWeekIndex--;
                if(($scope.param.weekIndex-1)>0)
                {
                    getWeekList($scope.param.tempWeekIndex);
                }
            }

            //显示之后的周
            $scope.nextWeek = function () {
                $scope.param.tempWeekIndex++;
                getWeekList($scope.param.tempWeekIndex);
            }

            $scope.chooseWeek = function () {
                getWeekList($scope.param.tempWeekIndex);
                if($scope.studentChooseWeek){
                    $scope.studentChooseWeek = false;
                }
                else{
                    $scope.studentChooseWeek = true;
                }
            }

        
}]);
