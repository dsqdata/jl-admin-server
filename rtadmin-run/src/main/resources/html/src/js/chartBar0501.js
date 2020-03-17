
var myChart501 = echarts.init(document.getElementById('chartBar0501'));
var myChart502 = echarts.init(document.getElementById('chartBar0502'));
var myChart503 = echarts.init(document.getElementById('chartBar0503'));
var myChart504 = echarts.init(document.getElementById('chartBar0504'));
function chartBar0501(rq,ext1,ext2,ext3,ext4){
    var x_data = rq;
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
                formatter:function(params) {
                    var relVal = params[0].name;
                    for (var i = 0, l = params.length; i < l; i++) {
                        if(i==0){
                            var pValue="";
                            if(params[i].value==""||params[i].value==null){
                                pValue="-";
                            }else{
                                pValue=params[i].value;
                            }
                            relVal += '<br/>' + params[i].marker + params[i].seriesName + ' : ' + pValue;
                        }else{
                           var pValue="";
                            if(params[i].value==""||params[i].value==null){
                                pValue="-";
                            }else{
                                pValue=params[i].value;
                            }
                            relVal += '<br/>' + params[i].marker + params[i].seriesName + ' : ' + pValue;
                        }
                    }
                    return relVal;
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
            series: [

                {
                    name: '基础要素采集APP（个）',
                    type: 'line',

                    symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                    symbolSize: 13,
                    smooth:0.5,
                    itemStyle: {
                        normal: {
                            color: "#f8e71c",  // 会设置点和线的颜色，所以需要下面定制 line
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
    myChart501.setOption(option);
    myChart502.setOption(option);
    myChart503.setOption(option);
    myChart504.setOption(option);


}
window.onresize = function () {
    setTimeout(function () {
        myChart501.resize();
        myChart502.resize();
        myChart503.resize();
        myChart504.resize();
    }, 300)
};