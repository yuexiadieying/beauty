angular.module('controllers',[]).controller('teacherDiscussStudentCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading) {

        $rootScope.title = "学生点评";

        $scope.goDiscussStudent = function (info) {
            $rootScope.teacherDiscussStudents.push(info);
            if(info.courseCommentStatus!='3')
            {
                $rootScope.teacherDiscussStudents = [];
                $rootScope.teacherDiscussStudents.push(info);
                $state.go("teacherDiscussStudSubmit",{type:'alreadySubmit'});
            }
        }
        
        $scope.goDiscussStudentGroup = function () {
            console.log($rootScope.teacherDiscussStudents);
            $state.go("teacherDiscussStudSubmit",{type:'noSubmit'});
        }
        
        $scope.chooseDiscussStudent = function (info) {
            info.discussStudentFlag = !info.discussStudentFlag;
        }

        $scope.teacherDiscussStudentList = [
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '李正凯',
                studentNo : '2005230001',
                courseCommentStatus : '0',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt1.jpeg',
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt2.jpg',
                ]
            },
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '刘涛',
                studentNo : '2005230002',
                courseCommentStatus : '1',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt1.jpeg',
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt2.jpg'
                ]
            },
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '王品恒',
                studentNo : '2005230001',
                courseCommentStatus : '0',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt1.jpeg',
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt2.jpg'
                ]
            },
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '陈桂红',
                studentNo : '2005230004',
                courseCommentStatus : '1',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt1.jpeg',
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt2.jpg'
                ]
            },
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '吕冲',
                studentNo : '2005230005',
                courseCommentStatus : '1',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt1.jpeg',
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt2.jpg'
                ]
            },
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '刘昊',
                studentNo : '2005230006',
                courseCommentStatus : '0',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt1.jpeg',
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt2.jpg'
                ]
            },
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '易晗平',
                studentNo : '2005230007',
                courseCommentStatus : '3',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                ]
            },
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '周小平',
                studentNo : '2005230008',
                courseCommentStatus : '3',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                ]
            },
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '王璇',
                studentNo : '2005230009',
                courseCommentStatus : '1',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt1.jpeg',
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt2.jpg'
                ]
            },
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '刘磊',
                studentNo : '2005230010',
                courseCommentStatus : '1',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt1.jpeg',
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt2.jpg'
                ]
            },
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '张弛',
                studentNo : '2005230011',
                courseCommentStatus : '3',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                ]
            },
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '刘一宁',
                studentNo : '2005230012',
                courseCommentStatus : '3',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt1.jpeg',
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt2.jpg'
                ]
            },
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '王洪涛',
                studentNo : '2005230013',
                courseCommentStatus : '1',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt1.jpeg',
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt2.jpg'
                ]
            },
            {
                courseId : '123223',
                studentId : '232234',
                studentName : '徐涛',
                studentNo : '2005230014',
                courseCommentStatus : '0',
                courseCommentMsg:'上课表现还需要加强，有时候容易跟同学聊天',
                courseCommentURLs : [
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt1.jpeg',
                    'http://extro.oss-cn-hangzhou.aliyuncs.com/kt2.jpg'
                ]
            }
        ]

        $rootScope.teacherDiscussStudents = [];

        angular.forEach($scope.teacherDiscussStudentList,function (val,index) {
            if(val.courseCommentStatus=='3')
            {
                value = {
                    discussStudentFlag:false
                }
                val.discussStudentFlag = false;
            }
        })
}])
