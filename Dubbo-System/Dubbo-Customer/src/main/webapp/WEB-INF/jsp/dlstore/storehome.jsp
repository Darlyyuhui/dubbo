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
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="author" content="Darly" />
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${itmsname}</title>
    <!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
    <link rel="stylesheet" type="text/css" href="${resourceUrl}/store/rs-plugin/css/settings.css" media="screen" />
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

    <script src="${root}/store/js/storehome.js"></script>
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
                                        <li data-transition="random" data-slotamount="7" data-masterspeed="300"  data-saveperformance="off" >
                                            <!-- MAIN IMAGE -->
                                            <img src="${resourceUrl}/store/images/slider-img-1.jpg"  alt="slider"  data-bgposition="center bottom" data-bgfit="cover" data-bgrepeat="no-repeat">

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
                                                 style="z-index: 5; font-size:30px; font-weight:500; color:#888888;   white-space: nowrap;">High Quality VR Glasses </div>

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
                                                 style="z-index: 6; font-size:50px; color:#0088cc; font-weight:800; white-space: nowrap;">3D Daydream View </div>

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
                                                 style="z-index: 7;  font-size:24px; color:#888888; font-weight:500;  white-space: nowrap;">Starting at </div>

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
                                                 style="z-index: 5; font-size:36px; font-weight:800; color:#000;   white-space: nowrap;">$49.99 </div>

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
                                                 style="z-index: 8;"><a href="#." class="btn-round big">Shop Now</a> </div>
                                        </li>

                                        <!-- SLIDE  -->
                                        <li data-transition="random" data-slotamount="7" data-masterspeed="300"  data-saveperformance="off" >
                                            <!-- MAIN IMAGE -->
                                            <img src="${resourceUrl}/store/images/slider-img-2.jpg"  alt="slider"  data-bgposition="center bottom" data-bgfit="cover" data-bgrepeat="no-repeat">

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
                                                 style="z-index: 5; font-size:30px; font-weight:500; color:#888888;   white-space: nowrap;">No restocking fee ($35 savings)</div>

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
                                                 style="z-index: 6; font-size:50px; color:#0088cc; font-weight:800; white-space: nowrap;">M75 Sport Watch </div>

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
                                                 style="z-index: 7;  font-size:24px; color:#888888; font-weight:500;  white-space: nowrap;">Now Only </div>

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
                                                 style="z-index: 5; font-size:36px; font-weight:800; color:#000;   white-space: nowrap;">$320.99 </div>

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
                                                 style="z-index: 8;"><a href="#." class="btn-round big">Shop Now</a> </div>
                                        </li>

                                        <!-- SLIDE  -->
                                        <li data-transition="random" data-slotamount="7" data-masterspeed="300"  data-saveperformance="off" >
                                            <!-- MAIN IMAGE -->
                                            <img src="${resourceUrl}/store/images/slider-img-3.jpg"  alt="slider"  data-bgposition="center bottom" data-bgfit="cover" data-bgrepeat="no-repeat">

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
                                                 style="z-index: 5; font-size:30px; font-weight:500; color:#888888; white-space: nowrap;">Get Free Bluetooth when buy </div>

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
                                                 style="z-index: 6; font-size:50px; color:#0088cc; font-weight:800; white-space: nowrap;">Flat SmartWatch </div>

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
                                                 style="z-index: 7;  font-size:24px; color:#888888; font-weight:500; white-space: nowrap;">Combo Only:</div>

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
                                                 style="z-index: 5; font-size:36px; font-weight:800; color:#000; white-space: nowrap;">$590.00 </div>

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
                                                 style="z-index: 8;"><a href="#." class="btn-round big">Shop Now</a> </div>
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
                                        <span class="price">$259.99</span> </div>
                                </div>
                            </div>

                            <!-- Weekly Slaes  -->
                            <div class="week-sale-bnr">
                                <h4>Weekly <span>Sale!</span></h4>
                                <p>Saving up to 50% off all online
                                    store items this week.</p>
                                <a href="#." class="btn-round">Shop now</a> </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

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
