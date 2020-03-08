$(function(){

    var option = {
        color: ['#72d7e9', '#f5e665'],

        tooltip: {
            trigger: 'axis'
            //formatter: "{b} <br> 合格率: {c}%"
        },
        legend: {
            top:'5%',
            right:'10',
            data: ['新增确诊', '新增疑似'],
            textStyle: {
                fontSize: 12,
                color: '#20E0D9'
            }
        },
        grid: {
            left: '3%',
            right: '5%',
            bottom:10,
            top:'23%',
            containLabel: true
        },

        xAxis: {
            type: 'category',

            data: [],

            axisLabel: {
                show:true,
                color: '#22b3e0',
                fontSize: 12,
                rotate: 30,
                showMaxLabel: true,
            },
            axisLine: {
                lineStyle: {
                    color: '#464f57'
                }
            },
            axisTick: {
                show: false,
            },

        },
        yAxis: {
            type: 'value',
            name: '人',
            nameTextStyle: {
                color: '#22b3e0'
            },
            scale: true,
            axisLabel: {
                color: '#22b3e0',
                fontSize: 12
            },
            axisLine: {
                lineStyle: {
                    color: '#464f57'
                }
            },
            axisTick: {
                show: false,
            },
            splitLine: {
                show: false,
                lineStyle: {
                    color: '#112a2f',
                    type: 'solid'
                }
            },
            minInterval : 1,
            boundaryGap : [ 0, 0.1 ]
        },
        series: [{
            name: '新增确诊',
            type: 'line',
            symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
            symbolSize: 8,
            smooth:0.5,
            itemStyle: {
                normal: {
                    color: "#72d7e9",  // 会设置点和线的颜色，所以需要下面定制 line
                    borderWidth: 8,
                    borderColor: "rgba(255,255,255,0.2)"  // 点边线的颜色
                }
            },
            data: [0, 0, 0, 0, 0, 0, 0,0, 0, 0,
                0, 0]
        },
            {
                name: '新增疑似',
                type: 'line',
                symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                symbolSize: 8,
                smooth:0.5,
                itemStyle: {
                    normal: {
                        color: "#f5e665",  // 会设置点和线的颜色，所以需要下面定制 line
                        borderWidth: 8,
                        borderColor: "rgba(255,255,255,0.2)"
                    }
                },

                data: [0, 0, 0, 0, 0, 0, 0,0, 0, 0,
                    0, 0]
            },
            {
                name: '柱子',
                type: 'bar',
                barGap: '-100%',
                barWidth: 8,
                label: {
                    normal: {
                        color: '#072338'
                    }
                },
                itemStyle: {
                    normal: {
                        barBorderRadius: 25,
                        color: '#072338',
                    }
                },
                z: -12
            }

            ]
    };
    chartLine01.setOption(option);
})
