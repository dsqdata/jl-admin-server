//其他疫情播报
function queryBroadcast(selectDate){
    $.axget1("/api/yndp/broadcast/getBroadcast?date="+selectDate,false, function (res) {
        if(res.data.length!=0){
            initOrgBoxBroadcast(res.data);
        }else{
            // initOrgBoxDryqdt([{id: null,date: null,today_confirmed: null,all_confirmed: null,today_suspected: null,all_suspected: null,today_dlose: null,all_close: null,relieve: null,observation:null,observation_status: null,today_receive: null,today_further: null,today_quarantine: null,ext1: null,ext2: null,ext3: null, create_time: null}]);
        }
    });
}

// 其他疫情播报
var initOrgBoxBroadcast = function (data) {
    console.log("initOrgBoxBroadcast");
    console.log(data);
    var html = template('tpl-orgBoxBroadcast', {
        broadcastList:data
    });
    document.getElementById('orgBoxBroadcast').innerHTML = html;
    //消息滚动
    $('.mess01').liMarquee({
        direction: 'up',
        scrolldelay:0,
        scrollamount: 10
    });
}