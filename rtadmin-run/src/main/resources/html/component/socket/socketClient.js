//新建webSocket，接收到信息后调用回调方法
var initWebSocket = function (id,callback) {


    // ws地址 -->这里是你的请求路径
    var ws = socketUrl + id;
    console.log(ws)
    var websock = new WebSocket(ws);

    websock.onmessage = function (e) {
        callback(JSON.parse(e.data));
    }

    websock.onclose = function (e) {
        console.log(e);
    }

    websock.onopen = function () {
        console.log('开启连接');
    }
    // 连接发生错误的回调方法
    websock.onerror = function () {
        console.log('WebSocket连接发生错误');
    }

}

