/**
 * 建立angular.module
 */

define(['angular'], function (angular) {
    var app = angular.module('educationApp',['ngResource','ui.router','ngSanitize','ionic','studentTab',
        'oc.lazyLoad','highcharts-ng','infinite-scroll','educationGlobal','ionic-datepicker'])
        .config(['$httpProvider','Global','$ionicConfigProvider',function($httpProvider,Global,$ionicConfigProvider) {

            $ionicConfigProvider.platform.android.tabs.position('bottom');

            $ionicConfigProvider.platform.android.navBar.alignTitle('center');

            $httpProvider.interceptors.push(function($rootScope){
                return {
                    request: function(config){
                        config.headers = config.headers || {};

                        if(window.location.href.indexOf("Student")!=-1||window.location.href.indexOf("student")!=-1) {
                            window.localStorage.setItem("userType",Global.userType.STUDENT);
                        }
                        else if(window.location.href.indexOf("Teacher")!=-1||window.location.href.indexOf("teacher")!=-1)
                        {
                            window.localStorage.setItem("userType",Global.userType.TEACHER);
                        }

                        if(window.localStorage.getItem("userType")!=undefined
                            &&window.localStorage.getItem("userType")!=null)
                        {
                            config.headers.educationusertype = window.localStorage.getItem("userType");
                        }

                        if(window.localStorage.getItem("studentlogintoken")!=undefined){
                            config.headers.studentlogintoken = window.localStorage.getItem("studentlogintoken");
                        }
                        if(window.localStorage.getItem("teacherlogintoken")!=undefined){
                            config.headers.teacherlogintoken = window.localStorage.getItem("teacherlogintoken");
                        }
                        if(localStorage.getItem("schoolId") !== undefined){
                            config.headers.schoolid = localStorage.getItem("schoolId");
                        }

                        return config;
                    }
                }
            });

        }])
        .run(function($rootScope){
            $rootScope.returnRootNative = function(){
            };
            $rootScope.teacherCourseMissionDetail = {
            };
            $rootScope.teacherDiscussStudents = [];
            $rootScope.schoolId = '';
            $rootScope.prepareMissionList = [];
            $rootScope.tempMissionBaseInfo = {
                missionName:'',
                missionDescription:''
            }
        })
    return app;
});