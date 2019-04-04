/**
 * 路由
 */
define(['appCar'], function(app){
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
                    .state('gameControl', {
                        url: '/gameControl',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'gameControlCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.gameControlCtrl',
                                    ['js/controllers/gameControlCtrl.js?ver=' + carVersion],
                                    'js/views/gameControl.html?ver=' + carVersion);
                            }
                        }
                    })
                    .state('bigShow', {
                        url: '/bigShow',
                        templateProvider: function() { return lazyDeferred.promise; },
                        controller: 'bigShowCtrl',
                        resolve: {
                            load: function($templateCache, $ocLazyLoad, $q, $http) {
                                loadFunction($templateCache, $ocLazyLoad, $q, $http,'app.bigShowCtrl',
                                    ['js/controllers/bigShowCtrl.js?ver=' + carVersion],
                                    'js/views/bigShow.html?ver=' + carVersion);
                            }
                        }
                    })
                $urlRouterProvider.otherwise('/gameControl')
            }])
})