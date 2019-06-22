'use strict';


angular.module('app', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngTouch',
    'ngStorage',
    'ui.router',
    'ui.bootstrap',
    'ui.load',
    'ui.jq',
    'ui.validate',
    'oc.lazyLoad',
    'pascalprecht.translate',
    'traGlobal'
]).run(function($rootScope,$http,$state,Global){

    $rootScope.loginOut = function(){
        $http.get('/traffic/user/loginOut')
            .then(function(response) {
                if(response.data.result==Global.SUCCESS)
                {
                    window.localStorage.removeItem("logintoken");
                    $state.go('access.signin');
                }
            }, function(x) {
                $scope.authError = 'Server Error';
            });
    };
});