//删除
function removeImg(obj, index,id) {
    if (obj != 0){
        //根據傳遞過來的id刪除對應圖片
        var data = new FormData();
        data.append("ID", id);
        //调用后台接口，找到對應商品
        $.ajax({
            url: obj + "/option/imagedelete",
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            data: data,
            processData: false,
            contentType: false,
            success: function (result) {
                if(result!=null&&result.resCode == 200) {
                    //移除點擊出的圖片
                    $("#result" + index).remove();
                    //移除對應的input標籤
                    if ($("#file" + index)[0]) {
                        $("#file" + index).remove();
                    }
                }else {
                    console.log(result.resDesc);
                }
            },
            error: function () {
                console.log("请求异常,检查网络和参数！");
            }
        });
    }else {
        //移除點擊出的圖片
        $("#result" + index).remove();
        //移除對應的input標籤
        if ($("#file" + index)[0]) {
            $("#file" + index).remove();
        }
    }
}
//图片灯箱
function imgDisplay(obj) {
    var src = $(obj).attr("src");
    var imgHtml = '<div style="width: 100%;height: 100vh;overflow: auto;background: rgba(0,0,0,0.5);text-align: center;position: fixed;top: 0;left: 0;z-index: 1000;"><img src=' + src + ' style="margin-top: 100px;width: 70%;margin-bottom: 100px;"/><p style="font-size: 50px;position: fixed;top: 30px;right: 30px;color: white;cursor: pointer;" onclick="closePicture(this)">×</p></div>'
    $('body').append(imgHtml);
}
//关闭
function closePicture(obj) {
    $(obj).parent("div").remove();
}

//图片预览路径
function getObjectURLs(file) {
    var url = null;
    if(window.createObjectURL != undefined) { // basic
        url = window.createObjectURL(file);
    } else if(window.URL != undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file);
    } else if(window.webkitURL != undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}