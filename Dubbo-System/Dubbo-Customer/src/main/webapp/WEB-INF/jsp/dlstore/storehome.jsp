<%--
  Created by IntelliJ IDEA.
  User: Darly
  Date: 2017/12/11
  Time: 8:59
  使用模板进行商城页面编辑，并结合Android端进行JS封装调用、。
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <!--標題欄圖標-->
    <link rel="SHORTCUT ICON" href="${resourceUrl}/images/base/logo.ico"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="author" content="Darly"/>
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${itmsname}</title>
    <!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
    <link rel="stylesheet" type="text/css" href="${resourceUrl}/store/rs-plugin/css/settings.css" media="screen"/>
    <!-- StyleSheets -->
    <link rel="stylesheet" href="${resourceUrl}/store/css/ionicons.min.css">
    <link rel="stylesheet" href="${resourceUrl}/store/css/bootstrap.min.css">
    <link rel="stylesheet" href="${resourceUrl}/store/css/font-awesome.min.css">
    <link rel="stylesheet" href="${resourceUrl}/store/css/main.css">
    <link rel="stylesheet" href="${resourceUrl}/store/css/style.css">
    <link rel="stylesheet" href="${resourceUrl}/store/css/responsive.css">
    <!-- Fonts Online -->
    <!-- JavaScripts -->
    <script src="${resourceUrl}/store/js/vendors/modernizr.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="${resourceUrl}/basejs/darly.js"></script>
    <script src="${resourceUrl}/store/js/storehome.js"></script>
    <script>
        function DarlyCallBack() {
            if (!(this instanceof DarlyCallBack)) {
                return new DarlyCallBack();
            }
        }

        DarlyCallBack.prototype = {
            setlatiude: function (jingdu) {
                console.log("setjingdu====" + jingdu);
            },
            setlongitude: function (weidu) {
                console.log("setweidu====" + weidu);
            }
        }
    </script>
</head>
<body>
<!-- Page Wrapper -->
<div id="wrap" class="layout-1">
    <tags:store-header/>

    <!-- Slid Sec -->
    <section class="slid-sec">
        <div class="container">
            <div class="container-fluid">
                <div class="row">

                    <!-- Main Slider  -->
                    <div class="col-md-9 no-padding">

                        <!-- Main Slider Start -->
                        <div class="tp-banner-container">
                            <div class="tp-banner">
                                <ul>

                                    <!-- SLIDE  -->
                                    <li data-transition="random" data-slotamount="7" data-masterspeed="300"
                                        data-saveperformance="off">
                                        <!-- MAIN IMAGE -->
                                        <img src="${resourceUrl}/store/images/slider-img-1.jpg" alt="slider"
                                             data-bgposition="center bottom" data-bgfit="cover"
                                             data-bgrepeat="no-repeat">

                                        <!-- LAYER NR. 1 -->
                                        <div class="tp-caption sfl tp-resizeme"
                                             data-x="left" data-hoffset="60"
                                             data-y="center" data-voffset="-110"
                                             data-speed="800"
                                             data-start="800"
                                             data-easing="Power3.easeInOut"
                                             data-splitin="chars"
                                             data-splitout="none"
                                             data-elementdelay="0.03"
                                             data-endelementdelay="0.4"
                                             data-endspeed="300"
                                             style="z-index: 5; font-size:30px; font-weight:500; color:#888888;   white-space: nowrap;">
                                            High Quality VR Glasses
                                        </div>

                                        <!-- LAYER NR. 2 -->
                                        <div class="tp-caption sfr tp-resizeme"
                                             data-x="left" data-hoffset="60"
                                             data-y="center" data-voffset="-60"
                                             data-speed="800"
                                             data-start="1000"
                                             data-easing="Power3.easeInOut"
                                             data-splitin="chars"
                                             data-splitout="none"
                                             data-elementdelay="0.03"
                                             data-endelementdelay="0.1"
                                             data-endspeed="300"
                                             style="z-index: 6; font-size:50px; color:#0088cc; font-weight:800; white-space: nowrap;">
                                            3D Daydream View
                                        </div>

                                        <!-- LAYER NR. 3 -->
                                        <div class="tp-caption sfl tp-resizeme"
                                             data-x="left" data-hoffset="60"
                                             data-y="center" data-voffset="10"
                                             data-speed="800"
                                             data-start="1200"
                                             data-easing="Power3.easeInOut"
                                             data-splitin="none"
                                             data-splitout="none"
                                             data-elementdelay="0.1"
                                             data-endelementdelay="0.1"
                                             data-endspeed="300"
                                             style="z-index: 7;  font-size:24px; color:#888888; font-weight:500;  white-space: nowrap;">
                                            Starting at
                                        </div>

                                        <!-- LAYER NR. 1 -->
                                        <div class="tp-caption sfr tp-resizeme"
                                             data-x="left" data-hoffset="210"
                                             data-y="center" data-voffset="5"
                                             data-speed="800"
                                             data-start="1300"
                                             data-easing="Power3.easeInOut"
                                             data-splitin="chars"
                                             data-splitout="none"
                                             data-elementdelay="0.03"
                                             data-endelementdelay="0.4"
                                             data-endspeed="300"
                                             style="z-index: 5; font-size:36px; font-weight:800; color:#000;   white-space: nowrap;">
                                            $49.99
                                        </div>

                                        <!-- LAYER NR. 4 -->
                                        <div class="tp-caption lfb tp-resizeme scroll"
                                             data-x="left" data-hoffset="60"
                                             data-y="center" data-voffset="80"
                                             data-speed="800"
                                             data-start="1300"
                                             data-easing="Power3.easeInOut"
                                             data-elementdelay="0.1"
                                             data-endelementdelay="0.1"
                                             data-endspeed="300"
                                             data-scrolloffset="0"
                                             style="z-index: 8;"><a href="#." class="btn-round big">Shop Now</a></div>
                                    </li>

                                    <!-- SLIDE  -->
                                    <li data-transition="random" data-slotamount="7" data-masterspeed="300"
                                        data-saveperformance="off">
                                        <!-- MAIN IMAGE -->
                                        <img src="${resourceUrl}/store/images/slider-img-2.jpg" alt="slider"
                                             data-bgposition="center bottom" data-bgfit="cover"
                                             data-bgrepeat="no-repeat">

                                        <!-- LAYER NR. 1 -->
                                        <div class="tp-caption sfl tp-resizeme"
                                             data-x="left" data-hoffset="60"
                                             data-y="center" data-voffset="-110"
                                             data-speed="800"
                                             data-start="800"
                                             data-easing="Power3.easeInOut"
                                             data-splitin="chars"
                                             data-splitout="none"
                                             data-elementdelay="0.03"
                                             data-endelementdelay="0.4"
                                             data-endspeed="300"
                                             style="z-index: 5; font-size:30px; font-weight:500; color:#888888;   white-space: nowrap;">
                                            No restocking fee ($35 savings)
                                        </div>

                                        <!-- LAYER NR. 2 -->
                                        <div class="tp-caption sfr tp-resizeme"
                                             data-x="left" data-hoffset="60"
                                             data-y="center" data-voffset="-60"
                                             data-speed="800"
                                             data-start="1000"
                                             data-easing="Power3.easeInOut"
                                             data-splitin="chars"
                                             data-splitout="none"
                                             data-elementdelay="0.03"
                                             data-endelementdelay="0.1"
                                             data-endspeed="300"
                                             style="z-index: 6; font-size:50px; color:#0088cc; font-weight:800; white-space: nowrap;">
                                            M75 Sport Watch
                                        </div>

                                        <!-- LAYER NR. 3 -->
                                        <div class="tp-caption sfl tp-resizeme"
                                             data-x="left" data-hoffset="60"
                                             data-y="center" data-voffset="10"
                                             data-speed="800"
                                             data-start="1200"
                                             data-easing="Power3.easeInOut"
                                             data-splitin="none"
                                             data-splitout="none"
                                             data-elementdelay="0.1"
                                             data-endelementdelay="0.1"
                                             data-endspeed="300"
                                             style="z-index: 7;  font-size:24px; color:#888888; font-weight:500;  white-space: nowrap;">
                                            Now Only
                                        </div>

                                        <!-- LAYER NR. 1 -->
                                        <div class="tp-caption sfr tp-resizeme"
                                             data-x="left" data-hoffset="210"
                                             data-y="center" data-voffset="5"
                                             data-speed="800"
                                             data-start="1300"
                                             data-easing="Power3.easeInOut"
                                             data-splitin="chars"
                                             data-splitout="none"
                                             data-elementdelay="0.03"
                                             data-endelementdelay="0.4"
                                             data-endspeed="300"
                                             style="z-index: 5; font-size:36px; font-weight:800; color:#000;   white-space: nowrap;">
                                            $320.99
                                        </div>

                                        <!-- LAYER NR. 4 -->
                                        <div class="tp-caption lfb tp-resizeme scroll"
                                             data-x="left" data-hoffset="60"
                                             data-y="center" data-voffset="80"
                                             data-speed="800"
                                             data-start="1300"
                                             data-easing="Power3.easeInOut"
                                             data-elementdelay="0.1"
                                             data-endelementdelay="0.1"
                                             data-endspeed="300"
                                             data-scrolloffset="0"
                                             style="z-index: 8;"><a href="#." class="btn-round big">Shop Now</a></div>
                                    </li>

                                    <!-- SLIDE  -->
                                    <li data-transition="random" data-slotamount="7" data-masterspeed="300"
                                        data-saveperformance="off">
                                        <!-- MAIN IMAGE -->
                                        <img src="${resourceUrl}/store/images/slider-img-3.jpg" alt="slider"
                                             data-bgposition="center bottom" data-bgfit="cover"
                                             data-bgrepeat="no-repeat">

                                        <!-- LAYER NR. 1 -->
                                        <div class="tp-caption sfl tp-resizeme"
                                             data-x="left" data-hoffset="60"
                                             data-y="center" data-voffset="-110"
                                             data-speed="800"
                                             data-start="800"
                                             data-easing="Power3.easeInOut"
                                             data-splitin="chars"
                                             data-splitout="none"
                                             data-elementdelay="0.03"
                                             data-endelementdelay="0.4"
                                             data-endspeed="300"
                                             style="z-index: 5; font-size:30px; font-weight:500; color:#888888; white-space: nowrap;">
                                            Get Free Bluetooth when buy
                                        </div>

                                        <!-- LAYER NR. 2 -->
                                        <div class="tp-caption sfr tp-resizeme"
                                             data-x="left" data-hoffset="60"
                                             data-y="center" data-voffset="-60"
                                             data-speed="800"
                                             data-start="1000"
                                             data-easing="Power3.easeInOut"
                                             data-splitin="chars"
                                             data-splitout="none"
                                             data-elementdelay="0.03"
                                             data-endelementdelay="0.1"
                                             data-endspeed="300"
                                             style="z-index: 6; font-size:50px; color:#0088cc; font-weight:800; white-space: nowrap;">
                                            Flat SmartWatch
                                        </div>

                                        <!-- LAYER NR. 3 -->
                                        <div class="tp-caption sfl tp-resizeme"
                                             data-x="left" data-hoffset="60"
                                             data-y="center" data-voffset="0"
                                             data-speed="800"
                                             data-start="1200"
                                             data-easing="Power3.easeInOut"
                                             data-splitin="none"
                                             data-splitout="none"
                                             data-elementdelay="0.1"
                                             data-endelementdelay="0.1"
                                             data-endspeed="300"
                                             style="z-index: 7;  font-size:24px; color:#888888; font-weight:500; white-space: nowrap;">
                                            Combo Only:
                                        </div>

                                        <!-- LAYER NR. 1 -->
                                        <div class="tp-caption sfr tp-resizeme"
                                             data-x="left" data-hoffset="240"
                                             data-y="center" data-voffset=" -5"
                                             data-speed="800"
                                             data-start="1300"
                                             data-easing="Power3.easeInOut"
                                             data-splitin="chars"
                                             data-splitout="none"
                                             data-elementdelay="0.03"
                                             data-endelementdelay="0.4"
                                             data-endspeed="300"
                                             style="z-index: 5; font-size:36px; font-weight:800; color:#000; white-space: nowrap;">
                                            $590.00
                                        </div>

                                        <!-- LAYER NR. 4 -->
                                        <div class="tp-caption lfb tp-resizeme scroll"
                                             data-x="left" data-hoffset="60"
                                             data-y="center" data-voffset="80"
                                             data-speed="800"
                                             data-start="1300"
                                             data-easing="Power3.easeInOut"
                                             data-elementdelay="0.1"
                                             data-endelementdelay="0.1"
                                             data-endspeed="300"
                                             data-scrolloffset="0"
                                             style="z-index: 8;"><a href="#." class="btn-round big">Shop Now</a></div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <!-- Main Slider  -->
                    <div class="col-md-3 no-padding">

                        <!-- New line required  -->
                        <div class="product">
                            <div class="like-bnr">
                                <div class="position-center-center">
                                    <h5>New line required</h5>
                                    <h4>Smartphone s7</h4>
                                    <span class="price">$259.99</span></div>
                            </div>
                        </div>

                        <!-- Weekly Slaes  -->
                        <div class="week-sale-bnr">
                            <h4>Weekly <span>Sale!</span></h4>
                            <p>Saving up to 50% off all online
                                store items this week.</p>
                            <a href="#." class="btn-round">Shop now</a></div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">


        <!-- tab Section -->
        <section class="featur-tabs padding-top-60 padding-bottom-60">
            <div class="container">

                <!-- Nav tabs -->
                <ul class="nav nav-tabs nav-pills margin-bottom-40" role="tablist">
                    <li role="presentation" class="active"><a href="#featur" aria-controls="featur" role="tab"
                                                              data-toggle="tab">Featured</a></li>
                    <li role="presentation"><a href="#special" aria-controls="special" role="tab" data-toggle="tab">Special</a>
                    </li>
                    <li role="presentation"><a href="#on-sal" aria-controls="on-sal" role="tab"
                                               data-toggle="tab">Onsale</a></li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <!-- Featured -->
                    <div role="tabpanel" class="tab-pane active fade in" id="featur">
                        <!-- Items Slider -->
                        <div class="item-slide-5 with-nav">
                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-1.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Latop</span> <a href="#." class="tittle">Laptop Alienware 15 i7
                                        Perfect For Playing Game</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>
                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-2.jpg"
                                              alt=""> <span class="sale-tag">-25%</span>

                                    <!-- Content -->
                                    <span class="tag">Tablets</span> <a href="#." class="tittle">Mp3 Sumergible
                                        Deportivo Slim Con 8GB</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00 <span>$200.00</span></div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-3.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Reloj Inteligente
                                        Smart Watch M26 Touch Bluetooh </a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-4.jpg"
                                              alt=""> <span class="new-tag">New</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-5.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-6.jpg"
                                              alt=""> <span class="sale-tag">-25%</span>

                                    <!-- Content -->
                                    <span class="tag">Tablets</span> <a href="#." class="tittle">Mp3 Sumergible
                                        Deportivo Slim Con 8GB</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00 <span>$200.00</span></div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-7.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Reloj Inteligente
                                        Smart Watch M26 Touch Bluetooh </a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-8.jpg"
                                              alt=""> <span class="new-tag">New</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>
                        </div>
                    </div>

                    <!-- Special -->
                    <div role="tabpanel" class="tab-pane fade" id="special">
                        <!-- Items Slider -->
                        <div class="item-col-5">

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-11.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Latop</span> <a href="#." class="tittle">Laptop Alienware 15 i7
                                        Perfect For Playing Game</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-9.jpg"
                                              alt=""> <span class="sale-tag">-25%</span>

                                    <!-- Content -->
                                    <span class="tag">Tablets</span> <a href="#." class="tittle">Mp3 Sumergible
                                        Deportivo Slim Con 8GB</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00 <span>$200.00</span></div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-8.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Reloj Inteligente
                                        Smart Watch M26 Touch Bluetooh </a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-7.jpg"
                                              alt=""> <span class="new-tag">New</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-6.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>
                        </div>
                    </div>

                    <!-- on sale -->
                    <div role="tabpanel" class="tab-pane fade" id="on-sal">
                        <!-- Items Slider -->
                        <div class="item-col-5">

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-3.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Latop</span> <a href="#." class="tittle">Laptop Alienware 15 i7
                                        Perfect For Playing Game</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-1.jpg"
                                              alt=""> <span class="sale-tag">-25%</span>

                                    <!-- Content -->
                                    <span class="tag">Tablets</span> <a href="#." class="tittle">Mp3 Sumergible
                                        Deportivo Slim Con 8GB</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00 <span>$200.00</span></div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-2.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Reloj Inteligente
                                        Smart Watch M26 Touch Bluetooh </a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-5.jpg"
                                              alt=""> <span class="new-tag">New</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-4.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Top Selling Week -->
        <c:forEach items="${allSale}" var="item">
            <c:choose>
                <c:when test="${item.key.storeType == 'HeaderTab'}">
                    <section class="light-gry-bg padding-top-5 padding-bottom-5">
                        <div class="container">
                            <!-- heading -->
                            <div class="heading">
                                <h2>${item.key.storeDesc}</h2>
                                <hr>
                            </div>
                            <!-- Items -->
                            <div class="item-col-5">
                                <c:forEach items="${item.value}" var="product">
                                    <!-- Product -->
                                    <div class="product">
                                        <article><img class="img-responsive" src="${resourceUrl}${product.productImage}"
                                                      alt=""> <span class="sale-tag">-25%</span>
                                            <!-- Content -->
                                            <span class="tag">Tablets</span> <a href="#."
                                                                                class="tittle">${product.productName}</a>
                                            <!-- Reviews -->
                                            <p class="rev">
                                                    <%--<c:forEach items="${product.productStars}" >--%>
                                                    <%--<i class="fa fa-star"></i>--%>
                                                    <%--</c:forEach>--%>
                                                <i class="fa fa-star"></i>
                                                <span class="margin-left-10">${product.productStars} Review(s)</span>
                                            </p>
                                            <div class="price">${product.productOrprice}
                                                <span>${product.productPrice}</span></div>
                                            <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a>
                                        </article>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </section>
                </c:when>
                <c:when test="${item.key.storeType == 'FooterTab'}">
                    <section class="light-gry-bg padding-top-5 padding-bottom-5">
                        <div class="container">
                            <!-- heading -->
                            <div class="heading">
                                <h2>${item.key.storeDesc}</h2>
                                <hr>
                            </div>
                            <!-- Items -->
                            <div class="item-col-5">
                                <c:forEach items="${item.value}" var="product">
                                    <!-- Product -->
                                    <div class="product">
                                        <article><img class="img-responsive" src="${resourceUrl}${product.productImage}"
                                                      alt=""> <span class="sale-tag">-25%</span>
                                            <!-- Content -->
                                            <span class="tag">Tablets</span> <a href="#."
                                                                                class="tittle">${product.productName}</a>
                                            <!-- Reviews -->
                                            <p class="rev">
                                                    <%--<c:forEach items="${product.productStars}" >--%>
                                                    <%--<i class="fa fa-star"></i>--%>
                                                    <%--</c:forEach>--%>
                                                <i class="fa fa-star"></i>
                                                <span class="margin-left-10">${product.productStars} Review(s)</span>
                                            </p>
                                            <div class="price">${product.productOrprice}
                                                <span>${product.productPrice}</span></div>
                                            <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a>
                                        </article>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </section>
                </c:when>
                <c:otherwise>
                    <section class="light-gry-bg padding-top-5 padding-bottom-5">
                        <div class="container">
                            <!-- heading -->
                            <div class="heading">
                                <h2>${item.key.storeDesc}</h2>
                                <hr>
                            </div>
                            <!-- Items -->
                            <div class="item-col-5">
                                <c:forEach items="${item.value}" var="product">
                                    <!-- Product -->
                                    <div class="product">
                                        <article><img class="img-responsive" src="${resourceUrl}${product.productImage}"
                                                      alt=""> <span class="sale-tag">-25%</span>
                                            <!-- Content -->
                                            <span class="tag">Tablets</span> <a href="#."
                                                                                class="tittle">${product.productName}</a>
                                            <!-- Reviews -->
                                            <p class="rev">
                                                <c:forEach var="i" begin="1" end="${product.productStars}"
                                                           varStatus="status">
                                                    <i class="fa fa-star"></i>
                                                </c:forEach>
                                                <span class="margin-left-10">${product.productStars} Review(s)</span>
                                            </p>
                                            <div class="price">${product.productOrprice}
                                                <span>${product.productPrice}</span></div>
                                            <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a>
                                        </article>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </section>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <!-- Main Tabs Sec -->
        <section class="main-tabs-sec padding-top-60 padding-bottom-0">
            <div class="container">
                <ul class="nav margin-bottom-40" role="tablist">
                    <li role="presentation" class="active"><a href="#tv-au" aria-controls="featur" role="tab"
                                                              data-toggle="tab"> <i class="flaticon-computer"></i> TV &
                        Audios <span>236 item(s)</span></a></li>
                    <li role="presentation"><a href="#smart" aria-controls="special" role="tab" data-toggle="tab"><i
                            class="flaticon-smartphone"></i>Smartphones <span>150 item(s)</span></a></li>
                    <li role="presentation"><a href="#deks-lap" aria-controls="on-sal" role="tab" data-toggle="tab"><i
                            class="flaticon-laptop"></i>Desk & Laptop <span>268 item(s)</span></a></li>
                    <li role="presentation"><a href="#game-com" aria-controls="special" role="tab" data-toggle="tab"><i
                            class="flaticon-gamepad-1"></i>Game Console <span>79 item(s)</span></a></li>
                    <li role="presentation"><a href="#watches" aria-controls="on-sal" role="tab" data-toggle="tab"><i
                            class="flaticon-computer-1"></i>Watches <span>105 item(s)</span></a></li>
                    <li role="presentation"><a href="#access" aria-controls="on-sal" role="tab" data-toggle="tab"><i
                            class="flaticon-keyboard"></i>Accessories <span>816 item(s)</span></a></li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <!-- TV & Audios -->
                    <div role="tabpanel" class="tab-pane active fade in" id="tv-au">

                        <!-- Items -->
                        <div class="item-slide-5 with-bullet no-nav">
                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-1.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Latop</span> <a href="#." class="tittle">Laptop Alienware 15 i7
                                        Perfect For Playing Game</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>
                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-2.jpg"
                                              alt=""> <span class="sale-tag">-25%</span>

                                    <!-- Content -->
                                    <span class="tag">Tablets</span> <a href="#." class="tittle">Mp3 Sumergible
                                        Deportivo Slim Con 8GB</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00 <span>$200.00</span></div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-3.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Reloj Inteligente
                                        Smart Watch M26 Touch Bluetooh </a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-4.jpg"
                                              alt=""> <span class="new-tag">New</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-5.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-6.jpg"
                                              alt=""> <span class="sale-tag">-25%</span>

                                    <!-- Content -->
                                    <span class="tag">Tablets</span> <a href="#." class="tittle">Mp3 Sumergible
                                        Deportivo Slim Con 8GB</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00 <span>$200.00</span></div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-7.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Reloj Inteligente
                                        Smart Watch M26 Touch Bluetooh </a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-8.jpg"
                                              alt=""> <span class="new-tag">New</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-9.jpg"
                                              alt=""> <span class="sale-tag">-25%</span>

                                    <!-- Content -->
                                    <span class="tag">Tablets</span> <a href="#." class="tittle">Mp3 Sumergible
                                        Deportivo Slim Con 8GB</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00 <span>$200.00</span></div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-10.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Reloj Inteligente
                                        Smart Watch M26 Touch Bluetooh </a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-11.jpg"
                                              alt=""> <span class="new-tag">New</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>
                        </div>
                    </div>

                    <!-- Smartphones -->
                    <div role="tabpanel" class="tab-pane fade" id="smart">
                        <!-- Items -->
                        <div class="item-col-5">

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-11.jpg"
                                              alt=""> <span class="sale-tag">-25%</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-8.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-5.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Reloj Inteligente
                                        Smart Watch M26 Touch Bluetooh </a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-17.jpg"
                                              alt=""> <span class="new-tag">New</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-15.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>
                        </div>
                    </div>
                    <!-- Desk & Laptop -->
                    <div role="tabpanel" class="tab-pane fade" id="deks-lap">

                        <!-- Items -->
                        <div class="item-col-5">

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-2.jpg"
                                              alt=""> <span class="sale-tag">-25%</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-3.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-4.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Reloj Inteligente
                                        Smart Watch M26 Touch Bluetooh </a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-13.jpg"
                                              alt=""> <span class="new-tag">New</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-15.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>
                        </div>
                    </div>
                    <!-- Game Console -->
                    <div role="tabpanel" class="tab-pane fade" id="game-com">

                        <!-- Items -->
                        <div class="item-col-5">

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-9.jpg"
                                              alt=""> <span class="sale-tag">-25%</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-1.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-5.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Reloj Inteligente
                                        Smart Watch M26 Touch Bluetooh </a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-3.jpg"
                                              alt=""> <span class="new-tag">New</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-2.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>
                        </div>
                    </div>
                    <!-- Watches -->
                    <div role="tabpanel" class="tab-pane fade" id="watches">

                        <!-- Items -->
                        <div class="item-col-5">

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-8.jpg"
                                              alt=""> <span class="sale-tag">-25%</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-9.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-17.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Reloj Inteligente
                                        Smart Watch M26 Touch Bluetooh </a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-16.jpg"
                                              alt=""> <span class="new-tag">New</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-12.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>
                        </div>
                    </div>
                    <!-- Accessories -->
                    <div role="tabpanel" class="tab-pane fade" id="access">

                        <!-- Items -->
                        <div class="item-col-5">

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-11.jpg"
                                              alt=""> <span class="sale-tag">-25%</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-12.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-16.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Reloj Inteligente
                                        Smart Watch M26 Touch Bluetooh </a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span class="margin-left-10">5 Review(s)</span>
                                    </p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-15.jpg"
                                              alt=""> <span class="new-tag">New</span>

                                    <!-- Content -->
                                    <span class="tag">Accessories</span> <a href="#." class="tittle">Teclado Inalambrico
                                        Bluetooth Con Air Mouse</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>

                            <!-- Product -->
                            <div class="product">
                                <article><img class="img-responsive" src="${resourceUrl}/store/images/item-img-1-14.jpg"
                                              alt="">
                                    <!-- Content -->
                                    <span class="tag">Appliances</span> <a href="#." class="tittle">Funda Para Ebook 7"
                                        128GB full HD</a>
                                    <!-- Reviews -->
                                    <p class="rev"><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                            class="fa fa-star"></i><i class="fa fa-star"></i> <i class="fa fa-star"></i>
                                        <span class="margin-left-10">5 Review(s)</span></p>
                                    <div class="price">$350.00</div>
                                    <a href="#." class="cart-btn"><i class="icon-basket-loaded"></i></a></article>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <c:choose>
            <c:when test="${storeblog !=null}">
                <section class="padding-top-60 padding-bottom-60">
                    <div class="container">

                        <!-- heading -->
                        <div class="heading">
                            <h2>客户展示</h2>
                            <hr>
                        </div>
                        <div id="blog-slide" class="with-nav">
                            <c:forEach items="${storeblog}" var="item">
                                <div class="blog-post">
                                    <article>
                                        <img class="img-responsive" src="${resourceUrl}${item.blog_image}" alt="">
                                        <span><i class="fa fa-bookmark-o"></i> ${item.blog_creattime}</span>
                                        <span><i class="fa fa-comment-o"></i> 86 Comments</span> <a href="#."
                                                                                                    class="tittle">${item.blog_title} </a>
                                        <p>${item.blog_article}</p>
                                        <a href="#.">Readmore</a></article>
                                </div>
                            </c:forEach>
                            <!-- Blog Post -->
                        </div>
                    </div>
                </section>
            </c:when>
        </c:choose>

        <!-- Shipping Info -->
        <section class="shipping-info">
            <div class="container">
                <ul>

                    <!-- Free Shipping -->
                    <li>
                        <div class="media-left"><i class="flaticon-delivery-truck-1"></i></div>
                        <div class="media-body">
                            <h5>免费送货</h5>
                            <span>购物满$99免费送货上门</span></div>
                    </li>
                    <!-- Money Return -->
                    <li>
                        <div class="media-left"><i class="flaticon-arrows"></i></div>
                        <div class="media-body">
                            <h5>上门退货</h5>
                            <span>30天内商品问题无条件退货</span></div>
                    </li>
                    <!-- Support 24/7 -->
                    <li>
                        <div class="media-left"><i class="flaticon-operator"></i></div>
                        <div class="media-body">
                            <h5>服务支持24/7</h5>
                            <span>服务热线: (+100) 123 456 7890</span></div>
                    </li>
                    <!-- Safe Payment -->
                    <li>
                        <div class="media-left"><i class="flaticon-business"></i></div>
                        <div class="media-body">
                            <h5>放心购物</h5>
                            <span>支持在线交易</span></div>
                    </li>
                </ul>
            </div>
        </section>
    </div>
    <!-- End Content -->
    <tags:store-footer/>
</div>

<!-- JavaScripts -->
<script src="${resourceUrl}/store/js/vendors/jquery/jquery.min.js"></script>
<script src="${resourceUrl}/store/js/vendors/wow.min.js"></script>
<script src="${resourceUrl}/store/js/vendors/bootstrap.min.js"></script>
<script src="${resourceUrl}/store/js/vendors/own-menu.js"></script>
<script src="${resourceUrl}/store/js/vendors/jquery.sticky.js"></script>
<script src="${resourceUrl}/store/js/vendors/owl.carousel.min.js"></script>
<!-- SLIDER REVOLUTION 4.x SCRIPTS  -->
<script type="text/javascript" src="${resourceUrl}/store/rs-plugin/js/jquery.tp.t.min.js"></script>
<script type="text/javascript" src="${resourceUrl}/store/rs-plugin/js/jquery.tp.min.js"></script>
<script src="${resourceUrl}/store/js/main.js"></script>
</body>
</html>
