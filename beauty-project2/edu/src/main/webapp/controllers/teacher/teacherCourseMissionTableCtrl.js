angular.module('controllers',[]).controller('teacherCourseMissionTableCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        '$sce','EducationUtil','TeacherCourseTableBaseInfo','Global','TeacherCourseTableList',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,
                  $sce,EducationUtil,TeacherCourseTableBaseInfo,Global,TeacherCourseTableList) {

        $rootScope.title = "选择课程";

        $scope.param = {
            weekNum:3,
            class:'全部班级',
            semester:'第一学期',
            month:4,
            classId:'all',
            chooseCourse:{},
            courseTableList:[]
        }

        $scope.studentChooseWeek = false;
        $scope.chooseCourseFlag = false;
        $scope.teacherChooseClass = false;
        $scope.missionTable = false;

        TeacherCourseTableBaseInfo.get({},function (data) {
            EducationUtil.checkResponseData(data,"teacherCourseTable");
            if(data.result=Global.SUCCESS)
            {
                $scope.param.weekIndex = data.responseData.weekIndex;
                $scope.param.tempWeekIndex = data.responseData.weekIndex;
                $scope.param.class = "所有班级";
                $scope.param.semester = data.responseData.semester;
                TeacherCourseTableList.get({weekIndex:$scope.param.weekIndex},function (data) {
                    EducationUtil.checkResponseData(data,"teacherCourseTable");
                    if(data.result=Global.SUCCESS)
                    {
                        $scope.param.courseTableList = data.responseData;
                        angular.forEach($scope.param.courseTableList,function (val,key) {
                            angular.forEach($rootScope.prepareMissionList,function (val1,key1) {
                                if(val.weekName.indexOf(val1.weekIndex)!=-1)
                                {
                                    angular.forEach(val.courseList,function (val2,key2) {
                                        if(val1.coursePlace==val2.coursePlace)
                                        {
                                            val2.chooseFlag = true;
                                        }
                                    })
                                }
                            })
                        })
                    }
                })
            }
        })

        $scope.preWeek = function () {
            if($scope.param.weekNum>1)
            {
                $scope.param.weekNum--;
            }
        }
        
        $scope.nextWeek = function () {
            if($scope.param.weekNum<=20)
            {
                $scope.param.weekNum++;
            }
        }

        $scope.chooseWeek = function () {
            $scope.studentChooseWeek = true;
        }

        $scope.confirmWeek = function (index) {
            $scope.studentChooseWeek = false;
        }
        
        $scope.backHome = function () {
            history.go(-1);
        }
        
        $scope.chooseCourse = function (item,parent) {
            $scope.chooseCourseFlag = true;
            $scope.param.chooseCourse = item;
            var weekName = parent.item1.weekName;
            if($scope.param.chooseCourse.chooseFlag&&$rootScope.prepareMissionList.length>1)
            {
                $scope.param.chooseCourse.chooseFlag = false;
                var missionList = [];
                angular.forEach($rootScope.prepareMissionList,function (val,index) {
                    if(!(val.coursePlace==item.coursePlace&&weekName.indexOf(val.weekIndex)!=-1))
                    {
                        missionList.push(val);
                    }
                })
                $rootScope.prepareMissionList = missionList;
            }
            else
            {
                $scope.param.chooseCourse.chooseFlag = true;
                var missionList = angular.copy($rootScope.prepareMissionList);
                var repeatFlag = true;
                angular.forEach($rootScope.prepareMissionList,function (val,index) {
                    if((val.coursePlace!=item.coursePlace||weekName.indexOf(val.weekIndex)==-1)&&repeatFlag)
                    {
                        item.weekIndex = weekName.replace("周","");
                        missionList.push(item);
                        repeatFlag = false;
                    }
                })
                $rootScope.prepareMissionList = missionList;
            }
            $scope.missionTable = true;
        }

        $scope.goTeacherPushMission = function () {
            $state.go("teacherPushMission");
        }
}])
