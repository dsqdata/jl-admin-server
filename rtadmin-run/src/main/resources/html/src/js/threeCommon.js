var selectTime ='';
$(function () {
    var beforeDate = '';
    $.axget1("/api/yndp/time/getBeforeDay",false, function (res) {
        beforeDate=res.data;
    });
    // new Date(Date.parse(beforeDate.replace(/-/g,"/")))
    $('#datetimepicker').datetimepicker({
        minView: "month",//设置只显示到月份
        format : "yyyy-mm-dd",//日期格式
        autoclose:true,//选中关闭
        todayBtn: true,//今日按钮
        language:'zh-CN',
        defaultDate: "1990-1-1",
       // initialDate:new Date(Date.parse(beforeDate.replace(/-/g,"/"))),
        endDate:new Date(Date.parse(beforeDate.replace(/-/g,"/")))
        // endDate:"-1d" //小于当天的日期的设置  endDate: new Date() 今天的日期和以前的能选择
    }).on('changeDate',function(ev){
        selectTime = $("#datetimepicker").find("input").val();
    });
});