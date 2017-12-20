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
        "                    <button onclick=\"add()\">新增商品</button>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "<div class=\"search-area\">\n" +
        "    <div class=\"sa-ele\">\n" +
        "        <label class=\"se-title\">名称:</label>\n" +
        "        <input class=\"se-con\" name=\"name\"/>\n" +
        "    </div>\n" +
        "    <div class=\"sa-ele\">\n" +
        "        <label class=\"se-title\">使用说明:</label>\n" +
        "        <input class=\"se-con\" name=\"info\"/>\n" +
        "    </div>\n" +
        "    <div class=\"sa-ele\">\n" +
        "        <label class=\"se-title\">url:</label>\n" +
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
                ,pageSize:50
                ,columnData: [{
                    key: 'productName',
                    remind: 'productName',
                    text: '商品名称',
                    sorting: ''
                },{
                    key: 'productPrice',
                    remind: 'productPrice',
                    text: '商品现价',
                    sorting: ''
                },{
                    key: 'productOrprice',
                    remind: 'productOrprice',
                    text: '商品原价',
                    sorting: ''
                },{
                    key: 'productDesc',
                    remind: 'productDesc',
                    text: '商品简介',
                    sorting: ''
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
                        return '<button style="margin: 5px" onclick="cler('+id+')">查看</button>' +
                            '<button  style="margin: 5px" onclick="good('+id+')">编辑</button>'
                            +'<button style="margin: 5px" onclick="del('+id+')">删除</button>';
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
                    name: document.querySelector('[name="name"]').value,
                    info: document.querySelector('[name="info"]').value,
                    url: document.querySelector('[name="url"]').value
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
    //活动录入页面
    onactivityentry:function (root) {
        //window.location.href = root+"/option/activityentry";
        $("#baseset").removeClass("active");
        $("#storeset").removeClass("active");
        $("#actset").addClass("active");

        $(".side-body").empty();
        $(".side-body").append($("<div class=\"search-area\">\n" +
            "    <div class=\"sa-ele\">\n" +
            "        <label class=\"se-title\">名称:</label>\n" +
            "        <input class=\"se-con\" name=\"name\"/>\n" +
            "    </div>\n" +
            "    <div class=\"sa-ele\">\n" +
            "        <label class=\"se-title\">使用说明:</label>\n" +
            "        <input class=\"se-con\" name=\"info\"/>\n" +
            "    </div>\n" +
            "    <div class=\"sa-ele\">\n" +
            "        <label class=\"se-title\">url:</label>\n" +
            "        <input class=\"se-con\" name=\"url\"/>\n" +
            "    </div>\n" +
            "    <div class=\"sa-ele\">\n" +
            "        <button class=\"search-action\">搜索</button>\n" +
            "        <button class=\"reset-action\">重置</button>\n" +
            "    </div>\n" +
            "</div>"));
        $(".side-body").append($("<table></table>"));
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
                ,pageSize:50
                ,columnData: [{
                    key: 'storeType',
                    remind: 'storeType',
                    text: '类型',
                    sorting: ''
                },{
                    key: 'storeDesc',
                    remind: 'storeDesc',
                    text: '简介'
                },{
                    key: 'storeStartTime',
                    remind: 'storeStartTime',
                    text: '开启时间',
                    sorting: 'DESC',
                    template: function(storeStartTime, rowObject){
                        return new Date(storeStartTime).format('YYYY-MM-DD HH:mm:ss');
                    }
                },{
                    key: 'storeEndTime',
                    remind: 'storeEndTime',
                    text: '结束时间',
                    sorting: 'DESC',
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
                        sorting: 'DESC',
                        template: function(storeCreatetime, rowObject){
                        return new Date(storeCreatetime).format('YYYY-MM-DD HH:mm:ss');
                    }
                },{
                    key: 'storeUpdatetime',
                        remind: 'storeUpdatetime',
                        text: '更新时间',
                        sorting: 'DESC',
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
                        return '<button style="margin: 5px" onclick="cler('+id+')">查看</button>' +
                            '<button  style="margin: 5px" onclick="good('+id+')">编辑</button>'
                            +'<button style="margin: 5px" onclick="del('+id+')">删除</button>';
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
                    name: document.querySelector('[name="name"]').value,
                    info: document.querySelector('[name="info"]').value,
                    url: document.querySelector('[name="url"]').value
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
    }
}