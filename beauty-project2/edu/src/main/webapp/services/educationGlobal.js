angular.module('educationGlobal',[])
    .constant("Global", {
        SUCCESS : '0x00001',
        FAILURE : '0x00002',
        ONLINE : '0x00003',
        OFFLINE : '0x00004',
        LOGIN_OUT: '0x00005',
        TOKEN_ERROR: '0x00006',
        PARAM_ERROR: '0x00007',
        LOGIN_SUCCESS_SECOND : '0x00008',
        NO_USER_ADDRESS : '0x00011',
        userType:{
            STUDENT:'student',
            TEACHER:'teacher'
        }
    })
    .constant("LogGlobal", {
        BUSINESS_HOME : "0x001",
        TRAINING_HOME : "0x002",
        USER_LOGIN : "0x003",
        BUSINESS_BANNER : "0x004",
        PRODUCT_DETAIL_CLICK : "0x005",
        BUY_PRODUCT : "0x006",
        USER_CANCEL_BUY_PRODUCT : "0x007",
        AUTO_CANCEL_BUY_PRODUCT : "0x008",
        ADD_PRODUCT_TO_BUY_CART : "0x009"
    })
    .constant("LoginGlobal",{
        MX_DL_SCDL:"MX_DL_SCDL",
        MX_SC_BADJ:"MX_SC_BADJ",
        MX_SC_ADJ:"MX_SC_ADJ",
        MX_SC_ACJ:" MX_SC_ACJ",
        MX_SC_YQX:"MX_SC_YQX",
        MX_SC_CQX:"MX_SC_CQX",
        MX_SC_AGW:"MX_SC_AGW",
        MX_YX_SZDJ:"MX_YX_SZDJ",
        MX_YX_SZCJ:"MX_YX_SZCJ",
        MX_YX_YXABF:"MX_YX_YXABF"
    })
    .constant("staticGlobal", {
        loginState : "loginState", //是否登录
        teacher : "teacher", //从教师端进入登录页面
        student : "student", //从学生端进入登录页面
        studentInfo : "studentInfo", //学生信息
        school : "school", //学校选择
        error : "内部异常",
        missionComment : "missionComment" //对作业任务点评
    })
    .factory('EducationUtil', ['Global','staticGlobal','$ionicPopup','$state','$rootScope','$http', '$ionicLoading', '$timeout',
        function(Global,staticGlobal,$ionicPopup,$state,$rootScope,$http, $ionicLoading, $timeout) {
            return {
                showToast : function (text) {
                    $ionicLoading.show({
                        template: text
                    });

                    $timeout(function(){
                        $ionicLoading.hide();
                    }, 1000);
                },
                checkResponseData: function(data,redirectParam) {
                    if(data.result === Global.FAILURE)
                    {
                        if(data.errorInfo === Global.TOKEN_ERROR){
                            $state.go("login",{redirectUrl:redirectParam})
                        }
                    }
                },
                getAddDate:function(date,days){
                    var d=new Date(date);
                    d.setDate(d.getDate()+days);
                    var month=d.getMonth()+1;
                    var day = d.getDate();
                    if(month<10){
                        month = "0"+month;
                    }
                    if(day<10){
                        day = "0"+day;
                    }
                    var val = d.getFullYear()+"-"+month+"-"+day;
                    return val;
                },
                IdentityCodeValid:function(code) {
                    var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
                    var tip = "";
                    var pass= true;

                    if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
                        tip = "身份证号格式错误";
                        pass = false;
                    }

                    else if(!city[code.substr(0,2)]){
                        tip = "地址编码错误";
                        pass = false;
                    }
                    else{
                        //18位身份证需要验证最后一位校验位
                        if(code.length == 18){
                            code = code.split('');
                            //∑(ai×Wi)(mod 11)
                            //加权因子
                            var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
                            //校验位
                            var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
                            var sum = 0;
                            var ai = 0;
                            var wi = 0;
                            for (var i = 0; i < 17; i++)
                            {
                                ai = code[i];
                                wi = factor[i];
                                sum += ai * wi;
                            }
                            var last = parity[sum % 11];
                            if(parity[sum % 11] != code[17]){
                                tip = "校验位错误";
                                pass =false;
                            }
                        }
                    }
                    if(!pass) alert(tip);
                    return pass;
                },
                getLoginState : function () {
                    if(localStorage.getItem(staticGlobal.loginState) !== null){
                        return true;
                    }
                    else {
                        return false;
                    }
                },
                saveLoginState : function () {
                    if(localStorage.getItem(staticGlobal.loginState) !== null){
                        localStorage.removeItem(staticGlobal.loginState);
                    }
                    localStorage.setItem(staticGlobal.loginState, "yes");
                },
                removeLoginState : function () {
                    if(localStorage.getItem(staticGlobal.loginState) !== null){
                        localStorage.removeItem(staticGlobal.loginState);
                    }
                },
                getSchoolName : function () {
                    if(sessionStorage.getItem(staticGlobal.school) !== null){
                        return JSON.parse(sessionStorage.getItem(staticGlobal.school));
                    }
                    else {
                        return null;
                    }
                },
                saveSchoolName : function (ob) {
                    if(sessionStorage.getItem(staticGlobal.school) !== null){
                        sessionStorage.removeItem(staticGlobal.school);
                    }
                    sessionStorage.setItem(staticGlobal.school, JSON.stringify(ob));
                },
                saveStudentInfo : function (ob) {
                    if(localStorage.getItem(staticGlobal.studentInfo) !== null){
                        localStorage.removeItem(staticGlobal.studentInfo);
                    }
                    localStorage.setItem(staticGlobal.studentInfo, JSON.stringify(ob));
                },
                getStudentInfo : function () {
                    if(localStorage.getItem(staticGlobal.studentInfo) !== null){
                        return JSON.parse(localStorage.getItem(staticGlobal.studentInfo));
                    }
                    else {
                        return false;
                    }
                },
                saveMissionComment : function (data) {
                    if(sessionStorage.getItem(staticGlobal.missionComment) !== null){
                        sessionStorage.removeItem(staticGlobal.missionComment);
                    }
                    sessionStorage.setItem(staticGlobal.missionComment, JSON.stringify(data));
                },
                getMissionComment : function () {
                    if(sessionStorage.getItem(staticGlobal.missionComment) !== null){
                        return JSON.parse(sessionStorage.getItem(staticGlobal.missionComment));
                    }
                    else {
                        return false;
                    }
                }
            };
        }]);
