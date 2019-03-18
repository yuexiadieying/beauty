var system = '/education/educationSystem/';
var teacher = '/education/educationTeacher/';
var student = '/education/educationStudent/';

define(['appEducation'], function (app) {
    app
        .factory('GetSchoolNewsList',['$resource',function ($resource){
            return $resource(system + 'schoolNewsList')
        }])
        .factory('GetSchoolNewsDetail',['$resource',function ($resource){
            return $resource(system + 'schoolNewsDetail')
        }])
        //获取学校的基本信息
        .factory('GetSchoolInfo',['$resource',function ($resource){
            return $resource(system + 'schoolInfo')
        }])
        .factory('EducationLogin',['$resource',function ($resource){
            return $resource(system + 'educationLogin')
        }])
        .factory('EducationPasswordChange',['$resource',function ($resource){
            return $resource(system + 'educationPasswordChange')
        }])
        .factory('SubmitMasterMail',['$resource',function ($resource){
            return $resource(system + 'submitMasterMail')
        }])
        .factory('GetTeacherClassCircle',['$resource',function ($resource){
            return $resource(teacher + 'teacherClassCircle')
        }])
        .factory('GetTeacherVacationApplyList',['$resource',function ($resource){
            return $resource(teacher + 'getTeacherVacationApplyList')
        }])
        .factory('ProcessVacationApply',['$resource',function ($resource){
            return $resource(teacher + 'processVacationApply')
        }])
        .factory('GetTeacherCourseMissionList',['$resource',function ($resource){
            return $resource(teacher + 'teacherCourseMissionList')
        }])
        .factory('GetTeacherDiscussStudentList',['$resource',function ($resource){
            return $resource(teacher + 'teacherDiscussStudentList')
        }])
        .factory('TeacherPushCommentStudent',['$resource',function ($resource){
            return $resource(teacher + 'teacherPushCommentStudent')
        }])
        .factory('TeacherPushHomeWorkComment',['$resource',function ($resource){
            return $resource(teacher + 'teacherPushHomeWorkComment')
        }])
        .factory('TeacherMoralStudent',['$resource',function ($resource){
            return $resource(teacher + 'teacherMoralStudent')
        }])
        //老师获取课程表数据
        .factory('TeacherCourseTableList',['$resource',function ($resource){
            return $resource(teacher + 'teacherCourseTableList')
        }])
        .factory('TeacherCourseTableBaseInfo',['$resource',function ($resource){
            return $resource(teacher + 'teacherCourseTableBaseInfo')
        }])
        .factory('TeacherClassList',['$resource',function ($resource){
            return $resource(teacher + 'teacherClassList')
        }])
        .factory('TeacherMissionList',['$resource',function ($resource){
            return $resource(teacher + 'teacherMissionList')
        }])
        .factory('TeacherCoursePrepareList',['$resource',function ($resource){
            return $resource(teacher + 'teacherCoursePrepareList')
        }])
        .factory('TeacherPushMission',['$resource',function ($resource){
            return $resource(teacher + 'teacherPushMission')
        }])
        //学生获取自己最新的未读的通知消息
        .factory('StudentShortMessage',['$resource',function ($resource){
            return $resource(student + 'studentShortMessage')
        }])
        //学生获取自己的班级圈信息
        .factory('GetStudentClassCircle',['$resource',function ($resource){
            return $resource(student + 'studentClassCircle')
        }])
        //学生获取自己某天的所有课程任务
        .factory('StudentCourseMissionList',['$resource',function ($resource){
            return $resource(student + 'studentCourseMissionList')
        }])
        //学生获取德育量化分数列表，按日期由近到远的排序
        .factory('StudentMoralityList',['$resource',function ($resource){
            return $resource(student + 'studentMoralityList')
        }])
        //学生获取自己在本课程的某天任务
        .factory('StudentCourseMissionDetail',['$resource',function ($resource){
            return $resource(student + 'studentCourseMissionDetail')
        }])
        //获取学生的请假申请列表
        .factory('StudentVacationApplyList',['$resource',function ($resource){
            return $resource(student + 'studentVacationApplyList')
        }])
        //获取学生的基本信息
        .factory('StudentInfo',['$resource',function ($resource){
            return $resource(student + 'studentInfo')
        }])
        //获取学生的某个请假详情情况
        .factory('StudentApplyVacationDetail',['$resource',function ($resource){
            return $resource(student + 'studentApplyVacationDetail')
        }])
        //学生提交请假申请
        .factory('StudentApplyVacation',['$resource',function ($resource){
            return $resource(student + 'studentApplyVacation')
        }])
        //获取学生的某个班级课程的信息
        .factory('StudentcourseClassInfo',['$resource',function ($resource){
            return $resource(student + 'studentcourseClassInfo')
        }])
        //获取上课评价信息
        .factory('getCourseMissionComment',['$resource',function ($resource){
            return $resource(student + 'getCourseMissionComment')
        }])
        //提交任务
        .factory('studentPushCourseMission',['$resource',function ($resource){
            return $resource(student + 'studentPushCourseMission')
        }])
        //学生获取课程表信息
        .factory('StudentCourseTableList',['$resource',function ($resource){
            return $resource(student + 'studentCourseTableList')
        }])
        //获取自己课表基本信息
        .factory('StudentCourseTableBaseInfo',['$resource',function ($resource){
            return $resource(student + 'studentCourseTableBaseInfo')
        }])


});
