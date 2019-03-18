angular.module('controllers',[]).controller('educationVacationCtrl',
    ['$scope','$rootScope','$stateParams','$state','EducationUtil', 'staticGlobal', 'Global','StudentApplyVacation',
        function ($scope,$rootScope,$stateParams,$state,EducationUtil, staticGlobal, Global, StudentApplyVacation) {

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

            //日期选择后的回调函数
            var startObjectCallbacks = function (val) {
                startTime = new Date(val).getTime();
                if (typeof (val) === 'undefined') {
                }
                else if(startTime === endTime){
                    vacationPeriod(1);
                }
                else if(endTime !== "" && endTime !== undefined){
                    vacationPeriod(Math.floor((endTime - startTime) / 86400000))
                }
            };

            var endObjectCallbacks = function (val) {
                endTime = new Date(val).getTime();
                if (typeof (val) === 'undefined') {
                }
                else if(startTime === undefined || startTime ===""){
                }
                else if(startTime === endTime){
                    vacationPeriod(1);
                }else {
                    vacationPeriod(Math.floor((endTime - startTime) / 86400000))
                }
            };

            var vacationPeriod = function (str) {
                $scope.vacationMap.period = str;
                $scope.vacationMap.vacationTime = $scope.vacationMap.period + "天";
                $('#mTime').html($scope.vacationMap.vacationTime);
            }

            $scope.$on('$ionicView.enter', function(){
                $("#startDate").mobiscroll().date(
                    {
                        preset: 'date', //日期，可选：date\datetime\time\tree_list\image_text\select
                        theme: 'default', //皮肤样式，可选：default\android\android-ics light\android-ics\ios\jqm\sense-ui\wp light\wp
                        display: 'modal', //显示方式 ，可选：modal\inline\bubble\top\bottom
                        mode: 'scroller', //日期选择模式，可选：scroller\clickpick\mixed
                        lang:'zh',
                        dateFormat: 'yyyy-mm-dd', // 日期格式
                        setText: '确定', //确认按钮名称
                        cancelText: '取消',//取消按钮名籍我
                        dateOrder: 'yyyymmdd', //面板中日期排列格式
                        dayText: '日', monthText: '月', yearText: '年', //面板中年月日文字
                        showNow: false,
                        nowText: "今",
                        /*startYear:1980, //开始年份
                        endYear:currYear, //结束年份*/
                        minDate: new Date(),
                        onSelect: function (valueText) {
                            console.log("st",valueText);
                            $scope.vacationMap.startTime = valueText;
                            startObjectCallbacks(valueText);
                        }
                    });

                $("#endDate").mobiscroll().date(
                    {
                        preset: 'date', //日期，可选：date\datetime\time\tree_list\image_text\select
                        theme: 'default', //皮肤样式，可选：default\android\android-ics light\android-ics\ios\jqm\sense-ui\wp light\wp
                        display: 'modal', //显示方式 ，可选：modal\inline\bubble\top\bottom
                        mode: 'scroller', //日期选择模式，可选：scroller\clickpick\mixed
                        lang:'zh',
                        dateFormat: 'yyyy-mm-dd', // 日期格式
                        setText: '确定', //确认按钮名称
                        cancelText: '取消',//取消按钮名籍我
                        dateOrder: 'yyyymmdd', //面板中日期排列格式
                        dayText: '日', monthText: '月', yearText: '年', //面板中年月日文字
                        showNow: false,
                        nowText: "今",
                        /*startYear:1980, //开始年份
                        endYear:currYear, //结束年份*/
                        minDate: new Date(),
                        onSelect: function (valueText) {
                            console.log("en",valueText);
                            $scope.vacationMap.endTime = valueText;
                            endObjectCallbacks(valueText);
                        }
                    });

        });

        
            //请假类型
            $scope.goVacation = function (type) {
                vacation = type;
                if(0 === type){
                    $scope.vacationList = vacationType;
                }
                $scope.showFloat = true;
                $scope.showOrgan = true;
            }


            //病假、事假
            $scope.changeOrganItem = function (index) {
                $scope.showOrgan = false;
                $scope.showFloat = false;
                if(0 === vacation){
                    $scope.vacationMap.type = $scope.vacationList[index].content;
                }
            }

            //去查看请假历史
            $scope.goHistoryVacation = function () {
                $state.go("studentHistoryVacationList");
            }

            //提交
            $scope.submitVacation = function () {
                var info = EducationUtil.getStudentInfo();
                if($scope.vacationMap.type === undefined || $scope.vacationMap.type === "" ||
                    $scope.vacationMap.case === undefined || $scope.vacationMap.case === "" ||
                    $scope.vacationMap.de === undefined || $scope.vacationMap.de === "" ||
                    $scope.vacationMap.startTime === undefined || $scope.vacationMap.startTime === "" ||
                    $scope.vacationMap.endTime === undefined || $scope.vacationMap.endTime === "" ){

                    EducationUtil.showToast("请假信息不全！");
                    return;
                }
                var ob = {
                    studentId : info.studentId,
                    studentName : info.studentName,
                    classId : info.classId,
                    className : info.className,
                    vacationType : $scope.vacationMap.type,
                    applyReason : $scope.vacationMap.case,
                    vacationPlace : $scope.vacationMap.de,
                    beginDate : $scope.vacationMap.startTime,
                    endDate : $scope.vacationMap.endTime,
                    period : $scope.vacationMap.period
                }

                StudentApplyVacation.save(ob, function (data) {
                    console.log("data", data);
                    if(data.result === Global.SUCCESS){
                        $state.go("studentHistoryVacationList");
                    }
                    else{
                        EducationUtil.showToast(staticGlobal.error);
                    }
                })
            }

}]);
