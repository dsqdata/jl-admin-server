
var initOrgBoxXxfx = function (data) {
    var html = template('tpl-orgBoxXxfx', data);
    document.getElementById('orgBoxXxfx').innerHTML = html;
}

var initOrgBoxDcz1 = function (data) {
    var html = template('tpl-orgBoxDcz1', data);
    document.getElementById('orgBoxDcz1').innerHTML = html;
    //消息滚动
    //消息滚动
    $('#mess02').liMarquee({
        direction: 'up',
        scrolldelay:0,
        scrollamount: 10

    });
}

var initOrgBoxDcz2 = function (data) {
    var html = template('tpl-orgBoxDcz2', data);
    document.getElementById('orgBoxDcz2').innerHTML = html;
    //消息滚动
    //消息滚动
    $('#mess03').liMarquee({
        direction: 'up',
        scrolldelay:0,
        scrollamount: 10

    });
}


var initOrgBoxQyfgfc = function (data1,data2,data3,data4,data5) {
    var html = template('tpl-orgBoxQyfgfc',{
        data1: data1,
        data2: data2,
        data3: data3,
        data4: data4,
        data5: data5
    });
    document.getElementById('orgBoxQyfgfc').innerHTML = html;
}


function getXxfgList(date) {
    var a='';
    $.axget("/api/yndp/xxfg/getXxfgList?date="+date, function (res) {
        a=res.data;
        if(a){
            initOrgBoxXxfx(res.data)
        }else{
            initOrgBoxXxfx({school:null,kindergarten:null,training:null})
        }

    });
}


function getDcgzList(date) {
    $.axget("/api/yndp/dcgz/getDcgzList?type=1&date="+date, function (res) {
        if(res.data){
            initOrgBoxDcz1(res.data)
        }else{
            initOrgBoxDcz1({content:null})
        }
    });

    $.axget("/api/yndp/dcgz/getDcgzList?type=2&date="+date, function (res) {
        if(res.data){
            initOrgBoxDcz2(res.data)
        }else{
            initOrgBoxDcz2({content:null})
        }
    });
}

function getQyfgfcList(date) {
    var data1='-';
    var data2='-';
    var data3='-';
    var data4='-';
    var data5='-';

    $.axget("/api/yndp/qyfgfc/getQyfgfcList?date="+date,function (res) {
        if(res.data){
          for(var i=0;i<res.data.length;i++){
                if(res.data[i].ext3==1){
                    data1=percentNum(res.data[i].ext2,res.data[i].ext1);
                }
                  if(res.data[i].ext3==2){
                      data2=percentNum(res.data[i].ext2,res.data[i].ext1);
                  }
                  if(res.data[i].ext3==3){
                      data3=percentNum(res.data[i].ext2,res.data[i].ext1);
                  }
                  if(res.data[i].ext3==4){
                      data4=percentNum(res.data[i].ext2,res.data[i].ext1);
                  }
                  if(res.data[i].ext3==5){
                      data5=percentNum(res.data[i].ext2,res.data[i].ext1);
                  }

          }
        }
        initOrgBoxQyfgfc(data1,data2,data3,data4,data5)
    });
}


function getGdjcpcEList(date) {
    var rq=[];
    var ext1=[];
    var ext2=[];
    var ext3=[];
    var ext4=[];
    var ext5=[];
    $.axget("/api/yndp/gdjcpcec/getGdjcpcEList?date="+date, function (res) {
        if(res.data){
            for(var i=0;i<res.data.length;i++){
                rq.push(res.data[i].date);
                ext1.push(res.data[i].ext1);
                ext2.push(res.data[i].ext2);
                ext3.push(res.data[i].ext3);
                ext4.push(res.data[i].ext4);
                ext5.push(res.data[i].ext5);

            }
        }
        console.log(rq)
        chartBar0401(rq,ext1,ext2,ext3,ext4,ext5);
    });
}


function percentNum(num,num2) {
    return (Math.round(num / num2 * 10000) / 100.00 + "%")
}//小数点后两位百分比
