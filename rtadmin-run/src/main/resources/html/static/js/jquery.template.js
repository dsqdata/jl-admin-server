/**
 * jq 扩展插件 依赖 jquery-*.min.js
 * 如使用Template 依赖 template-web.js
 *
 * 注意：Template 异步处理数据，如同步处理请嵌套使用
 */
(function($, window, document, undefined) {
    if(!window.tempFunction) {
        window.tempFunction = {};
    }
    var AjaxElement = function() {} //定义AjaxElement的构造函数
    AjaxElement.prototype = { //定义AjaxElement的方法
        getAjaxHttp: function() {
            var xmlHttp;
            try {
                xmlHttp = new XMLHttpRequest(); // Firefox, Opera 8.0+, Safari
                console.log(xmlHttp)
            } catch(e) {
                console.log(e)
                try { // Internet Explorer
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch(e) {
                    try {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch(e) {
                        alert("您的浏览器不支持AJAX！");
                        return false;
                    }
                }
            }
            return xmlHttp;
        },
        ajaxRequest: function(url, methodtype, con, parameter, callback) {
            var xmlhttp = this.getAjaxHttp();
            xmlhttp.onreadystatechange = function() {
                if(xmlhttp.readyState == 4) {
                    //HTTP响应已经完全接收才调用
                    callback(xmlhttp);
                }
            };
            xmlhttp.open(methodtype, url, con);
            xmlhttp.setRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=1.8");
            xmlhttp.setRequestHeader("Content-Type", "text/plain");
            xmlhttp.send(parameter);
        },
        tlProcessAjax: function(templateConfigureObj, func) {
            console.log(templateConfigureObj)
            if(tempFunction[templateConfigureObj.id]) {
                func(tempFunction[templateConfigureObj.id])
            } else {
                this.ajaxRequest(templateConfigureObj.src, 'get', true, null, function(http) {
                    //预编译模版
                    console.log(http)
                    console.log(10)
                    console.log(http.responseText)
                    var temp = template.compile(http.responseText.replace(/^\s*|\s*$/g, ""));
                    tempFunction[templateConfigureObj.id] = temp
                    func(tempFunction[templateConfigureObj.id])
                });
            }
        }
    }

    /**
     * 向本几点Append模版（选中目标的结尾插入）
     * @param {Object} templateConfigureObj
     * @param {Object} data
     * @param {Object} endMethod
     */
    $.fn.tlProcessAppend = function(templateConfigureObj, data, endMethod) {
        var element = this;
        if(!templateConfigureObj) {
            throw "请检查模版配置";
        }
        var ajaxElement = new AjaxElement();
        ajaxElement.tlProcessAjax(templateConfigureObj, function(func) {
            element.append(func(data))
            if(endMethod) {
                endMethod();
            }
        });
    }
    /**
     * 向本几点prepend模版（在标签开始的地方插入）
     * @param {Object} templateConfigureObj
     * @param {Object} data
     * @param {Object} endMethod
     */
    $.fn.tlProcessPrepend = function(templateConfigureObj, data, endMethod) {
        var element = this;
        if(!templateConfigureObj) {
            throw "请检查模版配置";
        }
        var ajaxElement = new AjaxElement();
        ajaxElement.tlProcessAjax(templateConfigureObj, function(func) {
            element.prepend(func(data))
            if(endMethod) {
                endMethod();
            }
        });
    }

    /**
     * 向本几点before模版（在标签前面插入）
     * @param {Object} templateConfigureObj
     * @param {Object} data
     * @param {Object} endMethod
     */
    $.fn.tlProcessBefore = function(templateConfigureObj, data, endMethod) {
        var element = this;
        if(!templateConfigureObj) {
            throw "请检查模版配置";
        }
        var ajaxElement = new AjaxElement();
        ajaxElement.tlProcessAjax(templateConfigureObj, function(func) {
            element.before(func(data))
            if(endMethod) {
                endMethod();
            }
        });
    }

    /**
     * 向本几点after模版（被选元素之后插入内容）
     * @param {Object} templateConfigureObj
     * @param {Object} data
     * @param {Object} endMethod
     */
    $.fn.tlProcessAfter = function(templateConfigureObj, data, endMethod) {
        var element = this;
        if(!templateConfigureObj) {
            throw "请检查模版配置";
        }
        var ajaxElement = new AjaxElement();
        ajaxElement.tlProcessAjax(templateConfigureObj, function(func) {
            element.after(func(data))
            if(endMethod) {
                endMethod();
            }
        });
    }

    /**
     *
     */
    $.fn.tlProcess = function() {
        var element = this;
        var templateConfigureObj = arguments[0];
        var data = arguments[1];
        var method = arguments[2];
        var endMethod = arguments[3];
        if(!method) {
            method = 'append';
        }
        if(!templateConfigureObj) {
            throw "请检查模版配置";
        }
        var ajaxElement = new AjaxElement();
        ajaxElement.tlProcessAjax(templateConfigureObj, function(func) {
            element[method](func(data))
            if(endMethod) {
                endMethod();
            }
        });
    }

    /**
     * js截取字符串，中英文都能用 ，如果给定的字符串大于指定长度，截取指定长度返回，否者返回源字符串。
     * @param str：需要截取的字符串
     * @param len: 需要截取的长度
     */
    $.interceptStr = function(str, len) {
        var str_length = 0;
        var str_len = 0;
        str_cut = new String();
        str_len = str.length;
        for(var i = 0; i < str_len; i++) {
            a = str.charAt(i);
            str_length++;
            if(escape(a).length > 4) {
                str_length++; //中文字符的长度经编码之后大于4
            }
            str_cut = str_cut.concat(a);
            if(str_length >= len) {
                str_cut = str_cut.concat("...");
                return str_cut;
            }
        }
        if(str_length < len) { //如果给定字符串小于指定长度，则返回源字符串；
            return str;
        }
    }

})(jQuery, window, document);
