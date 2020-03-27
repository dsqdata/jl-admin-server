
var initOrgBoxSchoolData = function (data) {
    if(1==data.type){
        var html = template('tpl-orgBoxAllTeacher', data);
        document.getElementById('orgBoxAllTeacher').innerHTML = html;
    }else if(2==data.type){
        var html = template('tpl-orgBoxAllStudent', data);
        document.getElementById('orgBoxAllStudent').innerHTML = html;
    }
}

var initOrgBoxHistory = function (data) {
    if(1==data.type){
        var html = template('tpl-orgBoxHistoryT', data);
        document.getElementById('orgBoxHistoryT').innerHTML = html;
    }else if(2==data.type){
        var html = template('tpl-orgBoxHistoryS', data);
        document.getElementById('orgBoxHistoryS').innerHTML = html;
    }
}

var initOrgBoxTitle = function (data) {
    var html = template('tpl-orgBoxTitle',{name:data});
    document.getElementById('orgBoxTitle').innerHTML = html;
}

function YndpFourSchoolMsg(date,school_id,type){

    $.axget("/api/yndp/SchoolMsg/getYndpFourSchoolMsgList?date="+date+"&&school_id="+school_id+"&&type="+type, function (res) {

        var m = 1;
        var ext11 = 0;
        var ext12 = 0;
        var ext13 = 0;
        var ext14 = 0;
        var ext15 = 0;
        var ext21 = 0;
        var ext22 = 0;
        var ext23 = 0;
        var ext24 = 0;
        var ext25 = 0;
        var ext26 = 0;
        var ext27 = 0;
        if(res.data){

            m = res.data.length-1;

            initOrgBoxSchoolData(res.data[m]);
            initOrgBoxHistory(res.data[m]);

            ext11 = res.data[m].ext11;
            ext12 = res.data[m].ext12;
            ext13 = res.data[m].ext13;
            ext14 = res.data[m].ext14;
            ext15 = res.data[m].ext15;

            ext21 = res.data[m].ext21;
            ext22 = res.data[m].ext22;
            ext23 = res.data[m].ext23;
            ext24 = res.data[m].ext24;
            ext25 = res.data[m].ext25;
            ext26 = res.data[m].ext26;
            ext27 = res.data[m].ext27;

        }

        if(1==type){
            chartBar401(date,school_id,type,ext11,ext12,ext13,ext14,ext15);
            //chartBar403(date,school_id,type,ext12,ext21,ext22,ext23,ext24,ext25,ext26,ext27);
            fourthZkjzgqkgzCircle(date,school_id,type,ext12,ext21,ext22,ext23,ext24,ext25,ext26,ext27);
        }

        if(2==type){
            chartBar402(date,school_id,type,ext11,ext12,ext13,ext14,ext15);
            //chartBar404(date,school_id,type,ext12,ext21,ext22,ext23,ext24,ext25,ext26,ext27);
            fourthZkxsqkgzCircle(date,school_id,type,ext12,ext21,ext22,ext23,ext24,ext25,ext26,ext27);
        }

    });
}


function YndpFourPeopleMsg(date,school_id,type,title){

    var rq=[];
    var ext11 = [];
    var ext12 = [];
    var ext13 = [];
    var ext14 = [];
    var ext15 = [];
    var ext21 = [];
    var ext22 = [];
    var ext23 = [];
    var ext24 = [];
    var ext25 = [];
    var ext26 = [];
    var ext27 = [];


    $.axget("/api/yndp/SchoolMsg/getYndpFourSchoolMsgList?date="+date+"&&school_id="+school_id+"&&type="+type, function (res) {

        if(res.data){
            for(var i=0;i<res.data.length;i++){
                rq.push(res.data[i].date);
                ext11.push(res.data[i].ext11);
                ext12.push(res.data[i].ext12);
                ext13.push(res.data[i].ext13);
                ext14.push(res.data[i].ext14);
                ext15.push(res.data[i].ext15);
                ext21.push(res.data[i].ext21);
                ext22.push(res.data[i].ext22);
                ext23.push(res.data[i].ext23);
                ext24.push(res.data[i].ext24);
                ext25.push(res.data[i].ext25);
                ext26.push(res.data[i].ext26);
                ext27.push(res.data[i].ext27);

            }
        }

        if('截止目前在昆人数'==title){
            chartBar422(rq,ext11,ext12);
        }
        if('截止目前在其他州人数'==title){
            chartBar422(rq,ext11,ext13);
        }
        if('在湖北(含武汉)人数'==title){
            chartBar422(rq,ext11,ext14);
        }
        if('在其他省外人数'==title){
            chartBar422(rq,ext11,ext15);
        }
        /*if('截止目前在昆学生数'==title){
            chartBar422(rq,ext11,ext12);
        }
        if('截止目前在其他州学生数'==title){
            chartBar422(rq,ext11,ext13);
        }
        if('在湖北(含武汉)学生数'==title){
            chartBar422(rq,ext11,ext14);
        }
        if('在其他省外学生数'==title){
            chartBar422(rq,ext11,ext15);
        }*/

        if('有发热、咳嗽、呼吸困难等症状'==title){
            chartBar422(rq,ext12,ext21);
        }
        if('外出后返昆未满15天'==title){
            chartBar422(rq,ext12,ext22);
        }
        if('正在进行隔离观察（治疗）'==title){
            chartBar422(rq,ext12,ext23);
        }
        if('与确诊及疑似密切接触未满15天'==title){
            chartBar422(rq,ext12,ext24);
        }
        if('新发感染病例'==title){
            chartBar422(rq,ext12,ext25);
        }
        if('确诊病例'==title){
            chartBar422(rq,ext12,ext26);
        }
        if('疑似病例'==title){
            chartBar422(rq,ext12,ext27);
        }

    });
}

