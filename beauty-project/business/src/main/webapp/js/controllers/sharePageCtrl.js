angular.module('controllers',[]).controller('sharePageCtrl',
    ['$scope','$rootScope','$stateParams','$state','GetQRCodeURL','BusinessUtil',
        function ($scope,$rootScope,$stateParams,$state,GetQRCodeURL,BusinessUtil) {

            $rootScope.title = "分享赚钱";

            $scope.param = {
                imgs:{},
                weixinShareInfo:{},
                ctx : {},
                mainImg:{},
                canvas:{}
            };

            var calcHeight = function(obj, w)
            {
                return w / obj.width * obj.height;
            };

            //绘制$scope.param.canvas
            var drawImage = function(){
                //背景图
                $scope.param.ctx.drawImage($scope.param.imgs.bg, 0, 0, $scope.param.canvas.width, $scope.param.canvas.height);
                //头像
                $scope.param.ctx.drawImage($scope.param.imgs.via, $scope.param.canvas.width*0.06, $scope.param.canvas.width*0.08, $scope.param.canvas.width*0.23, calcHeight($scope.param.imgs.via, $scope.param.canvas.width*0.23));
                //昵称
                //颜色
                $scope.param.ctx.fillStyle = '#000';
                // //字体设置 三个参数，font-weight font-size font-family
                $scope.param.ctx.font = '40px microsoft yahei';
                $scope.param.ctx.fillText('我的店铺', $scope.param.canvas.width*0.33, $scope.param.canvas.width*0.15);
                // //说明
                $scope.param.ctx.font = '23px microsoft yahei';
                $scope.param.ctx.fillText('美享99', $scope.param.canvas.width*0.33, $scope.param.canvas.width*0.25);
                // //身份
                $scope.param.ctx.fillText('店主', $scope.param.canvas.width*0.33, $scope.param.canvas.width*0.3);
                //二维码
                $scope.param.ctx.drawImage($scope.param.imgs.qrCode, $scope.param.canvas.width*0.08, $scope.param.canvas.height*0.75, $scope.param.canvas.width*0.32, calcHeight($scope.param.imgs.qrCode, $scope.param.canvas.width*0.32));
                //二维码有效期限
                $scope.param.ctx.fillStyle = '#888888';
                $scope.param.ctx.font = '20px microsoft yahei';
                $scope.param.ctx.fillText('二维码的有效期为30天', $scope.param.canvas.width*0.1, $scope.param.canvas.height*0.95);
                //获取base64格式的src
                var imgSrc = $scope.param.canvas.toDataURL('image/jpg');
                 $scope.param.mainImg.src = imgSrc;
                $("#canvas").hide();
            }

            var drawInto = function(){
                var imgNum = 0;
                for(var key in $scope.param.imgs){
                    var img = new Image();
                    img.src = $scope.param.imgs[key];
                    $scope.param.imgs[key] = img;
                    $scope.param.imgs[key].onload = function(){
                        imgNum++;
                        if(imgNum == Object.keys($scope.param.imgs).length) drawImage();
                    }
                }
            }

            $scope.$on('$ionicView.enter', function(){

                GetQRCodeURL.get(function (data) {
                    BusinessUtil.checkResponseData(data,'sharePage');

                    $scope.param.weixinShareInfo = data.responseData;

                    //获取$scope.param.canvas
                    $scope.param.canvas = document.getElementById('canvas');

                    //设置宽高
                    //想获取高清图请*2，一般的直接等于Width就行
                    var Height = window.innerHeight*2;
                    var Width = window.innerWidth*2;

                    //$scope.param.canvas绘制需要的对象
                    $scope.param.ctx = $scope.param.canvas.getContext("2d");
                    $scope.param.canvas.width = Width;
                    $scope.param.canvas.height = Height;

                    //获取图片
                    $scope.param.mainImg = document.getElementById('mainImg');

                    //获取图片
                    $scope.param.imgs = {
                        bg: 'images/sharePage/bgs.jpg', //大背景
                        via:  $scope.param.weixinShareInfo.userImage, //'img/people.jpg', //头像
                        qrCode: $scope.param.weixinShareInfo.qrCodeURL //.shareCode //二维码
                    }
                    //载入图片
                    drawInto();
                })

            })
        }])