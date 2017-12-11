<%--
  Created by IntelliJ IDEA.
  User: Darly
  Date: 2017/12/11
  Time: 8:59
  进行模板头部统一样式编辑
--%>
<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

    <!-- Top bar -->
    <div class="top-bar">
        <div class="container">
            <p>欢迎进入${storename}</p>
            <div class="right-sec">
                <ul>
                    <li><a href="#.">登录/注册 </a></li>
                    <li><a href="#.">店铺位置 </a></li>
                    <li><a href="#.">问题解答 </a></li>
                    <li><a href="#.">最新商品 </a></li>
                    <li>
                        <select class="selectpicker">
                            <option>English</option>
                            <option>Chinese</option>
                        </select>
                    </li>
                    <li>
                        <select class="selectpicker">
                            <option>Dollar</option>
                            <option>RMB</option>
                        </select>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Header -->
    <header>
        <div class="container">
            <!-- 商城首页图标，点击刷新首页 -->
            <div class="logo"> <a href="javascript:onstorehome()"><img src="${resourceUrl}/images/login/ic_darly_logo_index.png" alt="" ></a> </div>
            <!-- 搜索框 -->
            <div class="search-cate">
                <select class="selectpicker">
                    <option> 所有商品</option>
                    <option> Home Audio & Theater</option>
                    <option> TV & Video</option>
                    <option> Camera, Photo & Video</option>
                    <option> Cell Phones & Accessories</option>
                    <option> Headphones</option>
                    <option> Video Games</option>
                    <option> Bluetooth & Wireless </option>
                    <option> Gaming Console</option>
                    <option> Computers & Tablets</option>
                    <option> Monitors </option>
                </select>
                <input type="search" placeholder="请输入搜索关键字...">
                <button class="submit" type="submit"><i class="icon-magnifier"></i></button>
            </div>

            <!-- Cart Part -->
            <ul class="nav navbar-right cart-pop">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <span class="itm-cont">3</span>
                        <i class="flaticon-shopping-bag"></i>
                        <strong>购物车</strong>
                        <br>
                    <span>3 item(s) - $500.00</span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <div class="media-left"> <a href="#." class="thumb"> <img src="${resourceUrl}/store/images/item-img-1-1.jpg" class="img-responsive" alt="" > </a> </div>
                            <div class="media-body"> <a href="#." class="tittle">Funda Para Ebook 7" 128GB full HD</a> <span>250 x 1</span> </div>
                        </li>
                        <li>
                            <div class="media-left"> <a href="#." class="thumb"> <img src="${resourceUrl}/store/images/item-img-1-2.jpg" class="img-responsive" alt="" > </a> </div>
                            <div class="media-body"> <a href="#." class="tittle">Funda Para Ebook 7" full HD</a> <span>250 x 1</span> </div>
                        </li>
                        <li class="btn-cart"> <a href="#." class="btn-round">购物车</a> </li>
                    </ul>
                </li>
            </ul>
        </div>

        <!-- Nav -->
        <nav class="navbar ownmenu">
            <div class="container">

                <!-- Categories -->
                <div class="cate-lst"> <a  data-toggle="collapse" class="cate-style" href="#cater"><i class="fa fa-list-ul"></i> 商品列表 </a>
                    <div class="cate-bar-in">
                        <div id="cater" class="collapse">
                            <ul>
                                <li><a href="#."> Home Audio & Theater</a></li>
                                <li><a href="#."> TV & Video</a></li>
                                <li><a href="#."> Camera, Photo & Video</a></li>
                                <li class="sub-menu"><a href="#."> Cell Phones & Accessories</a>
                                    <ul>
                                        <li><a href="#."> TV & Video</a></li>
                                        <li><a href="#."> Camera, Photo & Video</a></li>
                                        <li><a href="#."> Cell Phones & Accessories</a>
                                    </ul>
                                </li>
                                <li><a href="#."> Headphones</a></li>
                                <li><a href="#."> Video Games</a></li>
                                <li class="sub-menu"><a href="#."> Bluetooth & Wireless Speakers</a>
                                    <ul>
                                        <li><a href="#."> TV & Video</a></li>
                                        <li><a href="#."> Camera, Photo & Video</a></li>
                                        <li><a href="#."> Cell Phones & Accessories</a>
                                    </ul>
                                </li>
                                <li class="sub-menu"><a href="#."> Gaming Console</a>
                                    <ul>
                                        <li><a href="#."> TV & Video</a></li>
                                        <li><a href="#."> Camera, Photo & Video</a></li>
                                        <li><a href="#."> Cell Phones & Accessories</a>
                                    </ul>
                                </li>
                                <li><a href="#."> Computers & Tablets</a></li>
                                <li><a href="#."> Monitors</a></li>
                                <li><a href="#."> Home Appliances</a></li>
                                <li><a href="#."> Office Supplies</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <!-- Navbar Header -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav-open-btn" aria-expanded="false"> <span><i class="fa fa-navicon"></i></span> </button>
                </div>
                <!-- NAV -->
                <div class="collapse navbar-collapse" id="nav-open-btn">
                    <ul class="nav">
                        <li><a href="javascript:onstorehome()"> 首页 </a></li>
                        <li><a href="javascript:onstorehome()"> 专区 </a></li>
                        <li><a href="javascript:onstorehome()"> 限时 </a></li>
                        <li><a href="javascript:onstorehome()"> 最新 </a></li>
                        <li><a href="javascript:onstorehome()"> 折扣区 </a></li>
                    </ul>
                </div>

                <!-- NAV RIGHT -->
                <div class="nav-right"> <span class="call-mun"><i class="fa fa-phone"></i> <strong>客服热线:</strong> 400-800-6666</span> </div>
            </div>
        </nav>
    </header>
<script>
    function onstorehome() {
        //跳转到商城首页
        window.location.href = "${root}/index";
    }
</script>
