<%--
  Created by IntelliJ IDEA.
  User: Darly
  Date: 2017/11/15
  Time: 9:06
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
    <link rel="SHORTCUT ICON" href="${resourceUrl}/images/base/logo.ico"/>
    <meta charset="utf-8">
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <%--<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->--%>
    <%--<title>${itmsname}</title>--%>
    <%--<!-- 引入 Bootstrap -->--%>
    <%--<link href="${resourceUrl}/basejs/bootstrap/ace/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link href="${resourceUrl}/basejs/bootstrap/ace/css/site.min.css" rel="stylesheet">--%>
    <%--<!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->--%>
    <%--<!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>--%>
    <%--<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>--%>
    <%--<![endif]-->--%>

    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- CSS
        ================================================== -->
    <!-- Bootstrap 3-->
    <link href="${resourceUrl}/landy/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic|Roboto+Condensed:300italic,400italic,700italic,400,300,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Condensed:300italic,400italic,700italic,400,300,700' rel='stylesheet' type='text/css'>
    <!-- Template Styles -->
    <link href="${resourceUrl}/landy/css/style.css" rel="stylesheet" media="screen">

</head>
<body>
    <!-- NAVBAR
             ================================================== -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <!--Replace text with your app name or logo image-->
                <a class="navbar-brand" href="#">Landy</a>

            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li><a onclick="$('header').animatescroll({padding:71});">Start</a></li>
                    <li><a onclick="$('.detail').animatescroll({padding:71});">Screens</a></li>
                    <li><a onclick="$('.features').animatescroll({padding:71});">Features</a></li>
                    <li><a onclick="$('.social').animatescroll({padding:71});">Social	</a></li>
                </ul>
            </div>
        </div>
    </nav>


    <!-- HEADER
    ================================================== -->
    <header>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1>Hello World!</h1>
                    <p class="lead">This is an Awesome App Landing Page</p>

                    <div class="carousel-iphone">
                        <div id="carousel-example-generic" class="carousel slide">

                            <!-- Indicators -->
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>

                            <!-- Wrapper for slides -->
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="${resourceUrl}/landy/img/screenshots/app-1.png" alt="App Screen 1">
                                </div>
                                <div class="item">
                                    <img src="${resourceUrl}/landy/img/screenshots/app-2.png" alt="App Screen 2">
                                </div>
                                <div class="item">
                                    <img src="${resourceUrl}/landy/img/screenshots/app-3.png" alt="App Screen 3">
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>


    <!-- PURCHASE
        ================================================== -->
    <section class="purchase">
        <div class="container">
            <div class="row">
                <div class="col-md-offset-2 col-md-8">
                    <h1>Everything's easily customizable.</h1>
                    <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit</p>
                    <button type="button" class="app-store"></button>
                </div>
            </div>
        </div>
    </section>


    <!-- PAYOFF
        ================================================== -->
    <section class="payoff">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna.</h1>
                </div>
            </div>
        </div>
    </section>


    <!-- DETAILS
        ================================================== -->
    <section class="detail">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div id="carousel-example-generic-2" class="carousel slide">

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <div class="row">
                                    <div class="col-sm-12 col-md-offset-1 col-md-6">
                                        <h1>Lorem ipsum dolor sit amet, consectetur adipisicing elit</h1>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna.</p>
                                    </div>
                                    <div class="col-sm-12 col-md-5">
                                        <div class="app-screenshot">
                                            <img src="${resourceUrl}/landy/img/screenshots/app-1.png" class="img-responsive" alt="App Screen 1">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="row">
                                    <div class="col-sm-12 col-md-offset-1 col-md-6">
                                        <h1>Sed do eiusmod tempor incididunt ut labore et dolore magna.</h1>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna.</p>
                                    </div>
                                    <div class="col-sm-12 col-md-5">
                                        <div class="app-screenshot">
                                            <img src="${resourceUrl}/landy/img/screenshots/app-2.png" class="img-responsive" alt="App Screen 2">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="row">
                                    <div class="col-sm-12 col-md-offset-1 col-md-6">
                                        <h1>Lorem ipsum dolor sit amet, consectetur adipisicing elit</h1>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna.</p>
                                    </div>
                                    <div class="col-sm-12 col-md-5">
                                        <div class="app-screenshot">
                                            <img src="${resourceUrl}/landy/img/screenshots/app-3.png" class="img-responsive" alt="App Screen 3">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic-2" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic-2" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic-2" data-slide-to="2"></li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <!-- FEATURES
        ================================================== -->
    <section class="features">
        <div class="container">
            <div class="row">

                <div class="col-md-4">
                    <div class="circle"><i class="icon-bookmark"></i></div>
                    <h2>Quick &amp; Easy Setup</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna.</p>
                </div>

                <div class="col-md-4">
                    <div class="circle"><i class="icon-keypad"></i></div>
                    <h2>Parallax Scrolling</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna.</p>
                </div>

                <div class="col-md-4">
                    <div class="circle"><i class="icon-like"></i></div>
                    <h2>Responsive Design</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna.</p>
                </div>

            </div>
        </div>
    </section>


    <!-- SOCIAL
        ================================================== -->
    <section class="social">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2>Connect with us</h2>
                    <a class="icon-facebook"></a>
                    <a class="icon-twitter"></a>
                    <a class="icon-google"></a>
                    <a class="icon-instagram"></a>
                    <a class="icon-pinterest"></a>
                </div>
            </div>
        </div>
    </section>


    <!-- GET IT
        ================================================== -->
    <section class="get-it">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1>Avaialable now on the App Store</h1>
                    <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit</p>
                    <button type="button" class="app-store"></button>
                </div>
                <div class="col-md-12">
                    <hr />
                    <ul>
                        <li><a href="#link-here">Contact</a></li>
                        <li><a href="#link-here">Twitter</a></li>
                        <li><a href="#link-here">Press</a></li>
                        <li><a href="#link-here">Support</a></li>
                        <li><a href="#link-here">Developers</a></li>
                        <li><a href="#link-here">Privacy</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </section>

    <%--<hr>--%>
    <%--<tags:footer/>--%>
    <%--<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->--%>
    <%--<script src="${resourceUrl}/basejs/bootstrap/ace/js/jquery.js"></script>--%>
    <%--<!-- 包括所有已编译的插件 -->--%>
    <%--<script src="${resourceUrl}/basejs/bootstrap/ace/js/bootstrap.min.js"></script>--%>

    <!-- JAVASCRIPT
            ================================================== -->
    <script src="${resourceUrl}/landy/js/jquery.js"></script>
    <script src="${resourceUrl}/landy/js/bootstrap.min.js"></script>
    <script src="${resourceUrl}/landy/js/animatescroll.js"></script>
    <script src="${resourceUrl}/landy/js/scripts.js"></script>
    <script src="${resourceUrl}/landy/js/retina.min.js"></script>
</body>
</html>