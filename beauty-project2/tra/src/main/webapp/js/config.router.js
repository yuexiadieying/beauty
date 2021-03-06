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
                  templateUrl: 'tpl/app.html'
              })
              .state('app.statistic', {
                  url: '/statistic',
                  templateUrl: 'tpl/tra/statistic.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/statistic.js']);
                          }]
                  }
              })
              .state('app.sjtystjfxjc', {
                  url: '/sjtystjfxjc',
                  templateUrl: 'tpl/tra/shjtystjfxjc.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/sjtystjfxjc/sjtystjfxjc.js']);
                          }]
                  }
              })
              .state('app.three_level_coordinated_management', {
                  url: '/three_level_coordinated_management',
                  templateUrl: 'tpl/tra/three_level_coordinated_management.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/three_level_coordinated_management.js']);
                          }]
                  }
              })
              .state('app.collaborative_management', {
                  abstract: true,
                  url: '/collaborative_management',
                  templateUrl: 'tpl/tra/collaborative_management.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/collaborative_management.js']);
                          }]
                  }
              })

              .state('app.collaborative_management.list', {
                  url: '/inbox/{fold}',
                  templateUrl: 'tpl/tra/collaborative_management.list.html'
              })
              .state('app.collaborative_management.vehicle', {
                  url: '/inbox1/{fold}',
                  templateUrl: 'tpl/tra/collaborative_management.vehicle.html'
              })
              .state('app.collaborative_management.personnel', {
                  url: '/inbox2/{fold}',
                  templateUrl: 'tpl/tra/collaborative_management.personnel.html'
              })
              .state('app.collaborative_management.line', {
                  url: '/inbox3/{fold}',
                  templateUrl: 'tpl/tra/collaborative_management.line.html'
              })
              .state('app.collaborative_management.road', {
                  url: '/inbox4/{fold}',
                  templateUrl: 'tpl/tra/collaborative_management.road.html'
              })
              .state('app.collaborative_management.transport', {
                  url: '/inbox5/{fold}',
                  templateUrl: 'tpl/tra/collaborative_management.transport.html'
              })

              .state('app.waterway_administration', {
                  url: '/waterway_administration',
                  templateUrl: 'tpl/tra/waterway_administration.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/waterway_administration.js']);
                          }]
                  }
              })

              .state('app.zhgj', {
                  url: '/zhgj/:index',
                  templateUrl: 'tpl/tra/zhgj.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/zhgj.js']);
                          }]
                  }
              })

              .state('app.waterwayYunZheng', {
                  url: '/waterwayYunZheng',
                  templateUrl: 'tpl/tra/waterwayYunZheng.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/waterwayYunZheng.js']);
                          }]
                  }
              })
              .state('app.waterwayYunZheng.list', {
                  url: '/waterTransport/{fold}',
                  templateUrl: 'tpl/tra/waterwayYunZheng.list.html'
              })
              .state('app.waterwayYunZheng.waterway', {
                  url: '/waterTransport1/{fold}',
                  templateUrl: 'tpl/tra/waterwayYunZheng.waterway.html'
              })
              .state('app.waterwayYunZheng.auxiliary', {
                  url: '/waterTransport2/{fold}',
                  templateUrl: 'tpl/tra/waterwayYunZheng.auxiliary.html'
              })
              .state('app.waterwayYunZheng.businessHouseholds', {
                  url: '/waterTransport3/{fold}',
                  templateUrl: 'tpl/tra/waterwayYunZheng.businessHouseholds.html'
              })
              .state('app.waterwayYunZheng.ship', {
                  url: '/waterTransport4/{fold}',
                  templateUrl: 'tpl/tra/waterwayYunZheng.ship.html'
              })
              .state('app.waterwayYunZheng.ship1', {
                  url: '/waterTransport5/{fold}',
                  templateUrl: 'tpl/tra/waterwayYunZheng.ship1.html'
              })
              .state('app.waterwayYunZheng.other', {
                  url: '/waterTransport6/{fold}',
                  templateUrl: 'tpl/tra/waterwayYunZheng.other.html'
              })
              .state('app.hunan_transport', {
                  url: '/hunan_transport',
                  templateUrl: 'tpl/tra/hunan_transport.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/hunan_transport.js']);
                          }]
                  }
              })
              .state('app.hunan_information_service', {
                  url: '/hunan_information_service',
                  templateUrl: 'tpl/tra/hunan_information_service.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/hunan_information_service.js']);
                          }]
                  }
              })
              .state('app.hunan_information_service.vehicle', {
                  url: '/hunan/{fold}',
                  templateUrl: 'tpl/tra/hunan_information_service.vehicle.html'
              })
              .state('app.hunan_information_service.complaint', {
                  url: '/hunan1/{fold}',
                  templateUrl: 'tpl/tra/hunan_information_service.complaint.html'
              })
              .state('app.hunan_information_service.petition', {
                  url: '/hunan2/{fold}',
                  templateUrl: 'tpl/tra/hunan_information_service.petition.html'
              })
              .state('app.hunan_information_service.facilities', {
                  url: '/hunan3/{fold}',
                  templateUrl: 'tpl/tra/hunan_information_service.facilities.html'
              })
              .state('app.hunan_information_service.honor', {
                  url: '/hunan4/{fold}',
                  templateUrl: 'tpl/tra/hunan_information_service.honor.html'
              })
              .state('app.hunan_information_service.rules', {
                  url: '/hunan5/{fold}',
                  templateUrl: 'tpl/tra/hunan_information_service.rules.html'
              })
              .state('app.hunan_information_service.employee', {
                  url: '/hunan6/{fold}',
                  templateUrl: 'tpl/tra/hunan_information_service.employee.html'
              })
              .state('app.throughput', {
                  url: '/throughput',
                  templateUrl: 'tpl/tra/throughput.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/throughput.js']);
                          }]
                  }
              })
              .state('app.throughputNextLevel', {
                  abstract: true,
                  url: '/throughputNextLevel',
                  templateUrl: 'tpl/tra/throughputNextLevel.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/throughputNextLevel.js']);
                          }]
                  }
              })
              .state('app.throughputNextLevel.list', {
                  url: '/terminal/{fold}',
                  templateUrl: 'tpl/tra/throughputNextLevel.list.html'
              })
              .state('app.throughputNextLevel.port', {
                  url: '/terminal1/{fold}',
                  templateUrl: 'tpl/tra/throughputNextLevel.port.html'
              })
              .state('app.throughputNextLevel.management', {
                  url: '/terminal2/{fold}',
                  templateUrl: 'tpl/tra/throughputNextLevel.management.html'
              })
              .state('app.water_transportation', {
                  url: '/water_transportation',
                  templateUrl: 'tpl/tra/water_transportation.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/water_transportation.js']);
                          }]
                  }
              })

              .state('app.water_transportationSystem', {
                  url: '/water_transportationSystem',
                  templateUrl: 'tpl/tra/water_transportationSystem.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/water_transportationSystem.js']);
                          }]
                  }
              })

              .state('app.water_transportationSystem.list', {
                  url: '/inbox/{fold},{index}',
                  templateUrl: 'tpl/tra/water_transportationSystem.list.html'
              })
              .state('app.highway', {
                  url: '/highway',
                  templateUrl: 'tpl/tra/highway.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/highway.js']);
                          }]
                  }
              })
              .state('app.highway_project_management', {
                  url: '/highway_project_management',
                  templateUrl: 'tpl/tra/highway_project_management.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/highway_project_management.js']);
                          }]
                  }
              })
              .state('app.highway_project_management_platform', {
                  abstract: true,
                  url: '/highway_project_management_platform',
                  templateUrl: 'tpl/tra/highway_project_management_platform.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/highway_project_management_platform.js']);
                          }]
                  }
              })
              .state('app.highway_project_management_platform.project', {
                  url: '/highwayProject/{fold}',
                  templateUrl: 'tpl/tra/highway_project_management_platform.project.html'
              })
              .state('app.highway_project_management_platform.block', {
                  url: '/highwayProject1/{fold}',
                  templateUrl: 'tpl/tra/highway_project_management_platform.block.html'
              })
              .state('app.highway_project_management_platform.unit', {
                  url: '/highwayProject2/{fold}',
                  templateUrl: 'tpl/tra/highway_project_management_platform.unit.html'
              })
              .state('app.highway_project_management_platform.completion', {
                  url: '/highwayProject3/{fold}',
                  templateUrl: 'tpl/tra/highway_project_management_platform.completion.html'
              })
              .state('app.highway_project_management_platform.parameter', {
                  url: '/highwayProject4/{fold}',
                  templateUrl: 'tpl/tra/highway_project_management_platform.parameter.html'
              })
              .state('app.highway_project_management_platform.engineering', {
                  url: '/highwayProject5/{fold}',
                  templateUrl: 'tpl/tra/highway_project_management_platform.engineering.html'
              })
              .state('app.kylwsp', {
                  url: '/kylwsp',
                  templateUrl: 'tpl/tra/kylwsp.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/kylwsp.js']);
                          }]
                  }
              })
              .state('app.gsglll', {
                  url: '/gsglll',
                  templateUrl: 'tpl/tra/gsglll.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/gsglll.js']);
                          }]
                  }
              })
              .state('access.newUser', {
                  url: '/newUser/:loginName',
                  templateUrl: 'tpl/tra/newUser.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/newUser.js']);
                          }]
                  }
              })
              .state('access.newDepartment', {
                  url: '/newDepartment',
                  templateUrl: 'tpl/tra/newDepartment.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/newDepartment.js']);
                          }]
                  }
              })
              .state('access.newRole', {
                  url: '/newRole/:roleId',
                  templateUrl: 'tpl/tra/newRole.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/newRole.js']);
                          }]
                  }
              })
              .state('access.userList', {
                  url: '/userList',
                  templateUrl: 'tpl/tra/userList.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                          function( $ocLazyLoad ){
                              return $ocLazyLoad.load(['js/controllers/tra/userList.js']);
                          }]
                  }
              })
              .state('app.dashboard-v1', {
                  url: '/dashboard-v1',
                  templateUrl: 'tpl/app_dashboard_v1.html',
                  resolve: {
                    deps: ['$ocLazyLoad',
                      function( $ocLazyLoad ){
                        return $ocLazyLoad.load(['js/controllers/chart.js']);
                    }]
                  }
              })
              .state('app.dashboard-v2', {
                  url: '/dashboard-v2',
                  templateUrl: 'tpl/app_dashboard_v2.html',
                  resolve: {
                    deps: ['$ocLazyLoad',
                      function( $ocLazyLoad ){
                        return $ocLazyLoad.load(['js/controllers/chart.js']);
                    }]
                  }
              })
              .state('app.ui', {
                  url: '/ui',
                  template: '<div ui-view class="fade-in-up"></div>'
              })
              .state('app.ui.buttons', {
                  url: '/buttons',
                  templateUrl: 'tpl/ui_buttons.html'
              })
              .state('app.ui.icons', {
                  url: '/icons',
                  templateUrl: 'tpl/ui_icons.html'
              })
              .state('app.ui.grid', {
                  url: '/grid',
                  templateUrl: 'tpl/ui_grid.html'
              })
              .state('app.ui.widgets', {
                  url: '/widgets',
                  templateUrl: 'tpl/ui_widgets.html'
              })          
              .state('app.ui.bootstrap', {
                  url: '/bootstrap',
                  templateUrl: 'tpl/ui_bootstrap.html'
              })
              .state('app.ui.sortable', {
                  url: '/sortable',
                  templateUrl: 'tpl/ui_sortable.html'
              })
              .state('app.ui.portlet', {
                  url: '/portlet',
                  templateUrl: 'tpl/ui_portlet.html'
              })
              .state('app.ui.timeline', {
                  url: '/timeline',
                  templateUrl: 'tpl/ui_timeline.html'
              })
              .state('app.ui.tree', {
                  url: '/tree',
                  templateUrl: 'tpl/ui_tree.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                        function( $ocLazyLoad ){
                          return $ocLazyLoad.load('angularBootstrapNavTree').then(
                              function(){
                                 return $ocLazyLoad.load('js/controllers/tree.js');
                              }
                          );
                        }
                      ]
                  }
              })
              .state('app.ui.toaster', {
                  url: '/toaster',
                  templateUrl: 'tpl/ui_toaster.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                        function( $ocLazyLoad){
                          return $ocLazyLoad.load('toaster').then(
                              function(){
                                 return $ocLazyLoad.load('js/controllers/toaster.js');
                              }
                          );
                      }]
                  }
              })
              .state('app.ui.jvectormap', {
                  url: '/jvectormap',
                  templateUrl: 'tpl/ui_jvectormap.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                        function( $ocLazyLoad){
                          return $ocLazyLoad.load('js/controllers/vectormap.js');
                      }]
                  }
              })
              .state('app.ui.googlemap', {
                  url: '/googlemap',
                  templateUrl: 'tpl/ui_googlemap.html',
                  resolve: {
                      deps: ['uiLoad',
                        function( uiLoad ){
                          return uiLoad.load( [
                            'js/app/map/load-google-maps.js',
                            'js/app/map/ui-map.js',
                            'js/app/map/map.js'] ).then(
                              function(){
                                return loadGoogleMaps(); 
                              }
                            );
                      }]
                  }
              })
              .state('app.chart', {
                  url: '/chart',
                  templateUrl: 'tpl/ui_chart.html',
                  resolve: {
                      deps: ['uiLoad',
                        function( uiLoad){
                          return uiLoad.load('js/controllers/chart.js');
                      }]
                  }
              })
              // table
              .state('app.table', {
                  url: '/table',
                  template: '<div ui-view></div>'
              })
              .state('app.table.static', {
                  url: '/static',
                  templateUrl: 'tpl/table_static.html'
              })
              .state('app.table.datatable', {
                  url: '/datatable',
                  templateUrl: 'tpl/table_datatable.html'
              })
              .state('app.table.footable', {
                  url: '/footable',
                  templateUrl: 'tpl/table_footable.html'
              })
              .state('app.table.grid', {
                  url: '/grid',
                  templateUrl: 'tpl/table_grid.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                        function( $ocLazyLoad ){
                          return $ocLazyLoad.load('ngGrid').then(
                              function(){
                                  return $ocLazyLoad.load('js/controllers/grid.js');
                              }
                          );
                      }]
                  }
              })
              // form
              .state('app.form', {
                  url: '/form',
                  template: '<div ui-view class="fade-in"></div>',
                  resolve: {
                      deps: ['uiLoad',
                        function( uiLoad){
                          return uiLoad.load('js/controllers/form.js');
                      }]
                  }
              })
              .state('app.form.elements', {
                  url: '/elements',
                  templateUrl: 'tpl/form_elements.html'
              })
              .state('app.form.validation', {
                  url: '/validation',
                  templateUrl: 'tpl/form_validation.html'
              })
              .state('app.form.wizard', {
                  url: '/wizard',
                  templateUrl: 'tpl/form_wizard.html'
              })
              .state('app.form.fileupload', {
                  url: '/fileupload',
                  templateUrl: 'tpl/form_fileupload.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                        function( $ocLazyLoad){
                          return $ocLazyLoad.load('angularFileUpload').then(
                              function(){
                                 return $ocLazyLoad.load('js/controllers/file-upload.js');
                              }
                          );
                      }]
                  }
              })
              .state('app.form.imagecrop', {
                  url: '/imagecrop',
                  templateUrl: 'tpl/form_imagecrop.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                        function( $ocLazyLoad){
                          return $ocLazyLoad.load('ngImgCrop').then(
                              function(){
                                 return $ocLazyLoad.load('js/controllers/imgcrop.js');
                              }
                          );
                      }]
                  }
              })
              .state('app.form.select', {
                  url: '/select',
                  templateUrl: 'tpl/form_select.html',
                  controller: 'SelectCtrl',
                  resolve: {
                      deps: ['$ocLazyLoad',
                        function( $ocLazyLoad ){
                          return $ocLazyLoad.load('ui.select').then(
                              function(){
                                  return $ocLazyLoad.load('js/controllers/select.js');
                              }
                          );
                      }]
                  }
              })
              .state('app.form.slider', {
                  url: '/slider',
                  templateUrl: 'tpl/form_slider.html',
                  controller: 'SliderCtrl',
                  resolve: {
                      deps: ['$ocLazyLoad',
                        function( $ocLazyLoad ){
                          return $ocLazyLoad.load('vr.directives.slider').then(
                              function(){
                                  return $ocLazyLoad.load('js/controllers/slider.js');
                              }
                          );
                      }]
                  }
              })
              .state('app.form.editor', {
                  url: '/editor',
                  templateUrl: 'tpl/form_editor.html',
                  controller: 'EditorCtrl',
                  resolve: {
                      deps: ['$ocLazyLoad',
                        function( $ocLazyLoad ){
                          return $ocLazyLoad.load('textAngular').then(
                              function(){
                                  return $ocLazyLoad.load('js/controllers/editor.js');
                              }
                          );
                      }]
                  }
              })
              // pages
              .state('app.page', {
                  url: '/page',
                  template: '<div ui-view class="fade-in-down"></div>'
              })
              .state('app.page.profile', {
                  url: '/profile',
                  templateUrl: 'tpl/page_profile.html'
              })
              .state('app.page.post', {
                  url: '/post',
                  templateUrl: 'tpl/page_post.html'
              })
              .state('app.page.search', {
                  url: '/search',
                  templateUrl: 'tpl/page_search.html'
              })
              .state('app.page.invoice', {
                  url: '/invoice',
                  templateUrl: 'tpl/page_invoice.html'
              })
              .state('app.page.price', {
                  url: '/price',
                  templateUrl: 'tpl/page_price.html'
              })
              .state('app.docs', {
                  url: '/docs',
                  templateUrl: 'tpl/docs.html'
              })
              // others
              .state('lockme', {
                  url: '/lockme',
                  templateUrl: 'tpl/page_lockme.html'
              })
              .state('access', {
                  url: '/access',
                  template: '<div ui-view class="fade-in-right-big smooth"></div>'
              })
              .state('access.signin', {
                  url: '/signin',
                  templateUrl: 'tpl/page_signin.html',
                  resolve: {
                      deps: ['uiLoad',
                        function( uiLoad ){
                          return uiLoad.load( ['js/controllers/signin.js'] );
                      }]
                  }
              })
              .state('access.signup', {
                  url: '/signup',
                  templateUrl: 'tpl/page_signup.html',
                  resolve: {
                      deps: ['uiLoad',
                        function( uiLoad ){
                          return uiLoad.load( ['js/controllers/signup.js'] );
                      }]
                  }
              })
              .state('access.forgotpwd', {
                  url: '/forgotpwd',
                  templateUrl: 'tpl/page_forgotpwd.html'
              })
              .state('access.404', {
                  url: '/404',
                  templateUrl: 'tpl/page_404.html'
              })

              // fullCalendar
              .state('app.calendar', {
                  url: '/calendar',
                  templateUrl: 'tpl/app_calendar.html',
                  // use resolve to load other dependences
                  resolve: {
                      deps: ['$ocLazyLoad', 'uiLoad',
                        function( $ocLazyLoad, uiLoad ){
                          return uiLoad.load(
                            ['vendor/jquery/fullcalendar/fullcalendar.css',
                              'vendor/jquery/fullcalendar/theme.css',
                              'vendor/jquery/jquery-ui-1.10.3.custom.min.js',
                              'vendor/libs/moment.min.js',
                              'vendor/jquery/fullcalendar/fullcalendar.min.js',
                              'js/app/calendar/calendar.js']
                          ).then(
                            function(){
                              return $ocLazyLoad.load('ui.calendar');
                            }
                          )
                      }]
                  }
              })

              // mail
              .state('app.mail', {
                  abstract: true,
                  url: '/mail',
                  templateUrl: 'tpl/mail.html',
                  // use resolve to load other dependences
                  resolve: {
                      deps: ['uiLoad',
                        function( uiLoad ){
                          return uiLoad.load( ['js/app/mail/mail.js',
                                               'js/app/mail/mail-service.js',
                                               'vendor/libs/moment.min.js'] );
                      }]
                  }
              })
              .state('app.mail.list', {
                  url: '/inbox/{fold}',
                  templateUrl: 'tpl/mail.list.html'
              })
              .state('app.mail.detail', {
                  url: '/{mailId:[0-9]{1,4}}',
                  templateUrl: 'tpl/mail.detail.html'
              })
              .state('app.mail.compose', {
                  url: '/compose',
                  templateUrl: 'tpl/mail.new.html'
              })
              .state('layout', {
                  abstract: true,
                  url: '/layout',
                  templateUrl: 'tpl/layout.html'
              })
              .state('layout.fullwidth', {
                  url: '/fullwidth',
                  views: {
                      '': {
                          templateUrl: 'tpl/layout_fullwidth.html'
                      },
                      'footer': {
                          templateUrl: 'tpl/layout_footer_fullwidth.html'
                      }
                  },
                  resolve: {
                      deps: ['uiLoad',
                        function( uiLoad ){
                          return uiLoad.load( ['js/controllers/vectormap.js'] );
                      }]
                  }
              })
              .state('layout.mobile', {
                  url: '/mobile',
                  views: {
                      '': {
                          templateUrl: 'tpl/layout_mobile.html'
                      },
                      'footer': {
                          templateUrl: 'tpl/layout_footer_mobile.html'
                      }
                  }
              })
              .state('layout.app', {
                  url: '/app',
                  views: {
                      '': {
                          templateUrl: 'tpl/layout_app.html'
                      },
                      'footer': {
                          templateUrl: 'tpl/layout_footer_fullwidth.html'
                      }
                  },
                  resolve: {
                      deps: ['uiLoad',
                        function( uiLoad ){
                          return uiLoad.load( ['js/controllers/tab.js'] );
                      }]
                  }
              })
              .state('apps', {
                  abstract: true,
                  url: '/apps',
                  templateUrl: 'tpl/layout.html'
              })
              .state('apps.note', {
                  url: '/note',
                  templateUrl: 'tpl/apps_note.html',
                  resolve: {
                      deps: ['uiLoad',
                        function( uiLoad ){
                          return uiLoad.load( ['js/app/note/note.js',
                                               'vendor/libs/moment.min.js'] );
                      }]
                  }
              })
              .state('apps.contact', {
                  url: '/contact',
                  templateUrl: 'tpl/apps_contact.html',
                  resolve: {
                      deps: ['uiLoad',
                        function( uiLoad ){
                          return uiLoad.load( ['js/app/contact/contact.js'] );
                      }]
                  }
              })
              .state('app.weather', {
                  url: '/weather',
                  templateUrl: 'tpl/apps_weather.html',
                  resolve: {
                      deps: ['$ocLazyLoad',
                        function( $ocLazyLoad ){
                          return $ocLazyLoad.load(
                              {
                                  name: 'angular-skycons',
                                  files: ['js/app/weather/skycons.js',
                                          'vendor/libs/moment.min.js', 
                                          'js/app/weather/angular-skycons.js',
                                          'js/app/weather/ctrl.js' ] 
                              }
                          );
                      }]
                  }
              })
              .state('music', {
                  url: '/music',
                  templateUrl: 'tpl/music.html',
                  controller: 'MusicCtrl',
                  resolve: {
                      deps: ['$ocLazyLoad',
                        function( $ocLazyLoad ){
                          return $ocLazyLoad.load([
                            'com.2fdevs.videogular', 
                            'com.2fdevs.videogular.plugins.controls', 
                            'com.2fdevs.videogular.plugins.overlayplay',
                            'com.2fdevs.videogular.plugins.poster',
                            'com.2fdevs.videogular.plugins.buffering',
                            'js/app/music/ctrl.js', 
                            'js/app/music/theme.css'
                          ]);
                      }]
                  }
              })
              .state('music.home', {
                    url: '/home',
                    templateUrl: 'tpl/music.home.html'
                })
              .state('music.genres', {
                    url: '/genres',
                    templateUrl: 'tpl/music.genres.html'
                })
              .state('music.detail', {
                    url: '/detail',
                    templateUrl: 'tpl/music.detail.html'
                })
              .state('music.mtv', {
                    url: '/mtv',
                    templateUrl: 'tpl/music.mtv.html'
                })
              .state('music.mtvdetail', {
                    url: '/mtvdetail',
                    templateUrl: 'tpl/music.mtv.detail.html'
                })
              .state('music.playlist', {
                    url: '/playlist/{fold}',
                    templateUrl: 'tpl/music.playlist.html'
                })
      }
    ]
  );