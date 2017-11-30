function retreet(name,id) {
    $("#dropselect").text(name);
    document.getElementById("dropselect").setAttribute("ids",id);
}

function freshUser(con) {
    $.getJSON("${root}/websocket/alluser",function (json) {
        console.log(json);
        if (json.resCode == 200){
            //有用户，先剔除所有用户。后添加新用户
            $("#dropselectul").empty();
            var  results = json.result;
            var li = document.createElement('li');
            var a = document.createElement('a');
            a.setAttribute("class", "tooltip-test");
            a.setAttribute("href", "javascript:retreet('全部','null');");
            a.title="所有在线用户";
            a.appendChild(document.createTextNode("全部"));
            li.appendChild(a);
            con.appendChild(li);
            var lsi = document.createElement('li');
            lsi.setAttribute("class", "divider");
            con.appendChild(lsi);
            results.forEach(function(e){
                if (e.id != "${account}"){
                    var li = document.createElement('li');
                    var a = document.createElement('a');
                    a.setAttribute("class", "tooltip-test");
                    a.setAttribute("href", "javascript:retreet('"+e.realName+"','"+e.id+"');");
                    a.title="用户的编号："+e.id;
                    a.appendChild(document.createTextNode(e.realName));
                    li.appendChild(a);
                    con.appendChild(li);
                    var lsi = document.createElement('li');
                    lsi.setAttribute("class", "divider");
                    con.appendChild(lsi);
                }
            });
        }
    })

}

$(function () {
    var websocket;
    var left = true;

    websocket = new SockJS("${root}/websocket/chat");
    websocket.onopen = function (evnt) {
        $("#tou").html("链接服务器成功!")
    };
    websocket.onmessage = function (evnt) {
        console.log(evnt.data);
        var con = document.getElementById('msg');
        var p = document.createElement('p');
        if (evnt.data.indexOf("userTip:") >= 0) {
            if (evnt.data.indexOf("${userName}") >= 0) {
                //在这里判断是否是用户本身。将left修改为false
                left = false;
            }else {
                left = true;
            }
        }
        if (left){
            p.style.textAlign = "left";
        }else {
            p.style.textAlign = "right";
        }
        if (evnt.data.indexOf("userTip:") >= 0) {
            p.style.wordWrap = 'break-word';
            var name = evnt.data.split("userTip:")[1];
            p.appendChild(document.createTextNode(name));
        } else {
            p.style.wordWrap = 'break-word';
            p.style.marginLeft = '20px';
            p.appendChild(document.createTextNode(evnt.data));
        }
        con.appendChild(p);
        con.scrollTop = con.scrollHeight;
    };
    websocket.onerror = function (evnt) {
    };
    websocket.onclose = function (evnt) {
        $("#tou").html("与服务器断开了链接!")
    }
    $('#send').bind('click', function () {
        var ids =  document.getElementById("dropselect").getAttribute("ids");
        send(ids);
    });


    function send(ids) {
        if (websocket != null) {
            var message = document.getElementById('message').value;
            if(ids == "null") {
                websocket.send(message);
            }else {
                websocket.send(ids + "-->splitmessage<--" + message);
            }
        } else {
            alert('未与服务器链接.');
        }
    }
});

$(document).keyup(function (e) {//捕获文档对象的按键弹起事件
    if (e.keyCode == 13) {//按键信息对象以参数的形式传递进来了
        //此处编写用户敲回车后的代码
        var ids =  document.getElementById("dropselect").getAttribute("ids");
        send(ids);
    }
});