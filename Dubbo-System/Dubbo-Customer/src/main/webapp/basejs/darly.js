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
        window.location.href = root+"/j_spring_security_logout";
    },
    storehome:function (root) {
        window.location.href = root+"/storehome";
    },
    //跳转商城管理首页
    onstoreoperationindex:function (root) {
        window.location.href = root+"/option/index";
    },
    //商品录入页面
    onproductentry:function (root) {
        window.location.href = root+"/option/productentry";
    },
    //活动录入页面
    onactivityentry:function (root) {
        window.location.href = root+"/option/activityentry";
    }
}