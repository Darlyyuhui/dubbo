<%--
  Created by IntelliJ IDEA.
  User: Darly
  Date: 2017/10/11
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <!--標題欄圖標-->
    <link rel="SHORTCUT ICON" href="${sourceUrl}/images/base/logo.ico"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${itmsname}</title>
    <!-- 引入 Bootstrap -->
    <link href="${sourceUrl}/basejs/bootstrap/ace/css/bootstrap.min.css" rel="stylesheet">
    <link href="${sourceUrl}/basejs/bootstrap/ace/css/site.min.css" rel="stylesheet">

    <link href="${sourceUrl}/basejs/json/css/font-awesome.min.css" rel="stylesheet">
    <link href="${sourceUrl}/basejs/json/css/base.css" rel="stylesheet">
    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <meta name="keywords" content="json,json在线解析,json格式化,json格式验证,json转xml,xml转json">
    <style type="text/css">.json_key {
        color: #92278f;
        font-weight: bold;
    }

    .json_null {
        color: #f1592a;
        font-weight: bold;
    }

    .json_string {
        color: #3ab54a;
        font-weight: bold;
    }

    .json_number {
        color: #25aae2;
        font-weight: bold;
    }

    .json_boolean {
        color: #f98280;
        font-weight: bold;
    }

    .json_link {
        color: #61D2D6;
        font-weight: bold;
    }

    .json_array_brackets {
    }</style>
</head>
<body>
<tags:header/>
<div class="container tag-body">
    <div>
        <h3>JSON验证</h3>
    </div>
    <div class="dropdown" style="border:0;height: 48px">
        <button type="button" data-toggle="dropdown" class="dropdown-toggle btn btn-default">
            API接口访问
        </button>
        <ul class="dropdown-menu">
            <li>
                <a href="javascript:showMenu('${root}/mobile/api/list')" class="tooltip-test" data-toggle="tooltip"
                   title="${root}/mobile/api/list GET请求">所有用户信息接口</a>
            </li>
            <li class="divider"></li>
            <li>
                <a href="javascript:showMenu('${root}/mobile/loginlog')" class="tooltip-test" data-toggle="tooltip"
                   title="${root}/mobile/loginlog GET请求">系统登录日志接口</a>
            </li>
            <li class="divider"></li>
            <li>
                <a href="#">等待中</a>
            </li>
            <li class="divider"></li>
            <li>
                <a href="#">等待中</a>
            </li>
            <li class="divider"></li>
            <li>
                <a href="#">等待中</a>
            </li>
            <li class="divider"></li>
            <li>
                <a href="#">等待中</a>
            </li>
        </ul>
    </div>
    <main class="row-fluid" style="height:85%;min-height:550px;">
        <div class="col-md-5" style="padding:0px;height:100%;">
            <div class="numberedtextarea-wrapper "><textarea id="json-src" placeholder="在此输入json字符串或XML字符串..."
                                                             class="form-control"
                                                             style="height:100%;height: 87vh;min-height:520px;padding:10px 10px 10px 30px;border:0;border-right:solid 1px #E5EBEE;border-bottom:solid 1px #eee;border-radius:0;resize: none; outline:none;font-size:10px;"></textarea>
                <div class="numberedtextarea-line-numbers"
                     style="padding-top: 10px; line-height: 17.1429px; font-family: menlo, monospace, Tahoma, 微软雅黑, 幼圆; width: 30px;">
                    <div class="numberedtextarea-number numberedtextarea-number-1" style="margin-bottom: 10px;">1</div>
                </div>
            </div>
        </div>
        <div class="col-md-7" style="padding:0;position:relative;height:100%;background-color: white">
            <div class="tool" style="position:absolute;">
                <a href="#" class="tip zip" title="" data-placement="bottom" data-original-title="压缩"
                   style="color:#999;">压缩<i class="glyphicon glyphicon-move"></i></a>
                <a href="#" class="tip xml" title="" data-placement="bottom" data-original-title="转XML"
                   style="color:#999;">转XML<i class="glyphicon glyphicon-move"></i></a>
                <a href="#" class="tip shown" title="" data-placement="bottom" data-original-title="显示行号">显示行号<i
                        class="glyphicon glyphicon-move"></i></a>
                <a href="#" class="tip clear" title="" data-placement="bottom" data-original-title="清空">清空<i
                        class="glyphicon glyphicon-move"></i></a>
                <a href="#" class="tip save" title="" data-placement="bottom" data-original-title="保存">保存<i
                        class="glyphicon glyphicon-move"></i></a>
                <a href="#" class="tip copy" title="" data-clipboard-target="#json-target" data-placement="bottom"
                   data-original-title="复制">复制<i class="glyphicon glyphicon-move"></i></a>
            </div>
            <div id="right-box"
                 style="width:100%;height: 87vh;min-height:520px;border:solid 1px #f6f6f6;border-radius:0;resize: none;overflow-y:scroll; outline:none;position:relative;font-size:12px;padding-top:40px;">
                <div id="line-num"
                     style="background-color:#fafafa;padding:0px 8px;float:left;border-right:dashed 1px #E5EBEE;display:none;z-index:-1;color:#999;position:absolute;text-align:center;over-flow:hidden;">
                    <div>1
                        <div></div>
                    </div>
                </div>
                <div class="ro" id="json-target" style="padding:0px 25px;white-space: pre-line;"></div>
            </div>
            <form id="form-save" method="POST"><input type="hidden" value="" id="txt-content" name="content"></form>
        </div>
        <br style="clear:both;">
    </main>
</div>
<hr>
<tags:footer/>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="${sourceUrl}/basejs/bootstrap/ace/js/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="${sourceUrl}/basejs/bootstrap/ace/js/bootstrap.min.js"></script>
<link href="${sourceUrl}/basejs/json/css/jquery.numberedtextarea.css" rel="stylesheet">
<script src="${sourceUrl}/basejs/json/js/hm.js"></script>
<script src="${sourceUrl}/basejs/json/jq/jquery.min.js"></script>
<script src="${sourceUrl}/basejs/json/jq/jquery.message.js"></script>
<script src="${sourceUrl}/basejs/json/jq/jquery.json.js"></script>
<script src="${sourceUrl}/basejs/json/jq/jquery.xml2json.js"></script>
<script src="${sourceUrl}/basejs/json/jq/jquery.json2xml.js"></script>
<script src="${sourceUrl}/basejs/json/js/json2.js"></script>
<script src="${sourceUrl}/basejs/json/js/jsonlint.js"></script>
<script src="${sourceUrl}/basejs/json/js/clipboard.min.js"></script>
<script src="${sourceUrl}/basejs/json/js/FileSaver.min.js"></script>
<script src="${sourceUrl}/basejs/json/jq/jquery.numberedtextarea.js"></script>
<script type="text/javascript">
    //      $(function () { $("[data-toggle='tooltip']").tooltip(); });

    function showMenu(url) {
        $.ajax({
            type: "GET",
            url: url,
            data: {},//数据
            async: false,//同步
            dataType: 'json',
            success: function (data) {
                console.info(JSON.stringify(data))
                $('textarea').val(JSON.stringify(data))
                $('#json-src').keyup();
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.info("报错")
                $('textarea').val(errorThrown.toString())
                $('#json-src').keyup();
            }
        });

    }

    $('textarea').numberedtextarea();
    var current_json = '';
    var current_json_str = '';
    var xml_flag = false;
    var zip_flag = false;
    var shown_flag = false;

    function init() {
        xml_flag = false;
        zip_flag = false;
        shown_flag = false;
        renderLine();
        $('.xml').attr('style', 'color:#999;');
        $('.zip').attr('style', 'color:#999;');

    }

    $('#json-src').keyup(function () {
        init();
        var content = $.trim($(this).val());
        var result = '';
        if (content != '') {
            //如果是xml,那么转换为json
            if (content.substr(0, 1) === '<' && content.substr(-1, 1) === '>') {
                try {
                    var json_obj = $.xml2json(content);
                    content = JSON.stringify(json_obj);
                } catch (e) {
                    result = '解析错误：<span style="color: #f1592a;font-weight:bold;">' + e.message + '</span>';
                    current_json_str = result;
                    $('#json-target').html(result);
                    return false;
                }

            }
            try {
                current_json = jsonlint.parse(content);
                current_json_str = JSON.stringify(current_json);
                //current_json = JSON.parse(content);
                result = new JSONFormat(content, 4).toString();
            } catch (e) {
                result = '<span style="color: #f1592a;font-weight:bold;">' + e + '</span>';
                current_json_str = result;
            }

            $('#json-target').html(result);
        } else {
            $('#json-target').html('');
        }
    });
    $('.xml').click(function () {
        if (xml_flag) {
            $('#json-src').keyup();
        } else {
            var result = $.json2xml(current_json);
            $('#json-target').html('<textarea style="width:100%;position:absolute;height: 80vh;min-height:480px;border:0;resize:none;">' + result + '</textarea>');
            xml_flag = true;
            $(this).attr('style', 'color:#15b374;');
        }

    });
    $('.shown').click(function () {
        if (!shown_flag) {
            renderLine();
            $('#line-num').show();
            $('.numberedtextarea-line-numbers').show();
            shown_flag = true;
            $(this).attr('style', 'color:#15b374;');
        } else {
            $('#line-num').hide();
            $('.numberedtextarea-line-numbers').hide();
            shown_flag = false;
            $(this).attr('style', 'color:#999;');
        }
    });

    function renderLine() {
        var line_num = $('#json-target').height() / 20;
        $('#line-num').html("");
        var line_num_html = "";
        for (var i = 1; i < line_num + 1; i++) {
            line_num_html += "<div>" + i + "<div>";
        }
        $('#line-num').html(line_num_html);
    }

    $('.zip').click(function () {
        if (zip_flag) {
            $('#json-src').keyup();
        } else {
            $('#json-target').html(current_json_str);
            zip_flag = true;
            $(this).attr('style', 'color:#15b374;');
        }

    });
    $('.clear').click(function () {
        $('#json-src').val('');
        $('#json-target').html('');
    });
    (function ($) {
        $.fn.innerText = function (msg) {
            if (msg) {
                if (document.body.innerText) {
                    for (var i in this) {
                        this[i].innerText = msg;
                    }
                } else {
                    for (var i in this) {
                        this[i].innerHTML.replace(/&amp;lt;br&amp;gt;/gi, "n").replace(/(&amp;lt;([^&amp;gt;]+)&amp;gt;)/gi, "");
                    }
                }
                return this;
            } else {
                if (document.body.innerText) {
                    return this[0].innerText;
                } else {
                    return this[0].innerHTML.replace(/&amp;lt;br&amp;gt;/gi, "n").replace(/(&amp;lt;([^&amp;gt;]+)&amp;gt;)/gi, "");
                }
            }
        };
    })(jQuery);
    $('.save').click(function () {
        // var content = JSON.stringify(current_json);
        // $('#txt-content').val(content);
        //var text = "hell world";
        var html = $('#json-target').html().replace(/\n/g, '<br/>').replace(/\n/g, '<br>');
        var text = $('#json-target').innerText();
        var blob = new Blob([text], {type: "text/plain;charset=utf-8"});
        saveAs(blob, "format.json");
    });
    $('.copy').click(function () {
        //$.msg("成功复制到粘贴板","color:#00D69C;");
        // $(this).tooltip('toggle')
        //       .attr('data-original-title', "复制成功！")
        //       .tooltip('fixTitle')
        //       .tooltip('toggle');
    });
    var clipboard = new Clipboard('.copy');
</script>
</body>
</html>