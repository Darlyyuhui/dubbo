//应用启动后直接调用Android端代码
window.onload = function () {
    if("DubboAndroidListener" in window){
        console.log(DubboAndroidListener);
        DubboAndroidListener.init();
    }
}
//Android端回调完成
function Darly(json) {
    if (!(this instanceof Darly)){
        return new Darly(json);
    }
    this.data = json;
    this.callback(DarlyCallBack());
};
Darly.prototype = {
    data:"",
    callback:function (json) {
        if (this.data == null||this.data == ""){
            console.log("this.data is null or is \"\""+this.data);
            return;
        }
        var data = JSON.parse(this.data);
        json.setlatiude(data.latiude);
        json.setlongitude(data.longitude);
    },
}

UIController.prototype = {
    callback:function (json) {
        if (darlyData == null||darlyData == ""){
            console.log("darlyData is null or is \"\""+darlyData);
            return;
        }
        var data = JSON.parse(darlyData);
        json.setjingdu(data.latiude);
        json.setweidu(data.longitude);
    },
}


