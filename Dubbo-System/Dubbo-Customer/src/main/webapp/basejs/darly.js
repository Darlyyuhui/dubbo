function darly() {
    if (!(this instanceof darly)) {
        return new darly();
    }
}

darly.prototype = {
    //跳转到登录页面
    storeLogin: function (root) {
        window.location.href = root + "/loginPage";
    },
    logout: function (root) {
        window.location.href = root + "/j_spring_security_logout";
    },
    storehome: function (root) {
        window.location.href = root + "/storehome";
    },
    //跳转商城管理首页
    onstoreoperationindex: function (root) {
        window.location.href = root + "/option/index";
    },
    //商品录入页面
    onproductentry: function (root) {
        // window.location.href = root+"/option/productentry";
        $("#baseset").removeClass("active");
        $("#storeset").addClass("active");
        $("#actset").removeClass("active");

        $(".side-body").empty();

        //假如弹出新增商品功能页面
        $(".side-body").append($("<div id=\"bg\"></div>\n" +
            "<div class=\"box\" style=\"display:none\">\n" +
            "    <div class=\"card\">\n" +
            "        <div class=\"card-header\">\n" +
            "            <div class=\"card-title\">\n" +
            "                <div id='classtitle' class=\"title\"></div>\n" +
            "            </div>\n" +
            "            <div class=\"text-right \" style=\"padding: 1.2em 25px;\">\n" +
            "                <button onclick=\"darly().productcloseer()\" style='width: 40px' ><i class='fa fa-remove'></i></button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"card-body\">\n" +
            "            <form id=\"former\" onsubmit=\"return false\" action=\"##\"  method=\"post\" enctype=\"multipart/form-data\">\n" +
            "                <label style='display: none'>商品id：</label><input type=\"text\" id='productid' name=\"id\" style='display: none'/>\n" +
            "                <label>商品名称：</label><input type=\"text\" id='productName' name=\"productName\"/><br/>\n" +
            "                <label>商品现价：</label><input type=\"text\" id='productPrice' name=\"productPrice\"/><br/>\n" +
            "                <label>商品原价：</label><input type=\"text\" id='productOrprice' name=\"productOrprice\"/><br/>\n" +
            "                <label>商品描述：</label><input type=\"text\" id='productDesc' name=\"productDesc\"/><br/>\n" +
            "                <label>商品库存：</label><input type=\"text\" id='productNum' name=\"productNum\"/><br/>\n" +
            "                <label>商品星评：</label><input type=\"text\" id='productStars' name=\"productStars\"/><br/>\n" +
            "                <label>商品图片：</label><br/>\n" +
            "                   <div id=\"upload_input_div\">\n" +
            "                       <div id=\"inputBox\"> <input type=\"file\" id='imagefile' class='auto_upload_file' name='file' onchange=\"new darly().autoChangeFile('imagefile', '0' )\"/>请选择商品图片</div><br/>\n" +
            "                   </div>\n"+
            "                <div id=\"images\"style='display:inline-flex'></div>\n" +
            "                <p><input type=\"button\" value=\"提交\" style='width: 40px'  onclick=\"darly().productinsert('" + root + "')\"/></p>\n" +
            "            </form>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>"));
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
            "                    <button style='width: 40px'  onclick=\"productadd('新增')\"><i class='fa fa-plus'></i></button>\n" +
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
            "        <button class=\"search-action\" ><i class='fa fa-search'></i></button>\n" +
            "        <button class=\"reset-action\" ><i class='fa fa-undo'></i></button>\n" +
            "    </div>\n" +
            "</div>\n" +
            "            <div class=\"card-body\">\n" +
            "                <table>\n" +
            "                </table>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>"));
        this.ontable(root);
    },

    productinsert: function (root) {
        if (confirm("是否确认新增或修改商品")) {
            var form = new FormData(document.getElementById("former"));
            console.log(root + "/option/addProduceter");
            $.ajax({
                url: root + "/option/addProduceter",
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                data: form,
                processData: false,
                contentType: false,
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

    productcloseer: function () {
        if ($("#former")[0]) {
            $("#former")[0].reset();
        }
        if ($("#upload_input_div")[0]) {
            $("#upload_input_div").empty();
            $("#upload_input_div").append("<div id=\"inputBox\"> <input type=\"file\" id='imagefile' class='auto_upload_file' name='file' onchange=\"new darly().autoChangeFile('imagefile', '0' )\"/>点击选择图片</div><br/>");
        }
        if ($("#images")[0]) {
            $("#images").empty();
        }
        //点击关闭按钮的时候，遮罩层关闭
        $("#bg,.box").css("display", "none");
    },

    ontable: function (root) {
        var table = document.querySelector('table');
        if (table != null) {
            table.GM({
                supportRemind: true
                , gridManagerName: 'test'
                , isCombSorting: true
                , supportAjaxPage: true
                , supportSorting: true
                , ajax_url: root + '/option/productentryser'
                , ajax_type: 'POST'
                , query: {pluginId: 1}
                , supportAdjust: true
                , supportAutoOrder: false
                , supportCheckbox: false
                , pageSize: 50
                , columnData: [{
                    key: 'id',
                    remind: 'id',
                    text: '商品编号',
                    sorting: ''
                }, {
                    key: 'productName',
                    remind: 'productName',
                    text: '商品名称',
                }, {
                    key: 'productPrice',
                    remind: 'productPrice',
                    text: '商品现价',
                }, {
                    key: 'productOrprice',
                    remind: 'productOrprice',
                    text: '商品原价',
                }, {
                    key: 'productDesc',
                    remind: 'productDesc',
                    text: '商品简介',
                }, {
                    key: 'productImage',
                    remind: 'productImage',
                    text: '图片'
                }, {
                    key: 'productNum',
                    remind: 'productNum',
                    text: '库存'
                }, {
                    key: 'productStars',
                    remind: 'productStars',
                    text: '评分'
                }, {
                    key: 'action',
                    remind: 'the action',
                    text: '操作',
                    template: function (action, rowObject) {
                        var id = "\'" + rowObject.id + "\'";
                        var roots = "\'" + root + "\'";
                        return '<button class="productedit" style="width: 40px;margin: 5px" onclick="darly().productedit(' + roots + ',' + id + ')"><i class="fa fa-edit"></i></button>'
                            + '<button style="width: 40px;margin: 5px" onclick="darly().productdelete(' + roots + ',' + id + ')"><i class="fa fa-trash-o"></i></button>';
                    }
                }
                ]
                // 分页前事件
                , pagingBefore: function (query) {
                    console.log('pagingBefore', query);
                }
                // 分页后事件
                , pagingAfter: function (data) {
                    console.log('pagingAfter', data);
                }
                // 排序前事件
                , sortingBefore: function (data) {
                    console.log('sortBefore', data);
                }
                // 排序后事件
                , sortingAfter: function (data) {
                    console.log('sortAfter', data);
                }
                // 宽度调整前事件
                , adjustBefore: function (event) {
                    console.log('adjustBefore', event);
                }
                // 宽度调整后事件
                , adjustAfter: function (event) {
                    console.log('adjustAfter', event);
                }
                // 拖拽前事件
                , dragBefore: function (event) {
                    console.log('dragBefore', event);
                }
                // 拖拽后事件
                , dragAfter: function (event) {
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
    productedit: function (root, id) {
        var roos = "'"+root+"'";
        var data = new FormData();
        data.append("ID", id);
        //调用后台接口，找到對應商品
        $.ajax({
            url: root + "/option/productedit",
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            data: data,
            processData: false,
            contentType: false,
            success: function (result) {
                console.log(result);
                //给form表单设置值
                $("#productid").val(result.result.id);
                $("#productName").val(result.result.productName);
                $("#productPrice").val(result.result.productPrice);
                $("#productOrprice").val(result.result.productOrprice);
                $("#productDesc").val(result.result.productDesc);
                $("#productNum").val(result.result.productNum);
                $("#productStars").val(result.result.productStars);
                //編輯时，获取到已经存在的对象图片集合。将这些图片集合进行展示。
                var images = result.result.images;
                if (images!=null) {
                    for (var item = 0; item < images.length; item++) {
                        var ids = item + 1000;
                        var imageurl = "'" + images[item].id + "'";
                        var imgSrc = resource + images[item].imageUrl;
                        var result = '<img src="' + imgSrc + '" onclick="imgDisplay(this)"><p onclick="removeImg(' + roos + ',' + ids + ',' + imageurl + ')" class="imgDelete">删除</p>';
                        var div = document.createElement('div');
                        div.id = "result" + ids;
                        div.setAttribute("class", "imgContainer");
                        div.innerHTML = result;
                        document.getElementById('images').appendChild(div);
                    }
                }
                productadd("编辑");
            },
            error: function () {
                console.log("请求异常,检查网络和参数！");
            }
        });
    },
    //移除商品
    productdelete: function (root, id) {
        if (confirm("确定要删除当前商品？")) {
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
    onactivityentry: function (root) {
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
            "                    <button onclick=\"productadd('新增')\" style='width: 40px'><i class='fa fa-plus'></i></button>\n" +
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
            "        <button class=\"search-action\" ><i class='fa fa-search'></i></button>\n" +
            "        <button class=\"reset-action\" ><i class='fa fa-undo'></i></button>\n" +
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
            "                <button onclick=\"darly().productcloseer()\" style='width: 40px' ><i class='fa fa-remove'></i></button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"card-body\">\n" +
            "            <form id=\"former\" onsubmit=\"return false\" action=\"##\"  method=\"post\" enctype=\"multipart/form-data\">\n" +
            "                <label style='display: none'>活动id：</label><input type=\"text\" id='activityid' name=\"id\" style='display: none'/><br/>\n" +
            "                <label style='display: none'>活动图标：</label><input type=\"text\" id='storeTypeIcon' name=\"storeTypeIcon\" style='display: none'/><br/>\n" +
            "                <label>活动类型：</label><input type=\"text\" id='storeType' name=\"storeType\"/><br/>\n" +
            "                <label>活动说明：</label><input type=\"text\" id='storeDesc' name=\"storeDesc\"/><br/>\n" +
            "                <label>开始时间：</label><input class=\"Wdate\"  type=\"text\" id='storeStartTime' name=\"storeStartTime\" onClick=\"WdatePicker({startDate:'%y-%M-01 00:00:00',el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})\"><br/>\n" +
            "                <label>结束时间：</label><input class=\"Wdate\" type=\"text\" id='storeEndTime' name=\"storeEndTime\" onClick=\"WdatePicker({startDate:'%y-%M-01 00:00:00',el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})\"><br/>\n" +
            "                <label>负责人&nbsp&nbsp&nbsp&nbsp：</label><input type=\"text\" id='storeTypeOp' name=\"storeTypeOp\"/><br/>\n" +
            "                <label>创建时间：</label><input class=\"Wdate\" type=\"text\" id='storeCreatetime' name=\"storeCreatetime\" onClick=\"WdatePicker({startDate:'%y-%M-01 00:00:00',el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})\"><br/>\n" +
            "                <label>更新时间：</label><input class=\"Wdate\" type=\"text\" id='storeUpdatetime' name=\"storeUpdatetime\" onClick=\"WdatePicker({startDate:'%y-%M-01 00:00:00',el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})\"><br/>\n" +
            "                <label>更新说明：</label><input type=\"text\" id='storeUpdatereason' name=\"storeUpdatereason\"/><br/>\n" +
            "                <label>活动图标：</label><br/>\n" +
            "                   <div id=\"upload_input_div\">\n" +
            "                       <div id=\"inputBox\"> <input type=\"file\" id='imagefile' class='auto_upload_file' name='file' onchange=\"new darly().autoChangeFile('imagefile', '0' )\"/>请选择活动图片</div><br/>\n" +
            "                   </div>\n"+
            "                <div id=\"images\"style='display:inline-flex'></div>\n" +
            "                <p><input style='width: 40px'  type=\"button\" value=\"提交\" onclick=\"darly().activityinsert('" + root + "')\"/></p>\n" +
            "            </form>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>"));
        var table = document.querySelector('table');
        if (table != null) {
            table.GM({
                supportRemind: true
                , gridManagerName: 'test'
                , isCombSorting: true
                , supportAjaxPage: true
                , supportSorting: true
                , ajax_url: root + '/option/activityentryser'
                , ajax_type: 'POST'
                , query: {pluginId: 1}
                , supportAdjust: true
                , supportAutoOrder: false
                , supportCheckbox: false
                , pageSize: 50
                , columnData: [{
                    key: 'id',
                    remind: 'id',
                    text: '编号',
                    sorting: ''
                }, {
                    key: 'storeType',
                    remind: 'storeType',
                    text: '类型'
                }, {
                    key: 'storeDesc',
                    remind: 'storeDesc',
                    text: '简介'
                }, {
                    key: 'storeStartTime',
                    remind: 'storeStartTime',
                    text: '开启时间',
                    template: function (storeStartTime, rowObject) {
                        return new Date(storeStartTime).format('YYYY-MM-DD HH:mm:ss');
                    }
                }, {
                    key: 'storeEndTime',
                    remind: 'storeEndTime',
                    text: '结束时间',
                    template: function (storeEndTime, rowObject) {
                        return new Date(storeEndTime).format('YYYY-MM-DD HH:mm:ss');
                    }
                }, {
                    key: 'storeTypeOp',
                    remind: 'storeTypeOp',
                    text: '负责人'
                }, {
                    key: 'storeCreatetime',
                    remind: 'storeCreatetime',
                    text: '创建时间',
                    template: function (storeCreatetime, rowObject) {
                        return new Date(storeCreatetime).format('YYYY-MM-DD HH:mm:ss');
                    }
                }, {
                    key: 'storeUpdatetime',
                    remind: 'storeUpdatetime',
                    text: '更新时间',
                    template: function (storeUpdatetime, rowObject) {
                        return new Date(storeUpdatetime).format('YYYY-MM-DD HH:mm:ss');
                    }
                }, {
                    key: 'storeUpdatereason',
                    remind: 'storeUpdatereason',
                    text: '原因'
                }, {
                    key: 'storeTypeIcon',
                    remind: 'storeTypeIcon',
                    text: '图片'
                }, {
                    key: 'action',
                    remind: 'the action',
                    width: '100px',
                    text: '操作',
                    template: function (action, rowObject) {
                        var id = "\'" + rowObject.id + "\'";
                        var roots = "\'" + root + "\'";
                        return '<button  style="width: 40px;margin: 5px" onclick="darly().activityedit(' + roots + ',' + id + ')"><i class="fa fa-edit"></i></button>'
                            + '<button style="width: 40px;margin: 5px" onclick="darly().activitydelete(' + roots + ',' + id + ')"><i class="fa fa-trash-o"></i></button>';
                    }
                }]
                // 分页前事件
                , pagingBefore: function (query) {
                    console.log('pagingBefore', query);
                }
                // 分页后事件
                , pagingAfter: function (data) {
                    console.log('pagingAfter', data);
                }
                // 排序前事件
                , sortingBefore: function (data) {
                    console.log('sortBefore', data);
                }
                // 排序后事件
                , sortingAfter: function (data) {
                    console.log('sortAfter', data);
                }
                // 宽度调整前事件
                , adjustBefore: function (event) {
                    console.log('adjustBefore', event);
                }
                // 宽度调整后事件
                , adjustAfter: function (event) {
                    console.log('adjustAfter', event);
                }
                // 拖拽前事件
                , dragBefore: function (event) {
                    console.log('dragBefore', event);
                }
                // 拖拽后事件
                , dragAfter: function (event) {
                    console.log('dragAfter', event);
                }
            });
            // 日期格式化,不是插件的代码,只用于处理时间格式化
            Date.prototype.format = function (fmt) {
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
                if (/([Y,y]+)/.test(fmt)) {
                    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
                }
                for (var k in o) {
                    if (new RegExp("(" + k + ")").test(fmt)) {
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

    activityinsert: function (root) {
        if (confirm("确认增加或修改活动？")) {
            var form = new FormData(document.getElementById("former"));
            console.log(this.root + "/option/activityinsert");
            $.ajax({
                url: root + "/option/activityinsert",
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                data: form,
                processData: false,
                contentType: false,
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
    //活动编辑
    activityedit: function (root, id) {
        var data = new FormData();
        data.append("ID", id);
        var roos = "'"+root+"'";
        //调用后台接口，找到對應商品
        $.ajax({
            url: root + "/option/activityedit",
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            data: data,
            processData: false,
            contentType: false,
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
                var icons = result.result.icons;
                if (icons!=null) {
                    for (var item = 0; item < icons.length; item++) {
                        var ids = item + 1000;
                        var imageurl = "'" + icons[item].id + "'";
                        var imgSrc = resource + icons[item].imageUrl;
                        var result = '<img src="' + imgSrc + '" onclick="imgDisplay(this)"><p onclick="removeImg(' + roos + ',' + ids + ',' + imageurl + ')" class="imgDelete">删除</p>';
                        var div = document.createElement('div');
                        div.id = "result" + ids;
                        div.setAttribute("class", "imgContainer");
                        div.innerHTML = result;
                        document.getElementById('images').appendChild(div);
                    }
                }
                productadd("编辑");
            },
            error: function () {
                console.log("请求异常,检查网络和参数！");
            }
        });
    },
    //活动移除
    activitydelete: function (root, id) {
        if (confirm("确定要删除当前活动？")) {
            var data = new FormData();
            data.append("ID", id);
            //调用后台接口，进行数据删除操作
            $.ajax({
                url: root + "/option/activitydelete",
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                data: data,
                processData: false,
                contentType: false,
                success: function (result) {
                    //在这里需要刷新Table表格数据
                    $('table').GM('refreshGrid');
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
    //活动绑定商品页面
    onactivityproduct: function (root) {
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
            "<div id='addbox' class=\"box\" style=\"display:none\">\n" +
            "    <div class=\"card\">\n" +
            "        <div class=\"card-header\">\n" +
            "            <div class=\"card-title\">\n" +
            "                <div id='addtitle' class=\"title\">参与活动的商品</div>\n" +
            "            </div>\n" +
            "            <div class=\"text-right \" style=\"padding: 1.2em 25px;\">\n" +
            "                <button onclick=\"darly().activityproductcloseer()\" style='width: 40px' ><i class='fa fa-remove'></i></button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"card-body\">\n" +
            "                <table id='activityproduct'>\n" +
            "                </table>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>"));
        //假如弹出新增商品功能页面
        $(".side-body").append($("<div id=\"bgprod\"></div>\n" +
            "<div id='boxprod' class=\"box\" style=\"display:none;background-color: #00cdcd\">\n" +
            "    <div class=\"card\">\n" +
            "        <div class=\"card-header\">\n" +
            "            <div class=\"card-title\">\n" +
            "                <div id='titleprod' class=\"title\">参与活动的商品</div>\n" +
            "            </div>\n" +
            "            <div class=\"text-right \" style=\"padding: 1.2em 25px;\">\n" +
            "                <button style='width: 40px;margin: 5px;' onclick=\"darly().activityproductinsert('" + root + "')\"><i class='fa fa-save'></i></button>\n" +
            "                <button onclick=\"darly().activityprodcloseer()\" style='width: 40px' ><i class='fa fa-remove'></i></button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"card-body\">\n" +
            "                <table id='activityproductinsert'>\n" +
            "                </table>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>"));
        //活动展示
        var table = document.querySelector('#activityshow');
        if (table != null) {
            table.GM({
                supportRemind: true
                , gridManagerName: 'test'
                , isCombSorting: true
                , supportAjaxPage: true
                , supportSorting: true
                , ajax_url: root + '/option/activityentryser'
                , ajax_type: 'POST'
                , query: {pluginId: 1}
                , supportAdjust: true
                , supportAutoOrder: false
                , supportCheckbox: false
                , pageSize: 50
                , columnData: [{
                    key: 'id',
                    remind: 'id',
                    text: '编号',
                    sorting: ''
                }, {
                    key: 'storeType',
                    remind: 'storeType',
                    text: '类型'
                }, {
                    key: 'storeDesc',
                    remind: 'storeDesc',
                    text: '简介'
                }, {
                    key: 'storeStartTime',
                    remind: 'storeStartTime',
                    text: '开启时间',
                    template: function (storeStartTime, rowObject) {
                        return new Date(storeStartTime).format('YYYY-MM-DD HH:mm:ss');
                    }
                }, {
                    key: 'storeEndTime',
                    remind: 'storeEndTime',
                    text: '结束时间',
                    template: function (storeEndTime, rowObject) {
                        return new Date(storeEndTime).format('YYYY-MM-DD HH:mm:ss');
                    }
                }, {
                    key: 'storeTypeOp',
                    remind: 'storeTypeOp',
                    text: '负责人'
                }, {
                    key: 'storeCreatetime',
                    remind: 'storeCreatetime',
                    text: '创建时间',
                    template: function (storeCreatetime, rowObject) {
                        return new Date(storeCreatetime).format('YYYY-MM-DD HH:mm:ss');
                    }
                }, {
                    key: 'storeUpdatetime',
                    remind: 'storeUpdatetime',
                    text: '更新时间',
                    template: function (storeUpdatetime, rowObject) {
                        return new Date(storeUpdatetime).format('YYYY-MM-DD HH:mm:ss');
                    }
                }, {
                    key: 'storeUpdatereason',
                    remind: 'storeUpdatereason',
                    text: '原因'
                }, {
                    key: 'storeTypeIcon',
                    remind: 'storeTypeIcon',
                    text: '图片'
                }, {
                    key: 'action',
                    remind: 'the action',
                    width: '100px',
                    text: '操作',
                    template: function (action, rowObject) {
                        var id = "\'" + rowObject.id + "\'";
                        var title = "\'" + rowObject.storeDesc + "\'";
                        var roots = "\'" + root + "\'";
                        return '<button  class="activityproductedit" style="width: 40px;margin: 5px" onclick="darly().activityproductedit(' + roots + ',' + id + ',' + title + ')"><i class="fa fa-edit"></i></button>' +
                            '<button  class="activityproductedit" style="width: 40px;margin: 5px" onclick="darly().activityproductadd(' + roots + ',' + id + ',' + title + ')"><i class="fa fa-plus"></i></button>';
                    }
                }]
                // 分页前事件
                , pagingBefore: function (query) {
                    console.log('pagingBefore', query);
                }
                // 分页后事件
                , pagingAfter: function (data) {
                    console.log('pagingAfter', data);
                }
                // 排序前事件
                , sortingBefore: function (data) {
                    console.log('sortBefore', data);
                }
                // 排序后事件
                , sortingAfter: function (data) {
                    console.log('sortAfter', data);
                }
                // 宽度调整前事件
                , adjustBefore: function (event) {
                    console.log('adjustBefore', event);
                }
                // 宽度调整后事件
                , adjustAfter: function (event) {
                    console.log('adjustAfter', event);
                }
                // 拖拽前事件
                , dragBefore: function (event) {
                    console.log('dragBefore', event);
                }
                // 拖拽后事件
                , dragAfter: function (event) {
                    console.log('dragAfter', event);
                }
            });
            // 日期格式化,不是插件的代码,只用于处理时间格式化
            Date.prototype.format = function (fmt) {
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
                if (/([Y,y]+)/.test(fmt)) {
                    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
                }
                for (var k in o) {
                    if (new RegExp("(" + k + ")").test(fmt)) {
                        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                    }
                }
                return fmt;
            };
        }
        //编辑浮层
        var table = document.querySelector("#activityproduct");
        if (table != null) {
            table.GM({
                supportRemind: true
                , gridManagerName: 'test'
                , isCombSorting: true
                , supportAjaxPage: true
                , supportSorting: false
                , ajax_url: root + '/option/actproduct'
                , ajax_type: 'POST'
                , query: {pluginId: 1}
                , supportAdjust: true//是否可以宽度调整
                , supportAutoOrder: false
                , supportCheckbox: false
                , pageSize: 50
                , columnData: [{
                    key: 'id',
                    remind: 'id',
                    text: '商品编号',
                }, {
                    key: 'productName',
                    remind: 'productName',
                    text: '商品名称',
                }, {
                    key: 'productPrice',
                    remind: 'productPrice',
                    text: '商品现价',
                }, {
                    key: 'productOrprice',
                    remind: 'productOrprice',
                    text: '商品原价',
                }, {
                    key: 'productDesc',
                    remind: 'productDesc',
                    text: '商品简介',
                }, {
                    key: 'productImage',
                    remind: 'productImage',
                    text: '图片'
                }, {
                    key: 'productNum',
                    remind: 'productNum',
                    text: '库存'
                }, {
                    key: 'productStars',
                    remind: 'productStars',
                    text: '评分'
                }, {
                    key: 'action',
                    remind: 'the action',
                    width: '100px',
                    text: '操作',
                    template: function (action, rowObject) {
                        var id = "\'" + rowObject.id + "\'";
                        var title = "\'" + rowObject.productName + "\'";
                        var roots = "\'" + root + "\'";
                        return '<button class="activityproductremove"  style="width: 40px;margin: 5px" onclick="darly().activityproductremove(' + roots + ',' + id + ',' + title + ')"><i class="fa fa-trash-o"></i></button>';
                    }
                }]
                // 分页前事件
                , pagingBefore: function (query) {
                    console.log('pagingBefore', query);
                }
                // 分页后事件
                , pagingAfter: function (data) {
                    console.log('pagingAfter', data);
                }
                // 排序前事件
                , sortingBefore: function (data) {
                    console.log('sortBefore', data);
                }
                // 排序后事件
                , sortingAfter: function (data) {
                    console.log('sortAfter', data);
                }
                // 宽度调整前事件
                , adjustBefore: function (event) {
                    console.log('adjustBefore', event);
                }
                // 宽度调整后事件
                , adjustAfter: function (event) {
                    console.log('adjustAfter', event);
                }
                // 拖拽前事件
                , dragBefore: function (event) {
                    console.log('dragBefore', event);
                }
                // 拖拽后事件
                , dragAfter: function (event) {
                    console.log('dragAfter', event);
                }
            });
        }
        //进入关联页面
        var table = document.querySelector("#activityproductinsert");
        if (table != null) {
            table.GM({
                supportRemind: true
                , gridManagerName: 'test'
                , isCombSorting: true
                , supportAjaxPage: true
                , supportSorting: false
                , ajax_url: root + '/option/activityproductinsert'
                , ajax_type: 'POST'
                , query: {pluginId: 1}
                , supportAdjust: true
                , supportAutoOrder: false
                , supportCheckbox: true
                , supportDrag: false
                , pageSize: 50
                , columnData: [{
                    key: 'id',
                    remind: 'id',
                    text: '商品编号',
                }, {
                    key: 'productName',
                    remind: 'productName',
                    text: '商品名称',
                }, {
                    key: 'productPrice',
                    remind: 'productPrice',
                    text: '商品现价',
                }, {
                    key: 'productOrprice',
                    remind: 'productOrprice',
                    text: '商品原价',
                }, {
                    key: 'productDesc',
                    remind: 'productDesc',
                    text: '商品简介',
                }, {
                    key: 'productImage',
                    remind: 'productImage',
                    text: '图片'
                }, {
                    key: 'productNum',
                    remind: 'productNum',
                    text: '库存'
                }, {
                    key: 'productStars',
                    remind: 'productStars',
                    text: '评分'
                }]
                // 分页前事件
                , pagingBefore: function (query) {
                    console.log('pagingBefore', query);
                }
                // 分页后事件
                , pagingAfter: function (data) {
                    console.log('pagingAfter', data);
                }
                // 排序前事件
                , sortingBefore: function (data) {
                    console.log('sortBefore', data);
                }
                // 排序后事件
                , sortingAfter: function (data) {
                    console.log('sortAfter', data);
                }
                // 宽度调整前事件
                , adjustBefore: function (event) {
                    console.log('adjustBefore', event);
                }
                // 宽度调整后事件
                , adjustAfter: function (event) {
                    console.log('adjustAfter', event);
                }
                // 拖拽前事件
                , dragBefore: function (event) {
                    console.log('dragBefore', event);
                }
                // 拖拽后事件
                , dragAfter: function (event) {
                    console.log('dragAfter', event);
                }
            });


        }

    },
    //移除绑定商品
    activityproductremove: function (root, id, title) {
        if (confirm("是否要从活动中移除关联的 " + title + " 商品？")) {
            //移除，删除数据操作
            var data = new FormData();
            data.append("ID", id);
            //调用后台接口，进行数据删除操作
            $.ajax({
                url: root + "/option/activityproductremove",
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                data: data,
                processData: false,
                contentType: false,
                success: function (result) {
                    //在这里需要刷新Table表格数据
                    var table = document.querySelector("#activityproduct");
                    table.GM('refreshGrid');
                    //在这里需要刷新Table表格数据
                    console.log(result);
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
    //点编辑查看关联商品浮层
    activityproductedit: function (root, id, title) {
        var _query = {
            id: id,
        };
        var table = document.querySelector("#activityproduct");
        table.GM('setQuery', _query).GM('refreshGrid', function () {
            $("#addtitle").html(title + "关联商品");
            $("#bg").css({
                display: "block", height: $(document).height()
            });
            var $box = $('#addbox');
            $box.css({
                //设置弹出层距离左边的位置
                width: $("body").width() - 100 + "px",
                left: 80 + "px",
                //设置弹出层距离上面的位置
                top: 80 + "px",
                display: "block"
            });

        });
    },
    //点击关联商品后弹出浮层
    activityproductadd: function (root, id, title) {
        var _query = {
            storeType: id,
        };
        var table = document.querySelector("#activityproductinsert");
        table.GM('setQuery', _query).GM('refreshGrid', function () {
            $("#titleprod").html("添加参与本活动的商品");
            $("#bgprod").css({
                display: "block", height: $(document).height()
            });
            var $box = $('#boxprod');
            $box.css({
                //设置弹出层距离左边的位置
                width: $("body").width() - 80 + "px",
                left: 70 + "px",
                //设置弹出层距离上面的位置
                top: 70 + "px",
                display: "block"
            });
        });
    },
    //新增关联商品
    activityproductinsert: function (root) {
        //新增关联商品
        if (confirm("商品是否确定参与此活动？")) {
            var table = document.querySelector("#activityproductinsert");
            var a = table.GM("getCheckedTr");

            var storeType = table.GM("getSettings").query.storeType;//获取到了活动ID
            var data = new FormData();
            data.append("storeType", storeType);
            var arg = [];
            for (var i = 0; i < a.length; i++) {
                arg.push(a[i].children[1].innerText);
            }
            console.log(arg);
            data.append("id", arg);
            //调用后台接口，进行数据删除操作
            $.ajax({
                url: root + "/option/activitysaleinsert",
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                data: data,
                processData: false,
                contentType: false,
                success: function (result) {
                    new darly().activityprodcloseer();
                    console.log(result);
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

    activityproductcloseer: function () {
        //点击关闭按钮的时候，遮罩层关闭
        $("#bg,.box").css("display", "none");
    },

    activityprodcloseer: function () {
        //点击关闭按钮的时候，遮罩层关闭
        $("#bgprod,#boxprod").css("display", "none");
    },


    autoChangeFile:function (id,uiindex) {
        var emptyCount = 0;
        $(".auto_upload_file").each(function() {
            if (this.value == "") {
                emptyCount++;
            }
        });
        var input = $("#"+id);
        if (!input[0].value.match(/.jpg|.gif|.png|.bmp/i)) {　　//判断上传文件格式
            console.warn("上传的图片格式不正确，请重新选择");
        }else {
            var fileList = input[0].files;
            for(var i = 0; i < fileList.length; i++) {
                var imgSrcI = getObjectURLs(fileList[i]);
                var result = '<img src="' + imgSrcI + '" onclick="imgDisplay(this)"><p onclick="removeImg(0,' + uiindex + ',null)" class="imgDelete">删除</p>';
                var div = document.createElement('div');
                div.id = "result"+uiindex;
                div.setAttribute("class","imgContainer");
                div.innerHTML = result;
                document.getElementById('images').appendChild(div);
            }
            //圖片加載完成后，進行新模塊添加
            if (emptyCount == 0) {
                uiindex++;
                $("#"+id).css("display", "none");;
                $("#inputBox").append("<input type=\"file\" id='file"+uiindex+"' name='file' class='auto_upload_file' name='file' onchange='new darly().autoChangeFile(\"file\"+"+uiindex+","+uiindex+")'/>");
            }
　　    }
    },
    oncleanFile:function (id,index) {
        console.info(id+"-------->"+index);
        var fileObj = $("#"+id);
        if (fileObj.clone().val() != "" || fileObj.val() != "") {
            fileObj.after(fileObj.clone().val(""));
            var pObj = fileObj.parent();
            fileObj.remove();
            var count = 0;
            $(".auto_upload_file").each(function() {
                count++;
            });
            if (count > 1) {
                pObj.remove();
            }
        }
        var imageObj = $("#result"+index);
        imageObj.parent().remove();
    },
}