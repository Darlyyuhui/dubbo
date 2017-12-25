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
        // window.location.href = root+"/option/productentry";
        $("#baseset").removeClass("active");
        $("#storeset").addClass("active");
        $("#actset").removeClass("active");

        $(".side-body").empty();

        $(".side-body").append($("<div id=\"sbring\"  class=\"page-title\" style=\"text-align: center;display: none\">\n" +
        "    <span id=\"sbringtext\" class=\"title\" style=\"color: darkred\">保存成功</span>\n" +
        "</div>\n" +
        "<div class=\"row\">\n" +
        "    <div class=\"col-xs-12\">\n" +
        "        <div class=\"card\">\n" +
        "            <div class=\"card-header\">\n" +
        "                <div class=\"card-title\">\n" +
        "                    <div class=\"title\">商品列表</div>\n" +
        "                </div>\n" +
        "                <div class=\"text-right \" style=\"padding: 1.2em 25px;\">\n" +
        "                    <button onclick=\"productadd('新增')\">新增商品</button>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "<div class=\"search-area\">\n" +
        "    <div class=\"sa-ele\">\n" +
        "        <label class=\"se-title\">商品名称:</label>\n" +
        "        <input class=\"se-con\" name=\"productName\"/>\n" +
        "    </div>\n" +
        "    <div class=\"sa-ele\">\n" +
        "        <label class=\"se-title\">商品描述:</label>\n" +
        "        <input class=\"se-con\" name=\"productDesc\"/>\n" +
        "    </div>\n" +
        "    <div class=\"sa-ele\">\n" +
        "        <label class=\"se-title\">商品图片:</label>\n" +
        "        <input class=\"se-con\" name=\"productImage\"/>\n" +
        "    </div>\n" +
        "    <div class=\"sa-ele\">\n" +
        "        <button class=\"search-action\">搜索</button>\n" +
        "        <button class=\"reset-action\">重置</button>\n" +
        "    </div>\n" +
        "</div>\n" +
        "            <div class=\"card-body\">\n" +
        "                <table>\n" +
        "                </table>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "    </div>\n" +
        "</div>"));
        //假如弹出新增商品功能页面
        $(".side-body").append($("<div id=\"bg\"></div>\n" +
            "<div class=\"box\" style=\"display:none\">\n" +
            "    <div class=\"card\">\n" +
            "        <div class=\"card-header\">\n" +
            "            <div class=\"card-title\">\n" +
            "                <div id='classtitle' class=\"title\">新增商品</div>\n" +
            "            </div>\n" +
            "            <div class=\"text-right \" style=\"padding: 1.2em 25px;\">\n" +
            "                <button onclick=\"darly().productcloseer()\">关闭</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"card-body\">\n" +
            "            <form id=\"former\" onsubmit=\"return false\" action=\"##\"  method=\"post\" enctype=\"multipart/form-data\">\n" +
            "                <label style='display: none'>商品id：</label><input type=\"text\" id='productid' name=\"id\" style='display: none'/><br/>\n" +
            "                <label style='display: none'>商品图片：</label><input type=\"text\" id='productImage' name=\"productImage\" style='display: none'/><br/>\n" +
            "                <label>商品名称：</label><input type=\"text\" id='productName' name=\"productName\"/><br/>\n" +
            "                <label>商品现价：</label><input type=\"text\" id='productPrice' name=\"productPrice\"/><br/>\n" +
            "                <label>商品原价：</label><input type=\"text\" id='productOrprice' name=\"productOrprice\"/><br/>\n" +
            "                <label>商品描述：</label><input type=\"text\" id='productDesc' name=\"productDesc\"/><br/>\n" +
            "                <label>商品图片：</label><input type=\"file\" id='file1' name=\"file\"/><br/>\n" +
            "                <label>商品图片：</label><input type=\"file\" id='file2' name=\"file\"/><br/>\n" +
            "                <label>商品图片：</label><input type=\"file\" id='file3' name=\"file\"/><br/>\n" +
            "                <label>商品图片：</label><input type=\"file\" id='file4' name=\"file\"/><br/>\n" +
            "                <label>商品库存：</label><input type=\"text\" id='productNum' name=\"productNum\"/><br/>\n" +
            "                <label>商品星评：</label><input type=\"text\" id='productStars' name=\"productStars\"/><br/>\n" +
            "                <p><input type=\"button\" value=\"提交\" onclick=\"darly().productinsert('"+root+"')\"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"reset\" value=\"重置\"></p>\n"+
            "            </form>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>"));
        this.ontable(root);
    },
    productinsert:function (root) {
        var form = new FormData(document.getElementById("former"));
        console.log(this.root+"/option/addProduceter");
        $.ajax({
            url: root+"/option/addProduceter" ,
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            data:form,
            processData:false,
            contentType:false,
            success: function (result) {
                //在这里需要刷新Table表格数据
                $('table').GM('refreshGrid');
                $('table').GM('clear');
                //在这里需要刷新Table表格数据
                console.log(result);
                console.log(result.resDesc);
                darly().productcloseer();
                $("#sbring").show();
                $("#sbringtext").text(result.resDesc);
                $("#sbring").fadeOut(3000);
                setTimeout(function(){$("#sbring").hide()},3000)
            },
            error : function() {
                console.log("请求异常,检查网络和参数！");
            }
        });
    },
    productcloseer:function () {
        if ($("#former")[0]){
            $("#former")[0].reset();
        }
        //点击关闭按钮的时候，遮罩层关闭
        $("#bg,.box").css("display", "none");
    },
    ontable:function (root){
        var table = document.querySelector('table');
        if (table!=null){
            table.GM({
                supportRemind: true
                ,gridManagerName: 'test'
                ,isCombSorting: true
                ,supportAjaxPage:true
                ,supportSorting: true
                ,ajax_url: root+'/option/productentryser'
                ,ajax_type: 'POST'
                ,query: {pluginId: 1}
                ,supportAdjust: false
                ,supportAutoOrder: false
                ,supportCheckbox: false
                ,pageSize:50
                ,columnData: [{
                    key: 'id',
                    remind: 'id',
                    text: '商品编号',
                    sorting: ''
                },{
                    key: 'productName',
                    remind: 'productName',
                    text: '商品名称',
                },{
                    key: 'productPrice',
                    remind: 'productPrice',
                    text: '商品现价',
                },{
                    key: 'productOrprice',
                    remind: 'productOrprice',
                    text: '商品原价',
                },{
                    key: 'productDesc',
                    remind: 'productDesc',
                    text: '商品简介',
                },{
                    key: 'productImage',
                    remind: 'productImage',
                    text: '图片'
                },{
                    key: 'productNum',
                    remind: 'productNum',
                    text: '库存'
                },{
                    key: 'productStars',
                    remind: 'productStars',
                    text: '评分'
                },{
                    key: 'action',
                    remind: 'the action',
                    text: '操作',
                    template: function(action, rowObject){
                        var id = "\'"+rowObject.id+"\'";
                        var roots = "\'"+root+"\'";
                        return '<button class="productedit" style="margin: 5px" onclick="darly().productedit('+roots+','+id+')">编辑</button>'
                            +'<button style="margin: 5px" onclick="darly().productdelete('+roots+','+id+')">删除</button>';
                    }
                }
                ]
                // 分页前事件
                ,pagingBefore: function(query){
                    console.log('pagingBefore', query);
                }
                // 分页后事件
                ,pagingAfter: function(data){
                    console.log('pagingAfter', data);
                }
                // 排序前事件
                ,sortingBefore: function (data) {
                    console.log('sortBefore', data);
                }
                // 排序后事件
                ,sortingAfter: function (data) {
                    console.log('sortAfter', data);
                }
                // 宽度调整前事件
                ,adjustBefore: function (event) {
                    console.log('adjustBefore', event);
                }
                // 宽度调整后事件
                ,adjustAfter: function (event) {
                    console.log('adjustAfter', event);
                }
                // 拖拽前事件
                ,dragBefore: function (event) {
                    console.log('dragBefore', event);
                }
                // 拖拽后事件
                ,dragAfter: function (event) {
                    console.log('dragAfter', event);
                }
            });
            // 绑定搜索事件
            document.querySelector('.search-action').addEventListener('click', function () {
                var _query = {
                    productName: document.querySelector('[name="productName"]').value,
                    productDesc: document.querySelector('[name="productDesc"]').value,
                    productImage: document.querySelector('[name="productImage"]').value
                };
                table.GM('setQuery', _query).GM('refreshGrid', function () {
                    console.log('搜索成功...');
                });
            });

            // 绑定重置
            document.querySelector('.reset-action').addEventListener('click', function () {
                document.querySelector('[name="productName"]').value = '';
                document.querySelector('[name="productDesc"]').value = '';
                document.querySelector('[name="productImage"]').value = '';
            });
        }
    },
    //商品編輯操作
    productedit: function(root,id) {
        var data = new FormData();
        data.append("ID",id);
        //调用后台接口，找到對應商品
        $.ajax({
            url: root+"/option/productedit" ,
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            data:data,
            processData:false,
            contentType:false,
            success: function (result) {
                console.log(result);
                //给form表单设置值
                $("#productid").val(result.result.id);
                $("#productName").val(result.result.productName);
                $("#productPrice").val(result.result.productPrice);
                $("#productOrprice").val(result.result.productOrprice);
                $("#productDesc").val(result.result.productDesc);
                $("#productImage").val(result.result.productImage);
                $("#productNum").val(result.result.productNum);
                $("#productStars").val(result.result.productStars);
                productadd("编辑");
            },
            error : function() {
                console.log("请求异常,检查网络和参数！");
            }
        });


    },
    //移除商品
    productdelete:function(root,id) {
        if(confirm("确定要删除当前商品？")) {
            var data = new FormData();
            data.append("ID", id);
            //调用后台接口，进行数据删除操作
            $.ajax({
                url: root + "/option/productdelete",
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                data: data,
                processData: false,
                contentType: false,
                success: function (result) {
                    //在这里需要刷新Table表格数据
                    $('table').GM('refreshGrid');
                    $('table').GM('clear');
                    //在这里需要刷新Table表格数据
                    console.log(result);
                    darly().productcloseer();
                    $("#sbring").show();
                    $("#sbringtext").text(result.resDesc);
                    $("#sbring").fadeOut(3000);
                    setTimeout(function () {
                        $("#sbring").hide()
                    }, 3000)
                },
                error: function () {
                    console.log("请求异常,检查网络和参数！");
                }
            });
        }

    },
    //活动录入页面
    onactivityentry:function (root) {
        //window.location.href = root+"/option/activityentry";
        $("#baseset").removeClass("active");
        $("#storeset").removeClass("active");
        $("#actset").addClass("active");
        $(".side-body").empty();


        $(".side-body").append($("<div id=\"sbring\"  class=\"page-title\" style=\"text-align: center;display: none\">\n" +
            "    <span id=\"sbringtext\" class=\"title\" style=\"color: darkred\">保存成功</span>\n" +
            "</div>\n" +
            "<div class=\"row\">\n" +
            "    <div class=\"col-xs-12\">\n" +
            "        <div class=\"card\">\n" +
            "            <div class=\"card-header\">\n" +
            "                <div class=\"card-title\">\n" +
            "                    <div class=\"title\">活动列表</div>\n" +
            "                </div>\n" +
            "                <div class=\"text-right \" style=\"padding: 1.2em 25px;\">\n" +
            "                    <button onclick=\"productadd('新增')\">新增活动</button>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "<div class=\"search-area\">\n" +
            "    <div class=\"sa-ele\">\n" +
            "        <label class=\"se-title\">类型:</label>\n" +
            "        <input class=\"se-con\" name=\"name\"/>\n" +
            "    </div>\n" +
            "    <div class=\"sa-ele\">\n" +
            "        <label class=\"se-title\">简介:</label>\n" +
            "        <input class=\"se-con\" name=\"info\"/>\n" +
            "    </div>\n" +
            "    <div class=\"sa-ele\">\n" +
            "        <label class=\"se-title\">负责人:</label>\n" +
            "        <input class=\"se-con\" name=\"url\"/>\n" +
            "    </div>\n" +
            "    <div class=\"sa-ele\">\n" +
            "        <button class=\"search-action\">搜索</button>\n" +
            "        <button class=\"reset-action\">重置</button>\n" +
            "    </div>\n" +
            "</div>\n" +
            "            <div class=\"card-body\">\n" +
            "                <table>\n" +
            "                </table>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>"));
        //假如弹出新增商品功能页面
        $(".side-body").append($("<div id=\"bg\"></div>\n" +
            "<div class=\"box\" style=\"display:none\">\n" +
            "    <div class=\"card\">\n" +
            "        <div class=\"card-header\">\n" +
            "            <div class=\"card-title\">\n" +
            "                <div id='classtitle' class=\"title\">新增活动</div>\n" +
            "            </div>\n" +
            "            <div class=\"text-right \" style=\"padding: 1.2em 25px;\">\n" +
            "                <button onclick=\"darly().productcloseer()\">关闭</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"card-body\">\n" +
            "            <form id=\"former\" onsubmit=\"return false\" action=\"##\"  method=\"post\" enctype=\"multipart/form-data\">\n" +
            "                <label style='display: none'>活动id：</label><input type=\"text\" id='activityid' name=\"id\" style='display: none'/><br/>\n" +
            "                <label style='display: none'>活动图标：</label><input type=\"text\" id='storeTypeIcon' name=\"storeTypeIcon\" style='display: none'/><br/>\n" +
            "                <label>活动类型：</label><input type=\"text\" id='storeType' name=\"storeType\"/><br/>\n" +
            "                <label>活动说明：</label><input type=\"text\" id='storeDesc' name=\"storeDesc\"/><br/>\n" +
            "                <label>开始时间：</label><input type=\"text\" id='storeStartTime' name=\"storeStartTime\"/><br/>\n" +
            "                <label>结束时间：</label><input type=\"text\" id='storeEndTime' name=\"storeEndTime\"/><br/>\n" +
            "                <label>负责人：</label><input type=\"text\" id='storeTypeOp' name=\"storeTypeOp\"/><br/>\n" +
            "                <label>创建时间：</label><input type=\"text\" id='storeCreatetime' name=\"storeCreatetime\"/><br/>\n" +
            "                <label>更新时间：</label><input type=\"text\" id='storeUpdatetime' name=\"storeUpdatetime\"/><br/>\n" +
            "                <label>活动图标：</label><input type=\"file\" id='file1' name=\"file\"/><br/>\n" +
            "                <label>更新说明：</label><input type=\"text\" id='storeUpdatereason' name=\"storeUpdatereason\"/><br/>\n" +
            "                <p><input type=\"button\" value=\"提交\" onclick=\"darly().activityinsert('"+root+"')\"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"reset\" value=\"重置\"></p>\n"+
            "            </form>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>"));
        var table = document.querySelector('table');
        if (table!=null){
            table.GM({
                supportRemind: true
                ,gridManagerName: 'test'
                ,isCombSorting: true
                ,supportAjaxPage:true
                ,supportSorting: true
                ,ajax_url: root+'/option/activityentryser'
                ,ajax_type: 'POST'
                ,query: {pluginId: 1}
                ,supportAdjust: false
                ,supportAutoOrder: false
                ,supportCheckbox: false
                ,pageSize:50
                ,columnData: [{
                    key: 'id',
                    remind: 'id',
                    text: '编号',
                    sorting: ''
                },{
                    key: 'storeType',
                    remind: 'storeType',
                    text: '类型'
                },{
                    key: 'storeDesc',
                    remind: 'storeDesc',
                    text: '简介'
                },{
                    key: 'storeStartTime',
                    remind: 'storeStartTime',
                    text: '开启时间',
                    template: function(storeStartTime, rowObject){
                        return new Date(storeStartTime).format('YYYY-MM-DD HH:mm:ss');
                    }
                },{
                    key: 'storeEndTime',
                    remind: 'storeEndTime',
                    text: '结束时间',
                    template: function(storeEndTime, rowObject){
                        return new Date(storeEndTime).format('YYYY-MM-DD HH:mm:ss');
                    }
                },{
                    key: 'storeTypeOp',
                    remind: 'storeTypeOp',
                    text: '负责人'
                },{
                    key: 'storeCreatetime',
                        remind: 'storeCreatetime',
                        text: '创建时间',
                        template: function(storeCreatetime, rowObject){
                        return new Date(storeCreatetime).format('YYYY-MM-DD HH:mm:ss');
                    }
                },{
                    key: 'storeUpdatetime',
                        remind: 'storeUpdatetime',
                        text: '更新时间',
                        template: function(storeUpdatetime, rowObject){
                        return new Date(storeUpdatetime).format('YYYY-MM-DD HH:mm:ss');
                        }
                },{
                    key: 'storeUpdatereason',
                    remind: 'storeUpdatereason',
                    text: '原因'
                }, {
                    key: 'storeTypeIcon',
                    remind:'storeTypeIcon',
                    text:'图片'
                },{
                    key: 'action',
                    remind: 'the action',
                    width: '100px',
                    text: '操作',
                    template: function(action, rowObject){
                        var id = "\'"+rowObject.id+"\'";
                        var roots = "\'"+root+"\'";
                        return '<button  style="margin: 5px" onclick="darly().activityedit('+roots+','+id+')">编辑</button>'
                            +'<button style="margin: 5px" onclick="darly().activitydelete('+roots+','+id+')">删除</button>';
                    }
            }]
                // 分页前事件
                ,pagingBefore: function(query){
                    console.log('pagingBefore', query);
                }
                // 分页后事件
                ,pagingAfter: function(data){
                    console.log('pagingAfter', data);
                }
                // 排序前事件
                ,sortingBefore: function (data) {
                    console.log('sortBefore', data);
                }
                // 排序后事件
                ,sortingAfter: function (data) {
                    console.log('sortAfter', data);
                }
                // 宽度调整前事件
                ,adjustBefore: function (event) {
                    console.log('adjustBefore', event);
                }
                // 宽度调整后事件
                ,adjustAfter: function (event) {
                    console.log('adjustAfter', event);
                }
                // 拖拽前事件
                ,dragBefore: function (event) {
                    console.log('dragBefore', event);
                }
                // 拖拽后事件
                ,dragAfter: function (event) {
                    console.log('dragAfter', event);
                }
            });
            // 日期格式化,不是插件的代码,只用于处理时间格式化
            Date.prototype.format = function(fmt){
                var o = {
                    "M+": this.getMonth() + 1, //月份
                    "D+": this.getDate(), //日
                    "d+": this.getDate(), //日
                    "H+": this.getHours(), //小时
                    "h+": this.getHours(), //小时
                    "m+": this.getMinutes(), //分
                    "s+": this.getSeconds(), //秒
                    "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                    "S": this.getMilliseconds() //毫秒
                };
                if (/([Y,y]+)/.test(fmt)){
                    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
                }
                for (var k in o){
                    if(new RegExp("(" + k + ")").test(fmt)){
                        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                    }
                }
                return fmt;
            };

            // 绑定搜索事件
            document.querySelector('.search-action').addEventListener('click', function () {
                var _query = {
                    storeType: document.querySelector('[name="name"]').value,
                    storeDesc: document.querySelector('[name="info"]').value,
                    storeTypeOp: document.querySelector('[name="url"]').value
                };
                table.GM('setQuery', _query).GM('refreshGrid', function () {
                    console.log('搜索成功...');
                });
            });

            // 绑定重置
            document.querySelector('.reset-action').addEventListener('click', function () {
                document.querySelector('[name="name"]').value = '';
                document.querySelector('[name="info"]').value = '';
                document.querySelector('[name="url"]').value = '';
            });
        }
    },
    activityinsert:function (root) {
        var form = new FormData(document.getElementById("former"));
        console.log(this.root+"/option/activityinsert");
        $.ajax({
            url: root+"/option/activityinsert" ,
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            data:form,
            processData:false,
            contentType:false,
            success: function (result) {
                //在这里需要刷新Table表格数据
                $('table').GM('refreshGrid');
                $('table').GM('clear');
                //在这里需要刷新Table表格数据
                console.log(result);
                console.log(result.resDesc);
                darly().productcloseer();
                $("#sbring").show();
                $("#sbringtext").text(result.resDesc);
                $("#sbring").fadeOut(3000);
                setTimeout(function(){$("#sbring").hide()},3000)

            },
            error : function() {
                console.log("请求异常,检查网络和参数！");
            }
        });
    },

    //活动编辑
    activityedit: function(root,id) {
        var data = new FormData();
        data.append("ID",id);
        //调用后台接口，找到對應商品
        $.ajax({
            url: root+"/option/activityedit" ,
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            data:data,
            processData:false,
            contentType:false,
            success: function (result) {
                console.log(result);
                //给form表单设置值
                $("#activityid").val(result.result.id);
                $("#storeType").val(result.result.storeType);
                $("#storeDesc").val(result.result.storeDesc);
                $("#storeStartTime").val(result.result.storeStartTime);
                $("#storeEndTime").val(result.result.storeEndTime);
                $("#storeTypeOp").val(result.result.storeTypeOp);
                $("#storeCreatetime").val(result.result.storeCreatetime);
                $("#storeUpdatetime").val(result.result.storeUpdatetime);
                $("#storeUpdatereason").val(result.result.storeUpdatereason);
                productadd("编辑");
            },
            error : function() {
                console.log("请求异常,检查网络和参数！");
            }
        });
    },
    //活动移除
    activitydelete:function(root,id) {
        if(confirm("确定要删除当前活动？")){
            var data = new FormData();
            data.append("ID",id);
            //调用后台接口，进行数据删除操作
            $.ajax({
                url: root+"/option/activitydelete" ,
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                data:data,
                processData:false,
                contentType:false,
                success: function (result) {
                    //在这里需要刷新Table表格数据
                    $('table').GM('refreshGrid');
                    $('table').GM('clear');
                    //在这里需要刷新Table表格数据
                    console.log(result);
                    darly().productcloseer();
                    $("#sbring").show();
                    $("#sbringtext").text(result.resDesc);
                    $("#sbring").fadeOut(3000);
                    setTimeout(function(){$("#sbring").hide()},3000)
                },
                error : function() {
                    console.log("请求异常,检查网络和参数！");
                }
            });
        }
    },

    //活动绑定商品页面
    onactivityproduct:function (root) {
        $("#baseset").removeClass("active");
        $("#storeset").removeClass("active");
        $("#actset").addClass("active");
        $(".side-body").empty();
        $(".side-body").append($("<div id=\"sbring\"  class=\"page-title\" style=\"text-align: center;display: none\">\n" +
            "    <span id=\"sbringtext\" class=\"title\" style=\"color: darkred\">保存成功</span>\n" +
            "</div>\n" +
            "<div class=\"row\">\n" +
            "    <div class=\"col-xs-12\">\n" +
            "        <div class=\"card\">\n" +
            "            <div class=\"card-header\">\n" +
            "                <div class=\"card-title\">\n" +
            "                    <div class=\"title\">活动商品查看</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"card-body\">\n" +
            "                <table id='activityshow'>\n" +
            "                </table>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>"));
        //假如弹出新增商品功能页面
        $(".side-body").append($("<div id=\"bg\"></div>\n" +
            "<div class=\"box\" style=\"display:none\">\n" +
            "    <div class=\"card\">\n" +
            "        <div class=\"card-header\">\n" +
            "            <div class=\"card-title\">\n" +
            "                <div id='classtitle' class=\"title\">参与活动的商品</div>\n" +
            "            </div>\n" +
            "            <div class=\"text-right \" style=\"padding: 1.2em 25px;\">\n" +
            "                <button onclick=\"darly().productsave()\">保存</button>\n" +
            "                <button onclick=\"darly().activityproductcloseer()\">关闭</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"card-body\">\n" +
            "                <table id='activityproduct'>\n" +
            "                </table>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>"));

        var table = document.querySelector('#activityshow');
        if (table!=null){
            table.GM({
                supportRemind: true
                ,gridManagerName: 'test'
                ,isCombSorting: true
                ,supportAjaxPage:true
                ,supportSorting: true
                ,ajax_url: root+'/option/activityentryser'
                ,ajax_type: 'POST'
                ,query: {pluginId: 1}
                ,supportAdjust: false
                ,supportAutoOrder: false
                ,supportCheckbox: false
                ,pageSize:50
                ,columnData: [{
                    key: 'id',
                    remind: 'id',
                    text: '编号',
                    sorting: ''
                },{
                    key: 'storeType',
                    remind: 'storeType',
                    text: '类型'
                },{
                    key: 'storeDesc',
                    remind: 'storeDesc',
                    text: '简介'
                },{
                    key: 'storeStartTime',
                    remind: 'storeStartTime',
                    text: '开启时间',
                    template: function(storeStartTime, rowObject){
                        return new Date(storeStartTime).format('YYYY-MM-DD HH:mm:ss');
                    }
                },{
                    key: 'storeEndTime',
                    remind: 'storeEndTime',
                    text: '结束时间',
                    template: function(storeEndTime, rowObject){
                        return new Date(storeEndTime).format('YYYY-MM-DD HH:mm:ss');
                    }
                },{
                    key: 'storeTypeOp',
                    remind: 'storeTypeOp',
                    text: '负责人'
                },{
                    key: 'storeCreatetime',
                    remind: 'storeCreatetime',
                    text: '创建时间',
                    template: function(storeCreatetime, rowObject){
                        return new Date(storeCreatetime).format('YYYY-MM-DD HH:mm:ss');
                    }
                },{
                    key: 'storeUpdatetime',
                    remind: 'storeUpdatetime',
                    text: '更新时间',
                    template: function(storeUpdatetime, rowObject){
                        return new Date(storeUpdatetime).format('YYYY-MM-DD HH:mm:ss');
                    }
                },{
                    key: 'storeUpdatereason',
                    remind: 'storeUpdatereason',
                    text: '原因'
                }, {
                    key: 'storeTypeIcon',
                    remind:'storeTypeIcon',
                    text:'图片'
                },{
                    key: 'action',
                    remind: 'the action',
                    width: '100px',
                    text: '操作',
                    template: function(action, rowObject){
                        var id = "\'"+rowObject.id+"\'";
                        var roots = "\'"+root+"\'";
                        return '<button class="activityproductselect"  style="margin: 5px" onclick="darly().activityproductselect('+roots+','+id+')">查询</button>'
                            +'<button  class="activityproductedit" style="margin: 5px" onclick="darly().activityproductedit('+roots+','+id+')">编辑</button>';
                    }
                }]
                // 分页前事件
                ,pagingBefore: function(query){
                    console.log('pagingBefore', query);
                }
                // 分页后事件
                ,pagingAfter: function(data){
                    console.log('pagingAfter', data);
                }
                // 排序前事件
                ,sortingBefore: function (data) {
                    console.log('sortBefore', data);
                }
                // 排序后事件
                ,sortingAfter: function (data) {
                    console.log('sortAfter', data);
                }
                // 宽度调整前事件
                ,adjustBefore: function (event) {
                    console.log('adjustBefore', event);
                }
                // 宽度调整后事件
                ,adjustAfter: function (event) {
                    console.log('adjustAfter', event);
                }
                // 拖拽前事件
                ,dragBefore: function (event) {
                    console.log('dragBefore', event);
                }
                // 拖拽后事件
                ,dragAfter: function (event) {
                    console.log('dragAfter', event);
                }
            });
            // 日期格式化,不是插件的代码,只用于处理时间格式化
            Date.prototype.format = function(fmt){
                var o = {
                    "M+": this.getMonth() + 1, //月份
                    "D+": this.getDate(), //日
                    "d+": this.getDate(), //日
                    "H+": this.getHours(), //小时
                    "h+": this.getHours(), //小时
                    "m+": this.getMinutes(), //分
                    "s+": this.getSeconds(), //秒
                    "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                    "S": this.getMilliseconds() //毫秒
                };
                if (/([Y,y]+)/.test(fmt)){
                    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
                }
                for (var k in o){
                    if(new RegExp("(" + k + ")").test(fmt)){
                        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                    }
                }
                return fmt;
            };
        }

        var table = document.querySelector("#activityproduct");
        if (table!=null){
            table.GM({
                supportRemind: true
                ,gridManagerName: 'test'
                ,isCombSorting: true
                ,supportAjaxPage:true
                ,supportSorting: true
                ,ajax_url: root+'/option/actproduct'
                ,ajax_type: 'POST'
                ,query: {pluginId: 1}
                ,supportAdjust: false
                ,supportAutoOrder: false
                ,supportCheckbox: true
                ,pageSize:50
                ,columnData: [{
                    key: 'id',
                    remind: 'id',
                    text: '商品编号',
                    sorting: ''
                },{
                    key: 'productName',
                    remind: 'productName',
                    text: '商品名称',
                },{
                    key: 'productPrice',
                    remind: 'productPrice',
                    text: '商品现价',
                },{
                    key: 'productOrprice',
                    remind: 'productOrprice',
                    text: '商品原价',
                },{
                    key: 'productDesc',
                    remind: 'productDesc',
                    text: '商品简介',
                },{
                    key: 'productImage',
                    remind: 'productImage',
                    text: '图片'
                },{
                    key: 'productNum',
                    remind: 'productNum',
                    text: '库存'
                },{
                    key: 'productStars',
                    remind: 'productStars',
                    text: '评分'
                }]
                // 分页前事件
                ,pagingBefore: function(query){
                    console.log('pagingBefore', query);
                }
                // 分页后事件
                ,pagingAfter: function(data){
                    console.log('pagingAfter', data);
                }
                // 排序前事件
                ,sortingBefore: function (data) {
                    console.log('sortBefore', data);
                }
                // 排序后事件
                ,sortingAfter: function (data) {
                    console.log('sortAfter', data);
                }
                // 宽度调整前事件
                ,adjustBefore: function (event) {
                    console.log('adjustBefore', event);
                }
                // 宽度调整后事件
                ,adjustAfter: function (event) {
                    console.log('adjustAfter', event);
                }
                // 拖拽前事件
                ,dragBefore: function (event) {
                    console.log('dragBefore', event);
                }
                // 拖拽后事件
                ,dragAfter: function (event) {
                    console.log('dragAfter', event);
                }
            });


        }

    },
    activityproductselect:function (root,id) {
            var table = document.querySelector("#activityproduct");
            table.GM('refreshGrid', function () {
                productadd('关联商品')
            });
    },
    //点击编辑查看关联商品浮层
    activityproductedit:function (root,id) {
        var _query = {
            id: id,
        };
        var table = document.querySelector("#activityproduct");
        table.GM('setQuery', _query).GM('refreshGrid', function () {
            productadd('关联商品')
        });
    },

    //编辑关联商品后进行保存操作
    productsave: function () {
        //根据选中项插入到数据库中。
    },
    activityproductcloseer:function () {
        var table = document.querySelector("#activityproduct");
        table.GM('clear');
        //点击关闭按钮的时候，遮罩层关闭
        $("#bg,.box").css("display", "none");
    },
}