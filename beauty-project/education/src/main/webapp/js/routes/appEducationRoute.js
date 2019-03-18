/**
 * 路由
 */
define(['appEducation'], function(app){
    return app
        .config(['$stateProvider','$urlRouterProvider',
            function($stateProvider,$urlRouterProvider) {
                var loadFunction = function($templateCache, $ocLazyLoad, $q, $http,name,files,htmlURL){
                    lazyDeferred = $q.defer();
                    return $ocLazyLoad.load ({
                        name: name,
                        files: files
                    }).then(function() {
                        return $http.get(htmlURL)
                            .success(function(data, status, headers, config) {
                                return lazyDeferred.resolve(data);
                            }).
                            error(function(data, status, headers, config) {
                                return lazyDeferred.resolve(data);
                            });
                    });
                };

                $stateProvider
                    .state('educationTeacherHome', {
                        url: '/educationTeacherHome',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationTeacherHomeCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationTeacherHomeCtrl',
                                    ['js/controllers/teacher/educationTeacherHomeCtrl.js?ver='+ educationVersion],
                                    'views/teacher/educationTeacherHome.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationStudentHome', {
                        url: '/educationStudentHome',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationStudentHomeCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationStudentHomeCtrl',
                                    ['js/controllers/student/educationStudentHomeCtrl.js?ver='+ educationVersion],
                                    'views/student/educationStudentHome.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationMoreInfo', { //更多内容
                        url: '/educationMoreInfo',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationMoreInfoCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationMoreInfoCtrl',
                                    ['js/controllers/student/educationMoreInfoCtrl.js?ver='+ educationVersion],
                                    'views/student/educationMoreInfo.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationTeacherMoreInfo', { //更多内容
                        url: '/educationTeacherMoreInfo',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationTeacherMoreInfoCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationTeacherMoreInfoCtrl',
                                    ['js/controllers/teacher/educationTeacherMoreInfoCtrl.js?ver='+ educationVersion],
                                    'views/teacher/educationTeacherMoreInfo.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationVacation', { //请假申请
                        url: '/educationVacation',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationVacationCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationVacationCtrl',
                                    ['js/controllers/student/educationVacationCtrl.js?ver='+ educationVersion],
                                    'views/student/educationVacation.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('courseMission', { //课表点击课堂
                        url: '/courseMission',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'courseMissionCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.courseMissionCtrl',
                                    ['js/controllers/student/courseMissionCtrl.js?ver='+ educationVersion],
                                    'views/student/courseMission.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('commitMission', { //提交任务
                        url: '/commitMission',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'commitMissionCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.commitMissionCtrl',
                                    ['js/controllers/student/commitMissionCtrl.js?ver='+ educationVersion],
                                    'views/student/commitMission.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('missionDetail', { //任务详情
                        url: '/missionDetail',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'missionDetailCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.missionDetailCtrl',
                                    ['js/controllers/student/missionDetailCtrl.js?ver='+ educationVersion],
                                    'views/student/missionDetail.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('courseDetail', { //课程详情
                        url: '/courseDetail',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'courseDetailCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.courseDetailCtrl',
                                    ['js/controllers/student/courseDetailCtrl.js?ver='+ educationVersion],
                                    'views/student/courseDetail.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('schoolNewsDetail', { //新闻详情
                        url: '/schoolNewsDetail',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'schoolNewsDetailCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.schoolNewsDetailCtrl',
                                    ['js/controllers/schoolNewsDetailCtrl.js?ver='+ educationVersion],
                                    'views/schoolNewsDetail.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('schoolNewsList', { //新闻列表
                        url: '/schoolNewsList',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'schoolNewsListCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.schoolNewsListCtrl',
                                    ['js/controllers/schoolNewsListCtrl.js?ver='+ educationVersion],
                                    'views/schoolNewsList.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('schoolMasterMail', { //新闻列表
                        url: '/schoolMasterMail',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'schoolMasterMailCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.schoolMasterMailCtrl',
                                    ['js/controllers/schoolMasterMailCtrl.js?ver='+ educationVersion],
                                    'views/schoolMasterMail.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationStudentMessage', { //消息
                        url: '/educationStudentMessage',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationStudentMessageCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationStudentMessageCtrl',
                                    ['js/controllers/student/educationStudentMessageCtrl.js?ver='+ educationVersion],
                                    'views/student/educationStudentMessage.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationTeacherMessage', { //消息
                        url: '/educationTeacherMessage',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationTeacherMessageCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationTeacherMessageCtrl',
                                    ['js/controllers/teacher/educationTeacherMessageCtrl.js?ver='+ educationVersion],
                                    'views/teacher/educationTeacherMessage.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationStudentCenter', { //我的
                        url: '/educationStudentCenter',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationStudentCenterCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationStudentCenterCtrl',
                                    ['js/controllers/student/educationStudentCenterCtrl.js?ver='+ educationVersion],
                                    'views/student/educationStudentCenter.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationTeacherCenter', { //我的
                        url: '/educationTeacherCenter',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationTeacherCenterCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationTeacherCenterCtrl',
                                    ['js/controllers/teacher/educationTeacherCenterCtrl.js?ver='+ educationVersion],
                                    'views/teacher/educationTeacherCenter.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationStudentInfo', { //个人信息
                        url: '/educationStudentInfo',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationStudentInfoCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationStudentInfoCtrl',
                                    ['js/controllers/student/educationStudentInfoCtrl.js?ver='+ educationVersion],
                                    'views/student/educationStudentInfo.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationTeacherInfo', { //个人信息
                        url: '/educationTeacherInfo',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationTeacherInfoCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationTeacherInfoCtrl',
                                    ['js/controllers/teacher/educationTeacherInfoCtrl.js?ver='+ educationVersion],
                                    'views/teacher/educationTeacherInfo.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationStudentReward', { //奖励奖章
                        url: '/educationStudentReward',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationStudentRewardCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationStudentRewardCtrl',
                                    ['js/controllers/student/educationStudentRewardCtrl.js?ver='+ educationVersion],
                                    'views/student/educationStudentReward.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationUserSet', { //设置
                        url: '/educationUserSet',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationUserSetCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationUserSetCtrl',
                                    ['js/controllers/educationUserSetCtrl.js?ver='+ educationVersion],
                                    'views/educationUserSet.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('teacherVacationList', { //请假审批列表
                        url: '/teacherVacationList',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'teacherVacationListCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.teacherVacationListCtrl',
                                    ['js/controllers/teacher/teacherVacationListCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherVacationList.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('teacherHistoryVacationList', { //审批记录
                        url: '/teacherHistoryVacationList',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'teacherHistoryVacationListCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.teacherHistoryVacationListCtrl',
                                    ['js/controllers/teacher/teacherHistoryVacationListCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherHistoryVacationList.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('teacherVacationDetail', { //审批详情
                        url: '/teacherVacationDetail',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'teacherVacationDetailCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.teacherVacationDetailCtrl',
                                    ['js/controllers/teacher/teacherVacationDetailCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherVacationDetail.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('teacherCourseTable', { //老师课表
                        url: '/teacherCourseTable',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'teacherCourseTableCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.teacherCourseTableCtrl',
                                    ['js/controllers/teacher/teacherCourseTableCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherCourseTable.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('teacherCourseMissionTable', { //老师课表
                        url: '/teacherCourseMissionTable',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'teacherCourseMissionTableCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.teacherCourseMissionTableCtrl',
                                    ['js/controllers/teacher/teacherCourseMissionTableCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherCourseMissionTable.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('studentChooseCourse', { //选课
                        url: '/studentChooseCourse',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'studentChooseCourseCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.studentChooseCourseCtrl',
                                    ['js/controllers/student/studentChooseCourseCtrl.js?ver='+ educationVersion],
                                    'views/student/studentChooseCourse.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('studentChooseCourseList', { //选课列表
                        url: '/studentChooseCourseList',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'studentChooseCourseListCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.studentChooseCourseListCtrl',
                                    ['js/controllers/student/studentChooseCourseListCtrl.js?ver='+ educationVersion],
                                    'views/student/studentChooseCourseList.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('accountSafety', { //账号安全
                        url: '/accountSafety',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'accountSafetyCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.accountSafetyCtrl',
                                    ['js/controllers/student/accountSafetyCtrl.js?ver='+ educationVersion],
                                    'views/student/accountSafety.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('aboutOur', { //关于我们
                        url: '/aboutOur',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'aboutOurCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.aboutOurCtrl',
                                    ['js/controllers/student/aboutOurCtrl.js?ver='+ educationVersion],
                                    'views/student/aboutOur.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('userAgreement', { //用户协议
                        url: '/userAgreement',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'userAgreementCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.userAgreementCtrl',
                                    ['js/controllers/student/userAgreementCtrl.js?ver='+ educationVersion],
                                    'views/student/userAgreement.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('studentHistoryVacationList', { //学生请假记录
                        url: '/studentHistoryVacationList',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'studentHistoryVacationListCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.studentHistoryVacationListCtrl',
                                    ['js/controllers/student/studentHistoryVacationListCtrl.js?ver='+ educationVersion],
                                    'views/student/studentHistoryVacationList.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('studentVacationDetail', { //学生请假详情
                        url: '/studentVacationDetail/:vacateId',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'studentVacationDetailCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.studentVacationDetailCtrl',
                                    ['js/controllers/student/studentVacationDetailCtrl.js?ver='+ educationVersion],
                                    'views/student/studentVacationDetail.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('studentCourseTable', { //学生请假详情
                        url: '/studentCourseTable',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'studentCourseTableCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.studentCourseTableCtrl',
                                    ['js/controllers/student/studentCourseTableCtrl.js?ver='+ educationVersion],
                                    'views/student/studentCourseTable.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('login', { //登录
                        url: '/login',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'loginCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.loginCtrl',
                                    ['js/controllers/loginCtrl.js?ver='+ educationVersion],
                                    'views/login.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('schoolChooseList', { //选择学校
                        url: '/schoolChooseList',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'schoolChooseListCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.schoolChooseListCtrl',
                                    ['js/controllers/schoolChooseListCtrl.js?ver='+ educationVersion],
                                    'views/schoolChooseList.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('teacherCourseMissionList', {
                        url: '/teacherCourseMissionList/:courseMissionId',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'teacherCourseMissionListCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.teacherCourseMissionListCtrl',
                                    ['js/controllers/teacher/teacherCourseMissionListCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherCourseMissionList.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('teacherCourseMissionDetail', {
                        url: '/teacherCourseMissionDetail',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'teacherCourseMissionDetailCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.teacherCourseMissionDetailCtrl',
                                    ['js/controllers/teacher/teacherCourseMissionDetailCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherCourseMissionDetail.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('teacherPushMission', {
                        url: '/teacherPushMission',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'teacherPushMissionCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.teacherPushMissionCtrl',
                                    ['js/controllers/teacher/teacherPushMissionCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherPushMission.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('teacherMissionDetail', {
                        url: '/teacherMissionDetail',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'teacherMissionDetailCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.teacherMissionDetailCtrl',
                                    ['js/controllers/teacher/teacherMissionDetailCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherMissionDetail.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('teacherDiscussStud', {
                        url: '/teacherDiscussStud',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'teacherDiscussStudCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.teacherDiscussStudCtrl',
                                    ['js/controllers/teacher/teacherDiscussStudCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherDiscussStud.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('teacherDiscussStudSubmit', {
                        url: '/teacherDiscussStudSubmit/:type',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'teacherDiscussStudSubmitCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.teacherDiscussStudSubmitCtrl',
                                    ['js/controllers/teacher/teacherDiscussStudSubmitCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherDiscussStudSubmit.html?ver=' + educationVersion);
                            }
                        }
                    })

                $urlRouterProvider.otherwise('/educationStudentHome')
            }])
})