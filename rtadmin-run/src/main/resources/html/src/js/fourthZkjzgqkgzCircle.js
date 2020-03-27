
function fourthZkjzgqkgzCircle(date,school_id,type,ext12,ext21,ext22,ext23,ext24,ext25,ext26,ext27){
    debugger;
    data1 = [{
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

    let arrValue1 = getArrayValue(data1, "value");
    let MaxValue1 = parseInt(arrValue1[0]);
    for (let i = 0; i < arrValue1.length - 1; i++) {
        MaxValue1 = MaxValue1 < parseInt(arrValue1[i+1]) ? parseInt(arrValue1[i+1]) : MaxValue1
    }

    let seriesObjs1 = [];
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

    for (let i = 0; i < data1.length; i++) {
        //            legendData.push(data[i].name)
        let seriesObj = {
            name: data1[i].name,
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
                value: data1[i].value
            }, {
                // value: data[0].value * 4 / 3 - data[i].value,
                value:(MaxValue1==0?1:MaxValue1) * 4 / 3 - data1[i].value,
                name: 'invisible',
                itemStyle: placeHolderStyle
            }]
        }
        seriesObjs1.push(seriesObj)
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
            // itemGap: 8,
            // left: '175',
            // top:'20',
            itemGap: 4,
            left: '175',
            top:'35',

            data: ['有发热、咳嗽、呼吸困难等症状','外出后返昆未满15天','正在进行隔离观察（治疗）','与确诊及疑似密切接触未满15天','新发感染病例','确诊病例','疑似病例'],
            formatter:function(name){
                for(var i = 0; i < data1.length; i++){
                    if(name==data1[i].name){
                        return name + '     ' +'{color' + i + '|'+ data1[i].value +'}'+'{font' + i + '|'+ '人'+'}';
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
        series: seriesObjs1
    }

    fourthZkjzgqkgz.setOption(option);
    fourthZkjzgqkgz.on('click',  function (params) {
        $(".schoolMid").show();
        initOrgBoxTitle(params.seriesName);
        YndpFourPeopleMsg(date,school_id,type,params.seriesName);
    });

    fourthZkjzgqkgz.on('legendselectchanged', function(obj) {
        var selected = obj.selected;
        var legend = obj.name;
        $(".schoolMid").show();
        initOrgBoxTitle(legend);
        YndpFourPeopleMsg(date,school_id,type,legend);


        var option = this.getOption();
        var select_value = Object.values(obj.selected);
        select_value.map(res => {
            if(!res){
                 option.legend[0].selected[obj.name] = true;
            }
        });
        this.setOption(option)

    });


    window.onresize = function () {
        setTimeout(function () {
            fourthZkjzgqkgz.resize();
        }, 300)
    };
}




