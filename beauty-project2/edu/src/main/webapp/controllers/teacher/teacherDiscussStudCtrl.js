angular.module('controllers',[]).controller('teacherDiscussStudCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','GetTeacherDiscussStudentList','Global',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,GetTeacherDiscussStudentList,Global) {

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

        $scope.teacherDiscussStudentList = []
        $rootScope.teacherDiscussStudents = [];

        GetTeacherDiscussStudentList.get(
            {
                classId:$rootScope.prepareMissionList[0].classId,
                courseId:$rootScope.prepareMissionList[0].courseId,
                weekIndex:$rootScope.prepareMissionList[0].weekIndex
            },function (data) {
                if(data.result==Global.SUCCESS)
                {
                    $scope.teacherDiscussStudentList = data.responseData;
                    angular.forEach($scope.teacherDiscussStudentList,function (val,index) {
                        if(val.courseCommentStatus=='3'||val.courseCommentStatus==undefined)
                        {
                            val.discussStudentFlag = false;
                            val.courseCommentStatus = '3';
                        }
                    })
                }
        })
}])
