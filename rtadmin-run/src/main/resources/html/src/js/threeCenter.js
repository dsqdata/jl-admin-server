
var initOrgBoxCheck = function (data) {
    var html = template('tpl-orgBoxCheck', data);
    document.getElementById('orgBoxCheck').innerHTML = html;
    $('.actionList03 .sttl01').hover(
        function () {
            $(this).find('span').show()
        },
        function () {
            $(this).find('span').hide()
        });
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
    var htmlModel = template('tpl-material_supply',data);
    document.getElementById('material_supply').innerHTML = htmlModel;
}

function ThreePageSupport(date) {
    $.axget("/api/yndp/Support/getYndpThreePageSupport?date="+date, function (res) {
        if(res.data){
                /*res.data.ext1=res.data.ext1.trim().split("|||");
                res.data.ext2=res.data.ext2.trim().split("|||");
                res.data.ext3=res.data.ext3.trim().split("|||");*/
            initOrgBoxSupport(res.data)
        }else{
            initOrgBoxSupport({living:null,prevention:null,capital:null})
        }
    });
}

var initOrgBoxWork = function (data) {
    /*var html = template('tpl-orgBoxWork',{worklist:data});
    document.getElementById('orgBoxWork').innerHTML = html;*/

    /*for (var m=0;m<data.length;m++){
        var value =data[m].id;
        //alert(value);
        var name  =data[m].name;
        //alert(name);
        $("#work").append("<option value="+value+">"+name+"</option>");
    }*/


}

function ThreePageWorkstationList() {
    $.axget("/api/yndp/Workstation/getYndpThreePageWorkstationList", function (res) {
        if(res.data){
            initOrgBoxWork(res.data);
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
    var sel1 = document.getElementById('work');
    var index = sel1.selectedIndex;
    console.log(sel1.options[index].value);
    var workid = sel1.options[index].value;
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

function ThreePageWorkstationTotalList(date){
    var rq=[];
    var today=[];
    var todayin=[];

    var wed1=[];
    var wynzh1=[];
    var wyngj1=[];
    var yq1=[];

    var wed2=[];
    var wynzh2=[];
    var wyngj2=[];
    var yq2=[];

    $.axget("/api/yndp/WorkstationTotal/getYndpThreePageWorkstationTotalList?date="+date, function (res) {
        if(res.data){
            for(var i=0;i<res.data.length;i++){
                if(res.data[i].workstation_id==1){
                    rq.push(res.data[i].date);
                    today.push(res.data[i].today_count==null?0:res.data[i].today_count);
                    todayin.push(res.data[i].toady_checkin==null?0:res.data[i].toady_checkin);
                }
                if(res.data[i].workstation_id==2){
                    wed1.push(res.data[i].all_count==null?0:res.data[i].all_count);
                    wed2.push(res.data[i].all_checkin==null?0:res.data[i].all_checkin);
                }
                if(res.data[i].workstation_id==3){
                    wynzh1.push(res.data[i].all_count==null?0:res.data[i].all_count);
                    wynzh2.push(res.data[i].all_checkin==null?0:res.data[i].all_checkin);
                }
                if(res.data[i].workstation_id==4){
                    wyngj1.push(res.data[i].all_count==null?0:res.data[i].all_count);
                    wyngj2.push(res.data[i].all_checkin==null?0:res.data[i].all_checkin);
                }
                if(res.data[i].workstation_id==5){
                    yq1.push(res.data[i].all_count==null?0:res.data[i].all_count);
                    yq2.push(res.data[i].all_checkin==null?0:res.data[i].all_checkin);
                }
            }
        }

        chartBar02(rq,today,wed1,wynzh1,wyngj1,yq1);
        chartBar03(rq,todayin,wed2,wynzh2,wyngj2,yq2);
    });
}


var initOrgBoxLack = function (data) {
    var html = template('tpl-orgBoxLack',{lacklist:data});
    document.getElementById('orgBoxLack').innerHTML = html;
    //消息滚动
    $('#jqwzMess').liMarquee({
        direction: 'up',
        scrolldelay:0,
        scrollamount: 10

    });
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

/*var initOrgBoxAllCol = function (data) {
    var html = template('tpl-orgBoxAllCol',{allCollist:data});
    document.getElementById('orgBoxAllCol').innerHTML = html;
}*/

function ThreePageCollectionEchartList(date){
    var rq=[];
    var ext1=[];
    var ext2=[];
    var ext3=[];
    var ext4=[];

    $.axget("/api/yndp/CollectionEchart/getYndpThreePageCollectionEchartList?date="+date, function (res) {
        if(res.data){
            for(var i=0;i<res.data.length;i++){
                rq.push(res.data[i].date);
                ext1.push(res.data[i].ext1);
                ext2.push(res.data[i].ext2);
                ext3.push(res.data[i].ext3);
                ext4.push(res.data[i].ext4);

            }
        }
        //console.log(rq)
        chartBar0501(rq,ext1,ext2,ext3,ext4);
    });

}