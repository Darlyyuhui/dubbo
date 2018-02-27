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
    <!-- 分页展示 -->
    <link href="${resourceUrl}/basejs/search/pager.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div align="center">
        <form  id="searcher" onsubmit="return false" action="##"  method="post">
            <span class="s_ipt_wr">
                <input id='KeyWord' name="KeyWord" class="s_ipt"  maxlength="255" value="" autocomplete="off">
            </span>
            <span class="s_btn_wr">
                <input class="bg s_btn"  type="submit" value="Darly搜索" onclick = "loadKey()">
            </span>
        </form>
    </div>
    <div>
        <!--容器-->
        <ul id="listShow"></ul>
        <!--分页容器-->
        <div class="turn-page" id="pager"></div>
        <!--模板-->
        <textarea id="listTemplate" style="display: none;">
			{for item in data}
            <li class="li-item hide"><a href="http://www.baidu.com">\${item.lucenekey}</a><br/><span style="font-size: 12px;color: #2b2b2b;">\${item.id}</span></li>
			{/for}
		</textarea>
    </div>
</div>
<script src="${resourceUrl}/basejs/json/jq/jquery.min.js"></script>
<script src="${resourceUrl}/basejs/search/pager.js"></script>
<script src="${resourceUrl}/basejs/search/template.js"></script>
<script>
    window.onload = function () {
        var text = '${keyword}';
        if (text!=null){
            var key = document.getElementById("KeyWord");
            key.value = text;
            PostData();
        }
    }
    function loadKey() {
        var key = document.getElementById("KeyWord").value;
        if (key != null&&key !=''){
            document.title = key+"_Darly搜索";
            window.history.pushState('', '', "${root}/search/index"+"?keyword="+key);
            PostData();
        }
    }
    function PostData() {
        var form = new FormData(document.getElementById("searcher"));
        $.ajax({
            url: "${root}/search",
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            data: form,
            processData: false,
            contentType: false,
            success: function(msg) {
                if (msg.resCode ==200){
                    var json = { data: [] };
                    json.data = msg.result;
                    $("#listShow").html(TrimPath.processDOMTemplate("listTemplate", json));
                    //调用客户端分页
                    $(this).pager({
                        pageSize: 20, //每一页显示的记录条数
                        pageid: "pager", //分页容器ID
                        itemClass: "li-item" //个体元素名称
                    });
                }
            }
        });
    }
</script>
</body>
</html>