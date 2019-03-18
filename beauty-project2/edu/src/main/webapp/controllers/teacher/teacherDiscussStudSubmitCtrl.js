angular.module('controllers',[]).controller('teacherDiscussStudSubmitCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','Global','TeacherPushCommentStudent',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,Global,TeacherPushCommentStudent) {

        $rootScope.title = "学生点评";

        $scope.submitStudentDiscuss = function () {

            var studentCourseCommentDTOS = [];
            angular.forEach($rootScope.teacherDiscussStudents,function (val,index) {
                    var value = {};
                    value.classCourseId = val.classCourseId;
                    value.studentId = val.studentId;
                    value.studentName = val.studentName;
                    value.studentNo = val.studentNo;
                    value.courseCommentStatus = val.courseCommentStatus;
                    value.courseCommentMsg = val.courseCommentMsg;
                    value.courseCommentURLs = "";
                    studentCourseCommentDTOS.push(value);
            })

            console.log(studentCourseCommentDTOS);
            TeacherPushCommentStudent.save(studentCourseCommentDTOS,function (data) {
                if(data.result==Global.SUCCESS)
                {
                    $state.go("teacherDiscussStud");
                }
            })
        }

        $scope.param = {
            courseCommentMsg : '',
            discussType : $stateParams.type
        };

        $scope.chooseDiscussType = function (type) {
            $scope.discussStudentType = type;
            angular.forEach($rootScope.teacherDiscussStudents,function (val,index) {
                    if(type=='praise') {
                        val.courseCommentStatus = '0';
                    }else if(type='criticism'){
                        val.courseCommentStatus = '1';
                    }else if(type='suggest'){
                        val.courseCommentStatus = '2';
                    }
                    val.courseCommentMsg = angular.copy($scope.param.courseCommentMsg);
            })
        }

}])
