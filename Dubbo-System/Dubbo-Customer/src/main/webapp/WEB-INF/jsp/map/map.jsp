<%--
  Created by IntelliJ IDEA.
  User: Darly
  Date: 2017/11/27
  Time: 11:49
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
    <script src="${root}/map/js/jquery.min.js"></script>
    <script src="http://api.map.baidu.com/api?v=2.0&ak=A1LU7iHS0avqQwPLAxbhKn0UYSQCuRVH"></script>
    <script src="${root}/map/js/jquery.baiduMap.min.js"></script>
    <style>
        .box { width: 100%; height: 600px;}
        #container1{ width: 100%; height: 100%; }
        .list li { height: 34px; line-height: 34px; padding-left: 20px; }
        .list li.active a { color: red; }
    </style>
</head>
<body>
<tags:header/>

    <div class="container tag-body">
        <div class="box">
            <div id="container1"></div>
        </div>
        <div >
            <a href="${resourceUrl}/samply/samply.html">跳转进入采样页面</a>
        </div>
    </div>

<script type="text/javascript">
    var points = [{
        id: 1,
        lng: 118.096525,
        lat: 24.462602,
        title: "厦门中山公园",
        content: ["地址：北京市新建宫门路19号", "电话：010-62881144"]
    }, {
        id: 2,
        lng: 118.095231,
        lat: 24.461615,
        title: "厦门实验小学",
        content: ["地址：北京市后花园风景区", "电话：010-69768087"]
    }, {
        id: 3,
        lng: 118.092644,
        lat: 24.468522,
        title: "厦门光明大厦",
        content: ["地址：北京市东城区景山前街4号", "电话：010-65131892"]
    }, {
        id: 4,
        lng: 118.106586,
        lat: 24.467207,
        title: "厦门将军祠",
        content: ["地址：北京市东城区天坛东里甲1号", "电话：010-67013036"]
    }, {
        id: 5,
        lng: 118.108526,
        lat: 24.474245,
        title: "厦门古龙商城",
        content: ["地址：北京市西城区文津街1号(故宫北)", "电话：010-64040610"]
    }];
    var map = new BaiduMap({
        id: "container1",
        level: 16, //  选填--地图级别--(默认15)
        zoom: true, // 选填--是否启用鼠标滚轮缩放功能--(默认false)
        type: ["地图", "卫星"], // 选填--显示地图类型--(默认不显示)
        width: 320, // 选填--信息窗口width--(默认自动调整)
        height: 70, // 选填--信息窗口height--(默认自动调整)
        titleClass: "title",
        contentClass: "content",
        showPanorama: false, // 是否显示全景控件(默认false)
        showMarkPanorama: true, // 是否显示标注点全景图(默认false)
        showLabel: false, // 是否显示文本标注(默认false)
        mapStyle: "normal", // 默认normal,可选dark,light
        icon: { // 选填--自定义icon图标
            url: "${root}/map/img/marker2.png",
            width: 34,
            height: 94
        },
        centerPoint: { // 中心点经纬度
            lng: 118.106586,
            lat: 24.467207
        },
        index: -1, // 开启对应的信息窗口，默认-1不开启
        animate: true, // 是否开启坠落动画，默认false
        points: points, // 标注点--id(唯一标识)
//        callback: function(id) {
//            $(".list").find("li").eq(id - 1).addClass("active").siblings().removeClass("active");
//        }
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