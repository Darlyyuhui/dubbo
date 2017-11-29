<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 引入 背景 -->
<script color="43, 22, 22" opacity='0.6' zIndex="-2" count="100" src="${sourceUrl}/basejs/login/js/canvas.js"></script>
<style type="text/css">
    #console-container {
        float: left;
        border: 1px solid #CCCCCC;
        border-right-color: #999999;
        border-bottom-color: #999999;
        overflow-y: scroll;
        height: 50px;
        width: 100%;
    }
</style>
<div class="container" style="background-color: white">
    <div id="console-container">
        <div id="console"></div>
    </div>
    <div class="row footer-top">
        <div class="col-sm-6">
            <h4>
                <img src="${sourceUrl}/images/login/ic_darly_logo.png" style="width: 140px">
            </h4>
            <p>本网站所列开源项目的中文版文档全部由国内成员翻译整理，并全部遵循 <a href="http://creativecommons.org/licenses/by/3.0/" target="_blank">CC BY 3.0</a>协议发布。</p>
        </div>
        <div class="col-sm-6  col-lg-5 col-lg-offset-1">
            <div class="row about">
                <div class="col-xs-9" style="text-align: center">
                    <h4>关于</h4>
                    <ul class="list-unstyled">
                        <li><a href="/about/">关于我们</a></li>
                        <li><a href="/ad/">广告合作</a></li>
                        <li><a href="/links/">友情链接</a></li>
                        <li><a href="/hr/">招聘</a></li>
                    </ul>
                </div>
                <div class="col-xs-3"  style="text-align: center">
                    <h4>联系方式</h4>
                    <ul class="list-unstyled">
                        <li><a href="mailto:darlyyuhui@hotmail.com">电子邮件</a></li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
    <hr>
    <div class="row footer-bottom">
        <ul class="list-inline text-center">
            <li><a href="http://www.miibeian.gov.cn/" target="_blank">京ICP备11008151号</a></li>
            <li>京公网安备11010802014853</li>
        </ul>
    </div>
</div>