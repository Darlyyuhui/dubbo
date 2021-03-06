<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<div class="container" align="center">
    <div class="row">
        <!--导航条-->
        <nav class="navbar navbar-inverse" style="background-color:#696969">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a class="navbar-brand" href="javascript:onindex();">${itmstitle}</a>
                </div>

                <div class="collapse navbar-collapse pull-right" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="javascript:onsearch();">
                                <span style="font-size:16px">全局搜索</span>
                            </a>
                        </li>

                        <li>
                            <a href="javascript:onmap();">
                                <span style="font-size:16px">地图展示</span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:oncheckjson();">
                                <span style="font-size:16px">JSON验证</span>
                            </a>
                        </li>
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" >
                                <span style="font-size:16px">辅助说明</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="javascript:onnginxftp();">
                                        <span style="font-size:16px">Nginx静态服务器建立</span>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="javascript:onGradleAar();">
                                        <span style="font-size:16px">Android Gradle上传aar</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:showSecondMenu();">
                                <span style="font-size:16px">搭建服务器</span>
                            </a>
                        </li>
                        <c:choose>
                            <c:when test="${hasUser}">
                                <li>
                                    <a href="javascript:onstoreoperation();">
                                        <span style="font-size:16px">商城管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:onlandy();">
                                        <span style="font-size:16px">外接页面</span>
                                    </a>
                                </li>
                                <li class="dropdown">
                                    <i data-toggle="dropdown" class="dropdown-toggle" style="background-color: transparent">
                                        <img class="img-circle" style="width: 42px;height: 42px" src="${resourceUrl}/images/login/ic_user.png"/>
                                        <span class="user-info" style="font-size:16px;color:#cccfd3">
                                            <small style="padding-top:15px">欢迎你,</small>
                                                ${userName }
                                        </span>
                                        <i class="glyphicon glyphicon-chevron-down"></i>
                                    </i>
                                    <ul class="dropdown-menu" style="background-color: #b2b2b2">
                                        <li>
                                            <a href="#modal-Profile" data-toggle="modal" data-backdrop="static">
                                                <i class="glyphicon glyphicon-user"></i>修改密码
                                            </a>
                                        </li>
                                        <li class="divider"></li>
                                        <li>
                                            <a href="#modal-Profile_out" data-toggle="modal" data-backdrop="static">
                                                <i class="glyphicon glyphicon-off"></i> 安全退出
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="javascript:login();" style="text-align: center">
                                        <span style="font-size:16px">登录</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="row" style="margin-top: -20px;">
        <!--轮播图-->
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="3000">
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="${root}/images/lbt01.jpg" alt="图片不存在" >
                </div>
                <div class="item">
                    <img src="${root}/images/lbt02.jpg" alt="图片不存在">
                </div>
                <div class="item">
                    <img src="${root}/images/lbt03.jpg" alt="图片不存在">
                </div>
            </div>

            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev" target="_self">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next" target="_self">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            </a>
        </div>
    </div>
</div>
<!-- 修改密码 -->
<div id="modal-Profile" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    修改密码
                </div>
            </div>
            <div class="modal-body no-padding">
                <form class="form-horizontal" id="updatePasd" role="form" action="${root}/system/user/changepasswd"
                      method="post">
                    <div class="form-group" style="margin-top: 10px;">
                        <label class="col-sm-3 control-label no-padding-right" for="pasd">原密码 </label>

                        <div class="col-sm-9">
                            <input type="password" id="pasd" name="old" class="form-control required"
                                   style="width: 80%"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="pasd1">新密码 </label>

                        <div class="col-sm-9">
                            <input type="password" id="pasd1" name="pwd" class="form-control required"
                                   style="width: 80%"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="pasd2">确认新密码</label>

                        <div class="col-sm-9">
                            <input type="password" name="pasd2" id="pasd2" class="form-control" required
                                   style="width: 80%"/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer no-margin-top" style="padding-top:8px;padding-bottom:8px;">
                <span class="text-warning" id="upPasdMsg"></span>
                <button class="btn btn-primary btn-xs" type="button" onclick="return upPasd();">
                    <i class="glyphicon glyphicon-ok"></i>
                    修改
                </button>
                <button class="btn btn-xs" class="close" data-dismiss="modal" aria-hidden="true">
                    <i class="glyphicon glyphicon-remove"></i>
                    关闭
                </button>
            </div>
        </div>
    </div>
</div>
<!-- 退出登录 -->
<div id="modal-Profile_out" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    退出登录
                </div>
            </div>
            <div class="modal-body no-padding">
                <div>您确定要退出当前系統吗？</div>
            </div>
            <div class="modal-footer no-margin-top" style="padding-top:8px;padding-bottom:8px;">
                <span class="text-warning"></span>
                <button class="btn btn-primary btn-xs" type="button" onclick="return logout();">
                    <i class="glyphicon glyphicon-ok"></i>
                    确认
                </button>
                <button class="btn btn-xs" class="close" data-dismiss="modal" aria-hidden="true">
                    <i class="glyphicon glyphicon-remove"></i>
                    取消
                </button>
            </div>
        </div>
    </div>
</div>
<!-- 修改密码 -->
<script>
    function onindex() {
        window.location.href = "${root}/storehome";
    }
    function onsearch() {
        window.location.href = "${root}/search/index";
    }
    function onmap() {
        window.location.href = "${root}/map";
    }

    function oncheckjson() {
        window.location.href = "${root}/checkjson";
    }
    function onlandy() {
        window.location.href = "${root}/landy";
    }
    function onnginxftp() {
        window.location.href = "${root}/nginxftp";
    }
    function onGradleAar() {
        window.location.href = "${root}/gradle";
    }

    function onsocket() {
        window.location.href = "${root}/websocket/skt/socket";
    }
    function onstoreoperation() {
        window.location.href = "${root}/option/index";
    }

    function login() {
        window.location.href = "${root}/loginPage";
    }

    function logout() {
        isloginout = true;
        window.location.href = "${root}/j_spring_security_logout";

    }

    function showSecondMenu() {
        window.location.href = "${root}/build/list";
    }

    function upPasd() {
        if ($("#pasd").val() == "") {
            $("#upPasdMsg").html("请输入原密码");
            $("#pasd").focus();
            return false;
        }
        if ($("#pasd1").val() == "" || $("#pasd2").val() == "") {
            $("#upPasdMsg").html("请输入新密码密码");
            return false;
        }
        if ($("#pasd1").val() != $("#pasd2").val()) {
            $("#upPasdMsg").html("新密码与确认密码不一致");
            $("#pasd2").focus();
            return false;
        }
        $.getJSON("${root}/system/user/changepasswd/" + $("#pasd").val() + "/" + $("#pasd1").val(),
            function (data) {
                if (data.result == 'ok') {
                    $("#pasd").val("");
                    $("#pasd1").val("");
                    $("#pasd2").val("");
                    $('#modal-Profile').modal('hide');
                    alert("修改成功");
                }
                if (data.result == '502') {
                    alert(data.message);
                    window.top.location.href = "${root}/loginPage";
                }
                if (data.result == 'error') {
                    $("#upPasdMsg").html(data.message);
                }
            });
    }

    var onoff = true;

    <c:if test="${hasIndex eq '1' }">

    function goHome() {
        window.location.href = "${root}/home/admin/?moudelId=0" + "&index=0";
    }

    </c:if>
</script>
<!-- 修改密码 -->
<!-- 下面是進行WebSocket長連接 -->
<script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
<script>
    var ws = null;
    var issameuser = false;
    var isloginout = false;

    function connectSocket() {
        ws = new SockJS("${root}/websocket/socket");
        ws.onopen = function () {
            console.log("连接服务端成功");
        };
        
        ws.onerror = function (evnt) {
            console.log("连接出错"+evnt);
        }

        ws.onmessage = function (event) {
            //在這裡判斷是否重複登錄
            console.info('Received: ' + event.data);
            if (event.data.indexOf("user:") >= 0) {
                if (event.data == "user:${account}user:${userName}") {
                    issameuser = true;
                    window.location.href = "${root}/sameuser";
                }else {
                    <!-- 这里是其他用户登录后进行判断是否在固定一个页面添加新登录的用户信息 -->
                    issameuser = false;
                    var con = document.getElementById('dropselectul');
                    if (con !=null){
                        freshUser(con);
                    }
                }
            }else {
                issameuser = false;
                log(event.data);
            }
        };

        ws.onclose = function (event) {
            <!-- 由于编辑在顶部标签中，所以每个新打开的页面都会去调用WebSocket连接，而关闭页面则连接跟随关闭。故而在这边不能直接调用跳转页面必须加上判断 -->
            <!-- 当用户在其他地方登陆时，也会调用此方法。导致展示错误。所以不能再这里判断Session是否失效 -->
            <%--if (!isloginout){--%>
                <%--if (!issameuser){--%>
                    <%--$.getJSON("${root}/websocket/hasuser",function (json) {--%>
                        <%--if (json.resCode == 200){--%>
                            <%--//有用户，不退出--%>
                        <%--}else {--%>
                            <%--//无用户，可以退出--%>
                            <%--window.location.href = "${root}/timeout";--%>
                        <%--}--%>
                    <%--})--%>
                <%--}--%>
            <%--}--%>
        };
    }

    function disconnectSocket() {
        if (ws != null) {
            ws.close();
            ws = null;
        }
    }

    function log(message) {
        var console = document.getElementById('console');
        var p = document.createElement('p');
        p.style.wordWrap = 'break-word';
        p.appendChild(document.createTextNode(message));
        console.appendChild(p);
        while (console.childNodes.length > 25) {
            console.removeChild(console.firstChild);
        }
        console.scrollTop = console.scrollHeight;
    }
    //    这个方案当页面打开时，执行此方法
    window.onload = connectSocket;
</script>