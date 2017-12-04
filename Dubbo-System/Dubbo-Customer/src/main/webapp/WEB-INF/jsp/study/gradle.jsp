<%--
  Created by IntelliJ IDEA.
  User: Darly
  Date: 2017/11/24
  Time: 15:27
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${itmsname}</title>
    <!-- 引入 Bootstrap -->
    <link href="${resourceUrl}/basejs/bootstrap/ace/css/bootstrap.min.css" rel="stylesheet">
    <link href="${resourceUrl}/basejs/bootstrap/ace/css/site.min.css" rel="stylesheet">
    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<tags:header/>
<div class="container tag-body">
    <h3>Android端使用Gradle打包Library并上传到私服
        <small>此功能实现自主打包，方便其他用户调用</small>
    </h3>
    <p class="text-left">工具：Android Studio、Nexus私服</p>
    <p class="text-left">主要实现aar包上传，和使用的效果</p>
    <div id="article_content" class="article_content tracking-ad" data-mod="popu_307" data-dsm="post">
        <p class="text-left">第一步：打开Android Studio并新建空白项目并上传</p>
        <div class="markdown_views">
            <p>打开项目外层空间的build.gradle输入需要上传的Nexus私服地址
<pre>
allprojects {
    repositories {
        jcenter()
        maven {
            url "http://193.169.100.100:8081/nexus/content/repositories/thirdparty/"
        }
    }
}
</pre>
            </p>
            <p>打开项目外层空间的gradle.properties输入需要上传的Nexus私服地址和登录信息
<pre>
#//正式包仓库地址
repositoryUrl=http://193.169.100.100:8081/nexus/content/repositories/thirdparty/
repositoryUserName=admin
repositoryPassword=admin123
</pre>
            </p>
            <p>建立Library项目，在Library项目的build.gradle中添加
<pre>
apply from:'maven-dview-aar.gradle'
</pre>
            </p>
            <p>在Library项目中建立maven-dview-aar.gradle
<pre>
apply plugin: 'maven'
// 2.maven-信息
ext {// ext is a gradle closure allowing the declaration of global properties
    ARTIFACT_ID = 'dview'
    GROUP_ID = 'com.darly.dview'
}
// 3.maven-输出路径
uploadArchives{
    repositories.mavenDeployer{
        println repositoryUrl
        repository(url:repositoryUrl){
            authentication(userName:repositoryUserName,password:repositoryPassword)
        }
            pom.project{
            groupId project.GROUP_ID
            artifactId project.ARTIFACT_ID
            version android.defaultConfig.versionName
        }
    }
}
//以下代码会生成jar包源文件，如果是不开源码，请不要输入这段
//aar包内包含注释
task sourcesJar(type: Jar) {
    from android.sourceSets.main.java.srcDirs
    classifier = 'sources'
}
task javadoc(type: Javadoc) {
    failOnError = false
    options.encoding ="utf-8"
    source = android.sourceSets.main.java.srcDirs
    ext.androidJar = "${android.sdkDirectory}/platforms/${android.compileSdkVersion}/android.jar"
    classpath += files(ext.androidJar)
}
task javadocJar(type: Jar, dependsOn: javadoc) {
    classifier = 'javadoc'
    from javadoc.destinationDir
}
artifacts {
    archives javadocJar
    archives sourcesJar
}
</pre>
            </p>
            <p>方法一：点击右侧Gradle命令列表，找到Library名称点击Tasks——>upload——>uploadArchives，编辑无错，则发布成功。
            </p>
            <p>方法二：打开Android Studio中的Terminal终端页面，直接输入gradlew uploadArchives，编辑无误，则整体Library全部发布成功
            </p>
        </div>
        <p class="text-left">第二步：打开Android Studio并新建项目使用aar包</p>
        <div class="markdown_views">
            <p>打开项目外层空间的build.gradle输入需要上传的Nexus私服地址
<pre>
allprojects {
    repositories {
        jcenter()
        maven {
            url "http://193.169.100.100:8081/nexus/content/repositories/thirdparty/"
        }
    }
}
</pre>
            </p>
            <p>打开项目APP的build.gradle 在dependencies中进行引用即可
<pre>
compile 'com.darly.dview:dview:1.0.0'
compile 'com.darly.common:common:1.0.0'
</pre>
            </p>
        </div>
    </div>

    <h3>Android使用说明
        <small>内容和程序模块</small>
    </h3>
    <p class="text-left">第一部分：dview</p>
    <p class="text-left">当导入compile 'com.darly.dview:dview:1.0.0'后并刷新出包内容时，就可以进行初始化操作，并进行调用实现了</p>
    <p class="text-left">1.初始化</p>
    <p class="text-left">在构建的项目的Application中进行初始化操作<code>DView.init().notifyInit(AppConst.isDebug(),this);</code>第一个参数，是否启动虚拟机摄像头，进行拍照
        在现实应用手机中，摄像头可以进行对焦操作，但虚拟机无法对焦，true的情况为测试专用，打包传值为false，第二个参数传递整个项目的上下文引用。
    </p>
    <p class="text-left">1.包说明 <a href="${resourceUrl}/apidoc/dviewapi/">点击浏览ApiDoc</a></p>
    <pre>
com.darly.dview.DView 自定义控件集合初始化，调用进行初始化操作。
        com.darly.dview.framework 框架基础 使用情况，在Activity或者Fragment中进行初始化操作 InitBinder.InitAll(this);InitBinder.InitAll(this, rootView);
com.darly.dview.framework.BaseEvent 映射主体类，@interface 类型，进行注解回调
com.darly.dview.framework.ClickBinder 点击事件注解类
com.darly.dview.framework.ClickInvocationHandler 拦截点击事件效果
com.darly.dview.framework.ContentBinder  Activity绑定Layout注解类
com.darly.dview.framework.InitBinder 针对注解映射初始化的类，使用前必须先在Activity中进行初始化
com.darly.dview.framework.ViewsBinder 我们首先要声明一个@interface，也就是注解类：注解控件
com.darly.dview.framework.ViewsFinder 映射查询类，直接针对findviewbyid进行拦截
        com.darly.dview.widget 自定义控件组合
com.darly.dview.widget.camera 相机相册，获取图片自定义功能模块，包括水印效果
com.darly.dview.widget.coupon 凹凸效果的购物券类控件
com.darly.dview.widget.header 自定义顶部标题栏控件
com.darly.dview.widget.image 自定义平滑展开全屏效果的图片控件
com.darly.dview.widget.listview 铺满需求屏幕高度的自定义控件
com.darly.dview.widget.loading  自定义加载过程等待动画的控件
com.darly.dview.widget.xlistView 自定义上拉加载，下拉刷新的控件
    </pre>
    <p class="text-left">第二部分：common</p>
    <p class="text-left">当导入compile 'com.darly.common:common:1.0.0'后并刷新出包内容时，就可以进行初始化操作，并进行调用实现了</p>
    <p class="text-left">1.初始化</p>
    <p class="text-left">在构建的项目的Application中进行初始化操作
        <code>Common.init().init(this,"object_share");</code>第一个参数整个项目的上下文引用，第二个参数为缓存文件名称。
        <code>Common.init().initDlog(AppConst.isDebug(), "appName");</code>初始化日志第一个参数是否测试模式，第二个参数为输出标题。
        <code>Common.init().initRetrofit(getVersionCode(),"http://10.10.15.110:8082/dubbo/",  new RetrofitCfg());</code>初始化网络请求第一个参数项目版本号，第二个参数为目标接口地址，第三个参数为头文件参数实现类。
    </p>

    <p class="text-left">1.包说明 <a href="${resourceUrl}/apidoc/commonapi/">点击浏览ApiDoc</a></p>
    <pre>
      com.darly.common.Common 工具集合类调用初始化方法。
com.darly.common.CRC16Validator 用于CRC校验码计算
com.darly.common.DeEncryptUtil 对用户输入信息进行解码编码操作类
com.darly.common.DLog 日志功能类
com.darly.common.EncodeTools url签名工具
com.darly.common.NameValuePair 自定义键值对接口
com.darly.common.NetUtils 网络工具类
com.darly.common.ParentAdapter 总适配器，其他单适配器斗继承此类，缩减代码
com.darly.common.ShareObject 保存对象到SharedPreferences中，进行缓存
com.darly.common.ToastApp Toast 实现全局工具类
com.darly.common.Tools 验证工具类
com.darly.common.Utils  工具类
        com.darly.common.retrofit 网络请求工具封装
com.darly.common.retrofit.FrameListener 业务请求对应接口
com.darly.common.retrofit.FramePresenter 基础业务逻辑类
com.darly.common.retrofit.FrameView 基础View层类
com.darly.common.retrofit.RxInterceptor 请求传递头文件参数合集
com.darly.common.retrofit.RxjavaRetrofitRequestUtil PostGet请求封装类
    </pre>
</div>
    <hr>
    <tags:footer/>
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="${resourceUrl}/basejs/bootstrap/ace/js/jquery.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="${resourceUrl}/basejs/bootstrap/ace/js/bootstrap.min.js"></script>
</body>
</html>