$(function() {
    var x_data = ['2002/01/01', '2002/01/02', '2002/01/05', '2002/01/10', '2002/01/12', '2002/01/14'],
        line_data = ["0", "20", "40", "60", "20", "10"],
        line_data1 = ["22", "33", "42", "66", "78", "32"],
        line_data2 = ["11", "33", "55", "32", "44", "55"],

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
                textStyle : {
                    fontSize: 12
                },
                formatter:function(params) {
                    var relVal = params[0].name;
                    for (var i = 0; i < params.length; i++) {

                        if(i==0){
                            relVal += '<br/>' + params[i].marker + params[i].seriesName + ' : ' + (params[i].value == null?'-':params[i].value)+"人";
                        }else{
                            relVal += '<br/>' + params[i].marker + params[i].seriesName + ' : ' + (params[i].value == null?'-':params[i].value)+"人";
                        }
                    }
                    return relVal;
                }
            },
            legend: {
                data: ['来昆游客', '务工求学回昆人员', '近期到过疫区人员'],
                right: "10",
                top: '5%',
                itemWidth: 25,
                itemHeight: 10,
                itemGap: 20,
                textStyle: {
                    fontSize: 12,
                    color: '#1d97c0'
                }
            },
            grid: {
                top: '24%',
                left: '3%',
                right: '4%',
                containLabel: true
            },
            xAxis: [{
                axisLabel: {
                    color: '#22b3e0',
                    fontSize: 12,
                    rotate: 30
                },
                axisLine: {
                    lineStyle: {
                        color: '#464f57'
                    }
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

                    fontSize: 12
                },
                axisTick: {
                    show: false
                },
                axisLabel: {
                    color: '#22b3e0',
                    fontSize: 12
                },
                axisLine: {
                    lineStyle: {
                        color: '#464f57'
                    }
                },

                splitLine: {
                    show: false,
                    lineStyle: {
                        color: '#112a2f',
                        type: 'solid'
                    }
                }
            }
            ],
            series: [{
                name: '来昆游客',
                type: 'bar',
                stack: '登记在册人员排查',
                smooth: true,
                barWidth: 33,
                yAxisIndex: 0,
                itemStyle: {
                    normal: {
                        color: 'rgba(248,175,22,0.4)',
                        borderColor: '#f58e0b'
                    }

                },
                data: line_data
            },
                {
                    name: '务工求学回昆人员',
                    type: 'bar',
                    stack: '登记在册人员排查',
                    smooth: true,
                    barWidth: 33,
                    yAxisIndex: 0,
                    itemStyle: {
                        normal: {
                            color: 'rgba(26,19,229,0.4)',
                            borderColor: '#1827ff'
                        }

                    },
                    data: line_data1
                },
                {
                    name: '近期到过疫区人员',
                    type: 'bar',
                    stack: '登记在册人员排查',
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
                }
            ]
        }
    secondDjzcrypcBar.setOption(option);

    window.onresize = function () {
        setTimeout(function () {
            secondDjzcrypcBar.resize();
        }, 300)
    };



})







