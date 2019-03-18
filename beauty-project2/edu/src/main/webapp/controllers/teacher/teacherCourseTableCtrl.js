angular.module('controllers',[]).controller('teacherCourseTableCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce',
        'TeacherCourseTableList','Global','TeacherCourseTableBaseInfo','TeacherClassList',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce,
                  TeacherCourseTableList,Global,TeacherCourseTableBaseInfo,TeacherClassList) {

        $rootScope.title = "课程详情";

        console.log($rootScope.schoolId);

        $scope.param = {
            weekIndex:3,
            tempWeekIndex : 0,
            class:'全部班级',
            semester:'第一学期',
            month:6,
            classId:'all',
            chooseCourse:{},
            courseTableList:[
                // {
                //     weekName:'周一',
                //     weekDate:'23日',
                //     courseList:[
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二1班',
                //             classId:'12341',
                //             coursePlace:1
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二2班',
                //             classId:'12342',
                //             coursePlace:3
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二3班',
                //             classId:'12343',
                //             coursePlace:4
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二4班',
                //             classId:'12344',
                //             coursePlace:6
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二4班',
                //             classId:'12344',
                //             coursePlace:7
                //         }
                //     ]
                // },
                // {
                //     weekName:'周二',
                //     weekDate:'24日',
                //     courseList:[
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二1班',
                //             classId:'12341',
                //             coursePlace:3
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二2班',
                //             classId:'12342',
                //             coursePlace:4
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二3班',
                //             classId:'12343',
                //             coursePlace:5
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二4班',
                //             classId:'12344',
                //             coursePlace:7
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二4班',
                //             classId:'12344',
                //             coursePlace:8
                //         }
                //     ]
                // },
                // {
                //     weekName:'周三',
                //     weekDate:'25日',
                //     courseList:[
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二1班',
                //             classId:'12341',
                //             coursePlace:3
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二2班',
                //             classId:'12342',
                //             coursePlace:4
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二3班',
                //             classId:'12343',
                //             coursePlace:5
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二4班',
                //             classId:'12344',
                //             coursePlace:6
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二4班',
                //             classId:'12344',
                //             coursePlace:7
                //         }
                //     ]
                // },
                // {
                //     weekName:'周四',
                //     weekDate:'26日',
                //     courseList:[
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二1班',
                //             classId:'12341',
                //             coursePlace:2
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二2班',
                //             classId:'12342',
                //             coursePlace:4
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二3班',
                //             classId:'12343',
                //             coursePlace:5
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二4班',
                //             classId:'12344',
                //             coursePlace:6
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二4班',
                //             classId:'12344',
                //             coursePlace:7
                //         }
                //     ]
                // },
                // {
                //     weekName:'周五',
                //     weekDate:'27日',
                //     courseList:[
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二1班',
                //             classId:'12341',
                //             coursePlace:3
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二2班',
                //             classId:'12342',
                //             coursePlace:4
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二3班',
                //             classId:'12343',
                //             coursePlace:5
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二4班',
                //             classId:'12344',
                //             coursePlace:6
                //         },
                //         {
                //             courseId:'432424',
                //             courseName:'语文',
                //             courseClass:'初二4班',
                //             classId:'12344',
                //             coursePlace:7
                //         }
                //     ]
                // },
                // {
                //     weekName:'周六',
                //     weekDate:'28日',
                //     courseList:[
                //     ]
                // },
                // {
                //     weekName:'周日',
                //     weekDate:'29日',
                //     courseList:[
                //     ]
                // }
            ],
            classList:[
                // {
                //     classId:'12341',
                //     className:'初二1班'
                // },
                // {
                //     classId:'12342',
                //     className:'初二2班'
                // },
                // {
                //     classId:'12343',
                //     className:'初二3班'
                // },
                // {
                //     classId:'12344',
                //     className:'初二4班'
                // }
            ],
            weekList : []
        }

        var getWeekList = function (weekIndex) {
            $scope.param.weekList = [];
            for(var i = 0; i< 4; i++)
            {
                $scope.param.weekList.push(weekIndex + i);
            }
            console.log($scope.param.weekList);
        }

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
                        console.log(data.responseData);
                        $scope.param.courseTableList = data.responseData;
                        $scope.param.month = $scope.param.courseTableList[0].weekMonth;
                    }
                })
            }
        })

        TeacherClassList.get({},function (data) {
            EducationUtil.checkResponseData(data,"teacherCourseTable");
            if(data.result=Global.SUCCESS)
            {
                console.log(data.responseData)
                $scope.param.classList = data.responseData;
            }
        })

        $scope.studentChooseWeek = false;
        $scope.chooseCourseFlag = false;
        $scope.teacherChooseClass = false;
        $scope.missionTable = false;

        $scope.preWeek = function () {
            $scope.param.tempWeekIndex--;
            if(($scope.param.weekIndex-1)>0)
            {
                getWeekList($scope.param.tempWeekIndex);
            }
        }
        
        $scope.nextWeek = function () {
            $scope.param.tempWeekIndex++;
            getWeekList($scope.param.tempWeekIndex);
        }
        
        $scope.commitMission = function () {
            $state.go("commitMission")
        }
        
        $scope.chooseWeek = function () {
            getWeekList($scope.param.tempWeekIndex);
            $scope.studentChooseWeek = true;
        }

        $scope.confirmWeek = function (index) {
            console.log(index);
            $scope.studentChooseWeek = false;
            $scope.param.weekIndex = index;
            $scope.param.tempWeekIndex = index;
            TeacherCourseTableList.get({weekIndex:$scope.param.weekIndex},function (data) {
                EducationUtil.checkResponseData(data,"teacherCourseTable");
                if(data.result=Global.SUCCESS)
                {
                    console.log(data.responseData);
                    $scope.param.courseTableList = data.responseData;
                    $scope.param.month = $scope.param.courseTableList[0].weekMonth;
                }
            })
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
                $scope.param.class = className;
            }
            $scope.teacherChooseClass = false;
            console.log($scope.param.classId);
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
