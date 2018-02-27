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
<html lang="zh-CN" style="height: 100%">
<head>
    <!--標題欄圖標-->
    <link rel="SHORTCUT ICON" href="${resourceUrl}/images/base/logo.ico"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${itmsname}</title>
    <style>
        .copyright {font-size: 12px; bottom:20px; POSITION:absolute; z-index:100;width: 100%;}
        *{
            padding: 0;
            margin: 0;
            border: 0;
        }
        .s_ipt_wr{border:1px solid #0a95da;border-color:#0a95da #0a95da #0a95da #0a95da;background:#fff;display:inline-block;vertical-align:top;width:539px;height:34px;margin-right:0;border-right-width:0;border-color:#b8b8b8 transparent #ccc #b8b8b8;overflow:hidden}
        .s_ipt{width:526px;height:22px;font:16px/18px arial;line-height:22px;margin:6px 0 0 7px;padding:0;background:transparent;border:0;outline:0;-webkit-appearance:none}
        .s_btn_wr{margin-left:-5px;width:auto;height:auto;border-bottom:1px solid transparent;*border-bottom:0}
        .s_btn{width:100px;height:36px;color:#fff;font-size:15px;letter-spacing:1px;background:#0a95da;border-bottom:1px solid #2d78f4;outline:medium;*border-bottom:0;-webkit-appearance:none;-webkit-border-radius:0;border: 0;outline: none}
    </style>
</head>
<body style="height: 100%">
<div style="height: 35%;">
</div>
<div align="center">
    <img style="padding: 20px" src="${resourceUrl}/images/login/ic_darly_logo_index.png">
    <form id="searcher" onsubmit="return false" action="##"  method="post">
        <span class="s_ipt_wr">
            <input name="wd" class="s_ipt" id="kw" maxlength="255" value="" autocomplete="off">
        </span>
        <span class="s_btn_wr">
            <input class="bg s_btn"  type="submit" value="Darly搜索" onclick = "nextPage()">
        </span>
    </form>
    <div class="copyright" align="center">
        <p>Copyright &copy; 2018.Company name All rights reserved.</p>
    </div>
</div>
<script>
    function nextPage() {
        var keyword = document.getElementById('kw').value;
        window.location.href = "${root}/search/index"+"?keyword="+keyword;
    }
</script>
</body>
</html>