
var myChart422 = echarts.init(document.getElementById('chartBar422'));
function chartBar422(rq,allnum,thisnum){
    var x_data = rq,
        bar_data = thisnum,
        line_data = []

    for(var i=0;i<x_data.length;i++){
        if(thisnum[i]!=0){
            line_data.push((thisnum[i]/allnum[i]  * 100).toFixed(2));
        }else{
            line_data.push(0);
        }

    };
    console.log(line_data);

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
            formatter: '{b}<ul><li style="color:#e55b5d;list-style-type:disc">{a0}:{c0}人</li>' +
                '<li style="color:#f5e665;list-style-type:disc">{a1}:{c1}%</li></ul>'
        },
        legend: {
            data: ['人数', '占比'],
            right: "2%",
            top:'5%',
            itemWidth: 25,
            itemHeight: 15,
            itemGap: 20,
            textStyle: {
                fontSize: 12,
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
                    color: '#666'
                }
            },
            axisLabel: {
                fontSize: 12,
                color: "#21b0dd",
                rotate:25,
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
                fontSize: 12
            },
            splitLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLine: {

                lineStyle: {
                    color: '#666'
                }
            },
            axisLabel: {
                fontSize: 12,
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
                    fontSize: 12
                },
                axisTick: {
                    show: false
                },
                axisLine: {
                    lineStyle: {
                        color: '#666'
                    }
                },
                axisLabel: {
                    fontSize: 12,
                    color: "#21b0dd"
                },
                splitLine: {
                    show: false
                },

                position: 'right'
            }
        ],
        series: [{
            name: '人数',
            type: 'bar',
            smooth: true,
            barWidth: 10,
            yAxisIndex: 0,
            itemStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(
                        0, 1, 0, 0, [{
                            offset: 0,
                            color: '#0CADF2'
                        }, {
                            offset: 1,
                            color: '#0AF2B6'
                        }]
                    ),
                    barBorderRadius: 20,
                }

            },
            data: bar_data
        },
            {
                name: '占比',
                type: 'line',

                symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                symbolSize: 8,
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
                barWidth: 10,
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
    myChart422.setOption(option);
}

window.onresize = function () {
    setTimeout(function () {
        myChart422.resize();
    }, 300)
};