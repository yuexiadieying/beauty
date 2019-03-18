define(['appEducation','jquery'], function (app,$) {
    app
        .directive('educationHead', ['$rootScope','$state',
            function ($rootScope,$state) {
                return {
                    restrict: 'EAC',
                    replace: true,
                    template: '<header><div style="float:left;margin-top:4%;margin-left:2%;font-size:0.34rem;" ' +
                    'ng-click="return()">&lt; 返回</div> <h1>{{elderName}}</h1> <div style="float:right;' +
                    'margin-top:4%;font-size:0.34rem;margin-right:2%;"ng-click="enterService()">服务 ></div></header>',
                    link: function(scope,ele,attrs) {

                        scope.return = function(){
                            connectWebViewJavascriptBridge(function() {
                                window.WebViewJavascriptBridge.callHandler('returnNative','',function(responseData) {});});
                        }

                        scope.enterService = function(){
                            window.location.href = "ionic#/healthServiceList";
                        }


                    }
                }
        }])
})
