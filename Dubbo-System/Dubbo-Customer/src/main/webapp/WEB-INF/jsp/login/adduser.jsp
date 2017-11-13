<%--
  Created by IntelliJ IDEA.
  User: Darly
  Date: 2017/10/18
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
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
    <div>
        <h3>添加用户 </h3>
    </div>
    <form id="inputForm" class="form-horizontal" action="${root}/user/add" method="post" style="margin:0;padding:0;">
        <input type="hidden" id="usname" name="usname"  />
        <input type="hidden" name="puserId" id="puserId" value="${puserId}" />
        <input type="hidden" id="org-name" />
        <div class="mar_5">
            <table class="table table-border-rl table-border-bot bukong-table">
                <tr>
                    <td class="device_td_bg3">姓 名：</td>
                    <td><input style="width:50%; min-width:200px;" type="text" value="${policeName}" id="user-name" placeholder="姓名" name="name" maxlength="10" class="input-large required" specialcharfilter="true" ><font color="red">*</font></td>
                </tr>
                <tr>
                    <td class="device_td_bg3">账 号：</td>
                    <td><input style="width:50%; min-width:200px;" type="text" id="user-account" value="${account}" englishDigits="true" placeholder="账号" name="account" maxlength="20" class="input-large required"><font color="red">*</font></td>
                </tr>
                <tr>
                    <td class="device_td_bg3">登录密码：</td>
                    <td><input style="width:50%; min-width:200px;" type="text" value="123456" id="user-passwd" password="true" placeholder="登陆密码" name="pwd" value="" maxlength="12" class="input-large required" /><font color="red">*</font></td>
                </tr>
                <tr>
                    <td class="device_td_bg3">重复一次：</td>
                    <td><input style="width:50%; min-width:200px;" type="text" value="123456"  name="repeatPasswd" password="true" placeholder="重复一次" value="" equalTo="#user-passwd" maxlength="12" class="input-large required" /><font color="red">*</font></td>
                </tr>
                <tr>
                    <td class="device_td_bg3">IP 控制：</td>
                    <td><input style="width:4%; min-width:20px;" onfocus="ipfocus('iprule1');" id="iprule1" name="iprule1" value="" type="text" maxlength="3" xinghaoDigits="true" />
                        .
                        <input style="width:4%; min-width:20px;" onfocus="ipfocus('iprule2');" id="iprule2" name="iprule2" value="" type="text" maxlength="3" xinghaoDigits="true" />
                        .
                        <input style="width:4%; min-width:20px;" onfocus="ipfocus('iprule3');" id="iprule3" name="iprule3" value="" type="text"  maxlength="3" xinghaoDigits="true" />
                        .
                        <input style="width:4%; min-width:20px;" id="iprule4" name="iprule4" value="" type="text" maxlength="3" xinghaoDigits="true" />
                        (模糊位请输入<font color="red">*</font>号,列如：<font color="red">192.168.***.100</font>)
                    </td>
                </tr>
                <tr>
                    <td class="device_td_bg3">手 机 号：</td>
                    <td><input style="width:50%; min-width:200px;" name="mobile" value="${policeMobile}" id="user-mobile" type="text" value="" placeholder="手机号" mobilephone="true" maxlength="11" /></td>
                </tr>
                <tr>
                    <td class="device_td_bg3">备 注：</td>
                    <td><textarea rows="5" maxlength="100" style="width:50%;min-width:200px;"></textarea> <span></span></td>
                </tr>
            </table>
        </div>
        <div class="btn_line">
            <input id="submit_btn" class="btn btn-info mar_r10" type="submit" value="保存" />
            <input id="cancel_btn" class="btn" type="button" value="返回" />
        </div>
    </form>
</div>

<hr>
<tags:footer/>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="${root}/basejs/bootstrap/ace/js/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="${root}/basejs/bootstrap/ace/js/bootstrap.min.js"></script>
<script>
    var flag = 0;
    var flagip = "";

    //设置值
    function ipfocus(id){
        flagip = id;
        flag = id.substr(id.length - 1 , id.length);
    }

    $(document).keydown(function(event){
        if((event.which == "110" || event.which == "190") && flag == 1 && flagip == "iprule1") {
            $("#iprule2").focus();
            return false;
        }
        if((event.which == "110" || event.which == "190") && flag == 2 && flagip == "iprule2") {
            $("#iprule3").focus();
            return false;
        }
        if((event.which == "110" || event.which == "190") && flag == 3 && flagip == "iprule3") {
            $("#iprule4").focus();
            return false;
        }
    });
</script>
</body>
</html>


