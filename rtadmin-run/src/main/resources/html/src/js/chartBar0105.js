
var myChart105 = echarts.init(document.getElementById('chartBar0105'));
function chartBar0105(rq5,lx5fgl,lx5fgs){
    var x_data = rq5,
        bar_data = lx5fgs,
        line_data = lx5fgl,
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
                data: ['经营企业累计复工企业数量', '复工率'],
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
            yAxis: [{
                type: 'value',
                name: '(户)    ',
                nameTextStyle: {
                    color: "#21b0dd",
                    fontSize: 18
                },
                splitLine: {
                    show: false
                },
                axisTick: {
                    show: false
                },
                axisLine: {

                    show: false
                },
                axisLabel: {
                    fontSize: 18,
                    color: "#21b0dd"
                },
                position: 'left',
            },
                {
                    type: 'value',
                    name: '      %',
                    min: 0,
                    nameTextStyle: {
                        color: "#21b0dd",
                        fontSize: 18
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

                    position: 'right'
                }
            ],
            series: [{
                name: '经营企业累计复工企业数量',
                type: 'bar',
                smooth: true,
                barWidth: 33,
                yAxisIndex: 0,
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
            },
                {
                    name: '复工率',
                    type: 'line',

                    symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                    symbolSize: 13,
                    smooth:0.5,
                    itemStyle: {
                        normal: {
                            color: "#f5e665",  // 会设置点和线的颜色，所以需要下面定制 line
                            borderWidth: 8,
                            borderColor: "rgba(255,255,255,0.5)"
                        }
                    },
                    yAxisIndex: 1,
                    data: line_data
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
    myChart105.setOption(option);
}

window.onresize = function () {
    setTimeout(function () {
        myChart105.resize();
    }, 300)
};