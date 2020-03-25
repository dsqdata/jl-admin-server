function getXxzs() {
    $.axget("/api/yndp/xxxx/getXxzs", function (res) {
        console.log(res.data)
        initOrgBox01(res.data)
    });
}

function getXxtl() {
    $.axget("/api/yndp/xxxx/getXxtl", function (res) {
        console.log(res.data[0].xxfl)
        initOrgBox02(res.data)
    });
}

var initOrgBox01 = function (data) {
    var html = template('tpl-orgBox01', {data:data});
    document.getElementById('orgBox01').innerHTML = html;
}

var initOrgBox02 = function (data) {
    var html = template('tpl-orgBox02', {xxfl:data});
    document.getElementById('orgBox02').innerHTML = html;
}