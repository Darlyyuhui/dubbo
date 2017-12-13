function darly() {
    if (!(this instanceof darly)){
        return new darly();
    }
}
darly.prototype = {
    //跳转到登录页面
    storeLogin:function (root) {
        window.location.href = root+"/login";
    },
    logout:function (root) {
        isloginout = true;
        window.location.href = root+"/j_spring_security_logout";
    }
}