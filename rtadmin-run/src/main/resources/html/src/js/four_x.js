var date1=0
var date2=0
var date3=0
var date4=0


function getXxzs() {
    $.axget("/api/yndp/xxxx/getXxzs", function (res) {
        initOrgBox01(res.data)
    });
}

function getXxtl() {
    $.axget("/api/yndp/xxxx/getXxtl", function (res) {
        initOrgBox02(res.data)
    });
}

function getXxfls() {
    var date=$('#date').val();
    $.axget("/api/yndp/xxxx/getXxfls?date="+date, function (res) {
        date1=res.data[0];
        date2=res.data[1];
        date3=res.data[2];
        date4=res.data[3];
        initOrgBox03(res.data)
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

var initOrgBox03 = function (data) {

    var html1 = template('tpl-orgBox31', {xxfls1:data[0]});
    document.getElementById('orgBox31').innerHTML = html1;

    var html2 = template('tpl-orgBox32', {xxfls2:data[1]});
    document.getElementById('orgBox32').innerHTML = html2;

    var html3 = template('tpl-orgBox33', {xxfls3:data[2]});
    document.getElementById('orgBox33').innerHTML = html3;

    var html4 = template('tpl-orgBox34', {xxfls4:data[3]});
    document.getElementById('orgBox34').innerHTML = html4;
}

var initOrgBox21 = function (data) {
    var html = template('tpl-orgBox21', {xxtjs21:data});
    document.getElementById('orgBox21').innerHTML = html;
}


$('.setPageDiv21').change(function() {
    getXxtjs21(parseInt($(this).val()))
})


function getXxtjs21(num,name) {
    var date=$('#date').val();
    $.axget("/api/yndp/xxxx/getXxtjs21?date="+date+"&name="+name, function (res) {
        //1.计算分页数量
        var showNum = num;
        var dataL = res.data.length;
        var pageNum = Math.ceil(dataL / showNum);

            $('#pagination21').pagination(pageNum, {
                num_edge_entries: 1, //边缘页数
                num_display_entries: 4, //主体页数
                items_per_page: 1, //每页显示1项
                prev_text: "<",
                next_text: ">",
                callback: function(index) {
                    //console.log(index);
                    var html = ''
                    for(var i = showNum * index; i < showNum * index + showNum; i++) {
                        console.log(Number(i)+1)
                        if(i < dataL) {
                            var  a=Number(i)+1;
                            html += '<a href="#" onclick="onclickMap('+res.data[i].school_id+')"><li>'+a+'.'+res.data[i].name+' <font color="red"> '+res.data[i].ext21+'人<font></li></a>'

                        }
                    }

                    $('#page21').html(html)
                }
            })


    })
}
$('.setPageDiv25').change(function() {
    getXxtjs25(parseInt($(this).val()))
})


function getXxtjs25(num,name) {
    var date=$('#date').val();
    $.axget("/api/yndp/xxxx/getXxtjs25?date="+date+"&name="+name, function (res) {
        //1.计算分页数量
        var showNum = num;
        var dataL = res.data.length;
        var pageNum = Math.ceil(dataL / showNum);

            $('#pagination25').pagination(pageNum, {
                num_edge_entries: 1, //边缘页数
                num_display_entries: 4, //主体页数
                items_per_page: 1, //每页显示1项
                prev_text: "<",
                next_text: ">",
                callback: function (index) {
                    //console.log(index);
                    var html = ''
                    for (var i = showNum * index; i < showNum * index + showNum; i++) {
                        if (i < dataL) {
                            var a = Number(i) + 1;
                            html += '<a href="#" onclick="onclickMap(' + res.data[i].school_id + ')"><li>' + a + '.' + res.data[i].name + ' <font color="red">  ' + res.data[i].ext25 + '人</font></li></a>'

                        }
                    }

                    $('#page25').html(html)
                }
            })


    })
}

$('.setPageDiv26').change(function() {
    getXxtjs26(parseInt($(this).val()))
})

function getXxtjs26(num,name) {
    var date=$('#date').val();
    $.axget("/api/yndp/xxxx/getXxtjs26?date="+date+"&name="+name, function (res) {
        //1.计算分页数量
        var showNum = num;
        var dataL = res.data.length;
        var pageNum = Math.ceil(dataL / showNum);

            $('#pagination26').pagination(pageNum, {
                num_edge_entries: 1, //边缘页数
                num_display_entries: 4, //主体页数
                items_per_page: 1, //每页显示1项
                prev_text: "<",
                next_text: ">",
                callback: function (index) {
                    //console.log(index);
                    var html = ''
                    for (var i = showNum * index; i < showNum * index + showNum; i++) {
                        if (i < dataL) {
                            var a = Number(i) + 1;
                            html += '<a href="#"  onclick="onclickMap(' + res.data[i].school_id + ')"><li>' + a + '.' + res.data[i].name + ' <font color="red">  ' + res.data[i].ext26 + '人</font></li></a>'

                        }
                    }

                    $('#page26').html(html)
                }
            })


    })
}
$('.setPageDiv27').change(function() {
    getXxtjs27(parseInt($(this).val()))
})

function getXxtjs27(num,name) {
    var date=$('#date').val();
    $.axget("/api/yndp/xxxx/getXxtjs27?date="+date+"&name="+name, function (res) {
        //1.计算分页数量
        var showNum = num;
        var dataL = res.data.length;
        var pageNum = Math.ceil(dataL / showNum);

            $('#pagination27').pagination(pageNum, {
                num_edge_entries: 1, //边缘页数
                num_display_entries: 4, //主体页数
                items_per_page: 1, //每页显示1项
                prev_text: "<",
                next_text: ">",
                callback: function (index) {
                    //console.log(index);
                    var html = ''
                    for (var i = showNum * index; i < showNum * index + showNum; i++) {
                        if (i < dataL) {
                            var a = Number(i) + 1;
                            html += '<a href="#"  onclick="onclickMap(' + res.data[i].school_id + ')"><li>' + a + '.' + res.data[i].name + ' <font color="red"> ' + res.data[i].ext27 + '人</font></li></a>'

                        }
                    }

                    $('#page27').html(html)
                }
            })

    })
}
    $('.setPageDiv').change(function() {
        getXxtjs(parseInt($(this).val()))
    })

    function getXxtjs(num,name) {
        $.axget("/api/yndp/xxxx/getXxjw?name="+name, function (res) {
            //1.计算分页数量
            var showNum = num;
            var dataL = res.data.length;
            var pageNum = Math.ceil(dataL / showNum);
                $('#pagination').pagination(pageNum, {
                    num_edge_entries: 1, //边缘页数
                    num_display_entries: 4, //主体页数
                    items_per_page: 1, //每页显示1项
                    prev_text: "<",
                    next_text: ">",
                    callback: function (index) {
                        //console.log(index);
                        var html = ''
                        for (var i = showNum * index; i < showNum * index + showNum; i++) {
                            if (i < dataL) {
                                var a = Number(i) + 1;
                                html += '<a href="#" onclick="onclickMap(' + res.data[i].id + ')"><li>' + a + '.' + res.data[i].name + '</li></a>'

                            }
                        }

                        $('#page').html(html)
                    }
                })
        })
    }
function onclickMap(id) {
    var date=$('#date').val();
    var childWindow=$('#mainContent')[0].contentWindow;
    childWindow.sayHello(id,date);
}

function onclick21() {
    event.stopPropagation();
    var ext21 =$('#ext21').val();
    getXxtjs21(5,ext21)
}

function onclick25() {
    event.stopPropagation();
    var ext25 =$('#ext25').val();
    getXxtjs25(5,ext25)
}

function onclick26() {
    event.stopPropagation();
    var ext26 =$('#ext26').val();
    getXxtjs26(5,ext26)
}

function onclick27() {
    event.stopPropagation();
    var ext27 =$('#ext27').val();
    getXxtjs27(5,ext27)
}
function onclick1() {
    event.stopPropagation();
    var ext1 =$('#ext1').val();
    getXxtjs(5,ext1)
}