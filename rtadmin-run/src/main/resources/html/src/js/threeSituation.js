//当日疫情动态
function querySituation(currentDate){
    $.axget1("/api/yndp/situation/getSituation?date="+currentDate,false, function (res) {
        if(res.data.length!=0){
            initOrgBoxDryqdt(res.data);
        }else{
            initOrgBoxDryqdt([{id: null,date: null,today_confirmed: null,all_confirmed: null,today_suspected: null,all_suspected: null,today_dlose: null,all_close: null,relieve: null,observation:null,observation_status: null,today_receive: null,today_further: null,today_quarantine: null,ext1: null,ext2: null,ext3: null, create_time: null}]);
        }
    });
}

// 当日疫情动态
var initOrgBoxDryqdt = function (data) {
    var html = template('tpl-orgBoxDryqdt', data[0]);
    document.getElementById('orgBoxDryqdt').innerHTML = html;
}
