<%--
  Created by IntelliJ IDEA.
  User: Darly
  Date: 2017/12/15
  Time: 15:14
  管理商城，直接针对数据库进行修改操作。
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="SHORTCUT ICON" href="${resourceUrl}/images/base/logo.ico"/>
    <meta name="author" content="Darly"/>
    <title>${itmsname}</title>

    <link href="${resourceUrl}/store/css/font-awesome.min.css" rel="stylesheet">
    <link href="${resourceUrl}/store/option/bootstrap.min.css" rel="stylesheet" >
    <script src="${resourceUrl}/basejs/darly.js"></script>
    <!-- CSS App -->
    <link rel="stylesheet" href="${resourceUrl}/store/option/style.css">
    <link rel="stylesheet" href="${resourceUrl}/store/option/themes/flat-blue.css">
    <link rel="stylesheet" href="${resourceUrl}/store/css/storeproduct.css">
    <style type="text/css">
        .box{position:absolute;width:600px;left:50%;height:auto;z-index:100;background-color:#fff;border:1px #ddd solid;padding:1px;}
        .box h2{height:25px;font-size:14px;background-color:#aaa;position:relative;padding-left:10px;line-height:25px;color:#fff;}
        .box h2 a{position:absolute;right:5px;font-size:12px;color:#fff;}
        .box .list{padding:10px;}
        .box .list li{height:24px;line-height:24px;}
        .box .list li span{margin:0 5px 0 0;font-family:"宋体";font-size:12px;font-weight:400;color:#ddd;}
        .showbtn {font:bold 24px '微软雅黑';}
        #bg{background-color:#666;position:absolute;z-index:99;left:0;top:0;display:none;width:100%;height:100%;opacity:0.5;filter: alpha(opacity=50);-moz-opacity: 0.5;}
    </style>
</head>
<body class="flat-blue">
<div class="app-container">
    <div class="row content-container">
        <nav class="navbar navbar-default navbar-fixed-top navbar-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-expand-toggle">
                        <i class="fa fa-bars icon"></i>
                    </button>
                    <ol class="breadcrumb navbar-breadcrumb">
                        <li class="active">商城管理</li>
                    </ol>
                    <button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                        <i class="fa fa-th icon"></i>
                    </button>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                        <i class="fa fa-times icon"></i>
                    </button>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-comments-o"></i></a>
                        <ul class="dropdown-menu animated fadeInDown">
                            <li class="title">
                                通知 <span class="badge pull-right">0</span>
                            </li>
                            <li class="message">
                                没有新通知
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown danger">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-star-half-o"></i> </a>
                        <ul class="dropdown-menu danger  animated fadeInDown">
                            <li class="title">
                                通知 <span class="badge pull-right"></span>
                            </li>
                            <li>
                                <ul class="list-group notifications">
                                    <a href="#">
                                        <li class="list-group-item">
                                            <span class="badge">1</span> <i class="fa fa-exclamation-circle icon"></i> 新注册
                                        </li>
                                    </a>
                                    <a href="#">
                                        <li class="list-group-item">
                                            <span class="badge success">1</span> <i class="fa fa-check icon"></i> 新消息
                                        </li>
                                    </a>
                                    <a href="#">
                                        <li class="list-group-item">
                                            <span class="badge danger">2</span> <i class="fa fa-comments icon"></i> 用户信息
                                        </li>
                                    </a>
                                    <a href="#">
                                        <li class="list-group-item message">
                                            查看所有
                                        </li>
                                    </a>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown profile">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">用户信息<span class="caret"></span></a>
                        <ul class="dropdown-menu animated fadeInDown">
                            <li class="profile-img">
                                <img src="${resourceUrl}/store/images/main-bg-slider.jpg" class="profile-img">
                            </li>
                            <li>
                                <div class="profile-info">
                                    <h4 class="username">${userName}</h4>
                                    <p>${account}</p>
                                    <div class="btn-group margin-bottom-2x" role="group">
                                        <button type="button" class="btn btn-default"><i class="fa fa-user"></i> Profile</button>
                                        <button type="button" class="btn btn-default"><i class="fa fa-sign-out"></i> Logout</button>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="side-menu sidebar-inverse">
            <nav class="navbar navbar-default" role="navigation">
                <div class="side-menu-container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="javascript:darly().onstoreoperationindex('${root}');">
                            <div class="icon fa fa-paper-plane"></div>
                            <div class="title">商城管理</div>
                        </a>
                        <button type="button" class="navbar-expand-toggle pull-right visible-xs">
                            <i class="fa fa-times icon"></i>
                        </button>
                    </div>
                    <ul  class="nav navbar-nav">
                        <li id="baseset" class="active">
                            <a href="javascript:darly().onstoreoperationindex('${root}');">
                                <span class="icon fa fa-tachometer"></span><span class="title">基础设置</span>
                            </a>
                        </li>
                        <li id="storeset" class="panel panel-default dropdown">
                            <a data-toggle="collapse" href="#dropdown-element">
                                <span class="icon fa fa-desktop"></span><span class="title">商城模块</span>
                            </a>
                            <!-- Dropdown level 1 -->
                            <div id="dropdown-element" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav navbar-nav">
                                        <li><a href="javascript:darly().onproductentry('${root}');">商品录入</a>
                                        </li>
                                        <li><a href="#">暂未开通</a>
                                        </li>
                                        <li><a href="#">暂未开通</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li id="actset" class="panel panel-default dropdown">
                            <a data-toggle="collapse" href="#dropdown-table">
                                <span class="icon fa fa-table"></span><span class="title">活动模块</span>
                            </a>
                            <!-- Dropdown level 1 -->
                            <div id="dropdown-table" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav navbar-nav">
                                        <li><a href="javascript:darly().onactivityentry('${root}');">活动录入</a>
                                        </li>
                                        <li><a href="javascript:darly().onactivityproduct('${root}');">活动绑定</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="javascript:darly().storehome('${root}');">
                                <span class="icon fa fa-stop"></span><span class="title">查看商城</span>
                            </a>
                        </li>

                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>
        </div>

        <!-- Main Content -->
        <div class="container-fluid">
            <div class="side-body">
                <div class="page-title">
                    <span class="title">商城管理图表展示</span>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-xs-12">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title">
                                    <div class="title">线图</div>
                                </div>
                            </div>
                            <div class="card-body no-padding">
                                <canvas id="line-chart" class="chart"></canvas>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-xs-12">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title">
                                    <div class="title">柱图</div>
                                </div>
                            </div>
                            <div class="card-body no-padding">
                                <canvas id="bar-chart" class="chart"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-xs-12">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title">
                                    <div class="title">雷达图</div>
                                </div>
                            </div>
                            <div class="card-body no-padding">
                                <canvas id="radar-chart" class="chart"></canvas>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-xs-12">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title">
                                    <div class="title">极坐标系下的堆叠柱状图</div>
                                </div>
                            </div>
                            <div class="card-body no-padding">
                                <canvas id="polar-area-chart" class="chart"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-xs-12">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title">
                                    <div class="title">饼图</div>
                                </div>
                            </div>
                            <div class="card-body no-padding">
                                <canvas id="pie-chart" class="chart"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="page-title">
                    <span class="title">Card Jumbotron</span>
                    <div class="description">Chart.js in Jumbotron Header, recommend using in dashboard pages.</div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-xs-12">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title">
                                    <div class="title">折线图</div>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="card primary">
                                    <div class="card-jumbotron no-padding">
                                        <canvas id="jumbotron-line-chart" class="chart no-padding"></canvas>
                                    </div>
                                    <div class="card-body">
                                        <h4>Lorem Ipsum</h4>
                                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer content -->
        <footer class="app-footer">
            <div class="wrapper">
                <ul class="list-inline text-center">
                    <li>Copyright &copy; 2017.Company Darly All rights reserved.</li>
                    <li><a href="http://www.miibeian.gov.cn/" target="_blank">京ICP备11008151号</a></li>
                    <li>京公网安备11010802014853</li>
                </ul>
            </div>
        </footer>
        <!-- /footer content -->
    </div>
</div>

<script src="${resourceUrl}/store/js/vendors/jquery/jquery.min.js"></script>
<script src="${resourceUrl}/store/js/vendors/bootstrap.min.js"></script>
<!-- Javascript -->
<script src="${resourceUrl}/store/js/bootstrapstore.js"></script>
<script src="${resourceUrl}/store/js/storeproduct.js"></script>
<script src="${resourceUrl}/store/js/chartjs.js"></script>
<script src="${resourceUrl}/store/js/Chart.min.js"></script>


<script type="text/javascript">
    //---新增商品链接---
    function productadd(title) {
        $("#classtitle").html(title);
        $("#bg").css({
            display: "block", height: $(document).height()
        });
        var $box = $('.box');
        $box.css({
            //设置弹出层距离左边的位置
            width:$("body").width()-100+ "px",
            left: 80 + "px",
            //设置弹出层距离上面的位置
            top: 80 + "px",
            right:20+"px",
            display: "block"
        });
    }
    <%--function productinsert() {--%>
        <%--var form = new FormData(document.getElementById("former"));--%>
        <%--$.ajax({--%>
            <%--url: "${root}/option/addProduceter" ,//url--%>
            <%--//几个参数需要注意一下--%>
            <%--type: "POST",//方法类型--%>
            <%--dataType: "json",//预期服务器返回的数据类型--%>
            <%--data:form,--%>
            <%--processData:false,--%>
            <%--contentType:false,--%>
            <%--success: function (result) {--%>
                <%--console.log(result);--%>
                <%--console.log(result.resDesc);--%>
                <%--productcloseer();--%>
                <%--//在这里需要刷新Table表格数据--%>
                <%--darly().ontable('${root}');--%>

                <%--$("#sbring").show();--%>
                <%--$("#sbringtext").text(result.resDesc);--%>
                <%--$("#sbring").fadeOut(3000);--%>
                <%--setTimeout(function(){$("#sbring").hide()},3000)--%>
            <%--},--%>
            <%--error : function() {--%>
                <%--console.log("请求异常,检查网络和参数！");--%>
            <%--}--%>
        <%--});--%>
    <%--}--%>
    //关闭浮层
//    function productcloseer() {
//        //点击关闭按钮的时候，遮罩层关闭
//        $("#bg,.box").css("display", "none");
//    }
    //进行判断是否成功
    window.onload = function () {
        if(${addProducet !=null}){
            $("#sbring").show();
            $("#sbringtext").text("${addProducet}");
            $("#sbring").fadeOut(3000);
            setTimeout(function(){$("#sbring").hide()},3000)
        }else {
            $("#sbring").hide();
        }
    }


//    //商品表格操作
//    function  productedit(id) {
//        console.log("productedit"+id)
//    }
//    //移除商品
//    function  productdelete(id) {
//        console.log("productdelete"+id)
//
//    }
</script>


</body>
</html>
