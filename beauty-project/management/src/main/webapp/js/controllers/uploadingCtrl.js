angular.module('controllers',[]).controller('uploadingCtrl',
    ['$scope','$interval','$rootScope','$stateParams','$state','Global','$timeout','ImageUploadToOSS',"$http",'AddOfflineProduct','$filter','ManagementUtil',
        function ($scope,$interval,$rootScope,$stateParams,$state,Global,$timeout,ImageUploadToOSS,$http,AddOfflineProduct,$filter,ManagementUtil) {
           var status = document.querySelector(".status");
            var postage = document.querySelector("#postage");
            var service = document.querySelectorAll(".service input[type='checkbox']");
            var serviceText = document.querySelectorAll(".service p label");
            var address = document.querySelector("#address").value;
            var address1 = document.querySelector("#address");
            var description = document.querySelector(".description");
            $scope.mess = false;
            $scope.ProductDTO = {
                productName:"",
                brand:"",
                type:"offline",
                secondType:"",
                description:"",
                price:"",
                status:"",
                firstUrl:"",
                createDate:$filter("date")(Date.parse(new Date()),"yyyy-MM-dd HH:mm:ss"),
                productDetail:{
                    listPic:[],
                    detailPic:[],
                    tag:[],
                    spec:[],
                    services:[],
                    senderAddress:""

                }


            };
            $scope.upload=function(){
                if($scope.hintPic1 ==""||$scope.hintPic2 ==""||$scope.hintPic3==""){
                    $scope.mess = true;
                    return;
                }


                 var index=address1.selectedIndex;
                    $scope.ProductDTO.productDetail.senderAddress = address1.options[index].value
                    var indexStatus = status.selectedIndex;
                    $scope.ProductDTO.status = status.options[indexStatus].value
                    if(postage.checked == true){
                        $scope.ProductDTO.productDetail.tag[0]="包邮"
                    }else{
                        $scope.ProductDTO.productDetail.tag[0]="不包邮"
                    };
                    /*服务*/
                    $scope.ProductDTO.productDetail.services=[];
                    for(var j=0;j<service.length;j++){

                        if(service[j].checked == true){
                            $scope.ProductDTO.productDetail.services[j]=serviceText[j].innerHTML
                        }
                    }
                    if($scope.ProductDTO.productName ==""||$scope.ProductDTO.brand ==""||$scope.ProductDTO.secondType ==""||$scope.ProductDTO.description ==""||$scope.ProductDTO.price ==""||$scope.ProductDTO.price ==null||$scope.ProductDTO.status ==""||$scope.ProductDTO.firstUrl.length<=-1||$scope.ProductDTO.productDetail.listPic.length<=0||$scope.ProductDTO.productDetail.detailPic =="[]"||$scope.ProductDTO.productDetail.spec.length<=0){
                        $scope.mess = true;
                    }else{

                        AddOfflineProduct.save($scope.ProductDTO,function(data){
                            ManagementUtil.checkResponseData(data,"");
                            if(data.errorInfo == Global.SUCCESS){
                                $state.go("home");
                            }
                        })
                    }
            };
/*删除图片*/
            function remove (name,picArr,id,div){
                var img = document.querySelectorAll(name);
                var patter = document.querySelector(id);
                var div = document.querySelectorAll(div);
                for(var i=0;i<img.length;i++){
                    img[i].onclick = function(){
                        change(this);
                    }
                }
                function change(obj){
                    for(var i=0;i<img.length;i++){
                        if(img[i]==obj){
                            if(id!="#publicityPic"){
                                $scope.ProductDTO.productDetail[picArr].splice(i,1);
                            }else{
                                $scope.ProductDTO.firstUrl=''
                            }

                            patter.removeChild(div[i]);
                            if($scope.ProductDTO.firstUrl==""){
                                $scope.hintPic3 ="";
                            }
                            if($scope.ProductDTO.productDetail.listPic.length<=0){
                                $scope.hintPic1 ="";
                            }
                            if($scope.ProductDTO.productDetail.detailPic.length<=0){
                                $scope.hintPic2 ="";
                            }
                            remove("#publicityPic .falsePic","firstUrl","#publicityPic","#publicityPic div");
                            remove("#particulars_viewPic .falsePic","detailPic","#particulars_viewPic","#particulars_viewPic div");
                            remove("#list_viewPic .falsePic","listPic","#list_viewPic","#list_viewPic div");
                        }
                    }

                }
            }
            /*添加型号*/
            $scope.type=function(){
                $scope.flag = true;
            };
            $scope.typeTrue = function(){
                var col = document.querySelector(".col").value;
                $scope.flag = false;
                if(col=='')return;
                $scope.ProductDTO.productDetail.spec.push(col);
                document.querySelector(".col").value=""
            };
            /*删除型号*/
            $scope.index = -1;
            $scope.delType=function(name,index){
                $scope.index = index;
                $scope.colName=name;
                $scope.flagDel =true
            };
            $scope.typeDelTrue = function(){
                if($scope.index>-1){
                    $scope.ProductDTO.productDetail.spec.splice($scope.index,1)
                }
                $scope.flagDel=false;
            };
            $scope.bgAll=function(){
                $scope.flag = false;
                $scope.flagDel = false
            };

            $scope.hintPic1 ="";
            $scope.hintPic2 ="";
            $scope.hintPic3="";
            $scope.uploadingPic = function(id,big,type){
                var input = document.getElementById(id);
                var big1 = document.getElementById(big);
                var result,div;
                if(typeof FileReader==='undefined'){
                    result.innerHTML = "抱歉，你的浏览器不支持 FileReader";
                    input.setAttribute('disabled','disabled');
                }else{
                    input.addEventListener('change',readFile,false);
                }
                function readFile(){
                   /* var as = big1.querySelectorAll('.as' );
                    if(as !=undefined){
                        for(var i=0;i<as.length;i++){
                            big1.removeChild(as[i])
                        }
                    }*/
                    if(id=="list_view"){
                        $scope.hintPic1="";
                    }else if(id=="particulars_view"){
                        $scope.hintPic2="";
                    }else if(id=="publicity"){
                        $scope.hintPic3="";

                    }
                    for(var i=0;i<this.files.length;i++){
                        if (!input['value'].match(/.jpg|.gif|.png|.bmp/i)){
                            return alert("上传的图片格式不正确，请重新选择")
                        }
                        var reader = new FileReader();
                        reader.readAsDataURL(this.files[i]);
                        reader.onload = function(e){
                            result = '<img src="'+this.result+'" alt=""/>';
                            div = document.createElement('div');
                            div.className="as";
                            var img1 = document.createElement('img');
                            img1.src = "images/cha.png";
                            img1.className="falsePic";
                            div.innerHTML = result;
                            div.appendChild(img1);
                            big1.appendChild(div);
                        }
                    }

                    ptoductType = "offlineProduct/";

                    var MultipartFile = new FormData();
                    MultipartFile.append("folder",ptoductType);
                    for(var i=0;i<this.files.length;i++){
                        var reader = new FileReader();
                        reader.readAsDataURL(this.files[i]);
                        MultipartFile.append("listFile",this.files[i]);
                    }
                    var url = "operation/imageUploadToOSS";
                    $http.post(url,MultipartFile,{
                        transformRequest: angular.identity,
                        headers: {
                            'Content-Type': undefined
                        }
                    }).success(function(data) {
                        ManagementUtil.checkResponseData(data,"");
                        if(data.errorInfo == Global.SUCCESS){

                            if(id=="list_view"){
                                $scope.hintPic1="images/true.png";
                                $scope.ProductDTO.productDetail.listPic= $scope.ProductDTO.productDetail.listPic.concat(data.responseData);
                                remove("#list_viewPic .falsePic","listPic","#list_viewPic","#list_viewPic div"); $scope.success=1;
                            }else if(id=="particulars_view"){
                                $scope.hintPic2="images/true.png";
                                $scope.ProductDTO.productDetail.detailPic=$scope.ProductDTO.productDetail.detailPic.concat(data.responseData);
                                remove("#particulars_viewPic .falsePic","detailPic","#particulars_viewPic","#particulars_viewPic div");
                                $scope.success=2;
                            }else if(id=="publicity"){
                                $scope.ProductDTO.firstUrl= data.responseData[0];
                                $scope.hintPic3="images/true.png";
                                remove("#publicityPic .falsePic","firstUrl","#publicityPic","#publicityPic div");
                                $scope.success=3;
                            }
                        }else{
                            alert("上传图片失败")
                        }

                    });
                }
            };
            $scope.uploadingPic("publicity","publicityPic","firstUrl");
            $scope.uploadingPic("list_view","list_viewPic","listPic");
            $scope.uploadingPic("particulars_view","particulars_viewPic","detailPic");
        }]);