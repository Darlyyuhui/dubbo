var flag = 0;
var flagip = "";

//设置值
function ipfocus(id){
    flagip = id;
    flag = id.substr(id.length - 1 , id.length);
}

$(document).keydown(function(event){
    if((event.which == "110" || event.which == "190") && flag == 1 && flagip == "iprule1") {
        $("#iprule2").focus();
        return false;
    }
    if((event.which == "110" || event.which == "190") && flag == 2 && flagip == "iprule2") {
        $("#iprule3").focus();
        return false;
    }
    if((event.which == "110" || event.which == "190") && flag == 3 && flagip == "iprule3") {
        $("#iprule4").focus();
        return false;
    }
});