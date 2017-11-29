<%--
  Created by IntelliJ IDEA.
  User: Darly
  Date: 2017/10/18
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <!--標題欄圖標-->
    <link rel="SHORTCUT ICON" href="${sourceUrl}/images/base/logo.ico"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${itmsname}</title>
    <!-- 引入 Bootstrap -->
    <link href="${sourceUrl}/basejs/bootstrap/ace/css/bootstrap.min.css" rel="stylesheet">
    <link href="${sourceUrl}/basejs/bootstrap/ace/css/site.min.css" rel="stylesheet">
    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<tags:header/>

<div class="container tag-body">
    <div>
        <h3>用户列表 </h3>
    </div>
    <div class="table-responsive">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th style="text-align: center">账户</th>
                <th style="text-align: center">昵称</th>
                <th style="text-align: center">密码</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="item">
                <tr style="text-align: center">
                    <td>${item.account}</td>
                    <td>${item.name}</td>
                    <td>${item.pwd}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


    <hr>
    <tags:footer/>
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="${sourceUrl}/basejs/bootstrap/ace/js/jquery.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="${sourceUrl}/basejs/bootstrap/ace/js/bootstrap.min.js"></script>
</body>
</html>


