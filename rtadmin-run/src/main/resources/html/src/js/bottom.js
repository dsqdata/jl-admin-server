
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
    $('#mess03').liMarquee({
        direction: 'up',
        scrolldelay:0,
        scrollamount: 10

    });
}


var initOrgBoxQyfgfc = function (data1,data2,data3,data4,data5,data101,data102,data201,data202,data301,data302,data401,data402,data501,data502) {
    var html = template('tpl-orgBoxQyfgfc',{
        data1: data1,
        data2: data2,
        data3: data3,
        data4: data4,
        data5: data5,
        data101:data101,
        data102:data102,
        data201:data201,
        data202:data202,
        data301:data301,
        data302:data302,
        data401:data401,
        data402:data402,
        data501:data501,
        data502:data502
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
    // $.axget("/api/yndp/dcgz/getDcgzList?type=1&date="+date, function (res) {
    //     if(res.data){
    //         initOrgBoxDcz1(res.data)
    //     }else{
    //         initOrgBoxDcz1({content:null})
    //     }
    // });

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
    var data101='-';
    var data102='-';
    var data201='-';
    var data202='-';
    var data301='-';
    var data302='-';
    var data401='-';
    var data402='-';
    var data501='-';
    var data502='-';

    $.axget("/api/yndp/qyfgfc/getQyfgfcList?date="+date,function (res) {
        if(res.data){
          for(var i=0;i<res.data.length;i++){
                if(res.data[i].ext3==1){
                    data1=percentNum(res.data[i].ext2,res.data[i].ext1);
                    data101=res.data[i].ext1;
                    data102=res.data[i].ext2;
                }
                  if(res.data[i].ext3==2){
                      data2=percentNum(res.data[i].ext2,res.data[i].ext1);
                      data201=res.data[i].ext1;
                      data202=res.data[i].ext2;
                  }
                  if(res.data[i].ext3==3){
                      data3=percentNum(res.data[i].ext2,res.data[i].ext1);
                      data301=res.data[i].ext1;
                      data302=res.data[i].ext2;
                  }
                  if(res.data[i].ext3==4){
                      data4=percentNum(res.data[i].ext2,res.data[i].ext1);
                      data401=res.data[i].ext1;
                      data402=res.data[i].ext2;
                  }
                  if(res.data[i].ext3==5){
                      data5=percentNum(res.data[i].ext2,res.data[i].ext1);
                      data501=res.data[i].ext1;
                      data502=res.data[i].ext2;
                  }

          }
        }
        initOrgBoxQyfgfc(data1,data2,data3,data4,data5,data101,data102,data201,data202,data301,data302,data401,data402,data501,data502)
    });
}

function getQyfgfcEchartList(date) {
    var rq1=[];
    var lx1fgl=[];
    var lx1fgs=[];
    var lx1gy=[];
    var lx1sm=[];
    var lx1fdc=[];
    var lx1jz=[];
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

    $.axget("/api/yndp/ReworkEchart/getYndpThreePageReworkEchartList?date="+date,function (res) {
        if(res.data){
            for(var i=0;i<res.data.length;i++){
                if(res.data[i].type==1){
                    rq1.push(res.data[i].date);
                    lx1fgl.push(Math.round(100*(res.data[i].ext3==null?0:res.data[i].ext3)));
                    lx1fgs.push(res.data[i].ext1==null?0:res.data[i].ext1);
                    lx1gy.push(res.data[i].ext4==null?0:res.data[i].ext4);
                    lx1sm.push(res.data[i].ext5==null?0:res.data[i].ext5);
                    lx1fdc.push(res.data[i].ext6==null?0:res.data[i].ext6);
                    lx1jz.push(res.data[i].ext7==null?0:res.data[i].ext7);
                }


                if(res.data[i].type==2){
                    rq2.push(res.data[i].date);
                    lx2fgl.push(Math.round(100*(res.data[i].ext3==null?0:res.data[i].ext3)));
                    lx2fgs.push(res.data[i].ext1==null?0:res.data[i].ext1);
                }
                if(res.data[i].type==3){
                    rq3.push(res.data[i].date);
                    lx3fgl.push(Math.round(100*(res.data[i].ext3==null?0:res.data[i].ext3)));
                    lx3fgs.push(res.data[i].ext1==null?0:res.data[i].ext1);
                }
                if(res.data[i].type==4){
                    rq4.push(res.data[i].date);
                    lx4fgl.push(Math.round(100*(res.data[i].ext3==null?0:res.data[i].ext3)));
                    lx4fgs.push(res.data[i].ext1==null?0:res.data[i].ext1);
                }
                if(res.data[i].type==5){
                    rq5.push(res.data[i].date);
                    lx5fgl.push(Math.round(100*(res.data[i].ext3==null?0:res.data[i].ext3)));
                    lx5fgs.push(res.data[i].ext1==null?0:res.data[i].ext1);
                }

            }
        }
        chartBar0101(rq1,lx1fgl,lx1fgs,lx1gy,lx1sm,lx1fdc,lx1jz);
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
