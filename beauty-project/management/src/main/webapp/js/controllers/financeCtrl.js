angular.module('controllers',[]).controller('financeCtrl',
    ['$scope','$interval','$rootScope','$stateParams','$state','Global','$timeout','QueryPayRecordsByParameters','ManagementUtil',
        function ($scope,$interval,$rootScope,$stateParams,$state,Global,$timeout,QueryPayRecordsByParameters,ManagementUtil) {
            $scope.bills = "";
            $scope.order = "";
            $scope.mum = true;
            var orderCompleteStart = document.querySelector(".StreamNumberStart");
            var orderCompleteEnd = document.querySelector(".StreamNumberEnd");
            var orderPayStart  = document.querySelector(".orderPayStart");
            var orderPayEnd  = document.querySelector(".orderPayEnd");



/*日期插件*/
        $scope.dataS =  function(id){
            !function(id){
                laydate.skin('danlan');//切换皮肤，请查看skins下面皮肤库
                laydate({elem: id});//绑定元素
            }();

            //日期范围限制
            var start = {
                   elem: '#start',
                   format: 'YYYY-MM-DD',
                   min: laydate.now(), //设定最小日期为当前日期
                   max: '2099-06-16', //最大日期
                   istime: true,
                   istoday: false,
                   choose: function(datas){
                       end.min = datas; //开始日选好后，重置结束日的最小日期
                       end.start = datas //将结束日的初始值设定为开始日
                   }
               };

            var end = {
                   elem: '#end',
                   format: 'YYYY-MM-DD',
                   min: laydate.now(),
                   max: '2099-06-16',
                   istime: true,
                   istoday: false,
                   choose: function(datas){
                       start.max = datas; //结束日选好后，充值开始日的最大日期
                   }
               };
            laydate(start);
            laydate(end);
        };

/*搜索*/
         $scope.searchBills = function(){
              $scope.loadPageList();
             $scope.choosePage(1)
            };
/*展示*/
/*transactionIdOrOrderId：bills（账单编号）
*                       ：order（订单编号）
* type:0   时间不参与搜索；
       1   付款时间
       2   完成时间               *
**/
         $scope.loadPageList = function(){
             var orderComplete = orderCompleteStart.value+orderCompleteEnd.value;
             var orderPay = orderPayStart.value+orderPayEnd.value;
             if(orderComplete !=""&&orderPay!=""){
                 var startTime = orderCompleteStart.value;
                 var endTime = orderCompleteEnd.value;
                 var type=2
             }else if(orderComplete !=""){
                 var startTime = orderCompleteStart.value;
                 var endTime = orderCompleteEnd.value;
                 var type=2
             }else if(orderPay!=""){
                 var startTime = orderPayStart.value;
                 var endTime = orderPayEnd.value;
                 var type=1
             }else{
                 var startTime = "";
                 var endTime = "";
                 var type=0
             }
             QueryPayRecordsByParameters.get({
                 pageNo : $scope.pageNo,
                 pageSize :$scope.pageSize,
                 startTime:startTime,
                 endTime:endTime,
                 transactionIdOrOrderId:$scope.order+$scope.bills,
                 type:type
             },function(data){
                 ManagementUtil.checkResponseData(data,"");
                 if(data.result == Global.SUCCESS){
                     $scope.finance = data.responseData.responseData;
                     $scope.response = {};
                     $scope.response.count = data.responseData.totalCount;
                     $scope.param.pageFrom = ($scope.pageNo-1)*$scope.pageSize+1;
                     $scope.param.pageTo = ($scope.pageNo-1)*$scope.pageSize+$scope.pageSize;
                     $scope.mum = false;
                    /* $scope.bills = "";
                     $scope.order = "";
                     orderCompleteStart.value='';
                     orderCompleteEnd.value='';
                     orderPayStart.value='';
                     orderPayEnd.value='';*/
                     }
                 })
             };
        }]);
