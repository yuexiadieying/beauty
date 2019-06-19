angular.module('app')
  .directive('selDate', ['$timeout', function($timeout) {
    return {
        restrict: 'EAC',
        scope:{
            index:'@',
            getData:"&"
        },
        replace: false,
        template: '<div class="input-group" >'+
        '<button type="button" class="btn btn-default pull-right" id="{{index}}" >'+
        '<i class="fa fa-calendar" style="margin-right: 5px"></i>'+
        '<span>时间</span>'+
        '<i class="fa fa-caret-down" style="margin-left:5px;"></i>'+
        '</button>'+
        '</div>',
        link: function (scope, element, attr) {
            scope.init = function () {
                //定义locale汉化插件
                var locale = {
                    "format": 'YYYY-MM-DD',
                    "separator": " -222 ",
                    "applyLabel": "确定",
                    "cancelLabel": "取消",
                    "fromLabel": "起始时间",
                    "toLabel": "结束时间'",
                    "customRangeLabel": "自定义",
                    "weekLabel": "W",
                    "daysOfWeek": ["日", "一", "二", "三", "四", "五", "六"],
                    "monthNames": ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                    "firstDay": 1
                };
                //初始化显示当前时间

                $("#"+scope.index +" span").html(moment().subtract(3, 'days').format('YYYY-MM-DD') + ' - ' + moment().format('YYYY-MM-DD'))
                //日期控件初始化
                $("#"+scope.index).daterangepicker(
                    {
                        'locale': locale,
                        //汉化按钮部分
                        ranges: {
                            '今天': [moment(), moment()],
                            '本周': [moment().startOf('week'), moment().endOf('week')],
                            '本月': [moment().startOf('month'), moment().endOf('month')]
                        },
                        startDate: moment().subtract(29, 'days'),
                        endDate: moment()
                    },
                    function (start, end) {
                        $("#"+scope.index +" span").html(start.format('YYYY-MM-DD') + ' - ' + end.format('YYYY-MM-DD'));
                        scope.getData(start.format('YYYY-MM-DD'),end.format('YYYY-MM-DD'))
                    }
                );
            };

            var time= $timeout(function(){
                scope.init()
                clearTimeout(time)
            },500)

        }
    }
  }])
  .directive('selMonth', ['$timeout', function($timeout) {
      return {
          restrict: 'EAC',
          scope:{
              index:'@',
              getData:"&"
          },
          replace: false,
          template:  '<form action="" class="form-horizontal"  role="form">'+
          '<div class="form-group">'+
          '<div class="input-group date  col-md-6" data-date="" data-date-format="" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd" id="{{index}}">'+
          '<input  name="start_time" class="form-control" size="16" type="text" value="" readonly placeholder="{{format_td}}" style="width:80px;background: #fff">'+

      '<span class="input-group-addon" style="background: #fff"><span class="glyphicon glyphicon-calendar"></span></span>'+
          '</div>'+
          '<input type="hidden" id="dtp_input2" value="" />'+
          '</div>'+
          '</form>',
          link: function (scope, element, attr) {
             scope.init=function () {
                 var today = new Date();
                 scope.format_td = today.getFullYear()+'-'+(today.getMonth()+1)
                 $('#'+scope.index).datetimepicker({
                     format: 'yyyy-mm',
                     weekStart: 1,
                     autoclose: true,
                     startView: 3,
                     minView: 3,
                     forceParse: false,
                     defaultDate:'2019-06',
                     language: 'zh-CN',
                 }).on('changeDate',function(dateText, inst){
                     var myDate = dateText.date;
                     var year = myDate.getFullYear();
                     var month = myDate.getMonth() + 1;
                     if(month<10){
                         var month = '0'+month
                     }
                     var timeDate = year +'-'+month
                 });
             }
              var time= $timeout(function(){
                  scope.init()
                  clearTimeout(time)
              },500)

          }
      }
}])
    .directive('selYear', ['$timeout', function($timeout) {
        return {
            restrict: 'EAC',
            scope:{
                index:'@',
                getData:"&"
            },
            replace: false,
            template:  '<form action="" class="form-horizontal"  role="form">'+
            '<div class="form-group">'+
            '<label for="dtp_input2" class="col-md-6 control-label">选择时间</label>'+
            '<div class="input-group date  col-md-6" data-date="" data-date-format="" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd" id="{{index}}">'+
            '<input id="start_time" name="start_time" class="form-control" size="16" type="text" value="" readonly placeholder="{{format_td}}" style="background: #fff;">'+

            '<span class="input-group-addon" style="background: #fff;"><span class="glyphicon glyphicon-calendar"></span></span>'+
            '</div>'+
            '<input type="hidden" id="dtp_input2" value="" />'+
            '</div>'+
            '</form>',
            link: function (scope, element, attr) {
                scope.init=function () {
                    var today = new Date();
                    scope.format_td = today.getFullYear()
                    $('#'+scope.index).datetimepicker({
                        format: 'yyyy',
                        weekStart: 1,
                        autoclose: true,
                        startView: 4,
                        minView: 4,
                        forceParse: false,
                        language: 'zh-CN',
                        defaultDate:'2019'
                    }).on('changeDate',function(dateText, inst){
                        var myDate = dateText.date;
                        var year = myDate.getFullYear();//当前年份
                    });
                }
                var time= $timeout(function(){
                    scope.init()
                    clearTimeout(time)
                },500)

            }
        }
    }])
    .directive('selSpacingm', ['$timeout', function($timeout) {
        return {
            restrict: 'EAC',
            scope:{
                index:'@',
                index1:'@'
            },
            replace: false,
            template:'<div style="display: flex;">'+
                '<div class="input-group ">'+
                '<input type="text" class="form-control content cursor-pointer" id="{{index}}"  readonly style="width:80px;background: #fff;" placeholder="{{format_td}}" >'+
                '</div>'+
                '<div class="input-group "><span>&nbsp~&nbsp</span>'+
                '<input type="text" class="form-control content cursor-pointer" id="{{index1}}"  readonly style="width:80px;float: none;background: #fff;" placeholder="{{format_td}}">'+
                '</div>'+
            '</div>',
            link: function (scope, element, attr) {
                scope.init = function () {
                    var today = new Date();
                    scope.format_td = today.getFullYear()+'-'+(today.getMonth()+1)
                    $("#"+scope.index).datetimepicker({
                        format: 'yyyy-mm',
                        weekStart: 1,
                        autoclose: true,
                        startView: 3,
                        minView: 3,
                        forceParse: false,
                        defaultDate:'2019-06',
                        language: 'zh-CN'
                    }).on("click",function(){
                        $("#"+scope.index).datetimepicker("setEndDate",$("#"+scope.index1).val());
                    });

                    $("#"+scope.index1).datetimepicker({
                        format: 'yyyy-mm',
                        weekStart: 1,
                        autoclose: true,
                        startView: 3,
                        minView: 3,
                        forceParse: false,
                        defaultDate:'2019-06',
                        language: 'zh-CN',
                    }).on("click",function(){
                        console.log(1);
                        $("#"+scope.index1).datetimepicker("setStartDate",$("#"+scope.index).val());
                    });

                    $(document).on("click","#"+scope.index1,function(){
                        $('#'+scope.index1).datetimepicker('show');
                    });

                    $(document).on("click","#"+scope.index,function(){
                        $('#'+scope.index).datetimepicker('show');
                    });
                }
                var time= $timeout(function(){
                    scope.init()
                    clearTimeout(time)
                },500)

            }

        }
    }])
    .directive('selDateSingle', ['$timeout', function($timeout) {
        return {
            restrict: 'EAC',
            scope:{
                index:'@',
                getData:"&"
            },
            replace: false,
            template:  '<form action="" class="form-horizontal"  role="form">'+
            '<div class="form-group">'+
            '<div class="input-group date  col-md-6" data-date="" data-date-format="" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd" id="{{index}}">'+
            '<input  name="start_time" class="form-control" size="16" type="text" value="" readonly placeholder="{{format_td}}" style="width:100px;background: #fff">'+

            '<span class="input-group-addon" style="background: #fff"><span class="glyphicon glyphicon-calendar"></span></span>'+
            '</div>'+
            '<input type="hidden" id="dtp_input2" value="" />'+
            '</div>'+
            '</form>',
            link: function (scope, element, attr) {
                scope.init=function () {
                    var today = new Date();
                    scope.format_td = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
                    $('#'+scope.index).datetimepicker({
                        minView: "month",
                        format: "yyyy-mm-dd",
                        language: 'zh-CN',
                        autoclose:true,
                        startDate: scope.format_td,
                    }).on('changeDate',function(dateText, inst){
                        var myDate = dateText.date;//当前时间
                        var year = myDate.getFullYear();//当前年份
                        var month = myDate.getMonth() + 1;//当前月份
                        var dd= myDate.getDate()
                        if(month<10){
                            var month = '0'+month
                        }
                        var timeDate = year +'-'+month + '-' +dd
                    });
                }
                var time= $timeout(function(){
                    scope.init()
                    clearTimeout(time)
                },500)

            }
        }
    }])