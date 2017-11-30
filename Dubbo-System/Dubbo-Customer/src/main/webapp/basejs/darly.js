<!-- 修改密码 -->
function onindex() {
    window.location.href = "${root}/index";
}

function oncheckjson() {
    window.location.href = "${root}/checkjson";
}

function onsocket() {
    window.location.href = "${root}/websocket/skt/socket";
}

function login() {
    window.location.href = "${root}/login";
}

function logout() {
    isloginout = true;
    window.location.href = "${root}/j_spring_security_logout";

}

function showSecondMenu(id) {
    window.location.href = "${root}/build/list/" + id;
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
                window.top.location.href = "${root}/login";
            }
            if (data.result == 'error') {
                $("#upPasdMsg").html(data.message);
            }
        });
}
<!-- 修改密码 -->

    <!-- 下面是進行WebSocket長連接 -->
let ws = null;
let issameuser = false;
let isloginout = false;

function connectSocket() {
    ws = new SockJS("${root}/websocket/socket");
    ws.onopen = function () {
    };

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
                let con = document.getElementById('dropselectul');
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
        if (!isloginout){
            if (!issameuser){
                $.getJSON("${root}/websocket/hasuser",function (json) {
                    if (json.resCode == 200){
                        //有用户，不退出
                    }else {
                        //无用户，可以退出
                        window.location.href = "${root}/timeout";
                    }
                })
            }
        }
    };
}

function disconnectSocket() {
    if (ws != null) {
        ws.close();
        ws = null;
    }
}

function log(message) {
    let console = document.getElementById('console');
    let p = document.createElement('p');
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