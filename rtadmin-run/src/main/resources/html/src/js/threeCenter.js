
var initOrgBoxCheck = function (data) {
    var html = template('tpl-orgBoxCheck', data);
    document.getElementById('orgBoxCheck').innerHTML = html;
}

function ThreePageCheck(date) {
    $.axget("/api/yndp/check/getYndpThreePageCheck?date="+date, function (res) {
        if(res.data){
            initOrgBoxCheck(res.data)
        }else{
            initOrgBoxCheck({first_yesterday:'',first_jkq:'',first_status:'',
                second_yesterday:'',second_jkq:'',second_status:'',
                third_yesterday:'',third_jkq:'',third_status:''})
        }
    });
}

var initOrgBoxCollection = function (data) {
    var html = template('tpl-orgBoxCollection',data);
    document.getElementById('orgBoxCollection').innerHTML = html;
}

function ThreePageCollection(date) {
    $.axget("/api/yndp/Collection/getYndpThreePageCollection?date="+date, function (res) {
        if(res.data){
            initOrgBoxCollection(res.data)
        }else{
            initOrgBoxCollection({app_install:'',app_used:'',people_num:'',woker_num:''})
        }
    });
}

var initOrgBoxInvestigation = function (data) {
    var html = template('tpl-orgBoxInvestigation',data);
    document.getElementById('orgBoxInvestigation').innerHTML = html;
}

function ThreePageInvestigation(date) {
    $.axget("/api/yndp/Investigation/getYndpThreePageInvestigation?date="+date, function (res) {
        if(res.data){
            initOrgBoxInvestigation(res.data)
        }else{
            initOrgBoxInvestigation({count:'',today_person:'',all_persons:'',today_vehicle:'',all_vehicle:''})
        }
    });
}

var initOrgBoxSupport = function (data) {
    var html = template('tpl-orgBoxSupport',data);
    document.getElementById('orgBoxSupport').innerHTML = html;
}

function ThreePageSupport(date) {
    $.axget("/api/yndp/Support/getYndpThreePageSupport?date="+date, function (res) {
        if(res.data){
            initOrgBoxSupport(res.data)
        }else{
            initOrgBoxSupport({living:null,prevention:null,capital:null})
        }
    });
}

var initOrgBoxWork = function (data,date) {
    /*var html = template('tpl-orgBoxWork',{worklist:data});
    document.getElementById('orgBoxWork').innerHTML = html;*/

    /*for (var m=0;m<data.length;m++){
        var value =data[m].id;
        //alert(value);
        var name  =data[m].name;
        //alert(name);
        $("#work").append("<option value="+value+">"+name+"</option>");
    }*/

    /*var sel1 = document.getElementById('work');
    sel1.onchange = function{
        var index = sel1.selectedIndex;
        console.log(sel1.options[index].value);
        workid = sel1.options[index].value;
    }*/


    //$("#work").change(ThreePageWorkstationTotal(date));

}

function ThreePageWorkstationList(date) {
    $.axget("/api/yndp/Workstation/getYndpThreePageWorkstationList", function (res) {
        if(res.data){
            initOrgBoxWork(res.data,date);
        }else{
        }
    });
    //$("#work").append("<option value='Value'>Text</option>");

}

var initOrgBoxTotal = function (data) {
    var html = template('tpl-orgBoxTotal',data);
    document.getElementById('orgBoxTotal').innerHTML = html;
}

function ThreePageWorkstationTotal(date) {

    $.axget("/api/yndp/WorkstationTotal/getYndpThreePageWorkstationTotal?date="+date+"&&workstation_id="+workid, function (res) {
        if(res.data){
            initOrgBoxTotal(res.data)
        }else{
            initOrgBoxTotal({today_count:null,all_count:null,all_remove:null,
                tody_remove:null,hubei_remove:null,hubei_remove_rujia:null,
                hubei_remove_home:null,hubei_remove_other:null,other_remove:null,
                other_yunan_remove:null,other_other_remove:null,all_checkin:null,
                toady_checkin:null,hubei_checkin:null,other_checkin:null})
        }
    });
}

function WorkstationTotal(date,workid) {

    $.axget("/api/yndp/WorkstationTotal/getYndpThreePageWorkstationTotal?date="+date+"&&workstation_id="+workid, function (res) {
        if(res.data){
            initOrgBoxTotal(res.data)
        }else{
            initOrgBoxTotal({today_count:null,all_count:null,all_remove:null,
                tody_remove:null,hubei_remove:null,hubei_remove_rujia:null,
                hubei_remove_home:null,hubei_remove_other:null,other_remove:null,
                other_yunan_remove:null,other_other_remove:null,all_checkin:null,
                toady_checkin:null,hubei_checkin:null,other_checkin:null})
        }
    });
}


var initOrgBoxLack = function (data) {
    var html = template('tpl-orgBoxLack',{lacklist:data});
    document.getElementById('orgBoxLack').innerHTML = html;
}

function ThreePageLackList(date) {
    $.axget("/api/yndp/Lack/getYndpThreePageLackList?date="+date, function (res) {
        if(res.data){
            //console.log(res.data)
            initOrgBoxLack(res.data)
        }else{
        }
    });
}

var initOrgBox308 = function (data) {
    var html = template('tpl-orgBox308',{lallCollist:data});
    document.getElementById('orgBox308').innerHTML = html;
}

function allCollection() {
    $.axget("/api/yndp/Collection/getYndpThreePageAllCollectionList?date=20200220", function (res) {
        console.log(res.data)
        initOrgBox308(res.data)
    });
}