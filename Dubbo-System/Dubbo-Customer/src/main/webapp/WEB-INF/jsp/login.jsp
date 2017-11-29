<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
    <!--標題欄圖標-->
    <link rel="SHORTCUT ICON" href="${root}/images/base/logo.ico"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link href="${root}/basejs/login/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${root}/basejs/login/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${root}/basejs/login/js/layer.js"></script>
</head>
<title>${itmsname}</title>
<body style="background-color: #e6e6e6;">
<div class="ma">
    <div class="bt"> ${itmsname} &nbsp;V0.0.1</div>
    <div class="bg">
        <div class="tit">
            <a class="tit" href="javascript:Regedit()">
            没有${itmsname}账户，请注册
            </a>
        </div>
        <form action="j_spring_security_check" method="post" id="loginForm" >
            <div class="con">
				<span class="sp">
					<img src="${root}/images/login/user.png" width="25px" height="25px" />
                    <input name="j_username" type="text"  id="user_name" placeholder="用户账号" value=""/>
				</span>
                <span class="sp">
					<img src="${root}/images/login/pass.png" width="25px" height="25px" />
					<input name="j_password" type="password"  id="user_pwd" placeholder="密码" onpaste="return false" onfocus="this.type='password'" autocomplete="off"/>
				</span>
                    <span class="login" onclick="Login()">登 录</span>
            </div>
        </form>
    </div>
</div>
<script>
    $(function(){
        var u_name = getCookie("user_name");
        $("#user_name").val(u_name);
        document.getElementById("user_name").focus();
        $(".top").css("height",$(window).height()*0.4);
        $(window).resize(function() {
            $(".top").css("height",$(window).height()*0.4);
        });
        if('true'=='${param.error}'){
            layer.closeAll('loading');
            layer.tips("账号或密码错误",'#user_name',{
                tips:3,time:2000
            });
            document.getElementById("user_name").focus();
        }
    });
    document.onkeydown = function(e){
        e = e ? e : window.event;
        var keycode = e.which ? e.which : e.keyCode;
        if(keycode == 13){
            Login();
        }
    };
    function Regedit() {
        window.location.href = "${root}/user/regedit";
    }
    
    
    function Login(){
        layer.load(2,{shade:0.3});
        var user_name = $("#user_name").val();
        var user_pwd = $("#user_pwd").val();
        if(""==user_name.replace(/\s/g,"")){
            layer.closeAll('loading');
            layer.tips("请输入用户账号",'#user_name',{
                tips:3,time:2000
            });
            document.getElementById("user_name").focus();
        }else if(""==user_pwd){
            layer.closeAll('loading');
            layer.tips("请输入密码",'#user_pwd',{
                tips:3,time:2000
            });
            document.getElementById("user_pwd").focus();
        }else{
            document.getElementById("loginForm").submit();
        }
    }

    function cookieEnabled(){
        if(!(document.cookie || navigator.cookieEnabled)){
            layer.msg("未记住用户编号、密码,浏览器已被禁用Cookie！",{time: 3000});
            return false;
        }else{
            return true;
        }
    }
    function setCookie(cname, cvalue, exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays*24*60*60*1000));
        var expires = "expires="+d.toUTCString();
        document.cookie = cname + "=" + cvalue + "; " + expires;
    }
    function getCookie(cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for(var i=0;ca.length> i; i++) {
            var c = ca[i];
            while (c.charAt(0)==' ') c = c.substring(1);
            if (c.indexOf(name) != -1)
                return c.substring(name.length, c.length);
        }
        return "";
    }
</script>
<script type="text/javascript" color="0,255,255" opacity='0.6' zIndex="-2" count="100" src="${root}/basejs/login/js/canvas.js"></script>
</body>

</html>