angular.module('controllers',[]).controller('teacherCourseTableCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce) {

        $rootScope.title = "课程详情";

        $scope.param = {
            weekNum:3,
            class:'全部班级',
            semester:'第一学期',
            month:6,
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
        
        $scope.commitMission = function () {
            $state.go("commitMission")
        }
        
        $scope.chooseWeek = function () {
            $scope.studentChooseWeek = true;
        }

        $scope.confirmWeek = function (index) {
            console.log(index);
            $scope.studentChooseWeek = false;
        }
        
        $scope.backHome = function () {
            history.go(-1);
        }
        
        $scope.chooseCourse = function (item) {
            $scope.param.chooseCourse = item;
            $scope.param.chooseCourse.chooseFlag = true;
            $scope.missionTable = true;
        }
        
        $scope.closeCourse = function () {
            $scope.chooseCourseFlag = false;
        }
        
        $scope.commitMission = function () {
            $state.go("commitMission");
        }
        
        $scope.goCourseDetail = function () {
            $state.go("courseDetail");
        }
        
        $scope.chooseTeacherClass = function () {
            $scope.teacherChooseClass = true;
        }
        
        $scope.chooseClass = function (classId,className) {
            $scope.param.classId = classId;
            if(classId=='all')
            {
                $scope.param.class = '所有班级';
            }
            else
            {
                console.log(className);
                $scope.param.class = className;
            }
            $scope.teacherChooseClass = false;
        }

        $scope.cancel = function () {
            $scope.missionTable = false;
            angular.forEach($scope.param.courseTableList,function (val,index) {
                angular.forEach(val.courseList,function (val1,index1) {
                    if(val1.chooseFlag)
                    {
                        val1.chooseFlag=false;
                    }
                })
            })
            console.log($scope.param.courseTableList.courseList);
        }

        $scope.pushMission = function () {
            $state.go("teacherPushMission");
        }

        $scope.discussStudent = function () {
            $state.go("teacherDiscussStud");
        }

}])
