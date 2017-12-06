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
    <div id="main" style="width: 100%;height: 400px"></div>
</div>
<hr>
<tags:footer/>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="${resourceUrl}/basejs/bootstrap/ace/js/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="${resourceUrl}/basejs/bootstrap/ace/js/bootstrap.min.js"></script>

<script>
    // 第二个参数可以指定前面引入的主题
    var chart = echarts.init(document.getElementById('main'), "dark");
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

    chart.setOption({
        title: {
            text: '用户登陆统计'
        },
        legend: {
            data: user,
            align: 'left'
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
            silent: false,
            splitLine: {
                show: false
            }
        },
        yAxis: {
        },
        series: Series,
        animationEasing: 'elasticOut',
        animationDelayUpdate: function (idx) {
            return idx * 5;
        }
    });
</script>
</body>
</html>