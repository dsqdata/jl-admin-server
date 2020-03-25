$(function() {
    var x_data = ['2002/01/29', '2002/01/30', '2002/02/01', '2002/02/02'],
        line_data = ["0", "20", "40", "60", "20", "10"],
        line_data1 = ["22", "33", "42", "66", "78", "32"],


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
                for (var i = 0;i< params.length; i++) {
                    if(i==0){
                        relVal += '<br/>' + params[i].marker + params[i].seriesName + ' : ' + (params[i].value == null?'-':params[i].value+"人");
                    }else{
                        relVal += '<br/>' + params[i].marker + params[i].seriesName + ' : ' + (params[i].value == null?'-':params[i].value)+"人";
                    }
                }
                return relVal;
            }

        },
        legend: {
            data: ['男性', '女性'],
            right: "2%",
            top: '5%',
            itemWidth: 25,
            itemHeight: 15,
            itemGap: 20,
            textStyle: {
                fontSize: 12,
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
            axisLabel: {
                show:true,
                color: '#22b3e0',
                fontSize: 12,
                rotate: 30,
                showMaxLabel: true,
            },
            axisTick: {
                show: false,
            },
            type: 'category',
            data: x_data
        }],
        yAxis: [{
            type: 'value',
            name: '(人)   ',
            nameTextStyle: {
                color: "#21b0dd",
                fontSize: 12
            },
            scale: true,
            axisLabel: {
                color: '#22b3e0',
                fontSize: 12
            },
            splitLine: {
                show: true
            },
            axisLine: {
                show: false
            },
                position: 'left',
            }
        ],
        series: [{
            name: '男性',
            type: 'bar',
            stack: '入住留验点人员情况',
            smooth: true,
            barWidth: 33,
            yAxisIndex: 0,
            itemStyle: {
                normal: {
                    color: 'rgba(6,20,248,0.4)',
                    borderColor: '#1a13e5'
                }

            },
            data: line_data
        },
            {
                name: '女性',
                type: 'bar',
                stack: '入住留验点人员情况',
                smooth: true,
                barWidth: 33,
                yAxisIndex: 0,
                itemStyle: {
                    normal: {
                        color: 'rgba(248,142,31,0.4)',
                        borderColor: '#f8a681'
                    }

                },
                data: line_data1
            }
        ]
    }
    secondRzlydryBar.setOption(option);

    window.onresize = function () {
        setTimeout(function () {
            secondRzlydryBar.resize();
        }, 300)
    };



})







