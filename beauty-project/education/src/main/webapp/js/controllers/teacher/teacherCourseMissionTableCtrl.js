angular.module('controllers',[]).controller('teacherCourseMissionTableCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce) {

        $rootScope.title = "选择课程";

        $scope.param = {
            weekNum:3,
            class:'全部班级',
            semester:'第一学期',
            month:4,
            classId:'all',
            chooseCourse:{},
            courseTableList:[
                {
                    weekName:'周一',
                    weekDate:'23日',
                    courseList:[
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二1班',
                            classId:'12341',
                            coursePlace:1
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二2班',
                            classId:'12342',
                            coursePlace:3
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二3班',
                            classId:'12343',
                            coursePlace:4
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二4班',
                            classId:'12344',
                            coursePlace:6
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二4班',
                            classId:'12344',
                            coursePlace:7
                        }
                    ]
                },
                {
                    weekName:'周二',
                    weekDate:'24日',
                    courseList:[
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二1班',
                            classId:'12341',
                            coursePlace:3
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二2班',
                            classId:'12342',
                            coursePlace:4
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二3班',
                            classId:'12343',
                            coursePlace:5
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二4班',
                            classId:'12344',
                            coursePlace:7
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二4班',
                            classId:'12344',
                            coursePlace:8
                        }
                    ]
                },
                {
                    weekName:'周三',
                    weekDate:'25日',
                    courseList:[
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二1班',
                            classId:'12341',
                            coursePlace:3
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二2班',
                            classId:'12342',
                            coursePlace:4
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二3班',
                            classId:'12343',
                            coursePlace:5
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二4班',
                            classId:'12344',
                            coursePlace:6
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二4班',
                            classId:'12344',
                            coursePlace:7
                        }
                    ]
                },
                {
                    weekName:'周四',
                    weekDate:'26日',
                    courseList:[
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二1班',
                            classId:'12341',
                            coursePlace:2
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二2班',
                            classId:'12342',
                            coursePlace:4
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二3班',
                            classId:'12343',
                            coursePlace:5
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二4班',
                            classId:'12344',
                            coursePlace:6
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二4班',
                            classId:'12344',
                            coursePlace:7
                        }
                    ]
                },
                {
                    weekName:'周五',
                    weekDate:'27日',
                    courseList:[
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二1班',
                            classId:'12341',
                            coursePlace:3
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二2班',
                            classId:'12342',
                            coursePlace:4
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二3班',
                            classId:'12343',
                            coursePlace:5
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二4班',
                            classId:'12344',
                            coursePlace:6
                        },
                        {
                            courseId:'432424',
                            courseName:'语文',
                            courseClass:'初二4班',
                            classId:'12344',
                            coursePlace:7
                        }
                    ]
                },
                {
                    weekName:'周六',
                    weekDate:'28日',
                    courseList:[
                    ]
                },
                {
                    weekName:'周日',
                    weekDate:'29日',
                    courseList:[
                    ]
                }
            ],
            classList:[
                {
                    classId:'12341',
                    className:'初二1班'
                },
                {
                    classId:'12342',
                    className:'初二2班'
                },
                {
                    classId:'12343',
                    className:'初二3班'
                },
                {
                    classId:'12344',
                    className:'初二4班'
                }
            ]
        }

        $scope.studentChooseWeek = false;
        $scope.chooseCourseFlag = false;
        $scope.teacherChooseClass = false;
        $scope.missionTable = false;

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
        
        $scope.chooseCourse = function (item) {
            $scope.chooseCourseFlag = true;
            $scope.param.chooseCourse = item;
            if($scope.param.chooseCourse.chooseFlag)
            {
                $scope.param.chooseCourse.chooseFlag = false;
            }
            else
            {
                $scope.param.chooseCourse.chooseFlag = true;
            }
            $scope.missionTable = true;
        }

        $scope.goTeacherPushMission = function () {
            $state.go("teacherPushMission");
        }
}])
