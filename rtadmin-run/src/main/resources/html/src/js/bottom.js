
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

function getQyfgfcEchartList(date) {
    var rq2=[];
    var lx2fgl=[];
    var lx2fgs=[];
    var rq3=[];
    var lx3fgl=[];
    var lx3fgs=[];
    var rq4=[];
    var lx4fgl=[];
    var lx4fgs=[];
    var rq5=[];
    var lx5fgl=[];
    var lx5fgs=[];
    var data2='0';
    var data3='0';
    var data4='0';
    var data5='0';

    $.axget("/api/yndp/qyfgfc/getQyfgfcEchartList?date="+date,function (res) {
        if(res.data){
            for(var i=0;i<res.data.length;i++){

                if(res.data[i].ext3==2){
                    rq2.push(res.data[i].date);
                    data2=percentNum2(res.data[i].ext2,res.data[i].ext1);
                    lx2fgl.push(data2);
                    lx2fgs.push(res.data[i].ext2);
                }
                if(res.data[i].ext3==3){
                    rq3.push(res.data[i].date);
                    data3=percentNum2(res.data[i].ext2,res.data[i].ext1);
                    lx3fgl.push(data3);
                    lx3fgs.push(res.data[i].ext2);
                }
                if(res.data[i].ext3==4){
                    rq4.push(res.data[i].date);
                    data4=percentNum2(res.data[i].ext2,res.data[i].ext1);
                    lx4fgl.push(data4);
                    lx4fgs.push(res.data[i].ext2);
                }
                if(res.data[i].ext3==5){
                    rq5.push(res.data[i].date);
                    data5=percentNum2(res.data[i].ext2,res.data[i].ext1);
                    lx5fgl.push(data5);
                    lx5fgs.push(res.data[i].ext2);
                }

            }
        }

        chartBar0102(rq2,lx2fgl,lx2fgs);
        chartBar0103(rq3,lx3fgl,lx3fgs);
        chartBar0104(rq4,lx4fgl,lx4fgs);
        chartBar0105(rq5,lx5fgl,lx5fgs);
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
        //console.log(rq)
        chartBar0401(rq,ext1,ext2,ext3,ext4,ext5);
    });
}


function percentNum(num,num2) {
    return (Math.round(num / num2 * 10000) / 100.00 + "%")
}//小数点后两位百分比

function percentNum2(num,num2) {
    return (Math.round(num / num2 * 10000) / 100.00)
}//小数点后两位百分比