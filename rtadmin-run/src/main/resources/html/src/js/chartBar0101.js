
var myChart101 = echarts.init(document.getElementById('chartBar0101'));
function chartBar0101(rq1,lx1fgl,lx1fgs,lx1gy,lx1sm,lx1fdc,lx1jz){
    var x_data = rq1,
        line_data = lx1fgl,
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
                },
                formatter: '{b}<ul><li style="color:#f84d77;list-style-type:disc">{a0}:{c0}个</li>' +
                    '<li style="color:#29ccff;list-style-type:disc">{a1}:{c1}个</li>' +
                    '<li style="color:#f8e71c;list-style-type:disc">{a2}:{c2}个</li>' +
                    '<li style="color:#7ed321;list-style-type:disc">{a3}:{c3}个</li>' +
                    '<li style="color:#f5e665;list-style-type:disc">{a4}:{c4}%</li></ul>'
            },
            legend: {
                data: ['规模以上工业', '限额以上商贸业','房地产企业','资质以上建筑业','复工率'],
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
                name: '(户)   ',
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
                name: '规模以上工业',
                type: 'bar',
                stack: '工业企业',
                smooth: true,
                barWidth: 33,
                yAxisIndex: 0,
                itemStyle: {
                    normal: {
                        color: 'rgba(248,77,119, 0.4)',
                        borderColor: '#f84d77'
                    }

                },
                data: lx1gy
            },
                {
                    name: '限额以上商贸业',
                    type: 'bar',
                    stack: '工业企业',
                    smooth: true,
                    barWidth: 33,
                    yAxisIndex: 0,
                    itemStyle: {
                        normal: {
                            color: 'rgba(41,204,255, 0.4)',
                            borderColor: '#29ccff'
                        }

                    },
                    data: lx1sm
                },
                {
                    name: '房地产企业',
                    type: 'bar',
                    stack: '工业企业',
                    smooth: true,
                    barWidth: 33,
                    yAxisIndex: 0,
                    itemStyle: {
                        normal: {
                            color: 'rgba(248,231,28, 0.4)',
                            borderColor: '#f8e71c'
                        }

                    },
                    data: lx1fdc
                },
                {
                    name: '资质以上建筑业',
                    type: 'bar',
                    stack: '工业企业',
                    smooth: true,
                    barWidth: 33,
                    yAxisIndex: 0,
                    itemStyle: {
                        normal: {
                            color: 'rgba(126,211,33, 0.4)',
                            borderColor: '#7ed321'
                        }

                    },
                    data: lx1jz
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
    myChart101.setOption(option);
}

window.onresize = function () {
    setTimeout(function () {
        myChart101.resize();
    }, 300)
};