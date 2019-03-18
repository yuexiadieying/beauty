/**
 * 建立angular.module
 */

define(['angular'], function (angular) {
    var app = angular.module('educationApp',['ngResource','ui.router','ngSanitize','ionic',
        'oc.lazyLoad','highcharts-ng','infinite-scroll','educationGlobal','ionic-datepicker'])
        .config(['$httpProvider',function($httpProvider) {

            $httpProvider.interceptors.push(function($rootScope){
                return {
                    request: function(config){
                        config.headers = config.headers || {};
                        if(window.localStorage.getItem("logintoken")!=undefined){
                            config.headers.logintoken = window.localStorage.getItem("logintoken");
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
            $rootScope.teacherDiscussStudents = []
        })
    return app;
});