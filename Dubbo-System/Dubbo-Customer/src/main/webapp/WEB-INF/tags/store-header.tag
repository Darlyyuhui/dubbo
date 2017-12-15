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
            <c:choose>
                <c:when test="${hasUser}">
                        <p>欢迎${userName}进入${storename}</p>
                </c:when>
                <c:otherwise>
                    <p>欢迎打开${storename}</p>
                </c:otherwise>
            </c:choose>
            <div class="right-sec">
                <ul>
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
                    <c:choose>
                        <c:when test="${hasUser}">
                            <li><a href="javascript:storeout()">安全退出 </a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="javascript:darly().storeLogin('${root}')">登录/注册 </a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
    <!-- 退出登陸提示框 -->
<style>
    .wrap-dialog {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        font-size: 16px;
        text-align: center;
        background-color: rgba(0, 0, 0, .4);
        z-index: 999;
    }
    .dialog {
        position: relative;
        margin: 15% auto;
        width: 300px;
        background-color: #FFFFFF;
    }
    .dialog .dialog-header {
        height: 40px;
        padding: 10px;
        background-color: lightskyblue;
    }
    .dialog .dialog-body {
        height: 60px;
        padding: 20px;
    }
    .dialog .dialog-footer {
        padding: 8px;
    }
    .btn {
        width: 70px;
        padding: 2px;
        background-color: lightskyblue;
    }
    .hide {
        display: none;
    }
    .ml50 {
        margin-left: 50px;
    }
</style>
    <div class="wrap-dialog hide">
        <div class="dialog">
            <div class="dialog-header">
                <span class="dialog-title">退出商城</span>
            </div>
            <div class="dialog-body">
                <span class="dialog-message">你确认退出本商城？</span>
            </div>
            <div class="dialog-footer">
                <input type="button" class="btn" id="confirm" value="确认" />
                <input type="button" class="btn ml50" id="cancel" value="取消" />
            </div>
        </div>
    </div>
    <!-- 退出登陸提示框 -->
    <!-- Header -->
    <header>
        <div class="container">
            <!-- 商城首页图标，点击刷新首页 -->
            <div class="logo"> <a href="javascript:darly().storehome('${root}');"><img src="${resourceUrl}/images/login/ic_darly_logo_index.png" alt="" ></a> </div>
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
                        <li><a href="javascript:darly().storehome('${root}');"> 首页 </a></li>
                        <li><a href="javascript:darly().storehome('${root}');"> 专区 </a></li>
                        <li><a href="javascript:darly().storehome('${root}');"> 限时 </a></li>
                        <li><a href="javascript:darly().storehome('${root}');"> 最新 </a></li>
                        <li><a href="javascript:darly().storehome('${root}');"> 折扣区 </a></li>
                    </ul>
                </div>

                <!-- NAV RIGHT -->
                <div class="nav-right"> <span class="call-mun"><i class="fa fa-phone"></i> <strong>客服热线:</strong> 400-800-6666</span> </div>
            </div>
        </nav>
    </header>
<script>
      function storeout(){
            var message = "你确认退出本商城？";
            dialogBox(message,
                function () {
                    darly().logout('${root}');
                },
                function(){
                }
            );
        };
    function dialogBox(message, yesCallback, noCallback){
        if(message){
            $('.dialog-message').html(message);
        }
        // 显示遮罩和对话框
        $('.wrap-dialog').removeClass("hide");
        // 确定按钮
        $('#confirm').click(function(){
            $('.wrap-dialog').addClass("hide");
            yesCallback();
        });
        // 取消按钮
        $('#cancel').click(function(){
            $('.wrap-dialog').addClass("hide");
            noCallback();
        });
    }

</script>