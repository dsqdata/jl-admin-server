$(function(){
    option = {
        title: [
            {
                text: '0人',
                x: 'center',
                y: '38%',
                textStyle: {
                    fontSize: 18,
                    fontWeight: 'normal',
                    fontStyle: 'normal',
                    color: '#f8e71c'
                }
            },
            {
                text: '特殊人群',
                x: 'center',
                y: '47%',
                textStyle: {
                    fontSize: 12,
                    fontWeight: '700',
                    fontStyle: 'normal',
                    color: '#23b7e5'
                }
            },
            {
                text: '新增 +0人',
                x: 'center',
                y: '57%',
                textStyle: {
                    fontSize: 12,
                    fontWeight: '700',
                    fontStyle: 'normal',
                    color: '#7ed321'
                }
            }
        ],
        tooltip: {
            trigger: 'item',
            formatter: '{b}: {c} ({d}%)'
        },

        color: ['#fbd249', '#37bc9b', '#ff5959', '#0cadf2', '#6464e5'],
        series: [{
            name: '重点人员摸排',
            type: 'pie',
            center: ['50%', '50%'],
            radius: ['42%', '60%'],
            clockwise: false,//是否顺时针
            startAngle: 360,
            avoidLabelOverlap: false,
            itemStyle: { //图形样式
                normal: {
                    borderColor: '#00042c',
                    borderWidth: 3,
                },
            },
            label: {
                normal: {
                    formatter:
                        function(params){
                            var str = ''
                            switch(params.name){
                                // case '务工返昆':str =  '{circle01|}{a|'+params.name+'}\n{b|'+params.value+'人}{c|'+params.data.bfb+'%'+'}\n{c|新增 '+'+'+params.data.xzrs+'人}';break;
                                // case '其他':str =  '{circle02|}{a|'+params.name+'}\n{b|'+params.value+'人}{c|'+params.data.bfb+"%"+'}\n{c|新增 '+'+'+params.data.xzrs+'人}';break;
                                // case '上学返昆':str =  '{circle03|}{a|'+params.name+'}\n{b|'+params.value+'人}{c|'+params.data.bfb+"%"+'}\n{c|新增'+'+'+params.data.xzrs+'人}';break;
                                // case '疫区来昆旅游':str =  '{circle04|}{a|'+params.name+'}\n{b|'+params.value+'人}{c|'+params.data.bfb+"%"+'}\n{c|新增'+'+'+params.data.xzrs+'人}';break;
                                // case '近期到过疫区':str =  '{circle05|}{a|'+params.name+'}\n{b|'+params.value+'人}{c|'+params.data.bfb+"%"+'}\n{c|新增'+'+'+params.data.xzrs+'人}';break;
                                case '务工返昆':str =  '{circle01|}{a|'+params.name+'}\n{b|'+params.value+'人}{c|'+params.data.bfb+'%'+'} {c|新增 '+'+'+params.data.xzrs+'人}';break;
                                case '其他':str =  '{circle02|}{a|'+params.name+'}\n{b|'+params.value+'人}{c|'+params.data.bfb+"%"+'} {c|新增 '+'+'+params.data.xzrs+'人}';break;
                                case '上学返昆':str =  '{circle03|}{a|'+params.name+'}\n{b|'+params.value+'人}{c|'+params.data.bfb+"%"+'} {c|新增'+'+'+params.data.xzrs+'人}';break;
                                case '疫区来昆旅游':str =  '{circle04|}{a|'+params.name+'}\n{b|'+params.value+'人}{c|'+params.data.bfb+"%"+'} {c|新增'+'+'+params.data.xzrs+'人}';break;
                                case '近期到过疫区':str =  '{circle05|}{a|'+params.name+'}\n{b|'+params.value+'人}{c|'+params.data.bfb+"%"+'} {c|新增'+'+'+params.data.xzrs+'人}';break;
                            }
                            return str
                        },
                    rich: {
                        a: {
                            fontSize: 11,
                            align: 'left',
                            padding: 6
                        },
                        b: {
                            fontSize: 11,
                            color: '#fff',
                            fontWeight:'700',
                            align: 'left',
                            padding: [1,10,1,0]
                        },
                        c:{
                            fontSize: 11,
                            color: '#fff',
                            align: 'left',
                            padding: [3,0]
                        },
                        circle01:{
                            backgroundColor: "#f3ce30",
                            width: 9,
                            align: 'left',
                            height: 9 ,
                            borderRadius: 9
                        },
                        circle02:{
                            backgroundColor: "#6364e4",
                            width: 9,
                            align: 'left',
                            height: 9 ,
                            borderRadius: 9
                        },
                        circle03:{
                            backgroundColor: "#0cadf2",
                            width: 9,
                            align: 'left',
                            height: 9,
                            borderRadius: 9
                        },
                        circle04:{
                            backgroundColor: "#ff5959",
                            width: 9,
                            align: 'left',
                            height: 9 ,
                            borderRadius: 9
                        },
                        circle05:{
                            backgroundColor: "#0bd99e",
                            width: 9,
                            align: 'left',
                            height: 9 ,
                            borderRadius: 9
                        },
                    },
                    textStyle: {
                        color: '#029aff'
                    }
                }
            },
            labelLine: {
                normal: {
                    smooth: 0.2,
                    length: 10,
                    length2: 20
                }
            },
            data: [{
                value: 1,
                name: '务工返昆',
                xzrs:22,
                bfb:12
            },
                {
                    value: 2,
                    name: '其他',
                    xzrs:22,
                    bfb:12
                },
                {
                    value: 3,
                    name: '上学返昆',
                    xzrs:22,
                    bfb:12
                },
                {
                    value: 4,
                    name: '疫区来昆旅游',
                    xzrs:22,
                    bfb:12
                },
                {
                    value: 5,
                    name: '近期到过疫区',
                    xzrs:22,
                    bfb:12
                }
            ]
        }]
    }
    chartPie01.setOption(option);


    window.onresize = function () {
        setTimeout(function () {
            chartPie01.resize();

        }, 300)
    };
})
