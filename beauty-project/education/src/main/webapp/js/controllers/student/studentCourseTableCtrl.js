angular.module('controllers',[]).controller('studentCourseTableCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','$sce',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,$sce) {

        $rootScope.title = "课程详情";

        $scope.studentChooseWeek = false;
        $scope.chooseCourseFlag = false;

        $scope.courseList = [
            {"week": [
                {
                    "courseName": "英语",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "数学",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": true //课中正面点评-表扬、建议
                },
                {
                    "courseName": "英语",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "数学",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "英语",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                }

            ]},
            {"week": [
                {
                    "courseName": "历史",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "生物",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "数学",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "物理",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "地理",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                }

            ]},
            {"week": [
                {
                    "courseName": "语文",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "政治",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "语文",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "历史",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "语文",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                }

            ]},
            {"week": [
                {
                    "courseName": "数学",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "化学",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": true //课中正面点评-表扬、建议
                },
                {
                    "courseName": "物理",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": true //课中正面点评-表扬、建议
                },
                {
                    "courseName": "地理",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "化学",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": true //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                }

            ]},
            {"week": [
                {
                    "courseName": "英语",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "化学",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "英语",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                }

            ]},
            {"week": [
                {
                    "courseName": "物理",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "语文",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "生物",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                }

            ]},
            {"week": [
                {
                    "courseName": "体育",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "数学",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "政治",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                }

            ]},
            {"week": [
                {
                    "courseName": "美术",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "英语",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "数学",
                    "redFlag": true, //课中负面点评-批评
                    "yellowFlag": true, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                },
                {
                    "courseName": "",
                    "redFlag": false, //课中负面点评-批评
                    "yellowFlag": false, //有课程任务
                    "greenFlag": false //课中正面点评-表扬、建议
                }
            ]}
        ]

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
            console.log("test");
            history.go(-1);
        }
        
        $scope.chooseCourse = function (name, red, green, yellow) {
            //$scope.chooseCourseFlag = true;
            if(name === ""){
                return;
            }
            $state.go("courseMission");
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
        
}]);
