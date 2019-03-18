angular.module('controllers',[]).controller('operationUploadingCtrl',
    ['$scope','$interval','$rootScope','$stateParams','$state','Global','$timeout','$http','ManagementUtil',
        function ($scope,$interval,$rootScope,$stateParams,$state,Global,$timeout,$http,ManagementUtil) {
            $scope.hintPic = "";
            var a =1;
            $scope.param={
                className:"拓客新思维",
                section:"第一课",
                minutia:"第一节",
                introduce:"系统课程",
                address:""
            }
/*上传视频*/
            $scope.activeBtn = function(){
                $scope.hintPic = "";
                $scope.blueBgLight="";
            }
            $scope.onFileSelect = function (files) {
                $scope.myFile = files;
            };
            $scope.uploadFile = function(){
                a++;
                if(a!=2){
                    alert("视频正在奔跑中...  请稍后");
                    return;
                }
                $scope.blueBgLight="blueBg";
                var file = $scope.myFile;
                var wav = document.querySelector(".wav").value;
                if (!wav.match(/.mp4|.mpeg|.avi|.rm|.wmv|.mov/i)){　　//判断上传文件格式
                    return alert("上传的图片格式不正确，请重新选择")
                }
                var uploadUrl = "operation/aviUploadToOSS";
                var File = new FormData();
                for(var i=0;i<file.length;i++){
                    File.append("listFile",file[i]);
                }
                $http.post(uploadUrl, File, {
                    transformRequest: angular.identity,
                    headers: {'Content-Type': undefined}
                }).success(function(data){
                    ManagementUtil.checkResponseData(data,"");
                    if(data.result!=undefined){
                         $scope.hintPic="images/true.png";
                         $scope.param.address=data.errorInfo;
                         a=1;
                    }else{
                         $scope.hintPic="images/false.png"
                    }
                }).error(function(){
                         $scope.hintPic="images/false.png"
                })
            };
           $scope.submit = function(){
                  $state.go("operation")
           }


        }]).directive('ngFileSelect', [ '$parse', '$timeout', function($parse, $timeout) {
                return function(scope, elem, attr) {
                    var fn = $parse(attr['ngFileSelect']);
                    elem.bind('change', function(evt) {
                        var files = [], fileList, i;
                        fileList = evt.target.files;
                        if (fileList != null) {
                            for (i = 0; i < fileList.length; i++) {
                                files.push(fileList.item(i));
                            }
                        }
                        $timeout(function() {
                            fn(scope, {
                                $files : files,
                                $event : evt
                            });
                        });
                    });
                };
}]);