<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <!--標題欄圖標-->
    <link rel="SHORTCUT ICON" href="${root}/images/base/logo.ico"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${itmsname}登录异常</title>
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
    <div class="container" align="center">
        您的账号已在其他地方登陆，您被迫下线，请确认你的账户是否已泄露并及时修改密码。
        <p>
            点<a href="${root}/login">这里</a>重新登陆
        </p>
    </div>
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="${root}/basejs/bootstrap/ace/js/jquery.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="${root}/basejs/bootstrap/ace/js/bootstrap.min.js"></script>
</body>
</html>

