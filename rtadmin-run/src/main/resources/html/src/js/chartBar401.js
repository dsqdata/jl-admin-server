
function chartBar401(date,school_id,type,ext11,ext12,ext13,ext14,ext15){
        var ext11=ext11;
        option = {

            tooltip: {
                show: false,
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c}人"
            },
            legend: {
                show: false,
                x: 'center',

                data: ['在湖北(含武汉)教职工数', '在其他省外教职工数', '截止目前在其他州教职工数', '截止目前在昆教职工数'],
                icon: 'circle',
                textStyle: {
                    color: '#fff',
                }
            },
            calculable: true,
            series: [{
                name: '',
                type: 'pie',
                //起始角度，支持范围[0, 360]
                startAngle: 0,
                //饼图的半径，数组的第一项是内半径，第二项是外半径
                radius: [25, 100],
                //支持设置成百分比，设置成百分比时第一项是相对于容器宽度，第二项是相对于容器高度
                center: ['50%', '15%'],
                //是否展示成南丁格尔图，通过半径区分数据大小。可选择两种模式：
                // 'radius' 面积展现数据的百分比，半径展现数据的大小。
                //  'area' 所有扇区面积相同，仅通过半径展现数据大小
                roseType: 'area',
                //是否启用防止标签重叠策略，默认开启，圆环图这个例子中需要强制所有标签放在中心位置，可以将该值设为 false。
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: true,
                        //clickable:true,
                        formatter: //"{b}:{c}人"
                            function(params){ //标签内容
                                return  params.name+':'+'\n'+params.value+'人('+(params.value / ext11 * 100).toFixed(2) + "%)"
                            },

                    },
                    emphasis: {
                        show: true
                    }
                },
                labelLine: {
                    normal: {
                        show: true,
                        length2: 1,
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: [{
                    value: ext14,
                    name: '在湖北(含武汉)教职工数',
                    itemStyle: {
                        normal: {
                            color: '#0CADF2'
                        }
                    }
                },
                    {
                        value: ext15,
                        name: '在其他省外教职工数',
                        itemStyle: {
                            normal: {
                                color: '#FBD249'
                            }
                        }
                    },
                    {
                        value: ext13,
                        name: '截止目前在其他州教职工数',
                        itemStyle: {
                            normal: {
                                color: '#FF5959'
                            }
                        }
                    },
                    {
                        value: ext12,
                        name: '截止目前在昆教职工数',
                        itemStyle: {
                            normal: {
                                color: '#6464E5'
                            }
                        }
                    },

                    {
                        value: 0,
                        name: "",
                        itemStyle: {
                            normal: {
                                color: 'transparent'
                            }
                        },
                        label: {
                            show: false
                        },
                        labelLine: {
                            show: false
                        }
                    },
                    {
                        value: 0,
                        name: "",
                        itemStyle: {
                            normal: {
                                color: 'transparent'
                            }
                        },
                        label: {
                            show: false
                        },
                        labelLine: {
                            show: false
                        }
                    },
                    {
                        value: 0,
                        name: "",
                        itemStyle: {
                            normal: {
                                color: 'transparent'
                            }
                        },
                        label: {
                            show: false
                        },
                        labelLine: {
                            show: false
                        }
                    },
                    {
                        value: 0,
                        name: "",
                        itemStyle: {
                            normal: {
                                color: 'transparent'
                            }
                        },
                        label: {
                            show: false
                        },
                        labelLine: {
                            show: false
                        }
                    }

                ]
            }]
        };

    myChart401.setOption(option);
    myChart401.on('click',  function (params) {
        $(".schoolMid").show();
        initOrgBoxTitle(params.name);
        YndpFourPeopleMsg(date,school_id,type,params.name);
    });
}

window.onresize = function () {
    setTimeout(function () {
        myChart401.resize();
    }, 300)
};