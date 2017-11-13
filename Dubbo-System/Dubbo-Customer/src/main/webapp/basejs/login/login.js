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