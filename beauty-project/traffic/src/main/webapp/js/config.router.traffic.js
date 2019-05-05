'use strict';

/**
 * Config for the router
 */
angular.module('app')
  .run(
    ['$rootScope', '$state', '$stateParams',
      function ($rootScope,   $state,   $stateParams) {
          $rootScope.$state = $state;
          $rootScope.$stateParams = $stateParams;        
      }
    ]
  )
  .config(
    ['$stateProvider', '$urlRouterProvider',
      function ($stateProvider,   $urlRouterProvider) {
          
          $urlRouterProvider
              .otherwise('/app/statistic');
          $stateProvider
              .state('app', {
                  abstract: true,
                  url: '/app',
                  templateUrl: 'tra/app.html'
              })
              .state('app.statistic', {
                  url: '/statistic',
                  templateUrl: 'tra/statistic.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/statistic.js']);
                          }]
                  }
              })

              .state('login', {
                  url: '/login',
                  templateUrl: 'tra/login.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/login.js']);
                          }]
                  }
              })
              .state('entry', {
                  url: '/entry',
                  templateUrl: 'tra/entry.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/entry.js']);
                          }]
                  }
              })


              .state('app.gsglllgc', {
                  url: '/gsglllgc',
                  templateUrl: 'tra/gljt/gsglllgc.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/gljt/gsglllgc.js']);
                          }]
                  }
              })
              .state('app.sglgcxmgl', {
                  url: '/sglgcxmgl',
                  templateUrl: 'tra/gljt/sglgcxmgl/sglgcxmgl.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/gljt/sglgcxmgl/sglgcxmgl.js']);
                          }]
                  }
              })
              .state('app.sglgcxmgl-xinxi', {
                  url: '/sglgcxmgl-xinxi',
                  templateUrl: 'tra/gljt/sglgcxmgl/sglgcxmgl_xinxi.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/gljt/sglgcxmgl/sglgcxmgl_xinxi.js']);
                          }]
                  }
              })
              .state('app.qtjt', {
                  url: '/qtjt',
                  templateUrl: 'tra/qtjt/qtjt.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/qtjt/qtjt.js']);
                          }]
                  }
              })
              .state('app.qzcspjk', {
                  url: '/qzcspjk',
                  templateUrl: 'tra/qtjt/qzcspjk.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/qtjt/qzcspjk.js']);
                          }]
                  }
              })
              .state('app.zhgj', {
                  url: '/zhgj',
                  templateUrl: 'tra/qtjt/zhgj.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/qtjt/zhgj.js']);
                          }]
                  }
              })
              .state('app.sdlyssjxtgl', {
                  url: '/sdlyssjxtgl',
                  templateUrl: 'tra/sdlyssjxtgl/sdlyssjxtgl.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sdlyssjxtgl/sdlyssjxtgl.js']);
                          }]
                  }
              })
              .state('app.sdlyssjxtgl-cyryxx', {
                  url: '/sdlyssjxtgl-cyryxx',
                  templateUrl: 'tra/sdlyssjxtgl/sdlyssjxtgl_cyryxx.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sdlyssjxtgl/sdlyssjxtgl_cyryxx.js']);
                          }]
                  }
              })
              .state('app.sdlyssjxtgl-dlysgljgxx', {
                  url: '/sdlyssjxtgl-dlysgljgxx',
                  templateUrl: 'tra/sdlyssjxtgl/sdlyssjxtgl_dlysgljgxx.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sdlyssjxtgl/sdlyssjxtgl_dlysgljgxx.js']);
                          }]
                  }
              })
              .state('app.sdlyssjxtgl-dlyzzfxx', {
                  url: '/sdlyssjxtgl-dlyzzfxx',
                  templateUrl: 'tra/sdlyssjxtgl/sdlyssjxtgl_dlyzzfxx.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sdlyssjxtgl/sdlyssjxtgl_dlyzzfxx.js']);
                          }]
                  }
              })
              .state('app.sdlyssjxtgl-yjclxx', {
                  url: '/sdlyssjxtgl-yjclxx',
                  templateUrl: 'tra/sdlyssjxtgl/sdlyssjxtgl_yjclxx.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sdlyssjxtgl/sdlyssjxtgl_yjclxx.js']);
                          }]
                  }
              })
              .state('app.sdlyssjxtgl-yjyhxx', {
                  url: '/sdlyssjxtgl-yjyhxx',
                  templateUrl: 'tra/sdlyssjxtgl/sdlyssjxtgl_yjyhxx.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sdlyssjxtgl/sdlyssjxtgl_yjyhxx.js']);
                          }]
                  }
              })
              .state('app.sdlyssjxtgl-yyxlxx', {
                  url: '/sdlyssjxtgl-yyxlxx',
                  templateUrl: 'tra/sdlyssjxtgl/sdlyssjxtgl_yyxlxx.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sdlyssjxtgl/sdlyssjxtgl_yyxlxx.js']);
                          }]
                  }
              })
              .state('app.sjtystjfxjc', {
                  url: '/sjtystjfxjc',
                  templateUrl: 'tra/sjtystjfxjc/sjtystjfxjc.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sjtystjfxjc/sjtystjfxjc.js']);
                          }]
                  }
              })
              .state('app.sjtystjfxjc-chenshikeyun', {
                  url: '/sjtystjfxjc-chenshikeyun',
                  templateUrl: 'tra/sjtystjfxjc/sjtystjfxjc_chenshikeyun.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sjtystjfxjc/sjtystjfxjc_chenshikeyun.js']);
                          }]
                  }
              })
              .state('app.sjtystjfxjc-daoluyunshu', {
                  url: '/sjtystjfxjc-daoluyunshu',
                  templateUrl: 'tra/sjtystjfxjc/sjtystjfxjc_daoluyunshu.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sjtystjfxjc/sjtystjfxjc_daoluyunshu.js']);
                          }]
                  }
              })
              .state('app.sjtystjfxjc-gangkouzonghe', {
                  url: '/sjtystjfxjc-gangkouzonghe',
                  templateUrl: 'tra/sjtystjfxjc/sjtystjfxjc_gangkouzonghe.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sjtystjfxjc/sjtystjfxjc_gangkouzonghe.js']);
                          }]
                  }
              })
              .state('app.sjtystjfxjc-gonglujiaodiao', {
                  url: '/sjtystjfxjc-gonglujiaodiao',
                  templateUrl: 'tra/sjtystjfxjc/sjtystjfxjc_gonglujiaodiao.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sjtystjfxjc/sjtystjfxjc_gonglujiaodiao.js']);
                          }]
                  }
              })
              .state('app.sjtystjfxjc-neihehangdao', {
                  url: '/sjtystjfxjc-neihehangdao',
                  templateUrl: 'tra/sjtystjfxjc/sjtystjfxjc_neihehangdao.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sjtystjfxjc/sjtystjfxjc_neihehangdao.js']);
                          }]
                  }
              })
              .state('app.sjtystjfxjc-yunshuzonghe', {
                  url: '/sjtystjfxjc-yunshuzonghe',
                  templateUrl: 'tra/sjtystjfxjc/sjtystjfxjc_yunshuzonghe.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sjtystjfxjc/sjtystjfxjc_yunshuzonghe.js']);
                          }]
                  }
              })
              .state('app.sljt', {
                  url: '/sljt',
                  templateUrl: 'tra/sljt/sljt.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sljt/sljt.js']);
                          }]
                  }
              })
              .state('app.gkqyhmtdwgl', {
                  url: '/gkqyhmtdwgl',
                  templateUrl: 'tra/sljt/gkqyhmtdwgl/gkqyhmtdwgl.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sljt/gkqyhmtdwgl/gkqyhmtdwgl.js']);
                          }]
                  }
              })
              .state('app.gkqyhmtdwgl-data', {
                  url: '/gkqyhmtdwgl-data',
                  templateUrl: 'tra/sljt/gkqyhmtdwgl/gkqyhmtdwgl_data.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sljt/gkqyhmtdwgl/gkqyhmtdwgl_data.js']);
                          }]
                  }
              })
              .state('app.sslyzgl', {
                  url: '/sslyzgl',
                  templateUrl: 'tra/sljt/sslyzgl/sslyzgl.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sljt/sslyzgl/sslyzgl.js']);
                          }]
                  }
              })
              .state('app.sslyzgl-data', {
                  url: '/sslyzgl-data',
                  templateUrl: 'tra/sljt/sslyzgl/sslyzgl_data.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sljt/sslyzgl/sslyzgl_data.js']);
                          }]
                  }
              })
              .state('app.tzjhgl', {
                  url: '/tzjhgl',
                  templateUrl: 'tra/tzjhgl/tzjhgl.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/tzjhgl/tzjhgl.js']);
                          }]
                  }
              })
              .state('app.tzjhgl-fupintongji', {
                  url: '/tzjhgl-fupintongji',
                  templateUrl: 'tra/tzjhgl/tzjhgl_fupintongji.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/tzjhgl/tzjhgl_fupintongji.js']);
                          }]
                  }
              })
              .state('app.tzjhgl-gongluyanghu', {
                  url: '/tzjhgl-gongluyanghu',
                  templateUrl: 'tra/tzjhgl/tzjhgl_gongluyanghu.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/tzjhgl/tzjhgl_gongluyanghu.js']);
                          }]
                  }
              })
              .state('app.tzjhgl-gudingzichan', {
                  url: '/tzjhgl-gudingzichan',
                  templateUrl: 'tra/tzjhgl/tzjhgl_gudingzichan.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/tzjhgl/tzjhgl_gudingzichan.js']);
                          }]
                  }
              })
              .state('app.tzjhgl-qiyefarencaiwuzhuangkuang', {
                  url: '/tzjhgl-qiyefarencaiwuzhuangkuang',
                  templateUrl: 'tra/tzjhgl/tzjhgl_qiyefarencaiwuzhuangkuang.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/tzjhgl/tzjhgl_qiyefarencaiwuzhuangkuang.js']);
                          }]
                  }
              })
              .state('app.tzjhgl-shuiyunjianshe', {
                  url: '/tzjhgl-shuiyunjianshe',
                  templateUrl: 'tra/tzjhgl/tzjhgl_shuiyunjianshe.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/tzjhgl/tzjhgl_shuiyunjianshe.js']);
                          }]
                  }
              })
              .state('app.xygl', {
                  url: '/xygl',
                  templateUrl: 'tra/xygl/xygl.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/xygl/xygl.js']);
                          }]
                  }
              })
              .state('app.xygl-sglsljsscxyxxgl', {
                  url: '/xygl-sglsljsscxyxxgl',
                  templateUrl: 'tra/xygl/xygl_sglsljsscxyxxgl.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/xygl/xygl_sglsljsscxyxxgl.js']);
                          }]
                  }
              })
              .state('app.xygl-sslysscxyxxgl', {
                  url: '/xygl-sslysscxyxxgl',
                  templateUrl: 'tra/xygl/xygl_sslysscxyxxgl.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/xygl/xygl_sslysscxyxxgl.js']);
                          }]
                  }
              })

      }
    ]
  );