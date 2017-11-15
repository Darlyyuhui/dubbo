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
    <link rel="SHORTCUT ICON" href="${root}/images/base/logo.ico"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${itmsname}</title>
    <!-- 引入 Bootstrap -->
    <link href="${root}/basejs/bootstrap/ace/css/bootstrap.min.css" rel="stylesheet">
    <link href="${root}/basejs/bootstrap/ace/css/site.min.css" rel="stylesheet">
    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<tags:header/>
<div class="container tag-body" >
    <div class="row">
        <!--导航条-->
        <nav class="navbar navbar-inverse" style="background-color:#696969">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-4 col-sm-6 col-xs-6">
                        <img style="padding: 4px" src="${root}/images/samply/ic_back_title.png"/>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-6">
                        <span style="width: 90%">现场采样</span>
                    </div>
                    <div class="col-md-3 col-sm-6 col-xs-6">
                        <span style="width: 90%">现场采样</span>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</div>
<hr>
<tags:footer/>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="${root}/basejs/bootstrap/ace/js/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="${root}/basejs/bootstrap/ace/js/bootstrap.min.js"></script>
</body>
</html>