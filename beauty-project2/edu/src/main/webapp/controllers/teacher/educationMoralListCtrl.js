angular.module('controllers',[]).controller('educationMoralListCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading) {

        $rootScope.title = "我的班级";

        $scope.info  = {
            showClass:true,
            classList:[
                {
                    "schoolId":"123456",
                    "schoolName":"育湖中学",
                    "classId":"13475",
                    "className":"初三2班",
                    "studentList":[
                        {
                            studentId : '232234',
                            studentName : '李正凯',
                        },
                        {
                            studentId : '232234',
                            studentName : '刘涛',
                        },
                        {
                            studentId : '232234',
                            studentName : '王明明',
                        },
                        {
                            studentId : '232234',
                            studentName : '王品衡',
                        },
                        {
                            studentId : '232234',
                            studentName : '李勇',
                        },
                        {
                            studentId : '232234',
                            studentName : '邓凯哲',
                        },
                        {
                            studentId : '232234',
                            studentName : '徐江',
                        },
                        {
                            studentId : '232234',
                            studentName : '李贺新',
                        },
                        {
                            studentId : '232234',
                            studentName : '刘昊',
                        },
                        {
                            studentId : '232234',
                            studentName : '周强',
                        }
                    ]
                },
                {
                    "schoolId":"123456",
                    "schoolName":"育湖中学",
                    "classId":"27456",
                    "className":"初三5班",
                    "studentList":[
                        {
                            studentId : '232234',
                            studentName : '李正凯',
                        },
                        {
                            studentId : '232234',
                            studentName : '刘涛',
                        },
                        {
                            studentId : '232234',
                            studentName : '王明明',
                        },
                        {
                            studentId : '232234',
                            studentName : '王品衡',
                        },
                        {
                            studentId : '232234',
                            studentName : '李勇',
                        },
                        {
                            studentId : '232234',
                            studentName : '邓凯哲',
                        },
                        {
                            studentId : '232234',
                            studentName : '徐江',
                        },
                        {
                            studentId : '232234',
                            studentName : '李贺新',
                        },
                        {
                            studentId : '232234',
                            studentName : '刘昊',
                        },
                        {
                            studentId : '232234',
                            studentName : '周强',
                        }
                    ]
                },
                {
                    "schoolId":"123456",
                    "schoolName":"育湖中学",
                    "classId":"27459",
                    "className":"初三7班",
                    "studentList":[
                        {
                            studentId : '232234',
                            studentName : '李正凯',
                        },
                        {
                            studentId : '232234',
                            studentName : '刘涛',
                        },
                        {
                            studentId : '232234',
                            studentName : '王明明',
                        },
                        {
                            studentId : '232234',
                            studentName : '王品衡',
                        },
                        {
                            studentId : '232234',
                            studentName : '李勇',
                        },
                        {
                            studentId : '232234',
                            studentName : '邓凯哲',
                        },
                        {
                            studentId : '232234',
                            studentName : '徐江',
                        },
                        {
                            studentId : '232234',
                            studentName : '李贺新',
                        },
                        {
                            studentId : '232234',
                            studentName : '刘昊',
                        },
                        {
                            studentId : '232234',
                            studentName : '周强',
                        }
                    ]
                }
            ],
            studentList : [],
            chooseClass : {}
        }

        $scope.goClassMoral = function (item) {
            $scope.info.showClass = false;
            console.log(item);
            $scope.info.chooseClass = item;
            $scope.info.studentList = item.studentList;
        }

        $scope.goMoralStudent = function (item) {
            console.log(item);
            $state.go("teacherMoralStudent",{studentId:item.studentId,studentName:item.studentName,classId:$scope.info.chooseClass.classId})
        }
}])
