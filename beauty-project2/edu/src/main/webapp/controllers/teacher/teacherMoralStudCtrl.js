angular.module('controllers',[]).controller('teacherMoralStudCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil','$ionicLoading','TeacherMoralStudent','Global',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil,$ionicLoading,TeacherMoralStudent,Global) {

        $rootScope.title = "学生德育量化打分";

        $scope.info = {
            studentId:$stateParams.studentId,
            studentName:$stateParams.studentName,
            classId:$stateParams.classId,
            schoolId:$rootScope.schoolId,
            moralTitle:"",
            moralContent:"",
            moralScore:''
        }

        $scope.submitStudentMoral = function () {
            if($scope.info.moralTitle==""||$scope.info.moralContent==""||$scope.info.moralScore=="")
            {
                alert("请填写完整学生德育量化评分信息")
            }
            else
            {
                TeacherMoralStudent.save($scope.info,function (data) {
                    if(data.result==Global.SUCCESS)
                    {
                        $state.go("educationMoralList");
                    }
                })
            }
        }


}])
