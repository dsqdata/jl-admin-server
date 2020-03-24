//当日疫情动态
function querySituation(currentDate){
    $.axget1("/api/yndp/situation/getSituation?date="+currentDate,false, function (res) {
        if(res.data.length!=0){
            initOrgBoxDryqdt(res.data);
        }else{
            initOrgBoxDryqdt([{id: null,date: null,today_confirmed: null,all_confirmed: null,today_suspected: null,all_suspected: null,today_dlose: null,all_close: null,relieve: null,observation:null,observation_status: null,today_receive: null,today_further: null,today_quarantine: null,ext1: null,ext2: null,ext3: null,ext4: null,ext5: null,ext6: null,ext7: null,ext8: null,ext9: null,ext10: null,ext11: null,ext12: null,create_time: null}]);
        }
    });


    var situationChart = echarts.init(document.getElementById('situationChart'));
    var option = {
        color: ['#72d7e9', '#f5e665'],

        tooltip: {
            trigger: 'axis',
            padding: [10, 10],
            backgroundColor: 'rgba(0,0,0,0.7)',
            extraCssText: 'border: 1px solid #3d7787',
            formatter:function(params) {
                var relVal = params[0].name;
                for (var i = 0, l = params.length; i < l; i++) {

                    if(i==0){
                        relVal += '<br/>' + params[i].marker + params[i].seriesName + ' : ' + (params[i].value == null?'-':params[i].value)+"次";
                    }else{
                        relVal += '<br/>' + params[i].marker + params[i].seriesName + ' : ' + (params[i].value == null?'-':params[i].value)+"人";
                    }
                }
                return relVal;
            }
        },
        legend: {
            top:'5%',
            right:'10',
            itemWidth: 25,
            itemHeight: 15,
            itemGap: 25,
            data: ['接诊人次', '复诊人数', '隔离观察人数'],
            textStyle: {
                fontSize: 18,
                color: '#23b7e5'
            }
        },
        grid: {
            left: '3%',
            right: '8%',
            bottom:20,
            top:'23%',
            containLabel: true
        },

        xAxis: {
            type: 'category',

            data: ['1001/01', '01/011010', '01/01', '01/01', '01/01', '01/01', '01/01' ,
                '01/01', '01/01', '01/01', '01/01' ,'01/0101'],

            axisLabel: {
                color: '#23b7e5',
                fontSize: 18,
            },
            axisLine: {
                lineStyle: {
                    color: '#14688b'
                }
            },
            axisTick: {
                show: false,
            },
        },
        yAxis: {
            type: 'value',
            name: '人/人次       ',
            nameTextStyle: {
                fontSize: 18,
                color: '#22b3e0'
            },
            min:0,
            max:100,
            axisLabel: {
                color: '#22b3e0',
                fontSize: 18
            },
            axisLine: {
                lineStyle: {
                    color: '#14688b'
                }
            },
            axisTick: {
                show: false,
            },
            splitLine: {
                lineStyle: {
                    color:"#13688a"
                }
            },

        },
        series: [{
            name: '接诊人次',
            type: 'line',
            symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
            symbolSize: 13,
            smooth:0.5,
            itemStyle: {
                normal: {
                    color: "#72d7e9",  // 会设置点和线的颜色，所以需要下面定制 line
                    borderWidth: 8,
                    borderColor: "rgba(255,255,255,0.5)"  // 点边线的颜色
                }
            },
            data: [10000, 18200, 12100, 15400, 11000, 20000, 19100,17400, 10000, 14300,
                13100, 12300]
        },
            {
                name: '复诊人数',
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

                data: [13000, 11200, 9100, 11400, 7000, 13000, 15100,12400, 5000, 10300,
                    10100, 9300]
            },
            {
                name: '隔离观察人数',
                type: 'line',
                symbol: "circle",      // 默认是空心圆（中间是白色的），改成实心圆
                symbolSize: 13,
                smooth:0.5,
                itemStyle: {
                    normal: {
                        color: "#fa5858",  // 会设置点和线的颜色，所以需要下面定制 line
                        borderWidth: 8,
                        borderColor: "rgba(255,255,255,0.5)"
                    }
                },

                data: [10000, 1200, 6100, 6400, 4000, 8000, 9100,11400, 4000, 5300,
                    10100, 9300]
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
            //     itemStyle: {
            //         normal: {
            //             color: '#072338',
            //         }
            //     },
            //     z: -12,
            //     data: [20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000]
            // }

        ]
    };
    situationChart.setOption(option);
    // 查询出发热门诊接触弹出echart数据
    $.axget("/api/yndp/situation/getReceive?date="+currentDate, function (res) {
        var MaxY = 100;
        var xArr = [];
        var jzrcArr=[];
        var fzrsArr=[];
        var glgcrsArr=[];
        var allSumArr=[];
        for (let i = 0; i < res.data.length; i++) {
            xArr.push(res.data[i].date);
           // jzrcArr.push(res.data[i].today_receive==null?'0':res.data[i].today_receive);
           // fzrsArr.push(res.data[i].today_further==null?'0':res.data[i].today_further);
           // glgcrsArr.push(res.data[i].today_quarantine==null?'0':res.data[i].today_quarantine)
            jzrcArr.push(res.data[i].today_receive);
            fzrsArr.push(res.data[i].today_further);
            glgcrsArr.push(res.data[i].today_quarantine)

            allSumArr.push(res.data[i].today_receive);
            allSumArr.push(res.data[i].today_further);
            allSumArr.push(res.data[i].today_quarantine);
        }
        var r = allSumArr.filter(function (s) {
            return s && s.trim(); // 注：IE9(不包含IE9)以下的版本没有trim()方法
        });
        //获取Y轴最大值
         MaxY =  Math.max.apply(null,r);
         if (MaxY==-Infinity){
             MaxY=100;
         }

        situationChart.setOption({
            xAxis:{
                data:xArr
            },
            yAxis: {
                min:0,
                max:MaxY+50,
            },
            series:[{
                name: '接诊人次',
                data: jzrcArr
            },
                {
                    name: '复诊人数',
                    data: fzrsArr
                },
                {
                    name: '隔离观察人数',
                    data: glgcrsArr
                }
                // ,
                // {
                //     name: '柱子',
                //     data: [20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000, 20000]
                // }

            ]
        });
    });

}

// 当日疫情动态
var initOrgBoxDryqdt = function (data) {
    var html = template('tpl-orgBoxDryqdt', data[0]);
    document.getElementById('orgBoxDryqdt').innerHTML = html;
}


