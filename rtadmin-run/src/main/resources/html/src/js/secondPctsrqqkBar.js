$(function() {
    var x_data = ['2002/01/29', '2002/01/29', '2002/01/29', '2002/01/29', '2002/01/29', '2002/01/29'],
        bar_data = ["88", "77", "80", "90", "50", "36"],
        line_data = ["0", "20", "40", "60", "20", "10"],
        line_data1 = ["22", "33", "42", "66", "78", "32"],
        line_data2 = ["11", "33", "55", "32", "44", "55"],
        line_data3 = ["0", "20", "23", "44", "32", "12"]

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
            formatter: '{b}<ul><li style="color:#13e512;list-style-type:disc">{a0}:{c0}个</li>' +
                '<li style="color:#ffde03;list-style-type:disc">{a1}:{c1}个</li>' +
                '<li style="color:#1af8f7;list-style-type:disc">{a2}:{c2}个</li>' +
                '<li style="color:#0614f8;list-style-type:disc">{a3}:{c3}个</li>' +
                '<li style="color:#f8b709;list-style-type:disc">{a4}:{c4}%</li></ul>'
        },
        legend: {
            data: ['疫区来昆游客', '务工返昆', '上学返昆', '近期到过疫区', '其他'],
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
        yAxis: [{
            type: 'value',
            name: '(人)   ',
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
                        color: "#13688a"
                    }
                },

                position: 'right'
            }
        ],
        series: [{
            name: '疫区来昆游客',
            type: 'bar',
            stack: '排查特殊人群情况',
            smooth: true,
            barWidth: 33,
            yAxisIndex: 0,
            itemStyle: {
                normal: {
                    color: 'rgba(61,248,5,0.4)',
                    borderColor: '#13e512'
                }

            },
            data: line_data
        },
            {
                name: '务工返昆',
                type: 'bar',
                stack: '排查特殊人群情况',
                smooth: true,
                barWidth: 33,
                yAxisIndex: 0,
                itemStyle: {
                    normal: {
                        color: 'rgba(254,255,12,0.4)',
                        borderColor: '#ffde03'
                    }

                },
                data: line_data1
            },
            {
                name: '上学返昆',
                type: 'bar',
                stack: '排查特殊人群情况',
                smooth: true,
                barWidth: 33,
                yAxisIndex: 0,
                itemStyle: {
                    normal: {
                        color: 'rgba(11,248,223,0.4)',
                        borderColor: '#1af8f7'
                    }

                },
                data: line_data2
            },
            {
                name: '近期到过疫区',
                type: 'bar',
                stack: '排查特殊人群情况',
                smooth: true,
                barWidth: 33,
                yAxisIndex: 0,
                itemStyle: {
                    normal: {
                        color: 'rgba(26,66,245,0.4)',
                        borderColor: '#0614f8'
                    }

                },
                data: line_data3
            },
            {
                name: '其他',
                type: 'bar',
                stack: '排查特殊人群情况',
                // symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                // symbolSize: 13,
                // smooth: 0.5,
                smooth: true,
                barWidth: 33,
                yAxisIndex: 0,
                itemStyle: {
                    normal: {
                        color:  "rgba(245,160,25,0.5)",  // 会设置点和线的颜色，所以需要下面定制 line
                        borderColor: '#f8b709'
                    }
                },
                yAxisIndex: 1,
                data: line_data
            }
            // ,
            // {
            //     name: '柱子',
            //     type: 'bar',
            //     barGap: '-100%',
            //     barWidth: 33,
            //     label: {
            //         normal: {
            //             color: '#072338'
            //         }
            //     },
            //     tooltip: {
            //         show: false
            //     },
            //     itemStyle: {
            //         normal: {
            //             color: '#072338',
            //         }
            //     },
            //     z: -12,
            //     data: [100, 100, 100, 100, 100, 100]
            // }
        ]
    }
    secondPctsrqqkBar.setOption(option);

    window.onresize = function () {
        setTimeout(function () {
            secondPctsrqqkBar.resize();
        }, 300)
    };



})







