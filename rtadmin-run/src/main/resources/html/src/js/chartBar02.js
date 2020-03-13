var myChart02 = echarts.init(document.getElementById('chartBar02'));
function chartBar02(rq,today,wed1,wynzh1,wyngj1,yq1) {
    var x_data = rq,
        line_data = today,
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
            formatter: '{b}<ul><li style="color:#f84d77;list-style-type:disc">{a0}:{c0}人</li>' +
                '<li style="color:#29ccff;list-style-type:disc">{a1}:{c1}人</li>' +
                '<li style="color:#f8e71c;list-style-type:disc">{a2}:{c2}人</li>' +
                '<li style="color:#7ed321;list-style-type:disc">{a3}:{c3}人</li>' +
                '<li style="color:#f5e665;list-style-type:disc">{a4}:{c4}人</li></ul>'
        },
        legend: {
            data: ['威尔登酒店', '维也纳智好酒店', '维也纳国际酒店', '云琪酒店', '新增人数'],
            right: "2%",
            top: '5%',
            itemWidth: 25,
            itemHeight: 15,
            itemGap: 20,
            textStyle: {
                fontSize: 18,
                color: '#1d97c0'
            },

        },
        grid: {
            top: '24%',
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
                name: '人      ',
                min: "dataMin",
                nameTextStyle: {
                    color: "#21b0dd",
                    padding: [20, 10],
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
                        color: "#13688a"
                    }
                },


            }
        ],
        series: [{
            name: '威尔登酒店',
            type: 'bar',
            stack: "总量",
            smooth: true,
            barWidth: 33,
            yAxisIndex: 0,
            itemStyle: {
                normal: {
                    color: 'rgba(248,77,119, 0.4)',
                    borderColor: '#f84d77'
                }

            },
            data: wed1,
        },
            {
                name: '维也纳智好酒店',
                type: 'bar',
                stack: "总量",
                smooth: true,
                barWidth: 33,
                yAxisIndex: 0,
                itemStyle: {
                    normal: {
                        color: 'rgba(41,204,255, 0.4)',
                        borderColor: '#29ccff'
                    }

                },
                data: wynzh1,
            },
            {
                name: '维也纳国际酒店',
                type: 'bar',
                stack: "总量",
                smooth: true,
                barWidth: 33,
                yAxisIndex: 0,
                itemStyle: {
                    normal: {
                        color: 'rgba(248,231,28, 0.4)',
                        borderColor: '#f8e71c'
                    }

                },
                data: wyngj1,
            },
            {
                name: '云琪酒店',
                type: 'bar',
                stack: "总量",
                smooth: true,
                barWidth: 33,
                yAxisIndex: 0,
                itemStyle: {
                    normal: {
                        color: 'rgba(126,211,33, 0.4)',
                        borderColor: '#7ed321'
                    }

                },
                data: yq1,
            },
            {
                name: '新增人数',
                type: 'line',

                symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                symbolSize: 13,
                smooth: 0.5,
                itemStyle: {
                    normal: {
                        color: "#f5e665",  // 会设置点和线的颜色，所以需要下面定制 line
                        borderWidth: 8,
                        borderColor: "rgba(255,255,255,0.5)"
                    }
                },

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
    myChart02.setOption(option);
}

    window.onresize = function () {
        setTimeout(function () {
            myChart02.resize();

        }, 300)
    };

