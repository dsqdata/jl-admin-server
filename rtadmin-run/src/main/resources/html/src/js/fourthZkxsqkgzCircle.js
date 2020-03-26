// $(function(){

   /* var data = [
         {
            name: "有发热、咳嗽、呼吸困难等症状",
            value: 200
         },
        {
            name: "外出后返昆未满15天",
            value: 400
        },
        {
            name: "正在进行隔离观察（治疗）",
            value: 100
        },
        {
            name: "与确诊及疑似密切接触未满15天",
            value: 100
        },
        {
            name: "新发感染病例",
            value: 100
        },
        {
            name: "确诊病例",
            value: 200
        },
        {
            name: "疑似病例",
            value: 300
        }
    ];



    arrName = getArrayValue(data, "name");
    arrValue = getArrayValue(data, "value");
    sumValue = eval(arrValue.join('+'));
    objData = array2obj(data, "name");
    optionData = getData(data)
    function getArrayValue(array, key) {
        var key = key || "value";
        var res = [];
        if (array) {
            array.forEach(function(t) {
                res.push(t[key]);
            });
        }
        return res;
    }

    function array2obj(array,key) {
        var resObj = {};
        for(var i=0;i<array.length;i++){
            resObj[array[i][key]] = array[i];
        }
        return resObj;
    }



    var placeHolderStyle = {
        normal : {
            color: '#20242B',
            // color: 'transparent',
            label: {show:false},
            labelLine: {show:false}
        },
        emphasis : {////鼠标移入动态的时候显示的默认样式
            // color: 'transparent'
            color: '#20242B',
            label: {show:false}
        }
    };

    var dataStyle = {
        normal: {
            label: {
                show: false
            },
            labelLine: {
                show: false
            },
        }
    };

    function getData(data) {
        var res = {
            series: [],
            yAxis: []
        };
        for (let i = 0; i < data.length; i++) {
            // console.log([70 - i * 15 + '%', 67 - i * 15 + '%']);
            res.series.push({
                name: '',
                type: 'pie',
                clockWise: false, //顺时加载
                hoverAnimation: false, //鼠标移入变大
                radius: [73 - i * 10 + '%', 68 - i * 10 + '%'],
                center: ["30%", "55%"],
                label: {
                    normal: {
                        show: false,
                    }
                },
                itemStyle: dataStyle,
                data: [{
                    value: data[i].value,
                    name: data[i].name
                }, {
                    value: sumValue - data[i].value,
                    name: '',
                    itemStyle: {
                        color: "rgba(0,0,0,0)",
                        borderWidth: 0
                    },
                    tooltip: {
                        show: false
                    },
                    hoverAnimation: false
                }]
            });
            res.series.push({
                name: '',
                type: 'pie',
                silent: true,
                z: 1,
                clockWise: false, //顺时加载
                hoverAnimation: false, //鼠标移入变大
                radius: [73 - i * 10 + '%', 68 - i * 10 + '%'],
                center: ["30%", "55%"],
                label: {
                    normal: {
                        show: false,
                    }
                },
                itemStyle: {
                    label: {
                        show: false,
                    },
                    labelLine: {
                        show: false
                    },
                    borderWidth: 5,
                },
                data: [{
                    value: 7.5,
                    itemStyle: {
                        color: "rgb(3, 31, 62)",
                        borderWidth: 0
                    },
                    tooltip: {
                        show: false
                    },
                    hoverAnimation: false
                }, {
                    value: 2.5,
                    name: '',
                    itemStyle: {
                        color: "rgba(0,0,0,0)",
                        borderWidth: 0
                    },
                    tooltip: {
                        show: false
                    },
                    hoverAnimation: false
                }]
            });
            res.yAxis.push((data[i].value / sumValue * 100).toFixed(2) + "%");
        }
        return res;
    }

    option = {
        backgroundColor:'#000',
        legend: {
            show: true,
            icon:"circle",
            top: "center",
            left: '50%',
            data: arrName,
            width:50,
            padding: [0, 5],
            itemGap: 10,
            formatter: function(name) {
                return "{title|" + name + "} {value|" + (objData[name].value) +"}  {title|人}"
            },
            textStyle: {
                rich: {
                    title: {
                        fontSize: 12,
                        lineHeight: 15,
                        color: "rgb(0, 178, 246)"
                    },
                    value: {
                        fontSize: 12,
                        lineHeight: 20,
                        color: "#fff"
                    }
                }
            },
        },
        tooltip: {
            show: true,
            trigger: "item",
            formatter: "{a}<br>{b}:{c}人({d}%)"
        },
        color:['#dc1439','#e6b600','#053afe','#FE13DB','#FE3BEB','#FEC511','#DC3AFE'],
        grid: {
            top: '16%',
            bottom: '53%',
            left: "30%",
            containLabel: false
        },
        yAxis: [{
            type: 'category',
            inverse: true,
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                interval: 0,
                inside: true,
                textStyle: {
                    color: "#fff",
                    fontSize: 12,
                },
                show: true
            },
            data: optionData.yAxis
        }],
        xAxis: [{
            show: false
        }],
        series: optionData.series
    };*/


//     fourthZkxsqkgzCircle.setOption(option);
// });

function fourthZkxsqkgzCircle(date,school_id,type,ext12,ext21,ext22,ext23,ext24,ext25,ext26,ext27){

    data = [{
            'name': '有发热、咳嗽、呼吸困难等症状',
            'value': ext21
        }, {
            'name': '外出后返昆未满15天',
            'value': ext22
        }, {
            'name': '正在进行隔离观察（治疗）',
            'value': ext23
        }, {
            'name': '与确诊及疑似密切接触未满15天',
            'value': ext24
        },
        {
            'name': '新发感染病例',
            'value': ext25
        },
        {
            'name': '确诊病例',
            'value': ext26
        },
        {
            'name': '疑似病例',
            'value': ext27
        }]

    let arrValue = getArrayValue(data, "value");
    let MaxValue = parseInt(arrValue[0]);
    for (let i = 0; i < arrValue.length - 1; i++) {
        MaxValue = MaxValue < parseInt(arrValue[i+1]) ? parseInt(arrValue[i+1]) : MaxValue
    }

    let seriesObjs = [];
    let r = 130;
    let color = ['#cf2d67', '#f7b632', '#5974f7', '#0063fe', '#fa6b40', '#d145cc', '#f7517f'];
    let placeHolderStyle = {
        normal: {
            label: {
                show: false,
                position: 'center'
            },
            labelLine: {
                show: false
            },
            color: 'rgba(0, 0, 0, 0)',
            borderColor: 'rgba(0, 0, 0, 0)',
            borderWidth: 0
        }
    }

    function getArrayValue(array, key) {
        var key = key || "value";
        var res = [];
        if (array) {
            array.forEach(function(t) {
                res.push(t[key]);
            });
        }
        return res;
    }

    for (let i = 0; i < data.length; i++) {
        //            legendData.push(data[i].name)
        let seriesObj = {
            name: data[i].name,
            type: 'pie',
            clockWise: false,
            center: ['35%', '55%'],
            radius: [r - 1 - i * 18, r - i * 18],
            itemStyle: {
                normal: {
                    label: {
                        show: false,
                        position: 'center'
                    },
                    labelLine: {
                        show: false
                    },
                    borderWidth: 8,
                    shadowBlur: 1,
                    borderColor: color[i],
                    shadowColor: 'rgba(142,152,241, 0.6)'
                }
                //                    emphasis: {
                //                      borderColor: 'rgb(142,152,241)',
                //                      shadowColor: 'rgba(142,152,241, 0.6)'
                //                    }
            },
            hoverAnimation: false,
            data: [{
                value: data[i].value
            }, {
                // value: data[0].value * 4 / 3 - data[i].value,
                value:MaxValue * 4 / 3 - data[i].value,
                name: 'invisible',
                itemStyle: placeHolderStyle
            }]
        }
        seriesObjs.push(seriesObj)
    }
    option = {
        tooltip: {
            show: false,
            formatter: '{a} : {c}'
        },
        legend: {
            orient: 'vertical',
            icon: 'circle',
            itemWidth: 0,
            itemHeight: 0,
            itemGap: 4,
            left: '175',
            top:'35',

            data: ['有发热、咳嗽、呼吸困难等症状','外出后返昆未满15天','正在进行隔离观察（治疗）','与确诊及疑似密切接触未满15天','新发感染病例','确诊病例','疑似病例'],
            formatter:function(name){
                for(var i = 0; i < data.length; i++){
                    if(name==data[i].name){
                        return name + '     ' +'{color' + i + '|'+ data[i].value +'}'+'{font' + i + '|'+ '人'+'}';
                    }
                }
            },
            textStyle: {
                color: '#23B7E5',
                fontSize: 12,
                rich: {

                    color0: {
                        color:'#cf2d67',
                        fontSize: 14,
                        fontWeight:800,
                        padding:[0,5]
                    },
                    color1: {
                        color:'#f7b632',
                        fontSize: 14,
                        fontWeight:800,
                        padding:[0,5]
                    },
                    color2: {
                        color:'#5974f7',
                        fontSize: 14,
                        fontWeight:800,
                        padding:[0,5]
                    },
                    color3: {
                        color:'#0063fe',
                        fontSize: 14,
                        fontWeight:800,
                        padding:[0,5]
                    },
                    color4: {
                        color:'#fa6b40',
                        fontSize: 14,
                        fontWeight:800,
                        padding:[0,5]
                    },
                    color5: {
                        color:'#d145cc',
                        fontSize: 14,
                        fontWeight:800,
                        padding:[0,5]
                    },
                    color6: {
                        color:'#f7517f',
                        fontSize: 14,
                        fontWeight:800,
                        padding:[0,5]
                    },
                    font0: {
                        color:'#cf2d67'
                    },
                    font1: {
                        color:'#f7b632'
                    },
                    font2: {
                        color:'#5974f7'
                    },
                    font3: {
                        color:'#0063fe'
                    },
                    font4: {
                        color:'#fa6b40'
                    },
                    font5: {
                        color:'#d145cc'
                    },
                    font6: {
                        color:'#f7517f'
                    },

                }}

        },
        toolbox: {
            show: false
        },
        series: seriesObjs
    }

    fourthZkxsqkgz.setOption(option);
    fourthZkxsqkgz.on('click',  function (params) {
        $(".schoolMid").show();
        initOrgBoxTitle(params.seriesName);
        YndpFourPeopleMsg(date,school_id,type,params.seriesName);
    });

    fourthZkxsqkgz.on('legendselectchanged', function(obj) {
        var selected = obj.selected;
        var legend = obj.name;
        $(".schoolMid").show();
        initOrgBoxTitle(legend);
        YndpFourPeopleMsg(date,school_id,type,legend);

    });

    window.onresize = function () {
        setTimeout(function () {
            fourthZkxsqkgz.resize();
        }, 300)
    };
}




