angular.module('controllers',[]).controller('educationVacationCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil) {

        $rootScope.title = "请假";
        $scope.showOrgan = false;
        $scope.showFloat = false;
        $scope.vacationMap = {};

        var vacation;
        var startTime;
        var endTime;

        //类型
        var vacationType = [
            {content : "病假"},
            {content : "事假"}
        ];

        //去向
        var vacationDirection = [
            {content : "家"},
            {content : "宿舍"},
            {content : "医院"}
        ];

        //原因
        var vacationCause = [
            {content : "感冒"},
            {content : "回家看世界杯"}
        ];

            //这是不可选的日期列表
            var disabledDates = [
                new Date(1437719836326),
                new Date(),
                new Date(2016, 7, 10), //months are 0-based, this is August, 10th!
                new Date('Wednesday, August 12, 2015'), //Works with any valid Date formats like long format
                new Date("08-14-2016"), //Short format
                new Date(1439676000000) //UNIX format
            ];
            //方便的年月日设置方式，正和我意，可以随便改了。
            var weekDaysList = ["日", "一", "二", "三", "四", "五", "六"];
            //默认值：["S", "M", "T", "W", "T", "F", "S"];
            var monthList = ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"];
            //默认值：["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

            //日期选择后的回调函数
            var startObjectCallbacks = function (val) {
                if (typeof (val) === 'undefined') {
                } else {
                    startTime = new Date(val).getTime();
                    console.log('Selected date is : ', startTime);
                    $scope.startObject.inputDate = val;  //这行官网没有，不设置 的话，选中日期不能回填到页面。
                }
            };

            var endObjectCallbacks = function (val) {
                if (typeof (val) === 'undefined') {
                } else {
                    endTime = new Date(val).getTime();
                    console.log('Selected date is : ', endTime);
                    $scope.endObject.inputDate = val;  //这行官网没有，不设置 的话，选中日期不能回填到页面。
                    $scope.vacationMap.vacationTime = Math.floor((endTime - startTime) / 86400000) + "天";
                }
            };
            //主体对象
            $scope.startObject = {
                titleLabel: '选择日期',  //可选
                closeButtonType:'button-assertive',//可选
                setButtonType: 'button-assertive',  //可选
                todayButtonType: 'button-assertive',  //可选
                inputDate: new Date(),  //可选，输入值
                sundayFirst: true,  //可选,星期一开头
                //disabledDates: disabledDates, //可选,不可选的日期
                weekDaysList: weekDaysList, //可选
                monthList: monthList, //可选
                templateType: 'popup', //可选i.e.的模式 modal or popup(兼容模式？)
                showTodayButton: 'true', //可选
                modalHeaderColor: 'bar-positive', //可选
                modalFooterColor: 'bar-positive', //可选
                from: new Date(2008, 8, 2), //可选
                to: new Date(2030, 8, 25),  //可选
                callback: function (val) {  //Mandatory
                    startObjectCallbacks(val);
                },
                dateFormat: 'yyyy-MM-dd', //可选
                closeOnSelect: true, //可选,设置选择日期后是否要关掉界面。呵呵，原本是false。
            };


            $scope.endObject = {
                titleLabel: '选择日期',  //可选
                closeButtonType:'button-assertive',//可选
                setButtonType: 'button-assertive',  //可选
                todayButtonType: 'button-assertive',  //可选
                inputDate: new Date(),  //可选，输入值
                sundayFirst: true,  //可选,星期一开头
                //disabledDates: disabledDates, //可选,不可选的日期
                weekDaysList: weekDaysList, //可选
                monthList: monthList, //可选
                templateType: 'popup', //可选i.e.的模式 modal or popup(兼容模式？)
                showTodayButton: 'true', //可选
                modalHeaderColor: 'bar-positive', //可选
                modalFooterColor: 'bar-positive', //可选
                from: new Date(2008, 8, 2), //可选
                to: new Date(2030, 8, 25),  //可选
                callback: function (val) {  //Mandatory
                    endObjectCallbacks(val);
                },
                dateFormat: 'yyyy-MM-dd', //可选
                closeOnSelect: true, //可选,设置选择日期后是否要关掉界面。呵呵，原本是false。
            };

            $scope.$on('$ionicView.enter', function(){

        });

        
        //请假类型
        $scope.goVacation = function (type) {
            vacation = type;
            if(0 === type){
                $scope.vacationList = vacationType;
            }
            else if(1 === type){
                $scope.vacationList = vacationDirection;
            }
            else if(2 === type){
                $scope.vacationList = vacationCause;
            }
            $scope.showFloat = true;
            $scope.showOrgan = true;
        }
        
        //请假时间
        $scope.goVacationTime = function (time) {

            if("start" === time){

            }
            else if("end" === time){

            }
        }    

        //
        $scope.changeOrganItem = function (index) {
            $scope.showOrgan = false;
            $scope.showFloat = false;
            if(0 === vacation){
                $scope.vacationMap.type = $scope.vacationList[index].content;
            }
            else if(1 === vacation){
                $scope.vacationMap.de = $scope.vacationList[index].content;
            }
            else if(2 === vacation){
                $scope.vacationMap.case = $scope.vacationList[index].content;
            }
        }
        
        //
        $scope.goHistoryVacation = function () {
            $state.go("studentHistoryVacationList");
        }
        
        //
        $scope.submitVacation = function () {
            $state.go("studentVacationDetail", {vacateId : 0});
        }

}]);
