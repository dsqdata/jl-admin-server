var jiangxi = "./static/json/data-1518338017111-rJK1gtpUM.json";
var aljd = "./static/json/data-1518338805373-ALJD.json";
var aljdAlsq = "./static/json/data-1518338805373-ALJD-ALSQ.json";
var lyjd = "./static/json/data-1518338805373-LYJD.json";
var lyjdDxcsq = "./static/json/data-1518338805373-LYJD-DXCSQ.json";
var lyjdDcsq = "./static/json/data-1518338805373-LYJD-DCSQ.json";
var lyjdHtpsq = "./static/json/data-1518338805373-LYJD-HTPSQ.json";
var lyjdXxcsq = "./static/json/data-1518338805373-LYJD-XXCSQ.json"


var lyjddlysq = "./static/json/data-1518338805373-LYJD-DLYSQ.json"
var lyjdxlysq = "./static/json/data-1518338805373-LYJD-XLYSQ.json"

var aljdhzsq = "./static/json/data-1518338805373-ALJD-HZSQ.json";
var aljdqssq = "./static/json/data-1518338805373-ALJD-QSSQ.json";
var aljdgpsq = "./static/json/data-1518338805373-ALJD-GPSQ.json";
var aljdpzsq = "./static/json/data-1518338805373-ALJD-PZSQ.json";
var aljdsbsq = "./static/json/data-1518338805373-ALJD-SBSQ.json";
var aljdsbsq = "./static/json/data-1518338805373-ALJD-SBSQ.json";
var aljdynhtsq = "./static/json/data-1518338805373-ALJD-YNHTSQ.json";
var aljdstsq = "./static/json/data-1518338805373-ALJD-STSQ.json";
var aljdyzsq = "./static/json/data-1518338805373-ALJD-YZSQ.json";
var aljdyzsq = "./static/json/data-1518338805373-ALJD-YZSQ.json";
var aljdkcsq = "./static/json/data-1518338805373-ALJD-KCSQ.json";
var aljdbglsq = "./static/json/data-1518338805373-ALJD-BGLSQ.json";
var aljdchsq = "./static/json/data-1518338805373-ALJD-CHSQ.json";
var aljdccsq = "./static/json/data-1518338805373-ALJD-CCSQ.json";
var lyjdglsq = "./static/json/data-1518338805373-LYJD-GLSQ.json";
var lyjdcmsq = "./static/json/data-1518338805373-LYJD-CMSQ.json";
var lyjdnjysq = "./static/json/data-1518338805373-LYJD-NJYSQ.json";
var lyjdnjysq = "./static/json/data-1518338805373-LYJD-NJYSQ.json";
var lyjdslhsq = "./static/json/data-1518338805373-LYJD-SLHSQ.json";
var lyjdsjssq = "./static/json/data-1518338805373-LYJD-SJSSQ.json";

var myMapChart = null;
var myMapOp = null

var onClickAble = true

echarts.extendsMap = function (id, opt) {
    // 实例
    var chart = this.init(document.getElementById(id));
    myMapChart = chart;
    var curGeoJson = {};
    var cityMap = {
        "阿拉街道": aljd,
        "高坡社区": aljdgpsq,
        "海子社区": aljdhzsq,
        "清水社区": aljdqssq,
        "普照社区": aljdpzsq,
        "石坝社区": aljdsbsq,
        "云南航天社区": aljdynhtsq,
        "顺通社区": aljdstsq,
        "云知社区": aljdyzsq,
        "昆船社区": aljdkcsq,
        "八公里社区": aljdbglsq,
        "昌宏社区": aljdchsq,
        "长春社区": aljdccsq,
        "洛羊街道":lyjd,
        "大冲社区":lyjdDcsq,
        "阿拉社区": aljdAlsq,
        "大新册社区":lyjdDxcsq,
        "小新册社区":lyjdXxcsq,
        "黄土坡社区":lyjdHtpsq,
        "大洛羊社区":lyjddlysq,
        "小洛羊社区":lyjdxlysq,
        "果林社区":lyjdglsq,
        "春漫社区":lyjdcmsq,
        "倪家营社区":lyjdnjysq,
        "石龙湖社区":lyjdslhsq,
        "水井山社区":lyjdsjssq
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
            var cityToPinyin = {
                "阿拉街道": "ALA",
                "洛羊街道": "luoyang",

                "高坡社区": "gaopo",
                "海子社区":  "haizi",
                "清水社区": "qingshui",
                "普照社区": "puzhao",
                "石坝社区": "shiba",
                "云南航天社区": "yunnanhangtian",
                "顺通社区": "shuntong",
                "云知社区": "yunzhi",
                "昆船社区": "kunchuang",
                "八公里社区": "bagongli",
                "昌宏社区": "changhong",
                "长春社区": "changchun",



                "大冲社区":"dachong",
                "阿拉社区": "ala",
                "大新册社区":"daxince",
                "小新册社区":"xiaoxince",
                "黄土坡社区":"huangtupo",

                "大洛羊社区":"daluoyang",
                "小洛羊社区":"xiaoluoyang",
                "果林社区":"guolin",
                "春漫社区":"chunman",
                "倪家营社区":"nijiaying",
                "石龙湖社区":"shilonghu",
                "水井山社区":"shuijingshan"




            };
            var breadcrumb = {
                type: 'group',
                id: name,
                left: pos.leftCur + pos.leftPlus-pos.left,
                top: pos.top + 65,
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
                        // handleEvents.initHtml(name)
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
                        var name = this.style.text;
                        // handleEvents.initHtml(name)
                        handleEvents.resetOption(chart, option, name);
                        handleEvents.setData(chart,option,name)
                    }
                }, {
                    type: 'text',
                    left: -68,
                    top: 17,
                    style: {
                        name: name,
                        text: cityToPinyin[name] ? cityToPinyin[name].toUpperCase() : '',
                        textAlign: 'center',
                        fill: style.textColor,
                        font: '12px "Microsoft YaHei", sans-serif',
                    },
                    onclick: function () {
                        // console.log(this.style);
                        var name = this.style.name;
                        // handleEvents.initHtml(name)
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
        initHtml: function( name){
            $.axget1("/api/yndp/glgz/getJgId?jgmc="+ name ,false, function (res) {
                console.log(res.data)
                if(!!res.data && res.data.id)
                    initHtmlNoMap(res.data.id, name,res.data.jglx)
            });
        },
        setData: function (i,option,name) {
            // console.log("name"+name)
            // option.series[1].data =[]
            // option.series[2].data =[]
            // option.series[5].data =[]
            // i.setOption(options, true);
        }
    };

    var option = {
        visualMap: {
            min: 0,
            max: 1000,
            left: 26,
            bottom: 100,
            showLabel: !0,
            text: ["高", "低"],
            textStyle:{
                color: "#ffffff"
            },
            pieces: [{
                gt: 10,
                label: "> 10 人",
                color:  'rgba(250,107,64,0.60)'
            }, {
                gte: 1,
                lt: 10,
                label: "1 - 9 人",
                color:  'rgba(3,176,246,0.60)'
            }, {
                value: 0,
                color: 'rgba(19,187,135,0.60)'
            }],
            show: !0
        },

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
                },
                    {
                        type: 'text',
                        left: 0,
                        top: 50,
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
                        top: 80,
                        style: {
                            text: 'JINGKAIQU',
                            textAlign: 'center',
                            fill: style.textColor,
                            font: '12px "Microsoft YaHei", sans-serif',
                        },
                        onclick: function () {
                            handleEvents.resetOption(chart, option, '经开区');
                        }
                    }
                ]
            }],
        geo: {
            map: opt.mapName,
            roam: true,
            zoom: 0.8,
            label: {
                normal: {
                    show: true,
                    textStyle: {
                        color: '#fff',
                        fontSize: 14,
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
                    areaColor: 'rgba(30,218,226,0.60)',
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
                symbolSize: 5,
                label: {
                    normal: {
                        show: true,
                        formatter: function (params) {
                            return '{fline|' + params.data.username + '}\n{nline|' + params.data.number  + '}\n{tline|' + params.data.address + '}';
                        },
                        position: 'top',
                        backgroundColor: 'rgba(5,20,17,0.7)',
                        padding: [0, 0],
                        borderColor: '#50e3c2',
                        borderWidth: 1,
                        lineHeight: 32,
                        color: '#f7fafb',
                        rich: {
                            fline: {
                                padding: [0, 20],
                                color: '#50e3c2'
                            },
                            nline: {
                                align: 'center',
                                padding: [0, 20],
                                color: '#f8e71c',
                                lineHeight: 10,
                            },
                            tline: {
                                align: 'center',
                                padding: [0, 20],
                                color: '#fff'
                            }
                        }
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#50e3c2'
                    }
                }
            },
            {
                type: 'effectScatter',
                coordinateSystem: 'geo',
                z: 1,
                data: [],
                symbolSize: 5,
                label: {
                    normal: {
                        show: true,
                        formatter: function (params) {
                            return '{fline|' + params.data.username + '}\n{nline|' + params.data.number  + '}\n{tline|' + params.data.address + '}';
                        },
                        position: 'top',
                        backgroundColor: 'rgba(5,20,17,0.7)',
                        padding: [0, 0],
                        borderColor: '#50e3c2',
                        borderWidth: 1,
                        lineHeight: 32,
                        color: '#f7fafb',
                        rich: {
                            fline: {
                                align: 'center',
                                padding: [0, 20],
                                color: '#50e3c2'
                            },
                            nline: {
                                align: 'center',
                                padding: [0, 20],
                                color: '#f8e71c',
                                lineHeight: 10,
                            },
                            tline: {
                                align: 'center',
                                padding: [0, 20],
                                color: '#fff'
                            }
                        }
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#50e3c2'
                    }
                }
            },
            {
                type: 'effectScatter',
                coordinateSystem: 'geo',
                z: 1,
                data: [],
                symbolSize: 5,
                label: {
                    normal: {
                        show: true,
                        formatter: function (params) {
                            return '{fline|' + params.data.username + '}\n{nline|' + params.data.number  + '}\n{tline|' + params.data.address + '}';
                        },
                        position: 'top',
                        backgroundColor: 'rgba(5,20,17,0.7)',
                        padding: [0, 0],
                        borderColor: '#50e3c2',
                        borderWidth: 1,
                        lineHeight: 32,
                        color: '#f7fafb',
                        rich: {
                            fline: {
                                align: 'center',
                                padding: [0, 20],
                                color: '#50e3c2'
                            },
                            nline: {
                                align: 'center',
                                padding: [0, 20],
                                color: '#f8e71c',
                                lineHeight: 10,
                            },
                            tline: {
                                align: 'center',
                                padding: [0, 20],
                                color: '#fff'
                            }
                        }
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#50e3c2'
                    }
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
                            return '{fline|' + params.data.username + '}\n{nline|' + params.data.number  + '}\n{tline|' + params.data.address + '}';
                        },
                        position: 'top',
                        backgroundColor: 'rgba(5,20,17,0.7)',
                        padding: [0, 0],
                        borderColor: '#50e3c2',
                        borderWidth: 1,
                        lineHeight: 32,
                        color: '#f7fafb',
                        rich: {
                            fline: {
                                align: 'center',
                                padding: [0, 20],
                                color: '#50e3c2'
                            },
                            nline: {
                                align: 'center',
                                padding: [0, 20],
                                color: '#f8e71c',
                                lineHeight: 10,
                            },
                            tline: {
                                align: 'center',
                                padding: [0, 20],
                                color: '#fff'
                            }
                        }
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#50e3c2'
                    }
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
    // options = option
    myMapOp = option
    chart.setOption(option);
    // 添加事件
    chart.on('click', function (params) {
        var _self = this;
        if (opt.goDown && params.name !== name[idx]) {
            if(!onClickAble){
                return false
            }
            onClickAble = false
            // handleEvents.initHtml(params.name)
            if (cityMap[params.name]) {
                var url = cityMap[params.name];
                try {
                    $.get(url, function (response) {
                        curGeoJson = response;
                        echarts.registerMap(params.name, response);
                        handleEvents.resetOption(_self, option, params.name);
                        handleEvents.setData(_self,option,params.name)
                        onClickAble = true
                    });
                }catch (e) {
                    onClickAble = true
                }
            }else{
                onClickAble = true
            }
        }
    });

    chart.setMap = function (mapName,subMapName,call) {
        var _self = this;
        // if (mapName.indexOf('区') < 0) mapName = mapName + '区';
        var citySource = cityMap[mapName];
        if (citySource) {
            // var url = './map/' + citySource + '.json';
            $.get(citySource, function (response) {
                // console.log(response);
                curGeoJson = response;
                echarts.registerMap(mapName, response);
                handleEvents.resetOption(_self, option, mapName);
                handleEvents.setData(_self,option,mapName)
                if(call)
                    call(subMapName)
            });
        }
        // handleEvents.resetOption(this, option, mapName);
    };
    chart.setInitData = function(mapName){
        var _self = this;
        handleEvents.setData(_self,option,mapName)
    };
    return chart;
};

function setMyMapChartData(data,name) {
    var td = []
    var map = {}
    for(var i =0 ;i<data.length;i++){
        var item = data[i]
        map[item.jgmc] = item.ljqzs
        var temp = !item.ljqzs ? 0 :item.ljqzs
        td.push({name:item.jgmc,value:temp })
    }

    myMapOp.series[1].data = []
    myMapOp.series[2].data = []
    myMapOp.series[6].data =  []
    myMapChart.setOption(myMapOp, true);
    myMapOp.series[6].data =  td

    if (name === '经开区') {
        var al = !!map['阿拉街道'] ? map['阿拉街道'] : 0
        var ly = !!map['洛羊街道'] ? map['洛羊街道'] : 0
        myMapOp.series[1].data = [{
            name: '',
            visualMap: false,
            username: "阿拉街道",
            address: "疫区来昆人数",
            number: al + "人",
            value: [102.85494405299998, 24.998903901328593]
        }];
        myMapOp.series[2].data = [{
            name: '',
            visualMap: false,
            username: "洛羊街道",
            address: "疫区来昆人数",
            number: ly + "人",
            value: [102.85494405299998, 24.946454769999982]
        }];
    }
    myMapChart.setOption(myMapOp, true);
}
function  echartsMap(data){
    var  ljqzs1='';
    var  ljqzs2='';
    if(data!=null && data!=""&&data.length>1) {
        if (data[0].ljqzs != null && data[0].ljqzs != "") {
            ljqzs1 = data[0].ljqzs;
        }
        if (data[1].ljqzs != null && data[1].ljqzs != "") {
            ljqzs2 = data[1].ljqzs;
        }
    }
    // console.log(data[0].ljqzs)

    var options = null;

    var provinceData = [[ 102.85494405299998, 24.946454769999982]]

// var timer = setInterval(() => {
//数据情况重绘，清除formatter移动效果，也可根据自身需求是否需要，删除这两行代码
    /*option.series[seriesjson[runidx].createType-1].data = [];
    myChart.setOption(option, true);*/

// }, 3000);
}



