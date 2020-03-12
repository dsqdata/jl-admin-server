
var myChart = echarts.init(document.getElementById('chartBar0504'));

function chartBar0504(rq,ext1,ext2,ext3,ext4){
    var x_data = rq,


        option = {
            tooltip: {
                trigger: 'axis',
                padding: [10, 10],
                backgroundColor: 'rgba(0,0,0,0.7)',
                extraCssText: 'border: 1px solid #3d7787',
                axisPointer: {
                    type: 'shadow',
                    shadowStyle: {
                        color: 'rgba(67,100,247,0.08)'
                    }
                }
            },
            legend: {
                data: ['基础要素采集APP（个）', '社会信息APP使用量（个）', '核查实有人口（人）','核查从业人员（人）'],
                right: "2%",
                top:'5%',
                itemWidth: 25,
                itemHeight: 15,
                itemGap: 20,
                textStyle: {
                    fontSize: 18,
                    color:'#1d97c0'
                },

            },
            grid: {
                top:'24%',
                left: '3%',
                right: '4%',

                containLabel: true
            },
            xAxis: [{
                axisLine: {
                    lineStyle: {
                        color: '#14688b'
                    }
                },
                axisLabel: {
                    fontSize: 18,
                    color: "#21b0dd"
                },
                type: 'category',
                axisTick: {
                    show: false,
                    alignWithLabel: true
                },
                data: x_data
            }],
            yAxis: [
                {
                    type: 'value',
                    name: '',
                    /*  name: '个/千辆/千人',*/
                    min: 0,
                    nameTextStyle: {
                        color: "#21b0dd",
                        fontSize: 18,
                        padding: [20, 10],
                    },
                    axisTick: {
                        show: false
                    },
                    axisLine: {
                        lineStyle: {
                            color: '#14688b'
                        }
                    },
                    axisLabel: {
                        fontSize: 18,
                        color: "#21b0dd"
                    },
                    splitLine: {
                        lineStyle: {
                            color:"#13688a"
                        }
                    },


                }
            ],
            series: [/*{
                name: '基础要素采集APP（个）',
                type: 'bar',

                barWidth: 33,

                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 1, 0, 0, [{
                                offset: 0,
                                color: '#e55b5d'
                            }, {
                                offset: 1,
                                color: '#ff0a45'
                            }]
                        ),
                        barBorderRadius: [50, 50, 0, 0],
                    }

                },
                data: bar_data
            },*/

                {
                    name: '基础要素采集APP（个）',
                    type: 'line',

                    symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                    symbolSize: 13,
                    smooth:0.5,
                    itemStyle: {
                        normal: {
                            color: "#50e3c2",  // 会设置点和线的颜色，所以需要下面定制 line
                            borderWidth: 8,
                            borderColor: "rgba(255,255,255,0.5)"
                        }
                    },

                    data: ext1
                },
                {
                    name: '社会信息APP使用量（个）',
                    type: 'line',

                    symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                    symbolSize: 13,
                    smooth:0.5,
                    itemStyle: {
                        normal: {
                            color: "#50e3c2",  // 会设置点和线的颜色，所以需要下面定制 line
                            borderWidth: 8,
                            borderColor: "rgba(255,255,255,0.5)"
                        }
                    },

                    data: ext2
                },
                {
                    name: '核查实有人口（人）',
                    type: 'line',

                    symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                    symbolSize: 13,
                    smooth:0.5,
                    itemStyle: {
                        normal: {
                            color: "#ff757a",  // 会设置点和线的颜色，所以需要下面定制 line
                            borderWidth: 8,
                            borderColor: "rgba(255,255,255,0.5)"
                        }
                    },

                    data: ext3
                },
                {
                    name: '核查从业人员（人）',
                    type: 'line',

                    symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                    symbolSize: 13,
                    smooth:0.5,
                    itemStyle: {
                        normal: {
                            color: "#29ccff",  // 会设置点和线的颜色，所以需要下面定制 line
                            borderWidth: 8,
                            borderColor: "rgba(255,255,255,0.5)"
                        }
                    },

                    data: ext4
                },

                {
                    name: '柱子',
                    type: 'bar',
                    barGap: '-100%',
                    barWidth: 33,
                    label: {
                        normal: {
                            color: '#072338'
                        }
                    },
                    tooltip: {
                        show: false
                    },
                    itemStyle: {
                        normal: {
                            color: '#072338',
                        }
                    },
                    z: -12,
                    data: [100, 100, 100, 100, 100, 100]
                }
            ]
        }
    myChart.setOption(option);



}
window.onresize = function () {
    setTimeout(function () {
        myChart.resize();

    }, 300)
};