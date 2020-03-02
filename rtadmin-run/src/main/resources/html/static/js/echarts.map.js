var jiangxi = "../static/json/data-1518338017111-rJK1gtpUM.json";
var aljd = "../static/json/data-1518338805373-aljd.json";
var aljdAlsq = "../static/json/data-1518338805373-ALJD-ALSQ.json";
var lyjd = "../static/json/data-1518338805373-LYJD.json";
var lyjdDxcsq = "../static/json/data-1518338805373-LYJD-DXCSQ.json";
var lyjdDcsq = "../static/json/data-1518338805373-LYJD-DCSQ.json";
var lyjdHtpsq = "../static/json/data-1518338805373-LYJD-HTPSQ.json";
var lyjdXxcsq = "../static/json/data-1518338805373-LYJD-XXCSQ.json"

var lyjddlysq = "../static/json/data-1518338805373-LYJD-DLYSQ.json"
var lyjdxlysq = "../static/json/data-1518338805373-LYJD-XLYSQ.json"
var options = null;
var myChart = null;

echarts.extendsMap = function (id, opt) {
    // 实例
    var chart = this.init(document.getElementById(id));
    var curGeoJson = {};
    var cityMap = {
        "阿拉街道": aljd,
        "洛羊街道": lyjd,

        "大冲社区":lyjdDcsq,
        "阿拉社区": aljdAlsq,
        "大新册社区":lyjdDxcsq,
        "小新册社区":lyjdXxcsq,
        "黄土坡社区":lyjdHtpsq,

        "大洛羊社区":lyjddlysq,
        "小洛羊社区":lyjdxlysq
    };

    var levelColorMap = {
        '1': 'rgba(241, 109, 115, .8)',
        '2': 'rgba(255, 235, 59, .7)',
        '3': 'rgba(147, 235, 248, 1)'
    };

    var defaultOpt = {
        mapName: 'china',     // 地图展示
        goDown: false,        // 是否下钻
        bgColor: '#404a59',   // 画布背景色
        activeArea: [],       // 区域高亮,同echarts配置项
        data: [],
        // 下钻回调(点击的地图名、实例对象option、实例对象)
        callback: function (name, option, instance) {
        }
    };
    if (opt) opt = this.util.extend(defaultOpt, opt);

    // 层级索引
    var name = [opt.mapName];
    var idx = 0;
    var pos = {
        leftPlus: 110,
        leftCur: 0,
        left: 5,
        top: 10
    };

    var line = [[0, 0], [8, 11], [0, 22]];
    // style
    var style = {
        font: '18px "Microsoft YaHei", sans-serif',
        textColor: '#eee',
        // lineColor: 'rgba(147, 235, 248, .8)'
    };

    var handleEvents = {
        /**
         * i 实例对象
         * o option
         * n 地图名
         **/
        resetOption: function (i, o, n) {
            var breadcrumb = this.createBreadcrumb(n);

            var j = name.indexOf(n);
            var l = o.graphic.length;
            if (j < 0) {
                o.graphic.push(breadcrumb);
                o.graphic[0].children[0].shape.x2 = 145;
                o.graphic[0].children[1].shape.x2 = 145;
                // if (o.graphic.length > 2) {
                //     for (var x = 0; x < opt.data.length; x++) {
                //         if (n === opt.data[x].name + '区' || n === opt.data[x].name + '县') {
                //             o.series[0].data = handleEvents.initSeriesData([opt.data[x]]);
                //             break;
                //         } else o.series[0].data = [];
                //     }
                // }
                name.push(n);
                idx++;
            } else {
                o.graphic.splice(j + 2, l);
                if (o.graphic.length <= 2) {
                    o.graphic[0].children[0].shape.x2 = 60;
                    o.graphic[0].children[1].shape.x2 = 60;
                    //o.series[0].data = handleEvents.initSeriesData(opt.data);
                }
                name.splice(j + 1, l);
                idx = j;
                pos.leftCur -= pos.leftPlus * (l - j - 1);
            }

            o.geo.map = n;
            //o.geo.zoom = 0.6;
            i.clear();
            i.setOption(o);
            //this.zoomAnimation();
            opt.callback(n, o, i);
        },
        /**
         * name 地图名
         **/
        createBreadcrumb: function (name) {
            let cityToPinyin = {
                "阿拉街道": "ALA",
                "洛羊街道": "luoyang",
                "阿拉社区": "ALAJIE",
                "大新册社区":"DAXINCE",
                "小新册社区":"xiaoxince",
                "大冲社区":"dachong",
                "黄土坡社区":"huangtupo",
                "大洛羊社区":"daluoyang",
                "大洛羊社区":"xiaoluoyang"
            };
            let breadcrumb = {
                type: 'group',
                id: name,
                left: pos.leftCur + pos.leftPlus-pos.left,
                top: pos.top + 3,
                children: [{
                    type: 'polyline',
                    left: -90,
                    top: -5,
                    shape: {
                        points: line
                    },
                    style: {
                        stroke: '#fff',
                        key: name
                        // lineWidth: 2,
                    },
                    onclick: function () {
                        var name = this.style.key;
                        handleEvents.resetOption(chart, option, name);
                        handleEvents.setData(chart,option,name)
                    }
                }, {
                    type: 'text',
                    left: -68,
                    top: 'middle',
                    style: {
                        text: name,
                        textAlign: 'center',
                        fill: style.textColor,
                        font: style.font
                    },
                    onclick: function () {
                        let name = this.style.text;
                        handleEvents.resetOption(chart, option, name);
                        handleEvents.setData(chart,option,name)
                    }
                }, {
                    type: 'text',
                    left: -68,
                    top: 10,
                    style: {
                        name: name,
                        text: cityToPinyin[name] ? cityToPinyin[name].toUpperCase() : '',
                        textAlign: 'center',
                        fill: style.textColor,
                        font: '12px "Microsoft YaHei", sans-serif',
                    },
                    onclick: function () {
                        // console.log(this.style);
                        let name = this.style.name;
                        handleEvents.resetOption(chart, option, name);
                        handleEvents.setData(chart,option,name)
                    }
                }]
            }
            pos.leftCur += pos.leftPlus;
            return breadcrumb;
        },
        // 设置effectscatter
        initSeriesData: function (data) {
            var temp = [];
            for (var i = 0; i < data.length; i++) {
                var geoCoord = geoCoordMap[data[i].name];
                if (geoCoord) {
                    temp.push({
                        name: data[i].name,
                        value: geoCoord.concat(data[i].value, data[i].level)
                    });
                }
            }
            return temp;
        },
        zoomAnimation: function () {
            var count = null;
            var zoom = function (per) {
                if (!count) count = per;
                count = count + per;
                // console.log(per,count);
                chart.setOption({
                    geo: {
                        zoom: count
                    }
                });
                if (count < 1) window.requestAnimationFrame(function () {
                    zoom(0.2);
                });
            };
            window.requestAnimationFrame(function () {
                zoom(0.2);
            });
        },
        setData: function (i,option,name) {
            console.log("name"+name)
            option.series[1].data =[]
            option.series[2].data =[]
            option.series[5].data =[]
            i.setOption(options, true);

            if(name == "大新册社区"){
                option.series[2].data = [{
                    name: '',
                    username: "username",
                    telphone: "telphone",
                    address: "address",
                    value: [102.84730911254883,
                        24.92800713812781]
                },{
                    name: '',
                    username: "username",
                    telphone: "telphone",
                    address: "address",
                    value: [102.86190032958984,
                        24.909481126447975]
                }];
                i.setOption(options, true);
            } else if(name == "经开区"){
                option.series[1].data = [{
                    name: '',
                    visualMap: false,
                    username: "阿拉街道",
                    address: "疫区来昆人数：8130人",
                    value: [ 102.85494405299998, 24.998903901328593]
                }];

                option.series[2].data = [{
                    name: '',
                    visualMap: false,
                    username: "洛羊街道",
                    address: "疫区来昆人数：8130人",
                    value: [  102.85494405299998,24.946454769999982]
                }];

                // options.series[5].data = [{
                //     name: '',
                //     username: "username",
                //     telphone: "telphone",
                //     address: "address",
                //     value: [102.85494405299998, 24.946454769999982]
                // }];
                option.series[6].data =  [
                    { name: "阿拉街道", value: 1110 },
                    { name: '洛羊街道', value: 54 },
                    { name: '阿拉社区', value: 13 },
                    { name: '大冲社区', value: 0 },
                    { name: '黄土坡社区', value: 0 },
                    { name: '高坡社区', value: 0 },
                    { name: '普照社区', value: 20 },
                    { name: '石坝社区', value: 20 },
                    { name: '海子社区', value: 20 },
                    { name: '清水社区', value: 20 },
                    { name: '小新册社区', value: 0 },
                    { name: '倪家营社区', value: 20 },
                    { name: '小洛羊社区', value: 20 },
                    { name: '洛龙社区', value: 20 },
                    { name: '大洛羊社区', value: 20 },
                    { name: '大新册社区', value: 20 }

                ];
                i.setOption(option, true);
            }
        }
    };

    var option = {
        visualMap: {
            min: 0,
            max: 1000,
            left: 26,
            bottom: 40,
            showLabel: !0,
            text: ["高", "低"],
            textStyle:{
                color: "#ffffff"
            },
            pieces: [{
                gt: 10000,
                label: "> 10000 人",
                color: "#033250"
            },{
                gte: 1000,
                lte: 10000,
                label: "1000 - 10000 人",
                color: "#064e7b"
            },{
                gte: 500,
                lt: 999,
                label: "500 - 499 人",
                color: "#0d83cf"
            },  {
                gte: 100,
                lt: 500,
                label: "10 - 499 人",
                color: "#11a2f8"
            }, {
                gte: 10,
                lt: 100,
                label: "10 - 99 人",
                color: "#3db2f8"
            }, {
                gte: 1,
                lt: 10,
                label: "1 - 9 人",
                color: "#5fbdf6"
            }, {
                gt: 0,
                lt: 1,
                label: "疑似",
                color: "#77c6f6"
            }, {
                value: 0,
                color: "#ffffff"
            }],
            show: !0
        },
        backgroundColor: opt.bgColor,
        graphic: [
            {
                type: 'group',
                left: pos.left,
                top: pos.top - 4,
                children: [{
                    type: 'line',
                    left: 0,
                    top: -20,
                    shape: {
                        x1: 0,
                        y1: 0,
                        x2: 60,
                        y2: 0
                    },
                    style: {
                        stroke: style.lineColor,
                    }
                }, {
                    type: 'line',
                    left: 0,
                    top: 20,
                    shape: {
                        x1: 0,
                        y1: 0,
                        x2: 60,
                        y2: 0
                    },
                    style: {
                        stroke: style.lineColor,
                    }
                }]
            },
            {
                id: name[idx],
                type: 'group',
                left: pos.left + 2,
                top: pos.top,
                children: [{
                    type: 'polyline',
                    left: 90,
                    top: -12,
                    shape: {
                        points: line
                    },
                    style: {
                        stroke: 'transparent',
                        key: name[0]
                    },
                    onclick: function () {
                        var name = this.style.key;
                        handleEvents.resetOption(chart, option, name);
                    }
                }, {
                    type: 'text',
                    left: 0,
                    top: 'middle',
                    style: {
                        text: name[0] === '经开区' ? '经开区' : name[0],
                        textAlign: 'center',
                        fill: style.textColor,
                        font: style.font
                    },
                    onclick: function () {
                        handleEvents.resetOption(chart, option, '经开区');
                    }
                }, {
                    type: 'text',
                    left: 0,
                    top: 10,
                    style: {
                        text: 'JINGKAIQU',
                        textAlign: 'center',
                        fill: style.textColor,
                        font: '12px "Microsoft YaHei", sans-serif',
                    },
                    onclick: function () {
                        handleEvents.resetOption(chart, option, '经开区');
                    }
                }]
            }],
        geo: {
            map: opt.mapName,
            roam: true,
            zoom: 1,
            label: {
                normal: {
                    show: true,
                    textStyle: {
                        color: '#C4C4C4',
                        fontSize: 20,
                    }
                },
                emphasis: {
                    textStyle: {
                        color: '#fff'
                    }
                }
            },
            itemStyle: {
                normal: {
                    borderColor: 'rgba(147, 235, 248, 1)',
                    borderWidth: 1,
                    areaColor: {
                        type: 'radial',
                        x: 0.5,
                        y: 0.5,
                        r: 0.8,
                        colorStops: [{
                            offset: 0,
                            color: 'rgba(147, 235, 248, 0)' // 0% 处的颜色
                        }, {
                            offset: 1,
                            color: 'rgba(147, 235, 248, .2)' // 100% 处的颜色
                        }],
                        globalCoord: false // 缺省为 false
                    },
                    // shadowColor: '#333',
                    shadowColor: 'rgba(255, 255, 255, .5)',
                    shadowOffsetX: -2,
                    shadowOffsetY: 2,
                    shadowBlur: 10
                },
                emphasis: {
                    areaColor: '#2B91B7',
                    borderWidth: 0
                }
            },
            regions: opt.activeArea.map(function (item) {
                if (typeof item !== 'string') {
                    return {
                        name: item.name,
                        itemStyle: {
                            normal: {
                                areaColor: item.areaColor || '#389BB7'
                            }
                        },
                        label: {
                            normal: {
                                show: item.showLabel,
                                textStyle: {
                                    color: '#fff'
                                }
                            }
                        }
                    }
                } else {
                    return {
                        name: item,
                        itemStyle: {
                            normal: {
                                borderColor: '#91e6ff',
                                areaColor: '#389BB7'
                            }
                        }
                    }
                }
            })
        },
        series: [
            {
                type: 'effectScatter',
                coordinateSystem: 'geo',
                // symbol: 'diamond',
                showEffectOn: 'render',
                rippleEffect: {
                    period: 15,
                    scale: 6,
                    brushType: 'fill'
                },
                hoverAnimation: true,
                itemStyle: {
                    normal: {
                        color: function (params) {
                            return levelColorMap[params.value[3]];
                        },
                        shadowBlur: 10,
                        shadowColor: '#333'
                    }
                },
                data: handleEvents.initSeriesData(opt.data)
            },
            {
                type: 'effectScatter',
                coordinateSystem: 'geo',
                z: 1,
                data: [],
                symbolSize: 14,
                label: {
                    normal: {
                        show: true,
                        formatter: function (params) {
                            return '{fline|' + params.data.username + '}\n{tline|' + params.data.address + '}';
                        },
                        position: 'top',
                        backgroundColor: 'rgba(254,174,33,.8)',
                        padding: [0, 0],
                        borderRadius: 3,
                        lineHeight: 32,
                        color: '#f7fafb',
                        rich: {
                            fline: {
                                align: 'center',
                                padding: [0, 10, 10, 10],
                                color: '#ffffff'
                            },
                            tline: {
                                align: 'center',
                                padding: [10, 10, 0, 10],
                                color: '#ffffff'
                            }
                        }
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    color: '#F4E925',
                }
            },
            {
                type: 'effectScatter',
                coordinateSystem: 'geo',
                z: 1,
                data: [],
                symbolSize: 14,
                label: {
                    normal: {
                        show: true,
                        formatter: function (params) {
                            return '{fline|' + params.data.username + '}\n{tline|' + params.data.address + '}';
                        },
                        position: 'top',
                        backgroundColor: 'rgba(233,63,66,.9)',
                        padding: [0, 0],
                        borderRadius: 3,
                        lineHeight: 32,
                        color: '#ffffff',
                        rich: {
                            fline: {
                                align: 'center',
                                padding: [0, 10, 10, 10],
                                color: '#ffffff'
                            },
                            tline: {
                                align: 'center',
                                padding: [10, 10, 0, 10],
                                color: '#ffffff'
                            }
                        }
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    color: '#e93f42',
                }
            },
            {
                type: 'effectScatter',
                coordinateSystem: 'geo',
                z: 1,
                data: [],
                symbolSize: 14,
                label: {
                    normal: {
                        show: true,
                        formatter: function (params) {
                            return '{fline|' + params.data.username + '}\n{tline|' + params.data.address + '}';
                        },
                        position: 'top',
                        backgroundColor: 'rgba(8,186,236,.9)',
                        padding: [0, 0],
                        borderRadius: 3,
                        lineHeight: 32,
                        color: '#ffffff',
                        rich: {
                            fline: {
                                align: 'center',
                                padding: [0, 10, 10, 10],
                                color: '#ffffff'
                            },
                            tline: {
                                align: 'center',
                                padding: [10, 10, 0, 10],
                                color: '#ffffff'
                            }
                        }
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    color: '#08baec',
                }
            },
            {
                type: 'effectScatter',
                coordinateSystem: 'geo',
                z: 1,
                data: [],
                symbolSize: 14,
                label: {
                    normal: {
                        show: true,
                        formatter: function (params) {
                            return '{fline|' + params.data.username + '}\n{tline|' + params.data.address + '}';
                        },
                        position: 'top',
                        backgroundColor: 'rgba(254,174,33,.8)',
                        padding: [0, 0],
                        borderRadius: 3,
                        lineHeight: 32,
                        color: '#f7fafb',
                        rich: {
                            fline: {
                                align: 'center',
                                padding: [0, 10, 10, 10],
                                color: '#ffffff'
                            },
                            tline: {
                                align: 'center',
                                padding: [10, 10, 0, 10],
                                color: '#ffffff'
                            }
                        }
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    color: '#feae21',
                }
            },
            {
                type: 'custom',
                coordinateSystem: 'geo',
                z: 12,
                silent: true,
                data: [],
                renderItem: function (params, api) {//具体实现自定义图标的方法
                    // console.log(params)
                    return {
                        type: 'image',
                        actionType: "image",// {string} 触发此次重绘的 action 的 type。
                        silent: true,
                        z2: 9999999,
                        style: {
                            image: './sxt.png',
                            width: 30,
                            height: 30,
                            x: api.coord([provinceData[params.dataIndex][0], provinceData[params.dataIndex][1]])[0],
                            y: api.coord([provinceData[params.dataIndex][0], provinceData[params.dataIndex][1]])[1],
                        }
                    }
                }
            },
            {
                name: "确诊病例",
                type: "map",
                geoIndex: 0
            }
        ]
    };
    options = option
    chart.setOption(option);
    // 添加事件
    chart.on('click', function (params) {
        console.log(params);
        var _self = this;
        if (opt.goDown && params.name !== name[idx]) {
            if (cityMap[params.name]) {
                var url = cityMap[params.name];
                $.get(url, function (response) {
                    // console.log(response);
                    curGeoJson = response;
                    echarts.registerMap(params.name, response);
                    handleEvents.resetOption(_self, option, params.name);
                    handleEvents.setData(_self,option,params.name)
                });
            }
        }
    });

    chart.setMap = function (mapName) {
        var _self = this;
        // if (mapName.indexOf('区') < 0) mapName = mapName + '区';
        var citySource = cityMap[mapName];
        if (citySource) {
            var url = './map/' + citySource + '.json';
            $.get(url, function (response) {
                // console.log(response);
                curGeoJson = response;
                echarts.registerMap(mapName, response);
                handleEvents.resetOption(_self, option, mapName);
                handleEvents.setData(_self,option,mapName)
            });
        }
        // handleEvents.resetOption(this, option, mapName);
    };
    chart.setInitData = function(mapName){
        var _self = this;
        handleEvents.setData(_self,option,mapName)
    };
    myChart = chart
    return chart;
};

$.getJSON(jiangxi, function (geoJson) {
    echarts.registerMap('经开区', geoJson);
    var myChart = echarts.extendsMap('chart-panel', {
        bgColor: '#404a59', // 画布背景色
        mapName: '经开区',    // 地图名
        goDown: true,       // 是否下钻
        // 下钻回调
        callback: function (name, option, instance) {
            console.log(name, option, instance);
            myChart.setInitData('经开区')
        },
        // // 数据展示
        // data: [{
        //     name: '南昌',
        //     value: 10,
        //     level: 1
        // }, {
        //     name: '景德镇',
        //     value: 12,
        //     level: 2
        // }, {
        //     name: '萍乡',
        //     value: 11,
        //     level: 3
        // }, {
        //     name: '赣州',
        //     value: 16,
        //     level: 2
        // }, {
        //     name: '吉安',
        //     value: 12,
        //     level: 1
        // }]
    });

    myChart.setInitData('经开区')
})

var provinceData = [[ 102.85494405299998, 24.946454769999982]]


// var timer = setInterval(() => {
//数据情况重绘，清除formatter移动效果，也可根据自身需求是否需要，删除这两行代码
/*option.series[seriesjson[runidx].createType-1].data = [];
myChart.setOption(option, true);*/

// }, 3000);

