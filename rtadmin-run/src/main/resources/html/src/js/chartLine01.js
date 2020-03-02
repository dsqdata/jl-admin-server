$(function(){
    var myChart = echarts.init(document.getElementById('chartLine01'));

    option = {


        color: ['#3398DB'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            },
            padding: [5, 10],
            formatter: function(params) {
                for (var i = 0; i < params.length; i++) {
                    return params[i].name + '<br>'+ "<span style=' background: #f34853; display: inline-block; border-radius: 10px; width: 7px; height: 7px; margin-right: 5px;'></span>当日新增: " + '111' + "<br><span style=' background: #32b778; display: inline-block; border-radius: 10px; width: 7px; height: 7px; margin-right: 5px;'></span>当日累计: " + params[i].value;
                }

            }
        },
        dataZoom: [{
            type: 'inside',
            start: 0,
            end: 100
        }],

        grid: {
            top:'30',
            left: '20',
            right: '20',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : [ '1月5日', '1月5日', '1月5日', '1月5日', '1月5日', '1月5日', '1月5日', '1月5日','1月5日', '1月5日', '1月5日', '1月5日', '1月5日', '1月5日', '1月5日', '1月5日','1月5日', '1月5日', '1月5日', '1月5日', '1月5日', '1月5日', '1月5日', '1月5日','1月5日', '1月5日', '1月5日', '1月5日', '1月5日', '1月5日', '1月5日', '1月5日'],
                splitLine: {
                    show: false,
                },

                axisLine: {
                    show: false,
                    lineStyle: {
                        color: '#609ee9'
                    }
                },
                axisLabel: {
                    textStyle: {
                        color:'#e3f6fe',
                        fontSize: 14
                    }
                },
            }
        ],
        yAxis : [
            {

                type : 'value',
                name:'单位：件  ',
                nameTextStyle: {
                    color: '#e3f6fe',
                    fontSize: 14
                },
                splitLine: {
                    show: false,
                },
                axisTick: {
                    show: false
                },
                axisLine: {
                    show: false,
                    lineStyle: {
                        color: '#609ee9'
                    }
                },
                axisLabel: {
                    textStyle: {
                        color:'#e3f6fe',
                        fontSize: 14
                    }
                },
            }
        ],

        series : [
            {
                name:'当日累计',
                type:'bar',
                barWidth: '60%',
                data:[100, 52, 200, 234, 290, 230, 220, 52,100, 52, 200, 234, 290, 230, 220, 52,100, 52, 200, 234, 290, 230, 220, 52,100, 52, 200, 234, 290, 230, 220, 52,100, 52, 200, 234, 290, 230, 220, 52,100, 52, 200, 234, 290, 230, 220, 52,100, 52, 200, 234, 290, 230, 220, 52,100, 52, 200, 234, 290, 230, 220, 10],
                label: {
                     normal: {
                         show: true,
                         lineHeight: 22,
                         width: 45,
                         height: 20,
                         backgroundColor: '#092a65',
                         borderRadius: 3,
                         position: 'top',
                         distance: 1,
                         formatter: '{a|{c}}',
                         rich: {
                             a: {
                                 color: '#fff',
                                 align: 'center',
                             }
                         }
                     }
                 },
                itemStyle: {
                    normal: {
                        color:
                            new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: '#34b86f' // 0% 处的颜色
                            }, {
                                offset: 1,
                                color: '#2ab5a0' // 100% 处的颜色
                            }], false),
                        barBorderRadius: [10, 10, 0, 0],
                    },

                }
            }
        ]
    }
    myChart.setOption(option);


    window.onresize = function () {
        setTimeout(function () {
            myChart.resize();

        }, 300)
    };
})
