<%--
  Created by IntelliJ IDEA.
  User: Darly
  Date: 2017/10/18
  Time: 10:53
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
<div class="container tag-body">
    <div class="col-md-3">
        <ul class="list-group">
            <li class="list-group-item"><a href="javascript:studyShow(0);">如何建立${itmsname}网站？</a></li>
            <li class="list-group-item"><a href="javascript:studyShow(1);">如何建立缓存机制？</a></li>
            <li class="list-group-item"><a href="javascript:studyShow(2);">如何关联数据库？</a></li>
            <li class="list-group-item"><a href="javascript:studyShow(3);">如何进行接口调用？</a></li>
            <li class="list-group-item"><a href="javascript:studyShow(4);">WebSocket建立机制？</a></li>
            <li class="list-group-item"><a href="javascript:studyShow(5);">Redis+Spring Security？</a></li>
        </ul>
    </div>
    <div class="col-md-9">
        <div id="study-0">
            ${studys.get(0).remark}
        </div>
        <div id="study-1" style="display: none">
            ${studys.get(1).remark}
        </div>
        <div id="study-2" style="display: none">
            ${studys.get(2).remark}
        </div>
        <div id="study-3" style="display: none">
            ${studys.get(3).remark}
        </div>
        <div id="study-4" style="display: none">
            ${studys.get(4).remark}
        </div>
        <div id="study-5" style="display: none">
            ${studys.get(5).remark}
        </div>
    </div>
</div>
<hr>
<tags:footer/>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="${root}/basejs/bootstrap/ace/js/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="${root}/basejs/bootstrap/ace/js/bootstrap.min.js"></script>
<script>
    function studyShow(num) {
        if (num == 0){
            document.getElementById("study-0").style.display="inline";
            document.getElementById("study-1").style.display="none";
            document.getElementById("study-2").style.display="none";
            document.getElementById("study-3").style.display="none";
            document.getElementById("study-4").style.display="none";
            document.getElementById("study-5").style.display="none";
        }else if (num == 1){
            document.getElementById("study-0").style.display="none";
            document.getElementById("study-1").style.display="inline";
            document.getElementById("study-2").style.display="none";
            document.getElementById("study-3").style.display="none";
            document.getElementById("study-4").style.display="none";
            document.getElementById("study-5").style.display="none";
        }else if (num == 2){
            document.getElementById("study-0").style.display="none";
            document.getElementById("study-1").style.display="none";
            document.getElementById("study-2").style.display="inline";
            document.getElementById("study-3").style.display="none";
            document.getElementById("study-4").style.display="none";
            document.getElementById("study-5").style.display="none";
        }else if (num == 3){
            document.getElementById("study-0").style.display="none";
            document.getElementById("study-1").style.display="none";
            document.getElementById("study-2").style.display="none";
            document.getElementById("study-3").style.display="inline";
            document.getElementById("study-4").style.display="none";
            document.getElementById("study-5").style.display="none";
        }else if (num == 4){
            document.getElementById("study-0").style.display="none";
            document.getElementById("study-1").style.display="none";
            document.getElementById("study-2").style.display="none";
            document.getElementById("study-3").style.display="none";
            document.getElementById("study-4").style.display="inline";
            document.getElementById("study-5").style.display="none";
        }else if (num == 5){
            document.getElementById("study-0").style.display="none";
            document.getElementById("study-1").style.display="none";
            document.getElementById("study-2").style.display="none";
            document.getElementById("study-3").style.display="none";
            document.getElementById("study-4").style.display="none";
            document.getElementById("study-5").style.display="inline";
        }
    }
</script>
</body>
</html>
