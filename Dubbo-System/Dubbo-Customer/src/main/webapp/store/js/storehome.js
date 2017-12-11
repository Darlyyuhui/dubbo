window.onload = function () {
    if("DubboAndroidListener" in window){
        console.log(DubboAndroidListener);
        DubboAndroidListener.init(function () {
			
        });
    }
}

function Darly(json) {
    if (!(this instanceof Darly)) {
        return new Darly(json);
    }
    var j = JSON.parse(json);
    this.t(j.t);
    this.s(j.s);
}

Darly.prototype ={
    t:function (json) {
		console.log(json);
    },
    s:function (json) {
		console.log(json);
    }
}