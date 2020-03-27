/*
$(function(){

    option = {
        title: [
            {
                text: '0人',
                x: 'center',
                y: '38%',
                textStyle: {
                    fontSize: 18,
                    fontWeight: 'normal',
                    fontStyle: 'normal',
                    color: '#f8e71c'
                }
            },
            {
                text: '公安检查点排查',
                x: 'center',
                y: '47%',
                textStyle: {
                    fontSize: 12,
                    fontWeight: '700',
                    fontStyle: 'normal',
                    color: '#23b7e5'
                }
            },
            {
                text: '新增 +0人',
                x: 'center',
                y: '57%',
                textStyle: {
                    fontSize: 12,
                    fontWeight: '700',
                    fontStyle: 'normal',
                    color: '#7ed321'
                }
            }
        ],
        tooltip: {
            trigger: 'item',
            formatter: '{b}: {c} ({d}%)'
        },

        color: ['#fbd249', '#37bc9b'],
        series: [{
            name: '重点人员摸排',
            type: 'pie',
            center: ['50%', '50%'],
            radius: ['42%', '60%'],
            clockwise: false,//是否顺时针
            startAngle: 360,
            avoidLabelOverlap: false,
            itemStyle: { //图形样式
                normal: {
                    borderColor: '#00042c',
                    borderWidth: 3,
                },
            },
            label: {
                normal: {
                    formatter:
                        function(params){
                            var str = ''
                            switch(params.name){
                                case '正常':str =  '{circle01|}{a|'+params.name+'}\n{b|'+params.value+'人}{c|'+params.data.bfb+'%'+'}\n{c|新增 '+'+'+params.data.xzrs+'人}';break;
                                case '异常':str =  '{circle02|}{a|'+params.name+'}\n{b|'+params.value+'人}{c|'+params.data.bfb+"%"+'}\n{c|新增 '+'+'+params.data.xzrs+'人}';break;
                            }
                            return str
                        },



                    rich: {
                        a: {
                            fontSize: 12,

                            align: 'left',
                            padding: 4
                        },
                        b: {
                            fontSize: 11,
                            color: '#fff',
                            fontWeight:'700',
                            align: 'left',
                            padding: [1,10,1,0]
                        },
                        c:{
                            fontSize: 11,
                            color: '#fff',
                            align: 'left',
                            padding: [3,0]
                        },
                        circle01:{
                            backgroundColor: "#f3ce30",
                            width: 9,
                            align: 'left',
                            height: 9 ,
                            borderRadius: 9
                        },
                        circle02:{
                            backgroundColor: "#6364e4",
                            width: 9,
                            align: 'left',
                            height: 9 ,
                            borderRadius: 9
                        },
                        circle03:{
                            backgroundColor: "#0cadf2",
                            width: 9,
                            align: 'left',
                            height: 9,
                            borderRadius: 9
                        },
                        circle04:{
                            backgroundColor: "#ff5959",
                            width: 9,
                            align: 'left',
                            height: 9 ,
                            borderRadius: 9
                        },
                        circle05:{
                            backgroundColor: "#0bd99e",
                            width: 9,
                            align: 'left',
                            height: 9 ,
                            borderRadius: 9
                        },

                    },
                    textStyle: {
                        color: '#029aff'
                    }
                }
            },
            labelLine: {
                normal: {

                    smooth: 0.2,
                    length: 10,
                    length2: 20
                }
            },
            data: [{
                value: 1,
                name: '正常',
                xzrs:22,
                bfb:12
            },
                {
                    value: 2,
                    name: '异常',
                    xzrs:22,
                    bfb:12
                }
            ]
        }]
    }
    chartPie04.setOption(option);


    window.onresize = function () {
        setTimeout(function () {
            chartPie04.resize();

        }, 300)
    };
})
*/


$(function() {
    // var dataChart01 = echarts.init(document.getElementById('jqyknlfx'));
    // var total = result[0]['num']+result[1]['num']+result[2]['num']+result[3]['num']+result[4]['num'];
    var color = ["#30b781", "#ed3d63", "#efd053", "#a139f1", "#7dc3f9"];
    // var xdata = ['1-15岁', "16-25岁", "26-35岁", "36-50岁", '51岁以上'];
    // var ydata = [{
    //     name: '1-15岁',
    //     value: result[0]['num']
    // },
    //     {
    //         name: '16-25岁',
    //         value: result[1]['num']
    //     },
    //     {
    //         name: '26-35岁',
    //         value: result[2]['num']
    //     },
    //     {
    //         name: '36-50岁',
    //         value: result[3]['num']
    //     },
    //     {
    //         name: '51岁以上',
    //         value: result[4]['num']
    //     }
    // ];
    var rich = {
        white: {
            color: '#fff',
            fontSize: 14,
        }
    };
    option = {
        color: color,
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        title: [
            {
                text: '0人',
                x: '25%',
                y: '38%',
                textStyle: {
                    fontSize: 18,
                    fontWeight: 'normal',
                    fontStyle: 'normal',
                    color: '#f8e71c'
                }
            },
            {
                text: '特殊人群',
                x: '21%',
                y: '47%',
                textStyle: {
                    fontSize: 12,
                    fontWeight: '700',
                    fontStyle: 'normal',
                    color: '#23b7e5'
                }
            },
            {
                text: '新增 +0人',
                x: '23%',
                y: '57%',
                textStyle: {
                    fontSize: 12,
                    fontWeight: '700',
                    fontStyle: 'normal',
                    color: '#7ed321'
                }
            }
        ],
        legend: {
            orient: "vartical",
            icon: 'circle',
            x: "left",
            top: "15%",
            left: "60%",
            bottom: "0%",
            data: [],
            selectedMode:false,
            itemWidth: 8,
            itemHeight: 8,
            textStyle: {
                fontSize: 16,
                color: '#fft',
                rich: rich,
            },
            itemGap: 20,
            // formatter: function (name) {
            //     var value = option.series[0].data;
            //     for (var i = 0; i < value.length; i++) {
            //         if (name == value[i].name)
            //             /*return value[i].name + '  ' + '{white|' + Math.round((value[i].value/total)*100) + '%}'*/
            //             return value[i].name + '  ' + '{white|' + value[i].value + '}'
            //     }
            //
            // },
        },
        series: [{
            name: '景区游客年龄分析',
            type: 'pie',
            clockwise: false, //饼图的扇区是否是顺时针排布
            minAngle: 20, //最小的扇区角度（0 ~ 360）
            radius: ["55%", "74%"],
            center: ["30%", "50%"],
            avoidLabelOverlap: false,
            label: {
                normal: {
                    show: false,
                },

            },
            data: []
        }]
    };

    chartPie04.setOption(option);
    chartPie04.resize();
    window.onresize = function () {
        setTimeout(function () {
            chartPie04.resize();
        }, 300)

    };
})