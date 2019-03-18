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
                    .state('tab', {
                        url: '/tab',
                        abstract: true,
                        cache: false,
                        templateUrl: 'views/student/studentTab.html?ver='+educationVersion,
                        controller: 'studentTabCtrl'

                    })
                    .state('tab.studentHome', {
                        url: '/studentHome/:schoolId',
                        views: {
                            'tab-studentHome': {
                                templateProvider: function() {
                                    return lazyDeferred.promise;
                                },
                                controller: 'educationStudentHomeCtrl',
                                resolve: {
                                    load: function($templateCache, $ocLazyLoad, $q, $http) {
                                        loadFunction($templateCache, $ocLazyLoad, $q, $http, 'app.tab.studentHome',
                                            ['controllers/student/educationStudentHomeCtrl.js'],
                                            'views/student/educationStudentHome.html?ver='+educationVersion);
                                    }
                                }
                            }
                        }
                    })
                    .state('tab.studentMessage', {
                        url: '/studentMessage',
                        views: {
                            'tab-studentMessage': {
                                templateProvider: function() {
                                    return lazyDeferred.promise;
                                },
                                controller: 'educationStudentMessageCtrl',
                                resolve: {
                                    load: function($templateCache, $ocLazyLoad, $q, $http) {
                                        loadFunction($templateCache, $ocLazyLoad, $q, $http, 'app.tab.studentMessage',
                                            ['controllers/student/educationStudentMessageCtrl.js'],
                                            'views/student/educationStudentMessage.html?ver='+educationVersion);
                                    }
                                }
                            }
                        }
                    })
                    .state('tab.studentCenter', {
                        url: '/studentCenter',
                        views: {
                            'tab-studentCenter': {
                                templateProvider: function() {
                                    return lazyDeferred.promise;
                                },
                                controller: 'educationStudentCenterCtrl',
                                resolve: {
                                    load: function($templateCache, $ocLazyLoad, $q, $http) {
                                        loadFunction($templateCache, $ocLazyLoad, $q, $http, 'app.tab.studentCenter',
                                            ['controllers/student/educationStudentCenterCtrl.js'],
                                            'views/student/educationStudentCenter.html?ver='+educationVersion);
                                    }
                                }
                            }
                        }
                    })
                    .state('educationTeacherHome', {
                        url: '/educationTeacherHome/:schoolId',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationTeacherHomeCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationTeacherHomeCtrl',
                                    ['controllers/teacher/educationTeacherHomeCtrl.js?ver='+ educationVersion],
                                    'views/teacher/educationTeacherHome.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationStudentHome', {
                        url: '/educationStudentHome/:schoolId',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationStudentHomeCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationStudentHomeCtrl',
                                    ['controllers/student/educationStudentHomeCtrl.js?ver='+ educationVersion],
                                    'views/student/educationStudentHome.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationMoreInfo', { //更多内容
                        url: '/educationMoreInfo',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationStudentMoreInfoCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationStudentMoreInfoCtrl',
                                    ['controllers/student/educationStudentMoreInfoCtrl.js?ver='+ educationVersion],
                                    'views/student/educationStudentMoreInfo.html?ver=' + educationVersion);
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
                                    ['controllers/teacher/educationTeacherMoreInfoCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/student/educationVacationCtrl.js?ver='+ educationVersion,
                                        'libs/tool/mobiscroll.custom-2.17.0.min.js',
                                        'styles/lib/mobiscroll.custom-2.17.0.min.css'],
                                    'views/student/educationVacation.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('courseMission', { //课表点击课堂
                        url: '/courseMission/:classCourseId,:time',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'courseMissionCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.courseMissionCtrl',
                                    ['controllers/student/courseMissionCtrl.js?ver='+ educationVersion],
                                    'views/student/courseMission.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('commitMission', { //提交任务
                        url: '/commitMission/:missionId,:classCourseId,:time',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'commitMissionCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.commitMissionCtrl',
                                    ['controllers/student/commitMissionCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/student/missionDetailCtrl.js?ver='+ educationVersion],
                                    'views/student/missionDetail.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('courseDetail', { //课程详情
                        url: '/courseDetail/:classCourseId,:time',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'courseDetailCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.courseDetailCtrl',
                                    ['controllers/student/courseDetailCtrl.js?ver='+ educationVersion],
                                    'views/student/courseDetail.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('schoolNewsDetail', { //新闻详情
                        url: '/schoolNewsDetail/:newsId',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'schoolNewsDetailCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.schoolNewsDetailCtrl',
                                    ['controllers/schoolNewsDetailCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/schoolNewsListCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/schoolMasterMailCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/student/educationStudentMessageCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/teacher/educationTeacherMessageCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/student/educationStudentCenterCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/teacher/educationTeacherCenterCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/student/educationStudentInfoCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/teacher/educationTeacherInfoCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/student/educationStudentRewardCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/educationUserSetCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/teacher/teacherVacationListCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/teacher/teacherHistoryVacationListCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/teacher/teacherVacationDetailCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/teacher/teacherCourseTableCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/teacher/teacherCourseMissionTableCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/student/studentChooseCourseCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/student/studentChooseCourseListCtrl.js?ver='+ educationVersion],
                                    'views/student/studentChooseCourseList.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('renrenList', { //人人通列表
                        url: '/renrenList',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'renrenListCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.renrenListCtrl',
                                    ['controllers/renrenListCtrl.js?ver='+ educationVersion],
                                    'views/renrenList.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('renrenDetail', { //人人通详情
                        url: '/renrenDetail',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'renrenDetailCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.renrenDetailCtrl',
                                    ['controllers/renrenDetailCtrl.js?ver='+ educationVersion],
                                    'views/renrenDetail.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('renrenRelease', { //人人通发布
                        url: '/renrenRelease',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'renrenReleaseCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.renrenReleaseCtrl',
                                    ['controllers/renrenReleaseCtrl.js?ver='+ educationVersion],
                                    'views/renrenRelease.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('renrenComment', { //人人通评论
                        url: '/renrenComment',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'renrenCommentCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.renrenCommentCtrl',
                                    ['controllers/renrenCommentCtrl.js?ver='+ educationVersion],
                                    'views/renrenComment.html?ver=' + educationVersion);
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
                                    ['controllers/student/accountSafetyCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/student/aboutOurCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/student/userAgreementCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/student/studentHistoryVacationListCtrl.js?ver='+ educationVersion],
                                    'views/student/studentHistoryVacationList.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('studentVacationDetail', { //学生请假详情
                        url: '/studentVacationDetail/:type,:vacateId',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'studentVacationDetailCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.studentVacationDetailCtrl',
                                    ['controllers/student/studentVacationDetailCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/student/studentCourseTableCtrl.js?ver='+ educationVersion],
                                    'views/student/studentCourseTable.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('login', { //登录
                        url: '/login/:redirectUrl',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'loginCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.loginCtrl',
                                    ['controllers/loginCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/schoolChooseListCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/teacher/teacherCourseMissionListCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/teacher/teacherCourseMissionDetailCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherCourseMissionDetail.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('teacherPushMission', {
                        url: '/teacherPushMission/:courseId,:classId',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'teacherPushMissionCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.teacherPushMissionCtrl',
                                    ['controllers/teacher/teacherPushMissionCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/teacher/teacherMissionDetailCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/teacher/teacherDiscussStudCtrl.js?ver='+ educationVersion],
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
                                    ['controllers/teacher/teacherDiscussStudSubmitCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherDiscussStudSubmit.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('educationMoralList', {
                        url: '/educationMoralList',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'educationMoralListCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.educationMoralListCtrl',
                                    ['controllers/teacher/educationMoralListCtrl.js?ver='+ educationVersion],
                                    'views/teacher/educationMoralList.html?ver=' + educationVersion);
                            }
                        }
                    })
                    .state('teacherMoralStudent', {
                        url: '/teacherMoralStudent/:studentId,:studentName,:classId',
                        cache:'false',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'teacherMoralStudentCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.teacherMoralStudentCtrl',
                                    ['controllers/teacher/teacherMoralStudentCtrl.js?ver='+ educationVersion],
                                    'views/teacher/teacherMoralStudent.html?ver=' + educationVersion);
                            }
                        }
                    })

                $urlRouterProvider.otherwise('/tab/studentHome/1')
            }])
})