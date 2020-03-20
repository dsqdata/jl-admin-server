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
            data: ['已住店离观', '离昆', '隔离期过14天', '不在辖区居住地','解除医学观察人员','其他','累计排查总人数','湖北以外其他地方回昆人员','入住指定的如家商旅酒店'],
            textStyle: {
                fontSize: 12,
                color: '#20E0D9'
            }
        },
        grid: {
            left: '3%',
            right: '5%',
            bottom:20,
            top:'23%',
            containLabel: true
        },

        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['01/02','01/03','01/04','01/05','01/06','01/07'],
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
            // name: '人',
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
            }
        },
        series: [
                    {
                        name: '已住店离观',
                        type: 'line',
                        symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                        symbolSize: 8,
                        smooth:0.5,
                        itemStyle: {
                            normal: {
                                color: "#f58b04",  // 会设置点和线的颜色，所以需要下面定制 line
                                borderWidth: 8,
                                borderColor: "rgba(255,255,255,0.2)"  // 点边线的颜色
                            }
                        },
                        data: [120, 132, 101, 134, 90, 230, 210]
                    },
                    {
                        name: '离昆',
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
                        data: [220, 182, 191, 234, 290, 330, 310]
                    },
                    {
                        name: '隔离期过14天',
                        type: 'line',
                        symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                        symbolSize: 8,
                        smooth:0.5,
                        itemStyle: {
                            normal: {
                                color: "#57f527",  // 会设置点和线的颜色，所以需要下面定制 line
                                borderWidth: 8,
                                borderColor: "rgba(255,255,255,0.2)"
                            }
                        },
                        data: [150, 232, 201, 154, 190, 330, 410]
                    },
                    {
                        name: '不在辖区居住地',
                        type: 'line',
                        symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                        symbolSize: 8,
                        smooth:0.5,
                        itemStyle: {
                            normal: {
                                color: "#1c29f5",  // 会设置点和线的颜色，所以需要下面定制 line
                                borderWidth: 8,
                                borderColor: "rgba(255,255,255,0.2)"
                            }
                        },
                        data: [320, 332, 301, 334, 390, 330, 320]
                    }

        ]
    };
    secondYqlkrytjChartLine.setOption(option);
})


