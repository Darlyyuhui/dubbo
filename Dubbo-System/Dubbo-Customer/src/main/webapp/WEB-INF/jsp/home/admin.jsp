<%--
  Created by IntelliJ IDEA.
  User: Darly
  Date: 2017/10/11
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <!--標題欄圖標-->
    <link rel="SHORTCUT ICON" href="${resourceUrl}/images/base/logo.ico"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="overview &amp; stats"/>
    <title>${itmsname}</title>

    <!-- 引入 Bootstrap -->
    <link href="${resourceUrl}/basejs/bootstrap/ace/css/bootstrap.min.css" rel="stylesheet">
    <link href="${resourceUrl}/basejs/bootstrap/ace/css/site.min.css" rel="stylesheet">
    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <script src="${root}/basejs/echarts.min.js"></script>
    <!-- 引入 vintage 主题 -->
    <script src="${root}/basejs/dark.js"></script>
</head>
<body>
<tags:header/>
<div class="container tag-body">
    <div class="row">
        <div class="col-md-6">
            <div id="time" style="width: 100%;height: 400px"></div>
        </div>
        <div class="col-md-6">
            <div id="main" style="width: 100%;height: 400px"></div>
        </div>
    </div>
    <p>玩家屬性分部圖</p>
    <div id="user" style="width: 300px;height: 400px"></div>
</div>

<script>
    // 实时监控
    var chart = echarts.init(document.getElementById('time'));
    var data = [];
    var xdata = [];
    var count = 100;
    var now = +new Date()-count*1000;
    var oneDay = 1*1000;
    var value = Math.random() * 10;
    for (var i = 0; i < count; i++) {
        data.push(randomData());
    }
    function randomData() {
        now += oneDay;
        var nnow = new Date(+now);
        value = value + Math.random() * 21 - 10;
        var year = nnow.getFullYear();
        var month = nnow.getMonth() + 1;
        var date = nnow.getDate();
        var hours = nnow.getHours()<10?"0"+nnow.getHours():nnow.getHours();
        var minutes = nnow.getMinutes()<10?"0"+nnow.getMinutes():nnow.getMinutes();
        var seconds = nnow.getSeconds()<10?"0"+nnow.getSeconds():nnow.getSeconds();
        var times = year+"/"+month+"/"+date+" "+ hours+":"+minutes+":"+seconds;

        xdata.push(times);
        return {
            name: times,
            value: [
                times,
                Math.round(value)
            ]
        }
    }
    chart.setOption({
        title: {
            text: '实时监控',subtext: '测试一些虚假数据',
            top: 10,
            bottom: 10,
            left: 10
        },
        tooltip: {
            trigger: 'axis',
            formatter: function (params) {
                params = params[0];
                var date = new Date(params.name);
                return date.getHours()+ ':' + date.getMinutes()+ ':' + date.getSeconds() + ' / ' + params.value[1];
            },
            axisPointer: {
                animation: true
            }
        },
        xAxis: {
            type: 'time',
            data: [],
            splitLine: {
                show: true
            }
        },
        yAxis: {
            type: 'value',
            boundaryGap: [0, '100%'],
            splitLine: {
                show: true
            }
        },
        series: [{
            name: '模拟数据',
            type: 'line',
            showSymbol: true,
            hoverAnimation: true,
            data: data
        }]
    });

    setInterval(function () {
        if (data.length>count){
            data.shift();
            xdata.shift();
        }
        data.push(randomData());
        //更新数据
        var option = chart.getOption();
        option.xAxis.data = xdata;
        option.series[0].data = data;
        chart.setOption(option);
    }, 1000);

</script>
<script>
    // 用户登陆统计
    var chartMain = echarts.init(document.getElementById('main'));
    var Item = function(){
        return {
            name:'',
            data:[],
            type: 'bar',
            animationDelay: function (idx) {
                return idx * 10 + 100;
            }
        }
    };// series中的每一项为一个item,所有的属性均可以在此处定义
    var Series = []; // 准备存放图表数据
    var xAxis = [];
    var data1 = [];
    var user = ['all'];
    var arg = JSON.parse('${xAxisData}');
    for (var i = 0; i < arg.length; i++) {
        xAxis.push(arg[i].date)
        data1.push(arg[i].count)
    }
    var users = JSON.parse('${users}');
    for (var i = 0; i < users.length; i++) {
        user.push(users[i].operatorId)
    }
    var al = new Item();
    al.name = 'all';
    al.data = data1;
    Series.push(al);

    var ausers = JSON.parse('${alluser}');
    for(var key in ausers[0]){
        var it = new Item();
        it.name = key;// 先将每一项填充数据
        var arr = ausers[0][key];

        for(var z=0;z <xAxis.length;z++){
            var isok = false;
            for(var i=0;i <arr.length;i++){
                if (xAxis[z] == arr[i].date){
                    it.data.push(arr[i].count)
                    isok = true;
                }
            }
            if(!isok){
                it.data.push(0);
            }
        }
        Series.push(it);// 将item放在series中
    }

    chartMain.setOption({
        title: {
            text: '用户登陆统计',subtext: '查看所有用户登录情况',
            top: 10,
            bottom: 10,
            left: 10
        },
        legend: {
            type: 'scroll',
            bottom: 10,
            data: user,
        },
        toolbox: {
            feature: {
                magicType: {
                    type: ['stack', 'tiled']
                },
                dataView: {},
                saveAsImage: {
                    pixelRatio: 2
                }
            }
        },
        tooltip: {},
        xAxis: {
            data: xAxis,
            silent: true,
            splitLine: {
                show: false
            }
        },
        yAxis: {
            splitLine: {
                show: true
            }
        },
        series: Series,
        animationEasing: 'elasticOut',
        animationDelayUpdate: function (idx) {
            return idx * 5;
        }
    });
</script>
<script>
    // 玩家屬性分部圖
    var legen = [];
    var serdata = [];
    var serValue = Math.random()*10;
    for (var i = 0; i < 10; i++) {
        var t = serdata[i-1];
        if (t!=null){
            serdata.push(dataSer(t.value,i));
        }else {
            serdata.push(dataSers());
        }
    }
    console.log(serdata)
    function dataSers() {
        //第一组数据
        var name = "预算&实际";
        serValue = serValue + Math.random() * 2000 - 10;
        legen.push(name);
        return {
            name: name,
            value: [
                Math.round(serValue + Math.random() * 10000 - 10),
                Math.round(serValue + Math.random() * 10000 - 10),
                Math.round(serValue + Math.random() * 10000 - 10),
                Math.round(serValue + Math.random() * 10000 - 10),
                Math.random()*2,
                Math.round(serValue + Math.random() * 10000 - 10)
            ]
        }
    }
    function dataSer(par,sr) {
        var name = "预算&实际"+sr;

        legen.push(name);
        return {
            name: name,
            value: [
                Math.round(par[0] + Math.random() *1000),
                Math.round(par[1] + Math.random() *200),
                Math.round(par[2] + Math.random() *1000),
                Math.round(par[3] + Math.random() *300),
                Math.round(par[4]+ Math.random()*0.1),
                Math.round(par[5] + Math.random() *100)
            ]
        }
    }
    var chartMain = echarts.init(document.getElementById('user'));
    chartMain.setOption({
        title: {
            text: '玩家属性'
        },
        tooltip: {},
        legend: {
            type: 'scroll',
            bottom: 10,
            data: legen,
        },
        radar: {
            shape: 'circle',
            name: {
                textStyle: {
                    color: '#fff',
                    backgroundColor: '#999',
                    borderRadius: 3,
                    padding: [3, 5]
                }
            },
            indicator: [
                { name: '力量', max: 20000},
                { name: '智力', max: 20000},
                { name: '敏捷', max: 20000},
                { name: '体能', max: 20000},
                { name: '操作性', max: 5},
                { name: '能量', max: 20000}
            ]
        },
        series: [{
            type: 'radar',
            data : serdata
        }]
    });
</script>
<hr>
<tags:footer/>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="${resourceUrl}/basejs/bootstrap/ace/js/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="${resourceUrl}/basejs/bootstrap/ace/js/bootstrap.min.js"></script>
</body>
</html>

