var selectTime ='';
var workid = '1';
$(function () {
    var beforeDate = '';
    $.axget1("/api/yndp/time/getBeforeDay",false, function (res) {
        beforeDate=res.data;
        checkDate(beforeDate.replace(/-/g,""));
    });
    // new Date(Date.parse(beforeDate.replace(/-/g,"/")))
    $('#datetimepicker').datetimepicker({
        minView: "month",//设置只显示到月份
        format : "yyyy-mm-dd",//日期格式
        autoclose:true,//选中关闭
        todayBtn: true,//今日按钮
        language:'zh-CN',
        initialDate:new Date(),
        // initialDate:new Date(Date.parse(beforeDate.replace(/-/g,"/"))),
        endDate:new Date(Date.parse(beforeDate.replace(/-/g,"/")))
        // endDate:"-1d" //小于当天的日期的设置  endDate: new Date() 今天的日期和以前的能选择
    }).on('changeDate',function(ev){
        selectTime = $("#datetimepicker").find("input").val();
        checkDate(selectTime.replace(/-/g,""))
    });
    $('#datetimepicker').datetimepicker('setDate', new Date(Date.parse(beforeDate.replace(/-/g,"/")))); //把要设置的默认值放入new Date()里面


    function checkDate(date){
        getXxfgList(date)
        getDcgzList(date)
        getQyfgfcList(date)
        getGdjcpcEList(date)
        // 当日疫情动态
        querySituation(date);
        //其他疫情播报
        queryBroadcast(date);

        ThreePageCheck(date);
        ThreePageCollection(date);
        ThreePageInvestigation(date);
        ThreePageSupport(date);
        ThreePageLackList(date);
        ThreePageWorkstationList();
        ThreePageWorkstationTotal(date)

    }
});