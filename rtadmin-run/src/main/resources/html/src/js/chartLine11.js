$(function(){
    var myChart11 = echarts.init(document.getElementById('chartLine11'));
    var option = {
        color: ['#72d7e9', '#f5e665'],

        tooltip: {
            trigger: 'axis',
            padding: [10, 10],
            backgroundColor: 'rgba(0,0,0,0.7)',
            extraCssText: 'border: 1px solid #422931',

        },

        grid: {
            left: 0,
            right: 30,
            bottom:10,
            top:10,
            containLabel: true
        },

        xAxis: {
            type: 'category',

            data: ['1001/01', '01/011010', '01/01', '01/01', '01/01', '01/01', '01/01' ,
                '01/01', '01/01', '01/01', '01/01' ,'01/0101'],

            axisLabel: {
                show: false,
            },
            axisLine: {
                lineStyle: {
                    color: '#0f526b'
                }
            },
            axisTick: {
                show: false,
            },
        },
        yAxis: {
            type: 'value',
            min:0,
            max:20000,
            axisLabel: {
                show: false,
            },
            axisLine: {
                show: false,
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

        },
        series: [{
            name: '新增确诊',
            type: 'line',
            symbolSize: 4,
            smooth:0.5,
            itemStyle: {
                normal: {
                    color: "#ff0944",  // 会设置点和线的颜色，所以需要下面定制 line

                }
            },
            data: [10000, 18200, 12100, 15400, 11000, 20000, 19100,17400, 10000, 14300,
                13100, 12300]
        },
        ]
    };
    myChart11.setOption(option);
})
